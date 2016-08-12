package wbs.threads;

class Sleeper extends Thread {

	private Object o;
	private Thread thread;

	public Sleeper(Object o, Thread thread) {
		this.o = o;
		this.thread = thread;
	}

	@Override
	public void run() {
		if (Math.random() > 0.5) {
			synchronized (o) {
				System.out.println("nice!");
				thread.interrupt();
			}
		} else {
			thread.interrupt();
		}
	}
}

public class SleepAndLocksDemo {

	public static void main(String[] args) {
		Object o = new Object();
		try {
			synchronized (o) {
				Thread thread = new Sleeper(o, Thread.currentThread());
				thread.start();
				Thread.sleep(10_000);
			}
		} catch (InterruptedException e) {
			System.out.println("good bye");
		}
	}
}
