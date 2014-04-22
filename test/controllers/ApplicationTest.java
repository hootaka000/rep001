/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */

package controllers;

import base.SaiyoTestBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.enums.SchoolDivision;
import models.*;
import org.junit.Test;
import play.api.libs.json.JsValue;
import play.api.libs.json.Json;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.*;

/**
 * @author a12609
 */

public class ApplicationTest extends SaiyoTestBase {
    /**
     * 郵便番号検索テスト.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void postcode() {
        Prefectures prefectures =
                Prefectures.finder.where().eq("name", "大阪府").findUnique();

        PostalCode testCode = new PostalCode();
        testCode.placeName = "大阪府テスト区テスト";
        testCode.codeNumber1 = 1234;
        testCode.codeNumber2 = 567890;
        prefectures.postalCodes.add(testCode);
        prefectures.save();

        Result result;
        String codeNumber1;
        String codeNumber2;

        // 数字以外
        codeNumber1 = "aaa";
        codeNumber2 = "bbbb";
        result = route(fakeRequest(POST, "/postcode/" + codeNumber1 + "/" + codeNumber2));
        assertThat(status(result)).isEqualTo(BAD_REQUEST);

        // 存在しない郵便番号
        codeNumber1 = "111";
        codeNumber2 = "2222";
        result = route(fakeRequest(POST, "/postcode/" + codeNumber1 + "/" + codeNumber2));
        assertThat(status(result)).isEqualTo(BAD_REQUEST);

        // 正しい郵便番号
        codeNumber1 = testCode.codeNumber1.toString();
        codeNumber2 = testCode.codeNumber2.toString();
        result = route(fakeRequest(POST, "/postcode/" + codeNumber1 + "/" + codeNumber2));
        assertThat(status(result)).isEqualTo(OK);

        String test = contentAsString(result);
        JsValue value = Json.parse(test);

        Map<String, Object> map = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(value.toString(), Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> prefecturesMap = (Map) map.get("prefectures");
        assertEquals(testCode.placeName, map.get("placeName"));
        assertEquals(prefectures.id.intValue(), prefecturesMap.get("id"));
    }

    /**
     * 学校名一覧取得テスト.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void schools() {
        // テスト用レコード生成
        Prefectures prefectures = Prefectures.finder.byId(1L);
        School school = new School();
        school.delflag = false;
        school.name = "テスト学校";
        school.division = SchoolDivision.UNIVERSITY.getCode();
        prefectures.schools.add(school);
        prefectures.save();

        // テスト用変数
        Result result;
        String division;
        String prefectureid;

        // 数字以外
        division = "aaa";
        prefectureid = "bbbb";

        result = route(fakeRequest(POST, "/schools/" + division + "/" + prefectureid));
        assertThat(status(result)).isEqualTo(BAD_REQUEST);

        // 学校リスト検索結果0件
        division = "0";
        prefectureid = prefectures.id.toString();

        result = route(fakeRequest(POST, "/schools/" + division + "/" + prefectureid));
        assertThat(status(result)).isEqualTo(OK);
        assertTrue(resultToJsonList(result).isEmpty());

        // 学校リスト検索結果1件以上
        division = school.division.toString();
        prefectureid = prefectures.id.toString();

        // 学校名登録件数
        Integer count = School.finder.where()
                .eq("division", school.division)
                .eq("prefecturesid", prefectures.id)
                .findRowCount();

        result = route(fakeRequest(POST, "/schools/" + division + "/" + prefectureid));
        assertThat(status(result)).isEqualTo(OK);

        List<Map<String, Object>> jsonList = resultToJsonList(result);
        assertEquals(count, (Integer) jsonList.size());
        boolean existTestItem = false;
        for (Map<String, Object> schoolMap : jsonList) {
            if (schoolMap.get("name").equals(school.name)) {
                existTestItem = true;
                assertEquals(Long.valueOf((Integer) schoolMap.get("id")), school.id);
                assertEquals(schoolMap.get("division"), school.division);
            }
        }
        assertTrue(existTestItem);
    }

    /**
     * 学部一覧取得テスト.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void departments() {
        // テスト用レコード生成
        School school = School.finder.byId(1L);
        SchoolDepartment department = new SchoolDepartment();
        department.department = "テスト学部";
        department.delflag = false;
        school.schoolDepartments.add(department);
        school.save();

        // テスト用変数
        Result result;
        String schoolid;

        // 数字以外
        schoolid = "aaa";

        result = route(fakeRequest(POST, "/departments/" + schoolid));
        assertThat(status(result)).isEqualTo(BAD_REQUEST);

        // 学部リスト検索結果0件
        schoolid = "0";

        result = route(fakeRequest(POST, "/departments/" + schoolid));
        assertThat(status(result)).isEqualTo(OK);
        assertTrue(resultToJsonList(result).isEmpty());

        //  学部リスト検索結果1件以上
        schoolid = school.id.toString();

        // 学部登録件数
        Integer count = SchoolDepartment.finder.where()
                .eq("schoolid", school.id)
                .findRowCount();

        result = route(fakeRequest(POST, "/departments/" + schoolid));
        assertThat(status(result)).isEqualTo(OK);

        List<Map<String, Object>> jsonList = resultToJsonList(result);
        assertEquals(count, (Integer) jsonList.size());
        boolean existTestItem = false;
        for (Map<String, Object> departmentMap : jsonList) {
            if (departmentMap.get("department").equals(department.department)) {
                existTestItem = true;
                assertEquals(Long.valueOf((Integer) departmentMap.get("id")), department.id);
            }
        }
        assertTrue(existTestItem);
    }

    /**
     * 学科一覧取得テスト.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void subjects() {
        // テスト用レコード生成
        SchoolDepartment department = SchoolDepartment.finder.byId(1L);
        SchoolSubject subject = new SchoolSubject();
        subject.subject = "テスト学科";
        subject.delflag = false;
        department.schoolSubjects.add(subject);
        department.save();

        // テスト用変数
        Result result;
        String departmentid;

        // 数字以外
        departmentid = "aaa";

        result = route(fakeRequest(POST, "/subjects/" + departmentid));
        assertThat(status(result)).isEqualTo(BAD_REQUEST);

        // 学科リスト検索結果0件
        departmentid = "0";

        result = route(fakeRequest(POST, "/subjects/" + departmentid));
        assertThat(status(result)).isEqualTo(OK);
        assertTrue(resultToJsonList(result).isEmpty());

        // 学科リスト検索結果1件以上
        departmentid = department.id.toString();

        // 学科登録件数
        Integer count = SchoolSubject.finder.where()
                .eq("school_departmentid", department.id)
                .findRowCount();

        result = route(fakeRequest(POST, "/subjects/" + departmentid));
        assertThat(status(result)).isEqualTo(OK);

        List<Map<String, Object>> jsonList = resultToJsonList(result);
        assertEquals(count, (Integer) jsonList.size());
        boolean existTestItem = false;
        for (Map<String, Object> subjectMap : jsonList) {
            if (subjectMap.get("subject").equals(subject.subject)) {
                existTestItem = true;
                assertEquals(Long.valueOf((Integer) subjectMap.get("id")), subject.id);
            }
        }
        assertTrue(existTestItem);
    }

    /**
     * 学校区分海外フラグ取得テスト.
     */
    @Test
    public void division() {
        // テスト用変数
        Result result;
        Integer divisionCode;
        String divisionStr;

        // 数字以外
        divisionStr = "aaa";
        result = route(fakeRequest(POST, "/division/" + divisionStr));
        assertNull(result);

        // 国内
        divisionCode = SchoolDivision.UNIVERSITY.getCode();
        result = route(fakeRequest(POST, "/division/" + divisionCode));
        assertThat(status(result)).isEqualTo(NO_CONTENT);

        // 海外
        divisionCode = SchoolDivision.FOREIGN_UNIVERSITY.getCode();
        result = route(fakeRequest(POST, "/division/" + divisionCode));
        assertThat(status(result)).isEqualTo(OK);
        assertEquals("true" , contentAsString(result));
    }

    /**
     * 戻り値のJsonからリストに変換.
     * @param result リクエスト結果
     * @return jsonから変換したList
     */
    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> resultToJsonList(Result result) {
        List<Map<String, Object>> jsonList = null;
        JsValue jsonValue = Json.parse(contentAsString(result));
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonList = mapper.readValue(jsonValue.toString(), ArrayList.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonList;
    }
}
