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
 * レポート種別 Enum.
 * @author a12609
 */
public enum ReportType {
    
/*
1 : 登録日
2 : 性別
3 : 登録者数
4 : 内定者数
5 : 最終面接
6 : 説明会 
enum.reporttype.torokubi=登録日
enum.reporttype.seibetsu=性別
enum.reporttype.torokushasu=登録者数
enum.reporttype.naiteishasu=内定者数
enum.reporttype.saishumensetsu=最終面接
enum.reporttype.setsumeikai=説明会 
 */
    
    /** 登録日. */
    TOROKUBI  (1, Messages.get("enum.reporttype.torokubi")),
    /** 性別 */
    SEIBETSU  (2, Messages.get("enum.reporttype.seibetsu")),
    /** 登録者数 */
    TOROKUSHASU  (3, Messages.get("enum.reporttype.torokushasu")),
    /** 内定者数 */
    NAITEISHASU  (4, Messages.get("enum.reporttype.naiteishasu")),
    /** 最終面接 */
    SAISHUMENSETSU  (5, Messages.get("enum.reporttype.saishumensetsu")),
    /** 説明会 */
    SETSUMEIKAI (6, Messages.get("enum.reporttype.setsumeikai"));

    /**
     * コード.
     */
    private Integer code;
    /**
     * 名前.
     */
    private String name;
    /**
     * enum検索用map.
     */
    private static final Map<Integer, ReportType> CODEMAP;

    static {
        Map<Integer, ReportType> map = new HashMap<>();
        for (ReportType t : values()) {
            map.put(t.code, t);
        }
        CODEMAP = Collections.unmodifiableMap(map);
    }

    /**
     * コンストラクタ.
     * @param code コード
     * @param name 名前
     */
    ReportType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
    
    /**
     * コード値を取得する
     * @return コード値
     */
    public Integer getCode() {
        return this.code;
    }
    
    /**
     * 名前を取得する
     * @return 名前
     */
    public String getName() {
        return this.name;
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
        for (ReportType s : values()) {
            map.put(s.code.toString(), s.name);
        }
        return map;
    }
}
