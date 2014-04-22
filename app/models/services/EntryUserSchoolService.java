/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */

package models.services;

import models.School;
import models.SchoolDepartment;
import models.SchoolSubject;

import java.util.List;

/**
 * @author a12609
 */

public class EntryUserSchoolService {
    /**
     * 学校リスト取得.
     * @param division   学校区分
     * @param prefecturesid 都道府県
     * @return 処理結果
     */
    public List<School> getSchoolListByDivision(Integer division, Long prefecturesid) {
        return School.finder.where()
                .eq("prefecturesid", prefecturesid)
                .eq("division", division)
                .findList();
    }

    /**
     * 学部一覧取得.
     * @param schoolid 学校ID
     * @return 処理結果
     */
    public List<SchoolDepartment> getDepartmentListBySchool(Long schoolid) {
        return SchoolDepartment.finder.where()
                .eq("schoolid", schoolid)
                .findList();
    }

    /**
     * 学科一覧取得.
     * @param departmentid 学部ID
     * @return 処理結果
     */
    public List<SchoolSubject> getSubjectListByDepartment(Long departmentid) {
        return SchoolSubject.finder.where()
                .eq("school_departmentid", departmentid)
                .findList();
    }
}
