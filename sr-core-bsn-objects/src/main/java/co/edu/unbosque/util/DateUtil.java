package co.edu.unbosque.util;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utilidades de conversión para fechas
 * @author proveedor_cjmurillo
 * @version 1.0
 * @since 1.0
 */
public class DateUtil {

	static Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
	
	/**
	 * Convierte de Date a XMLGregorianCalendar
	 * @param inn
	 * @return
	 */
    public static XMLGregorianCalendar toXMLGregorianCalendar(Date inn){
    	if(inn == null) { return null; }
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(inn);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            LOGGER.error("Error conviertiendo valores.",ex);
        }
        return xmlCalendar;
    }
  
   
    /**
     * Convierte de XMLGregorianCalendar a Date
     * @param inn
     * @return
     */
    public static Date toDate(XMLGregorianCalendar inn){
        if(inn == null) { return null; }
        return inn.toGregorianCalendar().getTime();
    }
	
	
}
