/*
 * BundleType
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

/**
 * Enumeración que representa los tipos de BUndle que maneja el sistema
 * @author proveedor_zagarcia
 * @version 1.0
 * @since 1.0
 */
public enum BundleType {
	
	/**
	 * Bundle de mensajes
	 */
	MESSAGES("co.edu.unbosque.bundles.i18n.messages.Messages"),
	
	/**
	 * Bundle de errores	
	 */
	ERRORS("co.edu.unbosque.bundles.i18n.messages.Errors");

	/**
	 * Nombre del Bundle
	 */
    private String bundleName; 
    
    /**
     * Constructor del Enum Bundle Type
     * @param bundleName
     */
    BundleType(String bundleName) {
        this.bundleName = bundleName;
    }
  
    @Override
    public String toString() {
        return bundleName;
    }

}
