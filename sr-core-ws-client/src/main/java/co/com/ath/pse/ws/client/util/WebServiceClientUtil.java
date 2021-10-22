package co.com.ath.pse.ws.client.util;


import java.net.URL;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Herramientas para la implementación de los clientes de sevicios web
 * @author proveedor_cjmurillo
 * @version 1.0
 * @since 1.0
 */
public class WebServiceClientUtil {

	static Logger LOGGER = LoggerFactory.getLogger(WebServiceClientUtil.class);

	/**
	 * Ubica en el contexto del cliente la wsdl a utilizar para consumir el servicio
	 * @param clientBinProvider
	 * @param newEndPoint
	 */
	public static void attachEndPointToClient(BindingProvider clientBinProvider,
			String newEndPoint){
		BindingProvider bindingProvider = (BindingProvider) clientBinProvider;
		Map<String, Object> mapaContext = bindingProvider.getRequestContext();
		mapaContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, newEndPoint);
	}


	/**
	 * Contextualiza la url de un cliente de ws
	 * @param url
	 * @param qName
	 * @param serviceClass
	 * @return representa eo puerto o cliente del servicio para consumir
	 */
	public static Object attachEndPointToClient (URL url, QName qName, 
			Object serviceClass){
			Service service = Service.create(url, qName);
			return service.getPort(serviceClass.getClass());
	}

}
