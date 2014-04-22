/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package models;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import play.db.ebean.*;

import com.avaje.ebean.annotation.*;

/**
 * 経歴.
 * @author A13413
 */
public class Career extends Model {

    /** シリアルバージョンUID. */
    private static final long serialVersionUID = -709269859575525770L;

    /** finder. */
    public static Finder<Long, Career> finder = new Finder<Long, Career>(Long.class, Career.class);

    /**
     * ID.
     */
    @Id
    public Long id;

    /**
     * エントリーシート.
     */
    @OneToOne
    @JoinColumn(name = "entry_sheetid")
    @NotNull
    public EntrySheet entrySheet;
    /**
     * 入学・入社年月
     */
    @NotNull
    public Date joinDate;
    /**
     * 卒業・退社年月
     */
    @NotNull
    public Date resignationDate;
    /**
     * 経歴名.
     */
    @NotNull
    @Encrypted(dbEncryption = true, dbLength = 512)
    public String name;
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
