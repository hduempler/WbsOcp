package wbs.nio.uebungen;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Path12 {
	public static void main(String s[]) throws IOException {
		Path path = Paths.get("\\sales\\quarter\\..\\qtrlreport.txt");
		path=path.relativize(Paths.get("\\sales\\annualreport.txt"));
		if (path.endsWith("annualreport.txt")) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
		System.out.println(path);
	}
}