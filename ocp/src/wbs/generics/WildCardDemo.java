package wbs.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardDemo {

	/*
	 * Wir illustrieren die Verwendung von ?
	 */

	public static void main(String[] args) {
		List<Integer> iList = new ArrayList<>();
		List<String> sList = new ArrayList<>();
		List<?> list;

		// Wir bestücken iList und sList

		iList.add(1);
		sList.add("abc");
		
		list=iList; // ok
		
		new Object();
		
		list.get(0);
		
		list.add(null);  //ok
		Object o = list.get(0);
		System.out.println(o.getClass().getName());
		list=sList;
		
		list=sList; // ok
		o=list.get(0);
		System.out.println(o.getClass().getName());
		

	}
}
