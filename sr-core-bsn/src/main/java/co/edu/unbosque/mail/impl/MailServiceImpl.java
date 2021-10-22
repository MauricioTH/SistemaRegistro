/*
 * PgwMailService
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
package co.edu.unbosque.mail.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import co.edu.unbosque.mail.IllegalLineSizeException;
import co.edu.unbosque.mail.MailTypeEnum;
import co.edu.unbosque.mail.dto.MailServiceInDTO;

/**
 * Implementación por defecto del envío de correo.
 *
 * @author Mauricio Tascon
 * @version 1.0 01/10/2017
 * @since 1.0
 */
@Service
public class MailServiceImpl {
	
	/**
	 * Tamaño máximo de la línea que podrá ser procesada al cargar una
	 * plantilla de correo
	 */
	private static final int MAX_STR_LEN = 300;
	
	private Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	
	@Value("${sd.mail.from}")
	private String from;
	
	@Value("${sd.mail.encoding:UTF-8}")
    private String encoding;
	
	@Value("${sd.mail.template.path}")
    private String mailTemplatePath;
	
	@Resource
	private Environment environment;
	
	private JavaMailSender javaMailSender;
	
	/**
	 * Constructor por defecto del servicio de mail.
	 */
	public MailServiceImpl() {
		super();
	}
	
	/**
	 * Método que inicializa la configuración del servicio de email.
	 */
	@PostConstruct
	public void init() {
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		mailSenderImpl.setHost(environment.getProperty("mail.host"));
		mailSenderImpl.setPort(environment.getProperty("mail.port", Integer.class));
		mailSenderImpl.setUsername(environment.getProperty("mail.smtp.user"));
		mailSenderImpl.setPassword(environment.getProperty("mail.smtp.password"));
		mailSenderImpl.setJavaMailProperties(getMailProperties());
		javaMailSender = mailSenderImpl;
	}
	
	/**
	 * Obtiene las propiedades adicionales para el servicio de email. 
	 * @return Propiedades adicionales para la conexion de email.
	 */	
	private Properties getMailProperties() {
		Properties mailProperties = new Properties();
		if(environment.containsProperty("mail.smtp.auth")){
			mailProperties.put("mail.smtp.auth", environment.getProperty("mail.smtp.auth"));
		}
		if(environment.containsProperty("mail.transport.protocol")){
			mailProperties.put("mail.transport.protocol", environment.getProperty("mail.transport.protocol"));
		}
		if(environment.containsProperty("mail.smtp.starttls.enable")){
			mailProperties.put("mail.smtp.starttls.enable", environment.getProperty("mail.smtp.starttls.enable"));
		}
		if(environment.containsProperty("mail.debug")){
			mailProperties.put("mail.debug", environment.getProperty("mail.debug"));
		}
        return mailProperties;
	}
	
	
	public void send(MailServiceInDTO inDTO, int tipoMsn) throws Exception {
		MailTypeEnum mailType = MailTypeEnum.CONFIRMATION_PLAIN_TEXT;
		mailType = inDTO.getMailTypeEnum();
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, encoding);
		helper.setFrom((inDTO.getFrom() != null)? inDTO.getFrom(): from);
		helper.setTo(inDTO.getTo());
		if(inDTO.getCc() != null){
			helper.setCc(inDTO.getCc());
		}
		if(inDTO.getBcc() != null){
			helper.setBcc(inDTO.getBcc());
		}
		helper.setSubject(replaceArgs(inDTO.getSubject(), inDTO.getArgs()));
		helper.setText(getMessageText(inDTO.getArgs(), tipoMsn, mailType), mailType.isHTML());

		// Adjuntar archivos al correo
		if(inDTO.getAttachmentList() != null){
			for(File file : inDTO.getAttachmentList()){
				helper.addAttachment(file.getName(), file);
			}
		}
		// Envía el email
		javaMailSender.send(message);
	}
	
	/**
	 * Realiza el formateo del texto enviado con los parametros segun el 
	 * tipo de mensaje 1=normal, 2=consolidado. 
	 * @param text 
	 * @param args
	 * @return
	 */
	private String getMessageText(Map<String, String> args, int tipoMsn, MailTypeEnum mailType) {
		String text = "";
		try{
			if(tipoMsn == 1){
				text = readFile(mailTemplatePath , mailType.getTemplate());
			}else{
				text = readFileCompuesto(mailTemplatePath , mailType.getTemplate(), args);
			}
		} catch(IOException ex) {
			logger.error("No fue posible cargar el template de email {} en la ruta {}", 
					mailType.getTemplate(), mailTemplatePath);
		}
		return replaceArgs(text, args);
	}
	
	/**
	 * Método encargado de reemplazar los argumentos en una cadena de texto dada.
	 * @param text Cadena de texto.
	 * @param args Argumentos a remplazar.
	 * @return Cadena de texto procesada.
	 */
	private String replaceArgs(String text, Map<String, String> args) {
		if (args != null && text != null) {
			Set<String> keySet = args.keySet();
			for (String key : keySet) {
				String value = args.get(key) != null ? args.get(key): "";
				text = text.replaceAll("\\{\\{[ ]*" + key + "[ ]*\\}\\}",
						Matcher.quoteReplacement(value));
			}
		}
		return text;
	}
	
	/**
	 * Método encargado leer un archivo como String.
	 * @param path Ruta del archivo.
	 * @param fileName Nombre del archivo.
	 * @return String con el contenido del archivo.
	 * @throws IOException
	 */
	private String readFileCompuesto(String path, String fileName, Map<String, String> map)  {
		StringBuilder sb = new StringBuilder();
		File file = new File(path, fileName);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String ls = System.getProperty("line.separator");
			String line = br.readLine();
			while (line != null) {
				if (line.length() > MAX_STR_LEN) {
					br.close();
					throw new IllegalLineSizeException("Tamano ilegal en alguna linea de la plantilla");
				}
				sb.append(line);
				if (line.equals("<!--inicia la tabla adiconal-->")) {
					sb.append(completarTablaMail(map));
				}
				sb.append(ls);
				line = br.readLine();
			}
		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		} finally {
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					logger.error("Error: " + e.getMessage());
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 *  Metodo que mapea los estados del mensaje consolidado de 
	 *  transacciones en una tabla HTML. 
	 * @param map
	 * @return
	 */
	private String completarTablaMail(Map<String, String> map) {
		StringBuilder text = new StringBuilder();
		String ls = System.getProperty("line.separator");
		text.append(ls);
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			if(!key.equals("imageRepoURL")){
				text.append("<tr><td>&nbsp;</td>");
				text.append(ls);
				text.append("<td style=\"color:#336699; font-size:12px;\">" + key + "</td>");
				text.append(ls);
				text.append("<td>&nbsp;</td>");
				text.append(ls);
				text.append("<td style=\"color:#336699; font-size:12px;\">{{ " + key + " }}</td>");
				text.append(ls);
				text.append("<td>&nbsp;</td>");
				text.append(ls);
				text.append("</tr>");
				text.append(ls);
			}	
		}
		text.append("<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>" +
					"<td>&nbsp;</td><td>&nbsp;</td></tr>");
		return text.toString();

	}

	/**
	 * Método encargado leer un archivo como String.
	 * @param path Ruta del archivo.
	 * @param fileName Nombre del archivo.
	 * @return String con el contenido del archivo.
	 * @throws IOException
	 */
	private String readFile(String path, String fileName) throws IOException {
		StringBuilder sb = new StringBuilder();
		File file = new File(path, fileName);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String ls = System.getProperty("line.separator");
			String line = br.readLine();
			while (line != null) {
				if (line.length() > MAX_STR_LEN) {
					br.close();
					throw new IllegalLineSizeException("Tamano ilegal en alguna linea de la plantilla");
				}
				sb.append(line);
				sb.append(ls);
				line = br.readLine();
			}

		} catch (IOException e) {
			logger.error("Error: " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error("Error: " + e.getMessage());
				}
			}
		}
		return sb.toString();
	}

}
