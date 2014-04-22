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
 * グループ条件グループ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class GroupConditionGroup extends Model {

    public static Finder<Long, GroupConditionGroup> finder = new Finder<Long, GroupConditionGroup>(Long.class,
            GroupConditionGroup.class);
    
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
    * -> グループ.条件のグループID
    */
    @ManyToOne
    @JoinColumn(name = "condition_groupid")
    @NotNull
    public ComplexGroup conditionGroup;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
