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
 * 問い合わせ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class Inquiry extends Model {

    public static Finder<Long, Inquiry> finder = new Finder<Long, Inquiry>(Long.class, Inquiry.class);

    @Id
    public Long id;

    /**
     * -> エントリユーザ.エントリユーザID
     */
    @ManyToOne
    @JoinColumn(name = "entry_userid")
    public EntryUser entryUser;

    /**
     * -> 社員マスタ.回答した社員ID
     */
    @ManyToOne
    @JoinColumn(name = "employee_id")
    public Employee employee;

    /**
     * 回答（暗号化）
     */
    @Encrypted(dbEncryption = true, dbLength = 2048)
    public String answer;

    /**
     * お問い合せ内容（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 2048)
    public String content;

    /**
     * お問い合せ種別
     */
    @NotNull
    public Integer type;

    /**
     * E-mailアドレス（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 512)
    public String email;

    /**
     * 名（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 18)
    public String firstName;

    /**
     * ミドルネーム（暗号化）
     */
    @Encrypted(dbEncryption = true, dbLength = 18)
    public String middleName;

    /**
     * 姓（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 18)
    public String lastName;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
