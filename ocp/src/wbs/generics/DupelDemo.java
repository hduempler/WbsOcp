package wbs.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DupelDemo {

	/*
	 * Wir bestücken ein Set mit einigen Strings. Dann erzeugen wir ein Set, das
	 * alle Dupel von Strings enthält, die dieselbe Länge haben.
	 */

	public static void main(String[] args) {

		String[] myStrings = { "Sabine", "Ellen", "Walter", "Ekkehard",
				"Silke", "Cordula", "Ulrike", "Birgit", "Fernando", "Tobias",
				"Eva", "Dennis", "Stefan", "Anny", "Jutta" };

		Set<String> strings = new HashSet<>(Arrays.asList(myStrings));
		Set<Dupel<String, String>> dupelSet = new HashSet<>();

		for (String s1 : strings) {
			for (String s2 : strings) {
				if (s1.length() == s2.length()) {
					dupelSet.add(new Dupel<>(s1, s2));
				}
			}
		}

		for (Dupel<String, String> dupel : dupelSet) {
			System.out.println(dupel);
		}
		System.out.println(dupelSet.size());

	}

}
