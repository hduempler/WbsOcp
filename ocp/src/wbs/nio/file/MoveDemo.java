package wbs.nio.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveDemo {
	public static void main(String[] args) {
		String src ="resources/io/characterdata/copysrc.txt";
		String dst ="copydst.txt";
		Path source = Paths.get(src);
		Path dest = Paths.get(dst);
		//Path destination = source.resolveSibling(dest);
		Path destination = source.resolveSibling(Paths.get("temp/copydst.txt"));

		
		try {
			Files.move(source, destination);
//			Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
		} catch (FileAlreadyExistsException fae) {
			fae.printStackTrace();
		} catch (NoSuchFileException nsfe) {
			nsfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}