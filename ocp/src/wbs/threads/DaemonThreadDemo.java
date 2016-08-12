package wbs.threads;

class einThread extends Thread {

	@Override
	public void run() {
		while(true);
			
	}
	
}
public class DaemonThreadDemo {

	/*
	 * Der Main -Thread startet eine THread der in eine endlos-Schleife geht.
	 * 
	 * Was passiert, wenn der Endlos-Thread ein Daemon / kein Daemon ist?
	 * Was passiert, wenn man setDaemon() nach dem Start eines Thread aufruft?
	 * 
	 */
	public static void main(String[] args) {
		
		Thread thread = new einThread();
		thread.setPriority(10);
		//thread.setDaemon(true);
		thread.start();

	}

}
