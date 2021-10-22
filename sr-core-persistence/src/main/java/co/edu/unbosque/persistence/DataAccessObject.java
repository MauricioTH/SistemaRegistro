/*
 * DataAccessObject
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

import java.util.List;
import javax.transaction.Transactional;

/**
 * Define el comportamiento básico que debe tener un Objeto de Acceso a Datos
 *
 * @author Mauricio Tascon
 * @version 1.0
 * @param <P>
 * @since 1.0
 */
public interface DataAccessObject<P> {

    /**
     * Crea un registro en el sistema de almacenamiento persistente con los
     * datos del objeto persistente.
     *
     * @param persistentObj
     * @return
     */
    public P create(P persistentObj);

    /**
     * Busca un objeto persistente por su id
     *
     * @param id Identificador del objeto persistente
     * @return
     */
    public P read(Object id);

    /**
     * Realiza la actualización de datos en un objeto persistente
     *
     * @param persistentObj Entidad a ser actualizada
     */
    @Transactional
    public void update(P persistentObj);

    /**
     * Elimina una entidad persistente
     *
     * @param persistentObj Entidad a eliminar
     */
    @Transactional
    public void delete(P persistentObj);

    /**
     * Realiza marca lógica de borrado en una entidad persistente
     *
     * @param persistentObj Entidad a eliminar
     */
    @Transactional
    public void logicDelete(P persistentObj);

    /**
     * Lista todos registros de la entidad
     *
     * @return
     */
    @Transactional
    public List<P> listAll();

    /**
     * Lista todos los registros de una entidad que no tengan marca lógica de
     * borrado.
     *
     * @return
     */
    @Transactional
    public List<P> listAllActive();

    /**
     * Cierra el Objeto de acceso a datos.
     */
    public void close();

}
