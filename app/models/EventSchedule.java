package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * イベント日程
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class EventSchedule extends Model {

    public static Finder<Long, EventSchedule> finder = new Finder<Long, EventSchedule>(Long.class, EventSchedule.class);

    @Id
    public Long id;

    /**
     * -> イベント情報.イベントID
     */
    @ManyToOne
    @JoinColumn(name = "eventid")
    @NotNull
    public Event event;

    /**
     * -> 会場情報マスタ.会場ID
     */
    @ManyToOne
    @JoinColumn(name = "venueid")
    @NotNull
    public Venue venue;

    /**
     * グループID
     */
    @NotNull
    public Integer groupid;

    /**
     * 開催日時
     */
    @NotNull
    public java.util.Date dateTime;

    /**
     * 定員（全体）
     */
    @NotNull
    public Integer capacitySum;
    
    /**
     * 定員（男性）
     */
    @NotNull
    public Integer capacityMale;
    
    /**
     * 定員（女性）
     */
    @NotNull
    public Integer capacityFemale;
    
    /**
     * サイボウズのイベントID
     */
    public Long cybozuEventid;

    /**
     * 予約受付終了日時
     */
    @NotNull
    public java.util.Date receptionTo;

    /**
     * 所要時間（分）
     */
    @NotNull
    public Integer timeMinute;

    /**
     * 予約受付開始日時
     */
    @NotNull
    public java.util.Date receptionFrom;
    
    /**
     * <- エントリユーザのイベント情報
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventSchedule")
    public List<EntryUserEventSchedule> entryUserEventSchedules;
    
    /**
     * <- イベント日程関係社員
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventSchedule")
    public List<EventScheduleEmployee> eventScheduleEmployees;
    

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
