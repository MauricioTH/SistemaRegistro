package co.edu.unbosque.mail.alert;

import co.edu.unbosque.persistence.model.Usuario;

/**
 * Interfaz que define la generalidad para aletar a un Funcionario 
 * @author Mauricio Tascon
 * @version 1.0 01/10/2017
 * @since 1.0
 */
public interface SentAlertMessageInterface {
	
	public void sendMail(Usuario tx)throws Exception;
	
	
}
