/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package models.services;

import java.security.*;

import play.data.Form;
import models.*;
import utils.*;
import views.html.student.password.password;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.*;

import controllers.forms.student.PasswordForm;

/**
 * パスワードに関する機能を提供する.
 * @author A13413
 */
public class PasswordService {
    /** パスワードに使用するシンボル. */
    private static final char[] SYMBOLS = new char[36];
    /** ランダム生成器. */
    private static final SecureRandom RANDOM = new SecureRandom();

    static {
        for (int idx = 0; idx < 10; ++idx) {
            SYMBOLS[idx] = (char) ('0' + idx);
        }
        for (int idx = 10; idx < 36; ++idx) {
            SYMBOLS[idx] = (char) ('a' + idx - 10);
        }
    }

    /**
     * パスワードを再発行する.
     * @param email e-mailアドレス
     * @return 処理結果（true:成功、false:失敗）
     */
    @Transactional(type = TxType.REQUIRED)
    public boolean republish(String email) {
        String password = generatePassword();
        EntryUser user = EntryUser.finder.where().eq("email", email).eq("delflag", false).findUnique();
        if (user == null) {
            return false;
        }
        user.password = password;
        user.save();
        AppLogUtil.debug("new password:" + password);
        // TODO パスワード案内メールを送信
        return true;
    }

    /**
     * パスワードを生成する.
     * @return パスワード
     */
    public String generatePassword() {
        char[] buf = new char[12];
        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = SYMBOLS[RANDOM.nextInt(SYMBOLS.length)];
        }
        return new String(buf);
    }

    /**
     * パスワードの確認を行う.
     * @param entryUserId ユーザID
     * @param oldPassword 旧パスワード
     * @return true:現在のパスワードが一致
     *         false:現在のパスワードが違う
     */
    public boolean passwordCheck(Long entryUserId, String oldPassword) {
        boolean flg = true;

        // 現在のパスワードをチェック
        EntryUser eu = EntryUser.finder.byId(entryUserId);
        if (!eu.password.equals(oldPassword)) {
            flg = false;
        }

        return flg;
    }

    /**
     * パスワードを再発行する.
     * @param entryUserId UserId
     * @param newPassword new Password
     * @return 処理結果（true:成功、false:失敗）
     */
    @Transactional(type = TxType.REQUIRED)
    public boolean updatePassword(Long entryUserId, String newPassword) {
        EntryUser user = EntryUser.finder.where().eq("id", entryUserId).eq("delflag", false).findUnique();
        if (user == null) {
            return false;
        }
        user.password = newPassword;
        user.save();
        AppLogUtil.debug("new password:" + newPassword);
        // TODO パスワード案内メールを送信
        return true;
    }
}
