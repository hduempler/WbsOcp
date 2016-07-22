package wbs.collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class Collection2Demo {
	/*
	 * Wir illustrieren die Methoden addAll(), removeAll() und retainAll() von
	 * Collection
	 */

	public static void main(String[] args) {
		Set<Integer> set1 = new LinkedHashSet<>();
		Set<Integer> set2 = new LinkedHashSet<>();
		Set<Integer> set3 = new LinkedHashSet<>();

		Set<Integer> set4 = new LinkedHashSet<>();

		for (int i = 1; i <= 5; i++) {
			set1.add(i);
			set2.add(i);
			set3.add(i);

		}

		for (int i = 3; i <= 7; i++) {
			set4.add(i);
		}

		set1.addAll(set4); // Vereinigung: in this OR in other
		set2.retainAll(set4); // Durchschnitt: in this AND in other
		set3.removeAll(set4); // Komplement: in this AND NOT in other
		
		// @formatter:off
        // in set1 - set3 war        [1, 2, 3, 4, 5]
		// in set4 ist:
		System.out.println(set4); //       [3, 4, 5, 6, 7]
		
		// Dies sind die Ergebnisse der Mengenoperationen
		System.out.println(set1); // [1, 2, 3, 4, 5, 6, 7]
		System.out.println(set2); //       [3, 4, 5]
		System.out.println(set3); // [1, 2]

	}

}
