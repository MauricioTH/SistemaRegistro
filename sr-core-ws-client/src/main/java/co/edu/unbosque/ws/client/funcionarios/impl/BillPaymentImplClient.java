package co.edu.unbosque.ws.client.funcionarios.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import org.example.funcionarios.Funcionarios;
import org.example.funcionarios.Funcionarios_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import co.com.ath.pse.ws.client.util.WebServiceClientUtil;
import co.com.ath.pse.ws.client.util.XTrustProvider;




/**
 * Implementación del cliente del servicio GetFuncionario
 * @author Mauricio Tascon
 * @version 1.0
 * @since 1.0
 */
public class BillPaymentImplClient {
	
	static Logger LOGGER = LoggerFactory.getLogger(BillPaymentImplClient.class);
	
	
	public BillPaymentImplClient(){
		
	}
	
	/** Verifica e indica que el nombre del host es valido */
	static {
	    HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier(){
			@Override
			public boolean verify(String hostname, SSLSession arg1) {
				/*
                if (hostname.equals("localhost")){
                	return true;
                }
                return false;
                */
				return true;
			}
        });
	}
	
	
	/** EndPoint donde se encuentra el servicio */
    private String urlEndPoint;
    
    /** Objeto que consume el servicio */
    private Funcionarios client;
    
    /** Constructor que recibe la url del EndPoint a consumir 
     * @throws MalformedURLException */
    public void billPaymentImplClient(String urlEndPoint) throws MalformedURLException, WebServiceException{
    	LOGGER.info("Iniciando cliente para EndPoint-> {}", urlEndPoint);
    	this.urlEndPoint = urlEndPoint;
        try {
			init();
		} catch (WebServiceException e) {
			LOGGER.error("Error, no se pudo inicializar el EndPoint \n{}", e);
			throw e;
		} catch (RuntimeException runtimeException) {
			LOGGER.error("Error inicializando cliente BillPaymentImplClient: \n{}", runtimeException);
			throw runtimeException;
		}
    }

    
    /**
     * Inicia el contexto del cliente
     * @throws MalformedURLException 
     */
    private void init() throws MalformedURLException {
    	XTrustProvider.install();
    	Funcionarios_Service service = new Funcionarios_Service(new URL(this.urlEndPoint));
		this.client = service.getFuncionariosSOAP();
        WebServiceClientUtil.attachEndPointToClient((BindingProvider) this.client, this.urlEndPoint);
        LOGGER.info("Cliente iniciado... ");
    }

    
	/**
	 * @return the urlEndPoint
	 */
	public String getUrlEndPoint() {
		return urlEndPoint;
	}

	/**
	 * @return the client
	 */
	public Funcionarios getClient() {
		return client;
	}

}
