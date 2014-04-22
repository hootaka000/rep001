
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
object eventcancel extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.student.EventForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(eventForm: Form[controllers.forms.student.EventForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.56*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/views/*5.7*/.html.student.main("申込確認")/*5.33*/ {_display_(Seq[Any](format.raw/*5.35*/("""

<h1>申込キャンセル画面</h1>
	"""),_display_(Seq[Any](/*8.3*/if(eventForm.get().message != null)/*8.38*/ {_display_(Seq[Any](format.raw/*8.40*/("""
		"""),_display_(Seq[Any](/*9.4*/eventForm/*9.13*/.get().message)),format.raw/*9.27*/("""
	""")))})),format.raw/*10.3*/("""
	<h4>以下の情報をキャンセルします。</h4>
	<h4>よろしければ、送信ボタンを押してください。</h4>
     """),_display_(Seq[Any](/*13.7*/form(CSRF(controllers.student.routes.Event.cancel))/*13.58*/ {_display_(Seq[Any](format.raw/*13.60*/("""
	<table border="1">
     	<tr><td><label>氏名</label></td><td>"""),_display_(Seq[Any](/*15.42*/eventForm/*15.51*/.get().entryUserName)),format.raw/*15.71*/("""</td></tr>
	    <tr><td><label>ID</label></td><td>"""),_display_(Seq[Any](/*16.41*/eventForm/*16.50*/.get().entryUserId)),format.raw/*16.68*/("""</td></tr>
     	<tr><td><label>開催日</label></td><td>"""),_display_(Seq[Any](/*17.43*/eventForm/*17.52*/.get().eventDate)),format.raw/*17.68*/("""</td></tr>
     	<tr><td><label>イベント名</label></td><td>"""),_display_(Seq[Any](/*18.45*/eventForm/*18.54*/.get().eventName)),format.raw/*18.70*/("""</td></tr>
     	<tr><td><label>会場名</label></td><td>"""),_display_(Seq[Any](/*19.43*/eventForm/*19.52*/.get().eventVenueName)),format.raw/*19.73*/("""</td></tr>
     </table>
		<input type="hidden" value=""""),_display_(Seq[Any](/*21.32*/eventForm/*21.41*/.get().entryUserId)),format.raw/*21.59*/("""" name="entryUserId">
		<input type="hidden" value=""""),_display_(Seq[Any](/*22.32*/eventForm/*22.41*/.get().eventScheduleId)),format.raw/*22.63*/("""" name="eventScheduleId">
		<input type="hidden" value=""""),_display_(Seq[Any](/*23.32*/eventForm/*23.41*/.get().eventId)),format.raw/*23.55*/("""" name="eventId">
	    <input type="button" class = "btn primary" value = "戻る" onclick="javascript:history.back();"/>
	    <input type="submit" class = "btn primary" value = "送信"/>
     """)))})),format.raw/*26.7*/("""
""")))})))}
    }
    
    def render(eventForm:Form[controllers.forms.student.EventForm]): play.api.templates.HtmlFormat.Appendable = apply(eventForm)
    
    def f:((Form[controllers.forms.student.EventForm]) => play.api.templates.HtmlFormat.Appendable) = (eventForm) => apply(eventForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/event/eventcancel.scala.html
                    HASH: 78c9e7f30881e8356edfd1b1e6ce0560f1ac6b0a
                    MATRIX: 829->1|994->55|1024->77|1061->80|1073->85|1107->111|1146->113|1206->139|1249->174|1288->176|1327->181|1344->190|1379->204|1414->208|1517->276|1577->327|1617->329|1717->393|1735->402|1777->422|1865->474|1883->483|1923->501|2013->555|2031->564|2069->580|2161->636|2179->645|2217->661|2307->715|2325->724|2368->745|2462->803|2480->812|2520->830|2610->884|2628->893|2672->915|2766->973|2784->982|2820->996|3041->1186
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|33->5|36->8|36->8|36->8|37->9|37->9|37->9|38->10|41->13|41->13|41->13|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|47->19|47->19|47->19|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|54->26
                    -- GENERATED --
                */
            