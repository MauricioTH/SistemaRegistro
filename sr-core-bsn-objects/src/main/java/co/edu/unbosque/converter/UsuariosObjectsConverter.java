/*
 * PaymentsObjectsConverter
 *  
 * GSI - Integración
 * Creado el: 20/11/2015
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 * 
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
package co.edu.unbosque.converter;

import org.example.registraduria.LoginResponseType;
import org.example.registraduria.LoginType;
import org.example.registraduria.LoginUsuarioResp;
import org.example.registraduria.RegistroResponseType;
import org.example.registraduria.RegistroType;
import org.example.registraduria.RegistroUsuarioResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.unbosque.dto.in.UsuarioInDTO;
import co.edu.unbosque.dto.out.UsuarioOutDTO;
import co.edu.unbosque.model.bo.UsuarioBO;
import co.edu.unbosque.util.DateUtil;

/**
 * Convierte objetos que vienen de los servicios a GateWayCustLimi correspondiente a validacion de Topes
 * 
 * @author Mauricio Tascon Hernandez
 * @version 1.0 
 * @since 1.0
 * @Fecha 17/08/2017
 * 
 */
public class UsuariosObjectsConverter {

	static Logger LOGGER = LoggerFactory.getLogger(UsuariosObjectsConverter.class);
	
	
	public static UsuarioInDTO convertRegistroTypeToUsuarioInDTO(RegistroType inn){
		UsuarioInDTO out = new UsuarioInDTO();
		out.setUsuarioBO(convertRegistroTypeTousuarioBO(inn));
		return out;
	}
	
   public static UsuarioBO convertRegistroTypeTousuarioBO(RegistroType inn){
		UsuarioBO out =new UsuarioBO();
		out.setrQUID(inn.getRqUID());
		out.setIdentificador(inn.getIdentificacion()); 
		out.setNombres(inn.getNombres()); 
		out.setApellidos(inn.getApellidos()); 
		out.setFuerzaPublica(Integer.valueOf(inn.getFuerzaPublica()));
		out.setRango(Integer.valueOf(inn.getRango()));
		out.setCorreoElectronico(inn.getEmail()); 
		out.setFecha(DateUtil.toDate(inn.getFechaRegistro()));
		return out;
	}
    
   
   
   
   public static RegistroUsuarioResp toRegistroResponseType(UsuarioOutDTO outDTO){
	   RegistroUsuarioResp response = new RegistroUsuarioResp();
	   RegistroResponseType responseType = new RegistroResponseType();
	   responseType.setRqUID(outDTO.getRqUID());
	   responseType.setFechaRegistro(DateUtil.toXMLGregorianCalendar(outDTO.getFecha()));
	   responseType.setStatusCode(Integer.parseInt(outDTO.getStatusCode()));
	   responseType.setSeverity(outDTO.getSeverity());
	   responseType.setStatusDesc(outDTO.getServerStatusCode()); 	   
	   response.setUsuarioOut(responseType); 
		return response;
	}
	
   
   
   public static UsuarioInDTO convertLoginTypeToUsuarioInDTO(LoginType inn){
		UsuarioInDTO out = new UsuarioInDTO();
		out.setUsuarioBO(convertUsuarioTypeTousuarioBO(inn));
		return out;
	}
	
  public static UsuarioBO convertUsuarioTypeTousuarioBO(LoginType inn){
		UsuarioBO out =new UsuarioBO();
		out.setrQUID(inn.getRqUID());
		out.setFecha(DateUtil.toDate(inn.getFechaLogin())); 
		out.setIdentificador(inn.getNumDocumento()); 
		out.setPassword(inn.getPassword()); 
		return out;
	}
  
  
  public static LoginUsuarioResp toLoginResponseType(UsuarioOutDTO outDTO){
	  LoginUsuarioResp out = new LoginUsuarioResp(); 
	  LoginResponseType responseType  = new LoginResponseType();
	  responseType.setRqUID(outDTO.getRqUID()); 
	  responseType.setFechaLogin(DateUtil.toXMLGregorianCalendar(outDTO.getFecha())); 
	  responseType.setStatusCode(Integer.parseInt(outDTO.getStatusCode()));
	  responseType.setSeverity(outDTO.getServerStatusCode());
	  responseType.setStatusDesc(outDTO.getMesajeria()); 
	  out.setLoginOut(responseType);
	  return out;
	}
	
   
}
