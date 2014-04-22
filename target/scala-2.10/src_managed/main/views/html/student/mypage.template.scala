
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
object mypage extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[forms.student.MyPageForm,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(mypageForm: forms.student.MyPageForm):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.40*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("My Page")/*5.17*/ {_display_(Seq[Any](format.raw/*5.19*/("""
    <h1>My Page</h1>
    """),_display_(Seq[Any](/*7.6*/if(mypageForm.mypage.hasGlobalErrors)/*7.43*/ {_display_(Seq[Any](format.raw/*7.45*/("""
        <p class="error">"""),_display_(Seq[Any](/*8.27*/mypageForm/*8.37*/.mypage.globalError.message)),format.raw/*8.64*/("""</p>
    """)))})),format.raw/*9.6*/("""
    """),_display_(Seq[Any](/*10.6*/helper/*10.12*/.form(CSRF(controllers.student.routes.Query.index))/*10.63*/ {_display_(Seq[Any](format.raw/*10.65*/("""
        <p><button type="submit">お問い合わせ</button></p>
    """)))})),format.raw/*12.6*/("""
    """),_display_(Seq[Any](/*13.6*/helper/*13.12*/.form(CSRF(controllers.student.routes.Password.index))/*13.66*/ {_display_(Seq[Any](format.raw/*13.68*/("""
        <a href=""""),_display_(Seq[Any](/*14.19*/controllers/*14.30*/.student.routes.Password.index)),format.raw/*14.60*/("""">パスワード変更</a>
    """)))})),format.raw/*15.6*/("""
    <a href=""""),_display_(Seq[Any](/*16.15*/controllers/*16.26*/.student.routes.Entry.confirmUnsubscribe)),format.raw/*16.66*/("""">退会</a>
    <br>
    <a href=""""),_display_(Seq[Any](/*18.15*/controllers/*18.26*/.student.routes.Event.index(1000005L))),format.raw/*18.63*/("""">event申込(1000005)</a>
    <br>
    <a href=""""),_display_(Seq[Any](/*20.15*/controllers/*20.26*/.student.routes.Event.index(1000001L))),format.raw/*20.63*/("""">event確認(1000001)</a>
    <br>
""")))})),format.raw/*22.2*/("""
"""))}
    }
    
    def render(mypageForm:forms.student.MyPageForm): play.api.templates.HtmlFormat.Appendable = apply(mypageForm)
    
    def f:((forms.student.MyPageForm) => play.api.templates.HtmlFormat.Appendable) = (mypageForm) => apply(mypageForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/mypage.scala.html
                    HASH: 4983cd6cb2c62989daafc1ecba0b34e3e67066bd
                    MATRIX: 801->1|950->39|980->61|1017->64|1040->79|1079->81|1142->110|1187->147|1226->149|1289->177|1307->187|1355->214|1396->225|1438->232|1453->238|1513->289|1553->291|1645->352|1687->359|1702->365|1765->419|1805->421|1861->441|1881->452|1933->482|1984->502|2036->518|2056->529|2118->569|2188->603|2208->614|2267->651|2351->699|2371->710|2430->747|2496->782
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|35->7|36->8|36->8|36->8|37->9|38->10|38->10|38->10|38->10|40->12|41->13|41->13|41->13|41->13|42->14|42->14|42->14|43->15|44->16|44->16|44->16|46->18|46->18|46->18|48->20|48->20|48->20|50->22
                    -- GENERATED --
                */
            