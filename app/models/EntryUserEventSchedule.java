package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * エントリユーザのイベント日程
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class EntryUserEventSchedule extends Model {

    public static Finder<Long, EntryUserEventSchedule> finder = new Finder<Long, EntryUserEventSchedule>(Long.class,
            EntryUserEventSchedule.class);
    
    @Id
    public Long id;

    /**
     * -> エントリユーザ.エントリユーザID
     */
    @ManyToOne
    @JoinColumn(name = "entry_userid")
    @NotNull
    public EntryUser entryUser;

    /**
     * -> イベント日程.イベント日程ID
     */
    @ManyToOne
    @JoinColumn(name = "event_scheduleid")
    @NotNull
    public EventSchedule eventSchedule;

    /**
     * 出席状態
     */
    @NotNull
    public Boolean attendance;

    /**
     * 選考結果
     */
    public Integer selectionResult;

    /**
     * テーブル番号
     */
    public Integer tableNumber;

    /**
     * 評価
     */
    public Integer evaluation;
    
    /**
     * キャンセルフラグ
     */
    @NotNull
    public boolean cancelFlag;
    
    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
