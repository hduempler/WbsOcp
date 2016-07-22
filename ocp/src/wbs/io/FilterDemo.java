package wbs.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class FilterDemo {
	public static void main(String[] args) {
		String path = "resources/io/characterdata";
		File dir = new File(path);
		File[] files;
		files = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.length() > 300 && file.length() < 500;
			}
		});
		for(File s : files) {
			System.out.println(s);
		}
//		System.out.println(Arrays.toString(files));
		System.out.println("**************************************");
		files = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
	for(File s : files) {
		System.out.println(s + " " + s.length());
	}
		// System.out.println(Arrays.toString(files));
	}
}