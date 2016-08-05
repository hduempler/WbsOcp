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

class MyFileCounter extends SimpleFileVisitor<Path> {
	private int fileCount = 0;
	private int fileSize = 0;
	private String pattern;
	PathMatcher matcher;

	MyFileCounter(String pattern) {
		fileCount = 0;
		fileSize = 0;
		this.pattern = pattern;
		matcher = FileSystems.getDefault().getPathMatcher(pattern);
	}

	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		if (matcher.matches(file.getFileName())) {
			fileCount++;
			fileSize+=attrs.size();
		}
		return super.visitFile(file, attrs);
	}


	public void reset() {
		fileCount = 0;
		fileSize = 0;
	}

	public int getFileCount() {
		return fileCount;
	}

	public int getFileSize() {
		return fileSize;
	}


	public void setPattern(String pattern) {
		this.pattern = pattern;
		this.matcher = FileSystems.getDefault().getPathMatcher(this.pattern);
	}

}

public class WorkspaceStatistikDemo {
	// static int fileCount=0;

	public static void main(String[] args) throws IOException {
		Path searchDir = Paths.get("src");
		String pattern = "glob:*.java";
		MyFileCounter fc =new MyFileCounter(pattern);
		Files.walkFileTree(searchDir, fc);
		System.out.println(fc.getFileCount());
		System.out.printf("%,d Bytes\n", fc.getFileSize());

	}

}
