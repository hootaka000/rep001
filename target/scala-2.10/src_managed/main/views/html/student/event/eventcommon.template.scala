
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
object eventcommon extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.student.EventForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(eventForm: Form[controllers.forms.student.EventForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.56*/("""

"""),format.raw/*4.1*/("""	    <table border=1>
	        <tr>
	        	<td>氏名</td><td>"""),_display_(Seq[Any](/*6.27*/eventForm/*6.36*/.get().entryUserName)),format.raw/*6.56*/("""</td>
	        </tr>
	        <tr>
	        	<td>ID</td><td>"""),_display_(Seq[Any](/*9.27*/eventForm/*9.36*/.get().entryUserIdEmail)),format.raw/*9.59*/("""</td>
	        </tr>
	        <tr>
	        	<td>開催日</td><td>"""),_display_(Seq[Any](/*12.28*/eventForm/*12.37*/.get().eventDate)),format.raw/*12.53*/("""</td>
	        </tr>
	        <tr>
	        	<td>開催時間</td><td>"""),_display_(Seq[Any](/*15.29*/eventForm/*15.38*/.get().eventTime)),format.raw/*15.54*/("""</td>
	        </tr>
	        <tr>
	        	<td>会場名</td><td><label>"""),_display_(Seq[Any](/*18.35*/eventForm/*18.44*/.get().eventVenueName)),format.raw/*18.65*/("""</label></td>
	        </tr>
	        <tr>
	        	<td>住所</td><td>"""),_display_(Seq[Any](/*21.27*/eventForm/*21.36*/.get().eventVenueAddress)),format.raw/*21.60*/("""</td>
	        </tr>
	        <tr>
	        	<td>問い合わせ</td><td>"""),_display_(Seq[Any](/*24.30*/eventForm/*24.39*/.get().eventContact)),format.raw/*24.58*/("""</td>
	        </tr>

	        """),_display_(Seq[Any](/*27.11*/for(i <- eventForm.get().eventTrans) yield /*27.47*/{_display_(Seq[Any](format.raw/*27.48*/("""
	        <tr >
		        <td>交通</td>
				<td>"""),_display_(Seq[Any](/*30.10*/i/*30.11*/.name)),format.raw/*30.16*/("""</td>
      		</tr >
	        """)))})),format.raw/*32.11*/("""

	        
	        """),_display_(Seq[Any](/*35.11*/for(j <- eventForm.get().eventAddTexts) yield /*35.50*/{_display_(Seq[Any](format.raw/*35.51*/("""
	        <tr>
	        	<td>"""),_display_(Seq[Any](/*37.16*/j/*37.17*/.title)),format.raw/*37.23*/("""</td>
	        	<td>"""),_display_(Seq[Any](/*38.16*/j/*38.17*/.message)),format.raw/*38.25*/("""</td>
	        </tr>
	        """)))})),format.raw/*40.11*/("""
	    </table>
		<input type="hidden" value=""""),_display_(Seq[Any](/*42.32*/eventForm/*42.41*/.get().eventScheduleId)),format.raw/*42.63*/("""" name="eventScheduleId">
		<input type="hidden" value=""""),_display_(Seq[Any](/*43.32*/eventForm/*43.41*/.get().entryUserId)),format.raw/*43.59*/("""" name="entryUserId">
		<input type="hidden" value=""""),_display_(Seq[Any](/*44.32*/eventForm/*44.41*/.get().eventId)),format.raw/*44.55*/("""" name="eventId">
		
"""))}
    }
    
    def render(eventForm:Form[controllers.forms.student.EventForm]): play.api.templates.HtmlFormat.Appendable = apply(eventForm)
    
    def f:((Form[controllers.forms.student.EventForm]) => play.api.templates.HtmlFormat.Appendable) = (eventForm) => apply(eventForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/event/eventcommon.scala.html
                    HASH: bf470d8e5f2660eaa074796e41b107636808890c
                    MATRIX: 829->1|994->55|1024->77|1123->141|1140->150|1181->170|1280->234|1297->243|1341->266|1442->331|1460->340|1498->356|1600->422|1618->431|1656->447|1764->519|1782->528|1825->549|1933->621|1951->630|1997->654|2100->721|2118->730|2159->749|2230->784|2282->820|2321->821|2407->871|2417->872|2444->877|2509->910|2570->935|2625->974|2664->975|2732->1007|2742->1008|2770->1014|2828->1036|2838->1037|2868->1045|2933->1078|3017->1126|3035->1135|3079->1157|3173->1215|3191->1224|3231->1242|3321->1296|3339->1305|3375->1319
                    LINES: 26->1|30->1|32->4|34->6|34->6|34->6|37->9|37->9|37->9|40->12|40->12|40->12|43->15|43->15|43->15|46->18|46->18|46->18|49->21|49->21|49->21|52->24|52->24|52->24|55->27|55->27|55->27|58->30|58->30|58->30|60->32|63->35|63->35|63->35|65->37|65->37|65->37|66->38|66->38|66->38|68->40|70->42|70->42|70->42|71->43|71->43|71->43|72->44|72->44|72->44
                    -- GENERATED --
                */
            