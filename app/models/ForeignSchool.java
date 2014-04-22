package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.Encrypted;
import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 外国学校
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class ForeignSchool extends Model {

    public static Finder<Long, ForeignSchool> finder = new Finder<Long, ForeignSchool>(Long.class, ForeignSchool.class);

    @Id
    public Long id;

    /**
     * 学科名（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 128)
    public String subject;

    /**
     * 学部名（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 128)
    public String department;

    /**
     * 学校名（暗号化）
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foreignSchool")
    public List<EntryUserSchool> entryUserSchools;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
