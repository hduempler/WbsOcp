package wbs.threads;

class ExtendsThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread());
	}
}

public class ExtendsThreadDemo {
	public static void main(String[] args) {
		ExtendsThread extendsThread = new ExtendsThread();
		extendsThread.start();
		System.out.println(Thread.currentThread());
	}
}