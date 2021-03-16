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


public class GS implements Serializable, EDIWritable{
	private static final long serialVersionUID = 1L;
	
	private String functionalIdentifierCode;  //固定值ֵ
	private String senderCode;//固定值ֵ
	private String receiverCode;//固定值ֵ
	private String date;
	private String time;
	private String assignNumber;
	private String responssibleAgencyCode; // 固定值    X12标准委员会
	private String identifierCode;  //版本号
	public String getFunctionalIdentifierCode() {
		return functionalIdentifierCode;
	}
	public void setFunctionalIdentifierCode(String functionalIdentifierCode) {
		this.functionalIdentifierCode = functionalIdentifierCode;
	}
	public String getSenderCode() {
		return senderCode;
	}
	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}
	public String getReceiverCode() {
		return receiverCode;
	}
	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAssignNumber() {
		return assignNumber;
	}
	public void setAssignNumber(String assignNumber) {
		this.assignNumber = assignNumber;
	}
	public String getResponssibleAgencyCode() {
		return responssibleAgencyCode;
	}
	public void setResponssibleAgencyCode(String responssibleAgencyCode) {
		this.responssibleAgencyCode = responssibleAgencyCode;
	}
	public String getIdentifierCode() {
		return identifierCode;
	}
	public void setIdentifierCode(String identifierCode) {
		this.identifierCode = identifierCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void write(Writer writer, Delimiters delimiters) throws IOException {
		Writer nodeWriter = new StringWriter();
        List<String> nodeTokens = new ArrayList<String>();
        
        nodeWriter.write("GS");        
        nodeWriter.write(delimiters.getField());
        
        if(functionalIdentifierCode != null){
        	nodeWriter.write(delimiters.escape(functionalIdentifierCode));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(senderCode != null){
        	nodeWriter.write(delimiters.escape(senderCode));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }

        nodeWriter.write(delimiters.getField());
        if(receiverCode != null){
        	nodeWriter.write(delimiters.escape(receiverCode));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }

        nodeWriter.write(delimiters.getField());
        if(date != null){
        	nodeWriter.write(delimiters.escape(date));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }

        nodeWriter.write(delimiters.getField());
        if(time != null){
        	nodeWriter.write(delimiters.escape(time));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }

        nodeWriter.write(delimiters.getField());
        if(assignNumber != null){
        	nodeWriter.write(delimiters.escape(assignNumber));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(responssibleAgencyCode != null){
        	nodeWriter.write(delimiters.escape(responssibleAgencyCode));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(identifierCode != null){
        	nodeWriter.write(delimiters.escape(identifierCode));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
                
        nodeTokens.add(nodeWriter.toString());

        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
        writer.write(delimiters.getSegment());
        writer.flush();		
	}
}
