package util;

import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.io.StreamUtils;
import org.milyn.payload.JavaResult;

import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;

public class EDICommonUtil {
	private static final String EDI204 = null;
	private static byte[] messageIn;
	private static Smooks smooks;

	protected static JavaResult runSmooksTransform(ExecutionContext executionContext) {
		try {
			Locale defaultLocale = Locale.getDefault();
			Locale.setDefault(new Locale("en", "IE"));
			JavaResult javaResult = new JavaResult();
			// Filter the input message to the outputWriter, using the execution
			// context...
			smooks.filterSource(executionContext, new StreamSource(new ByteArrayInputStream(messageIn)), javaResult);
			Locale.setDefault(defaultLocale);
			return javaResult;
		} finally {
			smooks.close();
		}
	}
	
	public static void test(Object obj) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Class<? extends Object> cla = obj.getClass();
		Field[] fieldArr = cla.getDeclaredFields();
		for(Field f : fieldArr){
			f.setAccessible(true);
			Field field = cla.getDeclaredField(f.getName());
			field.setAccessible(true);
			Object object = field.get(obj);
			if(object instanceof List){
				for(Object ob1 : (List)object){
					test(ob1);
				}
			}else if(object instanceof String){
				System.out.println(field.getName()+":"+field.get(obj));
			}else if(object instanceof Long){
				System.out.println(field.getName()+":"+field.get(obj));
			}
			else if(object instanceof Integer){
				System.out.println(field.getName()+":"+field.get(obj));
			}
			else if(object instanceof Double){
				System.out.println(field.getName()+":"+field.get(obj));
			}
			else if(object instanceof Float){
				System.out.println(field.getName()+":"+field.get(obj));
			}
			else if(object instanceof Object){
				test(object);
			}
		}
	}

	public static void main(String[] args) {
		JavaResult obj = analysisEDI214(new File("C:\\Users\\chen\\Desktop\\KERD_204.0503.2256553776671"), "edixml/smooks-204-config.xml");
		try {
			test(obj.getBean("edi204"));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static JavaResult analysisEDI214(File ediFile,String xmlConfig) {

		if (ediFile != null) {
			
			if (ediFile.exists()) {
				try {
					messageIn = changeInputMessage(ediFile); // 将214文件转码
					smooks = new Smooks(xmlConfig);
					ExecutionContext executionContext = smooks.createExecutionContext();
					JavaResult result = runSmooksTransform(executionContext);
					return result;
				} catch (Exception e) {
					System.out.println("========analysisEDI214=========Exception:"+e.getMessage());
					e.printStackTrace();
				}
			}
			return null;
		}
		return null;
	}

	private static byte[] readInputMessage(File ediFile) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(ediFile);
			return StreamUtils.readStream(fis);
		} catch (IOException e) {
			e.printStackTrace();
			return "<no-message/>".getBytes();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static String file2String(File file, String encoding) {
		InputStreamReader reader = null;
		StringWriter writer = new StringWriter();
		try {
			if (encoding != null && !"".equals(encoding.trim())) {
				reader = new InputStreamReader(new FileInputStream(file), encoding);
			} else {
				reader = new InputStreamReader(new FileInputStream(file));
			}
			// 将输入流写入输出流
			char[] buffer = new char[1024];
			int n = 0;
			while (-1 != (n = reader.read(buffer))) {
				writer.write(buffer, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null && writer != null) {
				try {
					reader.close();
					writer.close();
					return writer.toString();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public static byte[] stringToAscii(File file) { // 字符串转换为ASCII码
		String s = file2String(file, "");
		char[] chars = s.toCharArray();
		String ss = "";
		for (int i = 0; i < chars.length; i++) {
			if ((int) chars[i] == 30) {
				chars[i] = 42;
				ss += chars[i];
			} else if ((int) chars[i] == 29) {
				chars[i] = 62;
				ss += chars[i];
			} else {
				ss += chars[i];
			}
		}
		return ss.getBytes();
	}

	private static byte[] changeInputMessage(File file) {
		try {
			return stringToAscii(file);
		} catch (Exception e) {
			e.printStackTrace();
			return "<no-message/>".getBytes();
		}
	}
	
	/**
	 * 
	　* @Description aos945解析报文
	　* @return JavaResult 
	　* @exception 
	　* @author zj
	　* @date 2019年5月8日
	　* @param ediFile
	　* @param xmlConfig
	　* @return
	　
	 */
	public static JavaResult analysisAosEDI214(File ediFile,String xmlConfig) {

		if (ediFile != null) {
			
			if (ediFile.exists()) {
				try {
					messageIn =readInputMessage(ediFile);
					smooks = new Smooks(xmlConfig);
					ExecutionContext executionContext = smooks.createExecutionContext();
					JavaResult result = runSmooksTransform(executionContext);
					return result;
				} catch (Exception e) {
					System.out.println("========analysisEDI214=========Exception:"+e.getMessage());
					e.printStackTrace();
				}
			}
			return null;
		}
		return null;
	}
}
