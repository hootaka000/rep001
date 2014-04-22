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
 * 文理区分Enum.
 * @author a12609
 */
public enum Classification {
    /** 文系. */
    ART    (1, Messages.get("enum.classification.art")),
    /** 理系. */
    SCIENCE(2, Messages.get("enum.classification.science")),
    /** その他. */
    OTHER  (3, Messages.get("enum.classification.other"));

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
    private static final Map<Integer, Classification> CODEMAP;

    static {
        Map<Integer, Classification> map = new HashMap<>();
        for (Classification t : values()) {
            map.put(t.code, t);
        }
        CODEMAP = Collections.unmodifiableMap(map);
    }

    /**
     * コンストラクタ.
     * @param code コード
     * @param name 名前
     */
    Classification(Integer code, String name) {
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
        for (Classification s : values()) {
            map.put(s.code.toString(), s.name);
        }
        return map;
    }
}
