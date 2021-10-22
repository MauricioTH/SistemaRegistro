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



public class UsuarioBO {

    
    private int identificador;

    /**
     * Nombre del usuario
     */
    
    private String rQUID;
    
    private String nombres;
    
    private String apellidos;
    
    private Integer fuerzaPublica;
    
    private Integer rango;
    
    private Date fecha;
    
    private String correoElectronico;
    
    private String password;

    
    public UsuarioBO() {
        
    }
    
    
    public UsuarioBO(Integer identificador) {
        this.identificador = identificador;
    }

    
    public UsuarioBO(Integer identificador, String nombres, String apellidos) {
        this.identificador= identificador;
        this.nombres = nombres;
        this.apellidos = apellidos;
        
    }


	public String getrQUID() {
		return rQUID;
	}


	public void setrQUID(String rQUID) {
		this.rQUID = rQUID;
	}


	public int getIdentificador() {
		return identificador;
	}


	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public Integer getFuerzaPublica() {
		return fuerzaPublica;
	}


	public void setFuerzaPublica(Integer fuerzaPublica) {
		this.fuerzaPublica = fuerzaPublica;
	}


	public Integer getRango() {
		return rango;
	}


	public void setRango(Integer rango) {
		this.rango = rango;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

    
    
}
