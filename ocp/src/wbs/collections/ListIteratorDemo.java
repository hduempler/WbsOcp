package wbs.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {

	/*
	 * Wir bestücken eine List mit mehreren Integern. Dann geben wir die List
	 * vom Ende bis zum Anfang aus und verwenden dabei einen ListIterator.
	 */
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		ListIterator<Integer> li = list.listIterator(list.size());

		// for(int i: list) {
		// System.out.println(i);
		// }

		while (li.hasPrevious()) {
			System.out.println(li.previous());
		}

		System.out.println("und nun andersrum:");
		while (li.hasNext()) {
			System.out.println(li.next());
		}

	}

}
