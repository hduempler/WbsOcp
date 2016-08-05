package wbs.localization;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
 * Wir geben das aktuelle Datum in jeweils 4 verschiedenen Varianten aus:
 * SHORT, MEDIUM, LONG, FULL
 * 
 * Das machen wir für verschiedene Locales
 * Die Referenzen auf die Locales holen wir uns über
 * Konstanten oder Konstruktoren der Klasse Locale
 * 
 */
public class Locale1Demo {

	public static void main(Date d, Locale loc) {

	}

	public static void main(String[] args) {

		Date d = new Date();
		Locale[] locales = { Locale.FRANCE, new Locale("de", "DE"),
				new Locale("it","IT"), 
				new Locale("pt","PT"), 
				new Locale("pt","BR"), 
				new Locale("es"), 
				new Locale("ca"), 
				new Locale("zh"),
				new Locale("nb"),
				};

		for (Locale loc : locales) {
			System.out.println(loc.getDisplayName());
			
			DateFormat[] dfs = {
					DateFormat.getDateInstance(DateFormat.SHORT, loc),
					DateFormat.getDateInstance(DateFormat.MEDIUM, loc),
					DateFormat.getDateInstance(DateFormat.LONG, loc),
					DateFormat.getDateInstance(DateFormat.FULL, loc), };
			
			for (DateFormat df : dfs) {
				System.out.println(df.format(d));
			}
			System.out.println("------------------------------------");
		}


	}

}
