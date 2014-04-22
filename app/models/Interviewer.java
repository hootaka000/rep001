package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 面接官
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id"}))
public class Interviewer extends Model {

    public static Finder<Long, Interviewer> finder = new Finder<Long, Interviewer>(Long.class, Interviewer.class);
    
    @Id
    public Long id;

    /**
     * -> 社員マスタ.社員ID
     */
    @JoinColumn(name = "employee_id")
    @OneToOne(cascade = CascadeType.ALL)
    public Employee employee;

    /**
     * ステータス
     */
    @NotNull
    public Integer status;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
