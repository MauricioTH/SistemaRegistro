package co.edu.unbosque.persistence.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.persistence.AbstractDAO_JPA;
import co.edu.unbosque.persistence.dao.RangoDAO;
import co.edu.unbosque.persistence.model.Rango;


@Repository
public class RangoDAOImpl extends AbstractDAO_JPA<Rango> implements RangoDAO{
	
	
	static Logger LOGGER = LoggerFactory.getLogger(RangoDAOImpl.class.getName());

	

	public RangoDAOImpl() {
		super(Rango.class);

	}



	@Override
	public Rango findByIdentificacion(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
