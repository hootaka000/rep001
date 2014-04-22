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

import play.db.ebean.Model;

import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * グループ
 * @author ootaka
 * @author masafumi 2nd check
 */
@Entity
public class ComplexGroup extends Model {

    public static Finder<Long, ComplexGroup> finder = new Finder<Long, ComplexGroup>(Long.class, ComplexGroup.class);

    @Id
    public Long id;

    /**
     * -> 社員マスタ.作成した社員ID
     */
    @ManyToOne
    @JoinColumn(name = "employee_id")
    public Employee employee;

    /**
     * -> 企業情報マスタ.企業ID
     */
    @ManyToOne
    @JoinColumn(name = "companyid")
    public Company company;

    /**
     * グループ名
     */
    @NotNull
    @Column(length = 128, unique = true)
    public String name;

    /**
     * 登録日条件開始日
     */
    public java.util.Date conditionRegisterFrom;

    /**
     * 登録日条件終了日
     */
    public java.util.Date conditionRegisterTo;

    /**
     * 学校区分条件
     */
    @NotNull
    public Integer conditonSchoolDivision;

    /**
     * 性別条件
     */
    public Integer conditionSex;

    /**
     * 選考状態条件
     */
    public Integer conditionSelectionStatus;

    /**
     * 学校グループ条件種別
     */
    public Integer conditionSchoolGropuType;

    /**
     * 新入社員条件
     */
    public Integer conditionNewRecruit;

    /**
     * グループ条件種別
     */
    public Integer conditionGroupType;

    /**
     * イベント条件種別
     */
    public Integer conditionEventType;

    /**
     * コメント条件種別
     */
    public Integer conditionCommentType;
    
    /**
     * <- グループに属するエントリユーザ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "complexGroup")
    public List<EntryUserGroup> entryUserGroups;
    
    /**
     * <- グループのメールログ
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "complexGroup")
    public List<GroupMailLog> groupMailLogs;
    
    /**
     * <- グループの学校グループ条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "complexGroup")
    public List<GroupConditionSchoolGroup> groupConditionSchoolGroups;
    
    /**
     * <- グループのコメント条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "complexGroup")
    public List<GroupConditionComments> groupConditionComments;
    
    
    /**
     * <- イベント情報
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "complexGroup")
    public List<Event> events;
    
    /**
     * <- グループのイベント条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "complexGroup")
    public List<GroupConditionEvent> groupConditionEvents;
    
    /**
     * <- グループの職種条件
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "complexGroup")
    public List<GroupConditionJobType> groupConditionJobTypes;

    @UpdatedTimestamp
    public java.util.Date updatedAt;

    @Version
    public Long lockVersion;

}
