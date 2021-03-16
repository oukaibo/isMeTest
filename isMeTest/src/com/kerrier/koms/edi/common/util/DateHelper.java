package com.kerrier.koms.edi.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.SystemConstants;
import util.StringHelper;

public class DateHelper {
	
	
	public static boolean isBeforeNow(String dateStr,String format){
		try{
			SimpleDateFormat sf = new SimpleDateFormat(format);
			Date date=sf.parse(dateStr);
			Date now=new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(now);
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			int a=c.getTime().compareTo(date);
			
			return a>0;
		}catch (Exception e) {
			
		}
		return false;
	}
	
	public static boolean isDateByStr(String dateStr,String format){
		
		try{
			if (!StringHelper.isEmptyStr(dateStr)) {
		        SimpleDateFormat sdf = new SimpleDateFormat(format); 
		        if (dateStr.equals(sdf.format(sdf.parse(dateStr)))) {  
		        	return true;
		        }
			}
		}catch (Exception e) {
			
		}
		return false;
	}
	
	public static boolean isDate(String dateStr,String format){
		try{
			if (!StringHelper.isEmptyStr(dateStr)) {
				SimpleDateFormat sf = new SimpleDateFormat(format);
				Date date=sf.parse(dateStr);
				if(date!=null)
					return true;
			}
		}catch (Exception e) {
			
		}
		return false;
	}
	
	public static String addDayToTime(Date date,int day){
		Date now = null;
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, day);
			now = c.getTime();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return DateHelper.formatDate(now, SystemConstants.SYSTEM_DATETIME_FORMAT);
	}
	


	public static String formatDate(Date date, String format) {
		try{
		    if (date != null) {
                SimpleDateFormat sf = new SimpleDateFormat(format);
                return sf.format(date);
            } 
		}catch(Exception ex){
			
		} 
		return null;
	}
	
	public static Date parseDate(String dateStr, String format) throws ParseException {
		if (!StringHelper.isEmptyStr(dateStr)) {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			return sf.parse(dateStr);
		}
		return null;
	}
	
	public static Date parseDate3(String dateStr, String format) {
		if (!StringHelper.isEmptyStr(dateStr)) {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			try {
				return sf.parse(dateStr);
			} catch (ParseException e) { 
				return null;
			}
		} 
		return null;
	}
	
	public static Date parseDate2(String dateStr, String format) {
		if (!StringHelper.isEmptyStr(dateStr)) {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			try {
				return sf.parse(dateStr);
			} catch (ParseException e) { 
			}
		} 
		return new Date();
	}
	
	public static String formatDateString(String dateStr, String currentFormat, String newFormat) throws ParseException {
		Date date = DateHelper.parseDate(dateStr, currentFormat);
		String formattedDateStr = DateHelper.formatDate(date, newFormat); 
		return formattedDateStr;
	}
	/**
	 * 
	 * 解析时间,返回默认值
	 *
	 * @date 2018年3月9日
	 * @author ZSL_Admin
	 * @param dateStr
	 * @param format
	 * @param deft
	 * @return 
	 * @see
	 */
	public static Date optParseDate(String dateStr, String format,Date deft) {
        if (!StringHelper.isEmptyStr(dateStr)) {
            SimpleDateFormat sf = new SimpleDateFormat(format);
            try
            {
                return sf.parse(dateStr);
            }
            catch (ParseException e)
            {
               return deft;
            }
        }
        return deft;
    }
	 public static String nowDateStr(String format) {
	     return DateHelper.formatDate(new Date(),format);
	 }
	
    public static String formatDateString(String dateStr, String[] currentFormat, String newFormat) {
        if(currentFormat==null||currentFormat.length==0)
            return null;
        if(StringHelper.isEmptyStr(dateStr))
            return null;
        Date date =null;
        for(String f:currentFormat){
            date=optParseDate(dateStr,f,null);
            if(date!=null)
                return DateHelper.formatDate(date, newFormat);
        }
        return null; 
     }	
	
	/**
	 * 比较时间
	 * @Description 0=相等，1=date1大，-1=date1小
	 * @return int 
	 */
	public static int compareDate(Date date1, Date date2) {
		if (date1.getTime() > date2.getTime()) {
			return 1;
		} else if (date1.getTime() < date2.getTime()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public static String addDayOnDate(String dateStr,int day){
		Date date=null;
		try{
			date=DateHelper.parseDate(dateStr, SystemConstants.SYSTEM_DATE_FORMAT);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, day);
			date = c.getTime();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return DateHelper.formatDate(date, SystemConstants.SYSTEM_DATETIME_FORMAT);
	}
	
	public static String addDayOnDate(int day){
		Date date =null;
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(new Date(System.currentTimeMillis()));
			c.add(Calendar.DATE, day);
			date = c.getTime();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return DateHelper.formatDate(date, SystemConstants.SYSTEM_DATETIME_FORMAT);
	}
	
	public static String addDayOnDate(Date date, int day){
		Date result =null;
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, day);
			result = c.getTime();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return DateHelper.formatDate(result, SystemConstants.SYSTEM_DATETIME_FORMAT);
	}
	
	public static Date addDayOnDate(int day, Date date){
		Date result =null;
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, day);
			result = c.getTime();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return result;
	}
	
	public static String addDayOnDate(int day,String dateFormat){
		Date date =null;
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(new Date(System.currentTimeMillis()));
			c.add(Calendar.DATE, day);
			date = c.getTime();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return DateHelper.formatDate(date, dateFormat);
	}
	
	public static Date addHourOnDate(Date date, int hour){
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.HOUR, hour);
			date = c.getTime();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return date;
	}
	
	private final static SimpleDateFormat longHourSdf = new SimpleDateFormat(SystemConstants.SYSTEM_DATETIME_FORMAT_3);
	public static String addHourOnDate(Date date, int hour, String dateFormat) {
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.HOUR_OF_DAY, hour);
			date = c.getTime();
			date = longHourSdf.parse(longHourSdf.format(date));
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return DateHelper.formatDate(date, dateFormat);
	}
	public static String addHour(Date date, int hour) {
		return addHourOnDate(date, hour, SystemConstants.SYSTEM_DATETIME_FORMAT);
	}
	public static String getHour(Date date) {
		try {
			date = longHourSdf.parse(longHourSdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return DateHelper.formatDate(date, SystemConstants.SYSTEM_DATETIME_FORMAT);
	}
	public static int getNowHour(Date date) {
		int h = 0;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		h = c.get(Calendar.HOUR_OF_DAY);
		return h;
	}
	
	public static Date addMinuteOnDate(Date date, int minute){
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.MINUTE, minute);
			date = c.getTime();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return date;
	}
	
	public static Date addSecondOnDate(Date date, int second){
		try{
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.SECOND, second);
			date = c.getTime();
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return date;
	}
	
	public static Date getNoonOfDay() {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
		cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
		
		return cal.getTime();
	}
	
	public static int gapDate(Date start, Date end,int interval) {
		
		if (start == null) {
			start = new Date();
		}
		if(end == null){
			end = new Date();
		}
		int result = 0;
		try{
			result = compareDate(end,addHourOnDate(start,interval));
		}catch (Exception e){
			
		}
		return result;
	}
	
	public static long date2Millisecond(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		long milliseconds = 0;
		try {
			milliseconds = format.parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return milliseconds;
	}
	
	public static long date2Millisecond2(String date) {
		SimpleDateFormat format = new SimpleDateFormat(SystemConstants.SYSTEM_DATETIME_FORMAT);
		long milliseconds = 0;
		try {
			milliseconds = format.parse(date).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return milliseconds;
	}
	
	public static String millisecond2Date(long milliseconds) {
		Date date = new Date(milliseconds);
		SimpleDateFormat format = new SimpleDateFormat(SystemConstants.SYSTEM_DATETIME_FORMAT);
		return format.format(date);
	}
	
	/**
	 * 日期是否有效
	 * @param date
	 * @return
	 */
	public static boolean invalidDate(String date){
		try {
			Date d = DateHelper.parseDate(date, SystemConstants.SYSTEM_DATETIME_FORMAT);
			Calendar cl = Calendar.getInstance();
			cl.setTime(d);
			long time = cl.getTimeInMillis();
			if(time>=0){
				return true;
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return false;
	}
	
	public static int compareToNow(String dateStr,String format){
		try{
			SimpleDateFormat sf = new SimpleDateFormat(format);
			Date date=sf.parse(dateStr);
			Date now=new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(now);
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			int a=c.getTime().compareTo(date);
			return a;
		}catch (Exception e) {
			
		}
		return -1;
	}
	
	public static int calculateHours(Date from, Date to) {
	    long from2 = from.getTime();
	    long to2 = to.getTime();
	    int hours = (int) ((to2 - from2) / (1000 * 60 * 60));
	    return hours;
	}
	
	public static int compareDate(String date1,String date2,String format) {
		try{
			Date d1 = DateHelper.parseDate2(date1, format);
			Date d2 = DateHelper.parseDate2(date2, format);  
			return compareDate(d1,d2);
		}catch(Exception ex){
			ex.printStackTrace();  
		}  
		return -1;
	}
	
	public static Date getDate(int hour, int minute) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
		return cal.getTime();
	}
	
	public static Date getDate(int hour, int minute, int second, int millisecond) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, millisecond);
		return cal.getTime();
	}
	
	public static boolean isBetween2Date(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}
