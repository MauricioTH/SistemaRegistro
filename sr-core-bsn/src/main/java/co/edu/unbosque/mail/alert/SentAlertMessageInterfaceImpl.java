package co.edu.unbosque.mail.alert;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.edu.unbosque.mail.MailTypeEnum;
import co.edu.unbosque.mail.dto.MailServiceInDTO;
import co.edu.unbosque.mail.impl.MailServiceImpl;
import co.edu.unbosque.persistence.dao.UsuarioDAO;
import co.edu.unbosque.persistence.model.Usuario;
import co.edu.unbosque.util.ErrorCodes;

/**
 * Implementacion de la interfaz SentAlertMessageInterface que envía 
 * mensajes de notificacionloggin con TimeOut. 
 * @author Mauricio Tason
 * @version 1.0 01/10/2017
 * @since 1.0
 */
@Service
public class SentAlertMessageInterfaceImpl extends ErrorCodes implements SentAlertMessageInterface{

	private static Logger LOGGER = LoggerFactory.getLogger(SentAlertMessageInterfaceImpl.class);

	@Value("${sd.mail.template.images.url}")
	private String imageRepoURL;
	
	@Value("${sd.mail.subject.payment.confirmation}")
	private String subjectMsnTx;	
	
	@Value("${sd.mail.to}")
	private String toMSN;	
	
	@Resource
	private MailServiceImpl mailService;
	
	@Resource
	private UsuarioDAO usuarioDAO;
	
	
	
	/**
	 * Método encagado de enviar el correo de notificación al 
	 * al Usuario.
	 * @param tx
	 * @throws Exception 
	 */
	@Override
	public void sendMail(Usuario usuario) throws Exception {
		try {	
			
			   toMSN=usuario.getEmail();
				// Parametros de entrada para enviar el email
				Map<String, String> args = crearCuerpoMensaje(usuario); 
				MailServiceInDTO mailInDTO = new MailServiceInDTO();
				mailInDTO.setTo(toMSN);
				mailInDTO.setSubject(subjectMsnTx);
				mailInDTO.setArgs(args);
				mailInDTO.setMailTypeEnum(MailTypeEnum.CONFIRMATION_HTML);
				mailService.send(mailInDTO, 1);
				usuario.setNotificacionEmail(NOTIFICATION_OK );
				usuarioDAO.update(usuario);
				LOGGER.info("Se envío correo para el usuario:{}", usuario.getIdentificacion());
		} catch (Exception e) {
			LOGGER.info("Fallo al enviar el Correo:{}", usuario.getIdentificacion());
			throw e;
		}
	}
	
	
	
	/**
	 * Metodo generico para crear el cuerpo del mensaje que se envia 
	 * @param tx
	 * @return
	 */
	public Map<String, String> crearCuerpoMensaje(Usuario usuario) {
		Map<String, String> args = null;
		try{
			// Ingresar argumentos que seran remplazados en el mensaje de email
			args = new LinkedHashMap<String, String>();
			args.put("user", usuario.getIdentificacion() != null ? String.valueOf(usuario.getIdentificacion()) : "");
			args.put("password", usuario.getContrasena() != null ? usuario.getContrasena() : "");
			args.put("nombres", usuario.getNombres() != null ? usuario.getNombres(): "");
			args.put("apellidos", usuario.getApellidos() != null ? usuario.getApellidos(): "");
			args.put("transactionDate", usuario.getFechaCreacion() != null ? String.valueOf(usuario.getFechaCreacion()) : "");
			args.put("email", usuario.getEmail() != null ? usuario.getEmail() : "");
			args.put("imageRepoURL", imageRepoURL);
		}catch (Exception e) {
			LOGGER.info("Fallo el metodo: crearCuerpoMensaje(Usuario tx) {}:\n {}",
					usuario.getIdentificacion(), e);
			throw e;
		}
		return args;		
	}
	
	
}
