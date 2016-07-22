package wbs.generics;

import java.util.ArrayList;
import java.util.List;

/*
 * Wir illustrieren die Verwendung von ? extends
 */

public class WildCardSuperDemo {

	public static void main(String[] args) {
		List<Integer> iList = new ArrayList<>();
		List<Double> dList = new ArrayList<>();
		List<Object> oList = new ArrayList<>();
		List<String> sList = new ArrayList<>();
		List<Number> nList = new ArrayList<>();
		List<? super Number> list;

		iList.add(1); // ok
		dList.add(2.0); // ok
		sList.add("abc"); // ok
		oList.add(new Object()); // ok
		oList.add("0815"); // ok
		oList.add(715); // ok

		// list=sList; // Compilerfehler
		// list = iList; // Compilerfehler
		list = oList; // ok

		// list.add("abc"); // Compilerfehler
		// list.add(new Object()); // Compilerfehler
		// Integer i = list.get(0); Compilerfehler
		list.add(1); // ok
		list.add(Double.valueOf(2.0)); // ok
		
		list = nList; // ok
		list.add(12345);
		System.out.println(nList.get(0));  // 12345

	}

}
