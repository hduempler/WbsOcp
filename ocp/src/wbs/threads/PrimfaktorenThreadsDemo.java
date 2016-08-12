package wbs.threads;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class PrimThread extends Thread {
	private Writer writer;
	private long zahl;

	public PrimThread(long zahl, Writer writer) {
		this.writer = writer;
		this.zahl = zahl;
	}

	public static List<Long> primfaktoren(long zahl) {
		// Wir akzeptieren nur Zahlen > 1:
		if (zahl < 2) {
			throw new IllegalArgumentException("invalid argument...");
		}
		List<Long> result = new ArrayList<>();
		for (long teiler = 2; zahl > 1; teiler++) {
			for (; zahl % teiler == 0; zahl /= teiler) {
				result.add(teiler);
			}
		}
		return result;

	}

	@Override
	public void run() {
		List<Long> primList = primfaktoren(zahl);
		synchronized(writer) {
			try {
				writer.append("Ich heiße: " + this.getName() + "\n");
				writer.append("Meine Zahl ist: " + zahl + "\n");
				if (primList.size() == 1) {
					writer.append("Die Zahl ist eine Primzahl.\n");

				} else {
					writer.append("Und dies sind die Primfaktoren:\n");

					for (int i = 0; i < primList.size(); i++) {
						writer.append(primList.get(i) + "\n");

					}
				}
				writer.append("----------------------------------\n");
				System.out.println(this.getName() + " ist fertig.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

public class PrimfaktorenThreadsDemo {

	/*
	 * Wir bestücken ein Array mit einigen ziemlich großen Long-Werten Für jeden
	 * dieser Long-Werte starten wir einen Thread
	 * 
	 * Jeder Thread zerlegt die Zahl in Primfaktoren. Wenn er fertig ist,
	 * schreibt er in die Datei primfaktoren.txt: - seinen Namen - die Zahl, die
	 * er in Primfaktoren zerlegt hat - jeden Primfaktor der Zahl, jeweils in
	 * einer eigenen Zeile
	 * 
	 * 
	 */

	public static void main(String[] args) throws InterruptedException {
		// long[] zahlen = { 29302987389l, 7192873954l, 7384976l, 23098378,
		// 65536*256, Integer.MAX_VALUE-1,
		// 83946328, 9730974,6787687687l, 76732844, 74989234,
		// 763987165,9173894623l };

		final int MIN = 500_000_000;
		final int MAX = 1000_000_000;
		Random rnd = new Random();
		long zahlen[] = new long[20];
		for (int i = 0; i < zahlen.length; i++) {
			zahlen[i] = (MIN + rnd.nextInt(((MAX - MIN) + 1)));
		}
		// long[] zahlen = {29l, 71l, 738l};
		String fileName = "resources/io/characterdata/primfaktoren.txt";
		try (Writer writer = Files.newBufferedWriter(Paths.get(fileName),
				Charset.forName("UTF-8"), StandardOpenOption.CREATE,
				StandardOpenOption.TRUNCATE_EXISTING)) {

			List<PrimThread> tlist=new ArrayList<>();
			for (int i=0;i<zahlen.length;i++) {
				long zahl=zahlen[i];		
				PrimThread primThread = new PrimThread(zahl, writer);
				primThread.start();
				tlist.add(primThread);
			}
			
			for (PrimThread t : tlist) {
				t.join();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Fertig");

	}

}
