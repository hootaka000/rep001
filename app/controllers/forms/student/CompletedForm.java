/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.forms.student;

/**
 * 処理完了画面のFormクラス.
 * @author A13413
 */
public class CompletedForm {
    /** メッセージ. */
    public String message;
    /** 遷移先のリンクのテキスト. */
    public String nextText;
    /** 遷移先のURL. */
    public String nextUrl;

    /**
     * コンストラクタ.
     * @param message メッセージ
     * @param nextUrl 遷移先のURL
     */
    public CompletedForm(String message, String nextText, String nextUrl) {
        this.message = message;
        this.nextText = nextText;
        this.nextUrl = nextUrl;
    }
}
