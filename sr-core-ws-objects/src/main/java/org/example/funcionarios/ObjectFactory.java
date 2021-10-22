
package org.example.funcionarios;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.funcionarios package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.funcionarios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFuncionario }
     * 
     */
    public GetFuncionario createGetFuncionario() {
        return new GetFuncionario();
    }

    /**
     * Create an instance of {@link FuncionarioType }
     * 
     */
    public FuncionarioType createFuncionarioType() {
        return new FuncionarioType();
    }

    /**
     * Create an instance of {@link GetFuncionarioResponse }
     * 
     */
    public GetFuncionarioResponse createGetFuncionarioResponse() {
        return new GetFuncionarioResponse();
    }

    /**
     * Create an instance of {@link ResponseType }
     * 
     */
    public ResponseType createResponseType() {
        return new ResponseType();
    }

}
