package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * メールテンプレート
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class MailTemplate extends Model {

    public static Finder<Long, MailTemplate> finder = new Finder<Long, MailTemplate>(Long.class, MailTemplate.class);

    @Id
    public Long id;

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

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
