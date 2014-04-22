package controllers.admin;

import static play.data.Form.*;

import java.util.List;

import models.EntryUser;
import models.services.admin.StudentSearchService;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import base.SaiyoAcl;
import base.SaiyoRoles;
import controllers.forms.admin.StudentSearchForm;

/**
 * 学生検索コントローラー
 *
 * @author B03401
 *
 */
public class Student extends Controller {

    /**
     * 学生検索画面表示.
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result search() {
        //return TODO;
        return ok(views.html.admin.student.render(form(StudentSearchForm.class), null));
    }

    /**
     * 学生検索結果表示.
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result searchResult() {

        //検索条件フォーム
        Form<StudentSearchForm> form = form(StudentSearchForm.class).bindFromRequest();
        //検索結果を入れるリスト
        List<EntryUser> entryUserList = null;


        if (!form.hasErrors()) {

            //検索結果取得
            entryUserList = StudentSearchService.getInstance().searchStudents(form);

            return ok(views.html.admin.student.render(form, entryUserList));

        } else {
            return badRequest(views.html.admin.student.render(form, null));
        }

    }

}

