/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.forms.student;

import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;

/**
 * パスワード再発行のForm.
 * @author A13413
 */
public class RepublishForm {
    /**
     * E-Mailアドレス.
     */
    @Required
    @MinLength(5)
    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
