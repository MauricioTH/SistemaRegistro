package co.edu.unbosque.batch.notification.email;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import co.edu.unbosque.mail.alert.SentAlertMessageInterface;
import co.edu.unbosque.persistence.dao.UsuarioDAO;
import co.edu.unbosque.persistence.model.Usuario;

@Service
public class NotificationEmailItemWriter implements ItemWriter<Usuario> {
		

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationEmailItemWriter.class);

	
	@Resource
	private UsuarioDAO usuarioDAO;

	@Resource
	private SentAlertMessageInterface sentAlertMessage;

	
	@Override
	public void write(List<? extends Usuario> listUsuarios) {
		LOGGER.info("ENVIO DE CORREO AL USUARIO.");
		if (listUsuarios != null) {
			for (Usuario usuario : listUsuarios) {
				LOGGER.info("Usuario con Identificacion= " + usuario.getIdentificacion() + " se envia la informacio de usuario y contrasena al Correo  ");
				sendEmailNotificationRegistro(usuario);
			}
		}
	
	}
	
	
	
	private void sendEmailNotificationRegistro(Usuario usuario) {
		try {
			LOGGER.info("Envio de correo al usuario...");
			sentAlertMessage.sendMail(usuario);  
			LOGGER.info("Respuesta de envio del correo: " + " ' ");

		} catch (Exception e) {
			LOGGER.error("Se ha presentado un error en el servicio del envio del correo('{}')  {}:\nException:{}\nMessage:{}\nCause:\n{}",
					usuario.getIdentificacion(),  e.toString(), e.getMessage(), e.getCause());
		}
	}
	

}
