package pact.com.signing.request_signing;

import java.net.URI;
import java.util.Map;

public interface IMakeStringToSign {
	String makeStringToSign(String string, URI create, Map<String, String> headers);

	static IMakeStringToSign defaultMakeStringToSign() {
		return new MakeStringToSign();
	}

}
