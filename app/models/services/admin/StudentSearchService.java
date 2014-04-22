package models.services.admin;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import models.ComplexGroup;
import models.EntryUser;
import models.Event;
import models.EventSchedule;
import models.Prefectures;
import models.School;
import models.SchoolDepartment;
import models.SchoolGroup;
import models.SchoolGroupCondition;
import models.SchoolSubject;
import play.data.Form;
import utils.AppLogUtil;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.SqlRow;

import controllers.forms.admin.SchoolSearch;
import controllers.forms.admin.SchoolSearchForm;
import controllers.forms.admin.StudentSearchForm;

/**
 * 学生検索サービス
 * @author B03401
 */
public class StudentSearchService {

    private StudentSearchService() {
    }

    private static StudentSearchService service = new StudentSearchService();

    public static StudentSearchService getInstance() {
        return service;
    }

    /**
     * グループリスト取得.
     * @return
     */
    public Map<String, String> gainComplexGroupList() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for (ComplexGroup c : ComplexGroup.finder.orderBy("id").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }

    /**
     * 大学グループリスト取得.
     * @return
     */
    public Map<String, String> gainSchoolGroupList() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for (SchoolGroup c : SchoolGroup.finder.orderBy("id").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }

    /**
     * 大学リスト取得.
     * @return
     */
    public Map<String, String> gainSchoolList() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for (School c : School.finder.orderBy("id").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }

    /**
     * 学部リスト取得.
     * @return
     */
    public Map<String, String> gainSchoolDepartmentList() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for (SchoolDepartment c : SchoolDepartment.finder.orderBy("id").findList()) {
            options.put(c.id.toString(), c.department);
        }
        return options;
    }

    /**
     * 学科リスト取得.
     * @return
     */
    public Map<String, String> gainSchoolSubjectList() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for (SchoolSubject c : SchoolSubject.finder.orderBy("id").findList()) {
            options.put(c.id.toString(), c.subject);
        }
        return options;
    }

    /**
     * 都道府県リスト取得.
     * @return
     */
    public Map<String, String> gainPrefecturesList() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for (Prefectures c : Prefectures.finder.orderBy("id").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }

    /**
     * イベントリスト取得.
     * @return
     */
    public Map<String, String> gainEventList() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for (Event c : Event.finder.orderBy("id").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }

    /**
     * イベント日程リスト取得.
     * @return
     */
    public Map<String, String> gainEventScheduleList() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        for (EventSchedule c : EventSchedule.finder.orderBy("id").findList()) {
            options.put(c.id.toString(), c.dateTime.toString());
        }
        return options;
    }


    /**
     * 学生検索結果のリストを作成.
     *
     * @param form 学生検索条件
     * @return 結果リスト
     */
    public  List<EntryUser> searchStudents(Form<StudentSearchForm> form) {

//        String sql = "select id from entry_user";
//
//        RawSql rawSql = RawSqlBuilder.parse(sql)
//                                    .columnMapping("id", "id")
//                                    .create();

        //List<EntryUser> datas = PageData.finder




        //検索結果を入れるリスト
        List<EntryUser> entryUserList = null;

        ExpressionList<EntryUser> resultList = EntryUser.finder.where();
        //入力した検索条件のみ追加
        //応募年度(採用年度)
        if (form.get().applicationYear != -1) resultList.eq("applicationYear", form.get().applicationYear);
        //氏名(姓)
        if (!"".equals(form.get().lastName)) resultList.ilike("lastName", "%" + form.get().lastName + "%");
        //氏名(名)
        if (!"".equals(form.get().firstName)) resultList.ilike("firstName", "%" + form.get().firstName + "%");
        //性別
        if (form.get().sex != -1) resultList.eq("sex", form.get().sex);
        //応募者ID
        if (!"".equals(form.get().entryUserIds)) {
            resultList.in("id", (Object[])form.get().entryUserIds.split(","));
        }
        //選考ステータス
        if (form.get().entryStatus != -1) resultList.eq("entryStatus", form.get().entryStatus);

        AppLogUtil.debug("----------------------------------------------");
        //AppLogUtil.debug(resultList.join(resultList.orderBy("id").getGeneratedSql(), "id").getGeneratedSql());
        AppLogUtil.debug("----------------------------------------------");

        entryUserList = resultList.orderBy("id").findList();


        //ページング方法
        //entryUserList = EntryUser.finder.where().eq("sex", sex).orderBy("id").findPagingList(10).getPage(0).getList();

        AppLogUtil.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        AppLogUtil.debug("sql = ");
        AppLogUtil.debug(resultList.orderBy("id").getGeneratedSql());
        AppLogUtil.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");


        return entryUserList;
    }

    /**
     * 大学検索結果のリストを作成.
     *
     * @param form 大学検索条件
     * @return 結果リスト
     */
    public  List<SchoolSearch> searchSchools(Form<SchoolSearchForm> form) {

        String ql = "select p.id, p.area, s.schoolid, s.school, sd.departmentid "
                  + " , sd.department, ss.subjectid, ss.subject "
                  + " from (select id, area from prefectures)p "
                  + " join (select id AS schoolid, prefecturesid, name AS school "
                  + "       from school where delflag=0)s on p.id=s.prefecturesid "
                  + " left outer join (select id AS departmentid, schoolid, department "
                  + "                  from school_department where delflag=0)sd on s.schoolid=sd.schoolid "
                  + " left outer join (select id AS subjectid, school_departmentid, subject "
                  + "                  from school_subject where delflag=0)ss on sd.departmentid=ss.school_departmentid";

        List<SqlRow> sqlRows = Ebean.createSqlQuery(ql).findList();

        List<SchoolSearch> ssList = new ArrayList<SchoolSearch>();


        for (int i = 0; i <sqlRows.size(); i++) {

            SchoolSearch ss = new SchoolSearch();
            SchoolGroupCondition sgc = new SchoolGroupCondition();

            School school = new School();
            SchoolDepartment schoolDepartment = new SchoolDepartment();
            SchoolSubject schoolSubject = new SchoolSubject();
            Prefectures prefectures = new Prefectures();

            prefectures.id = sqlRows.get(i).getLong("id");
            prefectures.area = sqlRows.get(i).getInteger("area");
            school.prefectures = prefectures;
            school.id = sqlRows.get(i).getLong("schoolid");
            school.name = sqlRows.get(i).getString("school");
            schoolDepartment.id = sqlRows.get(i).getLong("departmentid");
            schoolDepartment.department = sqlRows.get(i).getString("department");
            schoolSubject.id = sqlRows.get(i).getLong("subjectid");
            schoolSubject.subject = sqlRows.get(i).getString("subject");

            sgc.school = school;
            sgc.schoolDepartment = schoolDepartment;
            sgc.schoolSubject = schoolSubject;
            ss.schoolGroupCondition = sgc;

            ssList.add(ss);
        }
        return ssList;
    }

}
