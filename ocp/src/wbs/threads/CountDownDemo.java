package wbs.threads;

class CountDown extends Thread {
	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			try {
				System.out.println(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class CountDownDemo {
	public static void main(String[] args) {
		CountDown countDown = new CountDown();
		System.out.println("countdown beginnt");
		countDown.start();
		try {
			countDown.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("countdown beendet");
	}
}