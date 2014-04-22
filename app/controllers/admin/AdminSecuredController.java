package controllers.admin;

import play.mvc.Security.Authenticated;
import controllers.SaiyoController;


/**
 * 採用管理システム　コントローラの基底クラス（認証が必要なコントローラ用）
 * @author masafumi
 */
@Authenticated(AdminSecured.class)
public abstract class AdminSecuredController extends SaiyoController {

    
}
