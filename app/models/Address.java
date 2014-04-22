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
 * 住所
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class Address extends Model {

    public static Finder<Long, Address> finder = new Finder<Long, Address>(Long.class, Address.class);
    
    @Id
    public Long id;

    /**
     * -> エントリユーザ.エントリユーザID
     */
    @ManyToOne
    @JoinColumn(name = "entry_userid")
    public EntryUser entryUser;

    /**
     * -> 都道府県マスタ.都道府県ID
     */
    @ManyToOne
    @JoinColumn(name = "prefecturesid")
    public Prefectures prefectures;
    
    /**
     * -> 都道府県マスタ.都道府県ID
     */
    @ManyToOne
    @JoinColumn(name = "postal_codeid")
    public PostalCode postalCode;
    
    /**
     * 国外_郵便番号（暗号化）
     */
    @Encrypted(dbEncryption = true, dbLength = 40)
    public String overseaPostalCode;

    /**
     * アパート名（暗号化）
     */
    @Encrypted(dbEncryption = true, dbLength = 100)
    public String apartment;

    /**
     * 地名（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 400)
    public String placeName;
    

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
