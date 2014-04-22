package models.services;
import static org.fest.assertions.Assertions.assertThat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Company;
import models.ComplexGroup;
import models.DashboardReport;
import models.Employee;
import models.EntryUser;
import models.EntryUserCommunication;
import models.EntryUserEventSchedule;
import models.EventGroup;
import models.EventSchedule;
import models.EventScheduleEmployee;
import models.Inquiry;
import models.JobType;
import models.ReportRecord;
import models.Venue;

import org.joda.time.DateTime;
import org.junit.Test;

import base.SaiyoTestBase;
import controllers.enums.EntryStatus;
import controllers.enums.ReportType;

/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class DashBoardServiceTest extends SaiyoTestBase {
    
    @Test
    public void testGetEvent001() {
        
        // 空っぽのパターン
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getEvent(1, 1);

        assertThat(result.get("eventGroups")).isInstanceOf(List.class);
        List<?> eventGroups = (List<?>) result.get("eventGroups");
        assertThat(eventGroups.isEmpty()).isTrue();
        
        assertThat(result.get("eventSchedules")).isInstanceOf(List.class);
        List<?> eventSchedules = (List<?>) result.get("eventSchedules");
        assertThat(eventSchedules.isEmpty()).isTrue();
    }
    
    @Test
    @SuppressWarnings("unchecked")
    public void testGetEvent002() {
        
        // イベントグループの確認
        
        // 仕込み
        JobType jobType = JobType.finder.byId(1L);
        
        DecimalFormat df = new DecimalFormat("0");
        
        EventGroup eg1 = new EventGroup();
        eg1.jobType = jobType;
        eg1.name = "グループ1";
        eg1.type = 9;
        eg1.save();
        assertThat(eg1.id).isNotNull();
        
        EventGroup eg2 = new EventGroup();
        eg2.jobType = jobType;
        eg2.name = "グループ2";
        eg2.type = 9;
        eg2.save();
        assertThat(eg2.id).isNotNull();
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getEvent(1, 1);

        assertThat(result.get("eventGroups")).isInstanceOf(List.class);
        List<HashMap<String, String>> eventGroups =
                (List<HashMap<String, String>>) result.get("eventGroups");
        assertThat(eventGroups.size()).isEqualTo(2);
        for (HashMap<String, String> eventGroup : eventGroups) {
            if (eventGroup.get("eventGroupId").equals(df.format(eg1.id))) {
                assertThat(eventGroup.get("eventGroupName")).isEqualTo("グループ1");
            }
            if (eventGroup.get("eventGroupId").equals(df.format(eg2.id))) {
                assertThat(eventGroup.get("eventGroupName")).isEqualTo("グループ2");
            }
        }
        
        assertThat(result.get("eventSchedules")).isInstanceOf(List.class);
        List<?> eventSchedules = (List<?>) result.get("eventSchedules");
        assertThat(eventSchedules.isEmpty()).isTrue();
    }
    
    @Test
    @SuppressWarnings("unchecked")
    public void testGetEvent003() {
        
        // イベントがあるパターン今日だけ
        
        // 仕込み
        // データがあるパターン
        DecimalFormat df = new DecimalFormat("0");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        // 仕込み
        DateTime today = DateTime.now();
                
        // 前提データ準備
        EntryUser entryUser =
                EntryUser.finder.where().eq("email", "shinjuku-test@test.local").findUnique();
        assertThat(entryUser.lastName).isEqualTo("新宿");

        JobType jobType = JobType.finder.where().eq("name", "インターネット広告営業").findUnique();
        assertThat(jobType.id).isNotNull();
        EventGroup eventGroup = new EventGroup();
        eventGroup.jobType = jobType;
        eventGroup.name = "テストイベントグループ";
        eventGroup.type = 1; // test
        eventGroup.save();
        assertThat(eventGroup.id).isNotNull();
        
        Venue venue = Venue.finder.where().eq("name", "マークシティ").findUnique();
        assertThat(venue.id).isNotNull();
        
        Employee employee = Employee.finder.where().eq("name", "宮嶋雅文").findUnique();
        
        Company company = Company.finder.where().eq("name", "株式会社サイバーエージェント").findUnique();

        ComplexGroup complexGroup = new ComplexGroup();
        complexGroup.company = company;
        complexGroup.employee = employee;
        complexGroup.name = "テストのグループ名";
        complexGroup.conditonSchoolDivision = 9;
        complexGroup.save();
        assertThat(complexGroup.id).isNotNull();
        
        models.Event event = new models.Event();
        event.eventGroup = eventGroup;
        event.cancelable = false;
        event.delflag = false;
        event.enqueteCode = "test";
        event.enqueteUrl = "http://test...../";
        event.message = "test";
        event.modifiable = true;
        event.name = "仮のイベント";
        event.receptionFrom = new java.util.Date(System.currentTimeMillis());
        event.stepName = "仮";
        event.complexGroup = complexGroup;
        event.save();
        assertThat(event.id).isNotNull();
        
        EventSchedule eventSchedule = new EventSchedule();
        eventSchedule.capacitySum = 1;
        eventSchedule.capacityFemale = 0;
        eventSchedule.capacityMale = 1;
        eventSchedule.cybozuEventid = 9L;
        java.util.Date today4set = new java.util.Date(today.getMillis());
        eventSchedule.dateTime = today4set;
        eventSchedule.event = event;
        eventSchedule.groupid = 9;
        eventSchedule.receptionFrom = new java.util.Date(System.currentTimeMillis());
        eventSchedule.receptionTo = new java.util.Date(System.currentTimeMillis() + 1000L);
        eventSchedule.venue = venue;
        eventSchedule.timeMinute = 40;
        eventSchedule.save();
        assertThat(eventSchedule.id).isNotNull();
        
        EntryUserEventSchedule entryUserEventSchedule = new EntryUserEventSchedule();
        entryUserEventSchedule.cancelFlag = false;
        entryUserEventSchedule.eventSchedule = eventSchedule;
        entryUserEventSchedule.entryUser = entryUser;
        entryUserEventSchedule.attendance = true;
        entryUserEventSchedule.evaluation = 9;
        entryUserEventSchedule.selectionResult = 9;
        entryUserEventSchedule.save();
        assertThat(entryUserEventSchedule.id).isNotNull();
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result =
                service.getEvent(jobType.id, eventGroup.id);

        
        assertThat(result.get("eventSchedules")).isInstanceOf(List.class);
        List<HashMap<String, String>> eventSchedules =
                (List<HashMap<String, String>>) result.get("eventSchedules");
        assertThat(eventSchedules.size()).isEqualTo(1);
        HashMap<String, String> resEventSchedule = (HashMap<String, String>) eventSchedules.get(0);
        assertThat(resEventSchedule.get("eventScheduleId")).isEqualTo(df.format(eventSchedule.id));
        assertThat(resEventSchedule.get("eventName")).isEqualTo("仮のイベント");
        assertThat(resEventSchedule.get("eventScheduleCapacitySum")).isEqualTo("1");
        assertThat(resEventSchedule.get("eventScheduleDateTime")).isEqualTo(sdf.format(today4set));
        assertThat(resEventSchedule.get("eventScheduleTimeMinute")).isEqualTo("40");
        assertThat(resEventSchedule.get("eventScheduleResultSum")).isEqualTo("1");

        
    }
    
    @Test
    @SuppressWarnings("unchecked")
    public void testGetEvent004() {
        
        // イベントがあるパターン今日、明日にある
        
        // 仕込み
        // データがあるパターン
        DecimalFormat df = new DecimalFormat("0");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        // 仕込み
        DateTime today = DateTime.now();
        DateTime tomorrow = today.plusDays(1);
        
                
        // 前提データ準備
        EntryUser entryUser =
                EntryUser.finder.where().eq("email", "shinjuku-test@test.local").findUnique();
        assertThat(entryUser.lastName).isEqualTo("新宿");

        JobType jobType = JobType.finder.where().eq("name", "インターネット広告営業").findUnique();
        assertThat(jobType.id).isNotNull();
        EventGroup eventGroup = new EventGroup();
        eventGroup.jobType = jobType;
        eventGroup.name = "テストイベントグループ";
        eventGroup.type = 1; // test
        eventGroup.save();
        assertThat(eventGroup.id).isNotNull();
        
        Venue venue = Venue.finder.where().eq("name", "マークシティ").findUnique();
        assertThat(venue.id).isNotNull();
        
        Employee employee = Employee.finder.where().eq("name", "宮嶋雅文").findUnique();
        
        Company company = Company.finder.where().eq("name", "株式会社サイバーエージェント").findUnique();

        ComplexGroup complexGroup = new ComplexGroup();
        complexGroup.company = company;
        complexGroup.employee = employee;
        complexGroup.name = "テストのグループ名";
        complexGroup.conditonSchoolDivision = 9;
        complexGroup.save();
        assertThat(complexGroup.id).isNotNull();
        
        models.Event event = new models.Event();
        event.eventGroup = eventGroup;
        event.cancelable = false;
        event.delflag = false;
        event.enqueteCode = "test";
        event.enqueteUrl = "http://test...../";
        event.message = "test";
        event.modifiable = true;
        event.name = "仮のイベント";
        event.receptionFrom = new java.util.Date(System.currentTimeMillis());
        event.stepName = "仮";
        event.complexGroup = complexGroup;
        event.save();
        assertThat(event.id).isNotNull();
        
        java.util.Date today4set = new java.util.Date(today.getMillis());
        EventSchedule eventSchedule = new EventSchedule();
        eventSchedule.capacitySum = 1;
        eventSchedule.capacityFemale = 0;
        eventSchedule.capacityMale = 1;
        eventSchedule.cybozuEventid = 9L;
        eventSchedule.dateTime = today4set;
        eventSchedule.event = event;
        eventSchedule.groupid = 9;
        eventSchedule.receptionFrom = new java.util.Date(System.currentTimeMillis());
        eventSchedule.receptionTo = new java.util.Date(System.currentTimeMillis() + 1000L);
        eventSchedule.venue = venue;
        eventSchedule.timeMinute = 40;
        eventSchedule.save();
        assertThat(eventSchedule.id).isNotNull();
        
        java.util.Date tomorrow4set = new java.util.Date(tomorrow.getMillis());
        EventSchedule eventSchedule2 = new EventSchedule();
        eventSchedule2.capacitySum = 5;
        eventSchedule2.capacityFemale = 0;
        eventSchedule2.capacityMale = 1;
        eventSchedule2.cybozuEventid = 9L;
        eventSchedule2.dateTime = tomorrow4set;
        eventSchedule2.event = event;
        eventSchedule2.groupid = 9;
        eventSchedule2.receptionFrom = new java.util.Date(System.currentTimeMillis());
        eventSchedule2.receptionTo = new java.util.Date(System.currentTimeMillis() + 1000L);
        eventSchedule2.venue = venue;
        eventSchedule2.timeMinute = 7;
        eventSchedule2.save();
        assertThat(eventSchedule2.id).isNotNull();
        
        
        EntryUserEventSchedule entryUserEventSchedule = new EntryUserEventSchedule();
        entryUserEventSchedule.cancelFlag = false;
        entryUserEventSchedule.eventSchedule = eventSchedule;
        entryUserEventSchedule.entryUser = entryUser;
        entryUserEventSchedule.attendance = true;
        entryUserEventSchedule.evaluation = 9;
        entryUserEventSchedule.selectionResult = 9;
        entryUserEventSchedule.save();
        assertThat(entryUserEventSchedule.id).isNotNull();
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result =
                service.getEvent(jobType.id, eventGroup.id);

        
        assertThat(result.get("eventSchedules")).isInstanceOf(List.class);
        List<HashMap<String, String>> eventSchedules =
                (List<HashMap<String, String>>) result.get("eventSchedules");
        assertThat(eventSchedules.size()).isEqualTo(2);
        for (HashMap<String, String> resEventSchedule : eventSchedules) {
            //
            if (resEventSchedule.get("eventScheduleId").equals(df.format(eventSchedule.id))) {
                assertThat(resEventSchedule.get("eventName")).isEqualTo("仮のイベント");
                assertThat(resEventSchedule.get("eventScheduleCapacitySum")).isEqualTo("1");
                assertThat(resEventSchedule.get("eventScheduleDateTime")).isEqualTo(sdf.format(today4set));
                assertThat(resEventSchedule.get("eventScheduleTimeMinute")).isEqualTo("40");
                assertThat(resEventSchedule.get("eventScheduleResultSum")).isEqualTo("1");                
            }
            if (resEventSchedule.get("eventScheduleId").equals(df.format(eventSchedule2.id))) {
                assertThat(resEventSchedule.get("eventName")).isEqualTo("仮のイベント");
                assertThat(resEventSchedule.get("eventScheduleCapacitySum")).isEqualTo("5");
                assertThat(resEventSchedule.get("eventScheduleDateTime")).isEqualTo(sdf.format(tomorrow4set));
                assertThat(resEventSchedule.get("eventScheduleTimeMinute")).isEqualTo("7");
                assertThat(resEventSchedule.get("eventScheduleResultSum")).isEqualTo("0");                
            }
        }
        
    }
    
    
    // -------------------------------------------------------------------- Lap
    @Test
    public void testGetLap001() {
        
        // 空っぽのパターン
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getLap("A12152", 1);

        assertThat(result.get("laps")).isInstanceOf(List.class);
        List<?> laps = (List<?>) result.get("laps");
        assertThat(laps.isEmpty()).isTrue();
    }
    
    @Test
    @SuppressWarnings("unchecked")
    public void testGetLap002() {
        
        // 一月だけのパターン
        
        // 仕込み
        
        Employee a12152 = Employee.finder.where().eq("employee_number", "A12152").findUnique();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        DecimalFormat df = new DecimalFormat("0");

        DashboardReport dr1 = new DashboardReport();
        dr1.employee = a12152;
        dr1.reportType = ReportType.TOROKUBI.getCode();
        dr1.save();
        assertThat(dr1.id).isNotNull();
        
        DashboardReport dr2 = new DashboardReport();
        dr2.employee = a12152;
        dr2.reportType = ReportType.TOROKUSHASU.getCode();
        dr2.save();
        assertThat(dr2.id).isNotNull();
        
        DateTime today = DateTime.now();
        DateTime tomorrow = today.plus(1);
        
        ReportRecord rr1today = new ReportRecord();
        rr1today.goal = 2;
        rr1today.reportCount = 1;
        rr1today.reportType = ReportType.TOROKUBI.getCode();
        rr1today.recordDate = new java.util.Date(today.getMillis());
        rr1today.save();
        assertThat(rr1today.id).isNotNull();
        
        ReportRecord rr1tomorrow = new ReportRecord();
        rr1tomorrow.goal = 20;
        rr1tomorrow.reportCount = 10;
        rr1tomorrow.reportType = ReportType.TOROKUBI.getCode();
        rr1tomorrow.recordDate = new java.util.Date(tomorrow.getMillis());
        rr1tomorrow.save();
        assertThat(rr1tomorrow.id).isNotNull();
        
        
        ReportRecord rr2today = new ReportRecord();
        rr2today.goal = 3;
        rr2today.reportCount = 8;
        rr2today.reportType = ReportType.TOROKUSHASU.getCode();
        rr2today.recordDate = new java.util.Date(today.getMillis());
        rr2today.save();
        assertThat(rr2today.id).isNotNull();
        
        ReportRecord rr2tomorrow = new ReportRecord();
        rr2tomorrow.goal = 30;
        rr2tomorrow.reportCount = 6;
        rr2tomorrow.reportType = ReportType.TOROKUSHASU.getCode();
        rr2tomorrow.recordDate = new java.util.Date(tomorrow.getMillis());
        rr2tomorrow.save();
        assertThat(rr2tomorrow.id).isNotNull();
        
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getLap("A12152", 1);
        
        assertThat(result.get("laps")).isInstanceOf(List.class);
        List<HashMap<String, Object>> laps = (List<HashMap<String, Object>>) result.get("laps");
        assertThat(laps.size()).isEqualTo(2);
        for (HashMap<String, Object> lap : laps) {
            String reportType = (String) lap.get("reportType");
            if (ReportType.TOROKUBI.getCode() == Integer.parseInt(reportType)) {
                assertThat(lap.get("reportTypeName")).isEqualTo(ReportType.TOROKUBI.getName());
                assertThat(lap.get("yyyyMM")).isEqualTo(sdf.format(new java.util.Date(today.getMillis())));
                assertThat(lap.get("sumResult")).isEqualTo(df.format(11));
                assertThat(lap.get("sumGoal")).isEqualTo(df.format(22));
            }
            if (ReportType.TOROKUSHASU.getCode() == Integer.parseInt(reportType)) {
                assertThat(lap.get("reportTypeName")).isEqualTo(ReportType.TOROKUSHASU.getName());
                assertThat(lap.get("yyyyMM")).isEqualTo(sdf.format(new java.util.Date(today.getMillis())));
                assertThat(lap.get("sumResult")).isEqualTo(df.format(14));
                assertThat(lap.get("sumGoal")).isEqualTo(df.format(33));
            }
        }

    }
    
    @Test
    @SuppressWarnings("unchecked")
    public void testGetLap003() {
        
        // 一月だけのパターン
        
        // 仕込み
        
        Employee a12152 = Employee.finder.where().eq("employee_number", "A12152").findUnique();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        DecimalFormat df = new DecimalFormat("0");

        DashboardReport dr1 = new DashboardReport();
        dr1.employee = a12152;
        dr1.reportType = ReportType.TOROKUBI.getCode();
        dr1.save();
        assertThat(dr1.id).isNotNull();
        
        DashboardReport dr2 = new DashboardReport();
        dr2.employee = a12152;
        dr2.reportType = ReportType.TOROKUSHASU.getCode();
        dr2.save();
        assertThat(dr2.id).isNotNull();
        
        DateTime today = DateTime.now();
        DateTime tomorrow = today.plus(1);
        DateTime nextMonthToday = today.plusMonths(1);
        DateTime nextMonthTomorrow = tomorrow.plusMonths(1);
        
        
        ReportRecord rr1today = new ReportRecord();
        rr1today.goal = 2;
        rr1today.reportCount = 1;
        rr1today.reportType = ReportType.TOROKUBI.getCode();
        rr1today.recordDate = new java.util.Date(today.getMillis());
        rr1today.save();
        assertThat(rr1today.id).isNotNull();
        
        ReportRecord rr1tomorrow = new ReportRecord();
        rr1tomorrow.goal = 20;
        rr1tomorrow.reportCount = 10;
        rr1tomorrow.reportType = ReportType.TOROKUBI.getCode();
        rr1tomorrow.recordDate = new java.util.Date(tomorrow.getMillis());
        rr1tomorrow.save();
        assertThat(rr1tomorrow.id).isNotNull();
        
        
        ReportRecord rr1NextMonthToday = new ReportRecord();
        rr1NextMonthToday.goal = 13;
        rr1NextMonthToday.reportCount = 7;
        rr1NextMonthToday.reportType = ReportType.TOROKUBI.getCode();
        rr1NextMonthToday.recordDate = new java.util.Date(nextMonthToday.getMillis());
        rr1NextMonthToday.save();
        assertThat(rr1NextMonthToday.id).isNotNull();
        
        ReportRecord rr1NextMonthTomorrow = new ReportRecord();
        rr1NextMonthTomorrow.goal = 6;
        rr1NextMonthTomorrow.reportCount = 2;
        rr1NextMonthTomorrow.reportType = ReportType.TOROKUBI.getCode();
        rr1NextMonthTomorrow.recordDate = new java.util.Date(nextMonthTomorrow.getMillis());
        rr1NextMonthTomorrow.save();
        assertThat(rr1NextMonthTomorrow.id).isNotNull();
        
        
        ReportRecord rr2today = new ReportRecord();
        rr2today.goal = 3;
        rr2today.reportCount = 8;
        rr2today.reportType = ReportType.TOROKUSHASU.getCode();
        rr2today.recordDate = new java.util.Date(today.getMillis());
        rr2today.save();
        assertThat(rr2today.id).isNotNull();
        
        ReportRecord rr2tomorrow = new ReportRecord();
        rr2tomorrow.goal = 30;
        rr2tomorrow.reportCount = 6;
        rr2tomorrow.reportType = ReportType.TOROKUSHASU.getCode();
        rr2tomorrow.recordDate = new java.util.Date(tomorrow.getMillis());
        rr2tomorrow.save();
        assertThat(rr2tomorrow.id).isNotNull();
        
        ReportRecord rr2NextMonthToday = new ReportRecord();
        rr2NextMonthToday.goal = 12;
        rr2NextMonthToday.reportCount = 7;
        rr2NextMonthToday.reportType = ReportType.TOROKUSHASU.getCode();
        rr2NextMonthToday.recordDate = new java.util.Date(nextMonthToday.getMillis());
        rr2NextMonthToday.save();
        assertThat(rr2NextMonthToday.id).isNotNull();
        
        ReportRecord rr2NextMonthTomorrow = new ReportRecord();
        rr2NextMonthTomorrow.goal = 4;
        rr2NextMonthTomorrow.reportCount = 5;
        rr2NextMonthTomorrow.reportType = ReportType.TOROKUSHASU.getCode();
        rr2NextMonthTomorrow.recordDate = new java.util.Date(nextMonthTomorrow.getMillis());
        rr2NextMonthTomorrow.save();
        assertThat(rr2NextMonthTomorrow.id).isNotNull();
        
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getLap("A12152", 2);
        
        
        assertThat(result.get("laps")).isInstanceOf(List.class);
        List<HashMap<String, Object>> laps = (List<HashMap<String, Object>>) result.get("laps");
        
        assertThat(laps.size()).isEqualTo(4);
        for (HashMap<String, Object> lap : laps) {
            String reportType = (String) lap.get("reportType");
            if (ReportType.TOROKUBI.getCode() == Integer.parseInt(reportType)) {
                
                assertThat(lap.get("reportTypeName")).isEqualTo(ReportType.TOROKUBI.getName());
                
                if (sdf.format( new java.util.Date(today.getMillis())).equals(lap.get("yyyyMM"))) {
                    assertThat(lap.get("sumResult")).isEqualTo(df.format(11));
                    assertThat(lap.get("sumGoal")).isEqualTo(df.format(22));                    
                }
                if (sdf.format( new java.util.Date(nextMonthToday.getMillis())).equals(lap.get("yyyyMM"))) {
                    assertThat(lap.get("sumResult")).isEqualTo(df.format(20)); // 9
                    assertThat(lap.get("sumGoal")).isEqualTo(df.format(41)); // 19
                }
                

            }
            if (ReportType.TOROKUSHASU.getCode() == Integer.parseInt(reportType)) {

                assertThat(lap.get("reportTypeName")).isEqualTo(ReportType.TOROKUSHASU.getName());
                
                if (sdf.format( new java.util.Date(today.getMillis())).equals(lap.get("yyyyMM"))) {
                    assertThat(lap.get("sumResult")).isEqualTo(df.format(14));
                    assertThat(lap.get("sumGoal")).isEqualTo(df.format(33));                    
                }
                if (sdf.format( new java.util.Date(nextMonthToday.getMillis())).equals(lap.get("yyyyMM"))) {
                    assertThat(lap.get("sumResult")).isEqualTo(df.format(26)); // 12
                    assertThat(lap.get("sumGoal")).isEqualTo(df.format(49)); // 16
                }
            }
        }

    }
    
    
    // -------------------------------------------------------------------- Schedule
    @Test
    public void testGetSchedule001() {
        
        // 空っぽのパターン
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getSchedule();

        assertThat(result.get("eventSchedules")).isInstanceOf(List.class);
        List<?> eventSchedules = (List<?>) result.get("eventSchedules");
        assertThat(eventSchedules.isEmpty()).isTrue();
    }
    
    @Test
    @SuppressWarnings("unchecked")
    public void testGetSchedule002() {
        
        // データがあるパターン
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DecimalFormat df = new DecimalFormat("0");
        
        // 仕込み
        DateTime today = DateTime.now();
        
        Employee a12152 = Employee.finder.where().eq("employee_number", "A12152").findUnique();
        Employee a13413 = Employee.finder.where().eq("employee_number", "A13413").findUnique();
        
        // 前提データ準備
        EntryUser entryUser =
                EntryUser.finder.where().eq("email", "shinjuku-test@test.local").findUnique();
        assertThat(entryUser.lastName).isEqualTo("新宿");

        JobType jobType = JobType.finder.where().eq("name", "インターネット広告営業").findUnique();
        assertThat(jobType.id).isNotNull();
        EventGroup eventGroup = new EventGroup();
        eventGroup.jobType = jobType;
        eventGroup.name = "テストイベントグループ";
        eventGroup.type = 1; // test
        eventGroup.save();
        assertThat(eventGroup.id).isNotNull();
        
        Venue venue = Venue.finder.where().eq("name", "マークシティ").findUnique();
        assertThat(venue.id).isNotNull();
        
        Employee employee = Employee.finder.where().eq("name", "宮嶋雅文").findUnique();
        
        Company company = Company.finder.where().eq("name", "株式会社サイバーエージェント").findUnique();

        ComplexGroup complexGroup = new ComplexGroup();
        complexGroup.company = company;
        complexGroup.employee = employee;
        complexGroup.name = "テストのグループ名";
        complexGroup.conditonSchoolDivision = 9;
        complexGroup.save();
        assertThat(complexGroup.id).isNotNull();
        
        models.Event event = new models.Event();
        event.eventGroup = eventGroup;
        event.cancelable = false;
        event.delflag = false;
        event.enqueteCode = "test";
        event.enqueteUrl = "http://test...../";
        event.message = "test";
        event.modifiable = true;
        event.name = "仮のイベント";
        event.receptionFrom = new java.util.Date(System.currentTimeMillis());
        event.stepName = "仮";
        event.complexGroup = complexGroup;
        event.save();
        assertThat(event.id).isNotNull();
        
        EventSchedule eventSchedule = new EventSchedule();
        eventSchedule.capacitySum = 1;
        eventSchedule.capacityFemale = 0;
        eventSchedule.capacityMale = 1;
        eventSchedule.cybozuEventid = 9L;
        java.util.Date today4set = new java.util.Date(today.getMillis());
        eventSchedule.dateTime = today4set;
        eventSchedule.event = event;
        eventSchedule.groupid = 9;
        eventSchedule.receptionFrom = new java.util.Date(System.currentTimeMillis());
        eventSchedule.receptionTo = new java.util.Date(System.currentTimeMillis() + 1000L);
        eventSchedule.venue = venue;
        eventSchedule.timeMinute = 40;
        eventSchedule.save();
        long eventScheduleId = eventSchedule.id;
        assertThat(eventSchedule.id).isNotNull();
        
        EntryUserEventSchedule entryUserEventSchedule = new EntryUserEventSchedule();
        entryUserEventSchedule.cancelFlag = false;
        entryUserEventSchedule.eventSchedule = eventSchedule;
        entryUserEventSchedule.entryUser = entryUser;
        entryUserEventSchedule.attendance = true;
        entryUserEventSchedule.evaluation = 9;
        entryUserEventSchedule.selectionResult = 9;
        entryUserEventSchedule.save();
        assertThat(entryUserEventSchedule.id).isNotNull();
        
        
        EventScheduleEmployee forA12152 = new EventScheduleEmployee();
        forA12152.employee = a12152;
        forA12152.eventSchedule = eventSchedule;
        forA12152.save();
        assertThat(forA12152.id).isNotNull();
        
        EventScheduleEmployee forA13413 = new EventScheduleEmployee();
        forA13413.employee = a13413;
        forA13413.eventSchedule = eventSchedule;
        forA13413.save();
        assertThat(forA13413.id).isNotNull();
        
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getSchedule();

        assertThat(result.get("eventSchedules")).isInstanceOf(List.class);
        List<?> eventSchedules = (List<?>) result.get("eventSchedules");
        assertThat(eventSchedules.size()).isEqualTo(1);
        assertThat(eventSchedules.get(0)).isInstanceOf(HashMap.class);
        HashMap<?, ?> resultSchedule = (HashMap<?, ?>) eventSchedules.get(0);
        assertThat(resultSchedule.get("eventScheduleId")).isEqualTo(df.format(eventScheduleId));
        assertThat(resultSchedule.get("eventScheduleDateTime")).isEqualTo(sdf.format(today4set));
        assertThat(resultSchedule.get("eventScheduleTimeMinute")).isEqualTo(df.format(40));
        assertThat(resultSchedule.get("eventName")).isEqualTo("仮のイベント");
        assertThat(resultSchedule.get("eventGroupName")).isEqualTo("テストイベントグループ");
        assertThat(resultSchedule.get("jobTypeName")).isEqualTo("インターネット広告営業");
        assertThat(resultSchedule.get("employeeNames")).isInstanceOf(List.class);
        List<String> employeeNames = (List<String>) resultSchedule.get("employeeNames");
        assertThat(employeeNames.size()).isEqualTo(2);
        assertThat(employeeNames.contains("宮嶋雅文")).isTrue();
        assertThat(employeeNames.contains("清水健司")).isTrue();
    }
    

    
    // -------------------------------------------------------------------- Activity
    @Test
    public void testGetActivity001() {
        
        // 空っぽのパターン
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getActivity();
        
        assertThat(result.get("noContactOver2week")).isEqualTo(false);
        assertThat(result.get("notDoneInquiryCount")).isEqualTo(0);
        assertThat(result.get("vacantInterviewNextDay")).isEqualTo(false);
    }
    
    
    @Test
    public void testGetActivity002() {
        
        // 内定していて、2週間連絡とってない人がいる場合

        // 前提データ準備
        EntryUser entryUser =
                EntryUser.finder.where().eq("email", "shinjuku-test@test.local").findUnique();
        assertThat(entryUser.lastName).isEqualTo("新宿");
        entryUser.entryStatus = EntryStatus.NAITEI.getCode();
        entryUser.update();
        EntryUserCommunication entryUserCommunication = new EntryUserCommunication();
        entryUserCommunication.comments  = "テスト";
        entryUserCommunication.conditiontype = 9; // test
        entryUserCommunication.entryUser = entryUser;
        DateTime before3week = DateTime.now().minusMonths(4);
        entryUserCommunication.datetime = new java.util.Date(before3week.getMillis());
        entryUserCommunication.save();
        assertThat(entryUserCommunication.id).isNotNull();
        
        
        // 結果取得
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getActivity();
        
        
        // アサーション
        assertThat(result.get("noContactOver2week")).isEqualTo(true);
        assertThat(result.get("notDoneInquiryCount")).isEqualTo(0);
        assertThat(result.get("vacantInterviewNextDay")).isEqualTo(false);
    }
    
    @Test
    public void testGetActivity003() {
        
        // 回答していないお問い合わせの件数（エントリユーザ：1人）

        // 前提データ準備
        EntryUser entryUser =
                EntryUser.finder.where().eq("email", "shinjuku-test@test.local").findUnique();
        assertThat(entryUser.lastName).isEqualTo("新宿");

        Inquiry inquiry = new Inquiry();
        inquiry.content = "テスト";
        inquiry.email = "test@local";
        //inquiry.employee = employee;
        inquiry.entryUser = entryUser;
        inquiry.firstName = "testF";
        inquiry.lastName = "testL";
        inquiry.type = 9; // for test
        inquiry.save();
        assertThat(inquiry.id).isNotNull();
        
        
        // 結果取得
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getActivity();
        
        
        // アサーション
        assertThat(result.get("noContactOver2week")).isEqualTo(false);
        assertThat(result.get("notDoneInquiryCount")).isEqualTo(1);
        assertThat(result.get("vacantInterviewNextDay")).isEqualTo(false);
    }
    
    
    @Test
    public void testGetActivity004() {
        
        // 回答していないお問い合わせの件数（エントリユーザ：2人）

        // 前提データ準備
        EntryUser entryUser1 =
                EntryUser.finder.where().eq("email", "shinjuku-test@test.local").findUnique();
        assertThat(entryUser1.lastName).isEqualTo("新宿");

        Inquiry inquiry = new Inquiry();
        inquiry.content = "テスト";
        inquiry.email = "test@local";
        //inquiry.employee = employee;
        inquiry.entryUser = entryUser1;
        inquiry.firstName = "testF";
        inquiry.lastName = "testL";
        inquiry.type = 9; // for test
        inquiry.save();
        assertThat(inquiry.id).isNotNull();
        
        // 前提データ準備
        EntryUser entryUser2 =
                EntryUser.finder.where().eq("email", "shibuya-test@test.local").findUnique();
        assertThat(entryUser2.lastName).isEqualTo("渋谷");

        Inquiry inquiry2 = new Inquiry();
        inquiry2.content = "テスト";
        inquiry2.email = "test2@local";
        //inquiry.employee = employee;
        inquiry2.entryUser = entryUser2;
        inquiry2.firstName = "testF";
        inquiry2.lastName = "testL";
        inquiry2.type = 9; // for test
        inquiry2.save();
        assertThat(inquiry2.id).isNotNull();
        
        
        // 結果取得
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getActivity();
        
        
        // アサーション
        assertThat(result.get("noContactOver2week")).isEqualTo(false);
        assertThat(result.get("notDoneInquiryCount")).isEqualTo(2);
        assertThat(result.get("vacantInterviewNextDay")).isEqualTo(false);
    }
    
    @Test
    public void testGetActivity005() {
        
        // 明日、定員に達していないイベントがある場合（キャンセルなしで）
        
        // 仕込み
        DateTime tommorow = DateTime.now().plusDays(1);
        
        // 前提データ準備
        EntryUser entryUser =
                EntryUser.finder.where().eq("email", "shinjuku-test@test.local").findUnique();
        assertThat(entryUser.lastName).isEqualTo("新宿");

        JobType jobType = JobType.finder.where().eq("name", "インターネット広告営業").findUnique();
        assertThat(jobType.id).isNotNull();
        EventGroup eventGroup = new EventGroup();
        eventGroup.jobType = jobType;
        eventGroup.name = "テストイベントグループ";
        eventGroup.type = 1; // test
        eventGroup.save();
        assertThat(eventGroup.id).isNotNull();
        
        Venue venue = Venue.finder.where().eq("name", "マークシティ").findUnique();
        assertThat(venue.id).isNotNull();
        
        Employee employee = Employee.finder.where().eq("name", "宮嶋雅文").findUnique();
        
        Company company = Company.finder.where().eq("name", "株式会社サイバーエージェント").findUnique();

        ComplexGroup complexGroup = new ComplexGroup();
        complexGroup.company = company;
        complexGroup.employee = employee;
        complexGroup.name = "テストのグループ名";
        complexGroup.conditonSchoolDivision = 9;
        complexGroup.save();
        assertThat(complexGroup.id).isNotNull();
        
        models.Event event = new models.Event();
        event.eventGroup = eventGroup;
        event.cancelable = false;
        event.delflag = false;
        event.enqueteCode = "test";
        event.enqueteUrl = "http://test...../";
        event.message = "test";
        event.modifiable = true;
        event.name = "仮のイベント";
        event.receptionFrom = new java.util.Date(System.currentTimeMillis());
        event.stepName = "仮";
        event.complexGroup = complexGroup;
        event.save();
        assertThat(event.id).isNotNull();
        
        EventSchedule eventSchedule = new EventSchedule();
        eventSchedule.capacitySum = 5;
        eventSchedule.capacityFemale = 2;
        eventSchedule.capacityMale = 3;
        eventSchedule.cybozuEventid = 9L;
        eventSchedule.dateTime = new java.util.Date(tommorow.getMillis());
        eventSchedule.event = event;
        eventSchedule.groupid = 9;
        eventSchedule.receptionFrom = new java.util.Date(System.currentTimeMillis());
        eventSchedule.receptionTo = new java.util.Date(System.currentTimeMillis() + 1000L);
        eventSchedule.venue = venue;
        eventSchedule.timeMinute = 40;
        eventSchedule.save();
        assertThat(eventGroup.id).isNotNull();
        
        EntryUserEventSchedule entryUserEventSchedule = new EntryUserEventSchedule();
        entryUserEventSchedule.cancelFlag = false;
        entryUserEventSchedule.eventSchedule = eventSchedule;
        entryUserEventSchedule.entryUser = entryUser;
        entryUserEventSchedule.attendance = true;
        entryUserEventSchedule.evaluation = 9;
        entryUserEventSchedule.selectionResult = 9;
        entryUserEventSchedule.save();
        assertThat(entryUserEventSchedule.id).isNotNull();
        
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getActivity();
        
        assertThat(result.get("noContactOver2week")).isEqualTo(false);
        assertThat(result.get("notDoneInquiryCount")).isEqualTo(0);
        assertThat(result.get("vacantInterviewNextDay")).isEqualTo(true);
    }
    
    @Test
    public void testGetActivity006() {
        
        // 明日、定員に達している（キャンセルなし）
        
        // 仕込み
        DateTime tommorow = DateTime.now().plusDays(1);
        
        // 前提データ準備
        EntryUser entryUser =
                EntryUser.finder.where().eq("email", "shinjuku-test@test.local").findUnique();
        assertThat(entryUser.lastName).isEqualTo("新宿");

        JobType jobType = JobType.finder.where().eq("name", "インターネット広告営業").findUnique();
        assertThat(jobType.id).isNotNull();
        EventGroup eventGroup = new EventGroup();
        eventGroup.jobType = jobType;
        eventGroup.name = "テストイベントグループ";
        eventGroup.type = 1; // test
        eventGroup.save();
        assertThat(eventGroup.id).isNotNull();
        
        Venue venue = Venue.finder.where().eq("name", "マークシティ").findUnique();
        assertThat(venue.id).isNotNull();
        
        Employee employee = Employee.finder.where().eq("name", "宮嶋雅文").findUnique();
        
        Company company = Company.finder.where().eq("name", "株式会社サイバーエージェント").findUnique();

        ComplexGroup complexGroup = new ComplexGroup();
        complexGroup.company = company;
        complexGroup.employee = employee;
        complexGroup.name = "テストのグループ名";
        complexGroup.conditonSchoolDivision = 9;
        complexGroup.save();
        assertThat(complexGroup.id).isNotNull();
        
        models.Event event = new models.Event();
        event.eventGroup = eventGroup;
        event.cancelable = false;
        event.delflag = false;
        event.enqueteCode = "test";
        event.enqueteUrl = "http://test...../";
        event.message = "test";
        event.modifiable = true;
        event.name = "仮のイベント";
        event.receptionFrom = new java.util.Date(System.currentTimeMillis());
        event.stepName = "仮";
        event.complexGroup = complexGroup;
        event.save();
        assertThat(event.id).isNotNull();
        
        EventSchedule eventSchedule = new EventSchedule();
        eventSchedule.capacitySum = 1;
        eventSchedule.capacityFemale = 0;
        eventSchedule.capacityMale = 1;
        eventSchedule.cybozuEventid = 9L;
        eventSchedule.dateTime = new java.util.Date(tommorow.getMillis());
        eventSchedule.event = event;
        eventSchedule.groupid = 9;
        eventSchedule.receptionFrom = new java.util.Date(System.currentTimeMillis());
        eventSchedule.receptionTo = new java.util.Date(System.currentTimeMillis() + 1000L);
        eventSchedule.venue = venue;
        eventSchedule.timeMinute = 40;
        eventSchedule.save();
        assertThat(eventGroup.id).isNotNull();
        
        EntryUserEventSchedule entryUserEventSchedule = new EntryUserEventSchedule();
        entryUserEventSchedule.cancelFlag = false;
        entryUserEventSchedule.eventSchedule = eventSchedule;
        entryUserEventSchedule.entryUser = entryUser;
        entryUserEventSchedule.attendance = true;
        entryUserEventSchedule.evaluation = 9;
        entryUserEventSchedule.selectionResult = 9;
        entryUserEventSchedule.save();
        assertThat(entryUserEventSchedule.id).isNotNull();
        
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getActivity();
        
        assertThat(result.get("noContactOver2week")).isEqualTo(false);
        assertThat(result.get("notDoneInquiryCount")).isEqualTo(0);
        assertThat(result.get("vacantInterviewNextDay")).isEqualTo(false);
    }
    
    @Test
    public void testGetActivity007() {
        
        // 明日、定員に達していない（キャンセルあり）
        
        // 仕込み
        DateTime tommorow = DateTime.now().plusDays(1);
        
        // 前提データ準備
        EntryUser entryUser =
                EntryUser.finder.where().eq("email", "shinjuku-test@test.local").findUnique();
        assertThat(entryUser.lastName).isEqualTo("新宿");

        JobType jobType = JobType.finder.where().eq("name", "インターネット広告営業").findUnique();
        assertThat(jobType.id).isNotNull();
        EventGroup eventGroup = new EventGroup();
        eventGroup.jobType = jobType;
        eventGroup.name = "テストイベントグループ";
        eventGroup.type = 1; // test
        eventGroup.save();
        assertThat(eventGroup.id).isNotNull();
        
        Venue venue = Venue.finder.where().eq("name", "マークシティ").findUnique();
        assertThat(venue.id).isNotNull();
        
        Employee employee = Employee.finder.where().eq("name", "宮嶋雅文").findUnique();
        
        Company company = Company.finder.where().eq("name", "株式会社サイバーエージェント").findUnique();

        ComplexGroup complexGroup = new ComplexGroup();
        complexGroup.company = company;
        complexGroup.employee = employee;
        complexGroup.name = "テストのグループ名";
        complexGroup.conditonSchoolDivision = 9;
        complexGroup.save();
        assertThat(complexGroup.id).isNotNull();
        
        models.Event event = new models.Event();
        event.eventGroup = eventGroup;
        event.cancelable = false;
        event.delflag = false;
        event.enqueteCode = "test";
        event.enqueteUrl = "http://test...../";
        event.message = "test";
        event.modifiable = true;
        event.name = "仮のイベント";
        event.receptionFrom = new java.util.Date(System.currentTimeMillis());
        event.stepName = "仮";
        event.complexGroup = complexGroup;
        event.save();
        assertThat(event.id).isNotNull();
        
        EventSchedule eventSchedule = new EventSchedule();
        eventSchedule.capacitySum = 1;
        eventSchedule.capacityFemale = 0;
        eventSchedule.capacityMale = 1;
        eventSchedule.cybozuEventid = 9L;
        eventSchedule.dateTime = new java.util.Date(tommorow.getMillis());
        eventSchedule.event = event;
        eventSchedule.groupid = 9;
        eventSchedule.receptionFrom = new java.util.Date(System.currentTimeMillis());
        eventSchedule.receptionTo = new java.util.Date(System.currentTimeMillis() + 1000L);
        eventSchedule.venue = venue;
        eventSchedule.timeMinute = 40;
        eventSchedule.save();
        assertThat(eventGroup.id).isNotNull();
        
        EntryUserEventSchedule entryUserEventSchedule = new EntryUserEventSchedule();
        entryUserEventSchedule.cancelFlag = true;
        entryUserEventSchedule.eventSchedule = eventSchedule;
        entryUserEventSchedule.entryUser = entryUser;
        entryUserEventSchedule.attendance = true;
        entryUserEventSchedule.evaluation = 9;
        entryUserEventSchedule.selectionResult = 9;
        entryUserEventSchedule.save();
        assertThat(entryUserEventSchedule.id).isNotNull();
        
        
        DashBoardService service = DashBoardService.getInstance();
        Map<String,Object> result = service.getActivity();
        
        assertThat(result.get("noContactOver2week")).isEqualTo(false);
        assertThat(result.get("notDoneInquiryCount")).isEqualTo(0);
        assertThat(result.get("vacantInterviewNextDay")).isEqualTo(true);
    }
    
    
    


}
