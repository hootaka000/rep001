/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package base;

/**
 * システムエラー次の汎用例外.
 * @author A13413
 */
public class SaiyoException extends RuntimeException {

    /** シリアルバージョンUID. */
    private static final long serialVersionUID = 6528640506335493642L;

    /**
     * コンストラクタ.
     * @param message
     * @param cause
     */
    public SaiyoException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * コンストラクタ.
     * @param message
     * @param message
     */
    public SaiyoException(String message) {
        super(message);
    }

    /**
     * コンストラクタ.
     * @param message
     * @param cause
     */
    public SaiyoException(Throwable cause) {
        super(cause);
    }

}
