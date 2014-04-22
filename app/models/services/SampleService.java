package models.services;

import models.*;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.*;

/**
 * サンプルのサービス層
 * @author masafumi
 * FIXME must delete!
 */
public class SampleService {

    private SampleService() {
    }

    private static SampleService service = new SampleService();

    public static SampleService getInstance() {
        return service;
    }

    /**
     * 業務ロジックを実行
     */
    @Transactional(type = TxType.REQUIRED)
    public Interviewer doBizLogic(String name) {

        // Employee employee = this.createEmployee(name);
        //
        // AppLogUtil.debug("fafa");
        // List<Employee> employees = Employee.finder.all();
        // for (Employee e : employees) {
        // AppLogUtil.debug(e.name);
        // }
        //
        //
        // if (employee.employeeStatus > 0) {
        // //throw new RuntimeException("これはエラーだ");
        // }
        //
        //
        //
        // Interviewer inteviewer = new Interviewer();
        // inteviewer.status = 9;
        // inteviewer.employee = employee;
        // inteviewer.save();

        return null;
    }

    public Employee createEmployee(String name) {

        // Employee employee = new Employee();
        // employee.name = name;
        // employee.employeeNumber = "A12152";
        // employee.employeeStatus = 1;
        // employee.save();
        //
        // return employee;
        return null;
    }
}
