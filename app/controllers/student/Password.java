/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.student;

import static play.data.Form.*;
import models.services.*;
import play.data.*;
import play.i18n.*;
import play.mvc.*;
import play.mvc.Security.Authenticated;
import views.html.student.password.*;
import base.*;
import controllers.*;
import controllers.forms.student.*;

/**
 * パスワード関連コントローラー.
 * @author A13413
 */
public final class Password extends SaiyoController {
    /**
     * パスワード再発行画面を表示する.
     * @return 処理結果
     */
    @SaiyoAcl(roles = SaiyoRoles.ACCESSIBLE)
    public static Result viewRepublish() {
        return ok(republish.render(form(RepublishForm.class)));
    }

    /**
     * パスワード再発行を行う.
     * @return 処理結果
     */
    @SaiyoAcl(roles = SaiyoRoles.ACCESSIBLE)
    public static Result republish() {
        Form<RepublishForm> republishForm = form(RepublishForm.class).bindFromRequest();
        if (republishForm.hasErrors()) {
            return badRequest(republish.render(republishForm));
        }
        PasswordService service = new PasswordService();
        if (service.republish(republishForm.get().email)) {
            session(Application.COMPLETED_MESSAGE, Messages.get("message.completed.republish.message"));
            session(Application.NEXT_TEXT, Messages.get("message.completed.republish.next.text"));
            session(Application.NEXT_URL, routes.Application.index().url());
            return redirect(routes.Application.completed());
        } else {
            // TODO 指定のアドレスが登録されていないエラー
            return badRequest(republish.render(republishForm));
        }
    }

    /**
     * パスワード変更画面を表示する.
     * @return 処理結果
     */
    @SaiyoAcl(roles = { SaiyoRoles.NEW_GRADUATE })
    @Authenticated(StudentSecured.class)
    public static Result index() {
        Form<PasswordForm> passForm = form(PasswordForm.class);
        return ok(password.render(passForm));
    }

    /**
     * パスワード変更を行う.
     * @return 処理結果
     */
    @SaiyoAcl(roles = { SaiyoRoles.NEW_GRADUATE })
    @Authenticated(StudentSecured.class)
    public static Result update() {
        Form<PasswordForm> passForm = form(PasswordForm.class).bindFromRequest();
        if (passForm.hasErrors()) {
            return badRequest(password.render(passForm));
        }

        // DB更新
        PasswordService service = new PasswordService();
        if (service.updatePassword(1L, passForm.get().newPassword)) {
            // 完了画面に遷移
            // TODO メッセージ：パスワードを変更しました。
            session(Application.COMPLETED_MESSAGE, "パスワードを変更");
            return redirect(routes.Application.completed());
        } else {
            // 元画面に戻る
            return badRequest(password.render(passForm));
        }
    }
}
