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

import java.net.MalformedURLException;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.edu.unbosque.bsn.ctrl.impl.BillPaymentControllerClient;
import co.edu.unbosque.bsn.services.UsuarioBussinesService;
import co.edu.unbosque.dto.in.UsuarioInDTO;
import co.edu.unbosque.dto.out.FuncionarioOutDTO;
import co.edu.unbosque.dto.out.UsuarioOutDTO;
import co.edu.unbosque.persistence.dao.FuerzaPublicaDAO;
import co.edu.unbosque.persistence.dao.FuncionarioDAO;
import co.edu.unbosque.persistence.dao.RangoDAO;
import co.edu.unbosque.persistence.dao.UsuarioDAO;
import co.edu.unbosque.persistence.model.Fuerzapublica;
import co.edu.unbosque.persistence.model.Funcionario;
import co.edu.unbosque.persistence.model.Rango;
import co.edu.unbosque.persistence.model.Usuario;
import co.edu.unbosque.util.ErrorCodes;
import co.edu.unbosque.util.PasswordGenerator;


@Service
public class UsuarioBussinesServiceImpl extends ErrorCodes implements UsuarioBussinesService {
	
	static Logger LOGGER = LoggerFactory.getLogger(UsuarioBussinesServiceImpl.class);

	
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
		Funcionario funcionarios=new Funcionario();
		Rango rango=new Rango();
		Usuario usuario=null;
		
		LOGGER.info("Se consulta en la BD  que el usuario (" + inDTO.getUsuarioBO().getIdentificador() + ") no exista para proceder a registrarlo.");
		try {
			 usuario = getUsuario(inDTO);
			
			if (usuario != null)
				return outDTO;
			
			LOGGER.info("Se consulta en la BD de Sistema de Defensa que el funcionario"
					+ " con identificacion (" + inDTO.getUsuarioBO().getIdentificador() + ") "
							+ "pertenezca a la institucion.");
			FuncionarioOutDTO funcionario = getFuncionarios(inDTO);
			
			if (!funcionario.getStatusCode().equals("0")) 
				return outDTO;
			
			usuario = new Usuario();
			
			
			funcionarios.setIdentificacion(inDTO.getUsuarioBO().getIdentificador());
			funcionarios.setNombres(inDTO.getUsuarioBO().getNombres()); 
			funcionarios.setApellidos(inDTO.getUsuarioBO().getApellidos());
			funcionarios.setCorreoElectronico(inDTO.getUsuarioBO().getCorreoElectronico()); 
			rango.setId(inDTO.getUsuarioBO().getRango()); 
			fuerzaPublica.setId(inDTO.getUsuarioBO().getFuerzaPublica());
			funcionarios.setIdrango(rango); 
			funcionarios.setIdfuerzapublica(fuerzaPublica);
			
			
			funcionarioDAO.create(funcionarios);
			
			usuario.setIdentificacion(inDTO.getUsuarioBO().getIdentificador()); 
			usuario.setContrasena(PasswordGenerator.getPassword(
					PasswordGenerator.MINUSCULAS+
					PasswordGenerator.MAYUSCULAS+
					PasswordGenerator.ESPECIALES,6));
			usuario.setEmail(inDTO.getUsuarioBO().getCorreoElectronico()); 
			usuario.setFechaCreacion(inDTO.getUsuarioBO().getFecha()); 
			usuario.setNotificacionEmail(NOTIFICATION_FAIL); 		
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
			outDTO.setMesajeria(ERROR_STATUS_CODE_1_DESC); 
			outDTO.setFecha(inDTO.getUsuarioBO().getFecha());
			return usuario;
		} else {
			LOGGER.info("El usuario con identificacion (" + inDTO.getUsuarioBO().getIdentificador() + ") no se encuentra registrado.");
			return null;
		}
	}
	
	private FuncionarioOutDTO getFuncionarios(UsuarioInDTO inDTO) throws MalformedURLException, WebServiceException {
		
		FuncionarioOutDTO funcionarioOutDTO=null;
		
		try {
			funcionarioOutDTO = funcionarioControllerClient.billPmt(inDTO);
			if (funcionarioOutDTO.getStatusCode().equals("0")) {
				LOGGER.info("El funcionario con identificacion (" + inDTO.getUsuarioBO().getIdentificador() + ") Se encuentra registrado en la BD de Sistema de Defensa"
						+ "Se puede registrar en la BD de Sistema de Registro de la Universidad.");
				return funcionarioOutDTO;
			} else {
				LOGGER.info("El Funcionario con identificacion   (" + inDTO.getUsuarioBO().getIdentificador() + ")  no se encuentra registrado en la BD de Sistema de Defensa"
						+ "no se puede registrar en la BD de Sistema de Registro de la Universida.");			
				outDTO.setRqUID(inDTO.getUsuarioBO().getrQUID());
				outDTO.setStatusCode(ERROR_STATUS_CODE_2); 
				outDTO.setServerStatusCode(ERROR_STATUS_CODE_2_DESC); 
				outDTO.setMesajeria(ERROR_STATUS_CODE_2_DESC); 
				outDTO.setFecha(inDTO.getUsuarioBO().getFecha());			
				return funcionarioOutDTO;
			}
		} catch (WebServiceException e) {
			return null;
		} catch (RuntimeException e) {
		   return null;
	   }catch (Exception e) {
			LOGGER.error("Error en la creacion de la trama del Request del WS cliente BillPaymentClient: \n{}", e.getMessage());
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
			outDTO.setRqUID(inDTO.getUsuarioBO().getrQUID());
			outDTO.setFecha(inDTO.getUsuarioBO().getFecha());
			outDTO.setStatusCode(ERROR_STATUS_CODE_5);			
		    outDTO.setServerStatusCode("Warning"); 
		    outDTO.setMesajeria("Usuario o contraseña invalida");		    
		    return outDTO;
		}else{
			outDTO.setRqUID(inDTO.getUsuarioBO().getrQUID());
			outDTO.setFecha(inDTO.getUsuarioBO().getFecha());
			outDTO.setStatusCode(USUARIO_SUCESS_CODE);			
		    outDTO.setServerStatusCode("Info"); 
		    outDTO.setMesajeria("Loggin Exitoso");
		    return outDTO;
		}
		
	}

	
}
