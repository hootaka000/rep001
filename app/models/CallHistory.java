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
 * コール履歴
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class CallHistory extends Model {

    public static Finder<Long, CallHistory> finder = new Finder<Long, CallHistory>(Long.class, CallHistory.class);

    @Id
    public Long id;

    /**
     * -> エントリユーザ.エントリユーザID
     */
    @ManyToOne
    @JoinColumn(name = "entry_userid")
    public EntryUser entryUser;

    /**
     * メモ（暗号化）
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 512)
    public String memo;

    /**
     * 日時
     */
    @NotNull
    public java.util.Date datetime;

    /**
     * コール履歴種別
     */
    @NotNull
    public Integer callHistoryType;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
