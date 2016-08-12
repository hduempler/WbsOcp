package wbs.threads;

class ImplementsRunnable implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread());
	}
}

public class ImplementsRunnableDemo {
	public static void main(String[] args) throws InterruptedException {
		ImplementsRunnable implementsRunnable = new ImplementsRunnable();
		Thread thread = new Thread(implementsRunnable, "Neuer Thread 1");
		thread.start();
		// thread.run(); // Hier wird KEIN Thread gestartet, sondern die
		// run-Methode (wie alle anderen denkbaren Methoden) im aktuellen Thread
		// aufgerufen.
		System.out.println(Thread.currentThread());
	}
}
