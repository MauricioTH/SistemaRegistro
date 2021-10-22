package co.edu.unbosque.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * Clase que trae todas las propiedades de codigos de error del archivo properties
 *
 * @author Mauricio Tascon
 * @version 1.0 01/10/2017
 * @since 1.0
 */

@Service
public class ErrorCodes{
	
	@Value("${usuario.sucess.code}")
	protected String USUARIO_SUCESS_CODE;
	
	@Value("${usuario.sucess.desc}")
	protected String USUARIO_SUCESS_DESC;
	
	@Value("${error.status.code.1}")
	protected String ERROR_STATUS_CODE_1;
	
	@Value("${error.status.code.1.desc}")
	protected String ERROR_STATUS_CODE_1_DESC;
	
	@Value("${error.status.code.2}")
	protected String ERROR_STATUS_CODE_2;
	
	@Value("${error.status.code.2.desc}")
	protected String ERROR_STATUS_CODE_2_DESC;
	
	@Value("${error.validacion}")
	protected String ERROR_VALIDACION;
	
	@Value("${error.query}")
	protected String ERROR_QUERY;
	
	@Value("${error.persistence}")
	protected String ERROR_PERSISTENCE;
	
	
	@Value("${sd.mail.usuario.ok}")
	protected Boolean NOTIFICATION_OK;
	
	@Value("${sd.mail.usuario.fail}")
	protected Boolean NOTIFICATION_FAIL;
	
	
	@Value("${error.status.code.5}")
	protected String  ERROR_STATUS_CODE_5;
	
	@Value("${error.status.code.5.desc}")
	protected String  ERROR_STATUS_CODE_5_DESC;
	
	
	@Value("${error.0.antecedentes}")
	protected String  ERROR_0_ANTECEDENTES;
	
	@Value("${error.1.antecedentes}")
	protected String  ERROR_1_ANTECEDENTES;
	
	@Value("${error.0.antecedentes_desc}")
	protected String  ERROR_0_ANTECEDENTES_DESC;
	
	@Value("${error.1.antecedentes_desc}")
	protected String  ERROR_1_ANTECEDENTES_DESC;
	
	
	protected String DISPLAY_DATE_FORMAT = "dd/MM/yyyy hh:mm:ss a";
	
	

	
}
