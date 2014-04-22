package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * イベント情報
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"next_eventid"}))
public class Event extends Model {

    public static Finder<Long, Event> finder = new Finder<Long, Event>(Long.class, Event.class);

    @Id
    public Long id;

    /**
     * -> イベントグループ.イベントグループID
     */
    @ManyToOne
    @JoinColumn(name = "event_groupid")
    public EventGroup eventGroup;

    /**
     * -> イベント情報.次のイベントID
     */
    @ManyToOne
    @JoinColumn(name = "next_eventid")
    public Event event;

    /**
     * -> グループ.グループID
     */
    @ManyToOne
    @JoinColumn(name = "groupid")
    @NotNull
    public ComplexGroup complexGroup;

    /**
     * アンケート埋め込みコード
     */
    @NotNull
    @Column(length = 2048)
    public String enqueteCode;

    /**
     * アンケートのURL
     */
    @NotNull
    @Column(length = 1024)
    public String enqueteUrl;

    /**
     * 削除フラグ
     */
    @NotNull
    public Boolean delflag;

    /**
     * イベント紹介メッセージ
     */
    @Column(length = 3000)
    public String message;

    /**
     * キャンセルの許可
     */
    @NotNull
    public Boolean cancelable;

    /**
     * 変更の許可
     */
    @NotNull
    public Boolean modifiable;

    /**
     * 受付／表示終了日時
     */
    public java.util.Date receptionTo;

    /**
     * 受付／表示開始日時
     */
    @NotNull
    public java.util.Date receptionFrom;

    /**
     * ステップ名
     */
    @NotNull
    @Column(length = 20)
    public String stepName;

    /**
     * イベント名
     */
    @NotNull
    @Column(length = 20)
    public String name;
    
    
    /**
     * <- イベント日程
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    public List<EventSchedule> eventSchedules;
    
    /**
     * <- 追加メッセージ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    public List<AdditionalText> additionalTexts;
    
    /**
     * <- グループのイベント条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    public List<GroupConditionEvent> groupConditionEvents;
    
    /**
     * <- 前のイベント
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    public List<Event> prevEvents;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
