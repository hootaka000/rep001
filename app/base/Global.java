package base;

import static play.mvc.Results.badRequest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.mail.Session;

import com.sun.mail.imap.AppendUID;

import models.AdminUser;
import models.Employee;
import play.Application;
import play.GlobalSettings;
import play.Play;
import play.api.mvc.EssentialFilter;
import play.filters.csrf.CSRFFilter;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Http.Request;
import play.mvc.Http.RequestHeader;
import play.mvc.SimpleResult;
import utils.AppLogUtil;
import utils.AuditLogUtil;
import utils.CertificateUtil;


/**
 * 共通基盤処理
 * @author masafumi
 */
public class Global extends GlobalSettings {
    
	/* (non-Javadoc)
	 * @see play.GlobalSettings#filters()
	 * CSRF対策
	 */
	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
    public <T extends EssentialFilter> Class<T>[] filters() {
	    AppLogUtil.debug("@@filters");
	    Class[] filters = {CSRFFilter.class};
        return filters;
    }

    /* (non-Javadoc)
     * @see play.GlobalSettings#onBadRequest(play.mvc.Http.RequestHeader, java.lang.String)
     * 必要ならば、エラーページに飛ばした方がよいかもしれない
     */
    @Override
	public Promise<SimpleResult> onBadRequest(RequestHeader handler, String message) {
		AppLogUtil.debug("@@onBadRequest");
		return super.onBadRequest(handler, message);
	}

	@Override
	public Promise<SimpleResult> onError(RequestHeader handler, Throwable th) {
	    AppLogUtil.debug("@@onError");
	    AppLogUtil.error("@@system error", th);
		Promise<SimpleResult> promise = Promise.<SimpleResult>pure(
		        // TODO 適切なエラーページに飛ばしてもらう（予期せぬ例外）
				badRequest("{\"status\": \"NG\"}").as("application/json")
				);
		return promise;
	}

	@Override
	public Promise<SimpleResult> onHandlerNotFound(RequestHeader header) {
	    AppLogUtil.debug("@@onHandlerNotFound");
	    // TODO 適切なエラーページにとばしてもらう（ページ存在しない）
		return super.onHandlerNotFound(header);
	}

	@Override
	public Action<?> onRequest(Request request, Method method) {
	    AppLogUtil.debug("@@onRequest");
	    
	    // TODO 監査ログはく（項目を決定する）
	    HashMap<String, String> message = new HashMap<String ,String>();
	    message.put("userId", "hogehoge");
	    message.put("methodName", method.getName());
	    AuditLogUtil.write(message);
		
		
		// ロールのチェック
		Annotation[] annotations = method.getDeclaredAnnotations();
		if (!this.hasRole(annotations, request)) {
		    Action<?> errorAction = new Action.Simple() {
                @Override
                public Promise<SimpleResult> call(Context context) throws Throwable {
                    Promise<SimpleResult> promise = Promise.<SimpleResult>pure(
                            // TODO 適切なエラーページにとばしてもらう（ページ存在しない）
                            badRequest("{\"status\": \"ROLE_NG\"}").as("application/json")
                           );
                    return promise;
                }
		    };
		    return errorAction;
		}
		return super.onRequest(request, method);
	}

	@Override
	public void onStart(Application app) {

	    AppLogUtil.debug("@@onStart");
	    SaiyoAppMode.init();
	    SaiyoDataInitializer.load();

		super.onStart(app);
	}

	@Override
	public void onStop(Application app) {
	    AppLogUtil.debug("@@onStop");
		super.onStop(app);
	}
	
	
	// ------------------------------------------------------- Private Methods
	
	
	@SuppressWarnings("deprecation")
	private boolean hasRole(Annotation[] annotations, Request request) {
	    List<Integer> hasRoles = new ArrayList<Integer>();
	    if (!SaiyoAppMode.isAdmin()) {
	        // 学生モードの場合、管理側のページリクエストされたら、エラーとする
	        String path = request.path();
	        if (path.startsWith("/admin")) {
	            throw new SaiyoException("学生側から管理用ページがリクエストされた");
	        }
	        // ロールは、学生側なので、「学生」ロール
	        hasRoles.add(SaiyoRoles.NEW_GRADUATE.getId());	        
	    } else {
	        String empNo = CertificateUtil.extractEmpno(request);
	        Employee emp = Employee.finder.where().eq("employeeNumber", empNo).findUnique();
	        if (emp != null && emp.adminUser != null) {
	            // 管理ロールの設定値をとる
	            hasRoles.add(emp.adminUser.role);
	        }
	        if (emp != null && emp.interviewer != null) {
	            // 面接官テーブルに存在するので、面接官ロール
	            hasRoles.add(SaiyoRoles.INTERVIER.getId());
	        }
	        
	    }
        for (Annotation annotation : annotations) {
            AppLogUtil.debug("annotation(acl):" + annotation);
            if (annotation instanceof SaiyoAcl) {
                SaiyoAcl saiyoAcl = (SaiyoAcl) annotation;
                for (SaiyoRoles role : saiyoAcl.roles()) {
                   if (role.getId() == SaiyoRoles.ACCESSIBLE.getId()) {
                       return true;
                   }
                   if (hasRoles.contains(role.getId())) {
                       return true;
                   }
                }               
            }
        }
	    return false;
	}
	
	 
}
