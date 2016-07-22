package wbs.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

/*
 * 
 * Wir illustrieren die beiden Überladungen der Methode reverseOrder() von Collections
 *  
 */

public class ReverseOrderDemo {

	public static void main(String[] args) {

		Comparator<String> cmp1 = Collections.reverseOrder();
		Comparator<StringBuffer> cmp2 = Collections
				.reverseOrder(new Comparator<StringBuffer>() {

					@Override
					public int compare(StringBuffer sb1, StringBuffer sb2) {
						return sb2.toString().compareTo(sb1.toString());
					}

				});

		String[] namen = { "Horst Jürgen", "Eckhard", "Herbert", "Jörg",
				"Manfred", "Hans-Michael", "Carsten", "Claus", "Claudia",
				"Corena", "Manuela", "Michael", "Klaus", "Bernhard", "Olaf",
				"Julia", "Monika", "Markus", "Salah", "Ingrid", "Dr. Stefanie" };
		NavigableSet<String> namensListe = new TreeSet<>(cmp1);

		namensListe.addAll(Arrays.asList(namen));

		for (String name : namensListe) {
			System.out.println(name);
		}

		System.out.println("---------------------------");
		NavigableSet<StringBuffer> namensListe2 = new TreeSet<>(cmp2);

		for (String s : namen) {
			namensListe2.add(new StringBuffer(s));

		}

		for (StringBuffer name : namensListe2) {
			System.out.println(name);
		}
	}

}
