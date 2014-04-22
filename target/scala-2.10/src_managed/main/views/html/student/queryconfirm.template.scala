
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
object queryconfirm extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.QueryForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(queryForm: Form[controllers.forms.QueryForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.api.data.Form

import play.api.data.Forms._


Seq[Any](format.raw/*1.48*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("お問い合わせ確認")/*7.18*/ {_display_(Seq[Any](format.raw/*7.20*/("""
"""),format.raw/*11.46*/("""
	"""),_display_(Seq[Any](/*12.3*/form(CSRF(controllers.student.routes.Query.send))/*12.52*/ {_display_(Seq[Any](format.raw/*12.54*/("""
		<h1>お問い合わせ確認</h1>
		"""),_display_(Seq[Any](/*14.4*/if(queryForm.hasGlobalErrors)/*14.33*/ {_display_(Seq[Any](format.raw/*14.35*/("""
		    <p class="error">"""),_display_(Seq[Any](/*15.25*/queryForm/*15.34*/.globalError.message)),format.raw/*15.54*/("""</p>
		""")))})),format.raw/*16.4*/("""
		<div>
		<table class="table-bordered" border="1">
			<tr>
				<td>お名前(漢字)</td>
				<td>
					<label for="lastName">"""),_display_(Seq[Any](/*22.29*/queryForm/*22.38*/.get().lastName)),format.raw/*22.53*/("""</label>
				</td>
				<td>
					<label for="firstName">"""),_display_(Seq[Any](/*25.30*/queryForm/*25.39*/.get().firstName)),format.raw/*25.55*/("""</label>
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td colspan=2>
					<label for="email">"""),_display_(Seq[Any](/*31.26*/queryForm/*31.35*/.get().email)),format.raw/*31.47*/("""</label>
				</td>
			</tr>
			<tr>
				<td>IDお持ちの方</td>
				<td colspan=2>
					<label for="entryUser">"""),_display_(Seq[Any](/*37.30*/queryForm/*37.39*/.get().entryUser)),format.raw/*37.55*/("""</label>
				</td>
			</tr>
			<tr>
				<td>お問い合わせ</td>
				<td colspan=2>
					<label for="iqtype">"""),_display_(Seq[Any](/*43.27*/queryForm/*43.36*/.get().iqType)),format.raw/*43.49*/("""</label>
				</td>
			</tr>
			<tr>
				<td>お問い合わせ内容</td>
				<td colspan=2>
					<label for="content">"""),_display_(Seq[Any](/*49.28*/queryForm/*49.37*/.get().content)),format.raw/*49.51*/("""</label>
				</td>
			</tr>
		</table>

		<input type="submit" class = "btn primary" value = "確定"/>
		<input type="hidden" value=""""),_display_(Seq[Any](/*55.32*/queryForm/*55.41*/.get().lastName)),format.raw/*55.56*/("""" name="lastName">
		<input type="hidden" value=""""),_display_(Seq[Any](/*56.32*/queryForm/*56.41*/.get().firstName)),format.raw/*56.57*/("""" name="firstName">
		<input type="hidden" value=""""),_display_(Seq[Any](/*57.32*/queryForm/*57.41*/.get().email)),format.raw/*57.53*/("""" name="email">
		<input type="hidden" value=""""),_display_(Seq[Any](/*58.32*/queryForm/*58.41*/.get().entryUser)),format.raw/*58.57*/("""" name="entryUser">
		<input type="hidden" value=""""),_display_(Seq[Any](/*59.32*/queryForm/*59.41*/.get().iqType)),format.raw/*59.54*/("""" name="iqType">
		<input type="hidden" value=""""),_display_(Seq[Any](/*60.32*/queryForm/*60.41*/.get().content)),format.raw/*60.55*/("""" name="content">
	""")))})),format.raw/*61.3*/("""
		<input type="button" class = "btn primary" value = "修正する"  onclick="javascript:history.back();"/>
</div>
""")))})),format.raw/*64.2*/("""
"""))}
    }
    
    def render(queryForm:Form[controllers.forms.QueryForm]): play.api.templates.HtmlFormat.Appendable = apply(queryForm)
    
    def f:((Form[controllers.forms.QueryForm]) => play.api.templates.HtmlFormat.Appendable) = (queryForm) => apply(queryForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/queryconfirm.scala.html
                    HASH: 969239e3520cdcca3eff148d516f5d9f44dd45b0
                    MATRIX: 816->1|1032->47|1062->128|1099->131|1123->147|1162->149|1192->298|1231->302|1289->351|1329->353|1390->379|1428->408|1468->410|1530->436|1548->445|1590->465|1630->474|1791->599|1809->608|1846->623|1942->683|1960->692|1998->708|2139->813|2157->822|2191->834|2338->945|2356->954|2394->970|2537->1077|2555->1086|2590->1099|2736->1209|2754->1218|2790->1232|2963->1369|2981->1378|3018->1393|3105->1444|3123->1453|3161->1469|3249->1521|3267->1530|3301->1542|3385->1590|3403->1599|3441->1615|3529->1667|3547->1676|3582->1689|3667->1738|3685->1747|3721->1761|3773->1782|3916->1894
                    LINES: 26->1|34->1|36->6|37->7|37->7|37->7|38->11|39->12|39->12|39->12|41->14|41->14|41->14|42->15|42->15|42->15|43->16|49->22|49->22|49->22|52->25|52->25|52->25|58->31|58->31|58->31|64->37|64->37|64->37|70->43|70->43|70->43|76->49|76->49|76->49|82->55|82->55|82->55|83->56|83->56|83->56|84->57|84->57|84->57|85->58|85->58|85->58|86->59|86->59|86->59|87->60|87->60|87->60|88->61|91->64
                    -- GENERATED --
                */
            