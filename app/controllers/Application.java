/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */

package controllers;

import base.SaiyoAcl;
import base.SaiyoRoles;
import controllers.enums.SchoolDivision;
import models.*;
import models.services.EntryUserSchoolService;
import play.libs.Json;
import play.mvc.Result;

import java.util.List;

/**
 * @author a12609
 */

public class Application extends SaiyoController {
    /**
     * 郵便番号検索.
     * @param code1 郵便番号(1) 前部分
     * @param code2 郵便番号(2) 後部分
     * @return 処理結果
     */
    @SaiyoAcl(roles = { SaiyoRoles.ACCESSIBLE })
    public static Result postcode(String code1, String code2) {
        Integer codeNumber1;
        Integer codeNumber2;
        try {
            codeNumber1 = Integer.valueOf(code1);
            codeNumber2 = Integer.valueOf(code2);
        } catch (NumberFormatException e) {
            return badRequest();
        }

        PostalCode postalCode = PostalCode.finder.where()
                .eq("codeNumber1", codeNumber1)
                .eq("codeNumber2", codeNumber2)
                .findUnique();

        if (postalCode == null) {
            return badRequest();
        } else {
            return ok(Json.toJson(postalCode));
        }
    }

    /**
     * 学校名一覧取得.
     * @param division     学校区分
     * @param prefectureid 都道府県
     * @return 処理結果
     */
    @SaiyoAcl(roles = { SaiyoRoles.ACCESSIBLE })
    public static Result schools(String division, String prefectureid) {
        Long lprefecturesid;
        Integer ldivision;

        try {
            lprefecturesid = Long.valueOf(prefectureid);
            ldivision = Integer.valueOf(division);
        } catch (NumberFormatException e) {
            return badRequest();
        }

        List<School> schoolList = new EntryUserSchoolService()
                .getSchoolListByDivision(ldivision, lprefecturesid);

        return ok(Json.toJson(schoolList));
    }

    /**
     * 学部一覧取得.
     * @param schoolid 学校ID
     * @return 処理結果
     */
    @SaiyoAcl(roles = { SaiyoRoles.ACCESSIBLE })
    public static Result departments(String schoolid) {
        Long lschoolid;

        try {
            lschoolid = Long.valueOf(schoolid);
        } catch (NumberFormatException e) {
            return badRequest();
        }

        List<SchoolDepartment> departmentList = new EntryUserSchoolService()
                .getDepartmentListBySchool(lschoolid);

        return ok(Json.toJson(departmentList));
    }

    /**
     * 学科一覧取得.
     * @param departmentid 学部ID
     * @return 処理結果
     */
    @SaiyoAcl(roles = { SaiyoRoles.ACCESSIBLE })
    public static Result subjects(String departmentid) {
        Long lDepartmentid;

        try {
            lDepartmentid = Long.valueOf(departmentid);
        } catch (NumberFormatException e) {
            return badRequest();
        }

        List<SchoolSubject> subjectList = new EntryUserSchoolService()
                .getSubjectListByDepartment(lDepartmentid);

        return ok(Json.toJson(subjectList));
    }

    /**
     * 学校区分海外フラグ取得.
     * @param division 学校区分
     * @return 処理結果
     */
    @SaiyoAcl(roles = { SaiyoRoles.ACCESSIBLE })
    public static Result division(Integer division) {
        if (SchoolDivision.getForeignFlg(division)) {
            return ok(Json.toJson(SchoolDivision.getForeignFlg(division)));
        } else {
            return noContent();
        }
    }
}
