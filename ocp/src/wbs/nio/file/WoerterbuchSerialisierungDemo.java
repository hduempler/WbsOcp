package wbs.nio.file;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import wbs.collections.Woerterbuch;

/*
 * Wir machen die Klasse Woerterbuch serialisierbar
 * Dann erzeugen wir ein Woerterbuch und lesen Daten aus einer csv-Datei ein
 * Dann serialisieren wir das Woerterbuch und holen den Stream zum Schreiben von Files
 * Dann holen wir einen InputStream von Files, lesen das serialisierte Wörterbuch ein und geben den Inhalt auf stdout aus
 * 
 */

public class WoerterbuchSerialisierungDemo {

	public static void main(String[] args) {
		Woerterbuch wb = new Woerterbuch("deutsch", "englisch");
		String filename = "resources/io/characterdata/woerterbuch_deutsch_englisch.txt";
		try {
			wb.importFromCSV(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String serFilename = "resources/io/characterdata/woerterbuch_deutsch_englisch.ser";

		try (ObjectOutputStream oos = new ObjectOutputStream(
				Files.newOutputStream(Paths.get(serFilename),
						StandardOpenOption.CREATE_NEW))) {
			oos.writeObject(wb);
			System.out.println("Datei wurde geschrieben");

		} catch (FileAlreadyExistsException e) {
			System.out.println("Datei ist schon vorhanden");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (ObjectInputStream ois = new ObjectInputStream(
				Files.newInputStream(Paths.get(serFilename)))) {

			Object o = ois.readObject();
			if (o.getClass() == Woerterbuch.class) {
				wb = (Woerterbuch) o;
				for (String entry : wb.srcWords()) {
					String[] dst = wb.getWords(entry).toArray(new String[0]);
					for (String s : dst) {
						System.out.println(entry + " -> " + s);
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
