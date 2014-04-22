package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 送信メール履歴
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class MailLog extends Model {

    public static Finder<Long, MailLog> finder = new Finder<Long, MailLog>(Long.class, MailLog.class);

    @Id
    public Long id;

    /**
     * 送信日時
     */
    @NotNull
    public java.util.Date sendDatetime;

    /**
     * 送信先
     */
    @NotNull
    public Integer destination;

    /**
     * 件名
     */
    @NotNull
    @Column(length = 128)
    public String subject;

    /**
     * 本文
     */
    @NotNull
    @Column(length = 3000)
    public String body;
    
    /**
     * <- エントリユーザへの送信メール履歴
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mailLog")
    public List<EntryUserMailLog> entryUserMailLogs;
    
    /**
     * <- グループのメールログ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mailLog")
    public List<GroupMailLog> groupMailLogs;
    
    /**
     * <- 学校グループのメールログ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mailLog")
    public List<SchoolGroupMailLog> schoolGroupMailLogs;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
