package base;

import utils.AppLogUtil;

/**
 * 採用管理システムの動作モード
 * 起動時に、-Dsaiyo.app.mode=admin を指定すると人事向けアプリケーションが振る舞う
 * @author masafumi
 */
public class SaiyoAppMode {
    
    // 極力、モードの切り分けは　人事／学生　の二つだけで抑える
    // モードが3個以上増えていくようなら、アプリケーションの分割を考える
    
    private static boolean admin = false;
    
    static void init() {
        String mode = System.getProperty("saiyo.app.mode");
        AppLogUtil.debug("mode *******>");
        AppLogUtil.debug(mode);
        AppLogUtil.debug("<******* mode");
        if ("admin".equals(mode)) admin = true;
    }

    /**
     * ※基本使用禁止
     * @return
     */
    @Deprecated
    public static boolean isAdmin() {
        return admin;
    }
}
