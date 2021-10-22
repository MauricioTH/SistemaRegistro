
package co.edu.unbosque.bsn.services;


import co.edu.unbosque.dto.in.CiudadanosInDTO;
import co.edu.unbosque.dto.out.CiudadanosOutDTO;

public interface CiudadanosBussinesService {

	public CiudadanosOutDTO getAntecedentes(CiudadanosInDTO inDTO); 
	
}
