package wbs.threads;

class Thread_2 extends Thread {

	private Object o;

	public Thread_2(Object o) {
		this.o = o;
		this.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("thread " + t + " has thrown " + e);
			}
		});
	}

	@Override
	public void run() {
		synchronized (o) {
			while (true) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(Math.random() > 0.5) {
					throw new IllegalArgumentException();
				}
			}
		}
	}
}

public class ExceptionsAndLocksDemo {

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		Thread thread = new Thread_2(o);
		thread.start();
		System.out.println("a little sleep...");
		Thread.sleep(1000);
		System.out.println("waitung for lock...");
		synchronized (o) {
			System.out.println("lock acquired");
		}
		System.out.println("finis...");
	}
}
