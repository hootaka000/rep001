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
 * グループのイベント条件
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class GroupConditionEvent extends Model {

    public static Finder<Long, GroupConditionEvent> finder = new Finder<Long, GroupConditionEvent>(Long.class,
            GroupConditionEvent.class);
    
    @Id
    public Long id;

    /**
     * -> グループ.グループID
     */
    @ManyToOne
    @JoinColumn(name = "groupid")
    @NotNull
    public ComplexGroup complexGroup;

    /**
     * -> イベント情報.イベントID
     */
    @ManyToOne
    @JoinColumn(name = "eventid")
    @NotNull
    public Event event;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
