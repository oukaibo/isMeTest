package testmain;

import com.kerrier.koms.edi.common.util.HttpUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

public class shellTest {
	protected static Logger logger = Logger.getLogger(shellTest.class);

	public static void main(String []args){
		// 请求接口
//		try {
//			String url="https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=17608475497";
//			String result = HttpUtilTest.httpGetTest(url);
////			String result=HttpUtil.httpPostInHeaderAndBody(url);
//		    System.out.println(result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		String url = "https://logisticshub-dev.digitalshell.com.cn/api/integration/login";
		JSONObject jObj = new JSONObject();
		jObj.put("apiKey", "426051afe9fd48ff9fcbc90dd38da9f8");
		jObj.put("apiSecret", "ae9f5bcf8f4d4427a442d32a4688bcf1");
		String data = jObj.toString();
		String result = "";
		try {
			logger.info("ShellApiUtil login request==>"+data);
			result = HttpUtil.httpPostInHeaderAndBody(url, data, null);
			logger.info("ShellApiUtil login response==>"+result);
		} catch (Exception e) {
			logger.error("ShellApiUtil login http error");
			e.printStackTrace();
		}
	}

}
