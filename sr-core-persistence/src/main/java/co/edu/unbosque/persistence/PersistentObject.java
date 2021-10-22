/*
 * PersistentObject
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

import java.io.Serializable;
import java.util.Date;

/**
 * Define el tipo que comparten todos los objetos del modelo persistente
 *
 * @author Mauricio Tascon
 * @version 1.0
 * @since 1.0
 */
public interface PersistentObject extends Serializable {

    /**
     * Indica si el registro tiene marca de borrado lógico
     *
     * @return
     */
    public boolean isRowDeleted();

    /**
     * Modifica el estado de borrado del registro
     *
     * @param rowDeleted Indica si se borra el registro
     */
    public void setRowDeleted(boolean rowDeleted);

    /**
     * Retorna la fecha de creación del registro
     *
     * @return
     */
    public Date getRowCreationDate();

    /**
     * Establece la fecha de creación del registro
     *
     * @param rowCreationDate Fecha de creación del registro
     */
    public void setRowCreationDate(Date rowCreationDate);

    /**
     * Devuelve la fecha de la última modificación del registro
     *
     * @return
     */
    public Date getRowLastUpdate();

    /**
     * Modifica la fecha de la última modificación del registro
     *
     * @param rowLastUpdate Fecha de modificación del registro
     */
    public void setRowLastUpdate(Date rowLastUpdate);
}