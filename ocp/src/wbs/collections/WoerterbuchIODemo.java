package wbs.collections;

import java.io.IOException;

public class WoerterbuchIODemo {

	public static void main(String[] args) {
		Woerterbuch wb = new Woerterbuch("deutsch", "englisch");
		String filename = "resources/io/characterdata/woerterbuch_deutsch_englisch.txt";
		try {
			wb.importFromCSV(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String entry : wb.srcWords()) {
			String[] dst = wb.getWords(entry).toArray(new String[0]);
			for (String s : dst) {
				System.out.println(entry + " -> " + s);
			}

		}

		try {
			wb.exportAsCSV("resources/io/characterdata/woerterbuch_deutsch_englisch_kopie.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
