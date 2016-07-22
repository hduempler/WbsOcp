package wbs.nested_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GemischtesDoppelDemo {
	/*
	 * An einem Bridge-Turnier nehmen 13 Damen und 7 Herren teil
	 * 
	 * Wir listen alle Zusammenstellungen von vier Personen auf, an denen genau
	 * 2 Damen und genau 2 Herren beteiligt sind. Wie viele solcher
	 * Zusammenstellungen gibt es?
	 */
	public static void main(String[] args) {
		String[] herren = { "Ben", "Jonas", "Leon", "Elias", "Paul", "Lukas",
				"Felix" };
		String[] damen = { "Emma", "Hanna", "Sophia", "Anna", "Marie", "Lena",
				"Lea", "Leonie", "Amelie", "Johanna", "Luisa", "Klara", "Laura" };

		MyList<String> myDamenList = new MyList<String>(Arrays.asList(damen));
		MyList<String> myHerrenList = new MyList<String>(Arrays.asList(herren));

		List<String> viererBande = new ArrayList<>();
		int n = 0;
		for (List<String> sublist1 : myHerrenList) {

			for (List<String> sublist2 : myDamenList) {
				if (sublist1.size() == 2 && sublist2.size() == 2) {
					viererBande.clear();
					viererBande.addAll(sublist1);
					viererBande.addAll(sublist2);
					System.out.println(viererBande);
					n++;
				}
			}
		}
		System.out.println(n++);
	}
}
