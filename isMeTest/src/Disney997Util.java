

import com.kerrier.koms.edi.api.wms.model.disney.*;
import model.SystemConstants;
import util.DateHelper;
import util.FileHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Disney997Util {


	private static final String ISADATE = "yyMMdd";
	private static final String DATEFORMAT = "yyyyMMdd";
	private static final String TIMEFORMAT = "HHmm";

	public EDI997 createEDI997(EDI204 edi204, Date date, Boolean flag) {
		if (edi204 != null ) {

			List<EDI997Item> edi997Items = new ArrayList<EDI997Item>();
			EDI997Item edi997Item = new EDI997Item();
			List<EDI204Item> edi204Items = edi204.getItems();
			List<EDIAKItem> items = new ArrayList<EDIAKItem>();

			ISA isa = edi204.getIsa();
			isa.setInterchangeDate(DateHelper.formatDate(date, ISADATE));
			SimpleDateFormat simleTimeFormat = new SimpleDateFormat(TIMEFORMAT);
			String strTime = simleTimeFormat.format(date);
			isa.setInterchangeTime(strTime);

			GS gs = edi204.getGs();
			gs.setFunctionalIdentifierCode("SM");
			gs.setDate(DateHelper.formatDate(date, DATEFORMAT));
			gs.setTime(DateHelper.formatDate(date, TIMEFORMAT));

			int j = 0;
			ST st = new ST();
			st.setTransactionCode("204");
			st.setTransactionNumber(gs.getAssignNumber()+"0001");
			j++;
			edi997Item.setSt(st);

			AK1 ak1 = new AK1();
			ak1.setId("SM");
			ak1.setNumber(gs.getAssignNumber());
			j++;
			edi997Item.setAk1(ak1);

			if (edi204Items != null && edi204Items.size() > 0) {
				for (int i = 0; i < edi204Items.size(); i++) {
					EDIAKItem ediakItem = new EDIAKItem();
					AK2 ak2 = new AK2();
					ak2.setId("997");
					ak2.setNumber(String.format("%04d", i + 1));
					ediakItem.setAk2(ak2);
					j++;
					AK5 ak5 = new AK5();
					if (flag) {
						ak5.setCode501("A");
					} else {
						ak5.setCode501("R");
					}
					ediakItem.setAk5(ak5);
					j++;
					items.add(ediakItem);
					edi997Item.setItems(items);
				}
			}

			AK9 ak9 = new AK9();
			if (flag) {
				ak9.setCode901("A");
				ak9.setCode902(edi204Items.size() + "");
				ak9.setCode903(edi204Items.size() + "");
				ak9.setCode904(edi204Items.size() + "");
				j++;
			} else {
				ak9.setCode901("R");
				ak9.setCode902(edi204Items.size() + "");
				ak9.setCode903(edi204Items.size() + "");
				ak9.setCode904(edi204Items.size() + "");
				j++;
			}
			edi997Item.setAk9(ak9);

			SE se = new SE();
			se.setNumberOfIncludedSegment(String.valueOf(j));
			se.setTransactionSetControlNumber("0001");
			edi997Item.setSe(se);
			edi997Items.add(edi997Item);

			GE ge = edi204.getGe();
			ge.setTotalTransactionNumber("1");
			IEA iea = edi204.getIea();

			EDI997 edi997 = new EDI997();
			edi997.setIsa(isa);
			edi997.setGs(gs);
			edi997.setItemList(edi997Items);
			edi997.setGe(ge);
			edi997.setIea(iea);
			return edi997;
		}
		return null;
	}


	public String createEdi997File(EDI997 edi997, String fileNameStr, String dir) {
		if (edi997 != null && fileNameStr != null) {
			// 创建997文件夹
			String dirName = SystemConstants.CUSTOMER_LOCAL_PAH.replaceAll("\\{0\\}", dir)+"/"
			               + FileHelper.mkDir("") + "/997/";
			StringWriter ediStream = new StringWriter();
			String fileName = null;
			FileWriter fw = null;
			try {
				edi997.write(ediStream);
				fileName = FileHelper.createFile(dirName) + fileNameStr + ".997"; // 生成997文件名
				fw = new FileWriter(fileName);
				fw.write(ediStream.getBuffer().toString());
				fw.flush();

				return fileName;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fw != null) {
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}


}
