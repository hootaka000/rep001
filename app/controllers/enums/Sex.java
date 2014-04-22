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
 * 性別Enum.
 * @author a12609
 */
public enum Sex {
    /** 男性. */
    MAN  (0, Messages.get("enum.sex.man")),
    /** 女性. */
    WOMAN(1, Messages.get("enum.sex.woman"));

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
    private static final Map<Integer, Sex> CODEMAP;

    static {
        Map<Integer, Sex> map = new HashMap<>();
        for (Sex t : values()) {
            map.put(t.code, t);
        }
        CODEMAP = Collections.unmodifiableMap(map);
    }

    /**
     * コンストラクタ.
     * @param code コード
     * @param name 名前
     */
    Sex(Integer code, String name) {
        this.code = code;
        this.name = name;
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
        for (Sex s : values()) {
            map.put(s.code.toString(), s.name);
        }
        return map;
    }
}
