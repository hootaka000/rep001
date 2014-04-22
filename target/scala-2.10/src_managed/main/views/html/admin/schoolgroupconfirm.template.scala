
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
object schoolgroupconfirm extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.admin.SchoolSearchForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ssfForm: Form[controllers.forms.admin.SchoolSearchForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.59*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "大学グループ登録確認画面")/*5.30*/ {_display_(Seq[Any](format.raw/*5.32*/("""

    <h1>大学グループ登録確認画面:</h1>

    <hr>

    """),_display_(Seq[Any](/*11.6*/form(CSRF(controllers.admin.routes.SchoolGroup.register))/*11.63*/ {_display_(Seq[Any](format.raw/*11.65*/("""

        <label for="schoolGroupName">"""),_display_(Seq[Any](/*13.39*/ssfForm/*13.46*/.get().schoolGroupName)),format.raw/*13.68*/("""</label>

        <table border=1>
            <tr><td>大学</td><td>学部</td><td>学科</td></tr>
            """),format.raw/*25.17*/("""
        </table>

        <p class="buttons">
            <input type="submit" value="登録">
            <input type="button" value="戻る" onclick="history.back();">
        <p>

    """)))})),format.raw/*33.6*/("""

""")))})),format.raw/*35.2*/("""





"""))}
    }
    
    def render(ssfForm:Form[controllers.forms.admin.SchoolSearchForm]): play.api.templates.HtmlFormat.Appendable = apply(ssfForm)
    
    def f:((Form[controllers.forms.admin.SchoolSearchForm]) => play.api.templates.HtmlFormat.Appendable) = (ssfForm) => apply(ssfForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:35 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/admin/schoolgroupconfirm.scala.html
                    HASH: 19848abf3af805c14d1ead4f6655669b1f233299
                    MATRIX: 833->1|1001->58|1031->80|1068->83|1104->111|1143->113|1229->164|1295->221|1335->223|1413->265|1429->272|1473->294|1607->763|1827->952|1863->957
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|39->11|39->11|39->11|41->13|41->13|41->13|45->25|53->33|55->35
                    -- GENERATED --
                */
            