package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.Encrypted;
import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 携帯電話
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class MobilePhone extends Model {

    public static Finder<Long, MobilePhone> finder = new Finder<Long, MobilePhone>(Long.class, MobilePhone.class);
    
    @Id
    public Long id;

    /**
     * -> エントリユーザ.エントリユーザID
     */
    @ManyToOne
    @JoinColumn(name = "entry_userid")
    @NotNull
    public EntryUser entryUser;

    /**
     * 携帯電話番号（暗号化）-1
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 8)
    public String number1;

    /**
     * 携帯電話番号（暗号化）-2
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 8)
    public String number2;
    
    /**
     * 携帯電話番号（暗号化）-3
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 8)
    public String number3;
    
    /**
     * 携帯アドレス（暗号化）
     */
    @Encrypted(dbEncryption = true, dbLength = 512)
    public String email;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
