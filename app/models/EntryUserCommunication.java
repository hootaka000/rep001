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
 * コミュニケーション履歴
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class EntryUserCommunication extends Model {

    public static Finder<Long, EntryUserCommunication> finder = new Finder<Long, EntryUserCommunication>(Long.class,
            EntryUserCommunication.class);

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
     * コメント（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 2048)
    public String comments;

    /**
     * コンディション種別
     */
    @NotNull
    public Integer conditiontype;

    /**
     * 日時
     */
    @NotNull
    public java.util.Date datetime;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
