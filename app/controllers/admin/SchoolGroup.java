package controllers.admin;

import static play.data.Form.*;

import java.util.ArrayList;
import java.util.List;

import models.services.admin.StudentSearchService;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import base.SaiyoAcl;
import base.SaiyoRoles;
import controllers.forms.admin.AppYearForm;
import controllers.forms.admin.SchoolSearchForm;

/**
 * 大学グループ用コントローラー
 *
 * @author B03401
 *
 */
public class SchoolGroup extends Controller {

    /**
     * 大学グループ一覧画面表示.
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result index() {

        //return TODO;
        return ok(views.html.admin.schoolgroups.render(form(AppYearForm.class), null));
    }


    /**
     * 大学グループ一覧取得.
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result gainSchoolGroups() {

        //選択した年度の取得
        Form<AppYearForm> form = form(AppYearForm.class).bindFromRequest();
        //グループ一覧用のリスト
        List<models.SchoolGroup> schoolGroupList = null;

        if (!form.hasErrors()) {

            //仮の値
            schoolGroupList = new ArrayList<models.SchoolGroup>();

            return ok(views.html.admin.schoolgroups.render(form, schoolGroupList));

        } else {
            return badRequest(views.html.admin.schoolgroups.render(form, schoolGroupList));
        }
    }


    /**
     * 大学グループ登録画面(初期表示).
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result newSchoolGroup() {

        //グループ一覧用のリスト
        List<models.SchoolGroup> schoolGroupList = new ArrayList<models.SchoolGroup>();

        //return TODO;
        return ok(views.html.admin.schoolgroupnew.render(form(SchoolSearchForm.class), null));
    }

    /**
     * 大学検索.
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result searchSchool() {

        //大学検索条件フォーム
        Form<SchoolSearchForm> form = form(SchoolSearchForm.class).bindFromRequest();
        //検索結果を入れるリスト
        //List<SchoolSearchForm> schoolSearchFormList = null;
        SchoolSearchForm ssf = new SchoolSearchForm();

        if (!form.hasErrors()) {

            //検索結果取得
            ssf.schoolSearchList = StudentSearchService.getInstance().searchSchools(form);

            //schoolSearchFormList = new ArrayList<SchoolSearchForm>();

            return ok(views.html.admin.schoolgroupnew.render(form, ssf));

        } else {
            return badRequest(views.html.admin.schoolgroupnew.render(form, null));
        }
    }

    /**
     * 大学グループ確認画面表示.
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result confirm() {

        //選択した年度の取得
        Form<SchoolSearchForm> form = form(SchoolSearchForm.class).bindFromRequest();
        //グループ一覧用のリスト
        //SchoolSearchForm ssf = new SchoolSearchForm();

        String name = form.get().schoolGroupName;


        if (!form.hasErrors()) {

            //ssf.schoolSearchList = form.get().schoolSearchList;

            //return TODO;
            return ok(views.html.admin.schoolgroupconfirm.render(form));

        } else {
            //return TODO;
            return badRequest(views.html.admin.schoolgroupconfirm.render(null));
        }
    }

    /**
     * 大学グループ登録.
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result register() {

        //選択した年度の取得
        Form<SchoolSearchForm> form = form(SchoolSearchForm.class).bindFromRequest();
        //グループ一覧用のリスト
        //SchoolSearchForm ssf = new SchoolSearchForm();


        if (!form.hasErrors()) {

            //ssf.schoolSearchList = form.get().schoolSearchList;

            //return TODO;
            return ok(views.html.admin.schoolgroupconfirm.render(null));

        } else {
            //return TODO;
            return badRequest(views.html.admin.schoolgroupconfirm.render(null));
        }
    }
}

