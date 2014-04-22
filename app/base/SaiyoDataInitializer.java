package base;

import java.util.List;
import java.util.Map;

import models.AdminUser;
import models.Company;
import models.Employee;
import models.EmployeeCompany;
import models.Prefectures;
import play.Play;
import play.libs.Yaml;
import utils.AppLogUtil;

import com.avaje.ebean.Ebean;


/**
 * Data initializer 
 * (開発支援用のコード！）
 * @author masafumi
 *
 */
class SaiyoDataInitializer {

    private SaiyoDataInitializer() {}
    
    /**
     * データ初期化する
     */
    @SuppressWarnings("unchecked")
    static void load() {

        // 本番の時は無視
        if (Play.isProd()) return;
        
        // 大前提となる、都道府県マスタがなければ、データ初期化
        // （本来ならば、対象の全テーブルみるところだが、開発支援コードなので・・・）
        // （エラー発生時は、evolutions前なので、あきらめる）
        try {
            int cnt = Prefectures.finder.findRowCount();
            if (cnt > 0) return;            
        } catch(Exception e) {
            // 多分evolutions実施前なので・・
            AppLogUtil.warn("!マスタにアクセスできない!", e);
            return;
        }
       
        // データ投入
        Map<String, List<Object>> all =
                (Map<String, List<Object>>) Yaml.load("init-data4dev.yml");

        Ebean.save(all.get("prefectures"));
        
        Ebean.save(all.get("employee"));
        
        Ebean.save(all.get("company"));
        
        Ebean.save(all.get("venue"));
        
        Ebean.save(all.get("systemMaster"));
        
        // 連関エンティティのマスタは、ymlだと表現が苦しいので、プログラマブルに設定
        Company cyberagent =
                Company.finder.where().eq("name", "株式会社サイバーエージェント").findUnique();
        AppLogUtil.debug("cy:" + cyberagent.name);
        List<Employee> employees = Employee.finder.where().findList();
        AppLogUtil.debug("!!!employees.size:" + employees.size());
        for (Employee e : employees) {
            EmployeeCompany employeeCompany = new EmployeeCompany();
            employeeCompany.employee = e;
            employeeCompany.company = cyberagent;
            employeeCompany.save();
            
            // テストやりやすいので管理権限付与
            if (e.employeeNumber.equals("A12152")) {
                AdminUser adminUser = new AdminUser();
                adminUser.employee = e;
                adminUser.role = SaiyoRoles.HR_ADMIN.getId();
                adminUser.save();
            }
        }
        
    }
}
