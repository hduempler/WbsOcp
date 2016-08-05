package wbs.localization;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/*
 * Wir geben für alle verfügbaren Locales die Sprache aus
 * und zwar in deutsch, englisch, französisch, chinesisch und japanisch
 * 
 * -> getAvailableLocales()
 * -> getDisplayLanguage()
 * 
 */
public class Locale2Demo {

	public static void main(String[] args) {

		Locale[] locAvail = Locale.getAvailableLocales();
		Arrays.sort(locAvail, new Comparator<Locale>() {

			@Override
			public int compare(Locale o1, Locale o2) {
				// TODO Auto-generated method stub

				return o1.getDisplayLanguage().compareTo(
						o2.getDisplayLanguage());
			}
		});
		Locale[] locSel = { Locale.GERMAN, Locale.ENGLISH, Locale.FRENCH,
				Locale.TRADITIONAL_CHINESE, Locale.JAPANESE, null };

		for (Locale loc : locAvail) {
			locSel[locSel.length - 1] = loc;
			for (Locale lang : locSel) {
				System.out.println("auf " + lang.getDisplayLanguage() + ": "
						+ loc.getDisplayName(lang));
			}
			System.out
					.println("------------------------------------------------");
		}

		// TODO Auto-generated method stub

	}

}
