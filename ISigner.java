package pact.com.signing.request_signing;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

public interface ISigner {

	String sign(String method, URI uri, Map<String, String> header) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException, InvalidKeySpecException, IOException;
	
	static ISigner defaultSigner() {
		return new Signer();
	}
}
