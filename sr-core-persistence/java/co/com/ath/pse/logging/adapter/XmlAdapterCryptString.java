/*
 * XmlAdapterCryptString
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
import co.com.ath.pse.logging.util.security.EncryptUtils;

/**
 * Adaptador para  XMLElement de tipo String
 * @author proveedor_cjmurillo
 * @version 1.0
 * @since 1.0
 */
public class XmlAdapterCryptString extends XmlAdapter<String, String> {

	/**
	 * Cifra el campo completo y le agrega una etiqueta al final.
	 */
	@Override
	public String marshal(String v) {
		if(LoggingConstants.CRYPTO_XML_ELEMENT){
			v = EncryptUtils.base64encode(v)+"[CRYPTED]";
		}
		return v;
	}

	@Override
	public String unmarshal(String v) {
		return v;
	}


}