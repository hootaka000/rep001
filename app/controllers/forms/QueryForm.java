/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.forms;

import javax.annotation.CheckForNull;

import org.springframework.format.annotation.NumberFormat;

import play.data.Form;
import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import models.Inquiry;
import models.services.QueryService;

/**
 * 問い合わせ処理のFormクラス.
 * @author B05138
 *
 */
public class QueryForm {

    /**
     * 問い合わせModel.
     */
    public Form<Inquiry> inquiry;

    /** 姓 . */
    @Required
    @MaxLength(9)
    public String lastName;

    /** 名 . */
    @Required
    @MaxLength(9)
    public String firstName;

    /** Email.  */
    @Required
    @Email
    @MaxLength(255)
    public String email;

    /** IDお持ちの方.  */
    @NumberFormat
    public Long entryUser;

    /** 問い合わせタイプ.  */
    @Required
    @CheckForNull
    public int iqType;

    /** 問い合わせ内容 . */
    @Required
    @MaxLength(1000)
    public String content;

    /** . */
    public String idMessage;

    /**
     * .
     * @return String
     */
    public String validate() {
        idMessage = null;
        if (entryUser != null) {
            QueryService service = new QueryService();
            if (!service.existsEntryUser(entryUser)) {
                utils.AppLogUtil.debug("入力されたIDがありません。");
                // 入力されたIDがない場合はここに入る。
                this.idMessage = "入力されたIDがありません。";
            }
        }
        return this.idMessage;
    }
}
