package testmain;

import com.kerrier.koms.edi.api.wms.model.disney.EDI204;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.milyn.payload.JavaResult;
import util.EDICommonUtil;
import util.FileHelper;

import java.io.File;

/**
 * @author 壮哥
 * @version V1.0
 * @date 2020/4/20
 **/
public class TestGetEDI {
    protected static Logger logger = Logger.getLogger(FileHelper.class);

    @Test
    public void test3() {
        System.out.println("111");
        createDisneyWaybill();
    }
    /**
     * 保存分单信息
     　* @Description 保存分单信息
     　* @return void
     　* @exception
     　* @author chen
     　* @date 2018年10月22日
     */
    public void createDisneyWaybill(){
        // 保存数据
        try {
            logger.info("开始");
            File file = new File("E:\\Intellij work space\\isMeTest\\test\\128file4");
            boolean flag = true;
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files.length > 0) {
                    for (int count = 0; count < files.length; count++) {
                        File f = files[count];
                        String fileNameStr = f.getName();
                        String fileName = f.getAbsolutePath();
                        try{
                            JavaResult obj = EDICommonUtil.analysisEDI214(f, "edixml/smooks-204-config.xml");
                            EDI204 edi204 = null;
                            if(obj!=null){
                                edi204 = (EDI204) obj.getBean("edi204");
                            }
                            if (edi204 == null) {
                                logger.error("没有拿到204文件");
                            }
                        }catch (Exception e){
                            logger.error("解析异常了");
                        }finally{
                            logger.info("文件执行结束");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.info("最终结束");
        }
    }

}
