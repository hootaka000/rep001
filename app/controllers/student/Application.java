/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.student;

import static play.data.Form.*;
import play.data.*;
import play.mvc.Http.Cookie;
import play.mvc.*;
import base.*;
import controllers.*;
import controllers.forms.student.*;

/**
 * 学生サイトのApplicationコントローラ.
 * @author A13413
 */
public class Application extends SaiyoController {
    /** Cookieに保存するログインEmailアドレスのキー名. */
    private static final String COOKIE_KEY_LOGIN_EMAIL = "login-email";
    /** セッションに保存するエントリユーザIDのキー名. */
    public static final String SESSION_ENTRY_USER_ID = "entry_user_id";

    /**
     * 学生トップページを表示する.
     * @return 処理結果
     */
    @SaiyoAcl(roles = SaiyoRoles.NEW_GRADUATE)
    public static Result index() {
        LoginForm loginForm = new LoginForm();
        Cookie cookie = request().cookie(COOKIE_KEY_LOGIN_EMAIL);
        if (cookie != null) {
            loginForm.email = cookie.value();
            loginForm.saveEmail = (loginForm.email != null);
        }
        return ok(views.html.student.index.render(form(LoginForm.class).fill(loginForm)));
    }

    /**
     * ログイン処理を行う.
     * @return 処理結果
     */
    @SaiyoAcl(roles = SaiyoRoles.NEW_GRADUATE)
    public static Result login() {
        Form<LoginForm> form = form(LoginForm.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(views.html.student.index.render(form));
        }
        LoginForm loginForm = form.get();
        session(SESSION_ENTRY_USER_ID, String.valueOf(loginForm.id));
        if (loginForm.saveEmail) {
            response().setCookie(COOKIE_KEY_LOGIN_EMAIL, loginForm.email);
        } else {
            response().discardCookie(COOKIE_KEY_LOGIN_EMAIL);
        }
        return redirect(routes.MyPage.index());
    }

    /**
     * ログアウト処理を行う.
     * @return 処理結果
     */
    @SaiyoAcl(roles = SaiyoRoles.NEW_GRADUATE)
    public static Result logout() {
        session().remove(SESSION_ENTRY_USER_ID);
        return redirect(routes.Application.index());
    }

    public static final String COMPLETED_MESSAGE = "completed_message";
    public static final String NEXT_TEXT = "next_text";
    public static final String NEXT_URL = "next_url";

    /**
     * 完了画面を表示する.
     * @return 処理結果
     */
    @SaiyoAcl(roles = SaiyoRoles.NEW_GRADUATE)
    public static Result completed() {
        String message = session(COMPLETED_MESSAGE);
        String nextText = session(NEXT_TEXT);
        String nextUrl = session(NEXT_URL);
        session().remove(COMPLETED_MESSAGE);
        session().remove(NEXT_TEXT);
        session().remove(NEXT_URL);
        if (message == null) {
            return redirect(routes.MyPage.index());
        }
        return ok(views.html.student.completed.render(new CompletedForm(message, nextText, nextUrl)));
    }

    /**
     * 利用規約画面を表示する.
     * @return 処理結果
     */
    @SaiyoAcl(roles = SaiyoRoles.NEW_GRADUATE)
    public static Result agree() {
        return ok();
    }
}
