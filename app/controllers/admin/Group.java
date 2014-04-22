package controllers.admin;

import static play.data.Form.*;

import java.util.ArrayList;
import java.util.List;

import models.ComplexGroup;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import base.SaiyoAcl;
import base.SaiyoRoles;
import controllers.forms.admin.AppYearForm;

/**
 * グループ用コントローラー
 *
 * @author B03401
 *
 */
public class Group extends Controller {

    /**
     * グループ一覧画面表示.
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result index() {

        //グループ一覧用のリスト
        List<ComplexGroup> complexGroupList = new ArrayList<ComplexGroup>();

        //return TODO;
        return ok(views.html.admin.groups.render(form(AppYearForm.class), null));
    }


    /**
     * グループ一覧取得.
     *
     * @return
     */
    @SaiyoAcl(roles = {SaiyoRoles.HR_ADMIN, SaiyoRoles.HR_STAFF})
    public static Result gainGroupList() {

        //選択した年度の取得
        Form<AppYearForm> form = form(AppYearForm.class).bindFromRequest();
        //グループ一覧用のリスト
        List<ComplexGroup> complexGroupList = null;

        if (!form.hasErrors()) {

            complexGroupList = new ArrayList<ComplexGroup>();

            return ok(views.html.admin.groups.render(form, complexGroupList));

        } else {
            return badRequest(views.html.admin.groups.render(form, null));
        }


    }
}

