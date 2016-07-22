package wbs.collections;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExceptionDemo {
/*
 * Wir provozieren eine ClassCastException beim Verwenden eines TreeSet
 */
	public static void main(String[] args) {
		
		Set<StringBuffer> ts = new TreeSet<>();
		ts.add(new StringBuffer("abc"));
		ts.add(new StringBuffer("def"));
		

	}

}
