package controllers.student;

import models.*;

import models.services.*;
import play.*;
import play.data.*;
import play.mvc.*;
import play.data.validation.Constraints.*;
import static play.data.Form.*;
import utils.*;
import base.*;
import controllers.*;

/**
 * TODO これはサンプルとして残してあるクラスなので、編集したり利用したりしないでください
 */
@Deprecated
public class Sample extends SaiyoController {
    
    /**
     * フォームクラス.
     */
    public static class SampleForm {
        @Required
        @MinLength(5)
        @Email
        public String email;
        
        @Max(5)
        public Integer count;
    }

    @SaiyoAcl
    public static Result index() {
        // return ok(views.html.);
        return ok(views.html.student.sample.index.render(form(SampleForm.class)));
    }

    /**
     * @return
     */
    @SaiyoAcl
    public static Result doTest() {

        String autocommit = Play.application().configuration().getString("db.default.autocommit");
        AppLogUtil.debug("autocommit!!!!!!!!!!**");
        AppLogUtil.debug(autocommit);


        Form<SampleForm> sampleForm = form(SampleForm.class).bindFromRequest();
        if (sampleForm.hasErrors()) {
            AppLogUtil.debug("hasE:" + sampleForm.hasErrors());
            AppLogUtil.debug("hasGE:" + sampleForm.hasGlobalErrors());
            AppLogUtil.debug("NG");
            return badRequest(views.html.student.sample.index.render(sampleForm));
        }
        AppLogUtil.debug("OK");
        return redirect(routes.Sample.index());
        

        // String url = "http://10.130.10.134:9000/json2disk";
        //
        // RequestBody body = request().body();
        // Logger.debug("get body..");
        // Logger.debug(body.asJson().toString());
        //
        // Map<String, String> params = new HashMap<String, String>();
        // params.put("name", "宮嶋　雅文");
        // params.put("age", "33");
        //
        // String jsonBody = JSON.encode(params);
        //
        // try {
        // RESTUtil.post(url, jsonBody);
        // } catch (Exception e) {
        // throw new RuntimeException("RESTAccessで予期せぬエラー", e);
        // }

        // return ok("{\"status\": \"OK\"}").as("application/json");
//        return ok(views.html.student.sample.index.render("い"));
    }

}
