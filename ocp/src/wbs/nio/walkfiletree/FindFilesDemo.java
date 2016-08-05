package wbs.nio.walkfiletree;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

//args[0] ${workspace_loc}
//args[1] glob:*.java
//liefert mit den angegebenen aufrufargumenten verzeichnisse und dateien
//mit der extension .java im workspace
public class FindFilesDemo {
	public static void main(String[] args) {
		Path searchDir = Paths.get(args[0]);
		String pattern = args[1];
		final PathMatcher matcher = FileSystems.getDefault().getPathMatcher(
				pattern);
		try {
			Files.walkFileTree(searchDir, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir,
						BasicFileAttributes attrs) throws IOException {
					//if (matcher.matches(dir.getFileName())) {
						System.out.println("directory: " + dir.toAbsolutePath());
					//}
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attrs) throws IOException {
					if (matcher.matches(file.getFileName())) {
						System.out.println("file: " + file.getFileName());
					}
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}