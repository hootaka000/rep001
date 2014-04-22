/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package utils;

import play.Logger;

/**
 * アプリケーションのログを出力する（ラッパ）
 * @author masafumi
 */
public class AppLogUtil {
    
    private AppLogUtil() {}
       
    /**
     * デバッグログを出力する
     * @param message
     */
    public static void debug(String message) {
        Logger.debug(message);
    }
       
    public static void warn(String message, Throwable th) {
        Logger.warn(message, th);
    }
    
    public static void warn(String message) {
        Logger.warn(message);
    }
    
    public static void error(String message, Throwable th) {
        Logger.warn(message, th);
    }
    
    public static void error(String message) {
        Logger.warn(message);
    }
    
}
