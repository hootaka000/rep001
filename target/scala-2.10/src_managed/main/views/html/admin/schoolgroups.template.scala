
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
object schoolgroups extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[controllers.forms.admin.AppYearForm],List[models.SchoolGroup],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(appYearForm: Form[controllers.forms.admin.AppYearForm])(schoolGroupList: List[models.SchoolGroup]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.101*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "大学グループ一覧画面")/*5.28*/ {_display_(Seq[Any](format.raw/*5.30*/("""

<script Language="JavaScript">
function getValue(selOBJ) """),format.raw/*8.27*/("""{"""),format.raw/*8.28*/("""
    document.selectYear.submit();
    """),format.raw/*10.5*/("""}"""),format.raw/*10.6*/("""
</script>

    <h1>大学グループ一覧画面:</h1>

    <table>
        <tr>
            <td>
                """),_display_(Seq[Any](/*18.18*/form(action=CSRF(controllers.admin.routes.SchoolGroup.gainSchoolGroups), 'name -> "selectYear")/*18.113*/ {_display_(Seq[Any](format.raw/*18.115*/("""

                    """),format.raw/*20.31*/("""
                    """),_display_(Seq[Any](/*21.22*/select(
                        field = appYearForm("applicationYear"),
                        options = options(
                            "-1" -> "20xx年度",
                            "2016" -> "2016年度",
                            "2015" -> "2015年度",
                            "2014" -> "2014年度"
                                  ),
                        args = '_label -> "採用年度", 'onchange -> "getValue(this)"
                    ))),format.raw/*30.22*/("""
                """)))})),format.raw/*31.18*/("""
            </td>
            <td><a href="schoolgroup/new">新規登録</a></td>
        </tr>
    </table>

    <hr>

    """),_display_(Seq[Any](/*39.6*/if(schoolGroupList != null)/*39.33*/ {_display_(Seq[Any](format.raw/*39.35*/("""

        <table border=1>
            <tr><td>大学グループ名</td><td>学生数</td><td>更新</td><td>メール</td><td>コメント</td><td>削除</td></tr>

            """),_display_(Seq[Any](/*44.14*/for(i <- schoolGroupList) yield /*44.39*/ {_display_(Seq[Any](format.raw/*44.41*/("""
                <tr>
                    <td>あああああ</td>
                    <td>20</td>
                    <td>"""),format.raw/*48.60*/("""</td>
                    <td>メール</td>
                    <td>コメント</td>
                    <td>削除</td>
                </tr>
            """)))})),format.raw/*53.14*/("""
        </table>
    """)))})),format.raw/*55.6*/("""


""")))})),format.raw/*58.2*/("""





"""))}
    }
    
    def render(appYearForm:Form[controllers.forms.admin.AppYearForm],schoolGroupList:List[models.SchoolGroup]): play.api.templates.HtmlFormat.Appendable = apply(appYearForm)(schoolGroupList)
    
    def f:((Form[controllers.forms.admin.AppYearForm]) => (List[models.SchoolGroup]) => play.api.templates.HtmlFormat.Appendable) = (appYearForm) => (schoolGroupList) => apply(appYearForm)(schoolGroupList)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:35 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/admin/schoolgroups.scala.html
                    HASH: 3e3aca4b276d84bf2a81818c3f82d8c918c147c5
                    MATRIX: 847->1|1058->100|1088->122|1125->125|1159->151|1198->153|1287->215|1315->216|1383->257|1411->258|1552->363|1657->458|1698->460|1750->494|1809->517|2282->968|2333->987|2494->1113|2530->1140|2570->1142|2749->1285|2790->1310|2830->1312|2975->1464|3152->1609|3208->1634|3246->1641
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|36->8|36->8|38->10|38->10|46->18|46->18|46->18|48->20|49->21|58->30|59->31|67->39|67->39|67->39|72->44|72->44|72->44|76->48|81->53|83->55|86->58
                    -- GENERATED --
                */
            