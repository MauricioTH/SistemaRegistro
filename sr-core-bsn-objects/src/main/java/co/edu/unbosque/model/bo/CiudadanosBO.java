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
package co.edu.unbosque.model.bo;

import java.util.Date;



public class CiudadanosBO {

	 
    private int identificador;
        
    private String primerNombre;
    
    private String segundoNombre;
    
    private String primerApellidos;
    
    private String segundoApellidos;
    
    private Date fechaNacimiento;
    
    private Integer lugarDeNacimiento;
   
    private Date fechaExpedicion;
    
    private Integer lugarDeExpedicion; 
    
    private String Sexo;
    
    private Integer idAntecedente;
    
    private Date fechaConsulta;
    

    
    public CiudadanosBO() {
        
    }




	public int getIdentificador() {
		return identificador;
	}




	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}



	public String getPrimerNombre() {
		return primerNombre;
	}




	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}




	public String getSegundoNombre() {
		return segundoNombre;
	}




	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}




	public String getPrimerApellidos() {
		return primerApellidos;
	}




	public void setPrimerApellidos(String primerApellidos) {
		this.primerApellidos = primerApellidos;
	}




	public String getSegundoApellidos() {
		return segundoApellidos;
	}




	public void setSegundoApellidos(String segundoApellidos) {
		this.segundoApellidos = segundoApellidos;
	}




	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}




	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}




	public Integer getLugarDeNacimiento() {
		return lugarDeNacimiento;
	}




	public void setLugarDeNacimiento(Integer lugarDeNacimiento) {
		this.lugarDeNacimiento = lugarDeNacimiento;
	}




	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}




	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}




	public Integer getLugarDeExpedicion() {
		return lugarDeExpedicion;
	}




	public void setLugarDeExpedicion(Integer lugarDeExpedicion) {
		this.lugarDeExpedicion = lugarDeExpedicion;
	}




	public String getSexo() {
		return Sexo;
	}




	public void setSexo(String sexo) {
		Sexo = sexo;
	}




	public Integer getIdAntecedente() {
		return idAntecedente;
	}




	public void setIdAntecedente(Integer idAntecedente) {
		this.idAntecedente = idAntecedente;
	}




	public Date getFechaConsulta() {
		return fechaConsulta;
	}




	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
    
    
    

	
    
    
}
