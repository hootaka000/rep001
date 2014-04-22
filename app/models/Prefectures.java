package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 都道府県マスタ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class Prefectures extends Model {

    public static Finder<Long, Prefectures> finder = new Finder<Long, Prefectures>(Long.class, Prefectures.class);

    @Id
    public Long id;

    /**
     * 地域
     */
    @NotNull
    public Integer area;

    /**
     * 都道府県名
     */
    @NotNull
    @Column(length = 8, unique = true)
    public String name;
    
    /**
     * <- 郵便番号マスタ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefectures")
    @JsonIgnore
    public List<PostalCode> postalCodes;
    
    /**
     * <- 学校マスタ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefectures")
    @JsonIgnore
    public List<School> schools;
    
    /**
     * <- 住所
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prefectures")
    @JsonIgnore
    public List<Address> addresses;
    

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
