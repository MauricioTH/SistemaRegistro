
package co.edu.unbosque.bsn.services;


import co.edu.unbosque.dto.in.UsuarioInDTO;
import co.edu.unbosque.dto.out.UsuarioOutDTO;

public interface RegistraduriaBussinesService {

	public UsuarioOutDTO addUsuario(UsuarioInDTO inDTO); 
	
	public UsuarioOutDTO logginUser(UsuarioInDTO inDTO);

	
}
