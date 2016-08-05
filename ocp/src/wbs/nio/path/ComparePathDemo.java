package wbs.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ComparePathDemo {
	public static void main(String[] args) {
		String s1 = "d:\\jseocp11\\eclipse_workspace\\ocp\\src\\"
				+ "wbs\\nio\\path\\ComparePathDemo.java";
		String s2 = "src\\wbs\\nio\\path\\ComparePathDemo.java";
		Path p1 = Paths.get(s1);
		Path p2 = Paths.get(s2);
		System.out.println(p1.compareTo(p2)); // -15
		System.out.println(p1.equals(p2)); // false
		System.out.println(p1.equals(p2.toAbsolutePath())); // false
	}
}