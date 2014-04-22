
package views.html.admin

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
object groups extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[controllers.forms.admin.AppYearForm],List[models.ComplexGroup],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(appYearForm: Form[controllers.forms.admin.AppYearForm])(complexGroupList: List[models.ComplexGroup]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.103*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "グループ一覧画面")/*5.26*/ {_display_(Seq[Any](format.raw/*5.28*/("""

<script Language="JavaScript">
function getValue(selOBJ) """),format.raw/*8.27*/("""{"""),format.raw/*8.28*/("""
    document.selectYear.submit();
    """),format.raw/*10.5*/("""}"""),format.raw/*10.6*/("""
</script>

    <h1>グループ一覧画面:</h1>

    """),_display_(Seq[Any](/*15.6*/form(action=CSRF(controllers.admin.routes.Group.gainGroupList), 'name -> "selectYear")/*15.92*/ {_display_(Seq[Any](format.raw/*15.94*/("""

        """),format.raw/*17.19*/("""
        """),_display_(Seq[Any](/*18.10*/select(
            field = appYearForm("applicationYear"),
            options = options(
                "-1" -> "20xx年度",
                "2016" -> "2016年度",
                "2015" -> "2015年度",
                "2014" -> "2014年度"
                      ),
            args = '_label -> "採用年度", 'onchange -> "getValue(this)"
        ))),format.raw/*27.10*/("""
    """)))})),format.raw/*28.6*/("""

    <hr>

    """),_display_(Seq[Any](/*32.6*/if(complexGroupList != null)/*32.34*/ {_display_(Seq[Any](format.raw/*32.36*/("""

        <table border=1>
            <tr><td>グループ名</td><td>学生数</td><td>更新</td><td>メール</td><td>コメント</td><td>削除</td></tr>

            """),_display_(Seq[Any](/*37.14*/for(i <- complexGroupList) yield /*37.40*/ {_display_(Seq[Any](format.raw/*37.42*/("""
                <tr>
                    <td>あああああ</td>
                    <td>20</td>
                    <td>"""),format.raw/*41.60*/("""</td>
                    <td>メール</td>
                    <td>コメント</td>
                    <td>削除</td>
                </tr>
            """)))})),format.raw/*46.14*/("""
        </table>
    """)))})),format.raw/*48.6*/("""


""")))})),format.raw/*51.2*/("""





"""))}
    }
    
    def render(appYearForm:Form[controllers.forms.admin.AppYearForm],complexGroupList:List[models.ComplexGroup]): play.api.templates.HtmlFormat.Appendable = apply(appYearForm)(complexGroupList)
    
    def f:((Form[controllers.forms.admin.AppYearForm]) => (List[models.ComplexGroup]) => play.api.templates.HtmlFormat.Appendable) = (appYearForm) => (complexGroupList) => apply(appYearForm)(complexGroupList)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:34 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/admin/groups.scala.html
                    HASH: c544a770b10776bbc8bb107cc8bd995deab2becc
                    MATRIX: 842->1|1055->102|1085->124|1122->127|1154->151|1193->153|1282->215|1310->216|1378->257|1406->258|1487->304|1582->390|1622->392|1662->414|1709->425|2074->768|2112->775|2168->796|2205->824|2245->826|2422->967|2464->993|2504->995|2649->1147|2826->1292|2882->1317|2920->1324
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|36->8|36->8|38->10|38->10|43->15|43->15|43->15|45->17|46->18|55->27|56->28|60->32|60->32|60->32|65->37|65->37|65->37|69->41|74->46|76->48|79->51
                    -- GENERATED --
                */
            