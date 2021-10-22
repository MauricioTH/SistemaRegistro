/*
 * PGWPaymentServiceImpl
 *  
 * GSI - Integración
 * Creado el: 25/09/2014
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 * 
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
package co.edu.unbosque.bsn.services.impl;
//import java.net.MalformedURLException;
import javax.annotation.Resource;
//import javax.xml.ws.WebServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import co.edu.unbosque.bsn.ctrl.impl.BillPaymentControllerClient;
import co.edu.unbosque.bsn.services.RegistraduriaBussinesService;
import co.edu.unbosque.dto.in.UsuarioInDTO;
//import co.edu.unbosque.dto.out.FuncionarioOutDTO;
import co.edu.unbosque.dto.out.UsuarioOutDTO;
import co.edu.unbosque.persistence.dao.FuerzaPublicaDAO;
import co.edu.unbosque.persistence.dao.FuncionarioDAO;
import co.edu.unbosque.persistence.dao.RangoDAO;
import co.edu.unbosque.persistence.dao.UsuarioDAO;
import co.edu.unbosque.persistence.model.Fuerzapublica;
import co.edu.unbosque.persistence.model.Perfil;
import co.edu.unbosque.persistence.model.Rango;
import co.edu.unbosque.persistence.model.Usuario;
import co.edu.unbosque.util.ErrorCodes;
import co.edu.unbosque.util.PasswordGenerator;


@Service
public class RegistraduriaBussinesServiceImpl extends ErrorCodes implements RegistraduriaBussinesService {
	
	static Logger LOGGER = LoggerFactory.getLogger(RegistraduriaBussinesServiceImpl.class);

	
	@Resource
	private FuncionarioDAO funcionarioDAO;
	
	@Resource
	private UsuarioDAO usuarioDAO;
	
	@Resource
	private FuerzaPublicaDAO fuerzaPublicaDAO;
	
	@Resource
	private RangoDAO rangoDAO;
	
	@Resource
	BillPaymentControllerClient funcionarioControllerClient;
	
	private UsuarioOutDTO outDTO;
	

	@Override
	public UsuarioOutDTO addUsuario(UsuarioInDTO inDTO) {
		
		outDTO = new UsuarioOutDTO();
		
		Fuerzapublica fuerzaPublica=new Fuerzapublica();
		Rango rango=new Rango();
		Perfil perfil=new Perfil();
		Usuario usuario=null;
		
		LOGGER.info("Se consulta en la BD que el usuario (" + inDTO.getUsuarioBO().getIdentificador() + ") no exista para proceder a registrarlo.");
		try {
			 usuario = getUsuario(inDTO);
			
			if (usuario != null)
				return outDTO;
						
			usuario = new Usuario();
			usuario.setIdentificacion(inDTO.getUsuarioBO().getIdentificador());
			usuario.setNombres(inDTO.getUsuarioBO().getNombres());
			usuario.setApellidos(inDTO.getUsuarioBO().getApellidos());			
			usuario.setContrasena(PasswordGenerator.getPassword(
					PasswordGenerator.MINUSCULAS+
					PasswordGenerator.MAYUSCULAS+
					PasswordGenerator.ESPECIALES,6));
			usuario.setEmail(inDTO.getUsuarioBO().getCorreoElectronico()); 
			usuario.setNotificacionEmail(NOTIFICATION_FAIL);
			usuario.setFechaCreacion(inDTO.getUsuarioBO().getFecha()); 			 
			rango.setId(inDTO.getUsuarioBO().getRango()); 
			fuerzaPublica.setId(inDTO.getUsuarioBO().getFuerzaPublica());
			perfil.setId(2); 
			usuario.setIdrango(rango); 
			usuario.setIdfuerzapublica(fuerzaPublica);
			usuario.setIdperfil(perfil); 
			usuarioDAO.create(usuario);
			
			outDTO.setRqUID(inDTO.getUsuarioBO().getrQUID());
			outDTO.setStatusCode(USUARIO_SUCESS_CODE); 
			outDTO.setServerStatusCode(USUARIO_SUCESS_DESC); 
			outDTO.setMesajeria(USUARIO_SUCESS_DESC); 
			outDTO.setFecha(inDTO.getUsuarioBO().getFecha());
			
		} catch (Exception e) {
			outDTO.setStatusCode(USUARIO_SUCESS_CODE); 
			outDTO.setServerStatusCode(ERROR_PERSISTENCE);
			return outDTO;
		}
		
		return outDTO;
	}

	private Usuario getUsuario(UsuarioInDTO inDTO) {
		Usuario usuario = null;
		usuario = usuarioDAO.findByIdentificacion(inDTO.getUsuarioBO().getIdentificador());
		if (usuario != null) {
			LOGGER.info("La el Usuario con identificacion(" + inDTO.getUsuarioBO().getIdentificador() + ")  ya existe, no se puede registrar.");
			outDTO.setRqUID(inDTO.getUsuarioBO().getrQUID());
			outDTO.setStatusCode(ERROR_STATUS_CODE_1); 
			outDTO.setServerStatusCode(ERROR_STATUS_CODE_1_DESC);
			outDTO.setSeverity("Warning"); 
			outDTO.setMesajeria(ERROR_STATUS_CODE_1_DESC); 
			outDTO.setFecha(inDTO.getUsuarioBO().getFecha());
			return usuario;
		} else {
			LOGGER.info("El usuario con identificacion (" + inDTO.getUsuarioBO().getIdentificador() + ") no se encuentra registrado.");
			return null;
		}
	}
	

	@Override
	public UsuarioOutDTO logginUser(UsuarioInDTO inDTO) {
		// TODO Auto-generated method stub
		outDTO = new UsuarioOutDTO();
		
		Usuario usuario=null;
		
		usuario	=usuarioDAO.findByUserAndPassword(inDTO.getUsuarioBO().getIdentificador(), inDTO.getUsuarioBO().getPassword() );
		
		if(usuario==null){
			outDTO.setStatusCode(ERROR_STATUS_CODE_5);			
		    outDTO.setServerStatusCode("Error"); 
		    outDTO.setMesajeria("Usuario o contraseña invalida");		    
		    return outDTO;
		}else{
			outDTO.setStatusCode(USUARIO_SUCESS_CODE);			
		    outDTO.setServerStatusCode("Info"); 
		    outDTO.setMesajeria("Loggin Exitoso");
		    return outDTO;
		}
		
	}

	
}
