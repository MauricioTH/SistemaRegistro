package co.com.ath.pse.ws.client.util;

import java.security.AccessController;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivilegedAction;
import java.security.Security;
import java.security.cert.X509Certificate;

import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactorySpi;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Proveedor de certificados genéricos de confianza
 * @author proveedor_cjmurillo
 * @version 1.0
 * @since 1.0
 */
public final class XTrustProvider extends java.security.Provider {
        
	static Logger LOGGER = LoggerFactory.getLogger(XTrustProvider.class);
	private static final long serialVersionUID = 1L;
	private final static String NAME = "XTrustJSSE";
    private final static String INFO = "XTrust JSSE Provider (Implementa una fábrica de de confianza sin validación de almacenes de claves)";
    private final static double VERSION = 1.0D;
    
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public XTrustProvider() 
    {	
    	super(NAME, VERSION, INFO);
    	AccessController.doPrivileged(new PrivilegedAction() 
    	{
			public Object run() {
				put("TrustManagerFactory." + TrustManagerFactoryImpl.getAlgorithm(), TrustManagerFactoryImpl.class.getName());
				return null;
	    	}
    	});
    }
    
	
    /**
     * Instala los certificados de confianza
     */
    public static void install() 
    {
	    if(Security.getProvider(NAME) == null) {
	        Security.insertProviderAt(new XTrustProvider(), 2);
	        Security.setProperty("ssl.TrustManagerFactory.algorithm", TrustManagerFactoryImpl.getAlgorithm());
	    }
    }
    
    
    /**
     * fábrica de certificados
     * @author proveedor_cjmurillo
     */
    public final static class TrustManagerFactoryImpl extends TrustManagerFactorySpi 
    {
	    public TrustManagerFactoryImpl() { }
	    public static String getAlgorithm() { return "XTrust509"; }
	    protected void engineInit(KeyStore keystore) throws KeyStoreException { }
	    
	    protected void engineInit(ManagerFactoryParameters mgrparams) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException( XTrustProvider.NAME + " ManagerFactoryParameters no implementado");
	    }
        
	    /* Obtiene un arreglo de motores de certificados */
        protected TrustManager[] engineGetTrustManagers() {
	        return new TrustManager[] {
	            new X509TrustManager() {
	                public X509Certificate[] getAcceptedIssuers() { return null; }
	                public void checkClientTrusted(X509Certificate[] certs, String authType) { }
	                public void checkServerTrusted(X509Certificate[] certs, String authType) { }
	            }
	        };
        }
    }
    
    
}
