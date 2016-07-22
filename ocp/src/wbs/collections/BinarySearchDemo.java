package wbs.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchDemo {

	/*
	 * Wir bestücken eine List mit einigen Vornamen als Strings. Dann sortieren
	 * wir die List aufsteigend.
	 * 
	 * Dann suchen wir mit binarySearch einen Vornamen, der in der List ist und
	 * einen Vornamen, der nicht in der List ist und interpretieren das Ergebnis
	 * 
	 * Dann machen wir dasselbe noch einmal, aber die Vornamen sind jetzt keine
	 * Strings, sondern StringBuffer.
	 */

	public static void main(String[] args) {

		String[] namen = { "Sabine", "Ellen", "Walter", "Ekkehard", "Silke",
				"Cordula", "Ulrike", "Birgit", "Fernando", "Tobias", "Eva",
				"Dennis", "Stefan", "Anny", "Jutta", "Lars", "Barbara",
				"Darlen", "Frank", "Dieter", "Helmut", "Margret", "Markus",
				"Dieter", "Katharina", "Renate", "Tobias", "Kirsten", "Jan",
				"Monica", "Petra", "Bernd", "Magdalena", "Wolfgang", "Claudia",
				"Johanna", "Roland", "Madeleine", "Wolf-Jürgen", "Grzegorz",
				"Marion", "Roland", "Jutta", "Ewa", "Alina", "Ingeborg" };

		List<String> namensListe1 = new ArrayList<>();
		namensListe1.addAll(Arrays.asList(namen));
		System.out.println("Der größte Wert in der 1. Liste ist: " + Collections.max(namensListe1));
		System.out.println("Der kleinste Wert in der 1. Liste ist: " + Collections.min(namensListe1));

		
		
		Collections.sort(namensListe1);

		String s = "Silke";
		int searchResult = Collections.binarySearch(namensListe1, s);
		System.out.println(s + " steht an Position " + searchResult + ":");
		System.out.println(namensListe1.get(searchResult));

		s = "Donald";
		searchResult = Collections.binarySearch(namensListe1, s);
		System.out.println(s + " steht an Position " + searchResult);

		List<StringBuffer> namensListe2 = new ArrayList<>();
		String[] namen2 = { "Horst Jürgen", "Eckhard", "Herbert", "Jörg",
				"Manfred", "Hans-Michael", "Carsten", "Claus", "Claudia",
				"Corena", "Manuela", "Michael", "Klaus", "Bernhard", "Olaf",
				"Julia", "Monika", "Markus", "Salah", "Ingrid", "Dr. Stefanie",
				"Reinhard", "Dr. Jens", "Sven", "Andreas", "Petra", "Melanie",
				"Kerstin", "Hiltrud", "Eva", "André", "Waltraud", "Marlies",
				"Fernando", "Dieter", "Sigrid", "Tanja", "Susanne",
				"Charlotte", "Doritha", "Maj-Britt", "Doris", "Dieter",
				"Angelika", "Harry", "Elke", "Thomas", "Bettina", "Erhard",
				"Cornelia", "Dora", "Günter", "Robert", "Martin",
				"Hans-Joachim", "Anna", "Peter", "Uta", "Hans-Günter",
				"Ursula", "Lieselotte", "Britta", "Bodo", "Christina",
				"Regina", "Karola", "Heike", "Renate", "Sergiy", "Wilfried",
				"Christoph", "Jürgen", "Edeltraud", "Heike-Ingeborg", "Samuil",
				"Maria", "Udo", "Karin", "Andrea", "Norbert", "Bruno", "Dirk",
				"Marion", "Danuta", "Wolfgang", "Gerhard", "Nadine",
				"Elfriede", "Jutta", "Hildegard", "Pietro", "Torsten",
				"Wilhelm", "Helmut", "Waldemar", "Roland", "Reiner", "Pierre",
				"Marcel", "Kirsten", "Ingeborg", "Ewa", "Heidrun", "Alexander",
				"Friederike", "Anny", "Tobias", "Ina", "Heinrich", "Ralph",
				"Dennis", "Stefan", "Katharina", "Grischa", "Ellen",
				"Madeleine", "Lothar", "Falk", "Lars", "Barbara"

		};

		for (String na : namen2) {
			namensListe2.add(new StringBuffer(na));
		}
		Comparator<StringBuffer> cmp = new Comparator<StringBuffer>() {

			@Override
			public int compare(StringBuffer o1, StringBuffer o2) {
				return o1.toString().compareTo(o2.toString());
			}

		};

		Collections.sort(namensListe2, cmp);

		StringBuffer sb = new StringBuffer("Dora");
		searchResult = Collections.binarySearch(namensListe2, sb, cmp);
		System.out.println(sb + " steht an Position " + searchResult + ":");
		System.out.println(namensListe2.get(searchResult));

		sb = new StringBuffer("Dagobert");
		searchResult = Collections.binarySearch(namensListe2, sb, cmp);
		System.out.println(sb + " steht an Position " + searchResult);

		
		int counter = 0;
		for (String x : namensListe1) {
			if (Collections.binarySearch(namensListe2, new StringBuffer(x), cmp) > 0) {
				counter++;
			}

		}
		System.out.println("Es gibt " + counter + " Namen, die in beiden Listen sind.");
		
		System.out.println("Der größte Wert in der 1. Liste ist: " + Collections.max(namensListe1));
	}

}
