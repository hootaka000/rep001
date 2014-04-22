/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */

package controllers.enums;


/**
 * 学校区分Enum.
 * @author a12152
 */

public enum SystemMasterKey {
       
    ADMIN_TARGET_YEAR("admtargetyear", "管理側の採用対象年度");
    
    /**
     * コード.
     */
    private String configKey;
    /**
     * 説明（簡易：デバッグ用）.
     */
    private String desc;


    /**
     * コンストラクタ.
     * @param code コード
     * @param name 名前
     */
    private SystemMasterKey(String key, String desc) {
        this.configKey = key;
        this.desc = desc;
    }
    
    /**
     * キー値を取得する
     * @return キー値
     */
    public String getConfigKey() {
        return this.configKey;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    @Deprecated
    public String toString() {
        return this.desc;
    }
    
    

    
}
