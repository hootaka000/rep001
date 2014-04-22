
package views.html.student.password

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
object republish extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.student.RepublishForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(repub: Form[controllers.forms.student.RepublishForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.student.main("パスワード再発行")/*4.37*/ {_display_(Seq[Any](format.raw/*4.39*/("""

    """),_display_(Seq[Any](/*6.6*/form(CSRF(controllers.student.routes.Password.republish))/*6.63*/ {_display_(Seq[Any](format.raw/*6.65*/("""
        <h1>パスワード再発行</h1>
        """),_display_(Seq[Any](/*8.10*/if(repub.hasGlobalErrors)/*8.35*/ {_display_(Seq[Any](format.raw/*8.37*/("""
            <p class="error">"""),_display_(Seq[Any](/*9.31*/repub/*9.36*/.globalError.message)),format.raw/*9.56*/("""</p>
        """)))})),format.raw/*10.10*/("""
        <p>"""),_display_(Seq[Any](/*11.13*/inputText(repub("email"), '_label -> "E-Mail", '_class -> "line-input", 'type -> "email"))),format.raw/*11.102*/("""</p>
        <p><input type="submit" class="btn primary" value="パスワード再発行"></p>
    """)))})),format.raw/*13.6*/("""
""")))})),format.raw/*14.2*/("""
"""))}
    }
    
    def render(repub:Form[controllers.forms.student.RepublishForm]): play.api.templates.HtmlFormat.Appendable = apply(repub)
    
    def f:((Form[controllers.forms.student.RepublishForm]) => play.api.templates.HtmlFormat.Appendable) = (repub) => apply(repub)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/password/republish.scala.html
                    HASH: ac23e7f696062e738e518174992159be3079775b
                    MATRIX: 834->1|999->55|1027->75|1064->78|1076->83|1114->113|1153->115|1196->124|1261->181|1300->183|1373->221|1406->246|1445->248|1512->280|1525->285|1566->305|1613->320|1663->334|1775->423|1892->509|1926->512
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|34->6|34->6|34->6|36->8|36->8|36->8|37->9|37->9|37->9|38->10|39->11|39->11|41->13|42->14
                    -- GENERATED --
                */
            