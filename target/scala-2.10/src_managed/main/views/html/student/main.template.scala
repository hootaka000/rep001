
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,Html,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, stylesheets: Html = Html(""), scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.88*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*9.43*/("""
<!-- For Student -->

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf8" />
    <title>"""),_display_(Seq[Any](/*16.13*/title)),format.raw/*16.18*/("""</title>
    <link rel="stylesheet"
          media="screen"
          href=""""),_display_(Seq[Any](/*19.18*/routes/*19.24*/.Assets.at("stylesheets/" + lang().language() + "/saiyo.min.css"))),format.raw/*19.89*/(""""></link>
    """),_display_(Seq[Any](/*20.6*/stylesheets)),format.raw/*20.17*/("""
    <link rel="shortcut icon"
          type="image/png"
          href=""""),_display_(Seq[Any](/*23.18*/routes/*23.24*/.Assets.at("images/" + lang().language() + "/favicon.png"))),format.raw/*23.82*/(""""></link>
    <script src=""""),_display_(Seq[Any](/*24.19*/routes/*24.25*/.Assets.at("javascripts/jquery-2.1.0.min.js"))),format.raw/*24.70*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*25.19*/routes/*25.25*/.Assets.at("javascripts/saiyo.min.js"))),format.raw/*25.63*/(""""></script>
    """),_display_(Seq[Any](/*26.6*/scripts)),format.raw/*26.13*/("""
  </head>
  <body>
    """),_display_(Seq[Any](/*29.6*/if(session.get("entry_user_id") != null)/*29.46*/ {_display_(Seq[Any](format.raw/*29.48*/("""
      """),_display_(Seq[Any](/*30.8*/form(CSRF(controllers.student.routes.Application.logout))/*30.65*/ {_display_(Seq[Any](format.raw/*30.67*/("""
        <p><input type="submit" class="btn primary" value="ログアウト"></p>
      """)))})),format.raw/*32.8*/("""
    """)))})),format.raw/*33.6*/("""
    """),_display_(Seq[Any](/*34.6*/content)),format.raw/*34.13*/("""
  </body>
</html>
"""))}
    }
    
    def render(title:String,stylesheets:Html,scripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,stylesheets,scripts)(content)
    
    def f:((String,Html,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,stylesheets,scripts) => (content) => apply(title,stylesheets,scripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/main.scala.html
                    HASH: 65760035bf327d25d6a5a484b3697e97ab2a86ed
                    MATRIX: 796->1|993->87|1023->109|1052->221|1190->323|1217->328|1334->409|1349->415|1436->480|1487->496|1520->507|1634->585|1649->591|1729->649|1794->678|1809->684|1876->729|1943->760|1958->766|2018->804|2071->822|2100->829|2163->857|2212->897|2252->899|2296->908|2362->965|2402->967|2514->1048|2552->1055|2594->1062|2623->1069
                    LINES: 26->1|30->1|32->4|33->9|40->16|40->16|43->19|43->19|43->19|44->20|44->20|47->23|47->23|47->23|48->24|48->24|48->24|49->25|49->25|49->25|50->26|50->26|53->29|53->29|53->29|54->30|54->30|54->30|56->32|57->33|58->34|58->34
                    -- GENERATED --
                */
            