package wbs.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
 * Nach dem Ende der Bundesligasaison ermitteln wir für jeden Verein
 * die Punktezahl und das Torverhältnis
 * 
 * Alle Vereine Packen wir in ein Set.
 * 
 * Dann iterieren wir über alle Vereine.
 * Die Iteration soll die Vereine aufsteigend sortiert liefern.
 * 
 * Sortierkriterien:
 * 1. Punktestand
 * 2. Torverhältnis
 * 3. Name
 * 
 */
class Verein {
	private String name;
	private Integer punkte;
	private Integer torVerhaeltnis;

	public Verein(String name, Integer punkte, Integer torVerhaeltnis) {
		this.name = name;
		this.punkte = punkte;
		this.torVerhaeltnis = torVerhaeltnis;
	}

	@Override
	public String toString() {
		return "Verein [punkte=" + punkte + ", torVerhaeltnis="
				+ torVerhaeltnis + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public Integer getPunkte() {
		return punkte;
	}

	public Integer getTorVerhaeltnis() {
		return torVerhaeltnis;
	}

}

public class BundesligaDemo {

	public static void main(String[] args) {

		Comparator<Verein> cmp = new Comparator<Verein>() {

			public int compare(Verein o1, Verein o2) {
				int result = 0;
				// null-fähiger Comparator - sollte nicht gemacht werden
				if ((o1==null) && (o2 != null)) {
					return -1;
				};
				if ((o1!=null) && (o2 == null)) {
					return 1;
				};
				if ((o1 == null) && (o2 == null)) {
					return 0;
				};
				result = o1.getPunkte().compareTo(o2.getPunkte());
				if (result == 0) {
					result = o1.getTorVerhaeltnis().compareTo(
							o2.getTorVerhaeltnis());
				}
				;
				if (result == 0) {
					result = o1.getName().compareTo(o2.getName());
				}
				return result;
			}

		};
		Set<Verein> vereinsListe = new TreeSet<>(cmp);
		vereinsListe.add(new Verein("1. FC Köln", 43, -4));
		vereinsListe.add(new Verein("TSG 1899 Hoffenheim", 37, -15));
		vereinsListe.add(new Verein("SV Darmstadt 98", 38, -15));
		vereinsListe.add(new Verein("FC Bayern München", 88, 63));
		vereinsListe.add(new Verein("FC Schalke 04", 52, 2));
		vereinsListe.add(new Verein("SV Werder Bremen", 38, -15));
		vereinsListe.add(new Verein("Hertha BSC", 50, 0));
		vereinsListe.add(new Verein("FC Ingolstadt 04", 40, -9));
		vereinsListe.add(new Verein("Hannover 96", 25, -31));
		vereinsListe.add(new Verein("Bayer 04 Leverkusen", 60, 16));
		vereinsListe.add(new Verein("Eintracht Frankfurt", 36, -18));
		vereinsListe.add(new Verein("Borussia Dortmund", 78, 48));
		vereinsListe.add(new Verein("Borussia Mönchengladbach", 55, 17));
		vereinsListe.add(new Verein("VfB Stuttgart", 33, -25));
		vereinsListe.add(new Verein("1. FSV Mainz 05", 50, 4));
		vereinsListe.add(new Verein("FC Augsburg", 38, -10));
		vereinsListe.add(new Verein("Hamburger SV", 41, -6));
		vereinsListe.add(new Verein("VfL Wolfsburg", 45, -2));
		vereinsListe.add(null);
		vereinsListe.add(null);
		
		for(Verein verein : vereinsListe) {
			System.out.println(verein);
		}
		

	}
}
