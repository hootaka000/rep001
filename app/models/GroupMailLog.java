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
 * グループのメールログ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class GroupMailLog extends Model {

    public static Finder<Long, GroupMailLog> finder = new Finder<Long, GroupMailLog>(Long.class, GroupMailLog.class);
    
    @Id
    public Long id;

    /**
     * -> グループ.グループID
     */
    @ManyToOne
    @JoinColumn(name = "groupid")
    @NotNull
    public ComplexGroup complexGroup;

    /**
     * -> 送信メール履歴.メールログID
     */
    @ManyToOne
    @JoinColumn(name = "mail_logid")
    @NotNull
    public MailLog mailLog;

    /**
     * 送信状態
     */
    @NotNull
    public Integer status;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
