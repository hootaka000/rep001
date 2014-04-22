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
 * ダッシュボードレポート設定
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class DashboardReport extends Model {

    public static Finder<Long, DashboardReport> finder = new Finder<Long, DashboardReport>(Long.class,
            DashboardReport.class);
    
    /**
     * ID.
     */
    @Id
    public Long id;

    /**
     * -> 社員マスタ.社員ID
     */
    @ManyToOne
    @JoinColumn(name = "employee_id")
    public Employee employee;

    /**
     * レポート種別
     */
    @NotNull
    public Integer reportType;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
