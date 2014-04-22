package controllers.student;

import play.mvc.Security.Authenticated;
import controllers.SaiyoController;


/**
 * 採用管理システム　コントローラの基底クラス（認証が必要なコントローラ用）
 * @author masafumi
 */
@Authenticated(StudentSecured.class)
public abstract class StudentSecuredController extends SaiyoController {

    
}
