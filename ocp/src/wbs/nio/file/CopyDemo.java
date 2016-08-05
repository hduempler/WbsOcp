package wbs.nio.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// Was passiert, wenn src nicht existiert?
// Was passiert, wenn dst existiert?
public class CopyDemo {
	
	public static void main(String[] args) {
//		String src ="resources/io/characterdata/copysrc.txt";
//		String dst ="copydst.txt";
		String src ="resources/io/characterdata/copydst.txt";
		String dst ="copysrc.txt";
		Path source = Paths.get(src);
		Path dest = Paths.get(dst);
		Path destination = source.resolveSibling(dest);
		try {
			//Files.copy(source, destination);
			Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
		} catch (FileAlreadyExistsException fae) {
			fae.printStackTrace();
		} catch (NoSuchFileException nsfe) {
			nsfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}