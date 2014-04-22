package models;
import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import javax.persistence.CascadeType;

import org.junit.Test;

import play.Logger;
import scalaz.std.effect.sql.preparedStatement;
import utils.AppLogUtil;
import base.SaiyoTestBase;

/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class EmployeeTest extends SaiyoTestBase {
    
    
    // @作業メモ
    // ここはUtilのテストなどでつかう
    // models.*と、utils.* 配下のクラス単体をする
    
    

    /**
     * OneToOneのチェック
     */
    @Test
    public void testSave001() {
        
        Prefectures prefectures = Prefectures.finder.where().eq("name", "大阪府").findUnique();
        
        PostalCode postalCode = new PostalCode();
        postalCode.placeName = "大阪府テスト区テスト";
        postalCode.codeNumber1 = 123;
        postalCode.codeNumber2 = 4567;
        prefectures.postalCodes.add(postalCode);

        prefectures.save();
        
//        AppLogUtil.debug("-----------------------");
//        
//        School school = School.finder.where().eq("prefecturesid", 1).eq("division", 1).findUnique();
//        AppLogUtil.debug(school.name);
//        
//        Employee employee = new Employee();
//        employee.employeeNumber = "A12152";
//        employee.employeeStatus = 1;
//        employee.name = "宮嶋雅文";
//        
//        Interviewer interviewer = new Interviewer();
//        interviewer.status = 9;
//                
//        interviewer.employee = employee;
//        
//        interviewer.save();
//        
//        List<Employee> employees = Employee.finder.all();
//        assertThat(1).isEqualTo(employees.size());
//        
//        for (Employee result : employees) {
//            AppLogUtil.debug(result.employeeNumber);
//        }
        
    }
    
    @Test
    public void testSave002() {
        
        Employee employee = Employee.finder.where().eq("employeeNumber", "A12152").findUnique();
        
        assertThat(employee).isNotNull();
        assertThat(employee.name).isEqualTo("宮嶋雅文");
        
        Interviewer interviewer = new Interviewer();
        interviewer.status = 9;
        employee.interviewer = interviewer;
        
        employee.save();
        
        assertThat(employee.interviewer.id).isNotNull();
        assertThat(employee.interviewer.status).isEqualTo(9);
        
    }
    
    
    


}
