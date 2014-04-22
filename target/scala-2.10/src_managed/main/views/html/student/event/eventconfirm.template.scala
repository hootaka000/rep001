
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
object eventconfirm extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.student.EventForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(eventForm: Form[controllers.forms.student.EventForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.56*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.student.main("申込確認")/*5.33*/ {_display_(Seq[Any](format.raw/*5.35*/("""

<h1>イベント申込確認画面</h1>
<h3>"""),_display_(Seq[Any](/*8.6*/eventForm/*8.15*/.get().eventName)),format.raw/*8.31*/("""</h3>
	"""),_display_(Seq[Any](/*9.3*/if(eventForm.get().message != null)/*9.38*/{_display_(Seq[Any](format.raw/*9.39*/("""
		"""),_display_(Seq[Any](/*10.4*/eventForm/*10.13*/.get().message)),format.raw/*10.27*/("""
	""")))})),format.raw/*11.3*/("""
     """),_display_(Seq[Any](/*12.7*/helper/*12.13*/.form(action=CSRF(controllers.student.routes.Event.register), 'class -> "form-horizontal", 'id -> "eventForm")/*12.123*/ {_display_(Seq[Any](format.raw/*12.125*/("""

		"""),_display_(Seq[Any](/*14.4*/eventcommon(eventForm))),format.raw/*14.26*/("""

		<input type="button" class = "btn primary" value = "戻る" onclick="javascript:history.back();"/>
		"""),_display_(Seq[Any](/*17.4*/if(eventForm.get().message == null)/*17.39*/{_display_(Seq[Any](format.raw/*17.40*/("""
			<input type="submit" class = "btn primary" value = "送信"/>
		""")))})),format.raw/*19.4*/("""

	""")))})),format.raw/*21.3*/("""
""")))})))}
    }
    
    def render(eventForm:Form[controllers.forms.student.EventForm]): play.api.templates.HtmlFormat.Appendable = apply(eventForm)
    
    def f:((Form[controllers.forms.student.EventForm]) => play.api.templates.HtmlFormat.Appendable) = (eventForm) => apply(eventForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/event/eventconfirm.scala.html
                    HASH: 3bd4d0d51108a0185a56c1591c284dc80b329bd7
                    MATRIX: 830->1|995->55|1025->77|1062->80|1074->85|1108->111|1147->113|1211->143|1228->152|1265->168|1308->177|1351->212|1389->213|1429->218|1447->227|1483->241|1518->245|1561->253|1576->259|1696->369|1737->371|1779->378|1823->400|1963->505|2007->540|2046->541|2144->608|2181->614
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|33->5|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|40->12|40->12|40->12|40->12|42->14|42->14|45->17|45->17|45->17|47->19|49->21
                    -- GENERATED --
                */
            