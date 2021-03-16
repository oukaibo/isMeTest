package com.kerrier.koms.edi.api.wms.model.disney;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.milyn.edisax.model.internal.DelimiterType;
import org.milyn.edisax.model.internal.Delimiters;
import org.milyn.edisax.util.EDIUtils;
import org.milyn.smooks.edi.EDIWritable;


public class GE implements Serializable, EDIWritable{
	private static final long serialVersionUID = 1L;
	
	private String totalTransactionNumber; //事务集总和，即共有多少ST-SE
	private String groupControlNumber; //流水号，无需补位
	public String getTotalTransactionNumber() {
		return totalTransactionNumber;
	}
	public void setTotalTransactionNumber(String totalTransactionNumber) {
		this.totalTransactionNumber = totalTransactionNumber;
	}
	public String getGroupControlNumber() {
		return groupControlNumber;
	}
	public void setGroupControlNumber(String groupControlNumber) {
		this.groupControlNumber = groupControlNumber;
	}

	public void write(Writer writer, Delimiters delimiters) throws IOException {
		Writer nodeWriter = new StringWriter();
        List<String> nodeTokens = new ArrayList<String>();
        
        nodeWriter.write("GE");        
        nodeWriter.write(delimiters.getField());
        
        if(totalTransactionNumber != null){
        	nodeWriter.write(delimiters.escape(totalTransactionNumber));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(groupControlNumber != null){
        	nodeWriter.write(delimiters.escape(groupControlNumber));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
       
        nodeTokens.add(nodeWriter.toString());

        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
        writer.write(delimiters.getSegment());
        writer.flush();		
	}
	

}
