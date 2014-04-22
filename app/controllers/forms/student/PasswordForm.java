/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.forms.student;

import base.PasswordValidator;
import models.services.PasswordService;
import play.data.validation.Constraints;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;


/**
 * @author B05138
 */
public class PasswordForm {

    /** EntryUser. */
    public Long entryUser;

    /** 旧パスワード. */
    @Required
    public String oldPassword;

    /** 新パスワード. */
    @Required
    @MinLength(5)
    @MaxLength(20)
    @Constraints.ValidateWith(value = PasswordValidator.class, message = PasswordValidator.MESSAGE)
    public String newPassword;

    /** 新パスワード確認. */
    @Required
    @MinLength(5)
    @MaxLength(20)
    @Constraints.ValidateWith(value = PasswordValidator.class, message = PasswordValidator.MESSAGE)
    public String rePassword;

    /**
     * .
     * @return String
     */
    public String validate() {

        // 現在のパスワードのチェック
        PasswordService service = new PasswordService();
        if (!service.passwordCheck(1L, oldPassword)) {
            // 現在のパスワードが違います
            return "パスワードが違います。";
        }

        // 新規パスワードのチェック
        // 再入力とのチェック
        if (!newPassword.equals(rePassword)) {
            return "パスワードが一致しません。";
            //return badRequest(password.render(passForm, message));
        }

        // 現在のパスワードと新規パスワードのチェックはしなくて良いか？
        // 再入力とのチェック
        if (newPassword.equals(oldPassword)) {
            return "同じパスワードになっています。";
            //return badRequest(password.render(passForm, message));
        }

        return null;
    }
}
