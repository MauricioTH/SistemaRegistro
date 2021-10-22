
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
 *         &lt;element name="LoginOut" type="{http://www.example.org/Registraduria/}LoginResponseType"/>
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
    "loginOut"
})
@XmlRootElement(name = "LoginUsuarioResp")
public class LoginUsuarioResp {

    @XmlElement(name = "LoginOut", required = true)
    protected LoginResponseType loginOut;

    /**
     * Gets the value of the loginOut property.
     * 
     * @return
     *     possible object is
     *     {@link LoginResponseType }
     *     
     */
    public LoginResponseType getLoginOut() {
        return loginOut;
    }

    /**
     * Sets the value of the loginOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoginResponseType }
     *     
     */
    public void setLoginOut(LoginResponseType value) {
        this.loginOut = value;
    }

}
