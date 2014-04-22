
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
object student extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[controllers.forms.admin.StudentSearchForm],List[models.EntryUser],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(studentSearchForm: Form[controllers.forms.admin.StudentSearchForm])(entryUserList: List[models.EntryUser]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.109*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main(title = "学生検索画面")/*5.24*/ {_display_(Seq[Any](format.raw/*5.26*/("""

    <h1>学生検索画面:</h1>

    """),_display_(Seq[Any](/*9.6*/form(CSRF(controllers.admin.routes.Student.searchResult))/*9.63*/ {_display_(Seq[Any](format.raw/*9.65*/("""

        <table border=0>
            <tr>
                <td colspan=3>
                    """),format.raw/*14.31*/("""
                    """),_display_(Seq[Any](/*15.22*/select(
                        field = studentSearchForm("applicationYear"),
                        options = options(
                            "-1" -> "20xx年度",
                            "2016" -> "2016年度",
                            "2015" -> "2015年度",
                            "2014" -> "2014年度"
                                  ),
                        args = '_label -> "採用年度"
                    ))),format.raw/*24.22*/("""
                </td>
            </tr>
            <tr>
                <td>
                    """),format.raw/*29.32*/("""
                    """),_display_(Seq[Any](/*30.22*/inputText(
                        field = studentSearchForm("lastName"),
                        args = '_label -> "氏名(姓)", 'placeholder -> ""
                    ))),format.raw/*33.22*/("""
                </td>
                <td>
                    """),format.raw/*36.32*/("""
                    """),_display_(Seq[Any](/*37.22*/inputText(
                        field = studentSearchForm("firstName"),
                        args = '_label -> "氏名(名)", 'placeholder -> ""
                    ))),format.raw/*40.22*/("""
                </td>
                <td>
                    """),format.raw/*43.29*/("""
                    """),_display_(Seq[Any](/*44.22*/select(
                        field = studentSearchForm("sex"),
                        options = options(
                            "-1" -> "ALL",
                            "0" -> "男性",
                            "1" -> "女性"
                                  ),
                        args = '_label -> "性別"
                    ))),format.raw/*52.22*/("""
                </td>
            </tr>
            <tr>
                <td colspan=3>
                    """),format.raw/*57.31*/("""
                    """),_display_(Seq[Any](/*58.22*/select(
                        field = studentSearchForm("complexGroup.id"),
                        options = options(models.services.admin.StudentSearchService.getInstance().gainComplexGroupList()),
                        args = '_label -> "グループ", '_default -> "ALL", '_showConstraints -> false
                    ))),format.raw/*62.22*/("""
                </td>
            </tr>
            <tr>
                <td>
                    """),format.raw/*67.33*/("""
                    """),_display_(Seq[Any](/*68.22*/select(
                        field = studentSearchForm("schoolGroup.id"),
                        options = options(models.services.admin.StudentSearchService.getInstance().gainSchoolGroupList()),
                        args = '_label -> "大学グループ", '_default -> "ALL", '_showConstraints -> false
                    ))),format.raw/*72.22*/("""
                </td>
                <td>
                    """),format.raw/*75.31*/("""
                    """),_display_(Seq[Any](/*76.22*/select(
                        field = studentSearchForm("division"),
                        options = options(
                            "-1" -> "ALL",
                            "1" -> "大学",
                            "2" -> "大学院(修士)",
                            "3" -> "大学(博士)",
                            "4" -> "外国大学日本校",
                            "5" -> "外国大学"
                              ),
                        args = '_label -> "学校区分"
                    ))),format.raw/*87.22*/("""
                </td>
                <td>
                    """),format.raw/*90.31*/("""
                    """),_display_(Seq[Any](/*91.22*/select(
                        field = studentSearchForm("classification"),
                        options = options(
                            "-1" -> "ALL",
                            "1" -> "文系",
                            "2" -> "理系"
                                  ),
                        args = '_label -> "文理区分"
                    ))),format.raw/*99.22*/("""
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    """),format.raw/*105.29*/("""
                    """),_display_(Seq[Any](/*106.22*/select(
                        field = studentSearchForm("school.id"),
                        options = options(models.services.admin.StudentSearchService.getInstance().gainSchoolList()),
                        args = '_label -> "大学", '_default -> "ALL", '_showConstraints -> false
                    ))),format.raw/*110.22*/("""
                </td>
                <td>
                    """),format.raw/*113.29*/("""
                    """),_display_(Seq[Any](/*114.22*/select(
                        field = studentSearchForm("schoolDepartment.id"),
                        options = options(models.services.admin.StudentSearchService.getInstance().gainSchoolDepartmentList()),
                        args = '_label -> "学部", '_default -> "ALL", '_showConstraints -> false
                    ))),format.raw/*118.22*/("""
                </td>
            </tr>
            <tr>
                <td>
                    """),format.raw/*123.31*/("""
                    """),_display_(Seq[Any](/*124.22*/select(
                        field = studentSearchForm("prefectures.id"),
                        options = options(models.services.admin.StudentSearchService.getInstance().gainPrefecturesList()),
                        args = '_label -> "都道府県", '_default -> "ALL", '_showConstraints -> false
                    ))),format.raw/*128.22*/("""
                </td>
                <td colspan=2>
                    """),format.raw/*131.31*/("""
                    """),_display_(Seq[Any](/*132.22*/inputText(
                        field = studentSearchForm("phoneNo"),
                        args = '_label -> "電話番号"
                    ))),format.raw/*135.22*/("""
                </td>
            </tr>
            <tr>
                <td colspan=3>
                    """),format.raw/*140.37*/("""
                    """),_display_(Seq[Any](/*141.22*/inputText(
                        field = studentSearchForm("email"),
                        args = '_label -> "E-mailアドレス", 'placeholder -> "xxx@xx.xx.xx"
                    ))),format.raw/*144.22*/("""
                </td>
            </tr>
            <tr>
                <td colspan=3>
                    """),format.raw/*149.32*/("""
                    """),_display_(Seq[Any](/*150.22*/inputText(
                        field = studentSearchForm("entryUserIds"),
                        args = '_label -> "応募者ID"
                    ))),format.raw/*153.22*/("""
                </td>
            </tr>
            <tr>
                <td>
                    """),format.raw/*158.31*/("""
                    """),_display_(Seq[Any](/*159.22*/select(
                        field = studentSearchForm("event.id"),
                        options = options(models.services.admin.StudentSearchService.getInstance().gainEventList()),
                        args = '_label -> "イベント", '_default -> "ALL", '_showConstraints -> false
                    ))),format.raw/*163.22*/("""
                </td>
                <td>
                    """),format.raw/*166.33*/("""
                    """),_display_(Seq[Any](/*167.22*/select(
                        field = studentSearchForm("eventSchedule.id"),
                        options = options(models.services.admin.StudentSearchService.getInstance().gainEventScheduleList()),
                        args = '_label -> "イベント日程", '_default -> "ALL", '_showConstraints -> false
                    ))),format.raw/*171.22*/("""
                </td>
                <td></td>
            </tr>
            <tr>
                <td colspan=3>
                    """),format.raw/*177.34*/("""
                    """),_display_(Seq[Any](/*178.22*/select(
                        field = studentSearchForm("entryStatus"),
                        options = options(
                            "-1" -> "ALL",
                            "1" -> "未選考",
                            "2" -> "選考中",
                            "3" -> "不合格",
                            "4" -> "辞退",
                            "5" -> "内定",
                            "6" -> "内定辞退",
                            "7" -> "内々定"
                                  ),
                        args = '_label -> "選考ステータス"
                    ))),format.raw/*191.22*/("""
                </td>
            </tr>
        </table>

        <p class="buttons">
            <input type="submit" value="検索">
        <p>

    """)))})),format.raw/*200.6*/("""

    <hr>

    """),_display_(Seq[Any](/*204.6*/if(entryUserList != null)/*204.31*/ {_display_(Seq[Any](format.raw/*204.33*/("""
        <h1>学生検索結果:</h1>



            <table border=1>
                <tr><td>選択</td><td>応募者ID</td><td>氏名</td><td>編集</td><td>削除</td></tr>

                """),_display_(Seq[Any](/*212.18*/for(i <- entryUserList) yield /*212.41*/ {_display_(Seq[Any](format.raw/*212.43*/("""
                    <tr>
                        <td>"""),format.raw/*214.57*/("""</td>
                        <td>"""),_display_(Seq[Any](/*215.30*/i/*215.31*/.id)),format.raw/*215.34*/("""</td>
                        <td><a href=""""),_display_(Seq[Any](/*216.39*/i/*216.40*/.dataUrl)),format.raw/*216.48*/("""">"""),_display_(Seq[Any](/*216.51*/i/*216.52*/.lastName)),format.raw/*216.61*/(""" """),_display_(Seq[Any](/*216.63*/i/*216.64*/.firstName)),format.raw/*216.74*/("""</a></td>
                        <td>編集</td>
                        <td>削除</td>
                    </tr>
                """)))})),format.raw/*220.18*/("""
            </table>

    """)))})),format.raw/*223.6*/("""

""")))})),format.raw/*225.2*/("""





"""))}
    }
    
    def render(studentSearchForm:Form[controllers.forms.admin.StudentSearchForm],entryUserList:List[models.EntryUser]): play.api.templates.HtmlFormat.Appendable = apply(studentSearchForm)(entryUserList)
    
    def f:((Form[controllers.forms.admin.StudentSearchForm]) => (List[models.EntryUser]) => play.api.templates.HtmlFormat.Appendable) = (studentSearchForm) => (entryUserList) => apply(studentSearchForm)(entryUserList)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:35 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/admin/student.scala.html
                    HASH: 6edacdb4c892e5e49e0892bd0b090b97f1b4afe9
                    MATRIX: 846->1|1065->108|1095->130|1132->133|1162->155|1201->157|1268->190|1333->247|1372->249|1500->359|1559->382|2007->808|2139->923|2198->946|2388->1114|2483->1192|2542->1215|2733->1384|2828->1459|2887->1482|3255->1828|3397->1952|3456->1975|3802->2299|3934->2415|3993->2438|4339->2762|4434->2839|4493->2862|5006->3353|5101->3430|5160->3453|5541->3812|5701->3951|5761->3974|6094->4284|6190->4359|6250->4382|6603->4712|6736->4826|6796->4849|7141->5171|7247->5258|7307->5281|7476->5427|7619->5557|7679->5580|7884->5762|8027->5887|8087->5910|8262->6062|8395->6176|8455->6199|8788->6509|8884->6588|8944->6611|9295->6939|9465->7093|9525->7116|10123->7691|10314->7850|10371->7871|10406->7896|10447->7898|10652->8066|10692->8089|10733->8091|10818->8175|10891->8211|10902->8212|10928->8215|11010->8260|11021->8261|11052->8269|11092->8272|11103->8273|11135->8282|11174->8284|11185->8285|11218->8295|11380->8424|11443->8455|11480->8460
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|37->9|37->9|37->9|42->14|43->15|52->24|57->29|58->30|61->33|64->36|65->37|68->40|71->43|72->44|80->52|85->57|86->58|90->62|95->67|96->68|100->72|103->75|104->76|115->87|118->90|119->91|127->99|133->105|134->106|138->110|141->113|142->114|146->118|151->123|152->124|156->128|159->131|160->132|163->135|168->140|169->141|172->144|177->149|178->150|181->153|186->158|187->159|191->163|194->166|195->167|199->171|205->177|206->178|219->191|228->200|232->204|232->204|232->204|240->212|240->212|240->212|242->214|243->215|243->215|243->215|244->216|244->216|244->216|244->216|244->216|244->216|244->216|244->216|244->216|248->220|251->223|253->225
                    -- GENERATED --
                */
            