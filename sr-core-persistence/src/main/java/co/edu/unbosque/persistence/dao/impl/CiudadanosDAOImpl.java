package co.edu.unbosque.persistence.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.persistence.AbstractDAO_JPA;
import co.edu.unbosque.persistence.dao.CiudadanosDAO;
import co.edu.unbosque.persistence.model.Ciudadano;


@Repository
public class CiudadanosDAOImpl extends AbstractDAO_JPA<Ciudadano> implements CiudadanosDAO{
	
	
	static Logger LOGGER = LoggerFactory.getLogger(CiudadanosDAOImpl.class.getName());

	

	public CiudadanosDAOImpl() {
		super(Ciudadano.class);

	}



	@SuppressWarnings("rawtypes")
	@Override
	public Ciudadano findByIdentificacion(Integer identificacion) {
		final StringBuilder hql = new StringBuilder();
		hql.append("select c from Ciudadano c where c.identificacion = :identificacion");
		final Query query = entityManager.createQuery(hql.toString());
		query.setParameter("identificacion", identificacion);
		
		LOGGER.info("Se realiza la Consulta del Ciudadano con identificacion (" + identificacion + ") ");
		final List resultado = query.getResultList();

		if (resultado.isEmpty()) {
			LOGGER.info("No Existe usuario (" + identificacion + ") ");
			return null;
		} else {
			return (Ciudadano) resultado.get(0);
		}
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudadano> buscarTodos() {
		// TODO Auto-generated method stub
		List<Ciudadano> ciudadanos=null;
		StringBuilder hql = new StringBuilder();
		hql.append("select c from Ciudadano c ");
		Query query = entityManager.createQuery(hql.toString());
		ciudadanos = query.getResultList();
		return ciudadanos;
	}



	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public  List<Ciudadano> getRequeridos(Date fechaDesde, Date fechaHasta) {
		StringBuilder sql = new StringBuilder();
        SimpleDateFormat formatoDeFecha = null;
        formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
        List<Ciudadano> listRequeridos=null;      
        try {			
            sql.append("SELECT c FROM Ciudadano c LEFT JOIN c.antecedentesciudadanosList as ac  ");         
            sql.append("LEFT JOIN ac.idantecedente a WHERE c.identificacion=ac.identificacion.identificacion ");
            sql.append("AND ac.idantecedente.id=a.id ");
            sql.append("AND ac.requerido=:requerido ");
            if (fechaDesde != null && fechaHasta != null)
            {
             sql.append("and ac.fechaRegistro BETWEEN to_date('").append(formatoDeFecha.format(fechaDesde)).append("','dd-MM-yyyy') and to_date('").append(formatoDeFecha.format(fechaHasta)).append("','dd-MM-yyyy') ");
            }
            
            Query query = entityManager.createQuery(sql.toString());
            query.setParameter("requerido", true);           
            listRequeridos = query.getResultList();
        	
		} catch (Exception e) {
			throw e;
		}
		return listRequeridos;
	}

	
	
	@SuppressWarnings({ "unchecked", "unused" })
	
	public  List<Ciudadano> getRequeridosPorDate(Date fechaDesde, Date fechaHasta) {
		StringBuilder sql = new StringBuilder();
        SimpleDateFormat formatoDeFecha = null;
        formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
        List<Ciudadano> listRequeridos=null;      
        try {			
            sql.append("SELECT c FROM Ciudadano c LEFT JOIN c.antecedentesciudadanosList as ac  ");         
            sql.append("LEFT JOIN ac.idantecedente a WHERE c.identificacion=ac.identificacion.identificacion ");
            sql.append("AND ac.idantecedente.id=a.id ");
            sql.append("AND ac.requerido=:requerido ");
            Query query = entityManager.createQuery(sql.toString());
            query.setParameter("requerido", true);           
            listRequeridos = query.getResultList();
        	
		} catch (Exception e) {
			throw e;
		}
		return listRequeridos;
	}


	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Ciudadano> getNotRequeridos(Date fechaDesde, Date fechaHasta) {
		StringBuilder sql = new StringBuilder();
        SimpleDateFormat formatoDeFecha = null;
        formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
        List<Ciudadano> listNotRequeridos=null;       
        try {			    
            sql.append(" SELECT c from Ciudadano c WHERE NOT c.identificacion IN ");
            sql.append(" ( ");
            sql.append(" SELECT ac.identificacion from Antecedentesciudadanos ac WHERE ac.requerido=:requerido ");
            sql.append(" ) ");
            
//            if (fechaDesde != null && fechaHasta != null)
//            {
//                sql.append(" AND c.fechanacimiento BETWEEN to_date('").append(formatoDeFecha.format(fechaDesde)).append("','dd-MM-yyyy') and to_date('").append(formatoDeFecha.format(fechaHasta)).append("','dd-MM-yyyy') ");
//            }
            
            Query query = entityManager.createQuery(sql.toString());
            
            query.setParameter("requerido", true);
            
            listNotRequeridos = query.getResultList();
            
            
        	
		} catch (Exception e) {
			throw e;
		}
		return listNotRequeridos;
	}
		
	
}
