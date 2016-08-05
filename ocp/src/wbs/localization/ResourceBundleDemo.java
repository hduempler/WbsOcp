package wbs.localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {
		Locale fr_CA = new Locale("fr", "CA");
		Locale fr = new Locale("fr");
		Locale korea = Locale.KOREA;
		Locale defaultLocale = new Locale("de", "DE");
		Locale[] locales = { fr_CA, fr, defaultLocale, korea };
		ResourceBundle bundle;
		for (Locale locale : locales) {
			bundle = ResourceBundle.getBundle(
					"wbs/localization/ResourceBundle", locale);
			System.out.println(locale.getDisplayName() + ":");
			System.out.println("______________________");
			System.out.println(bundle.getString("one"));
			System.out.println(bundle.getString("two"));
			System.out.println(bundle.getString("three"));
			System.out.println(bundle.getString("four"));
			System.out.println(bundle.getString("five"));
			System.out.println("--------------------------------------------------");
		}

	}
}
