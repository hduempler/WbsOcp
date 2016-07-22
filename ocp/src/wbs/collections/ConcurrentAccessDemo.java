package wbs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class K {
	public static final int ANZ=10_000_000;
}

class Thread11 extends Thread {
	private List<Integer> list;

	public Thread11(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		/*
		 * wir schreiben alle ungeraden zahlen zwischen 1 und 1000000 in die
		 * list
		 */
		for (int i = 1; i < K.ANZ; i += 2) {
			list.add(i);
		}
	}
}

class Thread12 extends Thread {
	private List<Integer> list;

	public Thread12(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		/*
		 * wir schreiben alle geraden zahlen zwischen 1 und 1000000 in die list
		 */
		for (int i = 2; i <= K.ANZ; i += 2) {
			list.add(i);
		}
	}
}

public class ConcurrentAccessDemo {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = Collections
				.synchronizedList(new ArrayList<Integer>());
//		List<Integer> list = new ArrayList<>();
		Thread11 thread11 = new Thread11(list);
		Thread12 thread12 = new Thread12(list);
		thread11.start();
		thread12.start();
		thread11.join();
		thread12.join();
		System.out.println(list.size());
	}

}
