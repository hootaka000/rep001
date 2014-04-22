package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.Encrypted;
import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * エントリユーザの学校情報
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"foreign_schoolid"}))
public class EntryUserSchool extends Model {

    public static Finder<Long, EntryUserSchool> finder = new Finder<Long, EntryUserSchool>(Long.class,
            EntryUserSchool.class);
    
    @Id
    public Long id;

    /**
     * -> 外国学校.外国学校ID
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foreign_schoolid")
    public ForeignSchool foreignSchool;

    /**
     * -> 学科マスタ.学科ID
     */
    @ManyToOne
    @JoinColumn(name = "school_subjectid")
    public SchoolSubject schoolSubject;

    /**
     * -> エントリユーザ.エントリユーザID
     */
    @ManyToOne
    @JoinColumn(name = "entry_userid")
    public EntryUser entryUser;

    /**
     * -> 学校マスタ.学校ID
     */
    @ManyToOne
    @JoinColumn(name = "schoolid")
    public School school;

    /**
     * -> 学部マスタ.学部ID
     */
    @ManyToOne
    @JoinColumn(name = "school_departmentid")
    public SchoolDepartment schoolDepartment;

    /**
     * 文理区分
     */
    @NotNull
    public Integer classification;

    /**
     * 卒業年月
     */
    @NotNull
    public java.util.Date graduation;

    /**
     * 卒業区分
     */
    @NotNull
    public Integer graduationType;

    /**
     * ゼミ・研究室（暗号化）
     */
    @Encrypted(dbEncryption = true, dbLength = 40)
    public String lab;

    /**
     * クラブ・サークル名（暗号化）
     */
    @Encrypted(dbEncryption = true, dbLength = 40)
    public String club;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
