package wbs.collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Wie könnte die Schnittstelle eines brauchbaren Wörterbuches aussehen?
 * (für den Zweck des Schimpfens)
 */
//@formatter:off
/*
 * Zu einem Wort der Quellsprache / des Quelldialekts
 * kann es beliebig viele Wörter der Zielsprache / des Zieldialekts geben 
 * (Wörter der Zielsprache aufsteigend sortiert)
 * 
 * 
 * Ein Wörterbuch soll invertiert werden können
 * Neue Wörterbücher sollen aus bestehenden erzeugt werden können
 * 
 * Wörterbücher sollen persistiert werden können
 * (als CSV-Datei, als serialisiertes Java-Objekt, als XML-Datei, Datenbank)
 * und aus externen Dateien / Datenbank rekonstruiert werden können.
 * 
 * Elementare Operationen:
 * 
 * putWord() -> zu einem Wort der Quellsprache ein ein Wort der Zielsprache eintragen
 * putWords() -> zu einem Wort der Quellsprache beliebig viele Wörter der Zielsprache eintragen
 * updateWord() -> ersetzt zu einem Wort der Quellsprache ein Wort der Zielsprache durch ein anderes
 * removeWord() -> löscht zu einem Wort der Quellsprache ein Wort der Zielsprache
 * removeEntry() -> löscht einen Eintrag der Quellsprache komplett 
 *
 * Alle Methoden liefern den Typ boolean 
 * (true, falls durch den Aufruf der Operation das Wörterbuch geändert wurde)
 */
//@formatter:on

public class Woerterbuch {

	private NavigableMap<String, NavigableSet<String>> dictionary;
	private String srcLanguage;
	private String dstLanguage;

	public Woerterbuch(String srcLanguage, String dstLanguage) {
		this.dictionary = new TreeMap<>();
		this.srcLanguage = srcLanguage;
		this.dstLanguage = dstLanguage;
	}

	public String getSrcLanguage() {
		return srcLanguage;
	}

	public String getDstLanguage() {
		return dstLanguage;
	}

	public NavigableSet<String> getWords(String srcWord) {
		return dictionary.get(srcWord);
	}

	public Set<String> srcWords() {
		return dictionary.keySet();
	}

	public Woerterbuch invertDict() {
		Woerterbuch wbInv = new Woerterbuch(this.getDstLanguage(),
				this.getSrcLanguage());

		for (Map.Entry<String, NavigableSet<String>> entry : dictionary
				.entrySet()) {
			String srcWord = entry.getKey();
			for (String destWord : entry.getValue()) {
				wbInv.putWord(destWord, srcWord);
			}
		}

		return wbInv;
	}

	public boolean putWord(String srcWord, String dstWord) {
		NavigableSet<String> dstWords = dictionary.get(srcWord);
		if (dstWords == null) {
			dstWords = new TreeSet<>();
			dictionary.put(srcWord, dstWords);
		}
		return dstWords.add(dstWord);
	}

	public boolean putWords(String srcWord, String dstWord, String... dstWords) {
		boolean isChanged_1 = putWord(srcWord, dstWord);
		boolean isChanged_2 = dictionary.get(srcWord).addAll(
				Arrays.asList(dstWords));
		return isChanged_1 || isChanged_2;
	}

	public boolean updateWord(String srcWord, String dstOldWord,
			String dstNewWord) {

		NavigableSet<String> dstWords = dictionary.get(srcWord);
		boolean isChanged = false;
		if ((dstWords != null) && (dstWords.contains(dstOldWord))
				&& (!dstWords.contains(dstNewWord))) {
			dstWords.remove(dstOldWord);
			dstWords.add(dstNewWord);
			isChanged = true;
		}
		return isChanged;

	}

	public boolean removeWord(String srcWord, String dstWord) {
		NavigableSet<String> dstWords = dictionary.get(srcWord);
		boolean isChanged = false;
		if (dstWords != null) {

			if (dstWords.remove(dstWord)) {
				isChanged = true;
				if (dstWords.isEmpty()) {
					removeEntry(srcWord);
				}
			}
		}
		return isChanged;
	}

	public boolean removeEntry(String srcWord) {

		return (dictionary.remove(srcWord) != null);

	}

	//@formatter:off
	
		/*
		 * Wir schreiben die Methode combine(). Sie liefert zu zwei Wörterbüchern
		 * ein drittes Wörterbuch.
		 * 
		 * wb1: a -> b (österreichisch -> hochdeutsch)
		 * wb2: b -> c (hochdeutsch -> plattdeutsch)
		 * 
		 * Ergebnis:
		 * wb3: a -> c (österreichisch -> plattdeutsch)
		 * 
		 */
	//@formatter:on

	public static Woerterbuch combine(Woerterbuch wb1, Woerterbuch wb2)
			throws IllegalArgumentException {
		if (!((wb1.getSrcLanguage().equals(wb2.getDstLanguage()) || (wb2
				.getSrcLanguage().equals(wb1.getDstLanguage()))))) {
			throw new IllegalArgumentException("Invalid Arguments...");
		}

		Woerterbuch wb = new Woerterbuch(wb1.getSrcLanguage(),
				wb2.getDstLanguage());

		return wb;
	}

	/*
	 * Wir schreiben die MEthode importFromCSV() Sie importiert Daten aus einer
	 * externen Datei ins Wörterbuch. Format der Eingabedatei:
	 * source:dest1,dest2,dest3...
	 */

	public void importFromCSV(String filename) throws IOException {
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while ((line = br.readLine()) != null) {
				String[] entry = line.split(":");
				for (String dstWord : entry[1].split(",")) {
					putWord(entry[0], dstWord);
				}

			}

		}
	}

	public void exportAsCSV(String filename) throws IOException {
		String line = "";
		try (PrintWriter pw = new PrintWriter(filename)) {

			for (String s : srcWords()) {
				line = s + ":";
				Iterator<String> itr = getWords(s).iterator();
				while (itr.hasNext()) {
					line += itr.next();
					if (itr.hasNext())
						line += ",";
				}
				pw.println(line);
			}
		}

	}
}
