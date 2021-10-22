package co.edu.unbosque.persistence.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.persistence.AbstractDAO_JPA;
import co.edu.unbosque.persistence.dao.FuerzaPublicaDAO;
import co.edu.unbosque.persistence.model.Fuerzapublica;

@Repository
public class FuerzaPublicaDAOImpl extends AbstractDAO_JPA<Fuerzapublica> implements FuerzaPublicaDAO{
	
	
	static Logger LOGGER = LoggerFactory.getLogger(UsuarioDAOImpl.class.getName());

	public FuerzaPublicaDAOImpl() {
		super(Fuerzapublica.class);

	}

	

}
