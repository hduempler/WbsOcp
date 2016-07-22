package wbs.nested_classes;

import java.util.Arrays;
import java.util.Comparator;

public class SortStringsDemo {

	public static void main(String[] args) {
		// scmp referenziert eine instanz einer anonymen klasse
		Comparator<String> scmp = new Comparator<String>() {
			public int compare(String s1, String s2) {
				int diff = s1.length() - s2.length();
				return diff != 0 ? diff : s1.compareTo(s2);
			}
		};
		Arrays.sort(args, scmp);
		for (String s : args) {
			System.out.println(s);
		}
		
		// instanz einer anonymen klasse als argument einer methode
		Arrays.sort(args, new Comparator<String>() {
			public int compare(String s1, String s2) {
				int diff = s1.length() - s2.length();
				return diff != 0 ? diff : s1.compareTo(s2);
			}
		});
		System.out.println("----------------------------");
		for (String s : args) {
			System.out.println(s);
		}
	}
}
