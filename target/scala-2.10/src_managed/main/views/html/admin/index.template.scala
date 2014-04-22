
package views.html.admin

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.admin.LoginForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(login: Form[controllers.forms.admin.LoginForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.admin.main("ログイン")/*4.31*/ {_display_(Seq[Any](format.raw/*4.33*/("""

    """),_display_(Seq[Any](/*6.6*/form(CSRF(controllers.admin.routes.Application.login))/*6.60*/ {_display_(Seq[Any](format.raw/*6.62*/("""
        <h2>ログイン</h2>
        
        """),_display_(Seq[Any](/*9.10*/if(login.hasGlobalErrors)/*9.35*/ {_display_(Seq[Any](format.raw/*9.37*/("""
          <p class="error">"""),_display_(Seq[Any](/*10.29*/login/*10.34*/.globalError.message)),format.raw/*10.54*/("""</p>
        """)))})),format.raw/*11.10*/("""

        <p>
          """),_display_(Seq[Any](/*14.12*/inputText(
			login("employeeNumber"),
			 '_label -> "Employee Number",
			 '_class -> "line-input",
			 'type -> "text",
			 '_error -> login.error("employeeNumber")))),format.raw/*19.46*/("""
        </p>
        <p>
          """),_display_(Seq[Any](/*22.12*/inputPassword(
			login("password"),
			 '_label -> "Password",
			 '_class -> "line-input",
			 'type -> "password",
			 '_error -> login.error("password")))),format.raw/*27.40*/("""
        </p>

        <p><input type="submit" class="btn primary" value="login"></p>
    """)))})),format.raw/*31.6*/("""

""")))})),format.raw/*33.2*/("""
"""))}
    }
    
    def render(login:Form[controllers.forms.admin.LoginForm]): play.api.templates.HtmlFormat.Appendable = apply(login)
    
    def f:((Form[controllers.forms.admin.LoginForm]) => play.api.templates.HtmlFormat.Appendable) = (login) => apply(login)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:34 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/admin/index.scala.html
                    HASH: 989f755d64ab95a5adbc11a99124a253c9a629a6
                    MATRIX: 813->1|972->49|1000->69|1037->72|1049->77|1081->101|1120->103|1163->112|1225->166|1264->168|1343->212|1376->237|1415->239|1481->269|1495->274|1537->294|1584->309|1648->337|1843->510|1919->550|2103->712|2229->807|2265->812
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|34->6|34->6|34->6|37->9|37->9|37->9|38->10|38->10|38->10|39->11|42->14|47->19|50->22|55->27|59->31|61->33
                    -- GENERATED --
                */
            