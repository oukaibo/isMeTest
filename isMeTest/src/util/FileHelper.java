package util;

import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FileHelper {

	protected static Logger logger = Logger.getLogger(FileHelper.class);

	public static byte[] getFileByte(String filePath, String filename) {
		byte[] bytes = null;

		InputStream is = null;
		ByteArrayOutputStream baos = null;

		try {

			is = new FileInputStream(new File(filePath + filename));
			baos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int read = 0;

			while ((read = is.read(buf)) != -1) {
				baos.write(buf, 0, read);
			}

			bytes = baos.toByteArray();

		} catch (IOException ioe) {
			// do nothing
			logger.error("get file byte error", ioe);
		} finally {
			try {
				if (is != null) {
					is.close();
				}

				if (baos != null) {
					baos.close();
				}
			} catch (IOException ioe) {
				// do nothing
				logger.error("fail to close file stream", ioe);
			}
		}

		return bytes;

	}

	public static byte[] getFileByte(DataHandler dh) {
		byte[] bytes = null;

		InputStream is = null;
		ByteArrayOutputStream baos = null;

		try {

			is = dh.getInputStream();
			baos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int read = 0;

			while ((read = is.read(buf)) != -1) {
				baos.write(buf, 0, read);
			}

			bytes = baos.toByteArray();

		} catch (IOException ioe) {
			// do nothing
			logger.error("get file byte error", ioe);
		} finally {
			try {
				if (is != null) {
					is.close();
				}

				if (baos != null) {
					baos.close();
				}
			} catch (IOException ioe) {
				// do nothing
				logger.error("fail to close file stream", ioe);
			}
		}

		return bytes;

	}

	public static File byte2file(byte[] bytes) {
		File file = null;
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;

		String tempPath = Thread.currentThread().getContextClassLoader()
				.getResource("/temp").getPath();
		try {
			File dir = new File(tempPath);
			if (!dir.exists() && dir.isDirectory()) {
				dir.mkdirs();
			}
			file = new File(tempPath + "\\temp");
			fos = new FileOutputStream(file);

			bos = new BufferedOutputStream(fos);
			bos.write(bytes);

		} catch (Exception e) {

		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (file.isFile() && file.exists()) {
				file.delete();
			}
		}
		return file;
	}
	
	/**
	 * ????????????????????????????????????
	 * @param startPath ?????????????????????
	 * @param endPath ???????????????
	 */
	public static void moveTotherFolders(String startPath,String endPath,boolean isDelete){
	    try {
	        File startFile = new File(startPath);
	        File file = new File(endPath + startFile.getName());
	        File parentFile = file.getParentFile();
	        if(!parentFile.exists()){
	        	parentFile.mkdirs();
	        }
	        if (startFile.renameTo(file)) {
	            logger.info("============ File is moved successful! ============");
	        } else {
	            logger.info("============ File is failed to move! ============");
	        }
	        if(isDelete){
	        	startFile.delete();
	        }
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	}

	/**
	 * ?????????????????????????????????????????????
	 * 
	 * @param ????????????
	 * @param ??????????????????
	 */
	public static void removeFile(String path, String newPath, boolean isDelete) {
		if (StringHelper.isEmptyStr(path) || StringHelper.isEmptyStr(newPath)) {
			return;
		}
		File file = new File(path);
		File file1 = new File(newPath);
		if (!file.exists()) {
			return;
		}
		byte[] b = new byte[(int) file.length()];
		if (file.isFile()) {
			FileInputStream is = null;
			FileOutputStream ps = null;
			try {
				is = new FileInputStream(file);
				ps = new FileOutputStream(file1);
				is.read(b);
				ps.write(b);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (ps != null) {
					try {
						ps.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else if (file.isDirectory()) {
			if (!file1.exists())
				file1.mkdir();
			String[] list = file.list();
			for (int i = 0; i < list.length; i++) {
				removeFile(path + "/" + list[i], newPath + "/" + list[i],
						isDelete);
			}
			if(isDelete){
				delFolder(path);
			}
		}
	}

	/**
	 * ???????????????????????????????????????
	 * @param folderPath
	 */
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // ???????????????????????????
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ????????????????????????????????????????????????
	 * @param path
	 * @return
	 */
	private static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		if(tempList.length == 0){
			file.delete();
		}
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				String paths = path + "/" + tempList[i];
				delAllFile(paths);// ?????????????????????????????????
				delAllFile(paths);//???????????????????????????
				flag = true;
			}
		}
		return flag;
	}
	
    public static String fileToString(File file, String encoding){
        StringBuilder result = new StringBuilder();
        InputStreamReader input = null;
        BufferedReader reader = null;
        try {
            input = new InputStreamReader(new FileInputStream(file), encoding);
            reader = new BufferedReader(input);
            String line = null;
            while((line = reader.readLine()) != null){
                result.append(line + "\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        	if(reader != null){
        		try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	if(input != null){
        		try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        return result.toString();
    }
    
    public static String fileToString(File file){
        StringBuilder result = new StringBuilder();
        InputStreamReader input = null;
        BufferedReader reader = null;
        try {
            input = new InputStreamReader(new FileInputStream(file));
            reader = new BufferedReader(input);
            String line = null;
            while((line = reader.readLine()) != null){
                result.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
        	if(reader != null){
        		try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	if(input != null){
        		try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        return result.toString();
    }
    
    
    public static boolean stringToFile(String content, File file, String encoding){
    	boolean isSuccess = false;
    	OutputStreamWriter output = null;
    	BufferedWriter writer = null;
    	
    	try {
    		if(!file.exists()){
    			File parentFile = file.getParentFile();
    			if(!parentFile.exists()){
    				parentFile.mkdirs();
    			}
    			file.createNewFile();
    		}
			output = new OutputStreamWriter(new FileOutputStream(file), encoding);
			writer = new BufferedWriter(output);
			writer.write(content);
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(writer != null){
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(output != null){
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	
    	return isSuccess;
    }
    

	public static void main(String[] args) {
//		removeFile("D:\\FTPServer\\KOMS_EDI\\avon_error",
//				"D:\\FTPServer\\KOMS_EDI\\avon_error_history", true);
//		//delAllFile("D:\\FTPServer\\KOMS_EDI\\avon_error\\");
//		System.out.println("=======");
		File file = new File("D:\\KOMS_EDI\\AVON\\2017\\11\\haha.csv");
		boolean flag = FileHelper.stringToFile("??????", file, "UTF-8");
		System.out.println(flag);
	}

	/**
	 * ??????????????????
	 * @param dateStr
	 * @return
	 */
	public static String mkDir(String dateStr) {
		if (!StringHelper.isEmptyStr(dateStr)) {
			try {
				Date date = DateHelper.parseDate(dateStr, "yyyyMMdd");
				String year = DateHelper.formatDate(date, "yyyy");
				String month = DateHelper.formatDate(date, "MM");
				String day = DateHelper.formatDate(date, "dd");
				String dir = year + "/" + month + "/" + day;
				return dir;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			Calendar calendar = Calendar.getInstance();
			String dir = calendar.get(Calendar.YEAR) + "/" + String.format("%02d", (calendar.get(Calendar.MONTH) + 1))
					+ "/" + String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
			return dir;
		}
		return dateStr;
	}
	
	public static String createFile(String path) {
		File file = new File(path);
		if(file.exists()){
			return path;			
		}
		
		if(file.isDirectory()){
			if(file.mkdirs())
				return path;
		}
		
		String[] paths = path.split("/");
		StringBuffer fullPath = new StringBuffer();
		for (int i = 0; i < paths.length; i++) {
			fullPath.append(paths[i]).append(File.separator);
			File newfile = new File(fullPath.toString());
			if (!newfile.exists()) {
				newfile.mkdir();
			}
		}
		return path;
	}

	public static List<String> readLineByFile(File f){
		List<String> list = new ArrayList<String>();
		BufferedReader br = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		try{
			fis = new FileInputStream(f);
			UnicodeReader ur = new UnicodeReader(fis, "utf-8");
			br = new BufferedReader(ur);//????????????BufferedReader??????????????????
	        String s = null;
	        while((s = br.readLine())!=null){//??????readLine????????????????????????
	        	list.add(s);
	        }
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(isr != null){
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
