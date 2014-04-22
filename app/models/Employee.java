package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 社員マスタ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class Employee extends Model {

    public static Finder<Long, Employee> finder = new Finder<Long, Employee>(Long.class, Employee.class);

    @Id
    public Long id;

    /**
     * 氏名
     */
    @NotNull
    @Column(length = 64)
    public String name;

    /**
     * 社員番号
     */
    @NotNull
    @Column(length = 6, unique = true)
    public String employeeNumber;
    
    /**
     * <- 問い合わせ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    public List<Inquiry> inquiries;
    
    /**
     * <- 所属企業マスタ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    public List<EmployeeCompany> companies;
    
    /**
     * <- グループ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    public List<ComplexGroup> complexGroups;
    
    /**
     * <- ダッシュボードレポート設定
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    public List<DashboardReport> dashboardReports;
    
    /**
     * <- イベント日程関係社員
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    public List<EventScheduleEmployee> eventScheduleEmployees;
    
    /**
     * 面接官
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
    public Interviewer interviewer;
    
    /**
     * 管理ユーザ
     */
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
    public AdminUser adminUser;
    

    /**
     * 社員ステータス
     */
    @NotNull
    public Integer employeeStatus;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}