/*
 * AbstractDAO_JPA
 *
 * GSI - Integración
 * Creado el: 22 de agosto de 2014
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 *
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */
package co.edu.unbosque.persistence;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementación genérica del interface DataAccessObject para JPA, se utiliza
 * Hibernate ORM como manejador de capa de persistencia
 *
 * @author Mauricio Tascon
 * @version 1.0
 * @param <P>
 * @since 1.0
 */
public abstract class AbstractDAO_JPA<P extends PersistentObject> implements DataAccessObject<P> {

    static Logger LOGGER = LoggerFactory.getLogger(AbstractDAO_JPA.class);

    /**
     * Clase que manejará el DAO
     */
    protected Class<P> type;
    

    /**
     * Entity Manager
     */
    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Constructor del DAO Genérico JPA
     *
     * @param type Clase que manejará el DAO
     */
    protected AbstractDAO_JPA(Class<P> type) {
        this.type = type;
    }
    
    
  
    
    @Override
    @Transactional
    public P create(P persistentObj) {
        persistentObj.setRowDeleted(false);
        entityManager.persist(persistentObj);
        return persistentObj;
    }

    @Override
    @Transactional
    public P read(Object id) {
        return (P) entityManager.find(type, id);
    }

    @Override
    public void update(P persistentObj) {
        persistentObj.setRowLastUpdate(new Date());
        entityManager.merge(persistentObj);
    }

    @Override
    public void delete(P persistentObj) {
        entityManager.remove(entityManager.merge(persistentObj));
    }

    @Override
    public void logicDelete(P persistentObj) {
        persistentObj.setRowDeleted(true);
        update(persistentObj);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<P> listAll() {
        StringBuilder sb = new StringBuilder("from ");
        sb.append(type.getName());
        Query query = entityManager.createQuery(sb.toString());
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<P> listAllActive() {
        StringBuilder sb = new StringBuilder("from ");
        sb.append(type.getName());
        sb.append(" e where e.rowDeleted <> 1");
        Query query = entityManager.createQuery(sb.toString());
        return query.getResultList();
    }

    @Override
    public void close() {
        LOGGER.info("...");
        if (entityManager != null) {
            entityManager.clear();
            entityManager.close();
        }
    }
    
   

}
