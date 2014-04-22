package base;

import com.avaje.ebean.config.EncryptKey;
import com.avaje.ebean.config.EncryptKeyManager;

/**
 * DBで暗号化するキーを管理するクラス
 * @author masafumi
 */
public class SaiyoEncryptKeyManager implements EncryptKeyManager {
    
    private String key = null;

    @Override
    public EncryptKey getEncryptKey(String tableName, String columnName) {
        EncryptKey k = new EncryptKey() {
            @Override
            public String getStringValue() {
                return SaiyoEncryptKeyManager.this.key;
            }
        };
        return k;
    }

    @Override
    public void initialise() {
        this.key = play.Play.application().configuration().getString("saiyo.db.cryptkey");
    }

}
