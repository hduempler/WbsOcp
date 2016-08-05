package wbs.localization;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddDemo {
	// Wir geben den vollen Namen des Wochentags aus, den wir in 100 Tagen haben
	// und zwar in mehreren Sprachen.

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		int addDays = 100;

		Locale[] locSel = { Locale.ENGLISH, Locale.FRENCH, Locale.ITALIAN,
				new Locale("es"), new Locale("pt"), Locale.TRADITIONAL_CHINESE,
				Locale.JAPANESE, Locale.KOREAN };

		SimpleDateFormat df = new SimpleDateFormat(
				"'Heute ist' EEEE '('dd.MM.yyyy')'");
		System.out.println(df.format(cal.getTime()));
		cal.add(Calendar.DAY_OF_MONTH, addDays);
		df = new SimpleDateFormat("'... und in " + addDays
				+ " Tagen ist' EEEE '('dd.MM.yyyy')'");
		System.out.println(df.format(cal.getTime()));
		System.out.println("------------------------");
		System.out.printf("%tA  heißt ...\n", cal.getTime());
		for (Locale loc : locSel) {
			System.out.println("... auf " + loc.getDisplayLanguage() + ": "
					+ new SimpleDateFormat("EEEE", loc).format(cal.getTime()));
		}

	}

}
