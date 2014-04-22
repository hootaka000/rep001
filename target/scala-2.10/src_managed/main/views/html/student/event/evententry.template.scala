
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
object evententry extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[controllers.forms.student.EventForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(eventForm: List[controllers.forms.student.EventForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import java.util.List;


Seq[Any](format.raw/*1.56*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/views/*6.7*/.html.student.main("申込")/*6.31*/ {_display_(Seq[Any](format.raw/*6.33*/("""
	<div>
		<h1>イベント申込</h1>
	    <table border=1>
	        <tr><td>予約状況</td><td>開催日</td><td>開催時間</td><td>会場名</td></tr>
			"""),_display_(Seq[Any](/*11.5*/for(i <- eventForm) yield /*11.24*/ {_display_(Seq[Any](format.raw/*11.26*/("""
				<tr>
						<td>
							"""),_display_(Seq[Any](/*14.9*/form(CSRF(controllers.student.routes.Event.confirm()))/*14.63*/ {_display_(Seq[Any](format.raw/*14.65*/("""
								<input type="hidden" class = "btn primary" name="eventScheduleId" value = """"),_display_(Seq[Any](/*15.85*/i/*15.86*/.eventScheduleId)),format.raw/*15.102*/(""""/>
								<input type="hidden" class = "btn primary" name="eventId" value = """"),_display_(Seq[Any](/*16.77*/i/*16.78*/.eventId)),format.raw/*16.86*/(""""/>
								<input type="hidden" class = "btn primary" name="entryUserId" value = """"),_display_(Seq[Any](/*17.81*/i/*17.82*/.entryUserId)),format.raw/*17.94*/(""""/>
								"""),_display_(Seq[Any](/*18.10*/if(i.message == "")/*18.29*/{_display_(Seq[Any](format.raw/*18.30*/("""
									<input type="submit" class = "btn primary" value = "予約"/>
								""")))}/*20.11*/else/*20.16*/{_display_(Seq[Any](format.raw/*20.17*/("""
									<label>"""),_display_(Seq[Any](/*21.18*/i/*21.19*/.message)),format.raw/*21.27*/("""</label>
								""")))})),format.raw/*22.10*/("""

							""")))})),format.raw/*24.9*/("""
						</td>
						<td><label>"""),_display_(Seq[Any](/*26.19*/i/*26.20*/.eventDate)),format.raw/*26.30*/("""</label></td>
						<td><label>"""),_display_(Seq[Any](/*27.19*/i/*27.20*/.eventTime)),format.raw/*27.30*/("""</label></td>
						<td><label>"""),_display_(Seq[Any](/*28.19*/i/*28.20*/.eventVenueName)),format.raw/*28.35*/("""</label></td>
				</tr>
			""")))})),format.raw/*30.5*/("""
		</table>
	<input type="button" class = "btn primary" value = "戻る" onclick="javascript:history.back();"/>
	</div>
""")))})),format.raw/*34.2*/("""
"""))}
    }
    
    def render(eventForm:List[controllers.forms.student.EventForm]): play.api.templates.HtmlFormat.Appendable = apply(eventForm)
    
    def f:((List[controllers.forms.student.EventForm]) => play.api.templates.HtmlFormat.Appendable) = (eventForm) => apply(eventForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/event/evententry.scala.html
                    HASH: 614458a42b279f5f424c26790a49563b57d18afa
                    MATRIX: 828->1|1018->55|1048->102|1085->105|1097->110|1129->134|1168->136|1329->262|1364->281|1404->283|1471->315|1534->369|1574->371|1696->457|1706->458|1745->474|1862->555|1872->556|1902->564|2023->649|2033->650|2067->662|2117->676|2145->695|2184->696|2282->776|2295->781|2334->782|2389->801|2399->802|2429->810|2480->829|2523->841|2592->874|2602->875|2634->885|2703->918|2713->919|2745->929|2814->962|2824->963|2861->978|2922->1008|3074->1129
                    LINES: 26->1|32->1|34->5|35->6|35->6|35->6|35->6|40->11|40->11|40->11|43->14|43->14|43->14|44->15|44->15|44->15|45->16|45->16|45->16|46->17|46->17|46->17|47->18|47->18|47->18|49->20|49->20|49->20|50->21|50->21|50->21|51->22|53->24|55->26|55->26|55->26|56->27|56->27|56->27|57->28|57->28|57->28|59->30|63->34
                    -- GENERATED --
                */
            