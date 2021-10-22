/*
 * PgwMailTypeEnum
 *  
 * GSI - Integración
 * Creado el: 27/10/2014
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 * 
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
package co.edu.unbosque.mail;

/**
 * Describe los tipos de mail que se pueden enviar.
 * 
 * @author Mauricio Tascon
 * @version 1.0 01/10/2017
 * @since 1.0
 */
public enum MailTypeEnum {

	CONFIRMATION_PLAIN_TEXT(false, "generic_confirmation_mail.txt"), 
	CONFIRMATION_HTML(true, "confirmation_mail.html"),
	CONSOLIDADO_HTML(true, "consolidado_mail.html"),
	GENERIC_CONFIRMATION_HTML(true, "generic_confirmation_mail.html");

	private boolean isHTML;
	
	private String template;

	MailTypeEnum(boolean isHTML, String template) {
		this.isHTML = isHTML;
		this.template = template;
	}

	/**
	 * Método encargado de recuperar el valor del atributo isHTML.
	 * 
	 * @return El atributo isHTML asociado a la clase.
	 */
	public boolean isHTML() {
		return isHTML;
	}

	/**
	 * Método encargado de actualizar el atributo isHTML.
	 * 
	 * @param isHTML
	 *            Nuevo valor para isHTML.
	 */
	public void setHTML(boolean isHTML) {
		this.isHTML = isHTML;
	}

	/**
	 * Método encargado de recuperar el valor del atributo template.
	 * @return El atributo template asociado a la clase.
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * Método encargado de actualizar el atributo template.
	 * @param template Nuevo valor para template.
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

}
