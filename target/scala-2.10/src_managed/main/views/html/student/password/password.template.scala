
package views.html.student.password

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
object password extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[forms.student.PasswordForm],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(passwordForm: Form[forms.student.PasswordForm]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.50*/("""
"""),format.raw/*4.7*/("""
"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/views/*7.7*/.html.student.main("パスワード変更")/*7.36*/{_display_(Seq[Any](format.raw/*7.37*/("""

	"""),_display_(Seq[Any](/*9.3*/form(CSRF(controllers.student.routes.MyPage.index))/*9.54*/ {_display_(Seq[Any](format.raw/*9.56*/("""
		<div>
			<p><input type="submit" class = "btn primary" value = "ホームに戻る"/></p>
		</div>
	""")))})),format.raw/*13.3*/("""

	"""),_display_(Seq[Any](/*15.3*/form(CSRF(controllers.student.routes.Password.update))/*15.57*/ {_display_(Seq[Any](format.raw/*15.59*/("""
		<h1>パスワードの変更</h1>
		"""),_display_(Seq[Any](/*17.4*/if(passwordForm.hasGlobalErrors)/*17.36*/ {_display_(Seq[Any](format.raw/*17.38*/("""
		    <p class="error">"""),_display_(Seq[Any](/*18.25*/passwordForm/*18.37*/.globalError.message)),format.raw/*18.57*/("""</p>
		""")))})),format.raw/*19.4*/("""

		<div class="container">
			<table class="table-bordered" border="1">
				<tr>
					<td>現在のパスワード</td>
					<td>
						"""),_display_(Seq[Any](/*26.8*/inputPassword(passwordForm("oldPassword"), '_label -> "" , '_class -> "line-input", '_showConstraints -> false))),format.raw/*26.119*/("""
					</td>
				</tr>
				<tr>
					<td>新しいパスワード</td>
					<td>
						"""),_display_(Seq[Any](/*32.8*/inputPassword(passwordForm("newPassword"), '_label -> "" ,'_class -> "line-input", '_showConstraints -> false))),format.raw/*32.118*/("""
					</td>
				</tr>
				<tr>
					<td>新しいパスワード確認用</td>
					<td>
						"""),_display_(Seq[Any](/*38.8*/inputPassword(passwordForm("rePassword"), '_label -> "" ,'_class -> "line-input", '_showConstraints -> false))),format.raw/*38.117*/("""
					</td>
				</tr>
			</table>
			<input type="button" class = "btn primary" value = "キャンセル" onclick="javascript:history.back();"/>
			<input type="submit" class = "btn primary" value = "変更"/>
		</div>
	""")))})),format.raw/*45.3*/("""


""")))})))}
    }
    
    def render(passwordForm:Form[forms.student.PasswordForm]): play.api.templates.HtmlFormat.Appendable = apply(passwordForm)
    
    def f:((Form[forms.student.PasswordForm]) => play.api.templates.HtmlFormat.Appendable) = (passwordForm) => apply(passwordForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 22 11:38:36 JST 2014
                    SOURCE: C:/Users/B05137/git/ca-infosys-saiyo/app/views/student/password/password.scala.html
                    HASH: 3dbbf0097d3e8712bfcf11f0211dc2a6574fefd7
                    MATRIX: 820->1|979->49|1007->110|1035->130|1072->133|1084->138|1121->167|1159->168|1199->174|1258->225|1297->227|1424->323|1465->329|1528->383|1568->385|1629->411|1670->443|1710->445|1772->471|1793->483|1835->503|1875->512|2039->641|2173->752|2285->829|2418->939|2533->1019|2665->1128|2910->1342
                    LINES: 26->1|30->1|31->4|32->6|33->7|33->7|33->7|33->7|35->9|35->9|35->9|39->13|41->15|41->15|41->15|43->17|43->17|43->17|44->18|44->18|44->18|45->19|52->26|52->26|58->32|58->32|64->38|64->38|71->45
                    -- GENERATED --
                */
            