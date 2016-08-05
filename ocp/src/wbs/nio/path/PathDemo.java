package wbs.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
	public static void main(String[] args) {
		String s = "src\\wbs\\ocp\\nio\\path\\PathDemo.java";
		Path path = Paths.get(s);
		System.out.println(path.toAbsolutePath());
		System.out.println(path.getNameCount());
		System.out.println(path.getRoot());
		System.out.println(path.toAbsolutePath().getRoot());
		System.out.println(path.getFileName());
		System.out.println(path.getParent());
		System.out.println(path.toUri());
		for (Path pathElement : path) {
			System.out.println(pathElement);
		}
	}
}