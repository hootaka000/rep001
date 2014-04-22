/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package models.services;

import play.data.Form;
import utils.AppLogUtil;
import models.EntryUser;
import models.Inquiry;
import controllers.forms.QueryForm;

/**
 * お問い合わせ画面に関する機能を提供する.
 * @author B05138
 *
 */
public class QueryService {

    /**
     * お問い合わせ画面にて入力されたIDの検索を行う.
     * @param entryUserId ユーザID
     * @return boolean
     */
    public boolean existsEntryUser(Long entryUserId) {
        // TODO どちらでも可
        EntryUser user = EntryUser.finder.where()
                .eq("id", entryUserId)
                .findUnique();

        if (user == null) {
            System.out.println("not found id");
            return false;
        } else {
            System.out.println("found id:" + entryUserId.toString());
        }
        return true;
    }

    /**
     * 問い合わせテーブルに登録を行う.
     * @param queryForm form
     */
    public void inquirySave(Form<QueryForm> queryForm) {
        Inquiry inquiry = new Inquiry();

        // 値のセット
        inquiry.lastName = queryForm.get().lastName;
        inquiry.firstName = queryForm.get().firstName;
        inquiry.email = queryForm.get().email;
        inquiry.type = queryForm.get().iqType;
        inquiry.content = queryForm.get().content;

        if (queryForm.get().entryUser != null) {
            // 外部キー設定用のmodelをnewする
            EntryUser entryUser = new EntryUser();

            // 外部キーに該当するエントリーIDに値をセットし、そのままmodelをセット
            entryUser.id = queryForm.get().entryUser;
            inquiry.entryUser = entryUser;
        }
        // 登録の実行
        inquiry.save();
    }
}
