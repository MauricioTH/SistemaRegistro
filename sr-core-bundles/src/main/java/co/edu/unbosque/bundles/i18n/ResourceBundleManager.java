/*
 * ResourceBundleManager
 *
 * GSI - Integración
 * Creado el: 22 de agosto de 2014
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 *
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
package co.edu.unbosque.bundles.i18n;

import java.util.Locale;

import co.edu.unbosque.bundles.i18n.BundleType;

/**
 * Gestor de Mensajes de internacionalización y localización
 * @author proveedor_zagarcia
 * @version 1.0
 * @since 1.0
 */
public interface ResourceBundleManager {
	
	/**
	 * Establece el tipo de Bundle de donde se recuperará el mensaje
	 * @param bundleType Tipo de Bundle deseado
	 */
	void setBundle(BundleType bundleType);
	
	/**
	 * Obtiene el mensaje del bundle de acuerdo a la clave y localización.
	 * @param key LLave del mensaje deseado
	 * @param args Argumentos del mensaje
	 * @param locale Información de región geográfica, política o cultural.
	 * @return Mensaje seleccionado del bundle
	 */
	String getMessage(String key, Object[] args, Locale locale);

}
