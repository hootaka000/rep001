
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
object schoolgroupnew extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[controllers.forms.admin.SchoolSearchForm],controllers.forms.admin.SchoolSearchForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(schoolSearchForm: Form[controllers.forms.admin.SchoolSearchForm])(ssf: controllers.forms.admin.SchoolSearchForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.115*/("""

"""),format.raw/*4.1*/("""
<script Language="JavaScript">
function goReturn() """),format.raw/*6.21*/("""{"""),format.raw/*6.22*/("""
    location.href = "/admin/schoolgroups";
    """),format.raw/*8.5*/("""}"""),format.raw/*8.6*/("""
</script>

"""),_display_(Seq[Any](/*11.2*/main(title = "大学グループ登録画面")/*11.28*/ {_display_(Seq[Any](format.raw/*11.30*/("""

    <h1>大学グループ登録画面:</h1>

    """),_display_(Seq[Any](/*15.6*/form(CSRF(controllers.admin.routes.SchoolGroup.searchSchool))/*15.67*/ {_display_(Seq[Any](format.raw/*15.69*/("""

        <table border=0>
            <tr>
                <td>
                    """),format.raw/*20.29*/("""
                    """),_display_(Seq[Any](/*21.22*/select(
                        field = schoolSearchForm("prefectures.area"),
                        options = options(
                            "1" -> "北海道・東北",
                            "2" -> "関東",
                            "3" -> "中部",
                            "4" -> "近畿",
                            "5" -> "中国",
                            "6" -> "四国",
                            "7" -> "九州"
                              ),
                        args = '_label -> "地域", '_default -> "全国", '_showConstraints -> false, 'size -> 5
                    ))),format.raw/*33.22*/("""
                </td>
                <td>
                    """),format.raw/*36.31*/("""
                    """),_display_(Seq[Any](/*37.22*/select(
                        field = schoolSearchForm("prefectures.id"),
                        options = options(models.services.admin.StudentSearchService.getInstance().gainPrefecturesList()),
                        args = '_label -> "都道府県", '_default -> "ALL", '_showConstraints -> false, 'size -> 5
                    ))),format.raw/*41.22*/("""
                </td>
                <td>
                </td>
            </tr>
            <tr>
                <td>
                    """),format.raw/*48.29*/("""
                    """),_display_(Seq[Any](/*49.22*/select(
                        field = schoolSearchForm("school.id"),
                        options = options(models.services.admin.StudentSearchService.getInstance().gainSchoolList()),
                        args = '_label -> "大学", '_default -> "ALL", '_showConstraints -> false, 'size -> 5
                    ))),format.raw/*53.22*/("""
                </td>
                <td>
                    """),format.raw/*56.29*/("""
                    """),_display_(Seq[Any](/*57.22*/select(
                        field = schoolSearchForm("schoolDepartment.id"),
                        options = options(models.services.admin.StudentSearchService.getInstance().gainSchoolDepartmentList()),
                        args = '_label -> "学部", '_default -> "ALL", '_showConstraints -> false, 'size -> 5
                    ))),format.raw/*61.22*/("""
                </td>
                <td>
                    """),format.raw/*64.29*/("""
                    """),_display_(Seq[Any](/*65.22*/select(
                        field = schoolSearchForm("schoolSubject.id"),
                        options = options(models.services.admin.StudentSearchService.getInstance().gainSchoolSubjectList()),
                        args = '_label -> "学部", '_default -> "ALL", '_showConstraints -> false, 'size -> 5
                    ))),format.raw/*69.22*/("""
                </td>
            </tr>
        </table>

        <p class="buttons">
            <input type="submit" value="検索">
        <p>

    """)))})),format.raw/*78.6*/("""

    <hr>

    """),_display_(Seq[Any](/*82.6*/if(ssf != null)/*82.21*/ {_display_(Seq[Any](format.raw/*82.23*/("""
        """),_display_(Seq[Any](/*83.10*/form(CSRF(controllers.admin.routes.SchoolGroup.confirm))/*83.66*/ {_display_(Seq[Any](format.raw/*83.68*/("""

            """),format.raw/*85.26*/("""
            """),_display_(Seq[Any](/*86.14*/inputText(
                field = schoolSearchForm("schoolGroupName"),
                args = '_label -> "大学グループ名", 'placeholder -> ""
            ))),format.raw/*89.14*/("""

            <table border=1>
                <tr><td>選択</td><td>大学</td><td>学部</td><td>学科</td></tr>
                """),_display_(Seq[Any](/*93.18*/for(i <- ssf.schoolSearchList) yield /*93.48*/ {_display_(Seq[Any](format.raw/*93.50*/("""
                    <tr>
                        <td>"""),_display_(Seq[Any](/*95.30*/checkbox(field = schoolSearchForm("checkFlg"),
                                      args = '_label -> None, '_showConstraints -> false
                                     ))),format.raw/*97.39*/("""
                        </td>
                        <td>"""),_display_(Seq[Any](/*99.30*/i/*99.31*/.schoolGroupCondition.school.name)),format.raw/*99.64*/("""</td>
                        <td>"""),_display_(Seq[Any](/*100.30*/i/*100.31*/.schoolGroupCondition.schoolDepartment.department)),format.raw/*100.80*/("""</td>
                        <td>"""),_display_(Seq[Any](/*101.30*/i/*101.31*/.schoolGroupCondition.schoolSubject.subject)),format.raw/*101.74*/("""</td>
                        <input type="hidden" value=""""),_display_(Seq[Any](/*102.54*/i/*102.55*/.schoolGroupCondition.school.name)),format.raw/*102.88*/("""" name="schoolname[]">
                        <input type="hidden" value=""""),_display_(Seq[Any](/*103.54*/i/*103.55*/.schoolGroupCondition.schoolDepartment.department)),format.raw/*103.104*/("""" name="department[]">
                        <input type="hidden" value=""""),_display_(Seq[Any](/*104.54*/i/*104.55*/.schoolGroupCondition.schoolSubject.subject)),format.raw/*104.98*/("""" name="subject[]">
                    </tr>
                """)))})),format.raw/*106.18*/("""
            </table>



            <p class="buttons">
                <input type="submit" value="確認">
                <input type="button" value="戻る" onclick="goReturn()">
            <p>

        """)))})),format.raw/*116.10*/("""
    """)))})),format.raw/*117.6*/("""

""")))})),format.raw/*119.2*/("""





"""))}
    }
    
    def render(schoolSearchForm:Form[controllers.forms.admin.SchoolSearchForm],ssf:controllers.forms.admin.SchoolSearchForm): play.api.templates.HtmlFormat.Appendable = apply(schoolSearchForm)(ssf)
    
    def f:((Form[controllers.forms.admin.SchoolSearchForm]) => (controllers.forms.admin.SchoolSearchForm) => play.api.templates.HtmlFormat.Appendable) = (schoolSearchForm) => (ssf) => apply(schoolSearchForm)(ssf)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:35 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/admin/schoolgroupnew.scala.html
                    HASH: ffb48c81cae37e548d2f84e72f390939eb1cec5d
                    MATRIX: 870->1|1095->114|1125->136|1206->190|1234->191|1310->241|1337->242|1388->258|1423->284|1463->286|1535->323|1605->384|1645->386|1763->484|1822->507|2427->1090|2522->1167|2581->1190|2936->1523|3113->1680|3172->1703|3515->2024|3610->2099|3669->2122|4032->2463|4127->2538|4186->2561|4543->2896|4733->3055|4789->3076|4813->3091|4853->3093|4900->3104|4965->3160|5005->3162|5049->3191|5100->3206|5274->3358|5432->3480|5478->3510|5518->3512|5611->3569|5809->3745|5907->3807|5917->3808|5972->3841|6045->3877|6056->3878|6128->3927|6201->3963|6212->3964|6278->4007|6375->4067|6386->4068|6442->4101|6556->4178|6567->4179|6640->4228|6754->4305|6765->4306|6831->4349|6929->4414|7174->4626|7213->4633|7250->4638
                    LINES: 26->1|30->1|32->4|34->6|34->6|36->8|36->8|39->11|39->11|39->11|43->15|43->15|43->15|48->20|49->21|61->33|64->36|65->37|69->41|76->48|77->49|81->53|84->56|85->57|89->61|92->64|93->65|97->69|106->78|110->82|110->82|110->82|111->83|111->83|111->83|113->85|114->86|117->89|121->93|121->93|121->93|123->95|125->97|127->99|127->99|127->99|128->100|128->100|128->100|129->101|129->101|129->101|130->102|130->102|130->102|131->103|131->103|131->103|132->104|132->104|132->104|134->106|144->116|145->117|147->119
                    -- GENERATED --
                */
            