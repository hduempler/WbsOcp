package wbs.generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardExtendsDemo {

	/*
	 * Wir illustrieren die Verwndung von ? extends
	 */
	public static void main(String[] args) {

		List<Integer> iList = new ArrayList<>();
		List<Double> dList = new ArrayList<>();
		@SuppressWarnings("unused")
		List<String> sList = new ArrayList<>();
		List<? extends Number> list;

		iList.add(1);
		dList.add(2.0);

		// list=sList; // Compilerfehler

		list = iList; // ok
		// list.add(2); Compilerfehler
		// Integer i = list.get(0); Compilerfehler

		Number n = list.get(0);
		System.out.println(n.getClass().getSimpleName()); // Integer
		list = dList; // ok
		n = list.get(0);
		System.out.println(n.getClass().getSimpleName()); // Double
		
	}

}
