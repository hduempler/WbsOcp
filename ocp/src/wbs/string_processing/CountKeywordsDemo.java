package wbs.string_processing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Wir iterieren über alle Java-Sourcen in einem Verzeichnis
 * und ermitteln für jedes Schlüsselwort in Java, wie häufig es insgesamt verwendet wird.
 * 
 *  Die Liste mit den Schlüsselwörtern wird aus einer Datei eingelesen (java_keywords.txt).
 *  Die Liste wird absteigend sortiert nach Häufigkeit aus gegeben.  
 *  
 *  Was nützlich sein könnte:
 *  - File + FileNameFilter
 *  - ScannerDemo2
 *  - Map <Schlüsselwort, Anzahl>
 *  - AtomicInteger
 *  
 */

class ValueComp implements Comparator<Map.Entry<String, AtomicInteger>> {
	public int compare(Map.Entry<String, AtomicInteger> a,
			Map.Entry<String, AtomicInteger> b) {
		int result = Integer.compare(b.getValue().intValue(), a.getValue()
				.intValue());
		if (result == 0) {
			result = a.getKey().compareTo(b.getKey());
		}
		return result;
	}
}

public class CountKeywordsDemo {

	public static void main(String[] args) {
		String keyWordsFilename = "resources/java_keywords.txt";
		String sourcesPath = "src/wbs/io";

		Map<String, AtomicInteger> map = new HashMap<String, AtomicInteger>();
		try (Scanner kwScanner = new Scanner(new File(keyWordsFilename))) {
			kwScanner.useDelimiter("\\W+");
			while (kwScanner.hasNext()) {
				map.put(kwScanner.next(), new AtomicInteger(0));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		File sources = new File(sourcesPath);
		String[] sourceFileNames = sources.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".java");
			}
		});

		for (String s : sourceFileNames) {
			File file = new File(sourcesPath + "/" + s);
			String token;
			try (Scanner scanner = new Scanner(file)) {
				scanner.useDelimiter("\\W+");
				while (scanner.hasNext()) {
					token = scanner.next();
					if (map.containsKey(token)) {
						map.get(token).incrementAndGet();
					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		int gesamtAnzahl = 0;
		for (AtomicInteger i : map.values()) {
			gesamtAnzahl += i.intValue();
		}
		List<Map.Entry<String, AtomicInteger>> list = new ArrayList<>(
				map.entrySet());
		Collections.sort(list, new ValueComp());
		for (Map.Entry<String, AtomicInteger> entry : list) {
			if (entry.getValue().intValue() > 0) {
				double anteil = (entry.getValue().doubleValue() / gesamtAnzahl) * 100;
				System.out.println(entry.getKey() + " = "
						+ entry.getValue().intValue()
						+ String.format(" (%.1f%%)", anteil));
			}
		}

	}
}
