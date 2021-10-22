/*
 * BankDAO
 *  
 * GSI - Integración
 * Creado el: 24/09/2015
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 * 
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.persistence.dao;


import java.util.Date;
import java.util.List;

import co.edu.unbosque.persistence.DataAccessObject;
import co.edu.unbosque.persistence.model.Ciudadano;


public interface CiudadanosDAO extends DataAccessObject<Ciudadano>{
	
	public Ciudadano findByIdentificacion(Integer code);
	public List<Ciudadano>buscarTodos();
	public List<Ciudadano> getRequeridos(Date fechaDesde, Date fechaHasta);
	public List<Ciudadano> getNotRequeridos(Date fechaDesde, Date fechaHasta);
	
}
