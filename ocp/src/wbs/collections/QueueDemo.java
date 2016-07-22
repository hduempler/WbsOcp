package wbs.collections;

import java.util.LinkedList;

public class QueueDemo {
	
	// i.d.r. first in, first out (FIFO); Ausnahme: PriorityQueue
	// der einzige zugriffspunkt der queue ist der head
	
	public static void main(String[] args) {
	
		LinkedList<Integer> list = new LinkedList<>();

		// insert
		list.add(1); // IllegalStateException, falls keine freie Kapazität
		list.offer(2); // false, falls keine freie Kapazität
		list.offer(3); // false, falls keine freie Kapazität
		
		// examine
		// referenz auf head holen, ohne das element zu entfernen
		System.out.println(list.peek()); // 1; null, falls empty
		System.out.println(list.element()); // 1; exception, falls empty
		
		// remove
		// referenz auf head holen, und das element entfernen
		System.out.println(list.poll()); // 1; null, falls empty
		System.out.println(list.remove()); // 2; exception, falls empty
	}

}
