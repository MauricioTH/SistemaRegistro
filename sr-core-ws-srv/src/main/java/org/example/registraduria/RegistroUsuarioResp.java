
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
 *         &lt;element name="UsuarioOut" type="{http://www.example.org/Registraduria/}RegistroResponseType"/>
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
    "usuarioOut"
})
@XmlRootElement(name = "RegistroUsuarioResp")
public class RegistroUsuarioResp {

    @XmlElement(name = "UsuarioOut", required = true)
    protected RegistroResponseType usuarioOut;

    /**
     * Gets the value of the usuarioOut property.
     * 
     * @return
     *     possible object is
     *     {@link RegistroResponseType }
     *     
     */
    public RegistroResponseType getUsuarioOut() {
        return usuarioOut;
    }

    /**
     * Sets the value of the usuarioOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistroResponseType }
     *     
     */
    public void setUsuarioOut(RegistroResponseType value) {
        this.usuarioOut = value;
    }

}
