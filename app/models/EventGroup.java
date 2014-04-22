package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * イベントグループ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class EventGroup extends Model {

    public static Finder<Long, EventGroup> finder = new Finder<Long, EventGroup>(Long.class, EventGroup.class);

    @Id
    public Long id;

    /**
     * -> 職種マスタ.職種ID
     */
    @ManyToOne
    @JoinColumn(name = "job_typeid")
    @NotNull
    public JobType jobType;

    /**
     * イベント種別
     */
    @NotNull
    public Integer type;

    /**
     * イベントグループ名
     */
    @NotNull
    @Column(length = 32)
    public String name;
    
    /**
     * <- イベント
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventGroup")
    public List<Event> events;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
