package controllers.admin;

import static play.data.Form.form;

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

import org.joda.time.DateTime;

import com.avaje.ebean.annotation.Transactional;

import models.EventScheduleEmployee;
import models.services.DashBoardService;
import play.db.DB;
import play.libs.Json;
import play.mvc.Result;
import utils.AppLogUtil;
import base.SaiyoAcl;
import base.SaiyoException;
import base.SaiyoRoles;
import controllers.forms.admin.IndexForm;

/**
 * ダッシュボード他、共通的管理機能を伴う、コントローラ
 * @author masafumi
 */
public class Administrator extends AdminSecuredController {

    /**
     * ダッシュボード表示
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result index() {
        return ok(views.html.admin.administrator.index.render(form(IndexForm.class)));
    }
    
    /**
     * アクティビティ表示
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result dashBoardActivity() {
        DashBoardService service = DashBoardService.getInstance();
        Map<String, Object> result = service.getActivity();
        return ok(Json.toJson(result));
    }
    
    /**
     * スケジュール表示
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result dashBoardSchedule() {
        DashBoardService service = DashBoardService.getInstance();
        Map<String, Object> result = service.getSchedule();
        return ok(Json.toJson(result));
    }
    
    /**
     * ラップ表示
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result dashBoardLap(String empNo, Integer monthTerm) {
        AppLogUtil.debug("empNo:" + empNo);
        AppLogUtil.debug("monthTerm:" + monthTerm);
        DashBoardService service = DashBoardService.getInstance();
        Map<String, Object> result = service.getLap(empNo, monthTerm);
        return ok(Json.toJson(result));
    }
    
    /**
     * イベント表示
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result dashBoardEvent(Long jobTypeId, Long eventGroupId) {
        AppLogUtil.debug("jobTypeId:" + jobTypeId);
        AppLogUtil.debug("eventGroupId:" + eventGroupId);
        DashBoardService service = DashBoardService.getInstance();
        Map<String, Object> result = service.getEvent(jobTypeId, eventGroupId);
        return ok(Json.toJson(result));
    }
    
    
    
}
