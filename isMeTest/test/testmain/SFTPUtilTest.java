package testmain;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import model.SystemConstants;
import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.kerrier.koms.edi.common.util.DateHelper;
import util.StringHelper;

public class SFTPUtilTest {

	private static String apple_host; // sftp的IP
	private static String apple_userName; // sftp用户名
	private static String apple_passWord; // sftp密码
	private static String apple_privateKey; // sftp密钥
	//private static String apple_passPhrase; // sftp密钥密码
	private static int apple_port; // sftp端口
	
	private static Logger logger = Logger.getLogger(SFTPUtilTest.class);
    /**
     * 连接服务器
     * @param host
     * @param userName
     * @param privateKey
     * @param passWord
     * @param port
     * @return
     * @throws JSchException 
     */
	private static ChannelSftp connectSFTP(String host, String userName,  String passWord, String privateKey, 
			String passPhrase, int port)
			throws Exception {		  		
		JSch jsch = new JSch();		
		Session session = null;
		Channel channel = null;

		apple_host = host;
		apple_userName = userName;
		if (!StringHelper.isEmptyStr(privateKey)) {
			URL url = Thread.currentThread().getContextClassLoader().getResource(privateKey);
			if (url != null) {
				apple_privateKey = url.getPath(); // 获取文件在项目中的路径
			}
		}
		if (!StringHelper.isEmptyStr(passWord)) {
			apple_passWord = passWord;
		}
		apple_port = port;
		if (!StringHelper.isEmptyStr(apple_privateKey)) { // 使用密钥验证。密钥可以有密码，也可以没有密码
			if (!StringHelper.isEmptyStr(passPhrase)) {
				jsch.addIdentity(apple_privateKey, passPhrase);
			} else {
				jsch.addIdentity(apple_privateKey);
			}
		}
		session = jsch.getSession(apple_userName, apple_host, apple_port);// 根据用户名、ip、端口获取一个session
		if (!StringHelper.isEmptyStr(apple_passWord)) {
			session.setPassword(apple_passWord); // 设置连接密码
		}
		if(host.equals(SystemConstants.DISNEY_SFTP_HOST)){
			session.setConfig("kex","diffie-hellman-group1-sha1");
		}
		Properties sshConfig = new Properties();
		// sshConfig.put("kex", "diffie-hellman-group1-sha1");// 在session中指定加密算法
		sshConfig.put("StrictHostKeyChecking", "no");// 不验证主机密钥
//		sshConfig.put("PreferredAuthentications", "publickey");
		
		session.setConfig(sshConfig);// 
		session.setTimeout(90000); // 设置session的超时时间
		session.connect();// ͨ通过session建立连接  
		channel = session.openChannel("sftp");// 打开sftp通道
		//channel.connect(60000);// 建立连接，设置超时
		channel.connect();// 建立连接
		return (ChannelSftp) channel;
	}
	public static void main(String[] args) {
//		downloadFile("ftp2-dhllink.dhl.com", "aplxkeas_sftp", "EEf6GPL8VyKIbxlk", "", "", 22, "/out/", "/out", 0);
		downloadFile("filetransfer.disney.com", "KERD", "KERD_gsaccess", "", "", 22050, "/TEST/outbound/EDI204/", "/out", 1);
	}
    
	/**
	 * 上传文件
	 * @param host
	 * @param userName
	 * @param privateKey
	 * @param passWord
	 * @param port
	 * @param fileName
	 * @param upDir
	 * @return
	 */
	public static String pushFile(String host, String userName, String passWord,String privateKey, String passPhrase, int port,
			String fileName, String upDir) {

		ChannelSftp cSftp = null;
		logger.info("======== push file start ========");
		try {
			long t1 = System.currentTimeMillis();
			cSftp = connectSFTP(host, userName, passWord, privateKey, passPhrase, port);
			long t2 = System.currentTimeMillis();
			logger.info("====== sftp push connect time ======"+(t2-t1)/1000);
			if (cSftp != null) {
				long t3 = System.currentTimeMillis();
				File file = new File(fileName);
				try {
					if (file.exists()) {
						try {
							cSftp.cd(upDir);
						} catch (Exception e) {
							cSftp.mkdir(upDir);
						}
						cSftp.put(fileName, upDir);
						long t4 = System.currentTimeMillis();
						logger.info("====== sftp push file time ======"+(t4-t3)/1000);
						logger.info("======== push file end ========");
						return "0";
					}else {
						return "3"; // 文件不存在
					}
				} catch (Exception e) {
					e.printStackTrace();
					return "1";
				} finally {
					if(cSftp.getSession()!= null && cSftp.getSession().isConnected()){
						cSftp.getSession().disconnect();
					}
					cSftp.quit();
					cSftp.disconnect();
				}
			}			
		} catch (Exception e1) {
			e1.printStackTrace();
			return "2";
		}		
		return null;
	}
	

	
	/**
	 * 下载文件
	 * @param host
	 * @param userName
	 * @param privateKey
	 * @param passWord
	 * @param port
	 * @param fileDir
	 * @param downDir
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String downloadFile(String host, String userName,String passWord,String privateKey, String passPhrase,
        int port, String fileDir, String downDir, int size) {

		ChannelSftp cSftp = null;
		try {
			long t1 = System.currentTimeMillis();
			logger.info("======== sftp info ========" + host + " " + userName + " " + passWord + " " + privateKey + " "
					+ passPhrase + " " + port);
			logger.info("===KOMS_EDI===" + host + " connect sftp start======"
					+ DateHelper.formatDate(new Date(), SystemConstants.SYSTEM_DATETIME_FORMAT_4));

			cSftp = connectSFTP(host, userName, passWord, privateKey, passPhrase, port);
			long t2 = System.currentTimeMillis();
			logger.info("===KOMS_EDI===" + host + " connect sftp end======"
					+ DateHelper.formatDate(new Date(), SystemConstants.SYSTEM_DATETIME_FORMAT_4));
			if (cSftp != null) {
				try {
					createDir(fileDir,cSftp);
					Vector fileList = cSftp.ls(fileDir); // 取出文件夹中的文件列表，返回值为vector
					if (fileList != null) {
						List<String> fileNameList = new ArrayList<String>();
						Iterator it = fileList.iterator(); // 放入迭代器中
						while (it.hasNext()) { // 进行遍历筛选
							// LsEntry可以认为是文件服务器上的文件条目信息，包含文件或者目录相关属性。ls命令返回的Vector中的就是LsEntry对象列表
							String fileName = ((LsEntry) it.next()).getFilename();
							logger.info("==KOMS_EDI====" + host + " sftp fileName:"+fileName+" ======");
							if (".".equals(fileName) || "..".equals(fileName)) { // 排除可能存在的上级目录
								logger.info("==KOMS_EDI====" + host + " sftp fileName:"+fileName+" continue ======");
								continue;
							}
							logger.info("==KOMS_EDI====" + host + " sftp fileName:"+fileName+" add ======");
							fileNameList.add(fileName); // 将文件名添加的list中
							
						}
						if (fileNameList != null && fileNameList.size() > 0) {
							Iterator<String> itd = fileNameList.iterator();
							while (itd.hasNext()) {
								String downName = itd.next().toString();
								int i = 0;
								if (downName.toString().indexOf(".") < 0) { // 去除可能存在的文件夹
									try {
										cSftp.cd(downName);
										continue;
									} catch (Exception e) {
										
									}
								}
								long t3 = System.currentTimeMillis();
								String saveFile = downDir + downName; // 下载后生成文件的文件名
								cSftp.cd(fileDir);
								FileOutputStream fops = new FileOutputStream(saveFile);
								cSftp.get(downName, fops); // 下载文件
								long t4 = System.currentTimeMillis();
								logger.info("==KOMS_EDI====" + host + " sftp download " + downName + " time ======"
										+ (t4 - t3) / 1000);
								cSftp.rm(downName);
								fops.close();
								i++;
								if (size != 0 && i == size) {
									break;
								}
							}
						}
					}
				} catch (Exception e) {
					logger.info("===KOMS_EDI===" + host + " connect sftp exception======"
							+ DateHelper.formatDate(new Date(), SystemConstants.SYSTEM_DATETIME_FORMAT_4));
					logger.info("====KOMS_EDI==== sftp Exception ========" + host + " " + userName + " " + passWord
							+ " " + privateKey + " " + passPhrase + " " + port + " " + e.getMessage());
					e.printStackTrace();
					return "1";
				} finally {
					if (cSftp.getSession() != null && cSftp.getSession().isConnected()) {
						cSftp.getSession().disconnect();
					}
					cSftp.quit();
					cSftp.disconnect();
				}
			}
		} catch (Exception e1) {
			logger.info("===KOMS_EDI===" + host + " connect sftp exception======"
					+ DateHelper.formatDate(new Date(), SystemConstants.SYSTEM_DATETIME_FORMAT_4));
			logger.info("===KOMS_EDI===== sftp Exception1 ========" + host + " " + userName + " " + passWord + " "
					+ privateKey + " " + passPhrase + " " + port + " " + e1.getMessage());
			e1.printStackTrace();
			return "2";
		}
		return "0";
	}
	
	@SuppressWarnings("rawtypes")
	public static String downloadFile(String host, String userName,String passWord,String privateKey, String passPhrase,
			int port, String fileDir, String downDir, int size,String fileFormat) throws Exception{
		ChannelSftp cSftp = null;
		logger.info("======== sftp info ========"+host+" "+userName+" "+passWord+" "+privateKey+" "+passPhrase+" "+port);
		logger.info("===KOMS_H3C==="+host+" connect sftp start======"+DateHelper.formatDate(new Date(), SystemConstants.SYSTEM_DATETIME_FORMAT_4));
		cSftp = connectSFTP(host, userName, passWord, privateKey, passPhrase,port);
		logger.info("===KOMS_H3C==="+host+" connect sftp end======"+DateHelper.formatDate(new Date(), SystemConstants.SYSTEM_DATETIME_FORMAT_4));
		if (cSftp != null) {
			try {
				try{
					cSftp.cd(fileDir);
				}catch (Exception e){
					cSftp.mkdir(fileDir);
				}
				Vector fileList = cSftp.ls(fileDir); // 取出文件夹中的文件列表，返回值为vector
				if (fileList != null) {
					List<String> fileNameList = new ArrayList<String>();
					Iterator it = fileList.iterator(); // 放入迭代器中
					while (it.hasNext()) { // 进行遍历筛选
						// LsEntry可以认为是文件服务器上的文件条目信息，包含文件或者目录相关属性。ls命令返回的Vector中的就是LsEntry对象列表
						String fileName = ((LsEntry) it.next()).getFilename();
						if (".".equals(fileName) || "..".equals(fileName)) { // 排除可能存在的上级目录
							continue;
						}
						if(!StringHelper.isEmptyStr(fileFormat)){
							if(fileFormat.indexOf(fileName) == 0){
								continue;
							}
						}
						fileNameList.add(fileName); // 将文件名添加的list中
					}
					if (fileNameList != null && fileNameList.size() > 0) {
						Iterator<String> itd = fileNameList.iterator();
						while (itd.hasNext()) {
							String downName = itd.next().toString();
							int i = 0;
							if (downName.toString().indexOf(".") < 0) { // 去除可能存在的文件夹
								continue;
							}
							long t3 = System.currentTimeMillis();
							String saveFile = downDir + downName; // 下载后生成文件的文件名
							cSftp.cd(fileDir);
							FileOutputStream fops = new FileOutputStream(saveFile);
							cSftp.get(downName, fops); // 下载文件
							long t4 = System.currentTimeMillis();
							logger.info("==KOMS_H3C===="+host+" sftp download "+downName+" time ======"+(t4-t3)/1000);
							cSftp.rm(downName);
							fops.close();
							i++;
							if(size>0&&i==size){
								break;
							}
						}
					}
				}
			}finally {
				try {
					if(cSftp != null && cSftp.getSession()!= null && cSftp.getSession().isConnected()){
						cSftp.getSession().disconnect();
					}
				} catch (JSchException e) {
					e.printStackTrace();
				}
				if(cSftp != null){
					cSftp.quit();
					cSftp.disconnect();
				}
			}
		} 		
		return "0";
	}
	
	@SuppressWarnings("rawtypes")
	public static String downloadAndMoveFile(String host, String userName,String passWord,String privateKey, String passPhrase,
			int port, String fileDir, String downDir, String newDir, int size, String rootDir) {

		ChannelSftp cSftp = null;
		logger.info("======== download file start ========");
		try {
			long t1 = System.currentTimeMillis();
			logger.info("======== sftp info ========"+host+" "+userName+" "+passWord+" "+privateKey+" "+passPhrase+" "+port);
			cSftp = connectSFTP(host, userName, passWord, privateKey, passPhrase,port);
			long t2 = System.currentTimeMillis();
			logger.info("====== connect sftp download time ======"+(t2-t1)/1000);
			if (cSftp != null) {
				try {
					boolean flag = false;
					Vector vector = cSftp.ls(rootDir);
					if(vector != null){
						Iterator it = vector.iterator(); // 放入迭代器中
						while (it.hasNext()) {
							String fileName = ((LsEntry) it.next()).getFilename();
							if(fileName.equals("ok.txt")){
								flag = true;
								cSftp.cd(rootDir);
								cSftp.rm(fileName);
								break;
							}
						}
					}
					long t3 = System.currentTimeMillis();
					if(flag){
						try{
							cSftp.cd(fileDir);
						}catch (Exception e){
							cSftp.mkdir(fileDir);
						}
						Vector fileList = cSftp.ls(fileDir); // 取出文件夹中的文件列表，返回值为vector
						if (fileList != null) {
							List<String> fileNameList = new ArrayList<String>();
							Iterator it = fileList.iterator(); // 放入迭代器中
							while (it.hasNext()) { // 进行遍历筛选
								// LsEntry可以认为是文件服务器上的文件条目信息，包含文件或者目录相关属性。ls命令返回的Vector中的就是LsEntry对象列表
								String fileName = ((LsEntry) it.next()).getFilename();
								if (".".equals(fileName) || "..".equals(fileName)) { // 排除可能存在的上级目录
									continue;
								}
								try {
									cSftp.cd(fileName);
									continue;
								} catch (Exception e) {
									
								}
								
								fileNameList.add(fileName); // 将文件名添加的list中
							}
							if (fileNameList != null && fileNameList.size() > 0) {
								Iterator<String> itd = fileNameList.iterator();
								while (itd.hasNext()) {
									String downName = itd.next().toString();
									int i = 0;
									if (downName.toString().indexOf(".") < 0) { // 去除可能存在的文件夹
										continue;
									}
									String saveFile = downDir + downName; // 下载后生成文件的文件名
									cSftp.cd(fileDir);
									FileOutputStream fops = new FileOutputStream(saveFile);
									cSftp.get(downName, fops); // 下载文件
									long t4 = System.currentTimeMillis();
									logger.info("====== sftp download "+downName+" time ======"+(t4-t3)/1000);
									//cSftp.rm(downName);
									try {
										cSftp.cd(newDir);
									} catch (Exception e) {
										cSftp.mkdir(newDir);
									}
									cSftp.rename(fileDir+downName, newDir+downName);
									fops.close();
									i++;
									if(size!=0&&i==size){
										break;
									}
								}
								logger.info("======== download file end ========");
								return "0";
							} else {
								System.out.println("sftpfile not exists");
								return "3";
							}
						} else {
							System.out.println("sftpDir not exists");
							return "4";
						}
					}
				} catch (Exception e) {
					logger.info("======== sftp Exception ========"+host+" "+userName+" "+passWord+" "+privateKey+" "+passPhrase+" "+port+" "+e.getMessage());
					e.printStackTrace();
					return "1";
				} finally {
					if(cSftp.getSession()!= null && cSftp.getSession().isConnected()){
						cSftp.getSession().disconnect();
					}
					cSftp.quit();
					cSftp.disconnect();
				}
			}			
		} catch (Exception e1) {
			logger.info("======== sftp Exception ========"+host+" "+userName+" "+passWord+" "+privateKey+" "+passPhrase+" "+port+" "+e1.getMessage());
			e1.printStackTrace();
			return "2";
		}		
		return "0";
	}
	
	@SuppressWarnings("rawtypes")
	public static String pushAndAuthFile(String host, String userName, String passWord,String privateKey, String passPhrase, int port,
			String fileName, String upDir) {

		ChannelSftp cSftp = null;
		logger.info("======== push file start ========"+host);
		try {
			long t1 = System.currentTimeMillis();
			cSftp = connectSFTP(host, userName, passWord, privateKey, passPhrase, port);
			long t2 = System.currentTimeMillis();
			logger.info("====== sftp push connect time ======"+host+" "+(t2-t1)/1000);
			if (cSftp != null) {
				long t3 = System.currentTimeMillis();
				File file = new File(fileName);
				try {
					boolean flag = false;
					Vector vector = cSftp.ls("/");
					if(vector != null){
						Iterator it = vector.iterator(); // 放入迭代器中
						while (it.hasNext()) {
							String fileStr = ((LsEntry) it.next()).getFilename();
							if(fileStr.equals("ok.txt")){
								flag = true;
								cSftp.rm(fileName);
							}
						}
					}
					if(flag){
						if (file.exists()) {						
							cSftp.put(fileName, upDir);
							long t4 = System.currentTimeMillis();
							logger.info("====== sftp push file time ======"+(t4-t3)/1000);
							logger.info("======== push file end ========");
							return "0";
						}else {
							return "3"; // 文件不存在
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					return "1";
				} finally {
					if(cSftp.getSession()!= null && cSftp.getSession().isConnected()){
						cSftp.getSession().disconnect();
					}
					cSftp.quit();
					cSftp.disconnect();
				}
			}			
		} catch (Exception e1) {
			e1.printStackTrace();
			return "2";
		}		
		return "0";
	}
	
	public static int pushListFile(String host, String userName, String passWord, String privateKey, String passPhrase, 
			int port, List<String> fileList, String upDir){
		ChannelSftp cSftp = null;
		try {
			long t1 = System.currentTimeMillis();
			logger.info("====KOMS_EVENT_PUSH===="+host+" push file start ========"+t1);
			cSftp = connectSFTP(host, userName, passWord, privateKey, passPhrase, port);;
			long t2 = System.currentTimeMillis();
			logger.info("===KOMS_EVENT_PUSH==="+host+" sftp push connect time ======"+t2);
			if (cSftp != null) {
				for(String fileName : fileList){
					try{
						long t3 = System.currentTimeMillis();
						File file = new File(fileName);
						if(file.exists()){
							cSftp.put(fileName, upDir);
							long t4 = System.currentTimeMillis();
							logger.info("===KOMS_EVENT_PUSH==="+host+" sftp push file time ======"+(t4-t3)/1000);
							logger.info("===KOMS_EVENT_PUSH===== push file end ========");
						}else{
							return 2;
						}
					}catch (Exception e){
						logger.info("===KOMS_EVENT_PUSH====="+host+" Exception:"+e.getMessage());
						e.printStackTrace();
						return 1;
					}
				}
			}
			return 0;
		} catch (Exception e1) {
			logger.info("===KOMS_EVENT_PUSH====="+host+" Exception1:"+e1.getMessage());
			e1.printStackTrace();
		}finally {
			try {
				if(cSftp != null && cSftp.getSession()!= null && cSftp.getSession().isConnected()){
					cSftp.getSession().disconnect();
				}
			} catch (JSchException e) {
				e.printStackTrace();
			}
			if(cSftp != null){
				cSftp.quit();
				cSftp.disconnect();
			}
		}	
		return 0;
	
	}
	
	  /**
     * 创建一个文件目录
     */
    private static void createDir(String createpath, ChannelSftp sftp)
    {
        try
        {
            if (isDirExist(createpath, sftp))
            {
                sftp.cd(createpath);
                return;
            }
            String pathArry[] = createpath.split("/");
            StringBuffer filePath = new StringBuffer("/");
            for (String path : pathArry)
            {
                if (path.equals(""))
                {
                    continue;
                }
                filePath.append(path + "/");
                if (isDirExist(filePath.toString(), sftp))
                {
                    sftp.cd(filePath.toString());
                }
                else
                {
                    // 建立目录
                    sftp.mkdir(filePath.toString());
                    // 进入并设置为当前目录
                    sftp.cd(filePath.toString());
                }
            }
            sftp.cd(createpath);
        }
        catch (SftpException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 判断目录是否存在
     */
    private static boolean isDirExist(String directory, ChannelSftp sftp)
    {
        boolean isDirExistFlag = false;
        try
        {
            SftpATTRS sftpATTRS = sftp.lstat(directory);
            isDirExistFlag = true;
            return sftpATTRS.isDir();
        }
        catch (Exception e)
        {
            if (e.getMessage().toLowerCase().equals("no such file"))
            {
                isDirExistFlag = false;
            }
        }
        return isDirExistFlag;
    }

}