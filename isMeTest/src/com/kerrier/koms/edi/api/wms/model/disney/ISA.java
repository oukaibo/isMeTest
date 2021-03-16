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


public class ISA implements Serializable, EDIWritable{
	private static final long serialVersionUID = 1L;
	
	private String authorizationInformationCode; // 固定值
	private String authorizationInformation; // 固定值 长度为10
	private String securityInformationCode;// 固定值?
	private String securityInformation;// 固定值 长度为10
	private String senderStructureCode;// 固定值
	private String senderIdentificationCode;// 固定值 长度为15
	private String receiverStructureCode;// 固定值
	private String receiverIdentificationCode;// 固定值 长度为15
	private String interchangeDate; // 当前日期
	private String interchangeTime; // 当前时间
	private String standardsIdentifierCode; // 固定值
	private String interchangeVersionCode; // 版本号
	private String controlNumber; // 流水号
	private String acknowledgmentRequested; // 固定值
	private String usageIndicatorCode; // 测试环境为T 生产环境为P
	private String compomentElementSeparator;
	public String getAuthorizationInformationCode() {
		return authorizationInformationCode;
	}
	public void setAuthorizationInformationCode(String authorizationInformationCode) {
		this.authorizationInformationCode = authorizationInformationCode;
	}
	public String getAuthorizationInformation() {
		return authorizationInformation;
	}
	public void setAuthorizationInformation(String authorizationInformation) {
		this.authorizationInformation = authorizationInformation;
	}
	public String getSecurityInformationCode() {
		return securityInformationCode;
	}
	public void setSecurityInformationCode(String securityInformationCode) {
		this.securityInformationCode = securityInformationCode;
	}
	public String getSecurityInformation() {
		return securityInformation;
	}
	public void setSecurityInformation(String securityInformation) {
		this.securityInformation = securityInformation;
	}
	public String getSenderStructureCode() {
		return senderStructureCode;
	}
	public void setSenderStructureCode(String senderStructureCode) {
		this.senderStructureCode = senderStructureCode;
	}
	public String getSenderIdentificationCode() {
		return senderIdentificationCode;
	}
	public void setSenderIdentificationCode(String senderIdentificationCode) {
		this.senderIdentificationCode = senderIdentificationCode;
	}
	public String getReceiverStructureCode() {
		return receiverStructureCode;
	}
	public void setReceiverStructureCode(String receiverStructureCode) {
		this.receiverStructureCode = receiverStructureCode;
	}
	public String getReceiverIdentificationCode() {
		return receiverIdentificationCode;
	}
	public void setReceiverIdentificationCode(String receiverIdentificationCode) {
		this.receiverIdentificationCode = receiverIdentificationCode;
	}
	public String getInterchangeDate() {
		return interchangeDate;
	}
	public void setInterchangeDate(String interchangeDate) {
		this.interchangeDate = interchangeDate;
	}
	public String getInterchangeTime() {
		return interchangeTime;
	}
	public void setInterchangeTime(String interchangeTime) {
		this.interchangeTime = interchangeTime;
	}
	public String getStandardsIdentifierCode() {
		return standardsIdentifierCode;
	}
	public void setStandardsIdentifierCode(String standardsIdentifierCode) {
		this.standardsIdentifierCode = standardsIdentifierCode;
	}
	public String getInterchangeVersionCode() {
		return interchangeVersionCode;
	}
	public void setInterchangeVersionCode(String interchangeVersionCode) {
		this.interchangeVersionCode = interchangeVersionCode;
	}
	public String getControlNumber() {
		return controlNumber;
	}
	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}
	public String getAcknowledgmentRequested() {
		return acknowledgmentRequested;
	}
	public void setAcknowledgmentRequested(String acknowledgmentRequested) {
		this.acknowledgmentRequested = acknowledgmentRequested;
	}
	public String getUsageIndicatorCode() {
		return usageIndicatorCode;
	}
	public void setUsageIndicatorCode(String usageIndicatorCode) {
		this.usageIndicatorCode = usageIndicatorCode;
	}
	public String getCompomentElementSeparator() {
		return compomentElementSeparator;
	}
	public void setCompomentElementSeparator(String compomentElementSeparator) {
		this.compomentElementSeparator = compomentElementSeparator;
	}

	public void write(Writer writer, Delimiters delimiters) throws IOException {
		Writer nodeWriter = new StringWriter();
		List<String> nodeTokens = new ArrayList<String>();

		nodeWriter.write("ISA");
		nodeWriter.write(delimiters.getField());

		if (authorizationInformationCode != null) {
			nodeWriter.write(delimiters.escape(authorizationInformationCode));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (authorizationInformation != null) {
			nodeWriter.write(delimiters.escape(authorizationInformation));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (securityInformationCode != null) {
			nodeWriter.write(delimiters.escape(securityInformationCode));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (securityInformation != null) {
			nodeWriter.write(delimiters.escape(securityInformation));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (senderStructureCode != null) {
			nodeWriter.write(delimiters.escape(senderStructureCode));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (senderIdentificationCode != null) {
			nodeWriter.write(delimiters.escape(senderIdentificationCode));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (receiverStructureCode != null) {
			nodeWriter.write(delimiters.escape(receiverStructureCode));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (receiverIdentificationCode != null) {
			nodeWriter.write(delimiters.escape(receiverIdentificationCode));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (interchangeDate != null) {
			
			nodeWriter.write(delimiters.escape(interchangeDate));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (interchangeTime != null) {
			nodeWriter.write(delimiters.escape(interchangeTime));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (standardsIdentifierCode != null) {
			nodeWriter.write(delimiters.escape(standardsIdentifierCode));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (interchangeVersionCode != null) {
			nodeWriter.write(delimiters.escape(interchangeVersionCode));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (controlNumber != null) {
			nodeWriter.write(delimiters.escape(controlNumber));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (acknowledgmentRequested != null) {
			nodeWriter.write(delimiters.escape(acknowledgmentRequested));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (usageIndicatorCode != null) {
			nodeWriter.write(delimiters.escape(usageIndicatorCode));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeWriter.write(delimiters.getField());
		if (compomentElementSeparator != null) {
			nodeWriter.write(delimiters.escape(compomentElementSeparator));
			nodeTokens.add(nodeWriter.toString());
			((StringWriter) nodeWriter).getBuffer().setLength(0);
		}

		nodeTokens.add(nodeWriter.toString());

		writer.write(EDIUtils.concatAndTruncate(nodeTokens, DelimiterType.FIELD, delimiters));
		writer.write(delimiters.getSegment());
		writer.flush();
	}

}
