package co.edu.unbosque.bsn.ctrl;

import org.example.registraduria.LoginUsuarioReq;
import org.example.registraduria.LoginUsuarioResp;
import org.example.registraduria.RegistroUsuarioReq;
import org.example.registraduria.RegistroUsuarioResp;

import co.edu.unbosque.persistence.model.Usuario;


/**
 * Servicio puente para las peticiones entre los servicios de Payments y el Core
 * @author Mauricio Tacon Hernandez
 * @version 1.0
 * @since 1.0
 * @Fecha Agosto 17 del 2017
 */
public interface UsuarosCtrlService {

	
	/**
	 * Registrar la transacción como pago con algún banco del grupo AVAL 
	 * @param avalPaymentAddRq
	 * @return AVALPaymentAddRsType
	 */
	
    public RegistroUsuarioResp addUsuarios(RegistroUsuarioReq parameter);

    /**
     * Registrar la transacción como pago por medio de PSE 
     * @param pseTransactionAddRq
     * @return PSETransactionAddRsType
     */
    
     public LoginUsuarioResp login(LoginUsuarioReq parameter); 
     
     public Usuario loginUsua(Usuario loginIn); 
    
}
