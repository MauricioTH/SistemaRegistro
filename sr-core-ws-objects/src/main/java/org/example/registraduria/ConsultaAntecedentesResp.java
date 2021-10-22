
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
 *         &lt;element name="AntecedentesOut" type="{http://www.example.org/Registraduria/}AntecedentesResponseType"/>
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
    "antecedentesOut"
})
@XmlRootElement(name = "ConsultaAntecedentesResp")
public class ConsultaAntecedentesResp {

    @XmlElement(name = "AntecedentesOut", required = true)
    protected AntecedentesResponseType antecedentesOut;

    /**
     * Gets the value of the antecedentesOut property.
     * 
     * @return
     *     possible object is
     *     {@link AntecedentesResponseType }
     *     
     */
    public AntecedentesResponseType getAntecedentesOut() {
        return antecedentesOut;
    }

    /**
     * Sets the value of the antecedentesOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link AntecedentesResponseType }
     *     
     */
    public void setAntecedentesOut(AntecedentesResponseType value) {
        this.antecedentesOut = value;
    }

}
