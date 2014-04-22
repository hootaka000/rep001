package base;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.start;
import static play.test.Helpers.stop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import play.Logger;
import play.db.DB;
import play.test.FakeApplication;
import scala.Array;



/**
 * 採用管理サイトのアプリケーションのテスト用の基底クラス
 * @author masafumi
 */
public abstract class SaiyoTestBase {
    
    private static final String RELATIVE_DDL_PATH = "conf/evolutions/default/1.sql";
//    private static final String RELATIVE_RESET_DDL_PATH = "target/dbreset.sql";
    
    protected static FakeApplication app = null;
    
//    protected static String resetDdlPath = "";
    
    private static String[] stringDropDdls = null;
    
    private static String[] stringCreateDdls = null;
    
    
    @BeforeClass
    public static void startApp() throws IOException {

        Map<String, String> testConfig = new HashMap<String, String>();
        testConfig.put("evolutionplugin", "disabled");
        app = fakeApplication(testConfig);
        
        String ddl = FileUtils.readFileToString(app.getWrappedApplication().getFile(RELATIVE_DDL_PATH));
        ddl = ddl.split("# --- !Ups")[1];
        String[] ddls = ddl.split("# --- !Downs");
        
        String createDdl = ddls[0];
        stringCreateDdls = createDdl.trim().split(";");
        String dropDdl = ddls[1];
        stringDropDdls = dropDdl.trim().split(";");
//        StringBuilder buffer = new StringBuilder();
//        String resetDdl = buffer.append(dropDdl).append("\n\n").append(createDdl).toString();
//        File restDdlFile = app.getWrappedApplication().getFile(RELATIVE_RESET_DDL_PATH);
//        if (restDdlFile.exists()) restDdlFile.delete();
//        FileUtils.write(
//                restDdlFile,
//                resetDdl,
//                "UTF-8");
//        resetDdlPath = restDdlFile.getAbsolutePath();
        
        Logger.debug("** starting...");
        start(app);
        Logger.debug("** started app");
    }
    
    @Before
    public void createCleanDb() throws IOException, InterruptedException, SQLException {
        initDb();
    }
    
    public static void initDb() throws IOException, InterruptedException, SQLException {
        
        // データベースの初期化
        // 当然、mysql-clientもインストールしとく
        // また、テスト開始前に、そのモデルに対応する、ddl(1.sql)があること

        Logger.debug("DB RESET ******************************************");
        try (Connection con = DB.getConnection()) {
            Statement stmt = con.createStatement();
            for (String drop : stringDropDdls) {
                stmt.execute(drop);
            }
            for (String create : stringCreateDdls) {
                stmt.execute(create);
            }
        }
        Logger.debug("<<<<<<<< ##########################################");
        
        // lod
        SaiyoDataInitializer.load();
        
      
//        // 事前にマスターいれる必要があるなら、このタイミング
//        Logger.debug("** initData");
//        int result = Ebean.execute(Ebean.createCallableSql(
//                "INSERT INTO employee VALUES (1, '渋谷太郎', CURRENT_TIMESTAMP)"
//                ));
//        Logger.info(String.valueOf(result));
        
    }
    
    public static void restartApp() {
        Logger.debug("** restartApp");
        start(app);
    }
    
    @AfterClass
    public static void stopApp() {
        Logger.debug("** stopApp");
        stop(app);
    }

}
