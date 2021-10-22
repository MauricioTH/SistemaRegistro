/*
 * MailServiceInDTO
 *  
 * GSI - Integración
 * Creado el: 28/10/2014
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 * 
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
package co.edu.unbosque.mail.dto;

import java.io.File;
import java.util.List;
import java.util.Map;

import co.edu.unbosque.mail.MailTypeEnum;

/**
 * DTO con la información de entrada para enviar el correo.
 *
 * @author Mauricio Tascon
 * @version 1.0 01/10/2017
 * @since 1.0
 */
public class MailServiceInDTO {

	/** email del cual procede el correo */
	private String from;
	
	/** Lista de email a quien se enviara el correo */
	private String[] to;
	
	/** Lista de email para enviar copia */
	private String[] cc;
	
	/** Lista de email para enviar copia oculta */
	private String[] bcc;
	
	/** Asunto del correo */
	private String subject;
	
	/** Argumentos para insertar en el mensaje */
	private Map<String, String> args;
	
	/** Lista de archivo a adjuntar a mensaje */
	private List<File> attachmentList;
	
	private MailTypeEnum mailTypeEnum; 

	public MailServiceInDTO() {
		super();
	}

	/**
	 * Método encargado de recuperar el valor del atributo from.
	 * @return El atributo from asociado a la clase.
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Método encargado de actualizar el atributo from.
	 * @param from Nuevo valor para from.
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Método encargado de recuperar el valor del atributo to.
	 * @return El atributo to asociado a la clase.
	 */
	public String[] getTo() {
		return to;
	}

	/**
	 * Método encargado de actualizar el atributo to.
	 * @param to Nuevo valor para to.
	 */
	public void setTo(String[] to) {
		this.to = to;
	}

	/**
	 * Método encargado de actualizar el atributo to.
	 * @param to Nuevo valor para to.
	 */
	public void setTo(String to) {
		this.to = new String[]{to};
	}
	
	/**
	 * Método encargado de recuperar el valor del atributo cc.
	 * @return El atributo cc asociado a la clase.
	 */
	public String[] getCc() {
		return cc;
	}

	/**
	 * Método encargado de actualizar el atributo cc.
	 * @param cc Nuevo valor para cc.
	 */
	public void setCc(String[] cc) {
		this.cc = cc;
	}

	/**
	 * Método encargado de recuperar el valor del atributo bcc.
	 * @return El atributo bcc asociado a la clase.
	 */
	public String[] getBcc() {
		return bcc;
	}

	/**
	 * Método encargado de actualizar el atributo bcc.
	 * @param bcc Nuevo valor para bcc.
	 */
	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

	/**
	 * Método encargado de recuperar el valor del atributo subject.
	 * @return El atributo subject asociado a la clase.
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Método encargado de actualizar el atributo subject.
	 * @param subject Nuevo valor para subject.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Método encargado de recuperar el valor del atributo args.
	 * @return El atributo args asociado a la clase.
	 */
	public Map<String, String> getArgs() {
		return args;
	}

	/**
	 * Método encargado de actualizar el atributo args.
	 * @param args Nuevo valor para args.
	 */
	public void setArgs(Map<String, String> args) {
		this.args = args;
	}

	/**
	 * Método encargado de recuperar el valor del atributo attachmentList.
	 * @return El atributo attachmentList asociado a la clase.
	 */
	public List<File> getAttachmentList() {
		return attachmentList;
	}

	/**
	 * Método encargado de actualizar el atributo attachmentList.
	 * @param attachmentList Nuevo valor para attachmentList.
	 */
	public void setAttachmentList(List<File> attachmentList) {
		this.attachmentList = attachmentList;
	}

	/**
	 * Método encargado de recuperar el valor del atributo mailTypeEnum.
	 * @return El atributo mailTypeEnum asociado a la clase.
	 */
	public MailTypeEnum getMailTypeEnum() {
		return mailTypeEnum;
	}

	/**
	 * Método encargado de actualizar el atributo mailTypeEnum.
	 * @param mailTypeEnum Nuevo valor para mailTypeEnum.
	 */
	public void setMailTypeEnum(MailTypeEnum mailTypeEnum) {
		this.mailTypeEnum = mailTypeEnum;
	}
}
