package pact.com.signing.request_signing;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

public class MakeStringToSignTest {

	IMakeStringToSign makeStringToSign = IMakeStringToSign.defaultMakeStringToSign();

	@Test
	public void testCanMakeStringToSign() {
		Map<String, String> headers = map();

		String expectedStringToSign = "(request-target): get /foo\n" + "date: Tue, 07 Jun 2014 20:51:35 GMT\n"
				+ "digest: 47DEQpj8HBSa+/TImW+5JCeuQeRkm5NMpJWZG3hSuFU=\n" + "x-ing-reqid: 12345";
		Assert.assertEquals(expectedStringToSign,
				makeStringToSign.makeStringToSign("Get", URI.create("/foo"), headers));
	}

	private Map<String, String> map() {
		Map<String, String> map = new LinkedHashMap();
		map.put("Date", "Tue, 07 Jun 2014 20:51:35 GMT");
		map.put("Digest", "SHA256=47DEQpj8HBSa+/TImW+5JCeuQeRkm5NMpJWZG3hSuFU=");
		map.put("X-ING-ReqID", "12345");
		return map;
	}

}
