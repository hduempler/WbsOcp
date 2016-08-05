package wbs.string_processing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * Wir berechnen für jede Zeile aus zahlen.txt die Summe und geben sie aus.
 * Zum Zerlegen der Zeile verwenden wir einen StringTokenizer.
 * Fehlerhafte Zeilen führen zu einer Fehlermeldung.
 *  
 */
public class ParseNumberLinesDemo {

	public static void main(String[] args) {

		String filename = "resources/io/characterdata/zahlen.txt";
		String line;
		double gesamtSumme = 0.0;
		List<String> fehlerListe = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			int counter = 0;
			while ((line = br.readLine()) != null) {
				double zeilenSumme = 0.0;
				StringTokenizer st = new StringTokenizer(line);
				counter++;
				while (st.hasMoreElements()) {
					String token = st.nextToken();
					try {
						double zahl = Double.valueOf(token);
						zeilenSumme += zahl;
					} catch (NumberFormatException e) {
						//System.out.println("Ungültige Zahl:" + token);
						fehlerListe.add(String.format(
								"Ungültiger Eintrag in Zeile %2$d: %1$s", token ,counter));
					}

				}
				gesamtSumme += zeilenSumme;
				System.out.println(String.format("%-20s %,10.2f",
						String.format("%s %d:", "Zeilensumme", counter),
						zeilenSumme));
			}

			System.out.println("________________________________________");
			System.out.println(String.format("%-20s %,10.2f", "Gesamtsumme:",
					gesamtSumme));
			System.out.println();
			if (fehlerListe.size() == 0) {
				System.out.println("Es sind keine Fehler aufgetreten!");
			} else {
				System.out.println("Es sind " + fehlerListe.size() + " Fehler aufgetreten:");
				for (String s : fehlerListe) {
					System.out.println(s);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
