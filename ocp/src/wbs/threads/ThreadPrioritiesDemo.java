package wbs.threads;

public class ThreadPrioritiesDemo {
	
	public static void main(String[] args) {
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println(Thread.MAX_PRIORITY);
		
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getThreadGroup());
		
		/*
		 * Wir legen uns 5 Sekunden schlafen
		 * und melden, wenn wir aufgewacht sind.
		 */
		System.out.println("Ich gehe jetzt schlafen...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Da bin ich wieder!");
	}

}
