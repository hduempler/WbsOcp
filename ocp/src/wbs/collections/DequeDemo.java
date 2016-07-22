package wbs.collections;

import java.util.ArrayDeque;

public class DequeDemo {
	public static void main(String[] args) {

		// Bei einer Deque ist zugriff an beiden Enden möglich
		// XXXFirst() operiert auf dem Head
		// XXXLast operiert auf dem Tail
		// addFirst(), offerFirst() fügen am Head ein
		// addlast(), offerLast() fügen am Tail ein
		// removeFirst(), pollFirst() entnehmen vom Head
		// removeLast(), pollLast() entnehmen vom Tail
		// getFirst(), peekFirst() untersuchen den Head
		// getLast(), peekLast() untersuchen den Tail

		ArrayDeque<Integer> deque = new ArrayDeque<>();
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addFirst(4);
		// head jetzt: 4 3 2 1
		deque.addLast(10);
		deque.addLast(11);
		deque.addLast(12);
		deque.addLast(13);
		// tail jetzt: 10 11 12 13
		System.out.println(deque.getFirst()); // 4
		System.out.println(deque.getLast()); // 13
		System.out.println("---------");
		// die gesamte deque jetzt: 4 3 2 1 10 11 12 13
		while (!deque.isEmpty()) {
			System.out.println(deque.removeFirst());
		}
	}
}