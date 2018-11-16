package pact.com.signing.request_signing;

import java.net.URI;
import java.util.Map;

public class MakeStringToSign implements IMakeStringToSign {

	@Override
	public String makeStringToSign(String action, URI uri, Map<String, String> headers) {
		StringBuilder builder = new StringBuilder();
		builder.append(setRequestTargetWithAction(action));
		builder.append(extractInformationFromURI(uri));
		builder.append(extractInformationFromMap(headers));
		return builder.toString();
	}

	private String setRequestTargetWithAction(String action) {
		return "(request-target): " + action.toLowerCase() + " ";
	}

	private String extractInformationFromMap(Map<String, String> headers) {
		final StringBuilder builder = new StringBuilder();
		headers.forEach((k, v) -> {
			builder.append(k.toLowerCase());
			builder.append(": ");
			builder.append(trimDigestIntial(v) + "\n");
		});

		return builder.toString().substring(0, builder.toString().length() - 1);
	}

	private String trimDigestIntial(String string) {
		if (string.startsWith("SHA256=")) {
			return string.substring(7);
		}
		return string;

	}

	private String extractInformationFromURI(URI uri) {
		return uri.getPath() + "\n";
	}

}
