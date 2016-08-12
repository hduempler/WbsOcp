package wbs.threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;

/*
 * Die main()-Methode startet einen Watch-Service in einem eigenen Thread.
 * In dem Verzeichnis, das vom Watch-Service überwacht wird, 
 * erzeugt der Main()-Thread einige neue Dateien (und pausiert dazwischen).
 * 
 * Mit dem Ende von main() soll auch der Watch-service-Thread beendet werden.
 * 
 */

class WatchThread implements Runnable {
	Path path;

	WatchThread(Path path) {
		this.path = path;
	}

	@Override
	public void run() {
		WatchService watchService = null;
		try {
			watchService = path.getFileSystem().newWatchService();
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
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
				switch (event.kind().name()) {
				case "OVERFLOW":
					System.out.println("We lost some events");
					break;
				case "ENTRY_CREATE":
					System.out.println(
							"File " + event.context() + " is created!");
					break;
				case "ENTRY_DELETE":
					System.out.println(
							"File " + event.context() + " is deleted!");
					break;
				}

				key.reset();
			}

		}

	}
}

public class WatchServiceThreadDemo {

	public static void main(String[] args) {
		Path path = Paths.get("C:/Users/Master/Documents");
		// Path path=Paths.get("resources/watchfolder");
		WatchThread watchThread = new WatchThread(path);
		Thread thread = new Thread(watchThread);
		thread.setDaemon(true);
		thread.start();

		try {
			List<Path> paths=new ArrayList<>();
			for (int i=1; i<=5;i++) {
				paths.add(Files.createTempFile(path, "tmp_", ".tmp"));
				Thread.sleep(1000);
			}
			for (int i=0; i<paths.size();i++) {
				Files.delete(paths.get(i));
				Thread.sleep(1000);
			}
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
