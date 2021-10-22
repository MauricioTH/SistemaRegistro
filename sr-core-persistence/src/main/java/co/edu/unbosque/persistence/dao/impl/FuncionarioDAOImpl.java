package co.edu.unbosque.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.persistence.AbstractDAO_JPA;
import co.edu.unbosque.persistence.dao.FuncionarioDAO;
import co.edu.unbosque.persistence.model.Funcionario;

@Repository
public class FuncionarioDAOImpl extends AbstractDAO_JPA<Funcionario> implements FuncionarioDAO{
	
	
	static Logger LOGGER = LoggerFactory.getLogger(UsuarioDAOImpl.class.getName());

	public FuncionarioDAOImpl() {
		super(Funcionario.class);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Funcionario findByIdentificacion(Integer identificacion) {
		final StringBuilder hql = new StringBuilder();
		hql.append("select f from Funcionario f where f.identificacion = :identificacion");
		final Query query = entityManager.createQuery(hql.toString());
		query.setParameter("identificacion", identificacion);
		LOGGER.info("Se realiza la Consulta del Funcionario con identificacion (" + identificacion + ") ");
		final List resultado = query.getResultList();

		if (resultado.isEmpty()) {
			LOGGER.info("No Existe el Funcionario con identificacion (" + identificacion + ") ");
			return null;
		} else {
			return (Funcionario) resultado.get(0);
		}
	}

}
