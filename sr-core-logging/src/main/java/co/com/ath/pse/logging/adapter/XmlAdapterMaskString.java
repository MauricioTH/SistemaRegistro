/*
 * XmlAdapterMaskString
 *  
 * GSI - Integración
 * Creado: Septiembre 2014
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 * 
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
package co.com.ath.pse.logging.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import co.com.ath.pse.logging.constants.LoggingConstants;

/**
 * Adaptador para  XMLElement de tipo String
 * @author Mauricio Tascon
 * @version 1.0
 * @since 1.0
 */
public class XmlAdapterMaskString extends XmlAdapter<String, String> {

	/**
	 * Esnascara los primeros N dígitos del campo remplazandolos por el parametro
	 */
	@Override
	public String marshal(String v) {
		if(LoggingConstants.MASK_XML_ELEMENT){
			int vSize = v.length();
			v = v.substring(vSize - LoggingConstants.LAST_CHART_MASK_SHOW);
			
			for (int i = LoggingConstants.LAST_CHART_MASK_SHOW; i < vSize; i++) {
				v = LoggingConstants.MASK_CHART + v;
			}
		}
		return v;
	}
	
	
	@Override
	public String unmarshal(String v) {
		return v;
	}


}

