package pact.com.signing.request_signing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class RSAKeyReader {
	public static String getKey(String filename) throws IOException {
		InputStream inputStream = RSAKeyReader.class.getClassLoader().getResourceAsStream(filename);
		try {
			return new BufferedReader(new InputStreamReader(inputStream)).lines().parallel()
					.collect(Collectors.joining("\n"));
		} finally {
			inputStream.close();
		}
	}

}
