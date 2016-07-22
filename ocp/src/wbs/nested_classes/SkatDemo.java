package wbs.nested_classes;

import java.util.ArrayList;
import java.util.List;

public class SkatDemo {
	/*
	 * An einem Skatturnier nehmen 10 Herren teil.
	 * 
	 * Wir listen alle möglichen Zusammenstellungen von 3 Herren zu einer
	 * Skatpartie auf.
	 */
	public static void main(String[] args) {

		List<String> skatList = new ArrayList<>();
		MyList<String> mySkatList = new MyList<String>(skatList);

		skatList.add("Tom");
		skatList.add("David");
		skatList.add("Benjamin");
		skatList.add("Michael");
		skatList.add("Stefan");
		skatList.add("Thomas");
		skatList.add("Lukas");
		skatList.add("Bernd");
		skatList.add("Christian");
		skatList.add("Philipp");

		int n = 0;
		for (List<String> sublist : mySkatList) {
			if (sublist.size() == 3) {
				System.out.println(sublist);
				n++;
			}
		}
		System.out.println();
		System.out.println("Bei " + skatList.size() + " Teilnehmern gibt es "
				+ n + " mögliche Zusammensetzungen von 3 Spielern.");

	}

}
