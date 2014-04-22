package models.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.DashboardReport;
import models.Employee;
import models.EntryUserEventSchedule;
import models.EventGroup;
import models.EventScheduleEmployee;
import models.SystemMaster;

import org.joda.time.DateTime;

import play.db.DB;
import utils.AppLogUtil;
import base.SaiyoException;

import com.avaje.ebean.annotation.Transactional;

import controllers.enums.EntryStatus;
import controllers.enums.ReportType;
import controllers.enums.SystemMasterKey;

/**
 * Dashボード関連のサービス
 * @author masafumi
 */
public class DashBoardService {
    
    // ！かならず、ステートレス、に実装すること！
    // ！インスタンス変数を定義しないこと！
    // ！何故か・・分からないが、@Transactionalのメソッドが長くなると、エラーになる！
    // ！jdkのバグっぽいのだが、ひとまずメソッドをprivateにして外出しするとうまくいく！

    private DashBoardService() {}
    
    private static DashBoardService instance = new DashBoardService();
    
    /**
     * インスタンスの取得をする
     * @return このサービスインスタンス
     */
    public static DashBoardService getInstance() {
        return instance;
    }
    
    /**
     * アクティビティ部分取得
     * @return アクティビティ部分
     */
    @Transactional(readOnly = true)
    public Map<String, Object> getActivity() {
        
        HashMap<String, Object> result = new HashMap<>();
        
        // 内定していて、２週間以上の連絡のない人がいるか？
        result.put("noContactOver2week", this.noContactOver2week());
        // 回答してないお問い合わせの件数
        result.put("notDoneInquiryCount", this.notDoneInquiryCount());
        // 翌日の面接で埋まってない枠があるか
        result.put("vacantInterviewNextDay", this.vacantInterviewNextDay());
        
        return result;
    }
    
    /**
     * スケジュール部分取得
     * @return スケジュール部分
     */
    @Transactional(readOnly = true)
    public Map<String, Object> getSchedule() {
        return this.helpGetSchedule();
    }
    
    
    /**
     * アクティビティ部分取得
     * @return アクティビティ部分
     */
    @Transactional(readOnly = true)
    public Map<String, Object> getLap(String empNo, int monthTerm) {
        return this.helpGetLap(empNo, monthTerm);
    }
    
    /**
     * イベント部分取得
     * @return イベント部分
     */
    @Transactional(readOnly = true)
    public Map<String, Object> getEvent(long jobTypeId, long eventGroupId) {
        return this.helpGetEvent(jobTypeId, eventGroupId);
    }
    
    
    
    // ------------------------------------------------------------------------- Private
    
    // イベント部分取得
    private HashMap<String, Object> helpGetEvent(long jobTypeId, long eventGroupId) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        SimpleDateFormat sdf4param = new SimpleDateFormat("yyyyMMdd");
        DecimalFormat df = new DecimalFormat("0");
        
        // 今日日付取得
        DateTime today = DateTime.now();
        
        // イベントグループのリスト取得
        result.put("eventGroups", this.genEventGroups(jobTypeId));
        
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("   eve_sch.id AS event_schedule_id "); // イベントスケジュールのID
        sql.append("  ,eve.name AS event_name "); // イベント名
        sql.append("  ,eve_sch.capacity_sum AS event_schedule_capacity_sum "); // イベントのキャパ
        sql.append("  ,DATE_FORMAT(eve_sch.date_time, '%Y/%m/%d %H:%i:%S') AS event_schedule_date_time ");
        sql.append("  ,eve_sch.time_minute AS event_schedule_time_minute ");
        sql.append(" FROM event_schedule AS eve_sch ");
        sql.append(" INNER JOIN event AS eve ON eve_sch.eventid = eve.id ");
        sql.append(" INNER JOIN event_group AS eve_grp ON eve.event_groupid = eve_grp.id ");
        sql.append(" WHERE eve_grp.job_typeid = ? AND eve_grp.id = ? AND DATE_FORMAT(eve_sch.date_time, '%Y%m%d') >= ? ");
        sql.append(" ORDER BY event_schedule_date_time, event_schedule_time_minute, event_schedule_id ");
         
        try (Connection con = DB.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql.toString());
            ps.setLong(1, jobTypeId);
            ps.setLong(2, eventGroupId);
            ps.setString(3, sdf4param.format(new java.sql.Date(today.getMillis())));
            ResultSet rs = ps.executeQuery();
            
            ArrayList<HashMap<String, String>> eventSchedules = new ArrayList<HashMap<String, String>>();
            while (rs.next()) {
                HashMap<String, String> eventSchedule = new HashMap<String, String>();
                int eventScheduleId = rs.getInt("event_schedule_id");
                eventSchedule.put("eventScheduleId", df.format(eventScheduleId));
                eventSchedule.put("eventName", rs.getString("event_name"));
                eventSchedule.put("eventScheduleCapacitySum", df.format(rs.getInt("event_schedule_capacity_sum")));
                eventSchedule.put("eventScheduleDateTime", rs.getString("event_schedule_date_time"));
                eventSchedule.put("eventScheduleTimeMinute", df.format(rs.getInt("event_schedule_time_minute")));
                int eventScheduleResultSum =
                        EntryUserEventSchedule.finder.where().eq("cancel_flag", false).eq("event_scheduleid", eventScheduleId).findRowCount();
                eventSchedule.put("eventScheduleResultSum", df.format(eventScheduleResultSum));
                eventSchedules.add(eventSchedule);
            }
            
            result.put("eventSchedules", eventSchedules);
            
        } catch (SQLException e) {
            throw new SaiyoException("DB error at helpGetEvent:", e);
        }
        
        return result;
    }
    
    // イベントグループの取得
    private ArrayList<HashMap<String, String>> genEventGroups(long jobTypeId) {
        DecimalFormat df = new DecimalFormat("0");
        ArrayList<HashMap<String, String>> eventGroups = new ArrayList<HashMap<String, String>>();
        List<EventGroup> orgGroups = EventGroup.finder.where().eq("job_typeid", jobTypeId).findList();
        for (EventGroup og : orgGroups) {
            HashMap<String, String> eventGroup = new HashMap<String, String>();
            eventGroup.put("eventGroupId", df.format(og.id));
            eventGroup.put("eventGroupName", og.name);
            eventGroups.add(eventGroup);
        }
        return eventGroups;
    }
    
    // ラップカウント（社員番号 AND 対象期間ごと)
    private HashMap<String, Object> helpGetLap(String empNo, int monthTerm) {
        
        if (monthTerm < 1) throw new IllegalArgumentException("Must monthTerm >= 1 !");
        
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        DecimalFormat df = new DecimalFormat("0");
        DateTime today = DateTime.now();
        
        // ユーザに紐づく対象のレポートタイプ取得して、
        Employee emp = Employee.finder.where().eq("employee_number", empNo).findUnique();
        List<DashboardReport> reports = DashboardReport.finder.where().eq("employee_id", emp.id).findList();
        List<HashMap<String, Object>> laps = new ArrayList<HashMap<String,Object>>();
        for (DashboardReport report : reports) {
            HashMap<String, Object> lap = new HashMap<String, Object>();

            int sumResult = 0;
            int sumGoal = 0;
            for (int i = 0; i < monthTerm; i++) {
                String yyyyMM =
                        sdf.format(new java.util.Date(today.plusMonths(i).getMillis()));
                HashMap<String, Integer> perTypeAndMonth =
                        this.helpGetLap(report.reportType, yyyyMM);
                sumResult += perTypeAndMonth.get("sum_result"); // 実績(累積
                sumGoal += perTypeAndMonth.get("sum_goal"); // 目標（累積
                lap.put("reportType", df.format(report.reportType));
                lap.put("reportTypeName", ReportType.getName(report.reportType));
                lap.put("yyyyMM", yyyyMM);
                lap.put("sumResult", df.format(sumResult));
                lap.put("sumGoal", df.format(sumGoal));
                
                laps.add(lap);
                
            }
            
            
        }
        
        result.put("laps", laps);
        return result;
    }
    
    // ラップのカウント（レポートタイプ AND 月次 ごと）
    private HashMap<String, Integer> helpGetLap(int reportType, String yyyyMM) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT SUM(report_count) AS sum_result, SUM(goal) AS sum_goal ");
        sql.append(" FROM report_record ");
        sql.append(" WHERE report_type = ? AND DATE_FORMAT(record_date, '%Y%m') = ? ");
        
        try (Connection con = DB.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql.toString());
            ps.setInt(1, reportType);
            ps.setString(2, yyyyMM);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result.put("sum_result", rs.getInt("sum_result"));
                result.put("sum_goal", rs.getInt("sum_goal"));
                return result;
            }
            
        } catch (SQLException e) {
            throw new SaiyoException("DB error at: helpGetLap(int, String)", e);
        }
        
        throw new SaiyoException("DB error at: helpGetLap(int, String)");
    }
    
    // スケジュール取得のヘルパーメソッド
    private HashMap<String, Object> helpGetSchedule() {
        HashMap<String, Object> result = new HashMap<String, Object>();

        SimpleDateFormat sdf4param = new SimpleDateFormat("yyyyMMdd");
        DecimalFormat df = new DecimalFormat("0");

        // 今日の時間を取得
        DateTime today = DateTime.now();
        AppLogUtil.debug("today:" + today);

        // スケジュール取得
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("   eve_sch.id AS event_schedule_id "); // イベントスケジュールID
        sql.append("  ,DATE_FORMAT(eve_sch.date_time, '%Y/%m/%d %H:%i:%S') AS event_schedule_date_time "); // イベントスケジュール開催日時
        sql.append("  ,eve_sch.time_minute AS event_schedule_time_minute "); // イベントスケジュール所用時間
        sql.append("  ,eve.name AS event_name "); // イベント名前
        sql.append("  ,eve_grp.name AS event_group_name "); // イベントグループ名前
        sql.append("  ,jobt.name AS job_type_name "); // イベントグループ名前
        sql.append(" FROM event_schedule AS eve_sch ");
        sql.append(" INNER JOIN event AS eve ON eve_sch.eventid = eve.id ");
        sql.append(" INNER JOIN event_group AS eve_grp ON eve.event_groupid = eve_grp.id ");
        sql.append(" INNER JOIN job_type AS jobt ON eve_grp.job_typeid = jobt.id ");
        sql.append(" WHERE DATE_FORMAT(eve_sch.date_time, '%Y%m%d') = ? ");
        sql.append(" ORDER BY job_type_name, event_group_name, event_name, event_schedule_date_time, event_schedule_time_minute, event_schedule_id ");
               
        try (Connection con = DB.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql.toString());
            ps.setString(1, sdf4param.format(new java.util.Date(today.getMillis())));
            ResultSet rs = ps.executeQuery();
            
            List<HashMap<String, Object>> eventSchedules = new ArrayList<HashMap<String, Object>>();
            while(rs.next()) {
                HashMap<String, Object> eventSchedule = new HashMap<String, Object>();
                int eventScheduleId = rs.getInt("event_schedule_id");
                eventSchedule.put("eventScheduleId", df.format(eventScheduleId));
                eventSchedule.put("eventScheduleDateTime", rs.getString("event_schedule_date_time"));
                eventSchedule.put("eventScheduleTimeMinute", df.format(rs.getInt("event_schedule_time_minute")));
                eventSchedule.put("eventName", rs.getString("event_name"));
                eventSchedule.put("eventGroupName", rs.getString("event_group_name"));
                eventSchedule.put("jobTypeName", rs.getString("job_type_name"));
                // イベント関係社員の名前を取得する
                List<EventScheduleEmployee> eventScheduleEmployees = EventScheduleEmployee.finder.where().eq("event_scheduleid", eventScheduleId).findList();
                List<String> employeeNames = new ArrayList<String>();
                for (EventScheduleEmployee eventScheduleEmployee : eventScheduleEmployees) {
                    employeeNames.add(eventScheduleEmployee.employee.name);
                }
                eventSchedule.put("employeeNames", employeeNames);
                
                eventSchedules.add(eventSchedule);
            }
            
            result.put("eventSchedules", eventSchedules);
            return result;
            
        } catch (SQLException e) {
            throw new SaiyoException("DB error at: getSchedule ", e);
        }
    }
    
    // 明日、定員に達していない、イベントがあるか？
    private boolean vacantInterviewNextDay() {
     
        // 明日
        DateTime now = DateTime.now();
        DateTime nextDay = now.plusDays(1);
        AppLogUtil.debug("nextDay:" + nextDay);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        
        
        // 対象年度で、内定していている人のなかで、２週間以上連絡してない人の数をカウント
        // システムマスタ値は、べたで使う（こちらがコントロールできる値なので、汚染はないだろう前提）
        try (Connection con = DB.getConnection()) {
            
            // 明日のイベント取得SQL
            StringBuilder getCapacity = new StringBuilder();
            getCapacity.append(
                    " SELECT id, capacity_sum FROM event_schedule WHERE DATE_FORMAT(date_time, '%Y%m%d') = ? ");
            PreparedStatement psGetCapacity = con.prepareStatement(getCapacity.toString());
            psGetCapacity.setString(1, sdf.format(new java.util.Date(nextDay.getMillis())));
                       
            // 明日のイベント取得
            ResultSet rsGetCapacity = psGetCapacity.executeQuery();
            while (rsGetCapacity.next()) {

                // イベントのキャパと、申し込み実績を確認し、まだキャパあるか判断
                int eventScheduleId = rsGetCapacity.getInt("id");
                int capacitySum = rsGetCapacity.getInt("capacity_sum");
                int resultCnt =
                        EntryUserEventSchedule.finder.where().eq("cancel_flag", false).eq("event_scheduleid", eventScheduleId).findRowCount();
                if (capacitySum > resultCnt) {
                    return true;
                }
                
            }
            

        } catch (SQLException e) {
            throw new SaiyoException("DB error at: vacantInterviewNextDay ", e);
        }

        return false;

    }
    
    
    // 内定していて２週間連絡のない人がいるか？
    private int notDoneInquiryCount() {

        // まずは、管理対象の採用年度を取得（カンマくぎりで複数ありえる）
        SystemMaster sm =
                SystemMaster.finder.where().eq("configKey", SystemMasterKey.ADMIN_TARGET_YEAR.getConfigKey()).findUnique();
        
        // 対象年度で、回答の入っていない問い合わせ件数
        // システムマスタ値は、べたで使う（こちらがコントロールできる値なので、汚染はないだろう前提）
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT COUNT(inq.id) AS target_cnt ");
        sql.append(" FROM entry_user AS eu INNER JOIN  inquiry AS inq ");
        sql.append(" ON eu.id = inq.entry_userid ");
        sql.append(" WHERE eu.application_year IN (").append(sm.configValue).append(") ");
        sql.append(" AND inq.employee_id IS NULL ");
        try (Connection con = DB.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql.toString());            
            ResultSet rs =  ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("target_cnt");
                AppLogUtil.debug("notDoneInquiryCount:" + count);
                return count;
            }
            // 結果セットがないのは、SQLのあやまりか、DBのエラー
            throw new SaiyoException("DB access error");
            
        } catch (SQLException e) {
            throw new SaiyoException("DB error at: notDoneInquiryCount ", e);
        }


    }
    
    
    
    // 内定していて２週間連絡のない人がいるか？
    private boolean noContactOver2week() {

        // まずは、管理対象の採用年度を取得（カンマくぎりで複数ありえる）
        SystemMaster sm =
                SystemMaster.finder.where().eq("configKey", SystemMasterKey.ADMIN_TARGET_YEAR.getConfigKey()).findUnique();
        
        // 今から二週間前
        DateTime now = DateTime.now();
        DateTime before2week = now.minusWeeks(2);
        AppLogUtil.debug("before2week:" + before2week);
        

        // 対象年度で、内定していている人のなかで、２週間以上連絡してない人の数をカウント
        // システムマスタ値は、べたで使う（こちらがコントロールできる値なので、汚染はないだろう前提）
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT COUNT(com.id) AS target_cnt ");
        sql.append(" FROM entry_user AS eu INNER JOIN  entry_user_communication AS com ");
        sql.append(" ON eu.id = com.entry_userid ");
        sql.append(" WHERE eu.entry_status = ? AND eu.application_year IN (").append(sm.configValue).append(") ");
        sql.append(" AND com.datetime <= ? ");
        try (Connection con = DB.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql.toString());
            ps.setInt(1, EntryStatus.NAITEI.getCode());
            ps.setDate(2, new java.sql.Date(before2week.getMillis()));
            
            ResultSet rs =  ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("target_cnt");
                AppLogUtil.debug("noContactOver2week count:" + count);
                if (count > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new SaiyoException("DB error at: noContactOver2week ", e);
        }

        return false;
    }
    
}
