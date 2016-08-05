package wbs.nio.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class BasicFileAttributeViewDemo {
	public static void main(String[] args) {
		//String dir = "E:/bbehrensdorf";
		String dir = "resources/java_keywords.txt";
		
		Path path = Paths.get(dir);
		BasicFileAttributeView bfav = Files.getFileAttributeView(path,
				BasicFileAttributeView.class);
		try {
			BasicFileAttributes bfa = bfav.readAttributes();
			System.out.println(bfa.isDirectory());
			System.out.println(bfa.isRegularFile());
			System.out.println(bfa.isOther());
			System.out.println(bfa.isSymbolicLink());
			System.out.println(bfa.lastAccessTime());
			System.out.println(bfa.lastModifiedTime());
			System.out.println(bfa.size());
			System.out.println(bfa.creationTime());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
