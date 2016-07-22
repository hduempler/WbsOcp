package wbs.nested_classes;

import java.util.ArrayList;
import java.util.List;

public class MyListDemo {

	/*
	 * Wir bestücken eine List mit den Zahlen von 1 bis 4 und geben dann alle
	 * Teillisten dieser List aus
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		MyList<Integer> myList = new MyList<>(list);
		for (int i = 1; i <= 4; i++) {
			list.add(i);
		}

		for (List<Integer> sublist : myList) {
			System.out.println(sublist);
		}

	}

}
