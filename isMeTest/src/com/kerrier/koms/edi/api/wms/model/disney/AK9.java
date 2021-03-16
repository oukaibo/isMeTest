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
 * EDI 997, AK9: Functional Group Response Trailer
 * @author hd
 *
 */
public class AK9 implements Serializable, EDIWritable{
	private static final long serialVersionUID = 1L;
	
	private String code901; // AK901 is mandatory and specifies whether the functional group identified in AK1 is accepted or rejected.
	private String code902; // AK902 specifies the number of transaction sets included in the identified functional group trailer (GE01).
	private String code903; // AK903 specifies the number of transaction sets received.
	private String code904; // AK904 specifies the number of transaction sets accepted in the identified functional group.
	private String code905; // AK905 is error code.
	private String code906; // AK906 is error code.
	private String code907; // AK907 is error code.
	private String code908; // AK908 is error code.
	private String code909; // AK909 is error code.

	public String getCode901() {
		return code901;
	}

	public void setCode901(String code901) {
		this.code901 = code901;
	}

	public String getCode902() {
		return code902;
	}

	public void setCode902(String code902) {
		this.code902 = code902;
	}

	public String getCode903() {
		return code903;
	}

	public void setCode903(String code903) {
		this.code903 = code903;
	}

	public String getCode904() {
		return code904;
	}

	public void setCode904(String code904) {
		this.code904 = code904;
	}

	public String getCode905() {
		return code905;
	}

	public void setCode905(String code905) {
		this.code905 = code905;
	}

	public String getCode906() {
		return code906;
	}

	public void setCode906(String code906) {
		this.code906 = code906;
	}

	public String getCode907() {
		return code907;
	}

	public void setCode907(String code907) {
		this.code907 = code907;
	}

	public String getCode908() {
		return code908;
	}

	public void setCode908(String code908) {
		this.code908 = code908;
	}

	public String getCode909() {
		return code909;
	}

	public void setCode909(String code909) {
		this.code909 = code909;
	}

	public void write(Writer writer, Delimiters delimiters) throws IOException {
		Writer nodeWriter = new StringWriter();
        List<String> nodeTokens = new ArrayList<String>();
        
        nodeWriter.write("AK9");        
        nodeWriter.write(delimiters.getField());
        
        if(code901 != null){
        	nodeWriter.write(delimiters.escape(code901));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code902!= null){
        	nodeWriter.write(delimiters.escape(code902));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code903!= null){
        	nodeWriter.write(delimiters.escape(code903));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
       
        nodeWriter.write(delimiters.getField());
        if(code904!= null){
        	nodeWriter.write(delimiters.escape(code904));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code905!= null){
        	nodeWriter.write(delimiters.escape(code905));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code906!= null){
        	nodeWriter.write(delimiters.escape(code906));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code907!= null){
        	nodeWriter.write(delimiters.escape(code907));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code908!= null){
        	nodeWriter.write(delimiters.escape(code908));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code909!= null){
        	nodeWriter.write(delimiters.escape(code909));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeTokens.add(nodeWriter.toString());

        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
        writer.write(delimiters.getSegment());
        writer.flush();		
	}

}
