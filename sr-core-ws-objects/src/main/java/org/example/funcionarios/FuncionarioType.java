
package org.example.funcionarios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para funcionarioType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="funcionarioType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RqUID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Fecha_consulta" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="identificacion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombres" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="apellidos" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fuerza_publica" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="rango" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idfuerzacorreoelectronco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "funcionarioType", propOrder = {
    "rqUID",
    "fechaConsulta",
    "identificacion",
    "nombres",
    "apellidos",
    "fuerzaPublica",
    "rango",
    "idfuerzacorreoelectronco"
})
public class FuncionarioType {

    @XmlElement(name = "RqUID", required = true)
    protected String rqUID;
    @XmlElement(name = "Fecha_consulta", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaConsulta;
    protected int identificacion;
    @XmlElement(required = true)
    protected String nombres;
    @XmlElement(required = true)
    protected String apellidos;
    @XmlElement(name = "fuerza_publica", required = true)
    protected String fuerzaPublica;
    @XmlElement(required = true)
    protected String rango;
    protected String idfuerzacorreoelectronco;

    /**
     * Obtiene el valor de la propiedad rqUID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRqUID() {
        return rqUID;
    }

    /**
     * Define el valor de la propiedad rqUID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRqUID(String value) {
        this.rqUID = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaConsulta.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaConsulta() {
        return fechaConsulta;
    }

    /**
     * Define el valor de la propiedad fechaConsulta.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaConsulta(XMLGregorianCalendar value) {
        this.fechaConsulta = value;
    }

    /**
     * Obtiene el valor de la propiedad identificacion.
     * 
     */
    public int getIdentificacion() {
        return identificacion;
    }

    /**
     * Define el valor de la propiedad identificacion.
     * 
     */
    public void setIdentificacion(int value) {
        this.identificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad nombres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Define el valor de la propiedad nombres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombres(String value) {
        this.nombres = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Define el valor de la propiedad apellidos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidos(String value) {
        this.apellidos = value;
    }

    /**
     * Obtiene el valor de la propiedad fuerzaPublica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuerzaPublica() {
        return fuerzaPublica;
    }

    /**
     * Define el valor de la propiedad fuerzaPublica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuerzaPublica(String value) {
        this.fuerzaPublica = value;
    }

    /**
     * Obtiene el valor de la propiedad rango.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRango() {
        return rango;
    }

    /**
     * Define el valor de la propiedad rango.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRango(String value) {
        this.rango = value;
    }

    /**
     * Obtiene el valor de la propiedad idfuerzacorreoelectronco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdfuerzacorreoelectronco() {
        return idfuerzacorreoelectronco;
    }

    /**
     * Define el valor de la propiedad idfuerzacorreoelectronco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdfuerzacorreoelectronco(String value) {
        this.idfuerzacorreoelectronco = value;
    }

}
