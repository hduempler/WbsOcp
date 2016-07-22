package wbs.collections;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
	
	// Das Element mit der höchsten Priorität ist am Ende (tail) der Queue
	// am Head der Queue ist das element mit der niedrigsten Priorität
	// null- Elemente sind nicht erlaubt
	// Basis der Prioritätsbestimmung ist das Natural Ordering der Elemente
	// oder ein im Konstruktor übergebener Comparator
	// Iteratoren garantieren keine bestimmte Reihenfolge
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(5);
		pq.add(7);
		pq.add(3);
		pq.add(9);
		while (!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
		// Ausgabe: 3 5 7 9
	}
}