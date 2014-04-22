package models.conf;

import utils.AppLogUtil;
import base.SaiyoEncryptKeyManager;

import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.event.ServerConfigStartup;

/**
 * Ebeanの振る舞いを制御するクラス
 * @author masafumi
 *
 */
public class SaiyoServerConfigStartUp implements ServerConfigStartup {

    @Override
    public void onStart(ServerConfig config) {
        AppLogUtil.debug("SaiyoServerConfigStartUp#onStart...");
        config.setEncryptKeyManager(new SaiyoEncryptKeyManager());
    }

}
