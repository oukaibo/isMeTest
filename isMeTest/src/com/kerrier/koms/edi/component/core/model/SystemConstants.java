package com.kerrier.koms.edi.component.core.model;

import util.StringHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class SystemConstants {
 
    public static final float WV_RATIO = 166.66667F;
    public static final float MV_RATIO = 166.67F;  
	private static Properties prop = new Properties();
	public static boolean isUseRedis;
	public static boolean openRedisBasic;
	public static boolean printaccesslog;
	public static String ediUrl;
	public static String kappApiUrl;
	public static String xiaomiUrl;
	private static InputStream in;
	public static String otmsUrl;
	public static int OTMS_ORDER_EVENT;
	public static String OTMS_ORDER_LOGIN;
	public static String OTMS_ORDER_PASSWORD;
	public static String OTMS_ORDER_VERSION;
	public static String OTMS_GPS_LOGIN;
	public static String OTMS_GPS_PASSWORD;
	public static String OTMS_ORDER_STATUS;//查询订单详情条件
	public static String OTMS_ORDER_CLIENT;//查询订单详情条件
	public static String LUBRIZOL_TOKEN;
	public static String KAPP_URL;
	public static String EMAIL_APPID;
	public static String EMAIL_APPKEY;
	public static String[] SONY_PROJECT_CODE;
	public static String LUBRIZOLCREATEBY;
	
	public static final String PROJECT_MAPPING_FIEDL_SERVIVEMODE_ID="service_mode_id";
	public static final String PROJECT_MAPPING_FIEDL_IS_IN_ORGSTATION="is_in_orgstation";
	
	public static String AVON_UPLOAD_DIR;
	public static String AVON_DOWNLOAD_DIR;
	public static String AVON_WAYBILL_PATH;
	public static String AVON_WAYBILL_HISTORY_PATH;
	public static String AVON_RESPONSE_PATH;
	public static String AVON_RESPONSE_SUCCESS_PATH;
	public static String AVON_RESPONSE_ERROR_PATH;
	public static String FTPIP;
	public static int FTPPort;
	public static String FTPUserName;
	public static String FTPPassWord;
	
	public static String FILE_PATH;
	public static int FILE_APPID;
	public static String FILE_APPKEY;
	public static String CUSTOMER_PATH;
	public static String CUSTOMER_LOCAL_PAH;
	public static String CUSTOMER_LOCAL_PAH_HISTORY;
	public static String ABB_DOWNLOAD_DIR;
	public static String ABB_SUCCESSDIR;
	public static String ABB_ERRDIR;
	public static String CUSTOMER_LOCAL_ERROR_PATH;
	public static String CUSTOMER_LOCAL_ERROR_HISTORY_PATH;
	public static String ABB_FTP;
	public static int ABB_FTPPORT;
	public static String ABB_FTPUSER;
	public static String ABB_FTPPASSWORD;
	public static String STRYKER_HOST;
	public static int STRYKER_PORT;
	public static String STRYKER_USERNAME;
	public static String STRYKER_PASSWORD;
	public static String STRYKER_TOKAPP_PATH;
	public static String STRYKER_FROMKAPP_PATH;
	public static String LOCAL_ORDER_PATH;
	public static String LOCAL_UPLOAD_PATH;
	public static String LOCAL_UPLOAD_SUCCESS_PATH;
	public static String LOCAL_UPLOAD_ERROR_PATH;
	public static String YD_PARTNER_ID;
	public static String YD_PASSWORD;
	public static String FESTO_FTP;
	public static String FESTO_USERNAME;
	public static String FESTO_PASSWORD;
	
	@Deprecated
	public static String FESTO_UPLOAD_PAH;//以后不再使用，通过koms_festo_project_mapping
	
	public static String APPLE_SFTP_HOST;
	public static String APPLE_SFTP_USERNAME;
	public static String APPLE_SFTP_PASSWORD;
	public static String APPLE_SFTP_PRIVATEKEY;
	public static String APPLE_SFTP_PASSPHRASE;
	public static String APPLE_SFTP_PORT;
	public static String APPLE_DOWNLOAD_PAH;
	
	public static String APPLECARE_SFTP_HOST;//applecare参数
	public static String APPLECARE_SFTP_USERNAME;
	public static String APPLECARE_SFTP_PASSWORD;
	public static String APPLECARE_SFTP_PRIVATEKEY;
	public static String APPLECARE_SFTP_PASSPHRASE;
	public static String APPLECARE_SFTP_PORT;
	public static String APPLECARE_UPLOAD_PAH;
	public static String APPLECARE_DOWNLOAD_PAH;
	
	public static String DISNEY_SFTP_HOST;
	public static String DISNEY_SFTP_USERNAME;
	public static String DISNEY_SFTP_PASSWORD;
	public static String DISNEY_SFTP_PRIVATEKEY;
	public static String DISNEY_SFTP_PASSPHRASE;
	public static String DISNEY_SFTP_PORT;
	public static String DISNEY_UPLOAD_PAH;
	public static String DISNEY_DOWNLOAD_PAH;
	
	public static String DHL_SFTP_HOST;
	public static String DHL_SFTP_USERNAME;
	public static String DHL_SFTP_PASSWORD;
	public static String DHL_SFTP_PRIVATEKEY;
	public static String DHL_SFTP_PASSPHRASE;
	public static String DHL_SFTP_PORT;
	public static String DHL_UPLOAD_PAH;
	public static String DHL_DOWNLOAD_PAH;
	
	public static String CNTIC_SFTP_HOST;
	public static String CNTIC_SFTP_USERNAME;
	public static String CNTIC_SFTP_PASSWORD;
	public static String CNTIC_SFTP_PRIVATEKEY;
	public static String CNTIC_SFTP_PASSPHRASE;
	public static String CNTIC_SFTP_PORT;
	public static String CNTIC_UPLOAD_PAH;
	public static String CNTIC_DOWNLOAD_PAH;
	
	
	public static String SLC_SFTP_HOST;
	public static String SLC_SFTP_USERNAME;
	public static String SLC_SFTP_PASSWORD;
	public static String SLC_SFTP_PRIVATEKEY;
	public static String SLC_SFTP_PASSPHRASE;
	public static String SLC_SFTP_PORT;
	public static String SLC_UPLOAD_PAH;
	public static String SLC_DOWNLOAD_PAH;
	
	
	
	public static String EDI_SFTP_HOST;
	public static String EDI_SFTP_USERNAME;
	public static String EDI_SFTP_PASSWORD;
	public static String EDI_SFTP_PRIVATEKEY;
	public static String EDI_SFTP_PASSPHRASE;
	public static String EDI_SFTP_PORT;
	public static String EDI_DHL_PAH;
	public static String EDI_CNTIC_PAH;
	
	public static String AVON_SFTP_HOST;
	public static String AVON_SFTP_USERNAME;
	public static String AVON_SFTP_PASSWORD;
	public static String AVON_SFTP_PRIVATEKEY;
	public static String AVON_SFTP_PASSPHRASE;
	public static String AVON_SFTP_PORT;
	public static String AVON_3PL_NEWPAH;
	public static String AVON_3PL_DOWNLOADPAH;
	public static String AVON_LOG_UPLOADPAH;
	public static String AVON_3PL_FILEPATH;
	public static String AVON_3PL_LOGPATH;
	public static String AVON_FILE_HISTORY_PATH;
	public static String AVON_RESPONSE_FILEPATH;
	public static String AVON_RESPONSE_UPLOAD;
	public static String AVON_RESPONSE_SUCCESS_DIR;
	public static String AVON_RESPONSE_ERROR_DIR;
	public static int HET_DISPATCH_ID;
	public static String CRM_URL;//视甄接口路径
	public static String CRM_TOKEN;//视甄接口token
	public static String CRM_SHIPPINGCOMPANY;//视臻接口公司名称
	public static String XiaoMisecret;//小米密钥
	public static String zt_key;//中通密钥
	public static String ZT_COMPANYCODE;// 中通客户平台编号
	public static String ZT_GETWEIGHT_PASSWORD;// 中通获取重量接口的密码
	public static String ZT_GETWEIGHT_URL;// 中通获取重量接口路径
	public static String ZT_GETWEIGHT_TYPE;// 中通获取重量接口的类型
	public static String ZT_COMPANY_ID;// 中通合作商ID
	public static String ZT_SCANTYPE;// 中通状态
	public static String DISNEY_EVENT_CODE;// 迪士尼事件状态
	public static String PROJECT_CODE;//project_code=A08005
	public static String START_STATION_CODES;
	public static String FILE_NAME;
	//ali
	public static String ALI_APP_KEY;
	public static String ALI_APP_SECRET;
	public static String ALI_APP_SANDBOX_KEY;
	public static String ALI_APP_SANDBOX_SECRET;
	public static String ALI_API_SANDBOX_HTTP_URL;//阿里接口沙盒http地址
	public static String ALI_DOMAIN;//阿里接口参数
	public static String ALI_ACTION_15 = "createLogisticsOrder";//阿里接口参数-推送分单信息
	public static String ALI_ACTION_16 = "updateLogisticsOrder";//阿里接口参数-推送在途信息
	public static String G7URL;//G7 url
	public static String G7APPKEY;//G7 appkey
	public static String G7APPSECRET;// G7 密钥
	public static String G7CARPARM;// G7 车辆信息参数
	public static String G7CARPATH;// G7 车辆方法
	public static String G7GPSPARM;// G7 GPS信息参数
	public static String G7GPSPATH;// G7 GPS方法
	public static List<String> CRMPROJECTS;
	//Inspur(浪潮)
	public static String INSPUR_SUPPLIER_CODE;//承运商代码
	public static String INSPUR_SUPPLIER_APPKEY;//承运商Appkey
	public static String INSPUR_INTERFACE_VEHICLE_PLAN;//运输计划接口地址
	public static String INSPUR_INTERFACE_SHIPMENT;//发货单接口地址
	public static String INSPUR_INTERFACE_GPS;//车辆轨迹接口地址
	public static String INSPUR_SFTP_ADDRESS;//sftp地址
	public static String INSPUR_SFTP_USERNAME;//sftp用户名
	public static String INSPUR_SFTP_PASSWORD;//sftp密码
	public static String INSPUR_PROJECT_CODE;//alarm_config中使用的project_code
	public static String INSPUR_EMAIL_ERROR_CODE_INNER;//alarm_config中使用的error_code：运输计划-国内
	public static String INSPUR_EMAIL_ERROR_CODE_OUTER;//alarm_config中使用的error_code：运输计划-国外
	public static String INSPUR_EXCEL_VEHICLE_PLAN_INNER;//表格附件=运输计划及明细-国内.xls
	public static String INSPUR_EXCEL_VEHICLE_PLAN_OUTER;//表格附件=运输计划及明细-国外.xls
	public static List<String> INSPUR_PARSE_PROJECT;
	//昆山盖茨
	public static String GATES_ORDER_OUTBOUND;
	public static String GATES_ASSIGN_DRIVER;
	public static String GATES_VERSION;
	public static String GATES_LOGIN;
	public static String GATES_PASSWORD;
//	public static int GATES_REFERENCE_TYPE_ID;//erpNumber已弃用
	public static String GATES_CUSTOMER_NAME;
	public static String GATES_EXCEL_NAME;
	public static String GATES_DRIVER_NAME;
	public static String GATES_DRIVER_MOBILE;
	public static String GATES_DRIVER_TRUCK_PLATE;
	public static int GATES_MAX;
	public static int GATES_GROUP_SIZE;
	public static List<String> GATES_GROUP = new ArrayList<String>();
	//视臻视睿新接口
	public static String CVTE_USERNAME;
	public static String CVTE_PASSWORD;
	public static String CVTE_SOURCESYSTEM;//TMS调koms接口时传入
	public static String CVTE_SOURCESYSTEM2;//koms调TMS接口时传入
	public static String CVTE_HOST;
	public static String CVTE_CARRIERCODE;
	public static String CVTE_KWMS_HOST;
	public static String CVTE_SFTP_HOST;
	public static int CVTE_SFTP_PORT;
	public static String CVTE_SFTP_DIR_CLAIM;
	public static String CVTE_SFTP_DIR_FEE;
	public static String CVTE_SFTP_USERNAME;
	public static String CVTE_SFTP_PASSWORD;
	public static int CVTE_SFTP_USERID;
	//shell api
	public static String SHELL_APIKEY;
	public static String SHELL_APISECRET;
	public static String SHELL_APIPATH_TYPE;
	public static String SHELL_API_LOGIN;
	public static String SHELL_API_REFRESH;
	public static String SHELL_API_WAYBILL;
	public static String SHELL_API_LOCATION;
	public static String SHELL_API_DELETE;
	
	//shell供方参数
	public static int SHELL_VENDOR_APPID;
	public static String SHELL_VENDOR_APPKEY;
	public static String SHELL_VENDOR_PASS;
	public static String SHELL_VENDOR_IV;
	//小米解密用
	public static List<String> XIAOMI_AES_PROJECT;
	public static String XIAOMI_AES_IV;
	public static String XIAOMI_AES_PKEY;
	//菲尼克斯
	public static String PHOENIX_ORGKEY;
	public static String PHOENIX_AUTHKEY;
	public static String PHOENIX_CODE;
	public static String PHOENIX_NAME;
	public static String PHOENIX_URL;
	public static List<String> PHOENIX_COMBINE_DATE;
	//tencent
	public static int TX_APP_ID;
	public static String TX_APP_KEY;
	public static String TX_APP_SECRET;
	public static String TX_METHOD_CREATE;
	public static String TX_METHOD_CANCEL;
	public static String TX_METHOD_GETINFO;
	public static String TX_V;
	public static List<String> TX_METHOD;
	public static int TX_WAYBILL_LIMIT;
	public static List<String> TX_EVENT_TYPE_CODE;
	static {
		try {
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream("common.properties");
			prop.load(new InputStreamReader(in, "UTF-8"));
			/** 是否开启Redis */
			isUseRedis = Boolean.parseBoolean(prop.getProperty("openRedis"));
			openRedisBasic = Boolean.parseBoolean(prop.getProperty("openRedisBasic"));
			printaccesslog= Boolean.parseBoolean(prop.getProperty("printaccesslog"));

			/*同步数据到EDI的接口路径*/
			ediUrl = String.valueOf(prop.getProperty("ediUrl"));
			kappApiUrl= String.valueOf(prop.getProperty("kappUrl"));
			xiaomiUrl = String.valueOf(prop.getProperty("xiaomiUrl"));
			otmsUrl = String.valueOf(prop.getProperty("otmsUrl"));
			/*OTMS订单接口配置*/
			OTMS_ORDER_EVENT = Integer.parseInt(prop.getProperty("otmsOrderEvent"));
			OTMS_ORDER_LOGIN = String.valueOf(prop.getProperty("otmsOrderLogin"));
			OTMS_ORDER_PASSWORD = String.valueOf(prop.getProperty("otmsOrderPassword"));
			OTMS_ORDER_VERSION = String.valueOf(prop.getProperty("otmsOrderVersion"));
			OTMS_GPS_LOGIN = String.valueOf(prop.getProperty("otmsGPSLogin"));
			OTMS_GPS_PASSWORD = String.valueOf(prop.getProperty("otmsGPSPassword"));
			OTMS_ORDER_STATUS = String.valueOf(prop.getProperty("otmsOrderStatus"));
			OTMS_ORDER_CLIENT = String.valueOf(prop.getProperty("otmsOrderClient"));
			LUBRIZOL_TOKEN = String.valueOf(prop.getProperty("LubrizolToken"));
			KAPP_URL = String.valueOf(prop.getProperty("kappUrl"));
			EMAIL_APPID = String.valueOf(prop.getProperty("email_appID"));
			EMAIL_APPKEY = String.valueOf(prop.getProperty("email_appKey"));
			SONY_PROJECT_CODE = String.valueOf(prop.getProperty("sony_project_print")).split(",");
			LUBRIZOLCREATEBY = String.valueOf(prop.getProperty("LubrizolCreateBy"));
			
			AVON_UPLOAD_DIR = String.valueOf(prop.getProperty("avon_uploadDir"));
			AVON_DOWNLOAD_DIR = String.valueOf(prop.getProperty("avon_downloadDir"));
			AVON_WAYBILL_PATH=String.valueOf(prop.getProperty("avon_waybill_path"));
			AVON_WAYBILL_HISTORY_PATH=String.valueOf(prop.getProperty("avon_waybill_history_path"));
			AVON_RESPONSE_PATH=String.valueOf(prop.getProperty("avon_response_path"));
			AVON_RESPONSE_SUCCESS_PATH=String.valueOf(prop.getProperty("avon_response_success_path"));
			AVON_RESPONSE_ERROR_PATH=String.valueOf(prop.getProperty("avon_response_error_path"));
			
			FTPIP = String.valueOf(prop.getProperty("ftp_ip"));
			FTPPort = Integer.valueOf(prop.getProperty("ftp_port"));
			FTPUserName = String.valueOf(prop.getProperty("ftp_username"));
			FTPPassWord = String.valueOf(prop.getProperty("ftp_password"));
			FILE_PATH = String.valueOf(prop.getProperty("filePath"));
			FILE_APPID = Integer.valueOf(prop.getProperty("fileappId","0"));
			FILE_APPKEY = String.valueOf(prop.getProperty("fileappkey"));
			CUSTOMER_PATH = String.valueOf(prop.getProperty("customer_path"));
			CUSTOMER_LOCAL_PAH = String.valueOf(prop.getProperty("customer_local_path"));
			CUSTOMER_LOCAL_PAH_HISTORY = String.valueOf(prop.getProperty("customer_local_path_history"));
			ABB_DOWNLOAD_DIR = String.valueOf(prop.getProperty("abb_dowbloadDir"));
			ABB_SUCCESSDIR = String.valueOf(prop.getProperty("abb_successDir"));
			ABB_ERRDIR = String.valueOf(prop.getProperty("abb_errDir"));
			CUSTOMER_LOCAL_ERROR_PATH = prop.getProperty("customer_local_error");
			CUSTOMER_LOCAL_ERROR_HISTORY_PATH = prop.getProperty("customer_local_error_history");
			ABB_FTP = prop.getProperty("abb_ftp");
			ABB_FTPPORT = Integer.parseInt(prop.getProperty("abb_ftport","0"));
			ABB_FTPUSER = prop.getProperty("abb_ftpuser");
			ABB_FTPPASSWORD = prop.getProperty("abb_ftppassword");
			STRYKER_HOST = String.valueOf(prop.getProperty("ftp_host"));
			STRYKER_PORT = Integer.parseInt(prop.getProperty("ftp_port","0"));
			STRYKER_USERNAME = String.valueOf(prop.getProperty("stryker_ftp_username"));
			STRYKER_PASSWORD =String.valueOf(prop.getProperty("stryker_ftp_password"));
			STRYKER_TOKAPP_PATH = String.valueOf(prop.getProperty("ftp_tokapp_path"));
			STRYKER_FROMKAPP_PATH = String.valueOf(prop.getProperty("ftp_fromkapp_path"));
			LOCAL_ORDER_PATH = String.valueOf(prop.getProperty("local_order_path"));
			LOCAL_UPLOAD_PATH = String.valueOf(prop.getProperty("local_upload_path"));
			LOCAL_UPLOAD_SUCCESS_PATH = String.valueOf(prop.getProperty("local_upload_success_path"));
			LOCAL_UPLOAD_ERROR_PATH = String.valueOf(prop.getProperty("local_upload_error_path"));
			YD_PARTNER_ID = prop.getProperty("partnerid","");
			YD_PASSWORD = prop.getProperty("password","");
			FESTO_FTP = prop.getProperty("festo_ftp_host","");
			FESTO_USERNAME = prop.getProperty("festo_ftp_username","");
			FESTO_PASSWORD = prop.getProperty("festo_ftp_password","");
			FESTO_UPLOAD_PAH = prop.getProperty("festo_download_path","");
			APPLE_SFTP_HOST = prop.getProperty("apple_sftp_host","");
			APPLE_SFTP_USERNAME = prop.getProperty("apple_sftp_username","");
			APPLE_SFTP_PASSWORD = prop.getProperty("apple_sftp_password","");
			APPLE_SFTP_PRIVATEKEY = prop.getProperty("apple_sftp_privatekey", "");
			APPLE_SFTP_PORT = prop.getProperty("apple_sftp_port","");
			APPLE_SFTP_PASSPHRASE = prop.getProperty("apple_sftp_passphrase","");
			APPLE_DOWNLOAD_PAH = prop.getProperty("apple_download_path","");
			APPLECARE_SFTP_HOST = prop.getProperty("applecare_sftp_host","");
			APPLECARE_SFTP_USERNAME = prop.getProperty("applecare_sftp_username","");
			APPLECARE_SFTP_PASSWORD = prop.getProperty("applecare_sftp_password","");
			APPLECARE_SFTP_PRIVATEKEY = prop.getProperty("applecare_sftp_privatekey", "");
			APPLECARE_SFTP_PORT = prop.getProperty("applecare_sftp_port","");
			APPLECARE_SFTP_PASSPHRASE = prop.getProperty("applecare_sftp_passphrase","");
			APPLECARE_UPLOAD_PAH = prop.getProperty("applecare_upload_path","");
			APPLECARE_DOWNLOAD_PAH = prop.getProperty("applecare_download_path","");
			
			DISNEY_SFTP_HOST = prop.getProperty("disney_sftp_host","");
			DISNEY_SFTP_USERNAME = prop.getProperty("disney_sftp_username","");
			DISNEY_SFTP_PASSWORD = prop.getProperty("disney_sftp_password","");
			DISNEY_SFTP_PRIVATEKEY = prop.getProperty("disney_sftp_privatekey", "");
			DISNEY_SFTP_PORT = prop.getProperty("disney_sftp_port","");
			DISNEY_SFTP_PASSPHRASE = prop.getProperty("disney_sftp_passphrase","");
			DISNEY_UPLOAD_PAH = prop.getProperty("disney_upload_path","");
			DISNEY_DOWNLOAD_PAH = prop.getProperty("disney_download_path","");
			
			DHL_SFTP_HOST = prop.getProperty("dhl_sftp_host","");
			DHL_SFTP_USERNAME = prop.getProperty("dhl_sftp_username","");
			DHL_SFTP_PASSWORD = prop.getProperty("dhl_sftp_password","");
			DHL_SFTP_PRIVATEKEY = prop.getProperty("dhl_sftp_privatekey", "");
			DHL_SFTP_PORT = prop.getProperty("dhl_sftp_port","");
			DHL_SFTP_PASSPHRASE = prop.getProperty("dhl_sftp_passphrase","");
			DHL_UPLOAD_PAH = prop.getProperty("dhl_upload_path","");
			DHL_DOWNLOAD_PAH = prop.getProperty("dhl_download_path","");
			
			CNTIC_SFTP_HOST = prop.getProperty("cntic_sftp_host","");
			CNTIC_SFTP_USERNAME = prop.getProperty("cntic_sftp_username","");
			CNTIC_SFTP_PASSWORD = prop.getProperty("cntic_sftp_password","");
			CNTIC_SFTP_PRIVATEKEY = prop.getProperty("cntic_sftp_privatekey", "");
			CNTIC_SFTP_PORT = prop.getProperty("cntic_sftp_port","");
			CNTIC_SFTP_PASSPHRASE = prop.getProperty("cntic_sftp_passphrase","");
			CNTIC_UPLOAD_PAH = prop.getProperty("cntic_upload_path","");
			CNTIC_DOWNLOAD_PAH = prop.getProperty("cntic_download_path","");			
			
			SLC_SFTP_HOST = prop.getProperty("slc_sftp_host","");
			SLC_SFTP_USERNAME = prop.getProperty("slc_sftp_username","");
			SLC_SFTP_PASSWORD = prop.getProperty("slc_sftp_password","");
			SLC_SFTP_PRIVATEKEY = prop.getProperty("slc_sftp_privatekey", "");
			SLC_SFTP_PORT = prop.getProperty("slc_sftp_port","");
			SLC_SFTP_PASSPHRASE = prop.getProperty("slc_sftp_passphrase","");
			SLC_UPLOAD_PAH = prop.getProperty("slc_upload_path","");
			SLC_DOWNLOAD_PAH = prop.getProperty("slc_download_path","");			
			
			EDI_SFTP_HOST = prop.getProperty("edi_sftp_host","");
			EDI_SFTP_USERNAME = prop.getProperty("edi_sftp_username","");
			EDI_SFTP_PASSWORD = prop.getProperty("edi_sftp_password","");
			EDI_SFTP_PRIVATEKEY = prop.getProperty("edi_sftp_privatekey", "");
			EDI_SFTP_PORT = prop.getProperty("edi_sftp_port","");
			EDI_SFTP_PASSPHRASE = prop.getProperty("edi_sftp_passphrase","");
			EDI_DHL_PAH = prop.getProperty("edi_dhl_path","");
			EDI_CNTIC_PAH = prop.getProperty("edi_cntic_path","");
			
			AVON_SFTP_HOST = prop.getProperty("avon_sftp_host","");
			AVON_SFTP_USERNAME = prop.getProperty("avon_sftp_username","");
			AVON_SFTP_PASSWORD = prop.getProperty("avon_sftp_password","");
			AVON_SFTP_PRIVATEKEY = prop.getProperty("avon_sftp_privatekey","");
			AVON_SFTP_PASSPHRASE = prop.getProperty("avon_sftp_passphrase","");
			AVON_SFTP_PORT = prop.getProperty("avon_sftp_port","");
			AVON_3PL_NEWPAH = prop.getProperty("avon_3pl_newpath","");
			AVON_3PL_DOWNLOADPAH = prop.getProperty("avon_3pl_downloadpath","");
			AVON_LOG_UPLOADPAH = prop.getProperty("avon_log_uploadpath","");
			AVON_3PL_FILEPATH = prop.getProperty("avon_3pl_filePath","");
			AVON_3PL_LOGPATH = prop.getProperty("avon_3pl_logpath","");
			AVON_FILE_HISTORY_PATH = prop.getProperty("avon_file_history_path","");
			AVON_RESPONSE_FILEPATH = prop.getProperty("avon_response_filepath","");
			AVON_RESPONSE_UPLOAD = prop.getProperty("avon_response_upload","");
			AVON_RESPONSE_SUCCESS_DIR = prop.getProperty("avon_response_success_dir","");
			AVON_RESPONSE_ERROR_DIR = prop.getProperty("avon_response_error_dir","");
			HET_DISPATCH_ID = StringHelper.intValue(prop.getProperty("HET_DISPATCH_ID","0"));
			CRM_URL = prop.getProperty("crm_url","");
			CRM_TOKEN=prop.getProperty("CRM_TOKEN", "");
			CRM_SHIPPINGCOMPANY=prop.getProperty("CRM_Shippingcompany", "");
			XiaoMisecret=prop.getProperty("XiaoMisecret", "");
			zt_key=prop.getProperty("zt_key","");
			ZT_COMPANYCODE = prop.getProperty("zt_companycode");
			ZT_GETWEIGHT_TYPE = prop.getProperty("zt_getweight_type");
			ZT_COMPANY_ID = prop.getProperty("zt_company_id");
			ZT_GETWEIGHT_URL = prop.getProperty("zt_getweight_url");
			ZT_GETWEIGHT_PASSWORD = prop.getProperty("zt_getweight_password");
			ZT_SCANTYPE = prop.getProperty("zt_scantypes");
			DISNEY_EVENT_CODE = prop.getProperty("disney_event_code","");
			PROJECT_CODE = prop.getProperty("project_code");
			START_STATION_CODES = prop.getProperty("start_station_codes");
			FILE_NAME = prop.getProperty("file_name");
			//阿里配置信息
			ALI_APP_KEY = prop.getProperty("ali_app_key","");
			ALI_APP_SECRET = prop.getProperty("ali_app_secret","");
			ALI_APP_SANDBOX_KEY = prop.getProperty("ali_app_sandbox_key","");
			ALI_APP_SANDBOX_SECRET=prop.getProperty("ali_app_sandbox_secret","");
			ALI_API_SANDBOX_HTTP_URL=prop.getProperty("ali_url","");
			ALI_DOMAIN=prop.getProperty("ali_domain","");
			ALI_ACTION_15=prop.getProperty("ali_pushwaybill_action","");
			ALI_ACTION_16=prop.getProperty("ali_pushgps_action","");
			G7URL = prop.getProperty("g7Url", "");
			G7APPKEY = prop.getProperty("g7AppKey", "");
			G7APPSECRET = prop.getProperty("g7AppSecret", "");
			G7CARPARM = prop.getProperty("g7CarParm", "");
			G7CARPATH = prop.getProperty("g7CarPath", "");
			G7GPSPARM = prop.getProperty("g7GpsParm", "");
			G7GPSPATH = prop.getProperty("g7GpsPath", "");
			CRMPROJECTS = Arrays.asList(prop.getProperty("crmProjects","").split(","));
			INSPUR_SUPPLIER_CODE = prop.getProperty("inspur_supplier_code", "");
			INSPUR_SUPPLIER_APPKEY = prop.getProperty("inspur_supplier_appkey", "");
			INSPUR_INTERFACE_VEHICLE_PLAN = prop.getProperty("inspur_interface_vehicle_plan", "");
			INSPUR_INTERFACE_SHIPMENT = prop.getProperty("inspur_interface_shipment", "");
			INSPUR_INTERFACE_GPS = prop.getProperty("inspur_interface_gps", "");
			INSPUR_SFTP_ADDRESS = prop.getProperty("inspur_sftp_address", "");
			INSPUR_SFTP_USERNAME = prop.getProperty("inspur_sftp_username", "");
			INSPUR_SFTP_PASSWORD = prop.getProperty("inspur_sftp_password", "");
			INSPUR_PROJECT_CODE = prop.getProperty("inspur_project_code", "");
			INSPUR_EMAIL_ERROR_CODE_INNER = prop.getProperty("inspur_email_error_code_inner", "");
			INSPUR_EMAIL_ERROR_CODE_OUTER = prop.getProperty("inspur_email_error_code_outer", "");
			INSPUR_EXCEL_VEHICLE_PLAN_INNER = prop.getProperty("inspur_excel_vehicle_plan_inner", "");
			INSPUR_EXCEL_VEHICLE_PLAN_OUTER = prop.getProperty("inspur_excel_vehicle_plan_outer", "");
			INSPUR_PARSE_PROJECT = Arrays.asList(prop.getProperty("inspur_parse_project", "").split(","));
			//gates
			GATES_ORDER_OUTBOUND = prop.getProperty("gates_order_outbound", "");
			GATES_ASSIGN_DRIVER = prop.getProperty("gates_assign_driver", "");
			GATES_VERSION = prop.getProperty("gates_version", "");
			GATES_LOGIN = prop.getProperty("gates_login", "");
			GATES_PASSWORD = prop.getProperty("gates_password", "");
//			GATES_REFERENCE_TYPE_ID = Integer.parseInt(prop.getProperty("gates_reference_type_id", "0"));
			GATES_CUSTOMER_NAME = prop.getProperty("gates_customer_name", "");
			GATES_EXCEL_NAME = prop.getProperty("gates_excel_name", "");
			GATES_DRIVER_NAME = prop.getProperty("gates_driver_name", "");
			GATES_DRIVER_MOBILE = prop.getProperty("gates_driver_mobile", "");
			GATES_DRIVER_TRUCK_PLATE = prop.getProperty("gates_driver_truck_plate", "");
			GATES_MAX = Integer.parseInt(prop.getProperty("gates_max", "100"));
			GATES_GROUP_SIZE = Integer.parseInt(prop.getProperty("gates_group_size", "0"));
			if(GATES_GROUP_SIZE>0) {
				for(int i=1;i<=GATES_GROUP_SIZE;i++) {
					GATES_GROUP.add(prop.getProperty("gates_group_"+i, ""));
				}
			}
			//cvte
			CVTE_USERNAME = prop.getProperty("cvte_api_username");
			CVTE_PASSWORD = prop.getProperty("cvte_api_password");
			CVTE_SOURCESYSTEM = prop.getProperty("cvte_api_sourcesystem");
			CVTE_SOURCESYSTEM2 = prop.getProperty("cvte_api_sourcesystem2");
			CVTE_HOST = prop.getProperty("cvte_api_host");
			CVTE_CARRIERCODE = prop.getProperty("cvte_api_carriercode");
			CVTE_KWMS_HOST = prop.getProperty("cvte_kwms_host");
			CVTE_SFTP_HOST = prop.getProperty("cvte_sftp_host");
			CVTE_SFTP_PORT = StringHelper.intValue(prop.getProperty("cvte_sftp_port"));
			CVTE_SFTP_DIR_CLAIM = prop.getProperty("cvte_sftp_dir_claim");
			CVTE_SFTP_DIR_FEE = prop.getProperty("cvte_sftp_dir_fee");
			CVTE_SFTP_USERNAME = prop.getProperty("cvte_sftp_username");
			CVTE_SFTP_PASSWORD = prop.getProperty("cvte_sftp_password");
			CVTE_SFTP_USERID = StringHelper.intValue(prop.getProperty("cvte_sftp_userid"));
			//shell
			SHELL_APIKEY = prop.getProperty("shell_apikey");
			SHELL_APISECRET = prop.getProperty("shell_apisecret");
			SHELL_APIPATH_TYPE = prop.getProperty("shell_apipath_type");
			SHELL_API_LOGIN = prop.getProperty("shell_api_login");
			SHELL_API_REFRESH = prop.getProperty("shell_api_refresh");
			SHELL_API_WAYBILL = prop.getProperty("shell_api_waybill");
			SHELL_API_LOCATION = prop.getProperty("shell_api_location");
			SHELL_API_DELETE = prop.getProperty("shell_api_delete");
			
			//shell供方参数
			SHELL_VENDOR_APPID=StringHelper.intValue(prop.getProperty("shell_vendor_appid"));
			SHELL_VENDOR_APPKEY=prop.getProperty("shell_vendor_appkey");
			SHELL_VENDOR_PASS=prop.getProperty("shell_vendor_pass");
			SHELL_VENDOR_IV=prop.getProperty("shell_vendor_iv");
			//小米解密用
			XIAOMI_AES_PROJECT = Arrays.asList(String.valueOf(prop.getProperty("xiaomi_aes_project")).split(","));
			XIAOMI_AES_IV = prop.getProperty("xiaomi_aes_iv");
			XIAOMI_AES_PKEY = prop.getProperty("xiaomi_aes_pkey");
			//菲尼克斯
			PHOENIX_ORGKEY = prop.getProperty("phoenix_orgkey");
			PHOENIX_AUTHKEY = prop.getProperty("phoenix_authkey");
			PHOENIX_CODE = prop.getProperty("phoenix_code");
			PHOENIX_NAME = prop.getProperty("phoenix_name");
			PHOENIX_URL = prop.getProperty("phoenix_url");
			PHOENIX_COMBINE_DATE = Arrays.asList(prop.getProperty("phoenix_combine_date","16:30,17:30;20:00,21:00").split(";"));
			//tencent
			TX_APP_ID = StringHelper.intValue(prop.getProperty("tx_app_id","1"));
			TX_APP_KEY = prop.getProperty("tx_app_key");
			TX_APP_SECRET = prop.getProperty("tx_app_secret");
			TX_METHOD_CREATE = prop.getProperty("tx_method_create");
			TX_METHOD_CANCEL = prop.getProperty("tx_method_cancel");
			TX_METHOD_GETINFO = prop.getProperty("tx_method_getinfo");
			TX_V = prop.getProperty("tx_v");
			TX_METHOD = new ArrayList<String>();
			TX_METHOD.add(TX_METHOD_CREATE);
			TX_METHOD.add(TX_METHOD_CANCEL);
			TX_METHOD.add(TX_METHOD_GETINFO);
			TX_WAYBILL_LIMIT = StringHelper.intValue(prop.getProperty("tx_waybill_limit","20"));
			TX_EVENT_TYPE_CODE = Arrays.asList(prop.getProperty("tx_event_type_code").split(","));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	
	public static final String PICKUP_NUMBER_HEADER = "316K";// 取件蓝牙打印的单号
	public static final String ISSUE_NUMBER_HEADER = "316W";// 异常单号
	
	public static final String WEIGHT_UNIT = "kg";// 重量单位
	public static final String VOLUME_UNIT = "m³";// 体积单位
	public static final String DIMENSION_UNIT = "cm";// 尺寸单位
	public static final String CURRENCY_UNIT = "元";// 货币单位  
	
	/******************************分区取多少天内的数据，只有最近的才能加这种条件取*******************************/
	public static final int PARTITION_EVENT_DAY=-30;
	public static final int PARTITION_EVENT_DAY30=-30;
	public static final int PARTITION_EVENT_DAY2=-7;
	public static final int PARTITION_MWB_DAY=-30;
	public static final int PARTITION_WAYBILL_DAY=-90;
	public static final int PARTITION_WAYBILL_DAY2=-365;
	/********************************* 单点登录--站点经理 角色的id ************************************************/ 
	  
	public static final String SYSTEM_ID = "koms-api";
	public static final String SYSTEM_VERSION = "1.0 demo";
	public static final String SYSTEM_DEFAULT_LANGUAGE = "zh_cn";
	public static final int TOKEN_EXPIRY_INTERVAL = 60;
	public static final boolean IS_DEBUG = true;
	public static final String SYSTEM_DATETIME_FORMAT_17 = "yyyyMMddHHmm";
	public static final String SYSTEM_DATETIME_FORMAT_16 = "yyyy-MM-dd't'HH:mm:ss";
	public static final String SYSTEM_DATETIME_FORMAT_15 = "yyyyMMddHHmmssSSS";
	public static final String SYSTEM_DATETIME_FORMAT_14 = "HHmm";
	public static final String SYSTEM_DATETIME_FORMAT_13 = "yyMMdd";
	public static final String SYSTEM_DATETIME_FORMAT_12 = "yyyyMMddHH";
	public static final String SYSTEM_DATETIME_FORMAT_10 = "yyyyMMdd";
	public static final String SYSTEM_DATETIME_FORMAT_9 = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String SYSTEM_DATETIME_FORMAT_8 = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final String SYSTEM_DATETIME_FORMAT_11 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	public static final String SYSTEM_DATETIME_FORMAT_7 = "yyyy/MM/dd";
	public static final String SYSTEM_DATETIME_FORMAT_6 = "yyyyMMddHHmmss";
	public static final String SYSTEM_DATETIME_FORMAT_5 = "yyyy/MM/dd HH:mm";
	public static final String SYSTEM_DATETIME_FORMAT_4 = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String SYSTEM_DATETIME_FORMAT_3 = "yyyy-MM-dd HH";
	public static final String SYSTEM_DATETIME_FORMAT_2 = "yyyy-MM-dd HH:mm";
	public static final String SYSTEM_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATABASE_DATETIME_FORMAT = "yyyy-MM-dd hh24:mi:ss";
	public static final String SYSTEM_DATE_FORMAT = "yyyy-MM-dd";
	public static final String YEARFORMAT = "yyyy";
    public static final String MONTHFORMAT = "MM";
    public static final String DAYFORMAT = "dd";
    
	public static final String SYTEM_UPLOAD_FILE_PATH = "d:\\tmp\\ktms\\upload_files\\";
	public static final String SYSTEM_UPLOAD_FILE_THUMBNAIL_SMALL_PATH = "d:\\tmp\\ktms\\thumbnail\\small\\";
	public static final String SYSTEM_UPLOAD_FILE_THUMBNAIL_MIDDLE_PATH = "d:\\tmp\\ktms\\thumbnail\\medium\\";
	public static final String SYSTEM_DEFAULT_ENCODE = "UTF-8";
	public static final int EMAIL_INLINE_IMAGE_DISPLAY = 300;
	public static final int MAP_STATIC_IMAGE_WIDTH = 300;
	public static final int MAP_STATIC_IMAGE_HEIGHT = 300;
	public static final int MAP_ZOOM_LEVEL_BAIDU = 10;
	public static final int WAYBILL_EVENT_POD_ID = 4;
	public static final int WAYBILL_EVENT_PD = 8;
	public static final int WAYBILL_EVENT_CUSTOMER_REFUSE = 12;//客户拒收
	public static final int WAYBILL_EVENT_REFUSE = 361;//内物拒收
	public static final int WAYBILL_EVENT_DAMAGE_ID = 5;
	public static final int[] WAYBILL_EVENT_POD_ERROR_CATEGORY = new int[] { 2, 9, 10 }; // 2, 9, 10 fail; 8, 12 exception---单独放出来
	
	public static final int WAYBILL_EVENT_POD_ERROR_CATEGORY_2=2;
	public static final int WAYBILL_EVENT_POD_ERROR_CATEGORY_9=9;
	public static final int WAYBILL_EVENT_POD_ERROR_CATEGORY_10=10;
	public static final int WAYBILL_EVENT_POD_ERROR_CATEGORY_11=11;
	public static final int WAYBILL_EVENT_POD_ERROR_CATEGORY_12=12;
	
	
	public static final int[] WAYBILL_EVENT_PICKUP_ERROR_CATEGORY=new int[] { 35, 36, 37 };//取件异常
	public static final int WAYBILL_EVENT_TRANSIT_ERROR_CATEGORY = 8;
	public static final int WAYBILL_EVENT_CARGO_ERROR_CATEGORY = 12;
	public static final int WAYBILL_EVENT_PARTIAL_POD_ID = 8;
	public static final int WAYBILL_EVENT_DOCUMENT_ERROR_CATEGORY = 40;//单证异常
	public static final int[] WAYBILL_EVENT_PARTIAL_POD_ERROR_CATEGORY = new int[] { 11, 13, 14 };
	public static final int WAYBILL_EVENT_DELIVERY_ID = 3;
	//************************************************
	public static final String WAYBILL_EVENT_ISDAMAGED = "289";//破损
	public static final String WAYBILL_EVENT_ISDAMPED = "129";//受潮
	public static final String WAYBILL_EVENT_ISMISSING = "P155";//货物不一
	public static final String WAYBILL_EVENT_ISINCONSISTENCE = "P109";//少件
	// public static final int[] WAYBILL_EVENT_INTRANSIT_ID_N = new int[]{7};
	public static final int WAYBILL_EVENT_990=373;
	public static final int[] WAYBILL_EVENT_INTRANSIT_ID = new int[] { 2, 229 };

	public static final String DELIVERY_LIST_COD_COLOR = "#F3ABCC";
	public static final String DELIVERY_LIST_FARE_COLOR = "#3366FF";
	public static final String OPERATION_MANUAL_URL = "http://www.kerrylogistics.com";

	public static final int MWB_EVENT_NEW_ID = 1;
	public static final int MWB_EVENT_POD_ID = 6;
	public static final int MWB_EVENT_UPDATE_ID =11;
	
	public static final int MWB_STATUS_POD_ID = 2;

	public static final int MWB_TYPE_DELIVERY_ID = 1;
	public static final int MWB_TYPE_PICKUP_ID = 3;

	public static final int ROLE_COURIER = 4;

	public static final String RANK_TYPE_LOCAL = "LOCAL";
	public static final String RANK_TYPE_ALL = "ALL";

	// 获取图片的类型
	public static final String PHOTO_TYPE_DEFAULT = "N";// 默认大图片
	public static final String PHOTO_TYPE_THUMBNAIL = "T";// 缩略图

	public static final int MWB_TRAFFIC_EXCEPTION = 8; // 主单在途异常分类 add by zys

	// 最新递送状态值
	public static final String LATEST_DELIVERY_STATUS_0 = "未知";
	public static final String LATEST_DELIVERY_STATUS_1 = "装车递送";
	public static final String LATEST_DELIVERY_STATUS_2 = "正常签收";
	public static final String LATEST_DELIVERY_STATUS_3 = "异常签收";
	public static final String LATEST_DELIVERY_STATUS_4 = "递送未成";
	public static final String LATEST_DELIVERY_STATUS_5 = "转运";
	public static final String LATEST_DELIVERY_STATUS_6 = "装车递送";
	public static final int LATEST_DELIVERY_STATUS_PEDING = 1;// 待递送
	public static final int LATEST_DELIVERY_STATUS_POD = 2;// 正常签收
	public static final int LATEST_DELIVERY_STATUS_EXPOD = 3;// 异常签收
	// public static final int LATEST_DELIVERY_STATUS_EXPD = 3;
	public static final int LATEST_DELIVERY_STATUS_FAIL = 4;// 递送未成 
	
	public static final int[] XIAOMI_WAYBILL_EVENT = new int[]{1,4,12};
	
	public static final String 	MSM_ORDER_PROJECT_CODE = "ET0013";
	
	public static final String AVON_PROJECT_CODE = "A06490";//雅芳正向
	public static final String AVON_REVERSE_PROJECT_CODE = "A06491";//雅芳反向
	@Deprecated
	public static final String FESTO_PROJECT_CODE = "A06566";//festo项目号,不用了,已经改为了 koms_festo_project_mapping
	public static final String APPLE_AOS_PROJECT = "A06346";//apple aos项目号
	public static final String UOP_SECURYITYKEY="dc379481ca3301c994bd69ba7f6a2275";
	public static final String UOP_PARTNER="80237908";
	public static final String UOP_GUESS="80398956";
	
	public static final int KOMS_WAYBILL_POD = 4;
	public static final String[] PUSH_EVENT_TYPE_ID={"100","124","POD","PD","145"};
	public static final int PICKUP_EVENT_100=1;  //取件扫描
	public static final int PICKUP_EVENT_Z100=362;  //Z100
	public static final int WAYBILL_EVENT_145 = 3;//装车扫描
	public static final int WAYBILL_EVENT_100=1;
	public static final String OTMS_ORIG_STATION = "上海站";//OTMS订单默认始发站
	public static final String OTMS_SUPPLY_COMPANY = "SHA";//OTMS订单默认货源分公司
	public static final String OTMS_PICKUP_AREA = "01";//OTMS订单默认取件区
	public static final String CUSTOMER_POD_CONFIG = "POD";//客户POD配置
	//public static final String BAIDU_APPKEY = "HF7ch4rl5CO82oQjs2eozxZ2";//百度地图APPKEY
	public static final String BAIDU_APPKEY = "Mez2e25fENQy1yseDrPrdPxU";//百度地图APPKEY
	public static final String XIAOMI_KUNMING_PROJECT = "ET0093";
	public static final String XIAOMI_PROJECT="ET0068";
	public static final String XIAOMI_KUNMING_ORIGSTATION = "昆明站";
	public static final String XIAOMI_SHENZHEN_ORIGSTATION = "深圳站";
	public static final String XIAOMI_CONSIGNEE = "1121926684@qq.com";
	public static final String XIAOMI_ERROR_TYPE = "1";
	public static final String XIAOMI_DEGAULT_PROJECT="0";
	public static final String WAYBILL_EVENT_PODE_CODE="POD";
	public static final String WAYBILL_EVENT_PD_CODE="PD";
	public static final Map<String, String> SONY_PROJECT_MAPPING = sonyProject();
	public static final int SONY_PICKUP_TASK_STATIONID = 1;
	public static final int WAYBILL_EVENT_T101=352;//在途
	public static final String ARVATO_ORDER_TYPE="DeliveryID";//欧唯特订单号型号
	public static final String ARVATO_PROJECT_CODE="A06442";//欧唯特正向取件项目号
	public static final String ARVATO_REVERSE_PROJECT_CODE="ET0208";//欧唯特正向取件项目号
	public static final int SONY_92_REFERENCE=27;
	public static final int SSG_BOXNO_REFERENCE=26;//三星boxno
	public static final int FESTO_REFERENCE_TYPE=28;//Festo项目号typeid
	public static final String WAYBILL_EVENT_130="130";
	public static final int UC_PICKUP_REFERENCE_TYPE=23;
	public static final int UC_PICKUP_SERIES_NO=24;
	public static final int ICN_REFERENCE_TYPE_ID=7;
	public static final List<String> CICSO_PROJECT_CODE = Arrays.asList("ET0123","ET0202");
	public static final List<String> ABB_PROJECT_CODE = Arrays.asList("A09006","ET0133","CS0028");
	public static final String STRYKER_PROJECT_CODE="HT0011";
	public static final int ABB_PROJECT_DESTINATION = 109;
	public static final List<String> ABB_DEFAULT_DEST_PROJECT= Arrays.asList("CS0028");
	public static final List<String> SERVICE_LEVEL = Arrays.asList("标准", "快速");
	public static final int KOMS_UUID_REFERENCE_TYPE = 25;
	public static final String STRYKER_TIME_LIMIT="4D24H";
	public static final String STRYKER_PAYER_CODE="C000371971";
	public static final String STRYKER_PAYER_NAME="史塞克(北京)医疗器械有限公司";
	public static final List<String> HET4_PROJECT_LIST= Arrays.asList("LT0136");
	public static final String HET4_PROJECT = "LT0136";
	public static final int KOMS_REFERENCE_TYPE_33=33;
	public static final int KOMS_REFERENCE_TYPE_37=37;
	public static final String CRM_PROJECT="ET0319";
	public static final String CRM_PROJECT2="ET0327";
	public static final String CRM_PROJECT3="ET0394";// 视臻新的仓配项目号
	public static final String CRM_PROJECT4="ET0357";
	public static final String CRM_PROJECT5="ET0352";
	public static final String SR_PROJECT="ET0383";
	public static final String SR_PROJECT1="ET0392";
	public static final int SR_ORIGSTATIONID=81;//视睿ET0358项目号始发站点id
	public static final int SR_DESTSTATIONID=109;//视睿ET0358项目号目的站点id
	public static final int SR_SERVICEMODEID=4;//视睿ET0358项目号服务方式
	public static final String SRCRM_CODE = "SRCRM";//视臻和视睿的报警通知
	public static final String KEAS_COMBINE_IDENTIFICATION="TYSV";
	public static final int KOMS_REFERENCE_TYPE_35=35;//中通参考号
	public static final int KOMS_REFERENCE_TYPE_36=36;//G7车牌号
	public static final List<String> ZHONGT_POSTEVENT_PROJECT_LIST= Arrays.asList("LT0157");
	public static final String XIAOMI_DEFAULT_PROJECT="ET0068";
	public static final List<String> ALIBABA_CAR_PROJECT = Arrays.asList("ET0320","ET0148");//整车项目号
	public static final List<String> ALI_PRIJECT= Arrays.asList("ET0142","A06482","ET0023");//零担项目号
	public static final int KOMS_REFERENCE_TYPE_18=18;
	public static final int KOMS_REFERENCE_TYPE_32=32;
	//订单未分配提醒
	public static final String CUSTOMER_PICKUP_ALARM = "disney";//多个用逗号隔开
	public static final String PICKUP_TASK_FILENAME = "未分配订单表.xls";
	//腾讯项目号
	public static final List<String> TENCENT_PRIJECT= Arrays.asList("ET0057");
	//苹果214项目号
	public static final String PROJCET_APPLE_EDI="A06346";
	//苹果214create_by字段固定为EDI214，remark字段固定为离开工厂
	public static final String APPLE_CREATE_BY="EDI214";
	public static final String APPLE_REMARK="离开工厂";
	public static final int TENCENT_TRANSPORT_ID = 34;
	//transportMode.name==>id
	public static final String TRANSPORT_MODE_NAME1 = "快件";
	public static final String TRANSPORT_MODE_NAME2 = "陆运";
	//serviceLevel.name==>id
	public static final String SERVICE_LEVEL_NAME1 = "标准";
	public static final String SERVICE_LEVEL_NAME2 = "快速";
	//project_address_info ET0148有多个
	public static final String PROJECT_ADDRESS_INFO_CODE = "ET0148";
	public static final String CUSTOMER_NUMBER_JINAN = "济南市";
	public static final String CUSTOMER_NUMBER_SHENZHEN = "深圳市";
	// 客户指定eta提示
	public static final String ETA_TIPS = "客户指定送达";
	// 物料描述默认
	public static final String CARGO_DESC_DEF = "服务器及配件";
	// gates
	public static final String GATES_ADDRESS = "吴中区苏州工业园区";//该地址的始发站固定为昆山站，取件地固定为昆山
	public static final String GATES_PICKUP_ADDRESS = "昆山";
	public static final int GATES_ORIGSTATION_ID = 32;//昆山站
	// h3c
	public static final String H3C_N1_BT1 = "新华三技术有限公司";
	public static final String H3C_N1_BT2 = "紫光华山科技有限公司";
	public static final String H3C_N1_BT3 = "紫光华山信息技术有限公司";
	public static final String H3C_BT1_PROJECTCODE="A06343";
	public static final String H3C_BT2_PROJECTCODE="A08134";
	public static final String H3C_BT3_PROJECTCODE="A08134";
	//腾讯变更单20191023
	public static final String TX_PARTICULARINSTRUCTION = "发货类型:{0}，物流级别:{1}。";
	//festo20191121--三字码解析报警提示
	public static final String FESTO_ALARM_MSG  = "分单{0}的目的站为百度解析";
	//dell20200409 --分单修改接口 允许修改项目号：A00007,A00012,A06645
	public static final List<String> DELL_PROJECT_LIST = Arrays.asList("A00007","A00012","A06645");
	//tencent
	public static final String TX_PAYMENT_TYPE1 = "UNIFIED_SETTLEMENT";
	public static final String TX_PAYMENT_TYPE2 = "SENDER_PAY";
	public static final String TX_PAYMENT_TYPE3 = "RECEIVER_PAY";
	public static String getDeliveryStatusName(int etype) {
		String name = "";
		switch (etype) {
		case 1:
			name = "PENDING";
			break;
		case 2:
			name = "POD";
			break;
		case 3:
			name = "EXPOD";
			break;
		case 4:
			name = "FAIL";
			break;
		case 5:
			name = "PENDING";
			break;
		default:
			name = "PENDING";
			break;
		}
		return name;
	}
	
	private static Map<String, String> sonyProject(){
		Map<String, String> map = new HashMap<String, String>();
		//送新-取旧
		map.put("ET0157", "ET0204");
		map.put("ET0192", "ET0198");
		return map;
	}

	public static String getDeliveryType(String refno) {
		String type = "";
		if("A".equals(refno)) {
			type = "标准快递";
		}else if("B".equals(refno)) {
			type = "经济快递";
		}else if("C".equals(refno)) {
			type = "普达";
		}else if("D".equals(refno)) {
			type = "整车";
		}
		return type;
	}
}
