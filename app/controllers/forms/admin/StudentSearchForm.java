package controllers.forms.admin;

import models.ComplexGroup;
import models.Event;
import models.EventSchedule;
import models.Prefectures;
import models.School;
import models.SchoolDepartment;
import models.SchoolGroup;
import play.data.validation.Constraints.Email;

/**
 * 学生検索フォーム.
 *
 * @author B03401
 *
 */
public class StudentSearchForm {

    public StudentSearchForm() {
    }

    /**
     * エントリーユーザID
     */
    public Long entryUserId = 0L;

    /**
     * 採用年度.
     */
    public Integer applicationYear = -1;

    /**
     * 氏名(姓)
     */
    public String firstName = "";

    /**
     * 氏名(名)
     */
    public String lastName = "";

    /**
     * 性別
     */
    public Integer sex = -1;

    /**
     * グループ
     */
    public ComplexGroup complexGroup = null;

    /**
     * 大学グループ
     */
    public SchoolGroup schoolGroup = null;

    /**
     * 学校区分
     */
    public Integer division = -1;

    /**
     * 文理区分
     */
    public Integer classification = -1;

    /**
     * 学校マスタ
     */
    public School school = null;

    /**
     * 学部マスタ
     */
    public SchoolDepartment schoolDepartment = null;

    /**
     * 都道府県
     */
    public Prefectures prefectures = null;

    /**
     * 電話番号
     */
    public Integer phoneNo = 0;

    /**
     * E-mailアドレス
     */
    @Email
    public String email = "";

    /**
     * 応募者ID(複数)
     */
    public String entryUserIds = "";

    /**
     * イベント情報
     */
    public Event event = null;

    /**
     * イベント日程
     */
    public EventSchedule eventSchedule = null;

    /**
     * 選考ステータス
     */
    public Integer entryStatus = -1;

}
