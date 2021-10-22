
package org.example.registraduria;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UsuarioIn" type="{http://www.example.org/Registraduria/}RegistroType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "usuarioIn"
})
@XmlRootElement(name = "RegistroUsuarioReq")
public class RegistroUsuarioReq {

    @XmlElement(name = "UsuarioIn", required = true)
    protected RegistroType usuarioIn;

    /**
     * Gets the value of the usuarioIn property.
     * 
     * @return
     *     possible object is
     *     {@link RegistroType }
     *     
     */
    public RegistroType getUsuarioIn() {
        return usuarioIn;
    }

    /**
     * Sets the value of the usuarioIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistroType }
     *     
     */
    public void setUsuarioIn(RegistroType value) {
        this.usuarioIn = value;
    }

}
