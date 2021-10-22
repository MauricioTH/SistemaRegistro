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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.edu.unbosque.bsn.services.CiudadanosBussinesService;
import co.edu.unbosque.dto.in.CiudadanosInDTO;
import co.edu.unbosque.dto.out.CiudadanosOutDTO;
import co.edu.unbosque.persistence.dao.AntecedentesCiudadanosDAO;
import co.edu.unbosque.persistence.dao.CiudadanosDAO;
import co.edu.unbosque.persistence.model.Antecedentesciudadanos;
import co.edu.unbosque.persistence.model.Ciudadano;
import co.edu.unbosque.util.ErrorCodes;


@Service
public class CiudadanosBussinesServiceImpl extends ErrorCodes implements CiudadanosBussinesService {
	
	static Logger LOGGER = LoggerFactory.getLogger(CiudadanosBussinesServiceImpl.class);

	@Resource
	CiudadanosDAO ciudadanosDAO;
	
	
	@Resource
	AntecedentesCiudadanosDAO antecedentesCiudadanosDAO;
	
	
	List<Ciudadano>listRequeridos;  
	
	@Override
	public CiudadanosOutDTO getAntecedentes(CiudadanosInDTO inDTO) {
		// TODO Auto-generated method stub
		
		CiudadanosOutDTO outDTO = new CiudadanosOutDTO();
		Ciudadano ciudadano=null;
		Antecedentesciudadanos antecedentesciudadanos=null;
		
		ciudadano = ciudadanosDAO.findByIdentificacion(inDTO.getCiudadanosBO().getIdentificador());
		
		
		List <String> avengers = new ArrayList<>();  

		// Now lets add some Avengers to the list
		avengers.add("Ant-Man");
		avengers.add("Black Widow");
		avengers.add("Captain America");
		avengers.add("Doctor Strange");
		
		
		if(ciudadano==null){
			outDTO.setAntecedente(false); 
			outDTO.setStatusCode(ERROR_STATUS_CODE_5); 
		    outDTO.setServerStatusCode(ERROR_STATUS_CODE_5_DESC); 
		    outDTO.setMesajeRespuesta(ERROR_STATUS_CODE_5_DESC);
		    outDTO.setFecha(new Date());
		    return outDTO;
		    
		    
		    
		}
		
		antecedentesciudadanos= antecedentesCiudadanosDAO.findByIdentificacion(inDTO.getCiudadanosBO().getIdentificador());
		
		if(antecedentesciudadanos==null){
			outDTO.setAntecedente(false); 
			outDTO.setStatusCode(ERROR_0_ANTECEDENTES); 
		    outDTO.setServerStatusCode(ERROR_0_ANTECEDENTES_DESC); 
		    outDTO.setMesajeRespuesta(ERROR_0_ANTECEDENTES_DESC); 
		    outDTO.setFecha(new Date());
		    return outDTO;
		}else if (antecedentesciudadanos.getIdantecedente().getId().equals(0)) { 
			outDTO.setAntecedente(false);  
			outDTO.setStatusCode(ERROR_0_ANTECEDENTES); 
		    outDTO.setServerStatusCode(ERROR_0_ANTECEDENTES_DESC); 
		    outDTO.setMesajeRespuesta(antecedentesciudadanos.getIdantecedente().getDescripcion());
		    outDTO.setFecha(inDTO.getCiudadanosBO().getFechaConsulta()); 
		}else  {
		outDTO.setAntecedente(true); 
		outDTO.setStatusCode(ERROR_1_ANTECEDENTES); 
	    outDTO.setServerStatusCode(ERROR_1_ANTECEDENTES_DESC); 
	    outDTO.setMesajeRespuesta(antecedentesciudadanos.getIdantecedente().getDescripcion()); 
	    outDTO.setFecha(antecedentesciudadanos.getFechaRegistro()); 
	}
		
		return outDTO;
	}

	
	
}
