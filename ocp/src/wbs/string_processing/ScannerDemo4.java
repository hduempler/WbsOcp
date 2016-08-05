package wbs.string_processing;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class ScannerDemo4 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			sb.append(Math.random() > 0.5 ? rnd.nextBoolean() : rnd
					.nextDouble());
			sb.append(" ");
			if (i % 2 == 0) {
				sb.append("blabla ");
			}
		}
		String source = sb.toString();
		try (Scanner scanner = new Scanner(source)) {
			scanner.useLocale(Locale.US);
			while (scanner.hasNext()) {
				if (scanner.hasNextDouble()) {
					System.out.println("Double -> " + scanner.nextDouble());
				} else if (scanner.hasNextBoolean()) {
					System.out.println("Boolean -> " + scanner.nextBoolean());
				} else {
					System.out.println("Sonstiges -> " + scanner.next());
				}
			}
		}
	}
}
