
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
 *         &lt;element name="AntecedentesIn" type="{http://www.example.org/Registraduria/}AntecedentesType"/>
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
    "antecedentesIn"
})
@XmlRootElement(name = "ConsultaAntecedentesReq")
public class ConsultaAntecedentesReq {

    @XmlElement(name = "AntecedentesIn", required = true)
    protected AntecedentesType antecedentesIn;

    /**
     * Gets the value of the antecedentesIn property.
     * 
     * @return
     *     possible object is
     *     {@link AntecedentesType }
     *     
     */
    public AntecedentesType getAntecedentesIn() {
        return antecedentesIn;
    }

    /**
     * Sets the value of the antecedentesIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link AntecedentesType }
     *     
     */
    public void setAntecedentesIn(AntecedentesType value) {
        this.antecedentesIn = value;
    }

}
