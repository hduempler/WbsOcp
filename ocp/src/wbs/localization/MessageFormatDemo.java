package wbs.localization;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatDemo {

	public static void main(String[] args) {
		Locale[] locales = { Locale.FRENCH, Locale.GERMAN };
		for (Locale local : locales) {
			ResourceBundle rb = ResourceBundle.getBundle("wbs/localization/Messages",
					local);
			String hallo = rb.getString("hallo");
			String bye = rb.getString("bye");
			String danke = rb.getString("danke");
			String bitte = rb.getString("bitte");
			System.out.println(hallo + "! ");
			System.out.println(bye + "! ");
			System.out.println(danke);
			System.out.println(bitte);
			String output = MessageFormat.format(rb.getString("muster"), new Date(), 42);
			System.out.println(output);
			System.out.println("--------");
		}
		// default locale
		ResourceBundle rb = ResourceBundle.getBundle("wbs/localization/Messages");
		System.out.println(rb.getString("danke"));
		// ändern des default locale
		Locale.setDefault(Locale.FRENCH);
		rb = ResourceBundle.getBundle("wbs/localization/Messages");
		System.out.println(rb.getString("danke"));
	}

}
