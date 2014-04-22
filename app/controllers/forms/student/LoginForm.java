/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.forms.student;

import models.*;
import models.services.*;
import play.data.validation.Constraints.Required;

/**
 * ログイン処理のFormクラス.
 * @author A13413
 */
public class LoginForm {
    public Long id;
    /** E-Mail. */
    @Required
    public String email;
    /** パスワード. */
    @Required
    public String password;
    /** E-MailをCookieに保存するかのフラグ. */
    public boolean saveEmail;

    public String validate() {
        EntryUser entryUser = new LoginService().findStudent(email, password);
        if (entryUser == null) {
            return "メールアドレスまたはパスワードが間違っています。";
        }
        id = entryUser.id;
        return null;
    }
}
