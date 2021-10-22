package co.edu.unbosque.bsn.ctrl.impl;

import javax.annotation.Resource;

import org.example.registraduria.LoginUsuarioReq;
import org.example.registraduria.LoginUsuarioResp;
import org.example.registraduria.RegistroUsuarioReq;
import org.example.registraduria.RegistroUsuarioResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.edu.unbosque.bsn.ctrl.UsuarosCtrlService;
import co.edu.unbosque.bsn.services.RegistraduriaBussinesService;
import co.edu.unbosque.bsn.services.UsuarioBussinesService;
import co.edu.unbosque.converter.UsuariosObjectsConverter;
import co.edu.unbosque.dto.in.UsuarioInDTO;
import co.edu.unbosque.dto.out.UsuarioOutDTO;
import co.edu.unbosque.persistence.dao.UsuarioDAO;
import co.edu.unbosque.persistence.model.Usuario;

@Service
public class UsuarosCtrlServiceImpl implements UsuarosCtrlService {

	@Resource
	UsuarioBussinesService  usuarioBussinesService;
	
	@Resource
	RegistraduriaBussinesService  registraduriaBussinesService;
	
	static Logger LOGGER = LoggerFactory.getLogger(UsuarosCtrlServiceImpl.class);

	@Resource
	private UsuarioDAO usuarioDAO; 
	
	
	
	
	@Override
	public RegistroUsuarioResp addUsuarios(RegistroUsuarioReq parameter) {
		// TODO Auto-generated method stub
		RegistroUsuarioResp responseType=null;
		
		try {
			UsuarioInDTO usuarioDTO = UsuariosObjectsConverter.convertRegistroTypeToUsuarioInDTO(parameter.getUsuarioIn());			
			UsuarioOutDTO usuarioOutDTO = registraduriaBussinesService.addUsuario(usuarioDTO); 
			responseType = UsuariosObjectsConverter.toRegistroResponseType(usuarioOutDTO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return responseType;
	}

	@Override
	public LoginUsuarioResp login(LoginUsuarioReq parameter) {
		// TODO Auto-generated method stub
		LoginUsuarioResp responseType=null;
		try {
			UsuarioInDTO usuarioDTO = UsuariosObjectsConverter.convertLoginTypeToUsuarioInDTO(parameter.getLogIn());			
			UsuarioOutDTO usuarioOutDTO = usuarioBussinesService.logginUser(usuarioDTO); 
			responseType = UsuariosObjectsConverter.toLoginResponseType(usuarioOutDTO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return responseType;
	}

	@Override
	public Usuario loginUsua(Usuario usua) {
		Usuario usuario=null;
		usuario =usuarioDAO.findByUserAndPassword(usua.getIdentificacion(), usua.getContrasena());
		return usuario;
	}



	
	
	
}
