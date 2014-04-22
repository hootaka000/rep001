package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * レポートレコード
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class ReportRecord extends Model {

    public static Finder<Long, ReportRecord> finder = new Finder<Long, ReportRecord>(Long.class, ReportRecord.class);
    
    @Id
    public Long id;

    /**
     * 目標
     */
    @NotNull
    public Integer goal;

    /**
     * 記録日
     */
    @NotNull
    public java.util.Date recordDate;

    /**
     * カウント数
     */
    @NotNull
    public Integer reportCount;

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
