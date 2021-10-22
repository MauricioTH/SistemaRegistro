/*
 * MailService
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

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

/**
 * Class description goes here...
 *
 * @author Mauricio Tascon 
 * @version 1.0 01/10/2017
 * @since 1.0
 */
public interface MailService {
	
	public void send(String from, String to, String subject, String text, Map<String, String> args) throws MessagingException;
	public void send(String to, String subject, String text, Map<String, String> args) throws MessagingException;
	public void send(String[] to, String subject, String text, Map<String, String> args) throws MessagingException;
	
	public void send(String from, String[] to, String[] cc, String[] bcc, String subject, String text, Map<String, String> args, List<File> attachmentList) throws MessagingException;
}
