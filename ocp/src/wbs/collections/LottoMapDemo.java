package wbs.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableMap;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/*
 * wir erzeugen 10_000 sets mit genau 6 verschiedenen zufallszahlen zwischen 1 und 49.
 * für jedes dieser sets ermitteln wir die trefferzahl 
 * (zahlen der letzten ziehung: 4,16,18,37,38,42)
 * dann bauen wir eine map auf. schlüssel in der map ist die trefferzahl. der zugehörige
 * wert ein list, die alle sets enthält mit der trefferzahl, die dem schlüssel entspricht.
 * dann geben wir für jede trefferzahl die anzahl der sets mit dieser trefferzahl aus.
 */
public class LottoMapDemo {

	public static void main(String[] args) {

		Random rnd = new Random();
		// Set mit den ziehungsdaten befüllen
		// Array mit den zahlen der Ziehung
		Integer[] ia = { 4, 16, 18, 37, 38, 42 };
		// Ziehungszahlen als Set
		Set<Integer> ziehung = new HashSet<>(Arrays.asList(ia));
		// deklarieren der ArrayList tipplist die Sets vom typ Integer enthalten
		// kann
		List<Set<Integer>> tippList = new ArrayList<>();

		for (int i = 0; i < 100_000; i++) {
			Set<Integer> iSet = new HashSet<>();
			// iteriere so lange bis 6 unterschiedliche zahlen (von 1-49) im
			// iSet enthalten
			while (iSet.size() < 6) {
				iSet.add(rnd.nextInt(49) + 1);
			}
			// hinzufügen des in der for-schleife erzeugten sets in die
			// Gesamtliste von sets
			tippList.add(iSet);
		}

		// Map <K,V)
		// K = Key = Integer (von 0 bis 6 (Treffer))
		// V = Value = alle Listen welche den Key (also die Treffer) haben
		NavigableMap<Integer, List<Set<Integer>>> resultMap = new TreeMap<>();
		// erzeugt in der NavigableMap (resultMap) 7 leere Listen mit den Keys
		// von 0 bis 6
		for (int i = 0; i <= 6; i++) {
			resultMap.put(i, new ArrayList<Set<Integer>>());
		}
		// iteriere über alle Sets der Liste tippList und
		for (Set<Integer> actSet : tippList) {
			// legt eine kopie des momentanen actSets an
			Set<Integer> treffer = new HashSet<>(actSet);
			// weil die retainAll-methode() das original-Set verändern würde
			// die methode retainAll behält im Set treffer nur die zahlen,
			// welche
			// auch in der Collection (bzw. Set) ziehung enthalten ist
			treffer.retainAll(ziehung);
			// ermittelt zum aktuellen Tipp die größe (Anzahl der Treffer) und
			// fügt das jeweilige actSet in die resultMap ein
			// size gibt die jeweilige anzahl der treffer (0 - 6) zurück,
			// entspricht gleichzeitig dem key der resultMap
			resultMap.get(treffer.size()).add(actSet);
		}
		// nun können wir über den key der resultMap iterieren
		// und die anzahl der enthaltenen Sets ausgeben
		for (Integer key : resultMap.keySet()) {
			System.out.println("Treffer: " + key + " -> "
					+ resultMap.get(key).size());
		}
	}
}
