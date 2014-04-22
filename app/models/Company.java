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
 * 企業情報マスタ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class Company extends Model {

    public static Finder<Long, Company> finder = new Finder<Long, Company>(Long.class, Company.class);

    @Id
    public Long id;

    /**
     * 企業名
     */
    @NotNull
    @Column(length = 32, unique = true)
    public String name;
    
    /**
     * <- 所属企業マスタ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    public List<EmployeeCompany> employeeCompanies;
    
    /**
     * <- エントリユーザ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    public List<EntryUser> entryUsers;
    
    /**
     * <- グループ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    public List<ComplexGroup> complexGroups;
    
    /**
     * <- 職種マスタ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    public List<JobType> jobTypes;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
