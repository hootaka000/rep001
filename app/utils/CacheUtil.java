package utils;


/**
 * Cache Wrapper
 * @author masafumi
 * ※ もし、Cacheをたてるようなことがあれば、使う想定のRedis-Clientのラッパー
 */
@Deprecated
public class CacheUtil {
	
	//private static Jedis client = new Jedis("localhost");

	private CacheUtil() {}
	
	public static String getValue(String key) {
//		return client.get(key);
	    return null;
	}
	
	public static void putValue(String key, String value) {
//		client.set(key, value);
//		client.expire(key, 30); // key & expires[sec]
	}
	
}
