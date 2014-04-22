/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package models.services.student;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.avaje.ebean.Expr;
import com.avaje.ebean.ExpressionList;

import play.data.Form;
import utils.AppLogUtil;
import controllers.forms.student.EventForm;
import models.AdditionalText;
import models.EntryUser;
import models.EntryUserEventSchedule;
import models.Event;
import models.EventSchedule;
import models.Transportation;

/**
 * @author B05138
 *
 */
public class EventService {

    /**
     * イベント日程の一覧を検索する.
     * @param eventId イベントID
     * @param entryUserId ユーザID
     * @return List<EventForm>
     */
    public List<EventForm> getEventScheduleList(Long eventId, Long entryUserId) {
        List<EventSchedule> listEue = EventSchedule.finder.where()
                .eq("eventid", eventId)
                .orderBy("dateTime")
                .findList();

        List<EventForm> list = null;
        list = new ArrayList<EventForm>();
        for (java.util.Iterator<EventSchedule> it = listEue.iterator(); it.hasNext();) {
            EventForm form = new EventForm();
            EventSchedule e = it.next();

            // イベント日程ID
            form.eventScheduleId = e.id;
            form.eventId = eventId;
            form.entryUserId = entryUserId;

            DateFormat df = DateFormat.getDateTimeInstance();
            Calendar cal = Calendar.getInstance();
            cal.setTime(e.dateTime);

            String datetime = df.format(e.dateTime);
            String[] date = datetime.split(" ");

            // 開催日
            form.eventDate  = date[0];
            // 開催時間
            form.eventTime  = date[1].substring(0, date[1].lastIndexOf(":"));
            // 会場名
            form.eventVenueName = e.venue.name;

            StringBuffer sb = new StringBuffer();
            // 定員数がいっぱいならメッセージを格納
            if (!isCapacityCheck(e, entryUserId, e.id, 0)) {
                // TODO メッセージ：満員
                sb.append("満員");
            }

            form.message = sb.toString();

            list.add(form);
        }
        return list;
    }

    /**
     * イベント日程の情報を取得する.
     * @param eventForm form
     */
    public void getEventSchedule(Form<EventForm> eventForm) {

        // 検索の実行
        EventSchedule eventSchedule = EventSchedule.finder.where()
                .eq("id", eventForm.get().eventScheduleId)
                .findUnique();

        if (!isCapacityCheck(eventSchedule, eventForm.get().entryUserId, eventForm.get().eventScheduleId, 1)) {
            // 定員数overのメッセージを表示
            eventForm.get().message = "定員に達しています。別の日程をお選びください。";
        }

        EntryUser eu = EntryUser.finder.where()
                .eq("id", eventForm.get().entryUserId)
                .findUnique();

        // イベント名
        Event event = Event.finder.byId(eventForm.get().eventId);
        eventForm.get().eventName = event.name;
        AppLogUtil.debug("----- イベント名:" + eventSchedule.id);

        //氏名
        eventForm.get().entryUserName = eu.lastName + " " + eu.firstName;

        // 応募者ID -> emailアドレスを表示
        eventForm.get().entryUserIdEmail = eu.email;

        String[] date = splitDateTime(eventSchedule.dateTime);

        // 開催日
        AppLogUtil.debug("----- 開催日：" + date[0]);
        eventForm.get().eventDate = date[0];
        // 開催時間
        AppLogUtil.debug("----- 開催時間：" + date[1].substring(0, date[1].lastIndexOf(":")));
        eventForm.get().eventTime = date[1].substring(0, date[1].lastIndexOf(":"));

        // 会場名
        AppLogUtil.debug("----- 会場名：" + eventSchedule.venue.name);
        eventForm.get().eventVenueName = eventSchedule.venue.name;
        // 住所
        AppLogUtil.debug("----- 住所：" + eventSchedule.venue.address);
        eventForm.get().eventVenueAddress = eventSchedule.venue.address;

        // 問い合わせ
        AppLogUtil.debug("----- 問い合わせ：" + eventSchedule.venue.contact);
        eventForm.get().eventContact = eventSchedule.venue.contact;

        // 交通
        eventForm.get().eventTrans = eventSchedule.venue.transportations;
        eventForm.get().eventTransCount = eventForm.get().eventTrans.size();
        for (java.util.Iterator<Transportation> it = eventForm.get().eventTrans.iterator(); it.hasNext();) {
            Transportation t = it.next();
            AppLogUtil.debug("----- 交通：" + t.name);
        }

        // 追加メッセージ
        eventForm.get().eventAddTexts = eventSchedule.event.additionalTexts;
        List<AdditionalText> addTests = eventSchedule.event.additionalTexts;
        for (java.util.Iterator<AdditionalText> it = addTests.iterator(); it.hasNext();) {
            AdditionalText a = it.next();
            AppLogUtil.debug("----- メッセージ：" + a.title + "｜" + a.message);
         }

        eventForm.get().eventScheduleId = eventSchedule.id;
        AppLogUtil.debug("----- 日程ID:" + eventSchedule.id);
    }

    /**
     * 予約済のイベントかチェックする.
     * @param entryUserId ユーザID
     * @param eventId イベントID
     * @return boolean
     */
    public boolean isReserved(Long entryUserId, Long eventId) {
        boolean flg = false; //未予約
        int iReserveCount = EntryUserEventSchedule.finder.where()
                .eq("entryUser.id", entryUserId)
                .eq("eventSchedule.event.id", eventId)
                .findRowCount();
        if (iReserveCount != 0) {
            flg = true;
        }
        return flg;
    }

    /**
     * 予約済イベント日程の情報を取得する.
     * @param entryUserId ユーザID
     * @param eventId イベントID
     * @param eventForm form
     */
    public void getEntryUserEventSchedule(Long entryUserId, Long eventId, Form<EventForm> eventForm) {
        EntryUserEventSchedule eues = EntryUserEventSchedule.finder.where()
                .eq("entryUser.id", entryUserId)
                .eq("eventSchedule.event.id", eventId)
                .findUnique();

        if (eues.cancelFlag) {
            // TODO メッセージ：キャンセル済のイベントです。
            eventForm.get().message = "すでにキャンセルされたイベントです。";
        }

        //氏名
        EntryUser eu = EntryUser.finder.where()
                .eq("id", eventForm.get().entryUserId)
                .findUnique();

        eventForm.get().entryUserName =  eu.lastName + " " + eu.firstName;

        // 応募者ID -> emailアドレスを表示
        eventForm.get().entryUserIdEmail = eu.email;

        String[] date = splitDateTime(eues.eventSchedule.dateTime);
        // 開催日
        eventForm.get().eventDate = date[0];

        // 開催時間
        eventForm.get().eventTime = date[1].substring(0, date[1].lastIndexOf(":"));

        // 会場名
        eventForm.get().eventVenueName = eues.eventSchedule.venue.name;
        // 住所
        eventForm.get().eventVenueAddress = eues.eventSchedule.venue.address;
        // 問い合わせ
        eventForm.get().eventContact = eues.eventSchedule.venue.contact;
        // 交通
        eventForm.get().eventTrans = eues.eventSchedule.venue.transportations;
        eventForm.get().eventTransCount = eventForm.get().eventTrans.size();

        // 追加メッセージ
        eventForm.get().eventAddTexts = eues.eventSchedule.event.additionalTexts;

        // 日程ID
        eventForm.get().eventScheduleId = eues.eventSchedule.id;

        // イベント名
        Event event = Event.finder.byId(eventForm.get().eventId);
        eventForm.get().eventName = event.name;
    }

    /**
     * イベント情報を登録する.
     * @param eventForm form
     */
    public void registUserEventSchedule(Form<EventForm> eventForm) {
        EntryUserEventSchedule eus = new EntryUserEventSchedule();

        // 外部キー設定用のmodelをnewする
        EventSchedule es = new EventSchedule();

        // 外部キーに該当するエントリーIDに値をセットし、そのままmodelをセット
        es.id = eventForm.get().eventScheduleId;
        eus.eventSchedule = es;

        // 外部キー設定用のmodelをnewする
        EntryUser entryUser = new EntryUser();

        // 外部キーに該当するエントリーIDに値をセットし、そのままmodelをセット
        entryUser.id = eventForm.get().entryUserId;
        eus.entryUser = entryUser;

        // 出席状況
        eus.attendance = false;

        eus.save();
    }

    /**
     * イベント情報をキャンセルする.
     * @param eventForm form
     */
    public void cancelUserEventSchedule(Form<EventForm> eventForm) {
        EntryUserEventSchedule eus = EntryUserEventSchedule.finder.where()
                .eq("entryUser.id", eventForm.get().entryUserId)
                .eq("eventSchedule.id", eventForm.get().eventScheduleId)
                .findUnique();

        // キャンセルフラグ
        eus.cancelFlag = true;

        eus.update();
    }


    /**
     * 定員数のチェックを行う.
     * @param eventSchedule form
     * @param entryUserId ユーザID
     * @param eventScheduleId イベント日程ID
     * @param number 参加予定人数
     * @return boolean
     */
    public boolean isCapacityCheck(EventSchedule eventSchedule, Long entryUserId, Long eventScheduleId, int number) {
        boolean flag = true;
        // ユーザイベント日程テーブルを検索後、以下のチェックを行う。
        // 定員数チェック：男性、女性で制限がない場合は男性：0、女性:0を入力してもらう。
        // 上記の場合は、sumのみのチェックを行う。
        // 上記以外の場合は、それぞれの性別の定員数のチェックを行う。
        // パターンとしては以下
        // 1:100 0  100
        // 2:100 50 50
        // 3:100 100 0
        // 4:100 0 0
        // イベントIDで絞り込んだリストを作成
        ExpressionList<EntryUserEventSchedule> where
            = EntryUserEventSchedule.finder.where().eq("event_scheduleid", eventScheduleId);

        // イベントの人数を取得
        int scheduleCount = where.findRowCount();

        AppLogUtil.debug("☆eventScheduleId☆:" + eventScheduleId);
        AppLogUtil.debug("☆scheduleCount☆:" + scheduleCount);
        AppLogUtil.debug("☆(scheduleCount+number)☆:" + (scheduleCount + number));
        AppLogUtil.debug("☆capacitySum☆:" + eventSchedule.capacitySum);
        AppLogUtil.debug("☆capacityMale☆:" + eventSchedule.capacityMale);
        AppLogUtil.debug("☆capacityFemale☆:" + eventSchedule.capacityFemale);

        // 定員数のsumと比較
        if (eventSchedule.capacitySum == scheduleCount) {
            flag = false;
        } else {
            if (eventSchedule.capacitySum >= (scheduleCount + number)) {
                AppLogUtil.debug("☆success☆");
                if (eventSchedule.capacityMale == 0 & eventSchedule.capacityFemale == 0) {
                    // 男性：0 and 女性:0の場合はチェックしない。
                    AppLogUtil.debug("----- 男女別定員なし");
                } else {
                    // エントリーユーザの性別を取得
                    AppLogUtil.debug("----- +++++:" + entryUserId);
                    EntryUser eu = EntryUser.finder.where().eq("id", entryUserId).findUnique();
                    // 取得した性別のイベント人数を取得
                    int iSexCount = where.eq("entryUser.sex", eu.sex).findRowCount();

                    switch (eu.sex) {
                    case 0:
                        if (eventSchedule.capacityMale == iSexCount) {
                            AppLogUtil.debug("----- 定員数==(Male equal)");
                            flag = false;
                        } else {
                            if (eventSchedule.capacityMale < (iSexCount + number)) {
                                AppLogUtil.debug("----- 定員数(Male Over)");
                                flag = false;
                            }
                        }
                        break;
                    case 1:
                        if (eventSchedule.capacityFemale == iSexCount) {
                            AppLogUtil.debug("----- 定員数==(Female equal)");
                            flag = false;
                        } else {
                            if (eventSchedule.capacityFemale < (iSexCount + number)) {
                                AppLogUtil.debug("----- 定員数(Female Over)");
                                flag = false;
                            }
                        }
                        break;
                    default:
                        break;
                    }
                }
            } else {
                AppLogUtil.debug("----- 定員数(Sum Over)");
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 日付、時間の分割.
     * @param dateTime java.util.Date
     * @return String[]
     */
    public String[] splitDateTime(Date dateTime) {
        String[] date = new String[2];
        DateFormat df = DateFormat.getDateTimeInstance();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);

        String datetime = df.format(dateTime);
        date = datetime.split(" ");
        return date;
    }

    /**
     * イベント日程情報の取得.
     * @param eventScheduleId イベント日程ID
     * @return EventSchedule
     */
    public EventSchedule findEventSchedule(Long eventScheduleId) {
        ExpressionList<EventSchedule> where = EventSchedule.finder.where();
        return where.conjunction().add(Expr.eq("id", eventScheduleId)).findUnique();
    }
}
