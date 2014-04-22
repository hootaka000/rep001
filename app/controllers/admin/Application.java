package controllers.admin;

import static play.data.Form.form;

import org.apache.commons.lang3.StringUtils;

import play.data.Form;
import play.mvc.Result;
import play.mvc.Security.Authenticated;
import utils.AppLogUtil;
import base.SaiyoAcl;
import base.SaiyoRoles;
import controllers.SaiyoController;
import controllers.forms.admin.LoginForm;

/**
 * 管理側　認証関連コントローラ
 * @author masafumi
 */
public class Application extends SaiyoController {

    /**
     * ログイン画面表示
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.ACCESSIBLE})
    public static Result index() {
        String empNo = session().get(AdminSecured.SESSION_KEY_EMPNO);
        AppLogUtil.debug("empNo:" + empNo);
        
        // ログインしてれば、ダッシュボードトップへ
        if (!StringUtils.isBlank(empNo)) {
            return redirect(controllers.admin.routes.Administrator.index().url());
        }
        return ok(views.html.admin.index.render(form(LoginForm.class)));
    }
    
    /**
     * ログイン
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.ACCESSIBLE})
    public static Result login() {
        Form<LoginForm> form = form(LoginForm.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(views.html.admin.index.render(form));
        }
        // 認証をクリアしたら、社員番号をセッションにセット（ログイン済み状態に）
        LoginForm loginForm = form.get();
        session().put(AdminSecured.SESSION_KEY_EMPNO, loginForm.employeeNumber);
        
        // 元々リクエストしていたページがあれば、そこへリダイレクト
        // でなければ、ダッシュボードトップへ
        String returnUrl = ctx().session().get(AdminSecured.SESSION_KEY_RETURN_URL);
        if (StringUtils.isBlank(returnUrl)){
            returnUrl = controllers.admin.routes.Administrator.index().url();            
        }
        AppLogUtil.debug("returnUrl:" + returnUrl);
        return redirect(returnUrl);
    }
    
    /**
     * ログアウト
     * @return
     */
    @Authenticated(AdminSecured.class)
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result logout() {
        session().clear();
        return redirect(controllers.admin.routes.Application.index());
    }
    
}
