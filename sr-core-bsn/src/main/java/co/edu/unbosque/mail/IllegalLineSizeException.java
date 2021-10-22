/*
 * IllegalLineSizeException
 *  
 * GSI - Integración
 * Creado el: 17/02/2015
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 * 
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quien represente sus derechos.
 */
package co.edu.unbosque.mail;

/**
 * Excepción lanzada cuando se está leyendo un archivo y el tamaño máximo de
 * línea es superado.
 * @author Mauricio Tascon
 *
 */
public class IllegalLineSizeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalLineSizeException(){
		super();
	}

	public IllegalLineSizeException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalLineSizeException(String message) {
		super(message);
	}

	public IllegalLineSizeException(Throwable cause) {
		super(cause);
	}
	
	
	

}
