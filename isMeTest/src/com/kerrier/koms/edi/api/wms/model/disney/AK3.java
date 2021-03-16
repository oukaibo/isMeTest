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
 * EDI 997, AK3: Data Segment Note, optional
 * 
 * @author hd
 * 
 */
public class AK3 implements Serializable, EDIWritable{
	private static final long serialVersionUID = 1L;
	
	private String id; // AK301 identifies the segment in error with its X12 segment ID, for example, NM1
	private String count; // AK302 is the segment count of the segment in error. The ST segment is "1" and each segment increments the segment count by one
	// contains LS,LE ???
	private String version; // AK303 identifies a bounded loop: a loop surrounded by an LS segment and a LE segment. AK303 contains the values of the LS and LE segments that bound the segment in error
	private String code; // AK304 is the error code for the error in the data segment. AK304 is optional, but is required if an error exists for the identified segment. For a list of the AK304 error codes, see X12 997 Acknowledgment Error Codes.

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void write(Writer writer, Delimiters delimiters) throws IOException {
		Writer nodeWriter = new StringWriter();
        List<String> nodeTokens = new ArrayList<String>();
        
        nodeWriter.write("AK3");        
        nodeWriter.write(delimiters.getField());
        
        if(id != null){
        	nodeWriter.write(delimiters.escape(id));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(count!= null){
        	nodeWriter.write(delimiters.escape(count));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(version!= null){
        	nodeWriter.write(delimiters.escape(version));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code!= null){
        	nodeWriter.write(delimiters.escape(code));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
       
        nodeTokens.add(nodeWriter.toString());

        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
        writer.write(delimiters.getSegment());
        writer.flush();		
	}

}
