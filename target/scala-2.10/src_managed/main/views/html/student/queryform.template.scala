
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
object queryform extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.QueryForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(queryForm: Form[controllers.forms.QueryForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.48*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("お問い合わせフォーム")/*5.20*/ {_display_(Seq[Any](format.raw/*5.22*/("""
	"""),_display_(Seq[Any](/*6.3*/form(CSRF(controllers.student.routes.Query.confirm))/*6.55*/ {_display_(Seq[Any](format.raw/*6.57*/("""
		<h1>お問い合わせフォーム</h1>
		"""),_display_(Seq[Any](/*8.4*/if(queryForm.hasGlobalErrors)/*8.33*/ {_display_(Seq[Any](format.raw/*8.35*/("""
		    <p class="error">"""),_display_(Seq[Any](/*9.25*/queryForm/*9.34*/.globalError.message)),format.raw/*9.54*/("""</p>
		""")))})),format.raw/*10.4*/("""

			<table class="table-bordered" border="1">
				<tr>
					<td>◆漢字氏名</td>
					<td>
					    """),_display_(Seq[Any](/*16.11*/inputText(queryForm("lastName"), '_label -> "姓 : " , '_class -> "line-input", '_showConstraints -> false))),format.raw/*16.116*/("""
					</td>
					<td>
					    """),_display_(Seq[Any](/*19.11*/inputText(queryForm("firstName"), '_label -> "名 : " , '_class -> "line-input", '_showConstraints -> false))),format.raw/*19.117*/("""
					</td>
				</tr>
				<tr>
					<td>◆E-mailアドレス</td>
					<td colspan=2>
						"""),_display_(Seq[Any](/*25.8*/inputText(queryForm("email"), '_label -> "" ,'_class -> "line-input", 'style->"width:350px;", 'placeholder -> "yamada@cyberagent.co.jp", '_showConstraints -> false))),format.raw/*25.172*/("""
					</td>
				</tr>
				<tr>
					<td>IDお持ちの方</td>
					<td colspan=2>
					"""),_display_(Seq[Any](/*31.7*/inputText(queryForm("entryUser"), '_label -> "ID : " ,'_class -> "line-input", '_showConstraints -> false))),format.raw/*31.113*/("""
					</td>
				</tr>
				<tr>
					<td>◆お問い合わせ</td>
					<td colspan=2>"""),_display_(Seq[Any](/*36.21*/inputRadioGroup(
							queryForm("iqType"),
								options = Seq("0" -> "ID・パスワードについて"
											, "1" -> "選考について"
											, "99" -> "その他"),
									'_label -> "", '_showConstraints -> false))),format.raw/*41.52*/("""
					</td>
				</tr>
				<tr>
					<td>◆お問い合わせ内容(1000文字以内でご記入ください。)</td>
					<td colspan=2>
					    """),_display_(Seq[Any](/*47.11*/textarea(queryForm("content"), '_label -> "" , '_class -> "line-input", '_showConstraints -> false))),format.raw/*47.110*/("""
					</td>
				</tr>
			</table>
			<label class="control-label"></label>
			<input type="submit" class="btn primary" value="登録">

	""")))})),format.raw/*54.3*/("""
	"""),_display_(Seq[Any](/*55.3*/form(CSRF(controllers.student.routes.Query.index))/*55.53*/ {_display_(Seq[Any](format.raw/*55.55*/("""
		<input type="submit" class="btn primary" value="戻る"  onclick="javascript:history.back();">
	""")))})),format.raw/*57.3*/("""
""")))})),format.raw/*58.2*/("""
"""))}
    }
    
    def render(queryForm:Form[controllers.forms.QueryForm]): play.api.templates.HtmlFormat.Appendable = apply(queryForm)
    
    def f:((Form[controllers.forms.QueryForm]) => play.api.templates.HtmlFormat.Appendable) = (queryForm) => apply(queryForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/queryform.scala.html
                    HASH: 00dcf5de74997ffc5c5465340b16404893fc8ce7
                    MATRIX: 813->1|970->47|1000->69|1037->72|1063->90|1102->92|1140->96|1200->148|1239->150|1301->178|1338->207|1377->209|1438->235|1455->244|1496->264|1536->273|1674->375|1802->480|1873->515|2002->621|2127->711|2314->875|2434->960|2563->1066|2677->1144|2902->1347|3048->1457|3170->1556|3342->1697|3381->1701|3440->1751|3480->1753|3609->1851|3643->1854
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|34->6|34->6|34->6|36->8|36->8|36->8|37->9|37->9|37->9|38->10|44->16|44->16|47->19|47->19|53->25|53->25|59->31|59->31|64->36|69->41|75->47|75->47|82->54|83->55|83->55|83->55|85->57|86->58
                    -- GENERATED --
                */
            