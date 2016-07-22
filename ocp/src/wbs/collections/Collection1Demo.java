package wbs.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Collection1Demo {

	public static void main(String[] args) {
		/*
		 * Wir illustrieren die Verwendung von ? und ? extends im Interface
		 * Collections
		 */

		Collection<CharSequence> c1 = new ArrayList<>();
		
		Collection<String> c11 = new HashSet<>();
		Collection<StringBuffer> c12 = new LinkedHashSet<>();
		
		c11.add("abc");
		c12.add(new StringBuffer("def"));
		
		Collection<Integer> c2 = new ArrayList<>();
		c2.add(123);
		
		// c1.addAll(c2); Compilerfehler
		System.out.println(c1.containsAll(c2)); // false;
	}

}
