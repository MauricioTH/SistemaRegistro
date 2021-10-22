package co.edu.unbosque.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.persistence.AbstractDAO_JPA;
import co.edu.unbosque.persistence.dao.AntecedentesDAO;
import co.edu.unbosque.persistence.model.Antecedentes;


@Repository
public class AntecedentesDAOImpl extends AbstractDAO_JPA<Antecedentes> implements AntecedentesDAO{
	
	
	static Logger LOGGER = LoggerFactory.getLogger(AntecedentesDAOImpl.class.getName());

	

	public AntecedentesDAOImpl() {
		super(Antecedentes.class);

	}



	


	@SuppressWarnings("unchecked")
	@Override
	public List<Antecedentes> buscarAllAntecedentes() {
		// TODO Auto-generated method stub
		List<Antecedentes> antecedentes=null;
		StringBuilder hql = new StringBuilder();
		hql.append("select a from Antecedentes a ");
		Query query = entityManager.createQuery(hql.toString());
		antecedentes = query.getResultList();
		return antecedentes;
	}



	
	
}
