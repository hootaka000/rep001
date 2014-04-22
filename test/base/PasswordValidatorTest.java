/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */

package base;

import org.junit.Test;
import play.data.Form;
import play.data.validation.Constraints;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static play.data.Form.form;

/**
 * @author a12609
 */

public class PasswordValidatorTest extends SaiyoTestBase {
    /**
     * テスト用Formクラス.
     */
    public static class TestForm {
        /**
         * パスワード.
         */
        @Constraints.ValidateWith(value = PasswordValidator.class, message = PasswordValidator.MESSAGE)
        public String password;
    }

    /**
     * isValidメソッドテスト.
     */
    @Test
    public void validTest() {
        PasswordValidator validate = new PasswordValidator();
        String password;

        // 異常パターン =========
        // null
        password = null;
        assertFalse(validate.isValid(password));

        // 全角かなを含む
        password = "abcdテスト123@";
        assertFalse(validate.isValid(password));
        assertEquals("error.password.invalid", validate.getErrorMessageKey()._1);

        // 全角英字を含む
        password = "abcｄ123@";
        assertFalse(validate.isValid(password));
        assertEquals("error.password.invalid", validate.getErrorMessageKey()._1);

        // 全角数字を含む
        password = "abcd１23@";
        assertFalse(validate.isValid(password));
        assertEquals("error.password.invalid", validate.getErrorMessageKey()._1);

        // 規定の全角記号を含む
        password = "abcd123＊";
        assertFalse(validate.isValid(password));
        assertEquals("error.password.invalid", validate.getErrorMessageKey()._1);

        // 規定以外の記号を含む
        password = "abcd123>";
        assertFalse(validate.isValid(password));
        assertEquals("error.password.invalid", validate.getErrorMessageKey()._1);

        // 規定以外の記号を含む(空白)
        password = "abcd 123";
        assertFalse(validate.isValid(password));
        assertEquals("error.password.invalid", validate.getErrorMessageKey()._1);

        // 数字のみ
        password = "12345";
        assertFalse(validate.isValid(password));
        assertEquals("error.password.invalid", validate.getErrorMessageKey()._1);

        // 英字のみ
        password = "abcd";
        assertFalse(validate.isValid(password));
        assertEquals("error.password.invalid", validate.getErrorMessageKey()._1);

        // 記号のみ
        password = "!#$&`()+:=?[]";
        assertFalse(validate.isValid(password));
        assertEquals("error.password.invalid", validate.getErrorMessageKey()._1);

        // 正常パターン =========
        // 数字 + 英字
        password = "123abc";
        assertTrue(validate.isValid(password));

        // 数字 + 記号
        password = "1!";
        assertTrue(validate.isValid(password));

        // 英字 + 記号
        password = "a@";
        assertTrue(validate.isValid(password));

        // 数字 + 英字 + 記号
        password = "h}z*y1/a~r_h;s@w-r.a";
        assertTrue(validate.isValid(password));

        // 数字 + 英字 + 記号
        password = "0!2#3$4&m5`";
        assertTrue(validate.isValid(password));

        // 数字 + 英字 + 記号
        password = "6(7)8+a:b=c?d[e]f^g{";
        assertTrue(validate.isValid(password));
    }

    /**
     * FormValidateテスト.
     */
    @Test
    public void formItemTest() {
        Map<String, String> data = new HashMap<>();
        data.put("password", "abcdテスト123@");
        Form<TestForm> testForm = form(TestForm.class).bind(data);

        assertTrue(testForm.hasErrors());
        assertEquals(1, testForm.errors().get("password").size());
        assertEquals(PasswordValidator.MESSAGE
                , testForm.errors().get("password").get(0).message());

        data.put("password", "2a1d23@");
        testForm = form(TestForm.class).bind(data);
        assertFalse(testForm.hasErrors());
    }
}
