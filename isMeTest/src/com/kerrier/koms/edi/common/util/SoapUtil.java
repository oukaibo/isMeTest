package com.kerrier.koms.edi.common.util;

import java.io.ByteArrayInputStream;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPMessage;

public class SoapUtil {
	/*
	 private static SOAPMessage formatSoapString(String soapString) {
        MessageFactory msgFactory;
       try {
            msgFactory = MessageFactory.newInstance();
            SOAPMessage reqMsg = msgFactory.createMessage(new MimeHeaders(),
                    new ByteArrayInputStream(soapString.getBytes("UTF-8")));
            reqMsg.saveChanges();
            return reqMsg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/
	 
	public static String formatSoapString(String soapString) {
        MessageFactory msgFactory;
       try {
            msgFactory = MessageFactory.newInstance();
            SOAPMessage reqMsg = msgFactory.createMessage(new MimeHeaders(),
                    new ByteArrayInputStream(soapString.getBytes("UTF-8")));
            reqMsg.saveChanges();
            return reqMsg.getSOAPBody().getTextContent();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
