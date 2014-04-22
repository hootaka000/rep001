
package views.html.student.event

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
object eventview extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.student.EventForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(eventForm: Form[controllers.forms.student.EventForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.56*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.student.main("申込確認")/*5.33*/ {_display_(Seq[Any](format.raw/*5.35*/("""
<h1>イベント確認画面</h1>
<h3>"""),_display_(Seq[Any](/*7.6*/eventForm/*7.15*/.get().eventName)),format.raw/*7.31*/("""</h3>
	"""),_display_(Seq[Any](/*8.3*/if(eventForm.get().message != null)/*8.38*/ {_display_(Seq[Any](format.raw/*8.40*/("""
		"""),_display_(Seq[Any](/*9.4*/eventForm/*9.13*/.get().message)),format.raw/*9.27*/("""
	""")))})),format.raw/*10.3*/("""
    """),_display_(Seq[Any](/*11.6*/form(CSRF(controllers.student.routes.Event.confirmCancel))/*11.64*/ {_display_(Seq[Any](format.raw/*11.66*/("""

		"""),_display_(Seq[Any](/*13.4*/eventcommon(eventForm))),format.raw/*13.26*/("""

		<input type="button" class = "btn primary" value = "戻る" onclick="javascript:history.back();"/>
		"""),_display_(Seq[Any](/*16.4*/if(eventForm.get().message == null)/*16.39*/{_display_(Seq[Any](format.raw/*16.40*/("""
		    <input type="submit" class = "btn primary" value = "キャンセル確認"/>
		""")))})),format.raw/*18.4*/("""
    """)))})),format.raw/*19.6*/("""
""")))})))}
    }
    
    def render(eventForm:Form[controllers.forms.student.EventForm]): play.api.templates.HtmlFormat.Appendable = apply(eventForm)
    
    def f:((Form[controllers.forms.student.EventForm]) => play.api.templates.HtmlFormat.Appendable) = (eventForm) => apply(eventForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/event/eventview.scala.html
                    HASH: 326abba9a7a42c43c2c495852e808d936f4ba516
                    MATRIX: 827->1|992->55|1022->77|1059->80|1071->85|1105->111|1144->113|1204->139|1221->148|1258->164|1301->173|1344->208|1383->210|1422->215|1439->224|1474->238|1509->242|1551->249|1618->307|1658->309|1700->316|1744->338|1884->443|1928->478|1967->479|2073->554|2111->561
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|39->11|39->11|39->11|41->13|41->13|44->16|44->16|44->16|46->18|47->19
                    -- GENERATED --
                */
            