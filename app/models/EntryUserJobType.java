/**
 * Copyright (C) CyberAgent, Inc. All Rights Reserved.
 */
package models;

import javax.persistence.*;
import javax.validation.constraints.*;

import play.db.ebean.*;

import com.avaje.ebean.annotation.*;

/**
 * エントリーユーザーの職種.
 * @author A13413
 */
@Entity
public class EntryUserJobType extends Model {

    /** シリアルバージョンUID. */
    private static final long serialVersionUID = 2331187907178594970L;
    /** finder. */
    public static Finder<Long, EntryUserJobType> finder = new Finder<Long, EntryUserJobType>(Long.class,
            EntryUserJobType.class);

    /**
     * ID.
     */
    @Id
    public Long id;

    /**
     * -> エントリユーザ.エントリユーザID.
     */
    @ManyToOne
    @JoinColumn(name = "entry_userid")
    @NotNull
    public EntryUser entryUser;
    /**
     * -> 職種.職種ID.
     */
    @ManyToOne
    @JoinColumn(name = "job_typeid")
    @NotNull
    public JobType jobType;

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
