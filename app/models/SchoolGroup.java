package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 学校グループ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class SchoolGroup extends Model {

    public static Finder<Long, SchoolGroup> finder = new Finder<Long, SchoolGroup>(Long.class, SchoolGroup.class);

    @Id
    public Long id;

    /**
     * グループ名
     */
    @NotNull
    @Column(length = 128, unique = true)
    public String name;
    
    /**
     * <- 学校グループのメールログ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolGroup")
    public List<SchoolGroupMailLog> schoolGroupMailLogs;
    
    /**
     * <- 学校グループ条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolGroup")
    public List<SchoolGroupCondition> schoolGroupConditions;
    
    /**
     * <- グループの学校グループ条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolGroup")
    public List<GroupConditionSchoolGroup> groupConditionSchoolGroups;

    @Version
    public Long lockVersion;
    
    @UpdatedTimestamp
    public java.util.Date updatedAt;
}
