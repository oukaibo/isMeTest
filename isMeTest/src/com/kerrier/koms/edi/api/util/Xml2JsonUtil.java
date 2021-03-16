package com.kerrier.koms.edi.api.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Xml2JsonUtil {

	private static JAXBContext jaxbContext;
	
	/**
	 * Xml->Java Object, 支持大小写敏感或不敏感.
	 * @param caseSensitive:默认为true
	 */
	@SuppressWarnings("unchecked")
	public static <T> T fromXml(String data, boolean caseSensitive,Class<?>... types) {
		try {
			String fromXml = data;
			if (!caseSensitive)
				fromXml = data.toLowerCase();
			StringReader reader = new StringReader(fromXml);
			jaxbContext = JAXBContext.newInstance(types);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			return  (T) unmarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Java Object->Xml
	 */
	public static String toXml(Object obj){
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
			 Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			 StringWriter writer = new StringWriter();
			 jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     jaxbMarshaller.marshal(obj, writer);
		     String result = writer.toString();
		     return result;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
