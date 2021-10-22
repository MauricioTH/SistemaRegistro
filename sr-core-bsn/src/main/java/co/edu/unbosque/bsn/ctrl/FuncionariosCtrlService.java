package co.edu.unbosque.bsn.ctrl;

import java.net.MalformedURLException;

import javax.xml.ws.WebServiceException;

import co.edu.unbosque.dto.in.UsuarioInDTO;
import co.edu.unbosque.dto.out.FuncionarioOutDTO;


/**
 * Servicio puente para las peticiones entre los servicios de Payments y el Core
 * @author Mauricio Tacon Hernandez
 * @version 1.0
 * @since 1.0
 * @Fecha Agosto 17 del 2017
 */
public interface FuncionariosCtrlService {

	
	/**
	 * Registrar la transacción como pago con algún banco del grupo AVAL 
	 * @param avalPaymentAddRq
	 * @return AVALPaymentAddRsType
	 */
	public FuncionarioOutDTO billPmt(UsuarioInDTO inDTO) throws MalformedURLException, WebServiceException;

    /**
     * Registrar la transacción como pago por medio de PSE 
     * @param pseTransactionAddRq
     * @return PSETransactionAddRsType
     */
    

    
}
