package wbs.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class MyListResourceBundleDemo {
	public static void main(String[] args) {
		ResourceBundle bundle;
		Locale[] locales = { Locale.GERMAN, Locale.ITALY, Locale.UK,
				Locale.FRENCH };
		for (Locale locale : locales) {
			bundle = ResourceBundle.getBundle(
					"wbs.localization.MyListResourceBundle", locale);
			System.out.println(bundle.getObject("language") + " -> "
					+ bundle.getObject("language").getClass());
			System.out.println(bundle.getObject("currency") + " -> "
					+ bundle.getObject("currency").getClass());
			System.out.println(bundle.getObject("capital") + " -> "
					+ bundle.getObject("capital").getClass());
			System.out.println("----");
		}
	}
}
