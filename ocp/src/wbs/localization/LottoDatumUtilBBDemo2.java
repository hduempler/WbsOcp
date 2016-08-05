package wbs.localization;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class LottoDatumUtilBBDemo2 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE dd.MM.yyyy HH:mm");

		Calendar cal = new GregorianCalendar(2016, 7, 10, 18, 0, 0);

		// Abgabe:
		int abgabeTag = 13;
		int abgabeMonat = 7;
		int abgabeJahr = 2016;
		int abgabeZeit = 17;

		boolean isMittwoch = true;
		boolean isSamstag = true;
		int abgabeSchlussMittwoch = 18;
		int abgabeSchlussSamstag = 18;
		int laufzeit = 3;

		cal.set(Calendar.YEAR, abgabeJahr);
		cal.set(Calendar.MONTH, abgabeMonat);
		cal.set(Calendar.DAY_OF_MONTH, abgabeTag);
		cal.set(Calendar.HOUR_OF_DAY, abgabeZeit);
		Date abgabeDatum = cal.getTime();

		System.out.println("Scheinabgabe: " + sdf.format(abgabeDatum));
		System.out.printf("TN-Mittwoch: %b, TN-Samstag: %b\n", isMittwoch,
				isSamstag);
		System.out
				.printf("Abgabeschluss Mittwoch: %d Uhr, Abgabeschluss Samstag: %d Uhr\n",
						abgabeSchlussMittwoch, abgabeSchlussMittwoch);
		System.out.printf("gewünschte Laufzeit: %d Wochen\n", laufzeit);

		List<Date> ziehungsTage = LottoDatumUtilBB.ziehungsTage(abgabeDatum,
				isMittwoch, isSamstag, abgabeSchlussMittwoch,
				abgabeSchlussSamstag, laufzeit);
		System.out.println("\nZiehungstage:");
		sdf = new SimpleDateFormat("EEE dd.MM.yyyy");

		for (Date d : ziehungsTage) {
			System.out.println(sdf.format(d));
		}

	}
}
