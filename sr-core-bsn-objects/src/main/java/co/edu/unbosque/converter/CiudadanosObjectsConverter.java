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

import org.example.registraduria.AntecedentesResponseType;
import org.example.registraduria.AntecedentesType;
import org.example.registraduria.ConsultaAntecedentesResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.edu.unbosque.dto.in.CiudadanosInDTO;
import co.edu.unbosque.dto.out.CiudadanosOutDTO;
import co.edu.unbosque.model.bo.CiudadanosBO;
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
public class CiudadanosObjectsConverter {

	static Logger LOGGER = LoggerFactory.getLogger(CiudadanosObjectsConverter.class);
	 
   
   public static CiudadanosInDTO convertAntecedentesTypeToUsuarioInDTO(AntecedentesType inn){
		CiudadanosInDTO out = new CiudadanosInDTO();
		out.setCiudadanosBO(convertAntecedentesTypeTousuarioBO(inn)); 
		return out;
	}
	
  public static CiudadanosBO convertAntecedentesTypeTousuarioBO(AntecedentesType inn){
	    CiudadanosBO out =new CiudadanosBO();
		out.setIdentificador(inn.getDocumetnum());
		out.setFechaConsulta(DateUtil.toDate(inn.getFechaConsulta())); 
		return out;
	}
   
   
  
   public static ConsultaAntecedentesResp toAntecedentesResponseType(CiudadanosOutDTO outDTO){
	   ConsultaAntecedentesResp response = new ConsultaAntecedentesResp();
	   AntecedentesResponseType responseType = new AntecedentesResponseType();
	   responseType.setRqUID(outDTO.getRqUID());
	   responseType.setAntecedente(outDTO.getAntecedente());
	   responseType.setStatusCode(Integer.parseInt(outDTO.getStatusCode()));
	   responseType.setEstado(outDTO.getServerStatusCode()); 
	   responseType.setStatusDesc(outDTO.getMesajeRespuesta()); 
	   responseType.setFechaConsulta(DateUtil.toXMLGregorianCalendar(outDTO.getFecha()));
	   response.setAntecedentesOut(responseType); 	   
	   return response;
	}
	
}
