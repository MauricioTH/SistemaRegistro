package co.com.ath.pse.logging.constants;

/**
 * Constantes para logging
 * @author proveedor_cjmurillo
 * @version 1.0
 * @since 1.0
 */
public interface LoggingConstants {

	/* Define si se deben encriptar los valores de los notos que soliciten el servicio. 
	 	Esta variable debe ser siempre = true en producción */
	public static final boolean CRYPTO_XML_ELEMENT 		= true;
	
	/* Define si se deben enmascarar los valores de los notos que soliciten el servicio. 
 	Esta variable debe ser siempre = true en producción */
	public static final boolean MASK_XML_ELEMENT 		= true;
	
	
	/* Cuantos "ultimos" carácteres se deben mostrar cuando se enmascara. 
 	Esta variable debe ser siempre. */
	public static final int LAST_CHART_MASK_SHOW 		= 4;
	
	/* Caracter que define el remplazo cuando se enmascara. 
 	Esta variable debe ser siempre. */
	public static final String MASK_CHART 				= "*";
	
	public static final String MASK_LARGE_STRING			= "*************";
	
	public static final String MASK_SMALL_STRING			= "***";
}
