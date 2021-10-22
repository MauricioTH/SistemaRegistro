
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
 *         &lt;element name="funcionarioIn" type="{http://www.example.org/Funcionarios/}funcionarioType"/&gt;
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
    "funcionarioIn"
})
@XmlRootElement(name = "GetFuncionario")
public class GetFuncionario {

    @XmlElement(required = true)
    protected FuncionarioType funcionarioIn;

    /**
     * Obtiene el valor de la propiedad funcionarioIn.
     * 
     * @return
     *     possible object is
     *     {@link FuncionarioType }
     *     
     */
    public FuncionarioType getFuncionarioIn() {
        return funcionarioIn;
    }

    /**
     * Define el valor de la propiedad funcionarioIn.
     * 
     * @param value
     *     allowed object is
     *     {@link FuncionarioType }
     *     
     */
    public void setFuncionarioIn(FuncionarioType value) {
        this.funcionarioIn = value;
    }

}
