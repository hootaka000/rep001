/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditLogUtil {
    
   private AuditLogUtil() {}
   
   private static Logger auditTrail = LoggerFactory.getLogger(AuditLogUtil.class);
   
   /**
    * 監査ログ出力用のログクラスです
    * TODO 項目と、出力タイミングと、出力先と、暗号化してストアするのか・・
    * @param message メッセージ
    */
   public static void write(Map<String, String> message) {
       StringBuilder record = new StringBuilder();
       record.append("userId=").append(message.get("userId")
               ).append(",methodName=").append(message.get("methodName"));
       auditTrail.info(record.toString());
   }
}
