package controllers.admin;

import play.mvc.Http.Context;
import play.mvc.*;
import utils.*;

/**
 * 学生の認証判定クラス.
 * @author masafumi
 */
public class AdminSecured extends Security.Authenticator {
    
    public static final String SESSION_KEY_EMPNO = "empno";
    public static final String SESSION_KEY_RETURN_URL = "returnUrl";

    @Override
    public String getUsername(Context context) {
        AppLogUtil.debug("@@@@@StudentSecured#getUsername");
        // FIXME 適切なID情報から判断
        // ※ adとの認証は、共通lib(ca-infosys-util)を使う
        // すでに、共通libとしてgithubに登録済み
        // 使い方は、GitHubのca-infosys-util
        return context.session().get(SESSION_KEY_EMPNO);
    }

    @Override
    public Result onUnauthorized(Context context) {
        AppLogUtil.debug("@@@@@StudentSecured#getUsername");
        // リクエストしたurlを保持しておく
        String returnUrl = context.request().uri();
        if (returnUrl == null) {
            returnUrl = "/";
        }
        context.session().put(SESSION_KEY_RETURN_URL, returnUrl);
        return redirect(controllers.admin.routes.Application.index());
    }

}
