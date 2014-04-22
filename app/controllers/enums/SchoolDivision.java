/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */

package controllers.enums;

import play.i18n.Messages;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 学校区分Enum.
 * @author a12609
 */

public enum SchoolDivision {
    /** 大学. */
    UNIVERSITY           (1, false, Messages.get("enum.schooldivision.university")),
    /** 大学院(修士). */
    MASTER               (2, false, Messages.get("enum.schooldivision.master")),
    /** 大学院(博士). */
    DOCTOR               (3, false, Messages.get("enum.schooldivision.doctor")),
    /** 外国大学日本校. */
    FOREIGN_UNIVERSITY_JP(4, true,  Messages.get("enum.schooldivision.foreign_university_jp")),
    /** 外国大学. */
    FOREIGN_UNIVERSITY   (5, true,  Messages.get("enum.schooldivision.foreign_university")),
    /** その他. */
    OTHER                (6, true,  Messages.get("enum.schooldivision.other"));

    /**
     * コード.
     */
    private Integer code;
    /**
     * 名前.
     */
    private String name;
    /**
     * 外国大学フラグ.
     */
    private Boolean foreignFlg;
    /**
     * enum検索用map.
     */
    private static final Map<Integer, SchoolDivision> CODEMAP;

    static {
        Map<Integer, SchoolDivision> map = new HashMap<>();
        for (SchoolDivision t : values()) {
            map.put(t.code, t);
        }
        CODEMAP = Collections.unmodifiableMap(map);
    }

    /**
     * コンストラクタ.
     * @param code       コード
     * @param foreignFlg 外国大学フラグ
     * @param name       名前
     */
    SchoolDivision(Integer code, Boolean foreignFlg, String name) {
        this.code = code;
        this.name = name;
        this.foreignFlg = foreignFlg;
    }

    /**
     * codeからforeignFlgを検索.
     * @param code コード
     * @return 外国大学フラグ
     */
    public static Boolean getForeignFlg(Integer code) {
        return CODEMAP.get(code) == null ? false : CODEMAP.get(code).foreignFlg;
    }

    /**
     * codeからnameを検索.
     * @param code コード
     * @return 名前
     */
    public static String getName(Integer code) {
        return CODEMAP.get(code) == null ? "" : CODEMAP.get(code).name;
    }

    /**
     * codeとnameのMap生成.
     * @return codeとnameのMap
     */
    public static Map<String, String> getMap() {
        Map<String, String> map = new LinkedHashMap<>();
        for (SchoolDivision s : values()) {
            map.put(s.code.toString(), s.name);
        }
        return map;
    }

    /**
     * codeのgetter.
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * nameのgetter.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * foreignFlgのgetter.
     * @return foreignFlg
     */
    public Boolean getForeignFlg() {
        return foreignFlg;
    }
}
