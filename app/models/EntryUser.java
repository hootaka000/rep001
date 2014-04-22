package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.Encrypted;
import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * エントリユーザ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class EntryUser extends Model {

    public static Finder<Long, EntryUser> finder = new Finder<Long, EntryUser>(Long.class, EntryUser.class);

    @Id
    public Long id;

    /**
     * -> 企業情報マスタ.企業ID
     */
    @ManyToOne
    @JoinColumn(name = "companyid")
    @NotNull
    public Company company;

    /**
     * 誕生日（暗号化）
     */
    @NotNull
    @Encrypted
    public java.util.Date birthday;

    /**
     * 姓（カナ）（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 18)
    public String lastNameKana;

    /**
     * ミドルネーム（カナ）（暗号化）
     */
    @Encrypted(dbEncryption = true, dbLength = 18)
    public String middleNameKana;

    /**
     * 名（カナ）（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 18)
    public String firstNameKana;

    /**
     * E-mailアドレス（暗号化）
     */
    @NotNull
    //@Encrypted(dbEncryption = true, dbLength = 512)
    @Column(unique = true)
    public String email;

    /**
     * 性別
     */
    @NotNull
    public Integer sex;

    /**
     * パスワード（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 40)
    public String password;

    /**
     * 登録日
     */
    @NotNull
    public java.util.Date entryDate;

    /**
     * エントリ種別
     */
    @NotNull
    public Integer entryType;

    /**
     * 選考状況
     */
    @NotNull
    public Integer entryStatus;

    /**
     * ミドルネーム（暗号化）
     */
    @Encrypted(dbEncryption = true, dbLength = 18)
    public String middleName;

    /**
     * データURL
     */
    @Column(length = 1024)
    public String dataUrl;

    /**
     * 姓（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 18)
    public String lastName;

    /**
     * 活性状態
     */
    @NotNull
    public Boolean activation;

    /**
     * 削除フラグ
     */
    @NotNull
    public Boolean delflag;

    /**
     * 応募年度
     */
    @NotNull
    public Integer applicationYear;

    /**
     * 名（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 18)
    public String firstName;

    /**
     * <- 住所
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryUser")
    public List<Address> addresses;

    /**
     * <- エントリユーザの学校情報
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryUser")
    public List<EntryUserSchool> entryUserSchools;

    /**
     * <- エントリユーザのコメント
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryUser")
    public List<EntryUserComments> entryUserComments;

    /**
     * <- エントリユーザ履歴
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryUser")
    public List<EntryUserCommunication> entryUserCommunications;

    /**
     * <- エントリユーザへの送信メール履歴
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryUser")
    public List<EntryUserMailLog> entryUserMailLogs;

    /**
     * <- コール履歴
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryUser")
    public List<CallHistory> callHistories;

    /**
     * <- グループに関するエントリユーザ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryUser")
    public List<EntryUserGroup> entryUserGroups;

    /**
     * <- 問い合わせ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryUser")
    public List<Inquiry> inquiries;

    /**
     * <- エントリユーザのイベント日程
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryUser")
    public List<EntryUserEventSchedule> entryUserEventSchedules;

    /**
     * <- エントリユーザのイベント情報
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entryUser")
    public List<EntryUserEvent> entryUserEvents;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
