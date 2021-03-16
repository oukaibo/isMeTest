package com.kerrier.koms.edi.common.util;

import static org.apache.commons.httpclient.params.HttpMethodParams.SO_TIMEOUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;

import com.kerrier.koms.edi.api.util.Xml2JsonUtil;
import util.StringHelper;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpUtil {
	protected static Logger logger = Logger.getLogger(HttpUtil.class);
	private static final String HTTP_CONTENT_CHARSET = "utf-8";
	public static final Integer MAX_TIME_OUT = 5000;
	public static final Integer MAX_SO_TIME_OUT = 180000;
	public static final Integer MAX_IDLE_TIME_OUT = 60000;
	public static final Integer MAX_CONN = 100;
	public static HttpClient httpClient = null;

	static {
		
		MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
		connectionManager.closeIdleConnections(MAX_IDLE_TIME_OUT);
		connectionManager.getParams().setParameter("http.connection-manager.max-total", MAX_CONN);
		httpClient = new HttpClient(connectionManager);
		httpClient.getParams().setParameter(SO_TIMEOUT, MAX_TIME_OUT);
//		httpClient.getParams().setParameter("http.connection.timeout", MAX_TIME_OUT);
		httpClient.getParams().setParameter("http.connection-manager.timeout", MAX_TIME_OUT.longValue());
	}

	public static String sendPostRequest(String url, Map<String, Object> param) {
		PostMethod post = new PostMethod(url);
		post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, HTTP_CONTENT_CHARSET);
		if (param != null) {
			for (Entry<String, Object> entry : param.entrySet()) {
				if (entry.getValue() != null) {
					post.addParameter(entry.getKey(), entry.getValue().toString());
				}
			}
		}
		try {
			post.addRequestHeader(new Header("Connection", "close"));
			httpClient.executeMethod(post);
			if (post.getStatusCode() == HttpStatus.SC_OK) {
				return post.getResponseBodyAsString();
			} else {
				post.abort();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			post.releaseConnection();
		}
		return null;
	}
	
	public static String sendGetRequest(String url) {
		GetMethod get = new GetMethod(url);
		get.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, HTTP_CONTENT_CHARSET);
		try {
			get.addRequestHeader(new Header("Connection", "close"));
			httpClient.executeMethod(get);
			if (get.getStatusCode() == HttpStatus.SC_OK) {
				return get.getResponseBodyAsString();
			} else {
				get.abort();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			get.releaseConnection();
		}
		return null;
	}

	public static String sendPutRequest(String url) {
		PutMethod put = new PutMethod(url);
		put.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, HTTP_CONTENT_CHARSET);
		try {
			put.addRequestHeader(new Header("Connection", "close"));
			httpClient.executeMethod(put);
			if (put.getStatusCode() == HttpStatus.SC_OK) {
				return put.getResponseBodyAsString();
			} else {
				put.abort();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			put.releaseConnection();
		}
		return null;
	}
	
	public static String sendDeleteRequest(String url) {
		DeleteMethod delete = new DeleteMethod(url);
		delete.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, HTTP_CONTENT_CHARSET);
		try {
			delete.addRequestHeader(new Header("Connection", "close"));
			httpClient.executeMethod(delete);
			if (delete.getStatusCode() == HttpStatus.SC_OK) {
				return delete.getResponseBodyAsString();
			} else {
				delete.abort();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			delete.releaseConnection();
		}
		return null;
	}
	

	public static String httpGet(String url, Map<String, Object>  data) throws Exception {
		HttpClient client = new HttpClient(new SimpleHttpConnectionManager(true));
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, MAX_SO_TIME_OUT);
		client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, MAX_TIME_OUT);
		StringBuffer result = null;
		InputStream is = null;
		GetMethod getMethod = null;
		BufferedReader br = null;
		Reader r = null;
		try {
			if(data!=null&&data.size()>0){
				int i=url.indexOf("?");
				for (Entry<String, Object> entry : data.entrySet()) {
					if(i==-1){
						url+="?"+entry.getKey()+"="+ java.net.URLEncoder.encode(entry.getValue().toString(),"utf-8");
					}
					else{
						url+="&"+entry.getKey()+"="+ java.net.URLEncoder.encode(entry.getValue().toString(),"utf-8");
					}
					i++;
				}
			}
			
			getMethod = new GetMethod(url);
			getMethod.setRequestHeader("Accept", MediaType.ALL_VALUE);
			getMethod.getParams().setContentCharset("utf-8");
			getMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
			client.executeMethod(getMethod);
			result = new StringBuffer();
			is = getMethod.getResponseBodyAsStream();
			r = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(r);
			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
		} finally {
			if(null!=br){
				br.close();
			}
			if(null!=r){
				r.close();
			}
			if(null!=is){
				is.close();
			}
			if(null!=getMethod){
				getMethod.releaseConnection();
			}
		}
		return result==null?null:result.toString();
	}
	
	@SuppressWarnings("unchecked")
	public static String httpPost(String url, Map<String, Object> data) throws Exception {
		HttpClient client = new HttpClient(new SimpleHttpConnectionManager(true));
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, MAX_SO_TIME_OUT);
		client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, MAX_TIME_OUT);
		PostMethod postMethod = null;
		StringBuffer result = null;
		InputStream is = null;
		BufferedReader br = null;
		Reader r = null;
		try {
			/*HttpConnectionManagerParams managerParams = client.getHttpConnectionManager().getParams();
			 // 设置连接超时时间(单位毫秒) 
			 managerParams.setConnectionTimeout(60000); 
			 // 设置读数据超时时间(单位毫秒) 
			 managerParams.setSoTimeout(120000);*/ 
			long t1=System.currentTimeMillis();
			List<NameValuePair> pair=new ArrayList<NameValuePair>();
			for (Entry<String, Object> entry : data.entrySet()) {
				Object obj=entry.getValue();
				if(obj!=null){
					String key=entry.getKey();
					if(obj instanceof List){
						List<String> objs=(List<String>)obj;
						for(String val:objs){
							pair.add(new NameValuePair(key,val.toString()));
						}
					}
					else{
						pair.add(new NameValuePair(key,obj.toString()));
					}
				}
			}
			NameValuePair[] ps=new NameValuePair[pair.size()];
			pair.toArray(ps);
			
			postMethod = new PostMethod(url);
			postMethod.setRequestHeader("Accept", MediaType.ALL_VALUE);
			postMethod.setRequestBody(ps);
			postMethod.getParams().setContentCharset("utf-8");
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			client.executeMethod(postMethod);
			result = new StringBuffer();
			is = postMethod.getResponseBodyAsStream();
			r = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(r);
			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			long t2=System.currentTimeMillis();
			logger.info("request time:"+url+"\t"+(t2-t1)+"ms");
		} finally {
			if(null!=br){
				br.close();
			}
			if(null!=r){
				r.close();
			}
			if(null!=is){
				is.close();
			}
			if(postMethod != null){
				postMethod.releaseConnection();
			}
		}
		return result.toString();
	}

	public static String httpPostInBody(String url,String data) throws IOException{
		HttpClient client = new HttpClient(new SimpleHttpConnectionManager(true));
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, MAX_SO_TIME_OUT);
		client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, MAX_TIME_OUT);
		PostMethod postMethod = null;
		StringBuffer result = null;
		InputStream is = null;
		BufferedReader br = null;
		Reader r = null;
		try{
			postMethod = new PostMethod(url);
			postMethod.setRequestHeader("Content-Type", MediaType.APPLICATION_XML_VALUE);
			StringRequestEntity sre = new StringRequestEntity(data, null, "utf-8");
			postMethod.setRequestEntity(sre);
			postMethod.getParams().setContentCharset("utf-8");
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			client.executeMethod(postMethod);
			result = new StringBuffer();
			is = postMethod.getResponseBodyAsStream();
			r = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(r);
			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				br.close();
			}
			if(r != null){
				r.close();
			}
			if(is != null){
				is.close();
			}
			if(postMethod != null){
				postMethod.releaseConnection();
			}
		}
		return result.toString();
	}
	
	public static String httpPostInHeaderAndBody(String url,String data, Map<String, String> headerMap) throws IOException{
		HttpClient client = new HttpClient(new SimpleHttpConnectionManager(true));
		client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 180000);
		PostMethod postMethod = null;
		StringBuffer result = null;
		InputStream is = null;
		BufferedReader br = null;
		Reader r = null;
		try{
			postMethod = new PostMethod(url);
			postMethod.setRequestHeader("Content-type", MediaType.APPLICATION_JSON_VALUE);
			if(headerMap != null && !headerMap.isEmpty()){
				for(String key : headerMap.keySet()){
					postMethod.addRequestHeader(new Header(key, headerMap.get(key)));
				}
			}
			if(!StringHelper.isEmptyStr(data)){
				StringRequestEntity sre = new StringRequestEntity(data, null, "utf-8");
				postMethod.setRequestEntity(sre);
			}
			postMethod.getParams().setContentCharset("utf-8");
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 180000);
			client.executeMethod(postMethod);
			result = new StringBuffer();
			is = postMethod.getResponseBodyAsStream();
			r = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(r);
			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
		}catch(HttpException e){
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null){
				br.close();
			}
			if(r != null){
				r.close();
			}
			if(is != null){
				is.close();
			}
			if(postMethod != null){
				postMethod.releaseConnection();
			}
		}
		return result.toString();
	}

	private static TrustManager myX509TrustManager = new X509TrustManager() {
		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1)
				throws java.security.cert.CertificateException {
			// TODO Auto-generated method stub

		}
		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1)
				throws java.security.cert.CertificateException {
			// TODO Auto-generated method stub

		}
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	public static String httpPostInHeaderAndBodyForTSL(String url,String data, Map<String, String> headerMap) throws IOException{

		HttpClient client = new HttpClient(new SimpleHttpConnectionManager(true));
		client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 180000);
		PostMethod postMethod = null;
		StringBuffer result = null;
		InputStream is = null;
		BufferedReader br = null;
		Reader r = null;
		try{
			postMethod = new PostMethod(url);
			postMethod.setRequestHeader("Content-type", MediaType.APPLICATION_JSON_VALUE);
			if(headerMap != null && !headerMap.isEmpty()){
				for(String key : headerMap.keySet()){
					postMethod.addRequestHeader(new Header(key, headerMap.get(key)));
				}
			}
			if(!StringHelper.isEmptyStr(data)){
				StringRequestEntity sre = new StringRequestEntity(data, null, "utf-8");
				postMethod.setRequestEntity(sre);
			}
			postMethod.getParams().setContentCharset("utf-8");
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 180000);
			client.executeMethod(postMethod);
			result = new StringBuffer();
			is = postMethod.getResponseBodyAsStream();
			r = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(r);
			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
		}catch(HttpException e){
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null){
				br.close();
			}
			if(r != null){
				r.close();
			}
			if(is != null){
				is.close();
			}
			if(postMethod != null){
				postMethod.releaseConnection();
			}
		}
		return result.toString();
	}

	public static String post(String url, String data, String contentType,String userName,String passWord) throws Exception {
		StringBuffer buffer = new StringBuffer();
		URL getUrl = new URL(url);
		HttpURLConnection connection = (HttpURLConnection)getUrl.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", contentType);
		connection.setRequestProperty("Connection", "Keep-Alive"); 
		connection.setUseCaches(false); 
		connection.setConnectTimeout(10000);
		connection.setReadTimeout(60000); 
		//connection.setRequestProperty("Accept", "application/xml");
		//connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		//if(userName!=null&&passWord!=null){
			//String input = userName + ":" + passWord;
			//String encoding = new sun.misc.BASE64Encoder().encode(input.getBytes());
			//connection.setRequestProperty("Authorization", "Basic " + encoding);
		//}
		connection.connect();
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
		out.write(data);
		out.flush();
		out.close();
		int rcode = connection.getResponseCode();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
		String line = "";
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		reader.close();
		connection.disconnect();
		return buffer.toString();
		
	}
	public static String httpPostXml(String url,String data,String contentType,String soapActionUrl) throws IOException{
		HttpClient client = new HttpClient(new SimpleHttpConnectionManager(true));
		PostMethod postMethod = null;
		StringBuffer result = null;
		InputStream is = null;
		BufferedReader br = null;
		Reader r = null;
		try{
			postMethod = new PostMethod(url);
			postMethod.setRequestHeader("SOAPAction",soapActionUrl);
			postMethod.setRequestHeader("Content-Type", contentType);
			StringRequestEntity sre = new StringRequestEntity(data, null, "utf-8");
			postMethod.setRequestEntity(sre);
			postMethod.getParams().setContentCharset("utf-8");
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, MAX_TIME_OUT);
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, MAX_SO_TIME_OUT);
			client.getParams().setParameter("http.connection-manager.timeout", MAX_TIME_OUT.longValue());
			client.executeMethod(postMethod);
			result = new StringBuffer();
			is = postMethod.getResponseBodyAsStream();
			r = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(r);
			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				br.close();
			}
			if(r != null){
				r.close();
			}
			if(is != null){
				is.close();
			}
			postMethod.releaseConnection();
		}
		return result.toString();
	}

	/**
	 * 访问KWMS2.0通用
	 * @param url 路径
	 * @param obj
	 * @param type
	 * @param temCreateOrGetElement
	 * @param temElement
	 * @param contentType "text/xml;charset=utf-8"
	 * @param soapActionUrl
	 * @return
	 * @throws Exception
	 */
	public static <T> T httpPostXML(String url,Object obj,Class<T> type,String temCreateOrGetElement,String temElement,String contentType,String soapActionUrl) throws Exception{
		if(obj==null)return null;
		String xml= Xml2JsonUtil.toXml(obj);
		if(xml==null)return null;
		String data="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">"
				  + "  <soapenv:Header/>"
				  + "  <soapenv:Body>"
				  + "     <tem:"+temCreateOrGetElement+">"
				  + "       <!--Optional:-->"
				  + "       <tem:"+temElement+"><![CDATA["+xml+"]]></tem:"+temElement+">"
				  + "     </tem:"+temCreateOrGetElement+">"
				  + "  </soapenv:Body>"
				  + "</soapenv:Envelope>";
		String response=httpPostXml(url, data, contentType,soapActionUrl);
		if(!StringHelper.isEmptyStr(response)){	
			response=SoapUtil.formatSoapString(response);
			if(!StringHelper.isEmptyStr(response)){
				return Xml2JsonUtil.fromXml(response,true, type);
			}	
		}
		return null;
	}
	
	public static String httpPostInBody(String url,String data,Map<String, String> headerMap) throws IOException{
		HttpClient client = new HttpClient(new SimpleHttpConnectionManager(true));
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 1200000);
		client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 600000);
		PostMethod postMethod = null;
		StringBuffer result = null;
		InputStream is = null;
		BufferedReader br = null;
		Reader r = null;
		try{
			long t1=System.currentTimeMillis();
			postMethod = new PostMethod(url); 
			postMethod.addRequestHeader("Connection", "Keep-Alive");
			//postMethod.addRequestHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			//postMethod.addRequestHeader("x-forwarded-for","180.173.164.85");//壳牌ip白名单
			if(headerMap != null && !headerMap.isEmpty()){
				for(String key : headerMap.keySet()){
					postMethod.addRequestHeader(new Header(key, headerMap.get(key)));
				}
			}
			StringRequestEntity sre = new StringRequestEntity(data, null, "utf-8");
			postMethod.setRequestEntity(sre);
			postMethod.getParams().setContentCharset("utf-8");
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			client.executeMethod(postMethod);
			result = new StringBuffer();
			is = postMethod.getResponseBodyAsStream();
			r = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(r);
			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			long t2=System.currentTimeMillis();
			logger.info("request time:"+url+"\t"+(t2-t1)+"ms");
			return result.toString();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				br.close();
			}
			if(r != null){
				r.close();
			}
			if(is != null){
				is.close();
			}
			postMethod.releaseConnection();
		}
		return null;
	}
	
	public static String httpDeleteInHeader(String url, Map<String, String> headerMap) throws IOException {
		HttpClient client = new HttpClient(new SimpleHttpConnectionManager(true));
		client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 180000);
		DeleteMethod delMethod = null;
		StringBuffer result = null;
		InputStream is = null;
		BufferedReader br = null;
		Reader r = null;
		try{
			delMethod = new DeleteMethod(url);
			if(headerMap != null && !headerMap.isEmpty()){
				for(String key : headerMap.keySet()){
					delMethod.addRequestHeader(new Header(key, headerMap.get(key)));
				}
			}
			delMethod.getParams().setContentCharset("utf-8");
			delMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
			delMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 180000);
			client.executeMethod(delMethod);
			result = new StringBuffer();
			is = delMethod.getResponseBodyAsStream();
			r = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(r);
			String line = "";
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
		}catch(HttpException e){
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null){
				br.close();
			}
			if(r != null){
				r.close();
			}
			if(is != null){
				is.close();
			}
			if(delMethod != null){
				delMethod.releaseConnection();
			}
		}
		return result.toString();
	}
}
