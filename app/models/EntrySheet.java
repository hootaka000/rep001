/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package models;

import javax.persistence.*;
import javax.validation.constraints.*;

import play.db.ebean.*;

import com.avaje.ebean.annotation.*;

/**
 * エントリーシート.
 * @author A13413
 */
public class EntrySheet extends Model {

    /** シリアルバージョンUID. */
    private static final long serialVersionUID = 4173984498768795002L;
    /** finder. */
    public static Finder<Long, EntrySheet> finder = new Finder<Long, EntrySheet>(Long.class, EntrySheet.class);

    /**
     * ID.
     */
    @Id
    public Long id;

    /**
     * バージョン番号.
     */
    @NotNull
    public Integer version;
    /**
     * 顔写真.
     */
    @NotNull
    @Column(length = 128)
    public String facePicture;
    /**
     * エントリーシート（任意）
     */
    @OneToOne
    @NotNull
    @JoinColumn(name = "entry_sheet_optional")
    public EntrySheetOptionalV1 optional;
    /**
     * エントリーユーザー.
     */
    @OneToOne
    @NotNull
    @JoinColumn(name = "entry_userid")
    public EntryUser entryUser;
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

}
