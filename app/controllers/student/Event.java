/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.student;

import static play.data.Form.form;
import controllers.forms.student.EventForm;
import models.services.student.EventService;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import base.SaiyoAcl;
import base.SaiyoRoles;
import utils.AppLogUtil;
import views.html.student.event.*;

/**
 * @author B05138
 *
 */
public final class Event extends Controller {

    /**
     * 削除予定 ユーザIDのとり方決まれば削除.
     */
    static Long entryUserId = 1L;

    /**
     * イベント申込/確認画面を表示する.
     * @param eventId イベントID
     * @return Result
     */
    @SaiyoAcl(roles = {SaiyoRoles.NEW_GRADUATE })
    public static Result index(Long eventId) {
        EventForm eventForm = new EventForm();

        // イベントIDをセット
        eventForm.eventId = eventId;
        // ユーザIDをセット
        eventForm.entryUserId = entryUserId;

        EventService service = new EventService();
        // ここで、EntryUserEventScheduleでデータの確認を行う。
        // 引数でもらったイベントIDについて申込済であれば、イベント確認画面に遷移
        if (service.isReserved(entryUserId, eventId)) {
            // 予約済なら、確認画面に遷移

            // ユーザ日程スケジュールから情報を取得
            service.getEntryUserEventSchedule(entryUserId, eventId, form(EventForm.class).fill(eventForm));

            return ok(eventview.render(form(EventForm.class).fill(eventForm)));
        } else {
            // 申込がされていなければ、日程一覧に遷移

            // イベント情報のリストを取得
            return ok(evententry.render(service.getEventScheduleList(eventId, eventForm.entryUserId)));
        }
    }

    /**
     * イベント申込確認画面を表示する.
     * @return 処理結果Long eventId
     */
    @SaiyoAcl(roles = {SaiyoRoles.NEW_GRADUATE })
    public static Result confirm() {
        Form<EventForm> eventForm = form(EventForm.class).bindFromRequest();

        AppLogUtil.debug("+++++ :" + eventForm.get().entryUserId);
        AppLogUtil.debug("+++++ :" + eventForm.get().eventId);
        AppLogUtil.debug("+++++ :" + eventForm.get().eventScheduleId);

        if (eventForm.hasErrors()) {
            return badRequest(eventview.render(eventForm));
        }

        // 一覧から押下されたイベントIDをキーに申込確認画面に遷移する。
        EventService service = new EventService();
        service.getEventSchedule(eventForm);

        return ok(eventconfirm.render(eventForm));
    }

    /**
     * イベント申込を登録する.
     * @return 処理結果
     */
    @SaiyoAcl(roles = {SaiyoRoles.NEW_GRADUATE })
    public static Result register() {
        Form<EventForm> eventForm = form(EventForm.class).bindFromRequest();

        // イベント申込を登録する。
        EventService service = new EventService();
        service.registUserEventSchedule(eventForm);

        // TODO メッセージ：イベント申込が完了しました。
        session(Application.COMPLETED_MESSAGE, "イベント申込");
        return redirect(routes.Application.completed());
    }

/*    *//**
     * .
     * @return 処理結果
     *//*
    @SaiyoAcl(roles = {SaiyoRoles.NEW_GRADUATE })
    public static Result view() {
        // このactionいらないかも。。。
        System.out.println("***** view *****");
        return TODO;
        //ok(eventview.render());
    }*/

    /**
     * イベントキャンセル確認画面を表示する.
     * @return 処理結果
     */
    @SaiyoAcl(roles = {SaiyoRoles.NEW_GRADUATE })
    public static Result confirmCancel() {
        Form<EventForm> eventForm = form(EventForm.class).bindFromRequest();

        EventService service = new EventService();
        service.getEntryUserEventSchedule(entryUserId, eventForm.get().eventId, eventForm);

        return ok(eventcancel.render(eventForm));
    }

    /**
     * イベントのキャンセルを登録する.
     * @return 処理結果
     */
    @SaiyoAcl(roles = {SaiyoRoles.NEW_GRADUATE })
    public static Result cancel() {
        Form<EventForm> eventForm = form(EventForm.class).bindFromRequest();

        EventService service = new EventService();
        service.cancelUserEventSchedule(eventForm);

        // TODO メッセージ：イベント予約をキャンセルしました。
        session(Application.COMPLETED_MESSAGE, "イベント予約のキャンセルしました。");
        return redirect(routes.Application.completed());
    }
}
