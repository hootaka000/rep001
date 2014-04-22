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
 * 施設情報マスタ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class Facility extends Model {

    public static Finder<Long, Facility> finder = new Finder<Long, Facility>(Long.class, Facility.class);

    @Id
    public Long id;
    
    /**
     * -> 会場情報マスタ.会場ID
     */
    @ManyToOne
    @JoinColumn(name = "venueid")
    @NotNull
    public Venue venue;

    /**
     * サイボウズの施設ID
     */
    @Column(unique = true)
    @NotNull
    public Long cybozid;

    /**
     * 施設名
     */
    @NotNull
    @Column(length = 64, unique = true)
    public String name;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
