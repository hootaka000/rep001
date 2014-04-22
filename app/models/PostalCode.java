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

import com.fasterxml.jackson.annotation.JsonIgnore;
import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * 郵便番号マスタ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class PostalCode extends Model {

    public static Finder<Long, PostalCode> finder = new Finder<Long, PostalCode>(Long.class, PostalCode.class);
    
    @Id
    public Long id;

    /**
     * -> 都道府県マスタ.都道府県ID
     */
    @ManyToOne
    @JoinColumn(name = "prefecturesid")
    @NotNull
    public Prefectures prefectures;

    /**
     * 地名
     */
    @NotNull
    @Column(length = 200)
    public String placeName;

    /**
     * 番号1
     */
    @NotNull
    public Integer codeNumber1;
    
    /**
     * 番号2
     */
    @NotNull
    public Integer codeNumber2;
    
    /**
     * <- 住所
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postalCode")
    @JsonIgnore
    public List<Address> addresses;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
