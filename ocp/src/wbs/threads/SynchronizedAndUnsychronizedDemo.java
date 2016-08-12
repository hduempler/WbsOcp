package wbs.threads;

import java.math.BigInteger;

class STest {

	private BigInteger bi = new BigInteger("1000000000");

	public synchronized void m1() {
			System.out.println("m1() start");
			for (int i = 1; i < 5_000_000; i++) {
				bi.isProbablePrime(20);
				bi = bi.add(BigInteger.ONE);
			}
		System.out.println("m1() ende");
	}

	public void m2() {
		System.out.println("m2(): " + bi);
	}

	public BigInteger getBi() {
		return bi;
	}
	
}

class STestThread_1 extends Thread {

	private STest sTest;

	public STestThread_1(STest sTest) {
		this.sTest = sTest;
	}

	@Override
	public void run() {
		sTest.m1();
	}
}

class STestThread_2 extends Thread {

	private STest sTest;

	public STestThread_2(STest sTest) {
		this.sTest = sTest;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sTest.m2();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class SynchronizedAndUnsychronizedDemo {

	public static void main(String[] args) throws InterruptedException {
		
		STest sTest = new STest();

		STestThread_1 t1 = new STestThread_1(sTest);
		STestThread_2 t2 = new STestThread_2(sTest);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println(sTest.getBi());
		
		System.out.println("main() ende");
	}
}
