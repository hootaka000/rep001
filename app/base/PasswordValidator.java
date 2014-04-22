/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */

package base;

import play.data.validation.Constraints;
import play.libs.F;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * パスワードバリデータ.
 * 半角アルファベット、半角数字、特殊文字のみである事。
 * 上記のうち2種類以上が使われている事
 * 特殊文字(! # $ & ` ( ) + : = ? [ ] ^ { } * / ~ _ ; @ - .)
 * @author a12609
 */
public class PasswordValidator extends Constraints.Validator<String> {
    /**
     * エラーメッセージ.
     */
    public static final String MESSAGE = "error.password.invalid";
    public static final String SYMBOL_PATTERN = "!#\\$&`\\(\\)\\+:=\\?\\[\\]\\^\\{\\}\\*/~_;@\\-\\.";

    @Override
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        // 半角アルファベット、半角数字、特殊文字
        Pattern p = Pattern.compile("^[a-zA-Z0-9" + SYMBOL_PATTERN + "]*$");
        Matcher m = p.matcher(s);

        // パターン以外の文字が混ざっているとfalse
        if (!m.matches()) {
            return false;
        }

        // 2種類以上の文字列が含まれているか
        Pattern number = Pattern.compile(".*[0-9].*");
        Pattern alphabet = Pattern.compile(".*[a-zA-Z].*");
        Pattern symbol = Pattern.compile(".*[" + SYMBOL_PATTERN + "].*");

        int trueCount = 0;
        m = number.matcher(s);
        if (m.matches()) {
            trueCount++;
        }
        m = alphabet.matcher(s);
        if (m.matches()) {
            trueCount++;
        }
        m = symbol.matcher(s);
        if (m.matches()) {
            trueCount++;
        }

        // 2種類以上の文字が含まれていないとfalse
        if (trueCount < 2) {
            return false;
        }

        return true;
    }

    @Override
    public F.Tuple<String, Object[]> getErrorMessageKey() {
        return F.Tuple(MESSAGE, new Object[] { });
    }
}
