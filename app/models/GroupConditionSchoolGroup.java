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
 * グループの学校グループ条件
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class GroupConditionSchoolGroup extends Model {

    public static Finder<Long, GroupConditionSchoolGroup> finder = new Finder<Long, GroupConditionSchoolGroup>(
            Long.class, GroupConditionSchoolGroup.class);
    
    @Id
    public Long id;

    /**
     * -> 学校グループ.学校グループID
     */
    @ManyToOne
    @JoinColumn(name = "school_groupid")
    @NotNull
    public SchoolGroup schoolGroup;

    /**
     * -> グループ.グループID
     */
    @ManyToOne
    @JoinColumn(name = "groupid")
    @NotNull
    public ComplexGroup complexGroup;
    

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
