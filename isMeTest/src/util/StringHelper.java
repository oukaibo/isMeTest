package util;

import net.sf.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringHelper {
	
	public static boolean isEmptyStr(String str) {
		return str == null || str.length() == 0 || "null".equals(str);
	}
	
	public static String optString(JSONObject json, String key){
//		if(null==json || isEmptyStr(key)){
//			return null;
//		}
//		if (json.isNullObject() || json.isEmpty()){
//	        return null;
//		}
//		String result = json.optString(key, "");
//		if(isEmptyStr(result)){
//			result = "";
//		}
		// 默认返回空字符串
		return optString(json, key, "");
	}
	
	/**
	 * 
	 * @param json			JSON字符串
	 * @param key			要解析的KEY
	 * @param defaultValue	指定默认值
	 * @return
	 */
	public static float optfloat(JSONObject json, String key, float defaultValue){
		if(null==json || isEmptyStr(key)){
			return 0F;
		}
		if (json.isNullObject() || json.isEmpty()){
	        return 0F;
		}
		String result = json.optString(key, "");
		return floatValue(isEmptyStr(result)?defaultValue+"":result);
	}

	/**
	 * 判断是否是数字
	 * @param str
	 * @return
	 */
	public static Boolean isNumber(String str){
		try {
			 Integer.valueOf(str);
		} catch (Exception e) {
			return false;
		}
		return true;	
	}
	
	/**
	 * 判断是不是float
	 * @param str
	 * @return
	 */
	public static Boolean isFloatNumber(String str){
		try {
			 Float.valueOf(str);
		} catch (Exception e) {
			return false;
		}
		return true;	
	}
	
	/**
	 * 
	 * @param json			JSON字符串
	 * @param key			要解析的KEY
	 * @param defaultValue	指定默认值
	 * @return
	 */
	public static String optString(JSONObject json, String key, String defaultValue){
		if(null==json || isEmptyStr(key)){
			return null;
		}
		if (json.isNullObject() || json.isEmpty()){
	        return null;
		}
		String result = json.optString(key, "");
		if(isEmptyStr(result)){
			result = defaultValue;
		}
		return result;
	}
	
	public static boolean isMobile(String str) {
		if(isEmptyStr(str))
			return false;
		
		return str.matches("^[1][3-8]+\\d{9}");
	}
	
	
	public static boolean isPostCode(String postcode){
		if(isEmptyStr(postcode)){
			return false;
		}
		
		return postcode.matches("[1-9]\\d{5}");
	}

	public static String paddingLeadingZero(long n, int digits) {
		String formatter = String.format("%%0%dd", digits);
		return String.format(formatter, n);
	}
	
	public static String paddingLeadingZero(int n, int digits) {
		String formatter = String.format("%%0%dd", digits);
		return String.format(formatter, n);
	}
	
	public static String tailingLeadingZero(double n, int decimal) {
		String pattern = "#0.";
		
		for (int i = 0; i < decimal; i++) {
			pattern += "0";
		}
		
		DecimalFormat formatter = new DecimalFormat(pattern);
	    return formatter.format(n); 
	}
	
	public static double doubleValue(String str) {
		try{
			return Double.valueOf(str);
		}catch(Exception ex){
			return 0;
		}
	}
	
	public static float floatValue(String str) {
		try{
			return Float.valueOf(str);
		}catch(Exception ex){
			return 0;
		}
	}
	
	public static long longValue(String str) {
		try{
			return Long.parseLong(str);
		}catch(Exception ex){
			return 0;
		}
	}
	
	public static int intValue(String str) {
		try{
			return Integer.parseInt(str);
		}catch(Exception ex){
			return 0;
		}
	}
	
	public static String bytesToHex(byte[] b) {
		char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		StringBuffer buf = new StringBuffer();
		for (int j = 0; j < b.length; j++) {
			buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
			buf.append(hexDigit[b[j] & 0x0f]);
		}
		return buf.toString();
	}
	
	public static String toUtf8String(String str) {
		String result;
		
		try {
			result = str != null ? new String(str.getBytes("ISO-8859-1"), "UTF-8") : str;
		} catch (UnsupportedEncodingException e) {
			result = str;
		}
		
		return result;
	}
	public static String stringFromMap(Map<String,Object> map, String key, String defaultstr){
		if(map==null||!map.containsKey(key))
			return defaultstr;
		String rs= map.get(key)==null?defaultstr:map.get(key).toString();
		return StringHelper.isEmptyStr(rs)?defaultstr:rs;
	}

	public static int intFromMap(Map<String,Object> map,String key,int dft){
		return StringHelper.intValue(stringFromMap(map,key,dft+""));
	}


	public static long longFromMap(Map<String,Object> map,String key,long dft){
		return StringHelper.longValue(stringFromMap(map,key,dft+""));
	}

	public static float floatFromMap(Map<String,Object> map,String key,int dft){
		return StringHelper.floatValue(stringFromMap(map,key,dft+""));
	}
	
	public static double doubleFromMap(Map<String,Object> map,String key,double dft) {
		return StringHelper.doubleValue(stringFromMap(map,key,dft+""));
	}

		/**
	 * 如果为空返回默认值
	 * @param str 传递值
	 * @param defauleStr 返回默认值
	 * @return
	 */
	public static String getDefaultValue(String str,String defauleStr){
		if(isEmptyStr(str)){
			return defauleStr;
		}else{
			return str;
		}
	}

	public static float initFloatValue(String str){
		try{
			return Float.parseFloat(str);
		}catch(Exception ex){
			return 0.00f;
		}
	}
	
	public static int strAppearCount(String srcStr, String findStr) {
		return (srcStr.length()-srcStr.replace(findStr, "").length())/findStr.length();
	}
	
	/**
	 * 把原始字符串分割成指定长度的字符串列表
	 * @Description 把原始字符串分割成指定长度的字符串列表
	 * @return List<String> 
	 * @exception 
	 * @author zb
	 * @date 2020年7月3日
	 * @param inputString 原始字符串
	 * @param length 指定长度
	 * @return
	 */
	public static List<String> getStrList(String inputString, int length) {
        int size = inputString.length() / length;
        if (inputString.length() % length != 0) {
            size += 1;
        }
        return getStrList(inputString, length, size);
    }
	
	/**
	 * 把原始字符串分割成指定长度的字符串列表
	 * @Description 把原始字符串分割成指定长度的字符串列表
	 * @return List<String> 
	 * @exception 
	 * @author zb
	 * @date 2020年7月3日
	 * @param inputString 原始字符串
	 * @param length 指定长度
	 * @param size 指定列表大小
	 * @return
	 */
	public static List<String> getStrList(String inputString, int length,
            int size) {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < size; index++) {
            String childStr = substring(inputString, index * length,
                    (index + 1) * length);
            list.add(childStr);
        }
        return list;
    }
	
	/**
	 * 分割字符串，如果开始位置大于字符串长度，返回空
	 * @Description 分割字符串，如果开始位置大于字符串长度，返回空
	 * @return String 
	 * @exception 
	 * @author zb
	 * @date 2020年7月3日
	 * @param str 原始字符串
	 * @param f 开始位置
	 * @param t 结束位置
	 * @return
	 */
	public static String substring(String str, int f, int t) {
        if (f > str.length())
            return null;
        if (t > str.length()) {
            return str.substring(f, str.length());
        } else {
            return str.substring(f, t);
        }
    }
	
	public static void main(String[] args) {
		String str = "DT008986054VP,DT008986068VP,30";
		List<String> list = getStrList(str, 10);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}