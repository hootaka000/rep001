package utils;

import play.Logger;
import play.libs.F.Promise;
import play.libs.WS;
import play.libs.WS.Response;


/**
 * @author masafumi
 * FIXME もし、外部システムとRESTでやりとりするようなことがあれば、こいつを整えて使ってください
 */
public class RESTUtil {
	
	private RESTUtil() {}
	
	public static void post(String url, String jsonBody) throws Exception {

	    // こっちの方がいいかも・・・
        Promise<WS.Response> response =
                WS.url(url).setContentType(
                                "application/json; charset=utf8").post(jsonBody);
        
        
        Response res = response.get(6000L);
        Logger.debug(res.getStatusText());
        Logger.debug(res.getBody());
        
	}
	


}
