
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
object query extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.QueryForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(queryForm: Form[controllers.forms.QueryForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.48*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("お問い合わせ")/*5.16*/ {_display_(Seq[Any](format.raw/*5.18*/("""
"""),_display_(Seq[Any](/*6.2*/form(CSRF(controllers.student.routes.Query.view))/*6.51*/ {_display_(Seq[Any](format.raw/*6.53*/("""
    <h1>お問い合わせ</h1>
    """),_display_(Seq[Any](/*8.6*/if(queryForm.hasGlobalErrors)/*8.35*/ {_display_(Seq[Any](format.raw/*8.37*/("""
        <p class="error">"""),_display_(Seq[Any](/*9.27*/queryForm/*9.36*/.globalError.message)),format.raw/*9.56*/("""</p>
    """)))})),format.raw/*10.6*/("""
<div class="container">
	<label class="control-label"></label>
	<table class="table-bordered" >
		<tr>
			<td>
				<label>link：</label>
				<a href=""""),_display_(Seq[Any](/*17.15*/controllers/*17.26*/.student.routes.Query.view)),format.raw/*17.52*/("""">お問い合わせ</a>
			</td>
		</tr>
		<tr>
			<td>
				<label>ボタン：</label>
				<input type="submit" class = "btn primary" value = "お問い合わせ"/>
			</td>
		</tr>
	</table>
	<input type="button" class="btn primary" value="戻る"  onclick="javascript:history.back();">
</div>
  """)))})),format.raw/*29.4*/("""
""")))})),format.raw/*30.2*/("""
"""))}
    }
    
    def render(queryForm:Form[controllers.forms.QueryForm]): play.api.templates.HtmlFormat.Appendable = apply(queryForm)
    
    def f:((Form[controllers.forms.QueryForm]) => play.api.templates.HtmlFormat.Appendable) = (queryForm) => apply(queryForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/query.scala.html
                    HASH: 3a12bcd1065e56f64b3cb64ebab41aae26bf8fe0
                    MATRIX: 809->1|966->47|996->69|1033->72|1055->86|1094->88|1131->91|1188->140|1227->142|1289->170|1326->199|1365->201|1428->229|1445->238|1486->258|1528->269|1722->427|1742->438|1790->464|2097->740|2131->743
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|34->6|34->6|34->6|36->8|36->8|36->8|37->9|37->9|37->9|38->10|45->17|45->17|45->17|57->29|58->30
                    -- GENERATED --
                */
            