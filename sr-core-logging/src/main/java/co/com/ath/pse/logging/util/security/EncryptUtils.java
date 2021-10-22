package co.com.ath.pse.logging.util.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utilidad para encriptar
 * @author Mauricio Tascon
 * @version 1.0
 * @since 1.0
 */
public class EncryptUtils {

	static Logger LOGGER = LoggerFactory.getLogger(EncryptUtils.class);

	public static final String DEFAULT_ENCODING="UTF-8"; 

	static DatatypeConverter enc;

	static DatatypeConverter dec;


	/**
	 * Encripta en base64
	 * @param text
	 * @return
	 */
	public static String base64encode(String text){
		try {
			String rez = DatatypeConverter.printBase64Binary(text.getBytes( DEFAULT_ENCODING ) );
			return rez;
		}
		catch ( UnsupportedEncodingException e ) {
			LOGGER.warn("Error encriptando.", e);
			return null;
		}
	}


	/**
	 * Desencripta en base64
	 * @param text
	 * @return
	 */
	public static String base64decode(String text){
		try {
			return new String(DatatypeConverter.parseBase64Binary( text ),DEFAULT_ENCODING);
		}
		catch ( IOException e ) {
			LOGGER.warn("Error desencriptando.", e);
			return null;
		}
	}


	/**
	 * Frase clave basada en ingeniería XOR
	 * @param message
	 * @param key
	 * @return
	 */
	public static String xorMessage(String message, String key){
		if (message==null || key==null ) return null;

		char[] keys=key.toCharArray();
		char[] mesg=message.toCharArray();

		int ml=mesg.length;
		int kl=keys.length;
		char[] newmsg=new char[ml];

		for (int i=0; i<ml; i++){
			newmsg[i]=(char)(mesg[i]^keys[i%kl]);
		}
		mesg=null; keys=null;
		return new String(newmsg);
	}

}

