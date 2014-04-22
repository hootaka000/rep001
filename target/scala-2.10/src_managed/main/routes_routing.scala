// @SOURCE:C:/Users/B05137/git/ca-infosys-saiyo/conf/routes
// @HASH:b5a08910d2cd1169ef49dbd79b4ca5426c68beb5
// @DATE:Tue Apr 22 11:38:34 JST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:7
private[this] lazy val controllers_student_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/index"))))
        

// @LINE:8
private[this] lazy val controllers_student_Application_login1 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/login"))))
        

// @LINE:9
private[this] lazy val controllers_student_Application_logout2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/logout"))))
        

// @LINE:10
private[this] lazy val controllers_student_Application_completed3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/completed"))))
        

// @LINE:11
private[this] lazy val controllers_student_Application_agree4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/agree"))))
        

// @LINE:13
private[this] lazy val controllers_student_MyPage_index5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/mypage"))))
        

// @LINE:15
private[this] lazy val controllers_student_Entry_confirmUnsubscribe6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/unsubscribe"))))
        

// @LINE:16
private[this] lazy val controllers_student_Entry_unsubscribe7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/unsubscribe"))))
        

// @LINE:19
private[this] lazy val controllers_Application_schools8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("schools/"),DynamicPart("division", """[^/]+""",true),StaticPart("/"),DynamicPart("prefecture", """[^/]+""",true))))
        

// @LINE:20
private[this] lazy val controllers_Application_departments9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("departments/"),DynamicPart("schoolid", """[^/]+""",true))))
        

// @LINE:21
private[this] lazy val controllers_Application_subjects10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("subjects/"),DynamicPart("departmentid", """[^/]+""",true))))
        

// @LINE:22
private[this] lazy val controllers_Application_postcode11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("postcode/"),DynamicPart("uppercode", """[^/]+""",true),StaticPart("/"),DynamicPart("lowercode", """[^/]+""",true))))
        

// @LINE:23
private[this] lazy val controllers_Application_division12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("division/"),DynamicPart("division", """[0-9]+""",false))))
        

// @LINE:26
private[this] lazy val controllers_student_Sample_index13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/sample/index"))))
        

// @LINE:27
private[this] lazy val controllers_student_Sample_doTest14 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/sample/doPost"))))
        

// @LINE:31
private[this] lazy val controllers_student_Password_viewRepublish15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/password/republish"))))
        

// @LINE:32
private[this] lazy val controllers_student_Password_republish16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/password/republish"))))
        

// @LINE:35
private[this] lazy val controllers_student_Query_index17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/query"))))
        

// @LINE:36
private[this] lazy val controllers_student_Query_view18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/queryform"))))
        

// @LINE:37
private[this] lazy val controllers_student_Query_confirm19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/queryform/confirm"))))
        

// @LINE:38
private[this] lazy val controllers_student_Query_send20 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/queryform"))))
        

// @LINE:40
private[this] lazy val controllers_student_Password_index21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/password"))))
        

// @LINE:41
private[this] lazy val controllers_student_Password_update22 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/password"))))
        

// @LINE:44
private[this] lazy val controllers_student_Event_index23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/event/entry/"),DynamicPart("eventid", """[^/]+""",true))))
        

// @LINE:45
private[this] lazy val controllers_student_Event_confirm24 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/event/confirm"))))
        

// @LINE:46
private[this] lazy val controllers_student_Event_register25 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/event/entry"))))
        

// @LINE:48
private[this] lazy val controllers_student_Event_confirmCancel26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/event/cancel"))))
        

// @LINE:49
private[this] lazy val controllers_student_Event_cancel27 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("student/event/cancel"))))
        

// @LINE:52
private[this] lazy val controllers_admin_Application_index28 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin"))))
        

// @LINE:53
private[this] lazy val controllers_admin_Application_login29 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/login"))))
        

// @LINE:55
private[this] lazy val controllers_admin_Administrator_index30 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/dashbord"))))
        

// @LINE:56
private[this] lazy val controllers_admin_Administrator_dashBoardActivity31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/dashboard/acitivity"))))
        

// @LINE:57
private[this] lazy val controllers_admin_Administrator_dashBoardSchedule32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/dashboard/schedule"))))
        

// @LINE:58
private[this] lazy val controllers_admin_Administrator_dashBoardLap33 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/dashboard/lap"))))
        

// @LINE:59
private[this] lazy val controllers_admin_Administrator_dashBoardEvent34 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/dashboard/event"))))
        

// @LINE:61
private[this] lazy val controllers_admin_Application_logout35 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/logout"))))
        

// @LINE:63
private[this] lazy val controllers_admin_Student_search36 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/student/search"))))
        

// @LINE:64
private[this] lazy val controllers_admin_Student_searchResult37 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/student/search"))))
        

// @LINE:65
private[this] lazy val controllers_admin_Group_index38 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/groups"))))
        

// @LINE:66
private[this] lazy val controllers_admin_Group_gainGroupList39 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/groups"))))
        

// @LINE:67
private[this] lazy val controllers_admin_SchoolGroup_index40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/schoolgroups"))))
        

// @LINE:68
private[this] lazy val controllers_admin_SchoolGroup_gainSchoolGroups41 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/schoolgroups"))))
        

// @LINE:69
private[this] lazy val controllers_admin_SchoolGroup_newSchoolGroup42 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/schoolgroup/new"))))
        

// @LINE:70
private[this] lazy val controllers_admin_SchoolGroup_searchSchool43 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/schoolgroup/new"))))
        

// @LINE:71
private[this] lazy val controllers_admin_SchoolGroup_confirm44 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/schoolgroup/new/confirm"))))
        

// @LINE:72
private[this] lazy val controllers_admin_SchoolGroup_register45 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("admin/schoolgroup/new/register"))))
        

// @LINE:75
private[this] lazy val controllers_Assets_at46 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/index""","""controllers.student.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/login""","""controllers.student.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/logout""","""controllers.student.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/completed""","""controllers.student.Application.completed()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/agree""","""controllers.student.Application.agree()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/mypage""","""controllers.student.MyPage.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/unsubscribe""","""controllers.student.Entry.confirmUnsubscribe()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/unsubscribe""","""controllers.student.Entry.unsubscribe()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """schools/$division<[^/]+>/$prefecture<[^/]+>""","""controllers.Application.schools(division:String, prefecture:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """departments/$schoolid<[^/]+>""","""controllers.Application.departments(schoolid:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """subjects/$departmentid<[^/]+>""","""controllers.Application.subjects(departmentid:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """postcode/$uppercode<[^/]+>/$lowercode<[^/]+>""","""controllers.Application.postcode(uppercode:String, lowercode:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """division/$division<[0-9]+>""","""controllers.Application.division(division:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/sample/index""","""controllers.student.Sample.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/sample/doPost""","""controllers.student.Sample.doTest()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/password/republish""","""controllers.student.Password.viewRepublish()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/password/republish""","""controllers.student.Password.republish()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/query""","""controllers.student.Query.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/queryform""","""controllers.student.Query.view()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/queryform/confirm""","""controllers.student.Query.confirm()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/queryform""","""controllers.student.Query.send()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/password""","""controllers.student.Password.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/password""","""controllers.student.Password.update()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/event/entry/$eventid<[^/]+>""","""controllers.student.Event.index(eventid:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/event/confirm""","""controllers.student.Event.confirm()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/event/entry""","""controllers.student.Event.register()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/event/cancel""","""controllers.student.Event.confirmCancel()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """student/event/cancel""","""controllers.student.Event.cancel()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin""","""controllers.admin.Application.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/login""","""controllers.admin.Application.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/dashbord""","""controllers.admin.Administrator.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/dashboard/acitivity""","""controllers.admin.Administrator.dashBoardActivity()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/dashboard/schedule""","""controllers.admin.Administrator.dashBoardSchedule()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/dashboard/lap""","""controllers.admin.Administrator.dashBoardLap(empNo:String, monthTerm:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/dashboard/event""","""controllers.admin.Administrator.dashBoardEvent(jobTypeId:Long, eventGroupId:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/logout""","""controllers.admin.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/student/search""","""controllers.admin.Student.search()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/student/search""","""controllers.admin.Student.searchResult()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/groups""","""controllers.admin.Group.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/groups""","""controllers.admin.Group.gainGroupList()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/schoolgroups""","""controllers.admin.SchoolGroup.index()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/schoolgroups""","""controllers.admin.SchoolGroup.gainSchoolGroups()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/schoolgroup/new""","""controllers.admin.SchoolGroup.newSchoolGroup()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/schoolgroup/new""","""controllers.admin.SchoolGroup.searchSchool()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/schoolgroup/new/confirm""","""controllers.admin.SchoolGroup.confirm()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """admin/schoolgroup/new/register""","""controllers.admin.SchoolGroup.register()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:7
case controllers_student_Application_index0(params) => {
   call { 
        invokeHandler(controllers.student.Application.index(), HandlerDef(this, "controllers.student.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """student/index"""))
   }
}
        

// @LINE:8
case controllers_student_Application_login1(params) => {
   call { 
        invokeHandler(controllers.student.Application.login(), HandlerDef(this, "controllers.student.Application", "login", Nil,"POST", """""", Routes.prefix + """student/login"""))
   }
}
        

// @LINE:9
case controllers_student_Application_logout2(params) => {
   call { 
        invokeHandler(controllers.student.Application.logout(), HandlerDef(this, "controllers.student.Application", "logout", Nil,"POST", """""", Routes.prefix + """student/logout"""))
   }
}
        

// @LINE:10
case controllers_student_Application_completed3(params) => {
   call { 
        invokeHandler(controllers.student.Application.completed(), HandlerDef(this, "controllers.student.Application", "completed", Nil,"GET", """""", Routes.prefix + """student/completed"""))
   }
}
        

// @LINE:11
case controllers_student_Application_agree4(params) => {
   call { 
        invokeHandler(controllers.student.Application.agree(), HandlerDef(this, "controllers.student.Application", "agree", Nil,"GET", """""", Routes.prefix + """student/agree"""))
   }
}
        

// @LINE:13
case controllers_student_MyPage_index5(params) => {
   call { 
        invokeHandler(controllers.student.MyPage.index(), HandlerDef(this, "controllers.student.MyPage", "index", Nil,"GET", """""", Routes.prefix + """student/mypage"""))
   }
}
        

// @LINE:15
case controllers_student_Entry_confirmUnsubscribe6(params) => {
   call { 
        invokeHandler(controllers.student.Entry.confirmUnsubscribe(), HandlerDef(this, "controllers.student.Entry", "confirmUnsubscribe", Nil,"GET", """""", Routes.prefix + """student/unsubscribe"""))
   }
}
        

// @LINE:16
case controllers_student_Entry_unsubscribe7(params) => {
   call { 
        invokeHandler(controllers.student.Entry.unsubscribe(), HandlerDef(this, "controllers.student.Entry", "unsubscribe", Nil,"POST", """""", Routes.prefix + """student/unsubscribe"""))
   }
}
        

// @LINE:19
case controllers_Application_schools8(params) => {
   call(params.fromPath[String]("division", None), params.fromPath[String]("prefecture", None)) { (division, prefecture) =>
        invokeHandler(controllers.Application.schools(division, prefecture), HandlerDef(this, "controllers.Application", "schools", Seq(classOf[String], classOf[String]),"POST", """ Common""", Routes.prefix + """schools/$division<[^/]+>/$prefecture<[^/]+>"""))
   }
}
        

// @LINE:20
case controllers_Application_departments9(params) => {
   call(params.fromPath[String]("schoolid", None)) { (schoolid) =>
        invokeHandler(controllers.Application.departments(schoolid), HandlerDef(this, "controllers.Application", "departments", Seq(classOf[String]),"POST", """""", Routes.prefix + """departments/$schoolid<[^/]+>"""))
   }
}
        

// @LINE:21
case controllers_Application_subjects10(params) => {
   call(params.fromPath[String]("departmentid", None)) { (departmentid) =>
        invokeHandler(controllers.Application.subjects(departmentid), HandlerDef(this, "controllers.Application", "subjects", Seq(classOf[String]),"POST", """""", Routes.prefix + """subjects/$departmentid<[^/]+>"""))
   }
}
        

// @LINE:22
case controllers_Application_postcode11(params) => {
   call(params.fromPath[String]("uppercode", None), params.fromPath[String]("lowercode", None)) { (uppercode, lowercode) =>
        invokeHandler(controllers.Application.postcode(uppercode, lowercode), HandlerDef(this, "controllers.Application", "postcode", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """postcode/$uppercode<[^/]+>/$lowercode<[^/]+>"""))
   }
}
        

// @LINE:23
case controllers_Application_division12(params) => {
   call(params.fromPath[Integer]("division", None)) { (division) =>
        invokeHandler(controllers.Application.division(division), HandlerDef(this, "controllers.Application", "division", Seq(classOf[Integer]),"POST", """""", Routes.prefix + """division/$division<[0-9]+>"""))
   }
}
        

// @LINE:26
case controllers_student_Sample_index13(params) => {
   call { 
        invokeHandler(controllers.student.Sample.index(), HandlerDef(this, "controllers.student.Sample", "index", Nil,"GET", """ Sample ↓いずれけします""", Routes.prefix + """student/sample/index"""))
   }
}
        

// @LINE:27
case controllers_student_Sample_doTest14(params) => {
   call { 
        invokeHandler(controllers.student.Sample.doTest(), HandlerDef(this, "controllers.student.Sample", "doTest", Nil,"POST", """""", Routes.prefix + """student/sample/doPost"""))
   }
}
        

// @LINE:31
case controllers_student_Password_viewRepublish15(params) => {
   call { 
        invokeHandler(controllers.student.Password.viewRepublish(), HandlerDef(this, "controllers.student.Password", "viewRepublish", Nil,"GET", """ Password""", Routes.prefix + """student/password/republish"""))
   }
}
        

// @LINE:32
case controllers_student_Password_republish16(params) => {
   call { 
        invokeHandler(controllers.student.Password.republish(), HandlerDef(this, "controllers.student.Password", "republish", Nil,"POST", """""", Routes.prefix + """student/password/republish"""))
   }
}
        

// @LINE:35
case controllers_student_Query_index17(params) => {
   call { 
        invokeHandler(controllers.student.Query.index(), HandlerDef(this, "controllers.student.Query", "index", Nil,"GET", """Query""", Routes.prefix + """student/query"""))
   }
}
        

// @LINE:36
case controllers_student_Query_view18(params) => {
   call { 
        invokeHandler(controllers.student.Query.view(), HandlerDef(this, "controllers.student.Query", "view", Nil,"GET", """""", Routes.prefix + """student/queryform"""))
   }
}
        

// @LINE:37
case controllers_student_Query_confirm19(params) => {
   call { 
        invokeHandler(controllers.student.Query.confirm(), HandlerDef(this, "controllers.student.Query", "confirm", Nil,"GET", """""", Routes.prefix + """student/queryform/confirm"""))
   }
}
        

// @LINE:38
case controllers_student_Query_send20(params) => {
   call { 
        invokeHandler(controllers.student.Query.send(), HandlerDef(this, "controllers.student.Query", "send", Nil,"POST", """""", Routes.prefix + """student/queryform"""))
   }
}
        

// @LINE:40
case controllers_student_Password_index21(params) => {
   call { 
        invokeHandler(controllers.student.Password.index(), HandlerDef(this, "controllers.student.Password", "index", Nil,"GET", """""", Routes.prefix + """student/password"""))
   }
}
        

// @LINE:41
case controllers_student_Password_update22(params) => {
   call { 
        invokeHandler(controllers.student.Password.update(), HandlerDef(this, "controllers.student.Password", "update", Nil,"POST", """""", Routes.prefix + """student/password"""))
   }
}
        

// @LINE:44
case controllers_student_Event_index23(params) => {
   call(params.fromPath[Long]("eventid", None)) { (eventid) =>
        invokeHandler(controllers.student.Event.index(eventid), HandlerDef(this, "controllers.student.Event", "index", Seq(classOf[Long]),"GET", """event""", Routes.prefix + """student/event/entry/$eventid<[^/]+>"""))
   }
}
        

// @LINE:45
case controllers_student_Event_confirm24(params) => {
   call { 
        invokeHandler(controllers.student.Event.confirm(), HandlerDef(this, "controllers.student.Event", "confirm", Nil,"POST", """""", Routes.prefix + """student/event/confirm"""))
   }
}
        

// @LINE:46
case controllers_student_Event_register25(params) => {
   call { 
        invokeHandler(controllers.student.Event.register(), HandlerDef(this, "controllers.student.Event", "register", Nil,"POST", """""", Routes.prefix + """student/event/entry"""))
   }
}
        

// @LINE:48
case controllers_student_Event_confirmCancel26(params) => {
   call { 
        invokeHandler(controllers.student.Event.confirmCancel(), HandlerDef(this, "controllers.student.Event", "confirmCancel", Nil,"GET", """GET     /student/event                       controllers.student.Event.view()""", Routes.prefix + """student/event/cancel"""))
   }
}
        

// @LINE:49
case controllers_student_Event_cancel27(params) => {
   call { 
        invokeHandler(controllers.student.Event.cancel(), HandlerDef(this, "controllers.student.Event", "cancel", Nil,"POST", """""", Routes.prefix + """student/event/cancel"""))
   }
}
        

// @LINE:52
case controllers_admin_Application_index28(params) => {
   call { 
        invokeHandler(controllers.admin.Application.index(), HandlerDef(this, "controllers.admin.Application", "index", Nil,"GET", """ admin""", Routes.prefix + """admin"""))
   }
}
        

// @LINE:53
case controllers_admin_Application_login29(params) => {
   call { 
        invokeHandler(controllers.admin.Application.login(), HandlerDef(this, "controllers.admin.Application", "login", Nil,"POST", """""", Routes.prefix + """admin/login"""))
   }
}
        

// @LINE:55
case controllers_admin_Administrator_index30(params) => {
   call { 
        invokeHandler(controllers.admin.Administrator.index(), HandlerDef(this, "controllers.admin.Administrator", "index", Nil,"GET", """""", Routes.prefix + """admin/dashbord"""))
   }
}
        

// @LINE:56
case controllers_admin_Administrator_dashBoardActivity31(params) => {
   call { 
        invokeHandler(controllers.admin.Administrator.dashBoardActivity(), HandlerDef(this, "controllers.admin.Administrator", "dashBoardActivity", Nil,"GET", """""", Routes.prefix + """admin/dashboard/acitivity"""))
   }
}
        

// @LINE:57
case controllers_admin_Administrator_dashBoardSchedule32(params) => {
   call { 
        invokeHandler(controllers.admin.Administrator.dashBoardSchedule(), HandlerDef(this, "controllers.admin.Administrator", "dashBoardSchedule", Nil,"GET", """""", Routes.prefix + """admin/dashboard/schedule"""))
   }
}
        

// @LINE:58
case controllers_admin_Administrator_dashBoardLap33(params) => {
   call(params.fromQuery[String]("empNo", None), params.fromQuery[Integer]("monthTerm", None)) { (empNo, monthTerm) =>
        invokeHandler(controllers.admin.Administrator.dashBoardLap(empNo, monthTerm), HandlerDef(this, "controllers.admin.Administrator", "dashBoardLap", Seq(classOf[String], classOf[Integer]),"GET", """""", Routes.prefix + """admin/dashboard/lap"""))
   }
}
        

// @LINE:59
case controllers_admin_Administrator_dashBoardEvent34(params) => {
   call(params.fromQuery[Long]("jobTypeId", None), params.fromQuery[Long]("eventGroupId", None)) { (jobTypeId, eventGroupId) =>
        invokeHandler(controllers.admin.Administrator.dashBoardEvent(jobTypeId, eventGroupId), HandlerDef(this, "controllers.admin.Administrator", "dashBoardEvent", Seq(classOf[Long], classOf[Long]),"GET", """""", Routes.prefix + """admin/dashboard/event"""))
   }
}
        

// @LINE:61
case controllers_admin_Application_logout35(params) => {
   call { 
        invokeHandler(controllers.admin.Application.logout(), HandlerDef(this, "controllers.admin.Application", "logout", Nil,"POST", """""", Routes.prefix + """admin/logout"""))
   }
}
        

// @LINE:63
case controllers_admin_Student_search36(params) => {
   call { 
        invokeHandler(controllers.admin.Student.search(), HandlerDef(this, "controllers.admin.Student", "search", Nil,"GET", """""", Routes.prefix + """admin/student/search"""))
   }
}
        

// @LINE:64
case controllers_admin_Student_searchResult37(params) => {
   call { 
        invokeHandler(controllers.admin.Student.searchResult(), HandlerDef(this, "controllers.admin.Student", "searchResult", Nil,"POST", """""", Routes.prefix + """admin/student/search"""))
   }
}
        

// @LINE:65
case controllers_admin_Group_index38(params) => {
   call { 
        invokeHandler(controllers.admin.Group.index(), HandlerDef(this, "controllers.admin.Group", "index", Nil,"GET", """""", Routes.prefix + """admin/groups"""))
   }
}
        

// @LINE:66
case controllers_admin_Group_gainGroupList39(params) => {
   call { 
        invokeHandler(controllers.admin.Group.gainGroupList(), HandlerDef(this, "controllers.admin.Group", "gainGroupList", Nil,"POST", """""", Routes.prefix + """admin/groups"""))
   }
}
        

// @LINE:67
case controllers_admin_SchoolGroup_index40(params) => {
   call { 
        invokeHandler(controllers.admin.SchoolGroup.index(), HandlerDef(this, "controllers.admin.SchoolGroup", "index", Nil,"GET", """""", Routes.prefix + """admin/schoolgroups"""))
   }
}
        

// @LINE:68
case controllers_admin_SchoolGroup_gainSchoolGroups41(params) => {
   call { 
        invokeHandler(controllers.admin.SchoolGroup.gainSchoolGroups(), HandlerDef(this, "controllers.admin.SchoolGroup", "gainSchoolGroups", Nil,"POST", """""", Routes.prefix + """admin/schoolgroups"""))
   }
}
        

// @LINE:69
case controllers_admin_SchoolGroup_newSchoolGroup42(params) => {
   call { 
        invokeHandler(controllers.admin.SchoolGroup.newSchoolGroup(), HandlerDef(this, "controllers.admin.SchoolGroup", "newSchoolGroup", Nil,"GET", """""", Routes.prefix + """admin/schoolgroup/new"""))
   }
}
        

// @LINE:70
case controllers_admin_SchoolGroup_searchSchool43(params) => {
   call { 
        invokeHandler(controllers.admin.SchoolGroup.searchSchool(), HandlerDef(this, "controllers.admin.SchoolGroup", "searchSchool", Nil,"POST", """""", Routes.prefix + """admin/schoolgroup/new"""))
   }
}
        

// @LINE:71
case controllers_admin_SchoolGroup_confirm44(params) => {
   call { 
        invokeHandler(controllers.admin.SchoolGroup.confirm(), HandlerDef(this, "controllers.admin.SchoolGroup", "confirm", Nil,"POST", """""", Routes.prefix + """admin/schoolgroup/new/confirm"""))
   }
}
        

// @LINE:72
case controllers_admin_SchoolGroup_register45(params) => {
   call { 
        invokeHandler(controllers.admin.SchoolGroup.register(), HandlerDef(this, "controllers.admin.SchoolGroup", "register", Nil,"POST", """""", Routes.prefix + """admin/schoolgroup/new/register"""))
   }
}
        

// @LINE:75
case controllers_Assets_at46(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     