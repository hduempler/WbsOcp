package wbs.string_processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Wir ermitteln für jedes Wort in "Song Of Myself",
 * wie häufig es vorkommt.
 * 
 * Wir geben alle Wörter aus:
 * - alphanumerisch aufsteigend
 * - absteigend nach Häufigkeit
 * 
 * Unterschiede zwischen Groß- und Kleinschreibung werden ignoriert.
 * 
 * Was ist ein Wort?
 * Was ein Wort ist entscheide ich selbst.
 * 
 */
public class WhitmanDemo {

	public static void main(String[] args) throws IOException {
		String filename = "resources/io/characterdata/song_of_myself_whitman.txt";
		String line = "";
		String pattern = "\\b+[a-z]+\\b";
		Pattern compiledPattern = Pattern.compile(pattern);
		Map<String, AtomicInteger> wordMap = new TreeMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while ((line = br.readLine()) != null) {
				line = line.toLowerCase();
				Matcher matcher = compiledPattern.matcher(line);

				while (matcher.find()) {
					String word = matcher.group();
					if (wordMap.containsKey(word)) {
						wordMap.get(word).incrementAndGet();
					} else {
						wordMap.put(word, new AtomicInteger(1));
					}
				}
			}
			for (Map.Entry<String, AtomicInteger> entry : wordMap.entrySet()) {
				System.out.println(entry.getKey() + " -> " + entry.getValue().get());

			}

			List<Map.Entry<String, AtomicInteger>> list = new ArrayList<>(
					wordMap.entrySet());
			Collections.sort(list,
					new Comparator<Map.Entry<String, AtomicInteger>>() {

						@Override
						public int compare(Map.Entry<String, AtomicInteger> e1,
								Map.Entry<String, AtomicInteger> e2) {
							int result = Integer.compare(e2.getValue().get(),
									e1.getValue().get());
							if (result == 0) {
								result = e1.getKey().compareTo(e2.getKey());
							}

							return result;
						}

					});
			System.out.println("--------------------------------------------");
			/*
			 * Wir schreiben das Ergebnis in eine Datei / geeignet formatiert
			 */
			
			String pathToStatistics ="resources/io/characterdata/song_of_myself_whitman_daten.txt";

			try(PrintWriter pw = new PrintWriter(pathToStatistics)) {
				for (Map.Entry<String, AtomicInteger> entry : list) {
					pw.printf("%20s: %10d%n", entry.getKey(), entry.getValue().get());
					//System.out.println(entry.getKey() + " -> " + entry.getValue());
				
			}
				

			}
			
			

		}
	}
}
