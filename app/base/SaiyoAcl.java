package base;


import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * 権限管理用のアノテーション
 * @author masafumi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SaiyoAcl {
    // デフォルトは、人部特権ユーザのみに限定、という一番厳しい設定
    SaiyoRoles[] roles() default SaiyoRoles.HR_ADMIN;
}