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

public class UsuarioOutDTO {

	private String RqUID;
	
	private String statusCode;
	
	private String Severity;
	
	
	private String serverStatusCode;
	
	private String mesajeria;
	
	private Date fecha;
	
	

	public UsuarioOutDTO() {

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


	public String getSeverity() {
		return Severity;
	}



	public void setSeverity(String severity) {
		Severity = severity;
	}


	public String getServerStatusCode() {
		return serverStatusCode;
	}





	public void setServerStatusCode(String serverStatusCode) {
		this.serverStatusCode = serverStatusCode;
	}





	public String getMesajeria() {
		return mesajeria;
	}





	public void setMesajeria(String mesajeria) {
		this.mesajeria = mesajeria;
	}





	public Date getFecha() {
		return fecha;
	}





	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	

}
