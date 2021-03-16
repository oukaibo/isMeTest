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
 * EDI 997, AK5: Transaction Set Response Trailer
 * @author hd
 *
 */
public class AK5 implements Serializable, EDIWritable{
	private static final long serialVersionUID = 1L;
	
	private String code501; // AK501 specifies whether the identified transaction set is accepted or rejected
	private String code502; // AK502 is error code
	private String code503; // AK503 is error code
	private String code504; // AK504 is error code
	private String code505; // AK505 is error code
	private String code506; // AK506 is error code

	public String getCode501() {
		return code501;
	}

	public void setCode501(String code501) {
		this.code501 = code501;
	}

	public String getCode502() {
		return code502;
	}

	public void setCode502(String code502) {
		this.code502 = code502;
	}

	public String getCode503() {
		return code503;
	}

	public void setCode503(String code503) {
		this.code503 = code503;
	}

	public String getCode504() {
		return code504;
	}

	public void setCode504(String code504) {
		this.code504 = code504;
	}

	public String getCode505() {
		return code505;
	}

	public void setCode505(String code505) {
		this.code505 = code505;
	}

	public String getCode506() {
		return code506;
	}

	public void setCode506(String code506) {
		this.code506 = code506;
	}


	public void write(Writer writer, Delimiters delimiters) throws IOException {
		Writer nodeWriter = new StringWriter();
        List<String> nodeTokens = new ArrayList<String>();
        
        nodeWriter.write("AK5");        
        nodeWriter.write(delimiters.getField());
        
        if(code501!= null){
        	nodeWriter.write(delimiters.escape(code501));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code502!= null){
        	nodeWriter.write(delimiters.escape(code502));
            nodeTokens.add(nodeWriter.toString());
            ((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code503!= null){
        	nodeWriter.write(delimiters.escape(code503));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
       
        nodeWriter.write(delimiters.getField());
        if(code504!= null){
        	nodeWriter.write(delimiters.escape(code504));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code505!= null){
        	nodeWriter.write(delimiters.escape(code505));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeWriter.write(delimiters.getField());
        if(code506!= null){
        	nodeWriter.write(delimiters.escape(code506));
        	nodeTokens.add(nodeWriter.toString());
        	((StringWriter)nodeWriter).getBuffer().setLength(0);
        }
        
        nodeTokens.add(nodeWriter.toString());

        writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
        writer.write(delimiters.getSegment());
        writer.flush();		
	}

}
