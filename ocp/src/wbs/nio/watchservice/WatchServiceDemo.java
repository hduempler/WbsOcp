package wbs.nio.watchservice;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceDemo {
	public static void main(String[] args) {
		Path path = Paths.get("C:/Users/Master/Documents");
		// Path path = Paths.get("resources");
		WatchService watchService = null;
		try {
			watchService = path.getFileSystem().newWatchService();
			path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (;;) {
			WatchKey key = null;
			try {
				key = watchService.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println(event);
				switch (event.kind().name()) {
				case "OVERFLOW":
					System.out.println("We lost some events");
					break;
				case "ENTRY_MODIFY":
					System.out.println("File " + event.context()
							+ " is changed!");
					break;
				case "ENTRY_CREATE":
					System.out.println("File " + event.context()
							+ " is created!");
					break;
				case "ENTRY_DELETE":
					System.out.println("File " + event.context()
							+ " is deleted!");
					break;
				}

				key.reset();
			}

		}
	}
}