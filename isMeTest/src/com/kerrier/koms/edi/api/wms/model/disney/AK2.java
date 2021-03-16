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
 * EDI 997, AK2: Transaction Set Response Header, optional
 * 
 * @author hd
 * 
 */
public class AK2 implements Serializable, EDIWritable{
	private static final long serialVersionUID = 1L;
	
	private String id; // AK201 is the transaction set ID (ST01) of the transaction set being acknowledged
	private String number; // AK202 is the transaction set control number (ST02 and SE02) of the transaction set being acknowledged
	private String version; // AK203 is optional and is the EDI implementation version sent in the ST03 of the original transaction. AK203 supports inbound 5010 compliant 997

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber( String number) {
		this.number = number;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void write(Writer writer, Delimiters delimiters) throws IOException {
		Writer nodeWriter = new StringWriter();
        List<String> nodeTokens = new ArrayList<String>();
        
        nodeWriter.write("AK2");        
        nodeWriter.write(delimiters.getField());
        
        if(id != null){
        	nodeWriter.write(delimiters.escape(id));
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
        if(version!= null){
        	nodeWriter.write(delimiters.escape(version));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
       
        nodeTokens.add(nodeWriter.toString());

        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
        writer.write(delimiters.getSegment());
        writer.flush();		
	}

}
