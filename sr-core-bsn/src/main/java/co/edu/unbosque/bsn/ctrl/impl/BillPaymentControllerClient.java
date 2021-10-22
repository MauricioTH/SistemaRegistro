/*
 * PaymentCommerceCtrlServiceImpl
 *  
 * GSI - Integración
 * Creado el: 25/09/2015
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 * 
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
package co.edu.unbosque.bsn.ctrl.impl;

import java.io.Serializable;
import java.net.MalformedURLException;

import javax.xml.ws.WebServiceException;

import org.example.funcionarios.FuncionarioType;
import org.example.funcionarios.ResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.edu.unbosque.bsn.ctrl.FuncionariosCtrlService;
import co.edu.unbosque.converter.FuncioariosObjectsConverter;
import co.edu.unbosque.dto.in.UsuarioInDTO;
import co.edu.unbosque.dto.out.FuncionarioOutDTO;
import co.edu.unbosque.ws.client.funcionarios.impl.BillPaymentImplClient;



/**
 * Implementación del servicio puente para el pago de transacciones por el medio
 * de pago PSE
 * 
 * @author Mauricio Tascon
 * @version 1.0 31/03/2016
 * @since 1.0
 */
@Service
public class BillPaymentControllerClient implements FuncionariosCtrlService, Serializable {

	private static final long serialVersionUID = 1L;

	static Logger LOGGER = LoggerFactory.getLogger(BillPaymentControllerClient.class);

	@Value("${sr.ws.sistemas.defensa.wsdl}")
	private  String urlEndPoint;

	
	@Override
	public FuncionarioOutDTO billPmt(UsuarioInDTO inDTO) throws MalformedURLException, WebServiceException {

		FuncionarioOutDTO outDTO = null;
		BillPaymentImplClient billPaymentImplClient = new BillPaymentImplClient();
		urlEndPoint="http://localhost:7005/SistemaDefensa/Funcionarios?wsdl";
		
		try {
			LOGGER.info("Se procede a establecer conexion con el sistema de defensa (" + inDTO.getUsuarioBO().getNombres() + ") por medio del Broker para el servicio GetFuncionario "
					+ "con Identificacion (" + inDTO.getUsuarioBO().getIdentificador() + ") ");
			billPaymentImplClient.billPaymentImplClient(urlEndPoint);

			/** Se instancia el objeto que realiza la transformacion de trama */
			FuncionarioType funcionarioIn = null;
			funcionarioIn = FuncioariosObjectsConverter.convetDtoToFuncionario(inDTO);

			LOGGER.info("Se procede a consumir el web service del Sistema de Defensa  por medio del Broker para el servicio GetFuncionario " + "con identificacion (" + inDTO.getUsuarioBO().getIdentificador() + ") \n{}");
			ResponseType out = billPaymentImplClient.getClient().getFuncionario(funcionarioIn); 
			LOGGER.info("Respuesta del Sistema de Defensa \n{}");
			outDTO = FuncioariosObjectsConverter.respuestaClient(out);

		} catch (WebServiceException e) {
			LOGGER.error("Error en establecer la conexion del WS BillPaymentClient: \n{}", e.getMessage());
			throw e;

		} catch (RuntimeException e) {
			if (e.getCause() != null && e.getCause().getClass().getName().equals("java.net.SocketTimeoutException")) {
				LOGGER.error("Error por TIME OUT WS BillPaymentClient: \n{}", e.getMessage());
			} else {
				LOGGER.error("Error en WS BillPaymentClient: \n{} Message:\n{}", e.toString(), e.getMessage());
			}
			throw e;

		} catch (Exception e) {
			LOGGER.error("Error en la creacion de la trama del Request del WS cliente BillPaymentClient: \n{}", e.getMessage());
			throw e;

		}

		return outDTO;
	}

	
}
