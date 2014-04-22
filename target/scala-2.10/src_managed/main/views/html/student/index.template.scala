
package views.html.student

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.student.LoginForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(login: Form[controllers.forms.student.LoginForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.student.main("ログイン")/*4.33*/ {_display_(Seq[Any](format.raw/*4.35*/("""

    <a href=""""),_display_(Seq[Any](/*6.15*/controllers/*6.26*/.student.routes.Application.agree)),format.raw/*6.59*/("""">新規登録</a>
    """),_display_(Seq[Any](/*7.6*/form(CSRF(controllers.student.routes.Application.login))/*7.62*/ {_display_(Seq[Any](format.raw/*7.64*/("""
        <h2>ログイン</h2>
        """),_display_(Seq[Any](/*9.10*/if(login.hasGlobalErrors)/*9.35*/ {_display_(Seq[Any](format.raw/*9.37*/("""
          <p class="error">"""),_display_(Seq[Any](/*10.29*/login/*10.34*/.globalError.message)),format.raw/*10.54*/("""</p>
        """)))})),format.raw/*11.10*/("""
        <p>"""),_display_(Seq[Any](/*12.13*/inputText(login("email"), '_label -> "E-Mail", '_class -> "line-input", 'type -> "email", '_error -> login.error("email")))),format.raw/*12.135*/("""</p>
        <p>"""),_display_(Seq[Any](/*13.13*/inputPassword(login("password"), '_label -> "Password", '_class -> "line-input", 'type -> "password", '_error -> login.error("password")))),format.raw/*13.150*/("""</p>
        <p>"""),_display_(Seq[Any](/*14.13*/checkbox(login("saveEmail"), '_label -> None, '_text -> "ログイン情報（メールアドレス）を保存する", '_showConstraints -> false))),format.raw/*14.120*/("""</p>
        <p><input type="submit" class="btn primary" value="ログイン"></p>
    """)))})),format.raw/*16.6*/("""
    <p><a href=""""),_display_(Seq[Any](/*17.18*/controllers/*17.29*/.student.routes.Password.viewRepublish)),format.raw/*17.67*/("""">パスワードを忘れた方はこちら</a></p>
    <p><a href=""""),_display_(Seq[Any](/*18.18*/controllers/*18.29*/.student.routes.Query.index)),format.raw/*18.56*/("""">お問い合わせ</a></p>
""")))})),format.raw/*19.2*/("""
"""))}
    }
    
    def render(login:Form[controllers.forms.student.LoginForm]): play.api.templates.HtmlFormat.Appendable = apply(login)
    
    def f:((Form[controllers.forms.student.LoginForm]) => play.api.templates.HtmlFormat.Appendable) = (login) => apply(login)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/index.scala.html
                    HASH: c4a5bfa6c64251cae83e4d94d57e5d3eb30d550f
                    MATRIX: 817->1|978->51|1006->71|1043->74|1055->79|1089->105|1128->107|1181->125|1200->136|1254->169|1305->186|1369->242|1408->244|1477->278|1510->303|1549->305|1615->335|1629->340|1671->360|1718->375|1768->389|1913->511|1967->529|2127->666|2181->684|2311->791|2424->873|2479->892|2499->903|2559->941|2638->984|2658->995|2707->1022|2757->1041
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|34->6|34->6|34->6|35->7|35->7|35->7|37->9|37->9|37->9|38->10|38->10|38->10|39->11|40->12|40->12|41->13|41->13|42->14|42->14|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19
                    -- GENERATED --
                */
            