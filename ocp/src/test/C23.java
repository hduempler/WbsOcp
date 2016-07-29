package test;

import java.util.Scanner;

public class C23 {
	public static void main(String[] args) {
		String s = "1 22 333 4444 fuenf 666666";
		Scanner scanner = new Scanner(s);
		while (scanner.hasNext()) {
			//if (scanner.hasNextInt()) {
				System.out.println(scanner.nextInt());
			//} else {
				//scanner.next();
			//}
		}
		scanner.close();
	}
}