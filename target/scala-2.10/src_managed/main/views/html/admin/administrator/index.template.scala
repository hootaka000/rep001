
package views.html.admin.administrator

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.forms.admin.IndexForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(login: Form[controllers.forms.admin.IndexForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

def /*4.2*/stylesheets/*4.13*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.17*/("""
  <link rel="stylesheet"
        media="screen"
        href=""""),_display_(Seq[Any](/*7.16*/routes/*7.22*/.Assets.at("stylesheets/" + lang().language() + "/admin/dashboard/site.min.css"))),format.raw/*7.102*/(""""></link>
""")))};def /*9.2*/scripts/*9.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*9.13*/("""
  <script src=""""),_display_(Seq[Any](/*10.17*/routes/*10.23*/.Assets.at("javascripts/admin/dashboard/site.min.js"))),format.raw/*10.76*/(""""></script>
""")))};
Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*3.1*/("""
"""),format.raw/*8.2*/("""
"""),format.raw/*11.2*/("""

"""),_display_(Seq[Any](/*13.2*/views/*13.7*/.html.admin.main("ダッシュボード", stylesheets, scripts)/*13.56*/ {_display_(Seq[Any](format.raw/*13.58*/("""

	<h2>ダッシュボード</h2>

    """),_display_(Seq[Any](/*17.6*/form(CSRF(controllers.admin.routes.Application.logout))/*17.61*/ {_display_(Seq[Any](format.raw/*17.63*/("""

		"""),format.raw/*22.5*/("""
        
        <p>
          <p><input type="submit" class="btn primary" value="logout"></p>
        </p>
        
    """)))})),format.raw/*28.6*/("""

	<h3>アクティビティ（仮）</h3>
	<div id="dashboard-activity-area">
		loading...	
	</div>
	
	<h3>スケジュール（仮）</h3>
	<div id="dashboard-schedule-area">
		loading...	
	</div>
	
	<h3>ラップ（仮）</h3>
	<div id="dashboard-lap-area">
		loading...	
	</div>
	
	<h3>イベント（仮）</h3>
	<div id="dashboard-event-area">
		loading...	
	</div>


""")))})),format.raw/*51.2*/("""
"""))}
    }
    
    def render(login:Form[controllers.forms.admin.IndexForm]): play.api.templates.HtmlFormat.Appendable = apply(login)
    
    def f:((Form[controllers.forms.admin.IndexForm]) => play.api.templates.HtmlFormat.Appendable) = (login) => apply(login)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/admin/administrator/index.scala.html
                    HASH: 8016a04432c39c28f921d639f29b425888334037
                    MATRIX: 827->1|969->72|988->83|1072->87|1174->154|1188->160|1290->240|1324->255|1338->262|1422->266|1476->284|1491->290|1566->343|1619->49|1647->69|1675->252|1704->357|1744->362|1757->367|1815->416|1855->418|1920->448|1984->503|2024->505|2057->554|2217->683|2582->1017
                    LINES: 26->1|29->4|29->4|31->4|34->7|34->7|34->7|35->9|35->9|37->9|38->10|38->10|38->10|40->1|41->3|42->8|43->11|45->13|45->13|45->13|45->13|49->17|49->17|49->17|51->22|57->28|80->51
                    -- GENERATED --
                */
            