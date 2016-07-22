package wbs.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SimpleDictDemo {

	/*
	 * Wir bestücken eine Map mit deutsch-englischen Wortpaaren
	 */
	public static void main(String[] args) {

		Map<String, String> dict = new TreeMap<>();
		dict.put("eins", "one");
		dict.put("zwei", "two");
		dict.put("drei", "three");
		// @formatter:off
		/*
		 * Wir geben alle Key-Value-Pairs aus:
		 * 
		 * 1. foreach über alle keys 
		 * 2. foreach über alle map.entries 
		 * 3. Iterator über alle keys 
		 * 4. Iterator über alle map.entries
		 * 
		 * 5. Welche dieser Alternativen würden Sie bevorzugen?
		 */
		// @formatter:on

		// 1

		for (String k : dict.keySet()) {
			System.out.println(k + " -> " + dict.get(k));

		}
		System.out.println("-------------------------------------");

		// 2

		for (Map.Entry<String, String> entry : dict.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());

		}
		System.out.println("-------------------------------------");

		// 3

		Iterator<String> itr1 = dict.keySet().iterator();
		String k;
		while (itr1.hasNext()) {
			k = itr1.next();
			System.out.println(k + " -> " + dict.get(k));
		}

		System.out.println("-------------------------------------");

		// 4

		Iterator<Map.Entry<String, String>> itr2 = dict.entrySet().iterator();
		Map.Entry<String, String> entry;
		while (itr2.hasNext()) {
			entry = itr2.next();
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
}
