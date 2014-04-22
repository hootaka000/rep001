
package views.html.student.entry

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
object unsubscribe extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.1*/("""
"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.student.main("退会")/*3.31*/ {_display_(Seq[Any](format.raw/*3.33*/("""

    """),_display_(Seq[Any](/*5.6*/form(CSRF(controllers.student.routes.Entry.unsubscribe))/*5.62*/ {_display_(Seq[Any](format.raw/*5.64*/("""
        <p>本当に退会しますか？</p>
        <p><input type="submit" class="btn primary" value="退会"></p>
    """)))})),format.raw/*8.6*/("""
""")))})),format.raw/*9.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/entry/unsubscribe.scala.html
                    HASH: 560758abf50ade5b3c721d10aba061863a418095
                    MATRIX: 892->18|929->21|941->26|973->50|1012->52|1055->61|1119->117|1158->119|1291->222|1324->225
                    LINES: 30->2|31->3|31->3|31->3|31->3|33->5|33->5|33->5|36->8|37->9
                    -- GENERATED --
                */
            