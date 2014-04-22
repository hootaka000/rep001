package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 所属企業マスタ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class EmployeeCompany extends Model {

    public static Finder<Long, EmployeeCompany> finder = new Finder<Long, EmployeeCompany>(Long.class,
            EmployeeCompany.class);
    
    @Id
    public Long id;

    /**
     * -> 社員マスタ.社員ID
     */
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @NotNull
    public Employee employee;

    /**
     * -> 企業情報マスタ.企業ID
     */
    @ManyToOne
    @JoinColumn(name = "companyid")
    @NotNull
    public Company company;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
