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
package co.edu.unbosque.dto.in;

import co.edu.unbosque.model.bo.UsuarioBO;

public class UsuarioInDTO {

	private UsuarioBO usuarioBO;

	public UsuarioInDTO() {

	}

	public UsuarioBO getUsuarioBO() {
		return usuarioBO;
	}

	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}

}
