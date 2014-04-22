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
 * コメント
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class Comments extends Model {

    public static Finder<Long, Comments> finder = new Finder<Long, Comments>(Long.class, Comments.class);

    @Id
    public Long id;

    /**
     * メッセージ
     */
    @NotNull
    @Column(length = 128, unique = true)
    public String message;
    
    /**
     * <- エントリーユーザのコメント
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comments")
    public List<EntryUserComments> entryUserComments;
    
    /**
     * <- グループのコメント条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comments")
    public List<GroupConditionComments> groupConditionComments; 

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
