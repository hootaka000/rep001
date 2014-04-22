// @SOURCE:C:/Users/B05137/git/ca-infosys-saiyo/conf/routes
// @HASH:b5a08910d2cd1169ef49dbd79b4ca5426c68beb5
// @DATE:Tue Apr 22 11:38:34 JST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:75
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
package controllers {

// @LINE:75
class ReverseAssets {
    

// @LINE:75
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseApplication {
    

// @LINE:23
def division(division:Integer): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "division/" + implicitly[PathBindable[Integer]].unbind("division", division))
}
                                                

// @LINE:22
def postcode(uppercode:String, lowercode:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "postcode/" + implicitly[PathBindable[String]].unbind("uppercode", dynamicString(uppercode)) + "/" + implicitly[PathBindable[String]].unbind("lowercode", dynamicString(lowercode)))
}
                                                

// @LINE:21
def subjects(departmentid:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "subjects/" + implicitly[PathBindable[String]].unbind("departmentid", dynamicString(departmentid)))
}
                                                

// @LINE:20
def departments(schoolid:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "departments/" + implicitly[PathBindable[String]].unbind("schoolid", dynamicString(schoolid)))
}
                                                

// @LINE:19
def schools(division:String, prefecture:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "schools/" + implicitly[PathBindable[String]].unbind("division", dynamicString(division)) + "/" + implicitly[PathBindable[String]].unbind("prefecture", dynamicString(prefecture)))
}
                                                
    
}
                          
}
                  

// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:61
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
package controllers.admin {

// @LINE:66
// @LINE:65
class ReverseGroup {
    

// @LINE:65
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/groups")
}
                                                

// @LINE:66
def gainGroupList(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "admin/groups")
}
                                                
    
}
                          

// @LINE:61
// @LINE:53
// @LINE:52
class ReverseApplication {
    

// @LINE:61
def logout(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "admin/logout")
}
                                                

// @LINE:52
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin")
}
                                                

// @LINE:53
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "admin/login")
}
                                                
    
}
                          

// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
class ReverseAdministrator {
    

// @LINE:58
def dashBoardLap(empNo:String, monthTerm:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/dashboard/lap" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("empNo", empNo)), Some(implicitly[QueryStringBindable[Integer]].unbind("monthTerm", monthTerm)))))
}
                                                

// @LINE:57
def dashBoardSchedule(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/dashboard/schedule")
}
                                                

// @LINE:56
def dashBoardActivity(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/dashboard/acitivity")
}
                                                

// @LINE:55
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/dashbord")
}
                                                

// @LINE:59
def dashBoardEvent(jobTypeId:Long, eventGroupId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/dashboard/event" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("jobTypeId", jobTypeId)), Some(implicitly[QueryStringBindable[Long]].unbind("eventGroupId", eventGroupId)))))
}
                                                
    
}
                          

// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
class ReverseSchoolGroup {
    

// @LINE:69
def newSchoolGroup(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/schoolgroup/new")
}
                                                

// @LINE:71
def confirm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "admin/schoolgroup/new/confirm")
}
                                                

// @LINE:72
def register(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "admin/schoolgroup/new/register")
}
                                                

// @LINE:70
def searchSchool(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "admin/schoolgroup/new")
}
                                                

// @LINE:67
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/schoolgroups")
}
                                                

// @LINE:68
def gainSchoolGroups(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "admin/schoolgroups")
}
                                                
    
}
                          

// @LINE:64
// @LINE:63
class ReverseStudent {
    

// @LINE:64
def searchResult(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "admin/student/search")
}
                                                

// @LINE:63
def search(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "admin/student/search")
}
                                                
    
}
                          
}
                  

// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:41
// @LINE:40
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:27
// @LINE:26
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
package controllers.student {

// @LINE:16
// @LINE:15
class ReverseEntry {
    

// @LINE:16
def unsubscribe(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "student/unsubscribe")
}
                                                

// @LINE:15
def confirmUnsubscribe(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/unsubscribe")
}
                                                
    
}
                          

// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
class ReverseEvent {
    

// @LINE:49
def cancel(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "student/event/cancel")
}
                                                

// @LINE:44
def index(eventid:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/event/entry/" + implicitly[PathBindable[Long]].unbind("eventid", eventid))
}
                                                

// @LINE:45
def confirm(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "student/event/confirm")
}
                                                

// @LINE:46
def register(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "student/event/entry")
}
                                                

// @LINE:48
def confirmCancel(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/event/cancel")
}
                                                
    
}
                          

// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseQuery {
    

// @LINE:37
def confirm(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/queryform/confirm")
}
                                                

// @LINE:38
def send(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "student/queryform")
}
                                                

// @LINE:36
def view(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/queryform")
}
                                                

// @LINE:35
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/query")
}
                                                
    
}
                          

// @LINE:41
// @LINE:40
// @LINE:32
// @LINE:31
class ReversePassword {
    

// @LINE:41
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "student/password")
}
                                                

// @LINE:40
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/password")
}
                                                

// @LINE:31
def viewRepublish(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/password/republish")
}
                                                

// @LINE:32
def republish(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "student/password/republish")
}
                                                
    
}
                          

// @LINE:13
class ReverseMyPage {
    

// @LINE:13
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/mypage")
}
                                                
    
}
                          

// @LINE:27
// @LINE:26
class ReverseSample {
    

// @LINE:27
def doTest(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "student/sample/doPost")
}
                                                

// @LINE:26
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/sample/index")
}
                                                
    
}
                          

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:11
def agree(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/agree")
}
                                                

// @LINE:10
def completed(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/completed")
}
                                                

// @LINE:9
def logout(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "student/logout")
}
                                                

// @LINE:7
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "student/index")
}
                                                

// @LINE:8
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "student/login")
}
                                                
    
}
                          
}
                  


// @LINE:75
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
package controllers.javascript {

// @LINE:75
class ReverseAssets {
    

// @LINE:75
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseApplication {
    

// @LINE:23
def division : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.division",
   """
      function(division) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "division/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("division", division)})
      }
   """
)
                        

// @LINE:22
def postcode : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.postcode",
   """
      function(uppercode,lowercode) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "postcode/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("uppercode", encodeURIComponent(uppercode)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("lowercode", encodeURIComponent(lowercode))})
      }
   """
)
                        

// @LINE:21
def subjects : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.subjects",
   """
      function(departmentid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "subjects/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("departmentid", encodeURIComponent(departmentid))})
      }
   """
)
                        

// @LINE:20
def departments : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.departments",
   """
      function(schoolid) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "departments/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("schoolid", encodeURIComponent(schoolid))})
      }
   """
)
                        

// @LINE:19
def schools : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.schools",
   """
      function(division,prefecture) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "schools/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("division", encodeURIComponent(division)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("prefecture", encodeURIComponent(prefecture))})
      }
   """
)
                        
    
}
              
}
        

// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:61
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
package controllers.admin.javascript {

// @LINE:66
// @LINE:65
class ReverseGroup {
    

// @LINE:65
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Group.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/groups"})
      }
   """
)
                        

// @LINE:66
def gainGroupList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Group.gainGroupList",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/groups"})
      }
   """
)
                        
    
}
              

// @LINE:61
// @LINE:53
// @LINE:52
class ReverseApplication {
    

// @LINE:61
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Application.logout",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/logout"})
      }
   """
)
                        

// @LINE:52
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin"})
      }
   """
)
                        

// @LINE:53
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Application.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/login"})
      }
   """
)
                        
    
}
              

// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
class ReverseAdministrator {
    

// @LINE:58
def dashBoardLap : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Administrator.dashBoardLap",
   """
      function(empNo,monthTerm) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/dashboard/lap" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("empNo", empNo), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("monthTerm", monthTerm)])})
      }
   """
)
                        

// @LINE:57
def dashBoardSchedule : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Administrator.dashBoardSchedule",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/dashboard/schedule"})
      }
   """
)
                        

// @LINE:56
def dashBoardActivity : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Administrator.dashBoardActivity",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/dashboard/acitivity"})
      }
   """
)
                        

// @LINE:55
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Administrator.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/dashbord"})
      }
   """
)
                        

// @LINE:59
def dashBoardEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Administrator.dashBoardEvent",
   """
      function(jobTypeId,eventGroupId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/dashboard/event" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("jobTypeId", jobTypeId), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("eventGroupId", eventGroupId)])})
      }
   """
)
                        
    
}
              

// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
class ReverseSchoolGroup {
    

// @LINE:69
def newSchoolGroup : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.SchoolGroup.newSchoolGroup",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/schoolgroup/new"})
      }
   """
)
                        

// @LINE:71
def confirm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.SchoolGroup.confirm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/schoolgroup/new/confirm"})
      }
   """
)
                        

// @LINE:72
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.SchoolGroup.register",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/schoolgroup/new/register"})
      }
   """
)
                        

// @LINE:70
def searchSchool : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.SchoolGroup.searchSchool",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/schoolgroup/new"})
      }
   """
)
                        

// @LINE:67
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.SchoolGroup.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/schoolgroups"})
      }
   """
)
                        

// @LINE:68
def gainSchoolGroups : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.SchoolGroup.gainSchoolGroups",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/schoolgroups"})
      }
   """
)
                        
    
}
              

// @LINE:64
// @LINE:63
class ReverseStudent {
    

// @LINE:64
def searchResult : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Student.searchResult",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/student/search"})
      }
   """
)
                        

// @LINE:63
def search : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.admin.Student.search",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/student/search"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:41
// @LINE:40
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:27
// @LINE:26
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
package controllers.student.javascript {

// @LINE:16
// @LINE:15
class ReverseEntry {
    

// @LINE:16
def unsubscribe : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Entry.unsubscribe",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/unsubscribe"})
      }
   """
)
                        

// @LINE:15
def confirmUnsubscribe : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Entry.confirmUnsubscribe",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/unsubscribe"})
      }
   """
)
                        
    
}
              

// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
class ReverseEvent {
    

// @LINE:49
def cancel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Event.cancel",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/event/cancel"})
      }
   """
)
                        

// @LINE:44
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Event.index",
   """
      function(eventid) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/event/entry/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("eventid", eventid)})
      }
   """
)
                        

// @LINE:45
def confirm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Event.confirm",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/event/confirm"})
      }
   """
)
                        

// @LINE:46
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Event.register",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/event/entry"})
      }
   """
)
                        

// @LINE:48
def confirmCancel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Event.confirmCancel",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/event/cancel"})
      }
   """
)
                        
    
}
              

// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseQuery {
    

// @LINE:37
def confirm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Query.confirm",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/queryform/confirm"})
      }
   """
)
                        

// @LINE:38
def send : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Query.send",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/queryform"})
      }
   """
)
                        

// @LINE:36
def view : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Query.view",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/queryform"})
      }
   """
)
                        

// @LINE:35
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Query.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/query"})
      }
   """
)
                        
    
}
              

// @LINE:41
// @LINE:40
// @LINE:32
// @LINE:31
class ReversePassword {
    

// @LINE:41
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Password.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/password"})
      }
   """
)
                        

// @LINE:40
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Password.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/password"})
      }
   """
)
                        

// @LINE:31
def viewRepublish : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Password.viewRepublish",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/password/republish"})
      }
   """
)
                        

// @LINE:32
def republish : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Password.republish",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/password/republish"})
      }
   """
)
                        
    
}
              

// @LINE:13
class ReverseMyPage {
    

// @LINE:13
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.MyPage.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/mypage"})
      }
   """
)
                        
    
}
              

// @LINE:27
// @LINE:26
class ReverseSample {
    

// @LINE:27
def doTest : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Sample.doTest",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/sample/doPost"})
      }
   """
)
                        

// @LINE:26
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Sample.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/sample/index"})
      }
   """
)
                        
    
}
              

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:11
def agree : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Application.agree",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/agree"})
      }
   """
)
                        

// @LINE:10
def completed : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Application.completed",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/completed"})
      }
   """
)
                        

// @LINE:9
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Application.logout",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/logout"})
      }
   """
)
                        

// @LINE:7
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "student/index"})
      }
   """
)
                        

// @LINE:8
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.student.Application.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "student/login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:75
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
package controllers.ref {


// @LINE:75
class ReverseAssets {
    

// @LINE:75
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
class ReverseApplication {
    

// @LINE:23
def division(division:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.division(division), HandlerDef(this, "controllers.Application", "division", Seq(classOf[Integer]), "POST", """""", _prefix + """division/$division<[0-9]+>""")
)
                      

// @LINE:22
def postcode(uppercode:String, lowercode:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.postcode(uppercode, lowercode), HandlerDef(this, "controllers.Application", "postcode", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """postcode/$uppercode<[^/]+>/$lowercode<[^/]+>""")
)
                      

// @LINE:21
def subjects(departmentid:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.subjects(departmentid), HandlerDef(this, "controllers.Application", "subjects", Seq(classOf[String]), "POST", """""", _prefix + """subjects/$departmentid<[^/]+>""")
)
                      

// @LINE:20
def departments(schoolid:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.departments(schoolid), HandlerDef(this, "controllers.Application", "departments", Seq(classOf[String]), "POST", """""", _prefix + """departments/$schoolid<[^/]+>""")
)
                      

// @LINE:19
def schools(division:String, prefecture:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.schools(division, prefecture), HandlerDef(this, "controllers.Application", "schools", Seq(classOf[String], classOf[String]), "POST", """ Common""", _prefix + """schools/$division<[^/]+>/$prefecture<[^/]+>""")
)
                      
    
}
                          
}
        

// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:61
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
package controllers.admin.ref {


// @LINE:66
// @LINE:65
class ReverseGroup {
    

// @LINE:65
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Group.index(), HandlerDef(this, "controllers.admin.Group", "index", Seq(), "GET", """""", _prefix + """admin/groups""")
)
                      

// @LINE:66
def gainGroupList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Group.gainGroupList(), HandlerDef(this, "controllers.admin.Group", "gainGroupList", Seq(), "POST", """""", _prefix + """admin/groups""")
)
                      
    
}
                          

// @LINE:61
// @LINE:53
// @LINE:52
class ReverseApplication {
    

// @LINE:61
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Application.logout(), HandlerDef(this, "controllers.admin.Application", "logout", Seq(), "POST", """""", _prefix + """admin/logout""")
)
                      

// @LINE:52
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Application.index(), HandlerDef(this, "controllers.admin.Application", "index", Seq(), "GET", """ admin""", _prefix + """admin""")
)
                      

// @LINE:53
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Application.login(), HandlerDef(this, "controllers.admin.Application", "login", Seq(), "POST", """""", _prefix + """admin/login""")
)
                      
    
}
                          

// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
class ReverseAdministrator {
    

// @LINE:58
def dashBoardLap(empNo:String, monthTerm:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Administrator.dashBoardLap(empNo, monthTerm), HandlerDef(this, "controllers.admin.Administrator", "dashBoardLap", Seq(classOf[String], classOf[Integer]), "GET", """""", _prefix + """admin/dashboard/lap""")
)
                      

// @LINE:57
def dashBoardSchedule(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Administrator.dashBoardSchedule(), HandlerDef(this, "controllers.admin.Administrator", "dashBoardSchedule", Seq(), "GET", """""", _prefix + """admin/dashboard/schedule""")
)
                      

// @LINE:56
def dashBoardActivity(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Administrator.dashBoardActivity(), HandlerDef(this, "controllers.admin.Administrator", "dashBoardActivity", Seq(), "GET", """""", _prefix + """admin/dashboard/acitivity""")
)
                      

// @LINE:55
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Administrator.index(), HandlerDef(this, "controllers.admin.Administrator", "index", Seq(), "GET", """""", _prefix + """admin/dashbord""")
)
                      

// @LINE:59
def dashBoardEvent(jobTypeId:Long, eventGroupId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Administrator.dashBoardEvent(jobTypeId, eventGroupId), HandlerDef(this, "controllers.admin.Administrator", "dashBoardEvent", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """admin/dashboard/event""")
)
                      
    
}
                          

// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:69
// @LINE:68
// @LINE:67
class ReverseSchoolGroup {
    

// @LINE:69
def newSchoolGroup(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.SchoolGroup.newSchoolGroup(), HandlerDef(this, "controllers.admin.SchoolGroup", "newSchoolGroup", Seq(), "GET", """""", _prefix + """admin/schoolgroup/new""")
)
                      

// @LINE:71
def confirm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.SchoolGroup.confirm(), HandlerDef(this, "controllers.admin.SchoolGroup", "confirm", Seq(), "POST", """""", _prefix + """admin/schoolgroup/new/confirm""")
)
                      

// @LINE:72
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.SchoolGroup.register(), HandlerDef(this, "controllers.admin.SchoolGroup", "register", Seq(), "POST", """""", _prefix + """admin/schoolgroup/new/register""")
)
                      

// @LINE:70
def searchSchool(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.SchoolGroup.searchSchool(), HandlerDef(this, "controllers.admin.SchoolGroup", "searchSchool", Seq(), "POST", """""", _prefix + """admin/schoolgroup/new""")
)
                      

// @LINE:67
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.SchoolGroup.index(), HandlerDef(this, "controllers.admin.SchoolGroup", "index", Seq(), "GET", """""", _prefix + """admin/schoolgroups""")
)
                      

// @LINE:68
def gainSchoolGroups(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.SchoolGroup.gainSchoolGroups(), HandlerDef(this, "controllers.admin.SchoolGroup", "gainSchoolGroups", Seq(), "POST", """""", _prefix + """admin/schoolgroups""")
)
                      
    
}
                          

// @LINE:64
// @LINE:63
class ReverseStudent {
    

// @LINE:64
def searchResult(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Student.searchResult(), HandlerDef(this, "controllers.admin.Student", "searchResult", Seq(), "POST", """""", _prefix + """admin/student/search""")
)
                      

// @LINE:63
def search(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.admin.Student.search(), HandlerDef(this, "controllers.admin.Student", "search", Seq(), "GET", """""", _prefix + """admin/student/search""")
)
                      
    
}
                          
}
        

// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:41
// @LINE:40
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:32
// @LINE:31
// @LINE:27
// @LINE:26
// @LINE:16
// @LINE:15
// @LINE:13
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
package controllers.student.ref {


// @LINE:16
// @LINE:15
class ReverseEntry {
    

// @LINE:16
def unsubscribe(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Entry.unsubscribe(), HandlerDef(this, "controllers.student.Entry", "unsubscribe", Seq(), "POST", """""", _prefix + """student/unsubscribe""")
)
                      

// @LINE:15
def confirmUnsubscribe(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Entry.confirmUnsubscribe(), HandlerDef(this, "controllers.student.Entry", "confirmUnsubscribe", Seq(), "GET", """""", _prefix + """student/unsubscribe""")
)
                      
    
}
                          

// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
class ReverseEvent {
    

// @LINE:49
def cancel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Event.cancel(), HandlerDef(this, "controllers.student.Event", "cancel", Seq(), "POST", """""", _prefix + """student/event/cancel""")
)
                      

// @LINE:44
def index(eventid:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Event.index(eventid), HandlerDef(this, "controllers.student.Event", "index", Seq(classOf[Long]), "GET", """event""", _prefix + """student/event/entry/$eventid<[^/]+>""")
)
                      

// @LINE:45
def confirm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Event.confirm(), HandlerDef(this, "controllers.student.Event", "confirm", Seq(), "POST", """""", _prefix + """student/event/confirm""")
)
                      

// @LINE:46
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Event.register(), HandlerDef(this, "controllers.student.Event", "register", Seq(), "POST", """""", _prefix + """student/event/entry""")
)
                      

// @LINE:48
def confirmCancel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Event.confirmCancel(), HandlerDef(this, "controllers.student.Event", "confirmCancel", Seq(), "GET", """GET     /student/event                       controllers.student.Event.view()""", _prefix + """student/event/cancel""")
)
                      
    
}
                          

// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
class ReverseQuery {
    

// @LINE:37
def confirm(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Query.confirm(), HandlerDef(this, "controllers.student.Query", "confirm", Seq(), "GET", """""", _prefix + """student/queryform/confirm""")
)
                      

// @LINE:38
def send(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Query.send(), HandlerDef(this, "controllers.student.Query", "send", Seq(), "POST", """""", _prefix + """student/queryform""")
)
                      

// @LINE:36
def view(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Query.view(), HandlerDef(this, "controllers.student.Query", "view", Seq(), "GET", """""", _prefix + """student/queryform""")
)
                      

// @LINE:35
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Query.index(), HandlerDef(this, "controllers.student.Query", "index", Seq(), "GET", """Query""", _prefix + """student/query""")
)
                      
    
}
                          

// @LINE:41
// @LINE:40
// @LINE:32
// @LINE:31
class ReversePassword {
    

// @LINE:41
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Password.update(), HandlerDef(this, "controllers.student.Password", "update", Seq(), "POST", """""", _prefix + """student/password""")
)
                      

// @LINE:40
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Password.index(), HandlerDef(this, "controllers.student.Password", "index", Seq(), "GET", """""", _prefix + """student/password""")
)
                      

// @LINE:31
def viewRepublish(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Password.viewRepublish(), HandlerDef(this, "controllers.student.Password", "viewRepublish", Seq(), "GET", """ Password""", _prefix + """student/password/republish""")
)
                      

// @LINE:32
def republish(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Password.republish(), HandlerDef(this, "controllers.student.Password", "republish", Seq(), "POST", """""", _prefix + """student/password/republish""")
)
                      
    
}
                          

// @LINE:13
class ReverseMyPage {
    

// @LINE:13
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.MyPage.index(), HandlerDef(this, "controllers.student.MyPage", "index", Seq(), "GET", """""", _prefix + """student/mypage""")
)
                      
    
}
                          

// @LINE:27
// @LINE:26
class ReverseSample {
    

// @LINE:27
def doTest(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Sample.doTest(), HandlerDef(this, "controllers.student.Sample", "doTest", Seq(), "POST", """""", _prefix + """student/sample/doPost""")
)
                      

// @LINE:26
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Sample.index(), HandlerDef(this, "controllers.student.Sample", "index", Seq(), "GET", """ Sample ↓いずれけします""", _prefix + """student/sample/index""")
)
                      
    
}
                          

// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:11
def agree(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Application.agree(), HandlerDef(this, "controllers.student.Application", "agree", Seq(), "GET", """""", _prefix + """student/agree""")
)
                      

// @LINE:10
def completed(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Application.completed(), HandlerDef(this, "controllers.student.Application", "completed", Seq(), "GET", """""", _prefix + """student/completed""")
)
                      

// @LINE:9
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Application.logout(), HandlerDef(this, "controllers.student.Application", "logout", Seq(), "POST", """""", _prefix + """student/logout""")
)
                      

// @LINE:7
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Application.index(), HandlerDef(this, "controllers.student.Application", "index", Seq(), "GET", """ Home page""", _prefix + """student/index""")
)
                      

// @LINE:8
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.student.Application.login(), HandlerDef(this, "controllers.student.Application", "login", Seq(), "POST", """""", _prefix + """student/login""")
)
                      
    
}
                          
}
        
    