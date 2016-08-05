package wbs.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

//falls other kein absoluter pfad ist, wird other an this angehängt
public class ResolveDemo {
	public static void main(String[] args) {
		String s11 = "a/b";
		String s12 = "c/d";
		Path p11 = Paths.get(s11);
		Path p12 = Paths.get(s12);
		System.out.println(p11.resolve(p12)); // a/b/c/d
		String s21 = "a/b";
		String s22 = "/c/d";
		Path p21 = Paths.get(s21);
		Path p22 = Paths.get(s22);
		System.out.println(p21.resolve(p22)); // /c/d
		String s31 = "/a/b";
		String s32 = "c/d";
		Path p31 = Paths.get(s31);
		Path p32 = Paths.get(s32);
		System.out.println(p31.resolve(p32)); // /a/b/c/d
		String s41 = "a/b";
		String s42 = "b/c";
		Path p41 = Paths.get(s41);
		Path p42 = Paths.get(s42);
		System.out.println(p41.resolve(p42)); // a/b/b/c
	}
}