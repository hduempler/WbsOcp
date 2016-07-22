package wbs.collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class SubSetDemo {

	/*
	 * Wir bestücken ein SortedSet mit einigen Elementen.
	 * 
	 * Dann holen wir zu diesem Set ein Subset
	 * 
	 * Dann fügen wir in dieses Subset ein neues Element ein (innerhalb der
	 * Intervallgrenzen) und geben das Original aus.
	 * 
	 * Wir versuchen, in das Subset ein neues Element außerhalb der
	 * Intervallgrenzen einzugeben und ermitteln, was passiert
	 */
	public static void main(String[] args) {

		SortedSet<Integer> set = new TreeSet<>();

		for (int i = 1; i <= 10; i++) {
			set.add(i * 3);
		}
		System.out.println(set);

		int subSetFrom = 10;
		int subSetTo = 20;
		System.out.println("Bilde subSet von " + subSetFrom + " bis " + subSetTo);
		SortedSet<Integer> subSet = set.subSet(10, 20);
		System.out.println(subSet);
		subSet.add(14);
		System.out.println(set);

		try {
			int addedValue = 11;
			System.out.println("Füge " + addedValue + " hinzu...");
			subSet.add(addedValue);
			System.out.println(set);
		} catch (IllegalArgumentException e) {
			System.out.println("ups...");
		}
	}

}
