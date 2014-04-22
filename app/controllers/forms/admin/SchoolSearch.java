package controllers.forms.admin;

import models.SchoolGroupCondition;

/**
 * 学校検索フォーム用の内部クラス.
 */
public class SchoolSearch {

    public SchoolSearch() {
    }

    /**
     * 対象判断フラグ
     */
    public boolean checkFlg = false;

    /**
     * 学校グループ条件
     */
    public SchoolGroupCondition schoolGroupCondition = null;
}
