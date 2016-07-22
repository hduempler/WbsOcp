package wbs.generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class Verein {
	private String name;
	private Integer punkte;
	private Integer torDifferenz;

	public Verein(String name, Integer punkte, Integer torDifferenz) {
		this.name = name;
		this.punkte = punkte;
		this.torDifferenz = torDifferenz;
	}

	@Override
	public String toString() {
		return "Verein [punkte=" + punkte + ", torDifferenz=" + torDifferenz
				+ ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public Integer getPunkte() {
		return punkte;
	}

	public Integer getTorDifferenz() {
		return torDifferenz;
	}

}

class Einwohner {
	private String name;
	private int alter;
	private String partei;

	public Einwohner(String name, int alter) {
		super();
		this.name = name;
		this.alter = alter;
	}

	public Einwohner(String name, int alter, String partei) {
		super();
		this.name = name;
		this.alter = alter;
		this.partei = partei;
	}

	public int getAlter() {
		return alter;
	}

	public String getName() {
		return name;
	}

	public String getPartei() {
		return partei;
	}

}

class PartnerSucher {
	private String name;
	private int alter;
	private String geschlecht;
	private String geschlechtsPraeferenz;
	private Set<String> hobbys = new HashSet<>();

	public PartnerSucher(String name, int alter, String geschlecht,
			String geschlechtsPraeferenz, String[] hobbys) {
		this.name = name;
		this.alter = alter;
		this.geschlecht = geschlecht;
		this.geschlechtsPraeferenz = geschlechtsPraeferenz;
		this.hobbys.addAll(Arrays.asList(hobbys));

	}

	@Override
	public String toString() {
		return name
				+ " ("
				+ alter
				+ ") mag "
				+ (geschlechtsPraeferenz.equals("weiblich") ? "Frauen"
						: "Männer") + "\n"
				+ (geschlecht.equals("weiblich") ? "ihre " : "seine ")
				+ "Hobbys: " + getHobbys();
	}

	public String getName() {
		return name;
	}

	public int getAlter() {
		return alter;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public String getGeschlechtsPraeferenz() {
		return geschlechtsPraeferenz;
	}

	public Set<String> getHobbys() {
		return hobbys;
	}

}

public class SetUtilDemo {

	public static void main(String[] args) {
		Set<Verein> vereinsListe = new HashSet<>();
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

		// for (Verein verein : vereinsListe) {
		// System.out.println(verein);
		// }

		Filter<Verein> vereinFilter = new Filter<Verein>() {

			@Override
			public boolean accept(Verein verein) {
				return verein.getTorDifferenz() > 0;
			}

		};

		Filter<Einwohner> personFilterAlter = new Filter<Einwohner>() {

			@Override
			public boolean accept(Einwohner person) {
				return person.getAlter() >= 65;
			}

		};

		Filter<Einwohner> personFilterName = new Filter<Einwohner>() {

			@Override
			public boolean accept(Einwohner person) {
				return person.getName() == "Dieter";
			}

		};

		System.out.println(SetUtil.countByProperty(vereinsListe, vereinFilter)
				+ " Vereine haben eine positive Tordifferenz.");
		System.out.println("-------------------------------");
		Set<Einwohner> abgeordnete = new HashSet<>();
		abgeordnete.add(new Einwohner("Sabine", 48, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ellen", 86, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Walter", 88, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ekkehard", 73, "Die Linke"));
		abgeordnete.add(new Einwohner("Silke", 55, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Cordula", 55, "Die Linke"));
		abgeordnete.add(new Einwohner("Ulrike", 45, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Birgit", 54, "SPD"));
		abgeordnete.add(new Einwohner("Fernando", 62, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Tobias", 45, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Eva", 66, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Dennis", 39, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Stefan", 47, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Anny", 79, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Jutta", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Lars", 48, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Barbara", 71, "SPD"));
		abgeordnete.add(new Einwohner("Darlen", 63, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Frank", 53, "SPD"));
		abgeordnete.add(new Einwohner("Dieter", 72, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Helmut", 70, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Margret", 75, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Markus", 41, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Dieter", 75, "Die Linke"));
		abgeordnete.add(new Einwohner("Roland", 52, "CDU/CSU"));
		abgeordnete
				.add(new Einwohner("Katharina", 49, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Renate", 64, "SPD"));
		abgeordnete.add(new Einwohner("Tobias", 52, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Kirsten", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Jan", 31, "SPD"));
		abgeordnete.add(new Einwohner("Monica", 58, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Petra", 50, "SPD"));
		abgeordnete.add(new Einwohner("Bernd", 63, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Magdalena", 39, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Wolfgang", 76, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Claudia", 52, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Johanna", 79, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Roland", 69, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Madeleine", 38, "SPD"));
		abgeordnete.add(new Einwohner("Wolf-Jürgen", 67, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Grzegorz", 37, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Marion", 61, "SPD"));
		abgeordnete.add(new Einwohner("Roland", 45, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Jutta", 77, "SPD"));
		abgeordnete.add(new Einwohner("Ewa", 50, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Alina", 57, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ingeborg", 68, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Wolfgang", 63, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Marcel", 54, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Waldemar", 43, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Amja", 46, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Heinz", 77, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Renate", 57, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Irmgard", 78, "SPD"));
		abgeordnete.add(new Einwohner("Heiko", 42, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Werner", 69, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Michaela", 43, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Anke", 54, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Anja", 42, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Rüdiger", 62, "Die Linke"));
		abgeordnete.add(new Einwohner("Irmgard", 82, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Dieter", 64, "SPD"));
		abgeordnete.add(new Einwohner("Bettina", 51, "SPD"));
		abgeordnete.add(new Einwohner("Doris", 47, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Vera", 31, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Tanja", 34, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Birgit", 55, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Michael", 54, "SPD"));
		abgeordnete.add(new Einwohner("Florian", 62, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ngoc Anh", 35, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Renata", 46, "SPD"));
		abgeordnete
				.add(new Einwohner("Karl-Heinz", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Martin", 56, "SPD"));
		abgeordnete.add(new Einwohner("Karl-Dieter", 63, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Inge", 89, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete
				.add(new Einwohner("Alexander", 44, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Hans-Dieter", 71,
				"BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Klaus", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Wilhelma", 71, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Reinhard", 80, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Cordula", 48, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Otto", 65, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Christina", 48, "SPD"));
		abgeordnete.add(new Einwohner("Britta", 34, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Martina", 58, "SPD"));
		abgeordnete.add(new Einwohner("Heinz", 65, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Olaf", 68, "SPD"));
		abgeordnete.add(new Einwohner("Gabriele", 66, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Corrina", 50, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Klaus", 76, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Gerd", 73, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Karwan", 48, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Uta", 58, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Dora", 85, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Margot", 79, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Gorden", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Brigitte", 63, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Susanne", 58, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Sigrid", 78, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Ursula", 64, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Viktoria", 31, "SPD"));
		abgeordnete.add(new Einwohner("Bettina", 71, "Die Linke"));
		abgeordnete.add(new Einwohner("Hannelore", 81, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Anja", 47, "SPD"));
		abgeordnete.add(new Einwohner("Thomas-Wolfgang", 48, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Solveig", 45, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Elfriede", 76, "CDU/CSU"));
		abgeordnete
				.add(new Einwohner("Christiane", 49, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Eva", 52, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Peter-Gerd", 71, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Bernd", 50, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Elke", 50, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Rolf", 73, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Andrea", 49, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Waltraud", 50, "SPD"));
		abgeordnete.add(new Einwohner("Anna", 36, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Günter", 65, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Alfredo", 78, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Beatrice", 52, "SPD"));
		abgeordnete.add(new Einwohner("Udo", 45, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Grischa", 34, "SPD"));
		abgeordnete.add(new Einwohner("Heidrun", 66, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Norbert", 59, "SPD"));
		abgeordnete.add(new Einwohner("Ute", 61, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Dieter", 75, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Björn", 45, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Stefan", 48, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Nikolaos", 41, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Klaus", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Reinhard", 69, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Regina", 62, "Die Linke"));
		abgeordnete.add(new Einwohner("Pierre", 49, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Christa", 75, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Angelika", 62, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Yulia", 33, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ursula", 66, "SPD"));
		abgeordnete.add(new Einwohner("Danuta", 57, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Cornelia", 55, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Karsten", 75, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Hans", 80, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Peter", 71, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Werner", 62, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Marlies", 66, "SPD"));
		abgeordnete.add(new Einwohner("Andrea", 50, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Stefan", 49, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Angelika", 63, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Gudrun", 67, "SPD"));
		abgeordnete.add(new Einwohner("Werner", 72, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Pietro", 41, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Maria", 39, "SPD"));
		abgeordnete.add(new Einwohner("Erhard", 64, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Gitta", 72, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Petra", 57, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Bärbel", 56, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Sandra", 43, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Dieter", 64, "SPD"));
		abgeordnete.add(new Einwohner("Martina", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Ulrike", 51, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Gerda", 57, "Die Linke"));
		abgeordnete.add(new Einwohner("Iris", 56, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Britta", 39, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Hiltrud", 48, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Doritha", 70, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Anke", 75, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Herbert", 78, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete
				.add(new Einwohner("Hans-Gerd", 50, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Ursula", 82, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Dimitri", 39, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Petra", 48, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Harry", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Ingeborg", 62, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Reiner", 57, "Die Linke"));
		abgeordnete.add(new Einwohner("Bettina", 52, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Eberhard", 65, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Sonja", 43, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Klaus", 67, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Manfred", 65, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Cornelia", 64, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Walter", 81, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Ralph", 40, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Karola", 74, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Karin", 59, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ute", 76, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Edeltraut", 62, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Dr. Ute", 49, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Christina", 50, "Die Linke"));
		abgeordnete.add(new Einwohner("Helga", 75, "SPD"));
		abgeordnete.add(new Einwohner("Britta", 47, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ina", 41, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Maj-Britt", 48, "SPD"));
		abgeordnete.add(new Einwohner("Ulrich", 59, "SPD"));
		abgeordnete.add(new Einwohner("Lothar", 80, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Kristina", 45, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ina", 52, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Erika", 59, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Jutta", 69, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Volker", 45, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Jan", 32, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Dominik", 35, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Klara", 31, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Sigrid", 65, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Beatrix", 59, "CDU/CSU"));
		abgeordnete
				.add(new Einwohner("Karl-Heinz", 76, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Elke", 76, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Andreas", 52, "SPD"));
		abgeordnete.add(new Einwohner("Falk", 36, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Jürgen", 67, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Anna", 42, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Holger", 54, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Heike", 43, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Andrea", 50, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Michael", 54, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Heinz", 81, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Klaus-Peter", 64, "SPD"));
		abgeordnete.add(new Einwohner("Charlotte", 61, "SPD"));
		abgeordnete.add(new Einwohner("Iris", 60, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Bärbel", 50, "SPD"));
		abgeordnete.add(new Einwohner("Julia", 42, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Christina", 60, "CDU/CSU"));
		abgeordnete
				.add(new Einwohner("Hildegard", 75, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Petra", 51, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Eilert", 45, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Norbert", 63, "Die Linke"));
		abgeordnete
				.add(new Einwohner("Friederike", 74, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("André", 41, "SPD"));
		abgeordnete.add(new Einwohner("Klaudia", 63, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Günter", 76, "SPD"));
		abgeordnete.add(new Einwohner("Detlef", 66, "Die Linke"));
		abgeordnete.add(new Einwohner("Peter", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Hans-Joachim", 59, "SPD"));
		abgeordnete.add(new Einwohner("Uta", 70, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Hans-Günter", 64, "SPD"));
		abgeordnete.add(new Einwohner("Klaus-Dieter", 75,
				"BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Bodo", 61, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Claudia", 71, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ulrich", 72, "SPD"));
		abgeordnete.add(new Einwohner("Joachim", 76, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Wilfried", 79, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete
				.add(new Einwohner("H.-Albert", 82, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete
				.add(new Einwohner("Alexandra", 43, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Stefanie", 38, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Bruno", 72, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Valentina", 70, "CDU/CSU"));
		abgeordnete
				.add(new Einwohner("Rosemarie", 74, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Wilfried", 62, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Robert", 63, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Aneta", 38, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Sergiy", 41, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Wilfried", 71, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Christoph", 57, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Jürgen", 68, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Michael", 61, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Susanne", 79, "SPD"));
		abgeordnete.add(new Einwohner("Edeltraud", 59, "SPD"));
		abgeordnete.add(new Einwohner("Ali", 36, "SPD"));
		abgeordnete.add(new Einwohner("Ahmad", 34, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Julia", 28, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ersin", 36, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Horst", 76, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Thorsten", 45, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Heike-Ingeborg", 72,
				"BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Burgit", 68, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Sofia", 48, "SPD"));
		abgeordnete.add(new Einwohner("Daniela", 35, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Renate", 63, "SPD"));
		abgeordnete.add(new Einwohner("Samuil", 59, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Horst Jürgen", 78,
				"BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Eckhard", 86, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Herbert", 82, "Die Linke"));
		abgeordnete.add(new Einwohner("Rita", 73, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Iris", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Petra", 58, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Jörg", 54, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Manfred", 70, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Dirk", 55, "SPD"));
		abgeordnete.add(new Einwohner("Bernhard", 59, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Christian", 51, "Die Linke"));
		abgeordnete.add(new Einwohner("Andreas", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Gabriele", 60, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Hans-Michael", 63, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Carsten", 45, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Claus", 81, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Claudia", 35, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Corena", 61, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Carsten", 47, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Wolfgang", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Manuela", 49, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Michael", 56, "SPD"));
		abgeordnete.add(new Einwohner("Annette", 50, "SPD"));
		abgeordnete.add(new Einwohner("Klaus", 62, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Bernhard", 63, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Olaf", 43, "SPD"));
		abgeordnete.add(new Einwohner("Thomas", 33, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Julia", 37, "SPD"));
		abgeordnete.add(new Einwohner("Ralf-Reimund", 64, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Monika", 77, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Markus", 51, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Salah", 63, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ingrid", 64, "SPD"));
		abgeordnete.add(new Einwohner("Ingrid", 72, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Julia", 35, "SPD"));
		abgeordnete.add(new Einwohner("Jiuxin", 46, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Dr. Stefanie", 42, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Reinhard", 86, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Michael", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Markus", 46, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Dr. Jens", 37, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Sven", 56, "SPD"));
		abgeordnete.add(new Einwohner("Andreas", 40, "SPD"));
		abgeordnete.add(new Einwohner("Petra", 62, "SPD"));
		abgeordnete.add(new Einwohner("Melanie", 35, "SPD"));
		abgeordnete.add(new Einwohner("Andreas", 50, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Kerstin", 55, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Anne-France", 44,
				"BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Maria", 81, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Klaus", 56, "SPD"));
		abgeordnete.add(new Einwohner("Irena", 70, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Hans-Jürgen", 65,
				"BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Kirsten", 54, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ute", 73, "SPD"));
		abgeordnete.add(new Einwohner("Anthimos", 82, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Erika", 66, "SPD"));
		abgeordnete.add(new Einwohner("Hans", 65, "SPD"));
		abgeordnete.add(new Einwohner("Viola", 52, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Sabina", 50, "SPD"));
		abgeordnete.add(new Einwohner("Hartmut", 60, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Wilhelm", 60, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Claudia", 45, "Die Linke"));
		abgeordnete
				.add(new Einwohner("Lieselotte", 83, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Klaus", 58, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Kirsten", 53, "SPD"));
		abgeordnete.add(new Einwohner("Katrin", 38, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Nicole", 47, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Peter", 75, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Volker", 46, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Bruno", 56, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Michael-Patrick", 47, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Heinrich", 61, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Wolfgang", 34, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Horst", 71, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Melanie", 46, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Torsten", 46, "SPD"));
		abgeordnete.add(new Einwohner("Cengiz", 52, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Manfred", 62, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ekkehard", 49, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Irmhild", 47, "SPD"));
		abgeordnete.add(new Einwohner("Eleonore", 74, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Adrian", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Manfred", 69, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Dirk", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Gerhard", 84, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Bärbel", 68, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Dirk", 58, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Werner", 43, "Die Linke"));
		abgeordnete.add(new Einwohner("Uwe", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Nadine", 34, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Thomas", 47, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Jürgen", 49, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Oliver", 42, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Inge", 60, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Barbara", 54, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Korkmaz", 41, "Die Linke"));
		abgeordnete.add(new Einwohner("Michael", 73, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Johann", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Vitali", 43, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Wilhelm", 74, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Bettina", 55, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Tanja", 51, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Björn", 45, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Rüdiger", 55, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Ilona", 64, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Gitta", 62, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Martina", 44, "SPD"));
		abgeordnete.add(new Einwohner("Arash", 44, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Günther", 74, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Annegret", 50, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Kirsten", 48, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Klaus-Dieter", 74,
				"BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Stefan", 40, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Bernd", 68, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Jürgen", 65, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Heinrich", 82, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Ingrid", 70, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Elena", 51, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Wolfgang", 61, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Edgara", 83, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Dorothea", 77, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Waltraut", 81, "SPD"));
		abgeordnete.add(new Einwohner("Gerold", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Sabine", 53, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Rainer", 46, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Sabine", 62, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Frieda", 93, "SPD"));
		abgeordnete.add(new Einwohner("Brigitte", 80, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Gerhard", 81, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Monika", 59, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Barbara", 53, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Hans-Karl", 73, "SPD"));
		abgeordnete.add(new Einwohner("Nils", 43, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Milica", 57, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Parviz", 62, "BÜNDNIS 90/DIE GRÜNEN"));
		abgeordnete.add(new Einwohner("Udo", 52, "CDU/CSU"));
		abgeordnete.add(new Einwohner("Carmen", 66, "BÜNDNIS 90/DIE GRÜNEN"));

		Mapper<Einwohner, String> mapper = new Mapper<Einwohner, String>() {

			@Override
			public String map(Einwohner o) {
				return o.getPartei();
			}
		};

		System.out.println(SetUtil.countByProperty(abgeordnete,
				personFilterAlter) + " Abgeordnete sind 65 Jahre oder älter.");
		System.out.println(SetUtil.countByProperty(abgeordnete,
				personFilterName) + " Abgeordnete heißen Dieter.");
		Map<String, Einwohner> representantenMap;
		representantenMap = SetUtil.repraesentanten(abgeordnete, mapper);
		for (Map.Entry<String, Einwohner> entry : representantenMap.entrySet()) {
			System.out.println(entry.getKey() + ": "
					+ entry.getValue().getName());
		}

		System.out
				.println("--------------------------------------------------------------");
		System.out
				.println("-------------- Matcher Demo ----------------------------------");
		System.out
				.println("--------------------------------------------------------------");
		Matcher<PartnerSucher, PartnerSucher> matcher = new Matcher<PartnerSucher, PartnerSucher>() {

			@Override
			public boolean isMatching(PartnerSucher t1, PartnerSucher t2) {
				if (t1 != t2) {
					if ((Math.abs(t1.getAlter() - t2.getAlter()) <= 25)
							&& (t1.getGeschlecht() == t2
									.getGeschlechtsPraeferenz())

							&& (t2.getGeschlecht() == t1
									.getGeschlechtsPraeferenz())

					) {
						Set<String> tmpSet = new HashSet<>();
						tmpSet.addAll(t1.getHobbys());
						tmpSet.retainAll(t2.getHobbys());
						if (tmpSet.size() >= 2) {
							return true;
						}

					}
				}
				// TODO Auto-generated method stub
				return false;
			};

		};

		Set<PartnerSucher> partnersuchende = new HashSet<>();
		partnersuchende.add(new PartnerSucher("Sabine", 28, "weiblich",
				"männlich", new String[] { "stricken", "jagen", "reisen",
						"lesen" }));
		partnersuchende.add(new PartnerSucher("Ellen", 66, "weiblich",
				"männlich", new String[] { "segeln", "gärtnern", "fliegen",
						"trinken", "lesen" }));
		partnersuchende.add(new PartnerSucher("Walter", 68, "männlich",
				"weiblich", new String[] { "musik", "fußball", "lesen",
						"stricken", "trinken" }));
		partnersuchende.add(new PartnerSucher("Ekkehard", 53, "männlich",
				"weiblich", new String[] { "fliegen", "musik", "jagen",
						"fußball", "trinken", "jagen" }));
		partnersuchende.add(new PartnerSucher("Silke", 35, "weiblich",
				"männlich", new String[] { "kunst sammeln", "fliegen",
						"stricken", "reisen", "briefmarken sammeln" }));
		partnersuchende.add(new PartnerSucher("Cordula", 35, "weiblich",
				"männlich", new String[] { "gärtnern", "fliegen", "musik",
						"fußball", "kunst sammeln" }));
		partnersuchende.add(new PartnerSucher("Ulrike", 25, "weiblich",
				"männlich", new String[] { "angeln", "reisen", "kunst sammeln",
						"gärtnern", "jagen" }));
		partnersuchende.add(new PartnerSucher("Birgit", 34, "weiblich",
				"männlich", new String[] { "trinken", "fußball", "lesen",
						"musik", "gärtnern" }));
		partnersuchende.add(new PartnerSucher("Fernando", 42, "männlich",
				"weiblich", new String[] { "fußball", "reisen", "lesen",
						"trinken", "fliegen", "gärtnern" }));
		partnersuchende.add(new PartnerSucher("Tobias", 25, "männlich",
				"männlich", new String[] { "kunst sammeln", "reisen",
						"gärtnern", "musik" }));
		partnersuchende.add(new PartnerSucher("Eva", 46, "weiblich",
				"weiblich", new String[] { "briefmarken sammeln", "fliegen",
						"jagen", "trinken", "gärtnern", "jagen" }));
		partnersuchende.add(new PartnerSucher("Dennis", 19, "männlich",
				"weiblich", new String[] { "fliegen", "jagen",
						"briefmarken sammeln", "lesen", "gärtnern", "musik" }));
		partnersuchende.add(new PartnerSucher("Stefan", 27, "männlich",
				"weiblich", new String[] { "angeln", "segeln", "gärtnern",
						"fliegen" }));
		partnersuchende.add(new PartnerSucher("Anny", 59, "weiblich",
				"männlich", new String[] { "reisen", "fußball", "gärtnern",
						"angeln", "kunst sammeln" }));
		partnersuchende.add(new PartnerSucher("Jutta", 31, "weiblich",
				"männlich", new String[] { "trinken", "jagen" }));
		partnersuchende.add(new PartnerSucher("Lars", 28, "männlich",
				"weiblich", new String[] { "fußball", "reisen", "trinken",
						"angeln" }));
		partnersuchende.add(new PartnerSucher("Barbara", 51, "weiblich",
				"männlich", new String[] { "kunst sammeln", "angeln",
						"kunst sammeln", "musik", "gärtnern" }));
		partnersuchende.add(new PartnerSucher("Darlen", 43, "weiblich",
				"männlich", new String[] { "segeln", "reisen", "kunst sammeln",
						"angeln", "gärtnern", "fliegen" }));
		partnersuchende.add(new PartnerSucher("Frank", 33, "männlich",
				"weiblich", new String[] { "lesen", "trinken", "kunst sammeln",
						"jagen", "segeln" }));
		partnersuchende.add(new PartnerSucher("Dieter", 52, "männlich",
				"weiblich", new String[] { "reisen", "trinken", "angeln",
						"musik", "briefmarken sammeln", "stricken" }));
		partnersuchende.add(new PartnerSucher("Helmut", 50, "männlich",
				"männlich", new String[] { "lesen", "angeln", "jagen",
						"fußball", "angeln", "stricken" }));
		partnersuchende.add(new PartnerSucher("Margret", 55, "weiblich",
				"männlich", new String[] { "trinken", "fußball", "segeln",
						"briefmarken sammeln", "stricken" }));
		partnersuchende.add(new PartnerSucher("Markus", 21, "männlich",
				"weiblich", new String[] { "gärtnern", "stricken", "fußball",
						"lesen" }));
		partnersuchende.add(new PartnerSucher("Dieter", 55, "männlich",
				"weiblich", new String[] { "briefmarken sammeln", "fußball",
						"gärtnern", "angeln", "lesen", "stricken" }));
		partnersuchende.add(new PartnerSucher("Roland", 32, "männlich",
				"weiblich", new String[] { "musik", "fliegen", "lesen",
						"stricken", "jagen" }));
		partnersuchende.add(new PartnerSucher("Katharina", 29, "weiblich",
				"männlich", new String[] { "trinken", "segeln", "angeln",
						"fliegen", "fußball" }));
		partnersuchende.add(new PartnerSucher("Renate", 44, "weiblich",
				"männlich", new String[] { "angeln", "jagen", "fliegen",
						"stricken", "trinken", "fußball" }));
		partnersuchende.add(new PartnerSucher("Tobias", 32, "männlich",
				"weiblich", new String[] { "fliegen", "briefmarken sammeln",
						"jagen", "angeln", "segeln" }));
		partnersuchende.add(new PartnerSucher("Kirsten", 31, "weiblich",
				"männlich", new String[] { "fliegen", "lesen", "jagen",
						"reisen", "musik" }));
		partnersuchende.add(new PartnerSucher("Jan", 11, "männlich",
				"weiblich", new String[] { "gärtnern", "fußball", "reisen",
						"gärtnern", "segeln" }));
		partnersuchende.add(new PartnerSucher("Monica", 38, "weiblich",
				"weiblich", new String[] { "musik", "trinken", "kunst sammeln",
						"fußball", "segeln", "fußball" }));
		partnersuchende.add(new PartnerSucher("Petra", 30, "weiblich",
				"männlich", new String[] { "fliegen", "trinken", "gärtnern",
						"segeln", "trinken", "fußball" }));
		partnersuchende.add(new PartnerSucher("Bernd", 43, "männlich",
				"weiblich", new String[] { "gärtnern", "briefmarken sammeln",
						"segeln", "gärtnern", "fliegen", "jagen" }));
		partnersuchende.add(new PartnerSucher("Magdalena", 19, "weiblich",
				"männlich", new String[] { "musik", "reisen", "stricken",
						"reisen", "gärtnern", "trinken" }));
		partnersuchende.add(new PartnerSucher("Wolfgang", 56, "männlich",
				"weiblich", new String[] { "segeln", "fußball",
						"briefmarken sammeln", "fliegen",
						"briefmarken sammeln", "lesen" }));
		partnersuchende.add(new PartnerSucher("Claudia", 32, "weiblich",
				"männlich", new String[] { "reisen", "trinken",
						"briefmarken sammeln", "kunst sammeln",
						"briefmarken sammeln", "reisen" }));
		partnersuchende.add(new PartnerSucher("Johanna", 59, "weiblich",
				"männlich", new String[] { "trinken", "reisen", "trinken",
						"musik", "kunst sammeln", "fliegen" }));
		partnersuchende.add(new PartnerSucher("Roland", 49, "männlich",
				"männlich", new String[] { "stricken", "jagen",
						"kunst sammeln", "gärtnern", "jagen" }));
		partnersuchende.add(new PartnerSucher("Madeleine", 18, "weiblich",
				"männlich", new String[] { "jagen", "kunst sammeln", "fußball",
						"fliegen", "lesen", "jagen" }));
		partnersuchende.add(new PartnerSucher("Wolf-Jürgen", 47, "männlich",
				"weiblich", new String[] { "gärtnern", "fliegen", "gärtnern",
						"kunst sammeln", "reisen", "lesen" }));
		partnersuchende.add(new PartnerSucher("Grzegorz", 17, "männlich",
				"weiblich", new String[] { "musik", "jagen", "trinken",
						"kunst sammeln" }));
		partnersuchende.add(new PartnerSucher("Marion", 41, "weiblich",
				"männlich", new String[] { "trinken", "kunst sammeln",
						"angeln", "segeln", "lesen" }));
		partnersuchende.add(new PartnerSucher("Roland", 25, "männlich",
				"weiblich",
				new String[] { "briefmarken sammeln", "briefmarken sammeln",
						"trinken", "stricken", "fliegen" }));
		partnersuchende.add(new PartnerSucher("Jutta", 57, "weiblich",
				"männlich", new String[] { "musik", "fußball", "gärtnern",
						"trinken", "stricken", "jagen" }));
		partnersuchende.add(new PartnerSucher("Ewa", 30, "weiblich",
				"männlich", new String[] { "musik", "kunst sammeln",
						"stricken", "segeln", "lesen", "fußball" }));
		partnersuchende.add(new PartnerSucher("Alina", 37, "weiblich",
				"männlich", new String[] { "fliegen", "musik", "gärtnern",
						"musik", "fliegen" }));
		partnersuchende.add(new PartnerSucher("Ingeborg", 48, "weiblich",
				"weiblich", new String[] { "musik", "briefmarken sammeln",
						"trinken", "segeln", "kunst sammeln" }));
		partnersuchende.add(new PartnerSucher("Wolfgang", 43, "männlich",
				"weiblich", new String[] { "angeln", "fußball", "stricken",
						"kunst sammeln", "lesen" }));
		partnersuchende.add(new PartnerSucher("Marcel", 34, "männlich",
				"weiblich", new String[] { "reisen", "lesen", "kunst sammeln",
						"trinken", "musik", "angeln" }));
		partnersuchende.add(new PartnerSucher("Waldemar", 23, "männlich",
				"weiblich", new String[] { "briefmarken sammeln", "reisen",
						"gärtnern", "segeln", "fußball" }));
		partnersuchende.add(new PartnerSucher("Amja", 26, "weiblich",
				"männlich", new String[] { "gärtnern", "stricken", "lesen",
						"musik", "jagen", "kunst sammeln" }));
		partnersuchende.add(new PartnerSucher("Heinz", 57, "männlich",
				"weiblich", new String[] { "gärtnern", "fliegen", "gärtnern",
						"kunst sammeln", "reisen", "lesen" }));
		partnersuchende.add(new PartnerSucher("Renate", 37, "weiblich",
				"männlich", new String[] { "musik", "jagen", "trinken",
						"kunst sammeln" }));
		partnersuchende.add(new PartnerSucher("Irmgard", 58, "weiblich",
				"weiblich", new String[] { "trinken", "kunst sammeln",
						"angeln", "segeln", "lesen" }));
		partnersuchende.add(new PartnerSucher("Heiko", 22, "männlich",
				"weiblich",
				new String[] { "briefmarken sammeln", "briefmarken sammeln",
						"trinken", "stricken", "fliegen" }));
		partnersuchende.add(new PartnerSucher("Werner", 49, "männlich",
				"weiblich", new String[] { "musik", "fußball", "gärtnern",
						"trinken", "stricken", "jagen" }));
		partnersuchende.add(new PartnerSucher("Michaela", 23, "weiblich",
				"männlich", new String[] { "musik", "kunst sammeln",
						"stricken", "segeln", "lesen", "fußball" }));
		partnersuchende.add(new PartnerSucher("Anke", 34, "weiblich",
				"männlich", new String[] { "fliegen", "musik", "gärtnern",
						"musik", "fliegen" }));
		partnersuchende.add(new PartnerSucher("Anja", 22, "weiblich",
				"männlich", new String[] { "musik", "briefmarken sammeln",
						"trinken", "segeln", "kunst sammeln" }));
		partnersuchende.add(new PartnerSucher("Rüdiger", 42, "männlich",
				"weiblich", new String[] { "angeln", "fußball", "stricken",
						"kunst sammeln", "lesen" }));

		Map<PartnerSucher, Set<PartnerSucher>> partner = SetUtil
				.matchingCandidates(partnersuchende, partnersuchende, matcher);

		for (Map.Entry<PartnerSucher, Set<PartnerSucher>> entry : partner
				.entrySet()) {
			System.out.println(entry.getKey() + "\npasst zu:");
			for (PartnerSucher ps : entry.getValue()) {
				System.out.println(ps);
			}
			System.out.println();
		}

		System.out.println("-----------------------------------");

		System.out.println("-------- SortedProposals-----------");
		System.out.println("-----------------------------------");

		Set<Integer> set = new HashSet<>();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			set.add(rnd.nextInt(20) + 11);
		}

		ScoredMatcher<Integer, Integer> scoredMatcher = new ScoredMatcher<Integer, Integer>() {

			@Override
			public int getMatching(Integer t1, Integer t2) {

				return Math.abs(t2-t1);
			}

		};
		Map<Integer, List<Integer>> proposals = SetUtil.sortedProposals2(set,
				set, 4, scoredMatcher);
		for (Map.Entry<Integer,List<Integer>> entry : proposals.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

	}
}
