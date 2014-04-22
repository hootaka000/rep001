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
 * 会場情報マスタ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class Venue extends Model {

    public static Finder<Long, Venue> finder = new Finder<Long, Venue>(Long.class, Venue.class);

    @Id
    public Long id;

    /**
     * 問い合わせ先
     */
    @NotNull
    @Column(length = 64)
    public String contact;

    /**
     * 会場名
     */
    @NotNull
    @Column(length = 32, unique = true)
    public String name;
    
    /**
     * 会場住所
     */
    @NotNull
    @Column(length = 300)
    public String address;
    
    /**
     * <- イベント日程
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venue")
    public List<EventSchedule> enEventSchedules;

    
    /**
     * <- 交通手段
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venue")
    public List<Transportation> transportations;
    
    /**
     * <- 設備情報マスタ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venue")
    public List<Facility> facilities;
    

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
