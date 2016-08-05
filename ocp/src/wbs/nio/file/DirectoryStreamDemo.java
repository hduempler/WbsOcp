package wbs.nio.file;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamDemo {
	public static void main(String[] args) {
		Path dir = Paths.get("src/wbs/nio/file");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir,
				"*W*.java")) {
			for (Path path : stream) {
				System.out.println(path.getFileName());
			}
		} catch (DirectoryIteratorException die) {
			die.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}