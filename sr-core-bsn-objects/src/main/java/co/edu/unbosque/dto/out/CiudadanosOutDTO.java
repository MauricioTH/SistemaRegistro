/*
 * BankBO
 *  
 * GSI - Integración
 * Creado el: 14/09/2015
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 * 
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
package co.edu.unbosque.dto.out;

import java.util.Date;


public class CiudadanosOutDTO {

	
   private String RqUID;
	
	private String statusCode;
	
	private String serverStatusCode;
	
	private String mesajeRespuesta;
	
	private Boolean antecedente;
	
	private Date fecha;
	
	

	public CiudadanosOutDTO() {

	}



	public String getRqUID() {
		return RqUID;
	}



	public void setRqUID(String rqUID) {
		RqUID = rqUID;
	}



	public String getStatusCode() {
		return statusCode;
	}



	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}



	public String getServerStatusCode() {
		return serverStatusCode;
	}



	public void setServerStatusCode(String serverStatusCode) {
		this.serverStatusCode = serverStatusCode;
	}



	public String getMesajeRespuesta() {
		return mesajeRespuesta;
	}



	public void setMesajeRespuesta(String mesajeRespuesta) {
		this.mesajeRespuesta = mesajeRespuesta;
	}



	public Boolean getAntecedente() {
		return antecedente;
	}



	public void setAntecedente(Boolean antecedente) {
		this.antecedente = antecedente;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
}
