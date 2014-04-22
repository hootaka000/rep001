package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * エントリユーザへの送信メール履歴
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class EntryUserMailLog extends Model {

    public static Finder<Long, EntryUserMailLog> finder = new Finder<Long, EntryUserMailLog>(Long.class,
            EntryUserMailLog.class);
    
    @Id
    public Long id;

    /**
     * -> 送信メール履歴.メールログID
     */
    @ManyToOne
    @JoinColumn(name = "mail_logid")
    @NotNull
    public MailLog mailLog;

    /**
     * -> エントリユーザ.エントリユーザID
     */
    @ManyToOne
    @JoinColumn(name = "entry_userid")
    @NotNull
    public EntryUser entryUser;

    /**
     * メール送信状態
     */
    @NotNull
    public Integer status;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
