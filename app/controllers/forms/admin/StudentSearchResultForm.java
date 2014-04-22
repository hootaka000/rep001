package controllers.forms.admin;


/**
 * 学生検索結果フォーム.
 *
 * @author B03401
 *
 */
public class StudentSearchResultForm {

    public StudentSearchResultForm() {
    }

    /**
     * エントリーユーザID
     */
    public Long entryUserId = 0L;

    /**
     * 氏名(姓)
     */
    public String firstName = "";

    /**
     * 氏名(名)
     */
    public String lastName = "";

    /**
     * データURL
     *
     */
    public String dataUrl = "";

    /**
     * チェックボックスフラグ
     *
     */
    public boolean checkBoxFlg = false;

}
