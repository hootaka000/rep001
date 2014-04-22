package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 追加メッセージ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class AdditionalText extends Model {

    public static Finder<Long, AdditionalText> finder = new Finder<Long, AdditionalText>(Long.class,
            AdditionalText.class);

    @Id
    public Long id;

    /**
     * -> イベント情報.イベントID
     */
    @ManyToOne
    @JoinColumn(name = "eventid")
    @NotNull
    public Event event;

    /**
     * タイトル
     */
    @NotNull
    @Column(length = 16)
    public String title;

    /**
     * メッセージ
     */
    @NotNull
    @Column(length = 1024)
    public String message;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
