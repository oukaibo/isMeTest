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


public class IEA implements Serializable, EDIWritable{
	private static final long serialVersionUID = 1L;
	
	private String groupNumber;
	private String interchangeControlNumebr;//流水号
	public String getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}
	public String getInterchangeControlNumebr() {
		return interchangeControlNumebr;
	}
	public void setInterchangeControlNumebr(String interchangeControlNumebr) {
		this.interchangeControlNumebr = interchangeControlNumebr;
	}

	public void write(Writer writer, Delimiters delimiters) throws IOException {
		Writer nodeWriter = new StringWriter();
        List<String> nodeTokens = new ArrayList<String>();
        
        nodeWriter.write("IEA");        
        nodeWriter.write(delimiters.getField());
        
        if(groupNumber != null){
        	nodeWriter.write(delimiters.escape(groupNumber));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(interchangeControlNumebr != null){
        	nodeWriter.write(delimiters.escape(interchangeControlNumebr));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
       
        nodeTokens.add(nodeWriter.toString());

        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
        writer.write(delimiters.getSegment());
        writer.flush();		
	}
	
}
