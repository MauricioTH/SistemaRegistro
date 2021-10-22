/*
 * PropertiesResourceBundleManager
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

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Implementa las funcionalidades de {@link ResourceBundleManager} usando 
 * archivos de propiedades (.properties)
 * @author proveedor_zagarcia
 * @version 1.0
 * @since 1.0
 */
public class PropertiesResourceBundleManager implements ResourceBundleManager {

	/**
	 * Tipo de Bundle actual
	 */
	private BundleType bundleType;

	/**
	 * Formateador de texto
	 */
	private MessageFormat formatter;

	/**
	 * Constructor de {@link PropertiesResourceBundleManager}
	 */
	public PropertiesResourceBundleManager(){
		//Por defecto el Bundle es el de mensajes
		bundleType = BundleType.MESSAGES;
		formatter = new MessageFormat("");
	}

	@Override
	public void setBundle(BundleType bundleType) {
		this.bundleType = bundleType;
	}

	@Override
	public String getMessage(String key, Object[] args, Locale locale) {
		synchronized (formatter) {
			ResourceBundle rBundle = 
					ResourceBundle.getBundle(bundleType.toString(), locale);
			formatter.setLocale(locale);
			try {
				formatter.applyPattern(rBundle.getString(key));
			} catch (MissingResourceException e) {
				formatter.applyPattern(rBundle.getString(BundleKeys.ERROR_UNKNOWN_KEY));
			}

			return formatter.format(args);
		}

	}

}
