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
 * エントリユーザのコメント
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class EntryUserComments extends Model {

    public static Finder<Long, EntryUserComments> finder = new Finder<Long, EntryUserComments>(Long.class,
            EntryUserComments.class);
    
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
     * -> コメント.コメントID
     */
    @ManyToOne
    @JoinColumn(name = "commentsid")
    @NotNull
    public Comments comments;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
