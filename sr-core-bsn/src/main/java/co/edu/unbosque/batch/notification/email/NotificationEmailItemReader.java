package co.edu.unbosque.batch.notification.email;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.stereotype.Service;

import co.edu.unbosque.persistence.model.Usuario;

/**
 * 
 * @author Mauricio Tascon
 *
 */
@Service
@StepScope
public class NotificationEmailItemReader
		extends JpaPagingItemReader<Usuario> {

	@Resource
	private EntityManagerFactory entityManagerFactory;

	
	@PostConstruct
	public void init() {
		this.setEntityManagerFactory(entityManagerFactory);
		this.setQueryString(getQueryConfirmPhoneCallTransaction());
		this.setParameterValues(fillParamsQuery());
	}

	/**
	 * Fill necessary parameters to consult
	 * 
	 * @return Map Of parameters query
	 */
	@SuppressWarnings("unused")
	private Map<String, Object> fillParamsQuery() {
		Date fechaDesde = new Date();
		Date fechaActual = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaDesde); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, -7); // numero de días a restar,
		Map<String, Object> params = new HashMap<>(1);
		params.put("notificacionEmail", false);
//		params.put("today", calendar.getTime());
//		params.put("today2", fechaActual);
		return params;
	}

	/**
	 * Get the query of transactions
	 * 
	 * @return
	 */
	private String getQueryConfirmPhoneCallTransaction() {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select u from Usuario u  ");				
		jpql.append(" WHERE u.notificacionEmail =:notificacionEmail ");
		//jpql.append(" and u.fechaCreacion >= :today and u.fechaCreacion <= :today2 ");
		return jpql.toString();
	}

	

}
