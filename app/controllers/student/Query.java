/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.student;

import static play.data.Form.*;
import models.services.QueryService;
import controllers.forms.QueryForm;
import play.data.Form;
import play.mvc.*;
import utils.AppLogUtil;
import views.html.student.query;
import views.html.student.queryform;
import views.html.student.queryconfirm;
import base.*;

/**
 * お問い合わせページのコントローラ.
 * @author A13413
 */
public final class Query extends Controller {

    /**
     * TODO 削除予定 ユーザIDのとり方決まれば削除.
     */
    static Long entryUserId = 1L;

    /**
     * お問い合せ画面を表示する.
     * @return 処理結果
     */
    @SaiyoAcl(roles = {SaiyoRoles.ACCESSIBLE })
    public static Result index() {
        Form<QueryForm> queryForm = form(QueryForm.class);
        return ok(query.render(queryForm));
    }

    /**
     * お問い合わせ画面フォームを表示する.
     * @return 処理結果
     */
    @SaiyoAcl(roles = {SaiyoRoles.ACCESSIBLE })
    public static Result view() {
        Form<QueryForm> queryForm = form(QueryForm.class);
        // お問い合わせ送信フォームを表示
        return ok(queryform.render(queryForm));
    }

    /**
     * お問い合わせ確認画面の表示を行う.
     * @return 処理結果
     */
    @SaiyoAcl(roles = {SaiyoRoles.ACCESSIBLE })
    public static Result confirm() {
        Form<QueryForm> queryForm = form(QueryForm.class).bindFromRequest();

        // 入力チェックがエラーの場合は元の画面に遷移
        if (queryForm.hasErrors()) {
            AppLogUtil.debug("--validation Error");
            return badRequest(queryform.render(queryForm));
        }

        // 問題なければ、画面遷移
        return ok(queryconfirm.render(queryForm));
    }

    /**
     * お問い合わせ送信を行う.
     * @return 処理結果
     */
    @SaiyoAcl(roles = {SaiyoRoles.ACCESSIBLE })
    public static Result send() {
        // 入力チェックは既に終わっているから、以下のソースは不要。。。？
        Form<QueryForm> queryForm = form(QueryForm.class).bindFromRequest();
        if (queryForm.hasErrors()) {
            return badRequest(queryform.render(queryForm));
        }

        // 送られてきた内容でDB保存
        QueryService service = new QueryService();
        service.inquirySave(queryForm);
        // フォーム内容をきれいにして終了
        queryForm = form(QueryForm.class);

        // 完了画面へ遷移
        // TODO メッセージ：お問い合わせの送信
        session(Application.COMPLETED_MESSAGE, "お問い合わせの送信");
        return redirect(routes.Application.completed());
    }
}
