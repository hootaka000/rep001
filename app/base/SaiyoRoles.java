package base;

/**
 * ロール
 * @author masafumi
 */
public enum SaiyoRoles {
    
    HR_ADMIN(1, "人事部特権ユーザ"),
    HR_STAFF(2, "人事部スタッフ"),
    INTERVIER(3, "面接官スタッフ"),
    NEW_GRADUATE(4, "新卒（応募者）"),
    ACCESSIBLE(9999, "(アクセス可能)");
    
    private Integer id;
    private String name;
    
    private SaiyoRoles(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /**
     * ロールIDを取得する
     * @return 
     */
    public Integer getId() {return this.id;}
    
    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    @Deprecated
    public String toString() {return this.name;}
}