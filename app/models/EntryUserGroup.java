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
 * グループに属するエントリユーザ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class EntryUserGroup extends Model {

    public static Finder<Long, EntryUserGroup> finder = new Finder<Long, EntryUserGroup>(Long.class,
            EntryUserGroup.class);
    
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
     * -> グループ.グループID
     */
    @ManyToOne
    @JoinColumn(name = "groupid")
    /**
     * <- エントリユーザのイベント情報
     */
    @NotNull
    public ComplexGroup complexGroup;

    /**
     * 固定
     */
    @NotNull
    public Boolean fixation;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
