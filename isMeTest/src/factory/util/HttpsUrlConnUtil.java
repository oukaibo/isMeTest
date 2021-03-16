package factory.util;

import factory.TLSSocketConnectionFactory;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;


public class HttpsUrlConnUtil {

    public HttpURLConnection createConnection(URI uri) throws IOException {
        URL url = uri.toURL();
        URLConnection connection = url.openConnection();
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
        httpsURLConnection.setSSLSocketFactory(new TLSSocketConnectionFactory());
        return httpsURLConnection;
    }

    public static void main(String[] args) {
        String loginUrl = "https://logisticshub-dev.digitalshell.com.cn/api/integration/login";
        JSONObject jObj = new JSONObject();
        // String data = "apiKey=426051afe9fd48ff9fcbc90dd38da9f8&apiSecret=ae9f5bcf8f4d4427a442d32a4688bcf1";
        jObj.put("apiKey", "426051afe9fd48ff9fcbc90dd38da9f8");
        jObj.put("apiSecret", "ae9f5bcf8f4d4427a442d32a4688bcf1");
        String data = jObj.toString();
        String n = httpConPostForTSL(loginUrl, data);
        System.out.println(n);
    }

    public static String httpConPostForTSL(String loginUrl, String data) {
        HttpsUrlConnUtil httpsUrlConnectionMessageSender = new HttpsUrlConnUtil();
        HttpURLConnection connection;
        String json = "";
        try {
            connection = httpsUrlConnectionMessageSender.createConnection(new URI(loginUrl));
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");

            connection.connect();
            //POST请求
            OutputStream os = null;
            os = connection.getOutputStream();
            os.write(data.getBytes(StandardCharsets.UTF_8));
            os.flush();
            json = getResponse(connection);
            System.out.println(json);
            connection.disconnect();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return json;

    }

    public static String getResponse(HttpURLConnection Conn) throws IOException {
        InputStream is;
        if (Conn.getResponseCode() >= 400) {
            is = Conn.getErrorStream();
        } else {
            is = Conn.getInputStream();
        }

        String response = "";
        byte buff[] = new byte[512];
        int b = 0;
        while ((b = is.read(buff, 0, buff.length)) != -1) {
            response += new String(buff, 0, b);
        }
        is.close();

        System.out.println(response);
        return response;
    }
}
