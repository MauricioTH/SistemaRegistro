/*
 * BundleKeys
 *
 * GSI - Integración
 * Creado el: 22 de agosto de 2014
 *
 * Copyright (c) A Toda Hora S.A. Todos los derechos reservados
 *
 * Este software es confidencial y es propietario de ATH, queda prohibido
 * su uso, reproducción y copia de manera parcial o permanente salvo autorización
 * expresa de A Toda Hora S.A o de quién represente sus derechos.
 */

package co.edu.unbosque.bundles.i18n;

/**
 * Contiene la declaración del nombre de las llaves de los mensajes de
 * internacionalización y localización.
 * 
 * @author proveedor_zagarcia
 * @version 1.0
 * @since 1.0
 *
 */
public interface BundleKeys {
	
	/**
	 * Transacción exitosa
	 */
	String TRANSACTION_SUCCESS = "transaction.success";
	
	
	/* ******************* Llaves de errores *********************************/
	
	/**
	 * Error desconocido	
	 */
	String ERROR_UNKNOWN_ERROR = "general.error.unknown_error";
	
	/**
	 * Llave de Bundle no encontrada
	 */
	String ERROR_UNKNOWN_KEY = "unknown.key";
	
	/**
	 * Error en validación de objeto: El atributo es nulo.
	 */
	String ERROR_NULL_VALUE = "validator.attribute.null";
	
	/**
	 * Error en validación de objeto: El valor del atributo es vacío.
	 */
	String ERROR_EMPTY_VALUE = "validator.attribute.empty";
	
	/**
	 * Error en validación de objeto: Dirección de email inválida.
	 */
	String ERROR_INVALID_EMAIL = "validator.attribute.invalidEmail";
	
	/**
	 * Error en validación de objeto:
	 * 	"{0}" no puede representarse como un número entero.
	 */
	String ERROR_NO_INT_VALUE = "validator.attribute.noIntValue";

	
	
	/**
	 * Canal de origen inválido.
	 */
	String ERROR_INVALID_CHANNEL_SOURCE = "validation.1.description";
	
	/**
	 * Fecha de solicitud inválida.
	 */
	String ERROR_INVALID_REQUEST_DATE = "validation.2.description";
	
	/**
     * Dirección IP Inválida.
     */
	String ERROR_INVALID_IP_ADDRESS = "validation.3.description";
	
	/**
     * El tipo de documento del cliente no es válido.
     */
	String ERROR_INVALID_DOCUMENT_TYPE = "validation.4.description";
	
	/**
     * El número de identificación del cliente no es válido.
     */
	String ERROR_INVALID_DOCUMENT_ID = "validation.5.description";
	
	/**
	 * El identificador del convenio no es válido.
	 */
	String ERROR_INVALID_AGREEMENT_ID = "validation.6.description";
	
	/**
	 * La URL de retorno especificada no es válida.
	 */
	String ERROR_INVALID_URL = "validation.7.description";
	
	/**
	 * Datos de inicio de sesión inválidos.
	 */
	String ERROR_INVALID_AUTH_DATA = "validation.8.description";
	
	/**
	 * La dirección de email proporcionada no es válida.
	 */
	String ERROR_INVALID_CUSTOMER_EMAIL = "validation.9.description";
    
    /**
     * El valor total de la transaccion es inválido.
     */
    String ERROR_INVALID_TOTAL_VALUE = "validation.11.description";
    
    /**
     * El valor total es menor o igual a cero.
     */
    String ERROR_INVALID_TOTAL_VALUE_LESS_OR_EQUALS_THAN_ZERO = 
    									"validation.11.lessOrEqualsThanZero";
    
    /**
     * La moneda usada en la transacción no es válida.
     */
    String ERROR_INVALID_CURRENCY_TYPE = "validation.12.description";
    
    /**
     * El tipo de moenda {0} no est\u00E1 soportado.
     */
    String ERROR_INVALID_CURRENCY_TYPE_NOT_SUPPORTED = "validation.12.notSupported";
    
    /**
     * El valor del impuesto no es válido.
     */
    String ERROR_INVALID_TAX_VALUE = "validation.13.description";
    
    /**
     * El valor del impuesto es menor que cero.
     */
    String ERROR_INVALID_TAX_VALUE_LESS_THAN_ZERO = "validation.13.lessThanZero";
    
    /**
     * El tipo de transacción solicitada no es válida
     */
    String ERROR_INVALID_TRANSACTION_TYPE = "validation.14.description";
    
    /**
     * No se encontró un tipo de tranzacción con código {0}.
     */
    String ERROR_INVALID_TRANSACTION_TYPE_NOT_FOUND = "validation.14.notFound";
    
    /**
     * El Identificador de la transacción es inválido.
     */
    String ERROR_INVALID_TRANSACTION_ID = "validation.15.description";
    
    /**
     * No se encontró una transacción con código {0}
     */
    String ERROR_INVALID_TRANSACTION_ID_NOT_FOUND = "validation.15.notFound";
    
    /**
     * No se encontró una transacción con código {0}
     */
    String ERROR_INVALID_TRANSACTION_ID_NURA_CODE_NOT_FOUND = "validation.15.idTransactionNuraCode.notFound";
    
    /**
     * El token que identifica la transacción no es válido.
     */
    String ERROR_INVALID_TRANSACTION_TOKEN = "validation.16.description";
    
    /**
     * No se encontró un token con el código {0}.
     */
    String ERROR_INVALID_TRANSACTION_TOKEN_NOT_FOUND = "validation.16.notFound";
    
    /**
     * El token con el código {0} expiro.
     */
    String ERROR_INVALID_TRANSACTION_TOKEN_TIME_OUT = "validation.16.timeout";
    
    /**
     * El número telefónico no es válido.
     */
    String ERROR_INVALID_PHONE_NUMBER = "validation.17.description";
    
    /**
     * El código del banco es inválido.
     */
    String ERROR_INVALID_BANK_ID = "validation.18.description";
    
    /**
     * No se encontró un banco con código {0}.
     */
    String ERROR_INVALID_BANK_ID_NOT_FOUND = "validation.18.notFound";
    
    /**
     * No se encontró un banco con código {0}.
     */
    String ERROR_INVALID_BANK_AVAL_CODE_NOT_FOUND = "validation.18.avavlCodeNotFound";
    
    /**
     * El número de factura o referencia de pago es inválida. 
     */
    String ERROR_INVALID_ORDER_NUMBER = "validation.19.description";
    
    /**
     * El tipo de cliente no es válido.
     */
    String ERROR_INVALID_CUSTOMER_TYPE = "validation.20.description";
    
    /**
     * La Franquicia es inválida
     */
    String ERROR_INVALID_BRAND = "validation.21.description";
    
    /**
     * No se encontró una franquicia con código {0}.
     */
    String ERROR_INVALID_BRAND_NOT_FOUND = "validation.21.notFound";
    
    /**
     * El número de la tarjeta de crédito no es válido.
     */
    String ERROR_INVALID_CREDIT_CARD = "validation.22.description";
    
    /**
     * El identificador del medio de pago no es válido.
     */
    String ERROR_INVALID_PAYMENT_WAY = "validation.23.description";
    
    /**
     * No se encontró medio de pago con código {0}.
     */
    String ERROR_INVALID_PAYMENT_WAY_NOT_FOUND = "validation.23.notFound";
    
    /**
     * El tipo de producto no es válido.
     */
    String ERROR_INVALID_PRODUCT_TYPE = "validation.24.description";
    
    /**
     * No se encontró medio tipo de producto con código {0}.
     */
    String ERROR_INVALID_PRODUCT_TYPE_NOT_FOUND = "validation.24.notFound";

    /**
     * Estado inválido de la transacción para la operación solicitada.
     */
    String ERROR_INVALID_TRANSACTION_STATUS_FOR_OPERATION = "validation.25.description";
    
    /**
	 * Estado APROBADO del numero de orden inválido.
	 */
	String ERROR_INVALID_ORDER_NUMBER_APPROVED = "validation.26.description";
	
	/**
	 * Estado PENDIENTE del numero de orden inválido.
	 */
	String ERROR_INVALID_ORDER_NUMBER_PENDING = "validation.27.description";
	
	/**
	 * Estado de negocio inválido.
	 */
	String ERROR_INVALID_BUSINESS_STATUS = "validation.28.description";
	
	/**
     * No se encontró una transacción con código {0}
     */
    String ERROR_INVALID_TRANSACTION_PMTID_NOT_FOUND = "validation.29.notFound";
    
    /**
     * El PmtI de la transacción es inválido.
     */
    String ERROR_INVALID_TRANSACTION_PMTID = "validation.29.description";
    
    /**
	 * Estado PENDIENTE del numero de orden inválido.
	 */
	String ERROR_INVALID_ORDER_NUMBER_PENDING_PSE = "validation.30.description";
	
	
	
}
