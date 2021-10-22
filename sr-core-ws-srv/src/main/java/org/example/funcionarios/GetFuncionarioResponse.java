
package org.example.funcionarios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetFuncionarioOut" type="{http://www.example.org/Funcionarios/}responseType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getFuncionarioOut"
})
@XmlRootElement(name = "GetFuncionarioResponse")
public class GetFuncionarioResponse {

    @XmlElement(name = "GetFuncionarioOut", required = true)
    protected ResponseType getFuncionarioOut;

    /**
     * Obtiene el valor de la propiedad getFuncionarioOut.
     * 
     * @return
     *     possible object is
     *     {@link ResponseType }
     *     
     */
    public ResponseType getGetFuncionarioOut() {
        return getFuncionarioOut;
    }

    /**
     * Define el valor de la propiedad getFuncionarioOut.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *     
     */
    public void setGetFuncionarioOut(ResponseType value) {
        this.getFuncionarioOut = value;
    }

}
