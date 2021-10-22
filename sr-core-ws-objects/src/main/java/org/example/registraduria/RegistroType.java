
package org.example.registraduria;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RegistroType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegistroType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RqUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fecha_Registro" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Identificacion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Nombres" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Apellidos" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Fuerza_Publica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Rango" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistroType", propOrder = {
    "rqUID",
    "fechaRegistro",
    "identificacion",
    "nombres",
    "apellidos",
    "fuerzaPublica",
    "rango",
    "email"
})
public class RegistroType {

    @XmlElement(name = "RqUID")
    protected String rqUID;
    @XmlElement(name = "Fecha_Registro", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaRegistro;
    @XmlElement(name = "Identificacion")
    protected int identificacion;
    @XmlElement(name = "Nombres", required = true)
    protected String nombres;
    @XmlElement(name = "Apellidos", required = true)
    protected String apellidos;
    @XmlElement(name = "Fuerza_Publica", required = true)
    protected String fuerzaPublica;
    @XmlElement(name = "Rango", required = true)
    protected String rango;
    @XmlElement(name = "Email", required = true)
    protected String email;

    /**
     * Gets the value of the rqUID property.
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
     * Sets the value of the rqUID property.
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
     * Gets the value of the fechaRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Sets the value of the fechaRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaRegistro(XMLGregorianCalendar value) {
        this.fechaRegistro = value;
    }

    /**
     * Gets the value of the identificacion property.
     * 
     */
    public int getIdentificacion() {
        return identificacion;
    }

    /**
     * Sets the value of the identificacion property.
     * 
     */
    public void setIdentificacion(int value) {
        this.identificacion = value;
    }

    /**
     * Gets the value of the nombres property.
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
     * Sets the value of the nombres property.
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
     * Gets the value of the apellidos property.
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
     * Sets the value of the apellidos property.
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
     * Gets the value of the fuerzaPublica property.
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
     * Sets the value of the fuerzaPublica property.
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
     * Gets the value of the rango property.
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
     * Sets the value of the rango property.
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
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

}
