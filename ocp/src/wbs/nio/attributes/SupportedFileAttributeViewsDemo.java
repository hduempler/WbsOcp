package wbs.nio.attributes;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Set;

public class SupportedFileAttributeViewsDemo {
	public static void main(String[] args) {
		FileSystem fileSystem = FileSystems.getDefault();
		Set<String> views = fileSystem.supportedFileAttributeViews();
		for (String supported : views) {
			System.out.println(supported);
		}
		// acl basic owner user dos
	}
}