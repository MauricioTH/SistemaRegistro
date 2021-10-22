package co.edu.unbosque.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.persistence.AbstractDAO_JPA;
import co.edu.unbosque.persistence.dao.AntecedentesCiudadanosDAO;
import co.edu.unbosque.persistence.model.Antecedentesciudadanos;


@Repository
public class AntecedentesCiudadanosDAOImpl extends AbstractDAO_JPA<Antecedentesciudadanos> implements AntecedentesCiudadanosDAO{
	
	
	static Logger LOGGER = LoggerFactory.getLogger(AntecedentesCiudadanosDAOImpl.class.getName());

	

	public AntecedentesCiudadanosDAOImpl() {
		super(Antecedentesciudadanos.class);

	}



	@SuppressWarnings("rawtypes")
	@Override
	public Antecedentesciudadanos findByIdentificacion(Integer identificacion) {
		final StringBuilder hql = new StringBuilder();
		hql.append("select a from Antecedentesciudadanos a where a.identificacion.identificacion = :identificacion");
		final Query query = entityManager.createQuery(hql.toString());
		query.setParameter("identificacion", identificacion);
		
		LOGGER.info("Se realiza la Consulta de antecedentes al Ciudadano con identificacion (" + identificacion + ") ");
		final List resultado = query.getResultList();

		if (resultado.isEmpty()) {
			LOGGER.info("No Existen atecedentes al ciudadano (" + identificacion + ") ");
			return null;
		} else {
			return (Antecedentesciudadanos) resultado.get(0);
		}
	}



	
	
}
