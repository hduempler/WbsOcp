package wbs.nio.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteDemo {
	public static void main(String[] args) {
		System.out.println(args[0]);
		String src = "resources/io/characterdata/copydst.txt";
		Path file = Paths.get(src);
		try {
			Files.delete(file);
			// Files.move(source,
			// destination,StandardCopyOption.REPLACE_EXISTING);
		} catch (NoSuchFileException nsfe) {
			nsfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}