package pact.com.signing.request_signing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.Test;

public class RSAKeyGeneratorUtilTest {

	@Test 
	public void trimRSAKeyStringHeaderAndFootersTest() throws IOException
	{
			String expected="MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAo8ilhH2UbDy47c57/Oo+k9MMzlXbN2JOJ/XEIJWj1Oh9MYqRoBoZWQeodQRU6gCC1P6xSXhSFeHErj/omzdaWQIDAQABAkA88hX9ZkmLuVDLVRG4PGZK1bcnNLWdN1yD7CUuRuCvAbednJnrXLEEe4YfvOW1s3u6Gsp4z+yu9yuu2fcY7wPtAiEA2czGXnCzMNh92n34SmK/H2x6bB2zsLWcf11lN92DIzsCIQDAgouU+ALlQa9IzYTkmE/JR4Hm+LRgDUpKzkU1QC93ewIhANf2TNxoM8ZDZMe6EPDxaUHndpyt9vdJnZxNJ4h1hQrxAiEAruKpjWaVstGuPJRAQy8/ZFpq33pW2t+X+0dSRiMOPBsCIDF99vC0EY2KGhFS1kjSdgAnddMNJE9DkQgk6WRa7VuD";
			String trimmedString=RSAKeyGeneratorUtil.trimRSAKeyStringHeaderAndFooters(RSAKeyReader.getKey("priv8.pem"));
			assertEquals(expected, trimmedString);
	}
	
	@Test 
	public void generatePrivatekeyFromStringTest() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException
	{
			String expected="MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAo8ilhH2UbDy47c57/Oo+k9MMzlXbN2JOJ/XEIJWj1Oh9MYqRoBoZWQeodQRU6gCC1P6xSXhSFeHErj/omzdaWQIDAQABAkA88hX9ZkmLuVDLVRG4PGZK1bcnNLWdN1yD7CUuRuCvAbednJnrXLEEe4YfvOW1s3u6Gsp4z+yu9yuu2fcY7wPtAiEA2czGXnCzMNh92n34SmK/H2x6bB2zsLWcf11lN92DIzsCIQDAgouU+ALlQa9IzYTkmE/JR4Hm+LRgDUpKzkU1QC93ewIhANf2TNxoM8ZDZMe6EPDxaUHndpyt9vdJnZxNJ4h1hQrxAiEAruKpjWaVstGuPJRAQy8/ZFpq33pW2t+X+0dSRiMOPBsCIDF99vC0EY2KGhFS1kjSdgAnddMNJE9DkQgk6WRa7VuD";
			String trimmedString=RSAKeyGeneratorUtil.trimRSAKeyStringHeaderAndFooters(RSAKeyReader.getKey("priv8.pem"));
			RSAKeyGeneratorUtil.generatePrivatekeyFromString(trimmedString);
			assertNotNull(RSAKeyGeneratorUtil.generatePrivatekeyFromString(trimmedString));
	}

}
