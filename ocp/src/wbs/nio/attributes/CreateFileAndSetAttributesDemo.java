package wbs.nio.attributes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/*
 * Wir erzeugen eine einzeilige Textdatei und schließen sie.
 * 
 * Wir öffnen die Textdatei und hängen eine Zeile an und schließen erneut.
 * Dann setzen wir das dos-Attribut readonly auf true
 * 
 * Dann versuchen wir nochmals, eine Zeile anzuhängen
 * 
 */

public class CreateFileAndSetAttributesDemo {

	public static void main(String[] args) throws IOException {

		Path path = Paths
				.get("resources/io/characterdata/CreateFileAndSetAttributesDemo.txt");

		// Wir erzeugen eine einzeilige Textdatei und schließen sie:
		try (BufferedWriter bw = Files.newBufferedWriter(path,
				Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
			bw.write("Zeile 1\n");
		}

		// try-with-resources hat die Datei automatisch geschlossen.

		// Dateiinhalt ausgeben:
		System.out.println(Files.readAllLines(path, Charset.defaultCharset()));

		// Wir öffnen die Textdatei, hängen eine Zeile an und schließen
		// erneut:
		try (BufferedWriter bw = Files.newBufferedWriter(path,
				Charset.forName("UTF-8"), StandardOpenOption.APPEND)) {
			bw.write("Zeile 2\n");
		}

		// Dateiinhalt ausgeben:
		System.out.println(Files.readAllLines(path, Charset.defaultCharset()));

		// Dann setzen wir das dos-Attribut readonly auf true:

		Files.setAttribute(path, "dos:readonly", true);

		// Versuchen, die Datei zum Schreiben zu öffnen:
		try (BufferedWriter bw = Files.newBufferedWriter(path,
				Charset.forName("UTF-8"), StandardOpenOption.APPEND)) {
			bw.write("Zeile 3\n");
		} catch (AccessDeniedException e) {
			System.out.printf("Die Datei %s ist schreibgeschützt.", path);
		} finally {
			// Schließlich setzen wir das dos-Attribut readonly wieder auf false:
			Files.setAttribute(path, "dos:readonly", false);
		}

	}

}
