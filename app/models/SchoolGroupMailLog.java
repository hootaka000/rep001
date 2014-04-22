package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 学校グループのメールログ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class SchoolGroupMailLog extends Model {

    public static Finder<Long, SchoolGroupMailLog> finder = new Finder<Long, SchoolGroupMailLog>(Long.class,
            SchoolGroupMailLog.class);

    /**
     * -> 学校グループ.学校グループID
     */
    @ManyToOne
    @JoinColumn(name = "school_groupid")
    @NotNull
    public SchoolGroup schoolGroup;

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
    public Integer status;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
