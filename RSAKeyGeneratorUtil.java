package pact.com.signing.request_signing;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class RSAKeyGeneratorUtil {
	
	public static String trimRSAKeyStringHeaderAndFooters(String rsaFile) {
		return rsaFile.replaceAll("\r\n", "").replace("-----BEGIN PRIVATE KEY-----", "")
				.replace("-----END PRIVATE KEY-----", "").replaceAll("\n", "");
	}

	public static RSAPrivateKey generatePrivatekeyFromString(String privateKeyContent)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec privSpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyContent));
		return (RSAPrivateKey) keyFactory.generatePrivate(privSpec);

	}

}
