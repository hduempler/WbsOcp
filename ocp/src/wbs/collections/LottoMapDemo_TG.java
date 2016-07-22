package wbs.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class LottoMapDemo_TG {

	// wir erzeugen 10000 sets mit genau 6 verschiedenen Zufallszahlen zwischen
	// 1 und 49

	// für jedes Set ermitteln wir die Trefferzahl (zahlen der letzten Ziehung:
	// 4,16,18,37,38,42);

	// dann bauen wir eine Map auf. Schlüssel in der Map ist die Trefferzahl,
	// der zugehörige Wert ein Set, dass alle Sets enthält mit der Trefferzahl,
	// die dem Schlüssel entspricht

	// dann geben wir für jede Trefferzahl die Anzahl der Sets mit dieser
	// Trefferzahl aus

	public static void main(String[] args) {

		Integer[] actTippArray = { 4, 16, 18, 37, 38, 42 };
		Set<Integer> actTippSet = new HashSet<>(Arrays.asList(actTippArray));

		Integer[] allNumbersArray = new Integer[49];
		for (int i = 0; i < 49; i++) allNumbersArray[i] = i+1;
		List<Integer> allNumberList = new ArrayList<>(Arrays.asList(allNumbersArray));
		

		List<Set<Integer>> tippList = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			Collections.shuffle(allNumberList);
			tippList.add(new HashSet<Integer>(allNumberList.subList(0, 6)));
		}

		NavigableMap<Integer, List<Set<Integer>>> resultMap = new TreeMap<>();
		for (int i = 0; i < 7; i++) {
			resultMap.put(i, new ArrayList<Set<Integer>>());
		}

		for (Set<Integer> actSet : tippList) {
			Set<Integer> treffer = new HashSet<>(actSet);
			treffer.retainAll(actTippSet);
			resultMap.get(treffer.size()).add(actSet);
		}

		for (Integer key : resultMap.keySet()) {
			System.out.println(key + ": " + resultMap.get(key).size());
		}

	}

}
