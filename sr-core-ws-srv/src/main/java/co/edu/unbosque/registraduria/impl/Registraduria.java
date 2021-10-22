/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.registraduria.impl;

import javax.inject.Inject;
import javax.jws.WebService;

import org.example.registraduria.ConsultaAntecedentesReq;
import org.example.registraduria.ConsultaAntecedentesResp;
import org.example.registraduria.LoginUsuarioReq;
import org.example.registraduria.LoginUsuarioResp;
import org.example.registraduria.RegistroUsuarioReq;
import org.example.registraduria.RegistroUsuarioResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import co.edu.unbosque.bsn.ctrl.CiudadanosCtrlService;
import co.edu.unbosque.bsn.ctrl.UsuarosCtrlService;

//import co.edu.unbosque.bsn.ctrl.UsuarosCtrlService;

/**
 *
 * @author MauricioTascon
 */
@WebService(serviceName = "Registraduria", 
portName = "RegistraduriaSOAP", 
endpointInterface = "org.example.registraduria.Registraduria", 
targetNamespace = "http://www.example.org/Registraduria/",
wsdlLocation = "WEB-INF/wsdl/Usuarios/Registraduria.wsdl")
public class Registraduria extends SpringBeanAutowiringSupport{
	
	
	private static Logger LOGGER = LoggerFactory.getLogger(Registraduria.class);
	
	@Inject
	private UsuarosCtrlService usuarosCtrlService;
	
	@Inject
	private CiudadanosCtrlService ciudadanosCtrlService;

    
    public RegistroUsuarioResp registroUsuario(RegistroUsuarioReq parameters) {
        //TODO implement this method
    	LOGGER.info("@addUsuario input:{}\n{}", parameters);
    	RegistroUsuarioResp response = usuarosCtrlService.addUsuarios(parameters);
    	return response;
    }
    
     
    public ConsultaAntecedentesResp consultaAntecedentes(ConsultaAntecedentesReq parameters) {
        //TODO implement this method
    	LOGGER.info("@consulta input:{}\n{}", parameters);
    	ConsultaAntecedentesResp response =ciudadanosCtrlService.consultaAntecedente(parameters);
        return response;
    }
    
    public LoginUsuarioResp loginUsuario(LoginUsuarioReq parameters) { 
        //TODO implement this method
    	LOGGER.info("@Login input:{}\n{}", parameters);
    	LoginUsuarioResp response =usuarosCtrlService.login(parameters);
        return response;
    }
    
    
}
