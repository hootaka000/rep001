/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package controllers.student;

import static play.data.Form.*;
import play.mvc.*;
import views.html.student.*;
import base.*;
import controllers.forms.student.*;

/**
 * マイページ画面関連コントローラー.
 * @author B05138
 */
public class MyPage extends StudentSecuredController {

    /**
     * マイページ画面を表示する.
     * @return 処理結果
     */
    @SaiyoAcl(roles = { SaiyoRoles.NEW_GRADUATE })
    public static Result index() {
        MyPageForm mypageForm = new MyPageForm(form(MyPageForm.Mypage.class));

        // ここで必要な情報を取得する。
        // TODO ここからサービス層。。。？
        // イベント情報

        return ok(mypage.render(mypageForm));
    }
}
