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

import java.util.Date;

import org.example.funcionarios.FuncionarioType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.unbosque.dto.in.UsuarioInDTO;
import co.edu.unbosque.dto.out.FuncionarioOutDTO;
import co.edu.unbosque.util.DateUtil;

/**
 * Convierte objetos que vienen de los servicios a GateWayCustLimi correspondiente a validacion de Topes
 * 
 * @author Mauricio Tascon Hernandez
 * @version 1.0 
 * @since 1.0
 * @Fecha 17/08/2017
 * 
 *  @RQ27199
 *  <strong>Autor</strong>Jordan Andrei Cortes</br>
 *  <strong>Descripcion</strong> Validcación de Topes</br>
 *  <strong>Numero de Cambios</strong>1</br>
 *  <strong>Identificador corto</strong>C01</br>
 */
public class FuncioariosObjectsConverter {

	static Logger LOGGER = LoggerFactory.getLogger(FuncioariosObjectsConverter.class);
	
	
   public static FuncionarioType convetDtoToFuncionario(UsuarioInDTO inDTO){
	   FuncionarioType out = new FuncionarioType();
	   out.setRqUID(inDTO.getUsuarioBO().getrQUID());
	   out.setIdentificacion(inDTO.getUsuarioBO().getIdentificador()); 
	   out.setNombres(inDTO.getUsuarioBO().getNombres()); 
	   out.setFuerzaPublica(String.valueOf(inDTO.getUsuarioBO().getFuerzaPublica()));  
	   out.setFechaConsulta(DateUtil.toXMLGregorianCalendar(new Date())); 
	   return out;
	}
   
   
   public static FuncionarioOutDTO respuestaClient(org.example.funcionarios.ResponseType out) {
	    FuncionarioOutDTO outDTO = new FuncionarioOutDTO();
	    outDTO.setRqUID(out.getRqUID());
		outDTO.setStatusCode(String.valueOf(out.getCodigoError())); 
		outDTO.setMesajeria(out.getMensajeRespuesta());
		return outDTO;
	}

	
}
