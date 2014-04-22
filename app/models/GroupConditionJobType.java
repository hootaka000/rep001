package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * グループの職種条件
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class GroupConditionJobType extends Model {

    public static Finder<Long, GroupConditionJobType> finder = new Finder<Long, GroupConditionJobType>(Long.class,
            GroupConditionJobType.class);

    /**
     * -> グループ.グループID
     */
    @ManyToOne
    @JoinColumn(name = "groupid")
    @NotNull
    public ComplexGroup complexGroup;

    /**
     * -> 職種マスタ.職種ID
     */
    @ManyToOne
    @JoinColumn(name = "job_typeid")
    @NotNull
    public JobType jobType;

    /**
     * 辞退者条件
     */
    @NotNull
    public Boolean refusal;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
