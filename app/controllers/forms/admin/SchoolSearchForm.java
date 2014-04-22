package controllers.forms.admin;

import java.util.List;

import models.Prefectures;
import models.School;
import models.SchoolDepartment;
import models.SchoolSubject;

/**
 * 学校検索フォーム.
 *
 * @author B03401
 *
 */
public class SchoolSearchForm {

    public SchoolSearchForm() {
    }

    /**
     * 都道府県マスタ
     */
    public Prefectures prefectures = null;

    /**
     * 大学マスタ
     */
    public School school = null;

    /**
     * 学部マスタ
     */
    public SchoolDepartment schoolDepartment = null;

    /**
     * 学科マスタ
     */
    public SchoolSubject schoolSubject = null;
    /**
     * 大学グループ名
     */
    public String schoolGroupName = "";

    /**
     * 対象判断フラグ
     */
    public boolean checkFlg = false;

    /**
     * 学校検索用フォーム
     */
    public List<SchoolSearch> schoolSearchList = null;


}
