package co.edu.unbosque.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.persistence.AbstractDAO_JPA;
import co.edu.unbosque.persistence.dao.CiudadDAO;
import co.edu.unbosque.persistence.model.Ciudad;


@Repository
public class CiudadDAOImpl extends AbstractDAO_JPA<Ciudad> implements CiudadDAO{
	
	
	static Logger LOGGER = LoggerFactory.getLogger(CiudadDAOImpl.class.getName());

	

	public CiudadDAOImpl() {
		super(Ciudad.class);

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudad> buscarAll() {
		// TODO Auto-generated method stub
		List<Ciudad> ciudad=null;
		StringBuilder hql = new StringBuilder();
		hql.append("select c from Ciudad c ");
		Query query = entityManager.createQuery(hql.toString());
		ciudad= query.getResultList();
		return ciudad;
	}
		
	
}
