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
 * 学校マスタ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class School extends Model {

    public static Finder<Long, School> finder = new Finder<Long, School>(Long.class, School.class);

    @Id
    public Long id;

    /**
     * -> 都道府県マスタ.都道府県ID
     */
    @ManyToOne
    @JoinColumn(name = "prefecturesid")
    @NotNull
    public Prefectures prefectures;

    /**
     * 削除フラグ
     */
    @NotNull
    public Boolean delflag;

    /**
     * 学校名
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 128)
    public String name;

    /**
     * 学校区分
     */
    @NotNull
    public Integer division;
    
    /**
     * <- エントリユーザの学校情報
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    @JsonIgnore
    public List<EntryUserSchool> entryUserSchools;
    
    /**
     * <- 学校グループ条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    @JsonIgnore
    public List<SchoolGroupCondition> schoolGroupConditions;
    
    
    /**
     * <- 学部マスタ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    @JsonIgnore
    public List<SchoolDepartment> schoolDepartments;
    

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
