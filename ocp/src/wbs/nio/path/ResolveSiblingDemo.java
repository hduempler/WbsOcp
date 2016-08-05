package wbs.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;



//geht in this eine stufe nach oben und hängt other an
public class ResolveSiblingDemo {
	public static void main(String[] args) {
		String s11 = "a/b";
		String s12 = "c/d";
		Path p11 = Paths.get(s11);
		Path p12 = Paths.get(s12);
		System.out.println(p11.resolveSibling(p12)); // a/c/d
	}
}