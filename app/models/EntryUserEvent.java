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
 * エントリユーザのイベント情報
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class EntryUserEvent extends Model {

    public static Finder<Long, EntryUserEvent> finder = new Finder<Long, EntryUserEvent>(Long.class,
            EntryUserEvent.class);
    
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
     * -> エントリユーザ.エントリユーザID
     */
    @ManyToOne
    @JoinColumn(name = "entry_userid")
    @NotNull
    public EntryUser entryUser;

    /**
     * 選考状況
     */
    @NotNull
    public Integer eventStatus;

    /**
     * 実施状態
     */
    @NotNull
    public Boolean enqueteStatus;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
