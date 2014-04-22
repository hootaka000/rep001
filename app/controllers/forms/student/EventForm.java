/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
*/
package controllers.forms.student;

import java.util.List;

import models.AdditionalText;
import models.EventSchedule;
import models.Transportation;
import models.services.student.EventService;
/**
 * @author B05138
 *
 */
public class EventForm {

    // イベント申込
    /** イベントID. */
    public Long eventId;

    /** イベント名. */
    public String eventName;

    /** ユーザ名 . */
    public String entryUserName;

    /** ユーザID.  */
    // TODO いらないかも。
    public Long entryUserId;

    // TODO いらないかも。
    /** 応募者ID.  */
    public String entryUserIdEmail;

    /** イベント日程ID. */
    public Long eventScheduleId;

    /** 開催日.  */
    public String eventDate;

    /** 開催時間.  */
    public String eventTime;

    /** 会場名. */
    public String eventVenueName;

    /** 会場住所. */
    public String eventVenueAddress;

    /** 問い合わせ. */
    public String eventContact;

    /** 交通. */
    public List<Transportation> eventTrans;

    /** 交通カウント. */
    // TODO いらないかも。
    public int eventTransCount;

    /** 追加メッセージ. */
    public List<AdditionalText> eventAddTexts;

    /** イベント日程. */
    public List<EventSchedule> eventScheduleList;

    /** メッセージ. */
    public String message;

    /**
     * .
     * @return string
     */
    public String validate() {
        EventSchedule es = new EventService().findEventSchedule(eventScheduleId);

        System.out.println("--------Form/id：" + es.id);
        System.out.println("--------Form/定員：" + es.capacitySum);
        // TODO ここでやれそう。おそらく次ページに遷移して何らかのメッセージを出すのかと思ふ。

/*        if (es == null) {
            return "メールアドレスまたはパスワードが間違っています。";
        }*/
        //message = "定員数に達しました。別日に調整おなしゃ～～っす";

        return null;
    }
}
