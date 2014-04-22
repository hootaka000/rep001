
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,Html,Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String, stylesheets: Html = Html(""), scripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.88*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*9.43*/("""
<!-- For HR -->

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
    """),_display_(Seq[Any](/*29.6*/content)),format.raw/*29.13*/("""
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
                    DATE: Tue Apr 22 11:38:35 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/admin/main.scala.html
                    HASH: 6a9239e677e631280472e4d8b38a4a63494f2d27
                    MATRIX: 794->1|991->87|1021->109|1050->221|1183->318|1210->323|1327->404|1342->410|1429->475|1480->491|1513->502|1627->580|1642->586|1722->644|1787->673|1802->679|1869->724|1936->755|1951->761|2011->799|2064->817|2093->824|2156->852|2185->859
                    LINES: 26->1|30->1|32->4|33->9|40->16|40->16|43->19|43->19|43->19|44->20|44->20|47->23|47->23|47->23|48->24|48->24|48->24|49->25|49->25|49->25|50->26|50->26|53->29|53->29
                    -- GENERATED --
                */
            