package co.edu.unbosque.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import co.edu.unbosque.persistence.dao.UsuarioDAO;
import co.edu.unbosque.persistence.model.Usuario;
import co.edu.unbosque.persistence.AbstractDAO_JPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class UsuarioDAOImpl extends AbstractDAO_JPA<Usuario> implements UsuarioDAO{
	
	
	static Logger LOGGER = LoggerFactory.getLogger(UsuarioDAOImpl.class.getName());

	

	public UsuarioDAOImpl() {
		super(Usuario.class);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Usuario findByIdentificacion(Integer identificacion) {
		final StringBuilder hql = new StringBuilder();
		hql.append("select u from Usuario u where u.identificacion = :identificacion");
		final Query query = entityManager.createQuery(hql.toString());
		query.setParameter("identificacion", identificacion);
		
		LOGGER.info("Se realiza la Consulta del Usuario con identificacion (" + identificacion + ") ");
		final List resultado = query.getResultList();

		if (resultado.isEmpty()) {
			LOGGER.info("No Existe usuario (" + identificacion + ") ");
			return null;
		} else {
			return (Usuario) resultado.get(0);
		}
	}

	@Override
	@SuppressWarnings("rawtypes")
	@Transactional
	public Usuario findByUserAndPassword(Integer identificacion, String password) {
		final StringBuilder hql = new StringBuilder();
		hql.append("select u from Usuario u where u.identificacion.identificacion = :identificacion ");
		hql.append(" and u.contrasena = :contrasena ");
		final Query query = entityManager.createQuery(hql.toString());
		query.setParameter("identificacion", identificacion);
		query.setParameter("contrasena", password);
		
		LOGGER.info("Se realiza la Consulta del Usuario con identificacion (" + identificacion + ") ");
		final List resultado = query.getResultList();

		if (resultado.isEmpty()) {
			LOGGER.info("No Existe usuario (" + identificacion + ") ");
			return null;
		} else {
			return (Usuario) resultado.get(0);
		}
	}

	
	
}
