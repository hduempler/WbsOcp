package wbs.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class MarkDemo {
	public static void main(String[] args) {
		String in = "eins\nzwei\ndrei\nvier";
		String line;
		try (BufferedReader br = new BufferedReader(new StringReader(in))) {
			line = br.readLine();
			System.out.println(line);
			line = br.readLine();
			System.out.println(line);
			br.mark(100);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			if (br.markSupported()) {
				br.reset();
				line = br.readLine();
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
}