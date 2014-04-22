/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */

package controllers.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import play.i18n.Messages;

/**
 * 学校区分Enum.
 * @author a12152
 */

public enum EntryStatus {
    
    
    /** 未選考. */
    MISENKO(0, Messages.get("enum.entrystatus.misenko")),
    /** 選考中. */
    SENKOCHU(1, Messages.get("enum.entrystatus.senkochu")),
    /** 不合格 */
    FUGOKAKU(2, Messages.get("enum.entrystatus.fugokaku")),
    /** 辞退 */
    JITAI(3, Messages.get("enum.entrystatus.jitai")),
    /** 内定 */
    NAITEI(4, Messages.get("enum.entrystatus.naitei")),
    /** 内定辞退 */
    NAITEI_JITAI(5, Messages.get("enum.entrystatus.naitei_jitai")),
    /** 内々定 */
    NAI_NAITEI(6, Messages.get("enum.entrystatus.nai_naitei"));
    
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
    private static final Map<Integer, EntryStatus> CODEMAP;

    static {
        Map<Integer, EntryStatus> map = new HashMap<>();
        for (EntryStatus t : values()) {
            map.put(t.code, t);
        }
        CODEMAP = Collections.unmodifiableMap(map);
    }

    /**
     * コンストラクタ.
     * @param code コード
     * @param name 名前
     */
    EntryStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
    
    /**
     * コード値の取得
     * @return
     */
    public Integer getCode() {
        return this.code;
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
        for (EntryStatus s : values()) {
            map.put(s.code.toString(), s.name);
        }
        return map;
    }
    
}
