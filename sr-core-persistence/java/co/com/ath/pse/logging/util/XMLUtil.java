package co.com.ath.pse.logging.util;


import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Convertidor entre objeto y xml
 * @author proveedor_cjmurillo
 * @version 1.0
 * @since 1.0
 */
public class XMLUtil<T> {
	
	static Logger LOGGER = LoggerFactory.getLogger(XMLUtil.class);
	
	
	/**
	 * Convierte un objeto a XML
	 * @param type objeto a convertir
	 * @return cadena en formato xml del objeto
	 */
	public String convertObjectToXml(T type) {
		try {
			StringWriter sw = new StringWriter();
			JAXBContext jc = JAXBContext.newInstance(type.getClass());
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); //Formatear el XML o mostrarlo en una sola linea
			m.setProperty(Marshaller.JAXB_FRAGMENT, true);
			m.marshal(type, sw);
			return sw.toString();
		} catch (JAXBException e) {
			LOGGER.warn("Error al convertir objeto a xml: ["+type.getClass().getName()+"]", e);
			return null;
		}
	}
	
}
