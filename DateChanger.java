package pact.com.signing.request_signing;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateChanger {
	
	private String dateFormat = "E, y-M-d 'at' h:m:s a z";

	public String getCurrentDate() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);
		return dateFormatter.format(new Date());
	}
}
