package co.com.ath.pse.logging;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ath.pse.logging.util.security.EncryptUtils;

/**
 * Unit Test Case para la utilidad de cifrado de la plataforma PSE.
 * 
 * @author proveedor_njmoreno
 * @version 1.0 29 Marzo 2016
 * @since 1.0
 */
public class EncryptUtilsTest {

	private static final String MESSAGE = "Texto a codificar";
	private static final String CRYPTED_MESSAGE = EncryptUtils.base64encode(MESSAGE);

	@Test
	public void encodeTest() {
		assertFalse("Codificacion Fallida", MESSAGE.equals(CRYPTED_MESSAGE));
	}
	
	@Test
	public void decodeTest() {
		assertEquals("Decodificacion Fallida", MESSAGE,
				EncryptUtils.base64decode(CRYPTED_MESSAGE));
	}

}