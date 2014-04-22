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
 * 学科マスタ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class SchoolSubject extends Model {

    public static Finder<Long, SchoolSubject> finder = new Finder<Long, SchoolSubject>(Long.class, SchoolSubject.class);

    @Id
    public Long id;

    /**
     * -> 学部マスタ.学部ID
     */
    @ManyToOne
    @JoinColumn(name = "school_departmentid")
    @NotNull
    public SchoolDepartment schoolDepartment;

    /**
     * 学科名
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 128)
    public String subject;

    /**
     * 削除フラグ
     */
    @NotNull
    public Boolean delflag;
    
    /**
     * <- エントリユーザの学校情報
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolSubject")
    @JsonIgnore
    public List<EntryUserSchool> entryUserSchools;
    
    /**
     * <- 学校グループ条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolSubject")
    @JsonIgnore
    public List<SchoolGroupCondition> schoolGroupConditions;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
