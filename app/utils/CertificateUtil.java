package utils;

import java.util.Map;

import play.Play;
import play.mvc.Http.Request;
import base.SaiyoException;

/**
 * クライアント証明書関連のユーティリティ
 * @author masafumi
 *
 */
public class CertificateUtil {

    private CertificateUtil() {}
    
    /**
     * ※テスト時に、任意の社員番号を渡したい場合、例えば、以下を指定する
     * -Dsaiyo.test.empno=A00000
     * @param request HttpRequest
     * @return 社員番号
     */
    public static String extractEmpno(Request request) {
        
        // 本番モード以外では、システムプロパティから動的に設定できるようにする
        if (!Play.isProd()) {
            String testEmpNo = System.getProperty("saiyo.test.empno");
            AppLogUtil.debug("testEmpNo=>");
            AppLogUtil.debug(testEmpNo);
            if (testEmpNo == null) throw new SaiyoException("本番ではなく、管理側モードの場合、-Dsaiyo.test.empno を指定してください");
            return testEmpNo;
        }
        
        // TODO 管理サイト(コンフィグからとる）　証明書チェック
        AppLogUtil.debug(request.getHeader("X-hogehoge-EmpNo"));
        Map<String, String[]> headers = request.headers();
        for (String key : headers.keySet()) {
            AppLogUtil.debug(key);
        }
        
        return null;
        
    }
    
}
