
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
object completed extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[controllers.forms.student.CompletedForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(completed: controllers.forms.student.CompletedForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.54*/("""
"""),format.raw/*3.1*/("""
"""),_display_(Seq[Any](/*4.2*/views/*4.7*/.html.student.main(completed.message + "完了")/*4.51*/ {_display_(Seq[Any](format.raw/*4.53*/("""

    <p>"""),_display_(Seq[Any](/*6.9*/{completed.message})),format.raw/*6.28*/("""が完了しました。</p>
    <p><a href=""""),_display_(Seq[Any](/*7.18*/completed/*7.27*/.nextUrl)),format.raw/*7.35*/("""">"""),_display_(Seq[Any](/*7.38*/completed/*7.47*/.nextText)),format.raw/*7.56*/("""</a>
""")))})),format.raw/*8.2*/("""
"""))}
    }
    
    def render(completed:controllers.forms.student.CompletedForm): play.api.templates.HtmlFormat.Appendable = apply(completed)
    
    def f:((controllers.forms.student.CompletedForm) => play.api.templates.HtmlFormat.Appendable) = (completed) => apply(completed)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/completed.scala.html
                    HASH: 60f32adf61c1e9d79a0d5cdcccd638302bbb5916
                    MATRIX: 819->1|982->53|1010->73|1047->76|1059->81|1111->125|1150->127|1196->139|1236->158|1302->189|1319->198|1348->206|1386->209|1403->218|1433->227|1470->234
                    LINES: 26->1|30->1|31->3|32->4|32->4|32->4|32->4|34->6|34->6|35->7|35->7|35->7|35->7|35->7|35->7|36->8
                    -- GENERATED --
                */
            