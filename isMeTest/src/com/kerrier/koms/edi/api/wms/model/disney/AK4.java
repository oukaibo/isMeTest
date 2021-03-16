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

/**
 * EDI 997, AK4: Data Element Note, optional
 * 
 * @author hd
 * 
 */
public class AK4 implements Serializable, EDIWritable{
	private static final long serialVersionUID = 1L;
	
	private String count; // AK401-1 identifies the data element or composite data structure in error with its numerical count
	private String number; // AK402 is optional and identifies the simple X12 data element number of the element in error. For example, NM101 is simple X12 data element number 98.
	private String error; // AK403 is mandatory and reports the error of the identified element.
	private String copy; // AK404 is optional, and contains a copy of the identified data element in error. AK404 is not used if the error indicates an invalid character.

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getCopy() {
		return copy;
	}

	public void setCopy(String copy) {
		this.copy = copy;
	}

	public void write(Writer writer, Delimiters delimiters) throws IOException {
		Writer nodeWriter = new StringWriter();
        List<String> nodeTokens = new ArrayList<String>();
        
        nodeWriter.write("AK4");        
        nodeWriter.write(delimiters.getField());
        
        if(count != null){
        	nodeWriter.write(delimiters.escape(count));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(number!= null){
        	nodeWriter.write(delimiters.escape(number));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(error!= null){
        	nodeWriter.write(delimiters.escape(error));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
       
        nodeWriter.write(delimiters.getField());
        if(copy!= null){
        	nodeWriter.write(delimiters.escape(copy));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeTokens.add(nodeWriter.toString());

        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
        writer.write(delimiters.getSegment());
        writer.flush();		
	}
}
