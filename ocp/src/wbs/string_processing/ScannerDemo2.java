package wbs.string_processing;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerDemo2 {
	public static void main(String[] args) {
		String path = "src\\wbs\\string_processing\\ScannerDemo2.java";
		File file = new File(path);
		String token;
		try (Scanner scanner = new Scanner(file)) {
			scanner.useDelimiter("\\W+");
			while (scanner.hasNext()) {
				token = scanner.next();
				//if (token.length() != 0) {
					System.out.println("[" + token + "]");
				//}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}