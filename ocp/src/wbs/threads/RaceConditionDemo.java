package wbs.threads;

import java.util.ArrayList;
import java.util.List;

class RaceCondition extends Thread {
	private List<Integer> li;

	public RaceCondition(List<Integer> li) {
		this.li = li;
	}

	public void run() {
		for (int i = 1; i <= 10_000_000; i++) {
			li.add(i);  //critical section
		}
	}
}

public class RaceConditionDemo {
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();  // ArrayList ist nicht thread-safe
		RaceCondition rc1 = new RaceCondition(li);
		RaceCondition rc2 = new RaceCondition(li);
		rc1.start();
		rc2.start();
		try {
			rc1.join();
			rc2.join();
			System.out.println(li.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}