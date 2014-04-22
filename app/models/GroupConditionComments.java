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
 * グループのコメント条件
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class GroupConditionComments extends Model {

    public static Finder<Long, GroupConditionComments> finder = new Finder<Long, GroupConditionComments>(Long.class,
            GroupConditionComments.class);
    
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
