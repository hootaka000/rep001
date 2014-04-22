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
 * 管理ユーザ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id"}))
public class AdminUser extends Model {

    public static Finder<Long, AdminUser> finder = new Finder<Long, AdminUser>(Long.class, AdminUser.class);
    
    @Id
    public Long id;

    /**
     * -> 社員マスタ.社員ID
     */
    @JoinColumn(name = "employee_id")
    @OneToOne(cascade = CascadeType.ALL)
    public Employee employee;

    /**
     * 管理者権限
     */
    @NotNull
    public Integer role;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
