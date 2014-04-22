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
 * 職種マスタ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class JobType extends Model {

    public static Finder<Long, JobType> finder = new Finder<Long, JobType>(Long.class, JobType.class);

    @Id
    public Long id;

    /**
     * -> 企業情報マスタ.企業ID
     */
    @ManyToOne
    @JoinColumn(name = "companyid")
    @NotNull
    public Company company;

    /**
     * 職種名
     */
    @NotNull
    @Column(length = 16)
    public String name;
    
    /**
     * <- グループの職種条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobType")
    public List<GroupConditionJobType> groupConditionJobTypes;
    
    /**
     * <- イベントグループ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobType")
    public List<EventGroup> eventGroups;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
