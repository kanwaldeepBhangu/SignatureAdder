package pact.com.signing.request_signing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

public class RSAKeyReaderTest {

	@Test
	public void getKeyTestFromClassPath() throws IOException {
		assertNotNull(RSAKeyReader.getKey("priv8.pem"));
	};
}
