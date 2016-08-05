package wbs.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

//wie komme ich von this nach other
public class RelativizeDemo {
	public static void main(String[] args) {
		// beide pfade absolut
		// ergebnis implementierungsabhängig
		Path p11 = Paths.get("/a/b");
		Path p12 = Paths.get("/c");
		System.out.println(p11.relativize(p12)); // ../../c
		// beide pfade relativ
		Path p21 = Paths.get("a/b");
		Path p22 = Paths.get("c");
		System.out.println(p21.relativize(p22)); // ../../c
		// this absolut, other relativ: exception
		try {
			Path p31 = Paths.get("/a/b");
			Path p32 = Paths.get("c");
			System.out.println(p31.relativize(p32));
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		// this relativ, other absolut: exception
		try {
			Path p41 = Paths.get("a/b");
			Path p42 = Paths.get("/c");
			System.out.println(p41.relativize(p42)); // ../../c
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}
}