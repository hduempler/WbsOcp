package wbs.string_processing;

import java.util.Locale;
import java.util.Scanner;

public class ScannerDemo3 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		int n = -1;
		double x = 0;
		boolean b = false;
		String s = null;
		sb.append(1 + " ");
		sb.append(2.0 + " ");
		sb.append(true + " ");
		sb.append("lalla" + " ");
		String source = sb.toString();
		System.out.println(source);
		try (Scanner scanner = new Scanner(source)) {
			scanner.useLocale(Locale.US);
			if (scanner.hasNextInt()) {
				n = scanner.nextInt();
			}
			if (scanner.hasNextDouble()) {
				x = scanner.nextDouble();
			}
			if (scanner.hasNextBoolean()) {
				b = scanner.nextBoolean();
			}
			if (scanner.hasNext()) {
				s = scanner.next();
			}
		}
		System.out.println("n: " + n); // 1
		System.out.println("x: " + x); // 2.0
		System.out.println("b: " + b); // true
		System.out.println("s: " + s); // lalla
	}
}
