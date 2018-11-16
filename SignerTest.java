package pact.com.signing.request_signing;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;
import junit.framework.Assert;

public class SignerTest {

	ISigner signer = ISigner.defaultSigner();

	@Test
	public void testCanSignString() throws Exception {
		String expectedSignature = "F6bO1fWiZ4Xgx2mslGBtnAHAUejfWa+CdiHOt7UUhJ37EUlevtHFK29bpUvZGtz+iwdcblNoLzRsTg1VadNEVw==";
		Assert.assertEquals(expectedSignature, signer.sign("Get", URI.create("/foo"), map()));
	}

	private Map<String, String> map() {
		Map<String, String> map = new LinkedHashMap();
		map.put("date", "Tue, 07 Jun 2014 20:51:35 GMT");
		map.put("digest", "SHA256=47DEQpj8HBSa+/TImW+5JCeuQeRkm5NMpJWZG3hSuFU=");
		map.put("X-ING-ReqID", "12345");
		return map;
	}

}
