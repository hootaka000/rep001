package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.Encrypted;
import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 学部マスタ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class SchoolDepartment extends Model {

    public static Finder<Long, SchoolDepartment> finder = new Finder<Long, SchoolDepartment>(Long.class,
            SchoolDepartment.class);

    @Id
    public Long id;

    /**
     * -> 学校マスタ.学校ID
     */
    @ManyToOne
    @JoinColumn(name = "schoolid")
    public School school;

    /**
     * 学部名
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 128)
    public String department;

    /**
     * 削除フラグ
     */
    @NotNull
    public Boolean delflag;
    
    /**
     * <- エントリユーザの学校情報
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolDepartment")
    @JsonIgnore
    public List<EntryUserSchool> entryUserSchools;
    
    /**
     * <- 学校グループ条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolDepartment")
    @JsonIgnore
    public List<SchoolGroupCondition> schoolGroupConditions;
    
    /**
     * <- 学科マスタ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolDepartment")
    @JsonIgnore
    public List<SchoolSubject> schoolSubjects;
    

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
