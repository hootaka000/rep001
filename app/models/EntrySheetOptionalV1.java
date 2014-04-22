/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import utils.*;

import com.avaje.ebean.annotation.*;

/**
 * エントリーシート（任意）ver.1.
 * @author A13413
 */
@Entity
public class EntrySheetOptionalV1 extends Model {

    /** シリアルバージョンUID. */
    private static final long serialVersionUID = 8185112696679987057L;
    /** finder. */
    public static Finder<Long, EntrySheetOptionalV1> finder = new Finder<Long, EntrySheetOptionalV1>(Long.class,
            EntrySheetOptionalV1.class);

    /**
     * ID.
     */
    @Id
    public Long id;

    /**
     * 志望職種.
     */
    @Column(length = 1024)
    public String jobType;
    /**
     * 自己PR
     */
    @Encrypted(dbEncryption = true, dbLength = 6000)
    public String selfPr;
    /**
     * 特技・趣味
     */
    @Encrypted(dbEncryption = true, dbLength = 6000)
    public String feats;
    /**
     * クラブ・サークル活動
     */
    @Encrypted(dbEncryption = true, dbLength = 6000)
    public String club;
    /**
     * アカウント情報.
     */
    @Encrypted(dbEncryption = true, dbLength = 2000)
    public String siteAccount;
    /**
     * プログラミング経験年数.
     */
    public Integer programmingYear;
    /**
     * プログラミング言語レベル.
     */
    @Column(length = 1024)
    public String programmingLevel;
    /**
     * その他のプログラミング言語レベル.
     */
    @Column(length = 1000)
    public String programmingLevelOther;
    /**
     * ミドルウェア・データベースレベル.
     */
    @Column(length = 1024)
    public String middlewareLebel;
    /**
     * その他のミドルウェア・データベースレベル.
     */
    @Column(length = 1000)
    public String middlewareLebelOther;
    /**
     * 資格情報.
     */
    @Column(length = 1000)
    public String license;
    /**
     * ポートフォリオの有無.
     */
    public Boolean portfolio;
    /**
     * ポートフォリオのURL
     */
    @Encrypted(dbEncryption = true, dbLength = 6000)
    public String portfolioUrl;
    /**
     * デザインレベル.
     */
    @Column(length = 1024)
    public String designLevel;
    /**
     * その他のデザインレベル.
     */
    @Column(length = 1000)
    public String designLevelOther;
    /**
     * 更新日時.
     */
    @UpdatedTimestamp
    public java.util.Date updatedAt;
    /**
     * ロックバージョン.
     */
    @Version
    public Long lockVersion;

    /**
     * プログラミング言語レベルを返す.
     * @return プログラミング言語レベル
     */
    public Map<String, Integer> getProgrammingLevel() {
        return parseLevelText(programmingLevel);
    }

    /**
     * ミドルウェア・データベースレベルを返す.
     * @return ミドルウェア・データベースレベル
     */
    public Map<String, Integer> getMiddlewareLevel() {
        return parseLevelText(middlewareLebel);
    }

    /**
     * デザインレベルを返す.
     * @return デザインレベル
     */
    public Map<String, Integer> getDesignLevel() {
        return parseLevelText(designLevel);
    }

    /**
     * 下記の形式になっている文字列を解析してMap形式に変換する. {key}:{value},{key}:{value},...
     * @param text 解析対象文字列
     * @return 解析結果
     */
    private Map<String, Integer> parseLevelText(String text) {
        Map<String, Integer> result = new HashMap<>();
        String[] nodes = text.split(",");
        for (String node : nodes) {
            if (node.isEmpty()) {
                continue;
            }
            String[] keyValue = node.split(":");
            if (keyValue.length != 2) {
                continue;
            }
            String key = keyValue[0];
            String value = keyValue[1];
            if (key != null && !key.isEmpty()) {
                try {
                    result.put(key, Integer.parseInt(value));
                } catch (NumberFormatException e) {
                    AppLogUtil.warn(e.getMessage(), e);
                }
            }
        }
        return result;
    }
}
