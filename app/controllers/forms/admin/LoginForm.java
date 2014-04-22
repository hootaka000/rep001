/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.forms.admin;

import jp.co.cyberagent.util.ad.ActiveDirectory;
import play.data.validation.Constraints.Required;
import utils.AppLogUtil;

/**
 * ログイン処理のFormクラス.
 */
public class LoginForm {

    /** 社員番号 */
    @Required
    public String employeeNumber;
    
    /** パスワード */
    @Required
    public String password;


    public String validate() {
        ActiveDirectory ad = ActiveDirectory.getInstance();
        boolean ok = ad.isAuthentication(this.employeeNumber, this.password);
        AppLogUtil.debug("login ok=>" + ok);
        if (!ok) {
            return play.i18n.Messages.get("error.admin.login.invalid");
        }
        return null;
    }
    
}
