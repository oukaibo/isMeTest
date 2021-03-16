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


public class SE implements Serializable, EDIWritable{
	private static final long serialVersionUID = 1L;
	
	private String numberOfIncludedSegment;
	private String transactionSetControlNumber;
	
	public String getNumberOfIncludedSegment() {
		return numberOfIncludedSegment;
	}
	public void setNumberOfIncludedSegment(String numberOfIncludedSegment) {
		this.numberOfIncludedSegment = numberOfIncludedSegment;
	}
	public String getTransactionSetControlNumber() {
		return transactionSetControlNumber;
	}
	public void setTransactionSetControlNumber(String transactionSetControlNumber) {
		this.transactionSetControlNumber = transactionSetControlNumber;
	}

	public void write(Writer writer, Delimiters delimiters) throws IOException {
		Writer nodeWriter = new StringWriter();
        List<String> nodeTokens = new ArrayList<String>();
        
        nodeWriter.write("SE");        
        nodeWriter.write(delimiters.getField());
        
        if(numberOfIncludedSegment != null){
        	nodeWriter.write(delimiters.escape(numberOfIncludedSegment));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(transactionSetControlNumber != null){
        	nodeWriter.write(delimiters.escape(transactionSetControlNumber));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
       
        nodeTokens.add(nodeWriter.toString());

        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
        writer.write(delimiters.getSegment());
        writer.flush();		
	}
	
	
}
