package wbs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/*
 * Wir bestücken 10 Lists mit jeweils 15 Zufallszahlen zwischen 1 und 50.
 * 
 * Dann bestücken wir eine List mit Referenzen auf diese 10 Lists.
 * 
 * Dann sortieren wie die List of Lists aufsteigend
 * nach der Differenz zwischen dem Minimum und dem Maximum.
 * 
 */

public class MinMaxDemo {

	public static void main(String[] args) {
		
		Random rnd = new Random();
		List<List<Integer>> listOfLists = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < 15; j++) {
				list.add(rnd.nextInt(50) + 1);
			}
			listOfLists.add(list);

		}

		Comparator<List<Integer>> cmp = new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				Integer diff1 = Collections.max(o1) - Collections.min(o1);
				Integer diff2 = Collections.max(o2) - Collections.min(o2);
				return diff1.compareTo(diff2);
			}

		};

		Collections.sort(listOfLists, cmp);
		
		for (List<Integer> l : listOfLists) {
			int maxValue = Collections.max(l);
			int minValue = Collections.min(l);
			int diff = maxValue-minValue;
			System.out.println("Max: " + maxValue + " Min: "+ minValue + " Diff: " + diff +" - List: " + l);
		}
	}
}
