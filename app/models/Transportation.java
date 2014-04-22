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
 * 交通手段
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class Transportation extends Model {

    public static Finder<Long, Transportation> finder = new Finder<Long, Transportation>(Long.class, Transportation.class);

    @Id
    public Long id;
    
    /**
     * -> 会場マスタ
     */
    @ManyToOne
    @JoinColumn(name = "venueid")
    @NotNull
    public Venue venue;

    /**
     * 交通手段名
     */
    @NotNull
    @Column(length = 64)
    public String name;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
