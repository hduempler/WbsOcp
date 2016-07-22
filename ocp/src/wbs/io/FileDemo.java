package wbs.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {
	public static void main(String[] args) {
		String path1 = "src/wbs";
		String path2 = "resources/io/aNewFile.txt";
		String path3 = "resources/io";

		String path4 = "../resources/io";

		File file1 = new File(path1);
		File file2 = new File(path2);
		File file3 = new File(path3);
		File file4 = new File(path4);
		try {
			System.out.println(file4.getCanonicalPath());
			System.out.println(file4.getAbsolutePath());
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		long lastModified;
		System.out.println(File.pathSeparator); // ;
		System.out.println(File.pathSeparatorChar); // ;
		System.out.println(File.separator); // \
		System.out.println(File.separatorChar); // \
		System.out.println(file1.isAbsolute()); // false
		System.out.println(file1.isDirectory()); // true
		System.out.println(file1.isHidden()); // false
		System.out.println(file1.isFile()); // false
		System.out.println(file1.canExecute()); // true
		System.out.println(file1.canRead()); // true
		System.out.println(file1.canWrite()); // true
		System.out.println(file1.length()); // 4096
		lastModified = file1.lastModified();
		System.out.println(new Date(lastModified)); // datum
		try {
			file2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			File.createTempFile("pre", ".txt", file3);
			// pre6885917375789059249.txt
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}