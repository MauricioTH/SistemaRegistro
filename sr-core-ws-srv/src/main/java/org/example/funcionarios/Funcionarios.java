
package org.example.funcionarios;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Funcionarios", targetNamespace = "http://www.example.org/Funcionarios/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Funcionarios {


    /**
     * 
     * @param funcionarioIn
     * @return
     *     returns org.example.funcionarios.ResponseType
     */
    @WebMethod(operationName = "GetFuncionario", action = "http://www.example.org/Funcionarios/GetFuncionario")
    @WebResult(name = "GetFuncionarioOut", targetNamespace = "")
    @RequestWrapper(localName = "GetFuncionario", targetNamespace = "http://www.example.org/Funcionarios/", className = "org.example.funcionarios.GetFuncionario")
    @ResponseWrapper(localName = "GetFuncionarioResponse", targetNamespace = "http://www.example.org/Funcionarios/", className = "org.example.funcionarios.GetFuncionarioResponse")
    public ResponseType getFuncionario(
        @WebParam(name = "funcionarioIn", targetNamespace = "")
        FuncionarioType funcionarioIn);

}
