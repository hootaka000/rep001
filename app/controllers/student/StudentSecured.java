package controllers.student;

import play.mvc.Http.Context;
import play.mvc.*;
import utils.*;

/**
 * 学生の認証判定クラス.
 * @author masafumi
 */
public class StudentSecured extends Security.Authenticator {

    @Override
    public String getUsername(Context context) {
        AppLogUtil.debug("@@@@@StudentSecured#getUsername");
        return context.session().get("entry_user_id");
    }

    @Override
    public Result onUnauthorized(Context context) {
        AppLogUtil.debug("@@@@@StudentSecured#getUsername");
        // FIXME 適切なリダイレクト先へ
        return redirect(controllers.student.routes.Application.index());
    }

}
