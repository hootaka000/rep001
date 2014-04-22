
package views.html.student.sample

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[controllers.student.Sample.SampleForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(sample: Form[controllers.student.Sample.SampleForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n._

def /*11.2*/stylesheets/*11.13*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*11.17*/("""
  <link rel="stylesheet"
        media="screen"
        href=""""),_display_(Seq[Any](/*14.16*/routes/*14.22*/.Assets.at("stylesheets/" + lang().language() + "/student/sample/index.min.css"))),format.raw/*14.102*/(""""></link>
""")))};def /*16.2*/scripts/*16.9*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*16.13*/("""
  <script src=""""),_display_(Seq[Any](/*17.17*/routes/*17.23*/.Assets.at("javascripts/student/sample/index.min.js"))),format.raw/*17.76*/(""""></script>
""")))};
Seq[Any](format.raw/*1.55*/("""

"""),format.raw/*5.1*/("""
<!-- このファイルはサンプルなのでいずれけします -->
<!-- FIXME　このファイルはサンプルなのでいずれけします -->


<!--  画面個別のスタイルとJS渡したい場合、以下のようにする -->
"""),format.raw/*15.2*/("""
"""),format.raw/*18.2*/("""

<!--
  渡すべきスタイルやJSがない場合は、
  名前付き引き数にして、からのコンテンツ(=Html(""))渡す
-->
"""),_display_(Seq[Any](/*24.2*/views/*24.7*/.html.student.main("this is sample", stylesheets, scripts)/*24.65*/ {_display_(Seq[Any](format.raw/*24.67*/("""


    """),_display_(Seq[Any](/*27.6*/form(CSRF(controllers.student.routes.Sample.doTest()))/*27.60*/ {_display_(Seq[Any](format.raw/*27.62*/("""
    	
    	<span>Test111</span><br/>
    	<span>"""),_display_(Seq[Any](/*30.13*/sample/*30.19*/.hasGlobalErrors)),format.raw/*30.35*/("""</span>
        """),_display_(Seq[Any](/*31.10*/if(sample.globalError != null)/*31.40*/ {_display_(Seq[Any](format.raw/*31.42*/("""
            <p class="error" style="color: red;">"""),_display_(Seq[Any](/*32.51*/sample/*32.57*/.globalError.message)),format.raw/*32.77*/("""</p>
        """)))})),format.raw/*33.10*/("""

        <p>
          """),_display_(Seq[Any](/*36.12*/(helper.inputText (
			field = sample("email")
			)))),format.raw/*38.6*/("""
        </p>
        
        <p>
          """),_display_(Seq[Any](/*42.12*/(helper.inputText (
			field = sample("count")
			)))),format.raw/*44.6*/("""
        </p>
    	
    	<input type="submit" onclick="" />
    """)))})),format.raw/*48.6*/("""
""")))})),format.raw/*49.2*/("""

"""))}
    }
    
    def render(sample:Form[controllers.student.Sample.SampleForm]): play.api.templates.HtmlFormat.Appendable = apply(sample)
    
    def f:((Form[controllers.student.Sample.SampleForm]) => play.api.templates.HtmlFormat.Appendable) = (sample) => apply(sample)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/sample/index.scala.html
                    HASH: 60e4dd5788ba6e95ac67a36a538dd39383ca37e2
                    MATRIX: 826->1|995->213|1015->224|1100->228|1203->295|1218->301|1321->381|1356->396|1371->403|1456->407|1510->425|1525->431|1600->484|1653->54|1683->97|1825->393|1854->498|1963->572|1976->577|2043->635|2083->637|2129->648|2192->702|2232->704|2321->757|2336->763|2374->779|2428->797|2467->827|2507->829|2595->881|2610->887|2652->907|2699->922|2763->950|2838->1004|2924->1054|2999->1108|3099->1177|3133->1180
                    LINES: 26->1|31->11|31->11|33->11|36->14|36->14|36->14|37->16|37->16|39->16|40->17|40->17|40->17|42->1|44->5|50->15|51->18|57->24|57->24|57->24|57->24|60->27|60->27|60->27|63->30|63->30|63->30|64->31|64->31|64->31|65->32|65->32|65->32|66->33|69->36|71->38|75->42|77->44|81->48|82->49
                    -- GENERATED --
                */
            