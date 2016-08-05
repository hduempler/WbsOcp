package wbs.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeDemo {
	public static void main(String[] args) {
		String s1 = ".\\a\\b";
		Path path = Paths.get(s1);
		System.out.println(path.normalize()); // a\b
		String s2 = "..\\.\\a\\b";
		path = Paths.get(s2); // a\b
		System.out.println(path.normalize()); // ..\a\b
	}
}