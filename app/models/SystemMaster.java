package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * システムマスターテーブル
 * @author masafumi
 */
@Entity
public class SystemMaster extends Model {

    public static Finder<Long, SystemMaster> finder = new Finder<Long, SystemMaster>(Long.class, SystemMaster.class);
    
    @Id
    public Long id;

    
    /**
     * キー
     */
    @NotNull
    @Column(length = 16, unique = true)
    public String configKey;
    
    
    /**
     * 値
     */
    @NotNull
    @Column(length = 1024)
    public String configValue;
    
    /**
     * 説明
     */
    @NotNull
    @Column(length = 1024)
    public String description;
    

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
