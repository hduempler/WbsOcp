package wbs.threads;

class Counter {
	private int zahl;

	public synchronized void increment() {
		
			zahl++;
		
	}

	public int getZahl() {
		return zahl;
	}
}

class CounterThread extends Thread {
	private Counter counter;
	private int n; // Anzahl der Inkrementierungen

	CounterThread(Counter counter, int n) {
		this.counter = counter;
		this.n = n;
	}

	// run() inkrementiert counter n mal
	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
			counter.increment();
		}
	}

}

public class CounterDemo {

	public static void main(String[] args) {

		// erzeugt 2 counter-Threads und startet sie.
		// beide Counter-Threads operieren auf demselben Counter-Objekt
		// Wartet auf das Ende der beiden Counter-Threads
		// gibt dann den Wert zahl des Counter-Objekts aus

		Counter counter = new Counter();
		int anzahl = 20000;
		CounterThread ct1 = new CounterThread(counter, anzahl);
		CounterThread ct2 = new CounterThread(counter, anzahl);
		ct1.setPriority(5);
		ct2.setPriority(5);

		ct1.start();
		ct2.start();
		try {
			ct1.join();
			ct2.join();
			System.out.println("zahl= " + counter.getZahl());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
