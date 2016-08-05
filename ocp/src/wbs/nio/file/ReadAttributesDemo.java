package wbs.nio.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ReadAttributesDemo {
	public static void main(String[] args) {
		//String dir = "E:/bbehrensdorf";
		String dir = "resources/java_keywords.txt";

		
		
		
		
		
		
		Path path = Paths.get(dir);
		try {
			Map<String, Object> attributes = Files.readAttributes(path,
					"size,lastModifiedTime,lastAccessTime");
			for (Object o : attributes.values()) {
				System.out.println(o.getClass().getName() + " -> " + o);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("-----------");
		try {
			Map<String, Object> attributes = Files.readAttributes(path, "*");
			for (Map.Entry<String, Object> entry : attributes.entrySet()) {
				if (entry.getValue() != null) {
					System.out.println(entry.getKey() + "," + entry.getValue()
							+ "(" + entry.getValue().getClass().getSimpleName()
							+ ")");
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("------------");
		try {
			Object o = Files.getAttribute(path, "creationTime");
			System.out.println(o);
			System.out.println(Files.getAttribute(path, "lastModifiedTime"));
			System.out.println(Files.getAttribute(path, "dos:hidden"));
			System.out.println(Files.getAttribute(path, "isDirectory"));
			// System.out.println(Files.getAttribute(path,"posix:uid"));
			// ...
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}