package pact.com.signing.request_signing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Map;
import java.util.stream.Collectors;

public class Signer implements ISigner {
	
	public String rsaKey;
	
	@Override
	public String sign(String method, URI uri, Map<String, String> headers) throws NoSuchAlgorithmException,
			InvalidKeyException, SignatureException, InvalidKeySpecException, IOException {
		String textToSign = IMakeStringToSign.defaultMakeStringToSign().makeStringToSign(method, uri, headers);
		String privateKeyContent=rsaKey;
		if(rsaKey==null)
		privateKeyContent = RSAKeyGeneratorUtil.trimRSAKeyStringHeaderAndFooters(RSAKeyReader.getKey("priv8.pem"));
		return signTheData(textToSign, RSAKeyGeneratorUtil.generatePrivatekeyFromString(privateKeyContent));
	}
	private String signTheData(String input, RSAPrivateKey privKey)
			throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
		Signature rsaSha256Signature = Signature.getInstance("SHA256withRSA");
		rsaSha256Signature.initSign(privKey);
		rsaSha256Signature.update(input.getBytes("UTF-8"));
		byte[] signed2 = rsaSha256Signature.sign();
		return Base64.getEncoder().encodeToString(signed2);
	}
}
