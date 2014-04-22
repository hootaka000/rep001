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
 * 学校グループ条件
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class SchoolGroupCondition extends Model {

    public static Finder<Long, SchoolGroupCondition> finder = new Finder<Long, SchoolGroupCondition>(Long.class,
            SchoolGroupCondition.class);
    
    @Id
    public Long id;

    /**
     * -> 学科マスタ.学科ID
     */
    @ManyToOne
    @JoinColumn(name = "school_subjectid")
    public SchoolSubject schoolSubject;

    /**
     * -> 学部マスタ.学部ID
     */
    @ManyToOne
    @JoinColumn(name = "school_departmentid")
    public SchoolDepartment schoolDepartment;

    /**
     * -> 学校マスタ.学校ID
     */
    @ManyToOne
    @JoinColumn(name = "schoolid")
    public School school;

    /**
     * -> 学校グループ.学校グループID
     */
    @ManyToOne
    @JoinColumn(name = "school_groupid")
    @NotNull
    public SchoolGroup schoolGroup;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
