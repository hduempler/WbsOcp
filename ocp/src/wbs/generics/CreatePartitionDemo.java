package wbs.generics;

import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

class Ureinwohner {
	String name;
	int alter;
	String partei;

	public Ureinwohner(String name, int geburtsjahr, String partei) {
		this.name = name;
		this.alter = geburtsjahr;
		this.partei = partei;
	}

	@Override
	public String toString() {
		return name + "(" + alter + ", " + partei + ")";
	}

}

public class CreatePartitionDemo {

	public static void main(String[] args) {
		Set<Person> personen = new HashSet<>(PersonenUtilBB
				.getPersonen("E:\\bbehrensdorf\\personen.dat"));
//		List<Person> personen = PersonenUtilBB
//				.getPersonen("E:\\bbehrensdorf\\personen.dat");
		Set<Ureinwohner> einwohner = new HashSet<>();

		einwohner.add(new Ureinwohner("Sabine", 48, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ellen", 86, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Walter", 88, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ekkehard", 73, "Die Linke"));
		einwohner.add(new Ureinwohner("Silke", 55, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Cordula", 55, "Die Linke"));
		einwohner.add(new Ureinwohner("Ulrike", 45, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Birgit", 54, "SPD"));
		einwohner.add(new Ureinwohner("Fernando", 62, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Tobias", 45, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Eva", 66, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Dennis", 39, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Stefan", 47, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Anny", 79, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Jutta", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Lars", 48, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Barbara", 71, "SPD"));
		einwohner.add(new Ureinwohner("Darlen", 63, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Frank", 53, "SPD"));
		einwohner.add(new Ureinwohner("Dieter", 72, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Helmut", 70, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Margret", 75, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Markus", 41, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Dieter", 75, "Die Linke"));
		einwohner.add(new Ureinwohner("Roland", 52, "CDU/CSU"));
		einwohner
				.add(new Ureinwohner("Katharina", 49, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Renate", 64, "SPD"));
		einwohner.add(new Ureinwohner("Tobias", 52, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Kirsten", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Jan", 31, "SPD"));
		einwohner.add(new Ureinwohner("Monica", 58, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Petra", 50, "SPD"));
		einwohner.add(new Ureinwohner("Bernd", 63, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Magdalena", 39, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Wolfgang", 76, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Claudia", 52, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Johanna", 79, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Roland", 69, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Madeleine", 38, "SPD"));
		einwohner.add(new Ureinwohner("Wolf-Jürgen", 67, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Grzegorz", 37, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Marion", 61, "SPD"));
		einwohner.add(new Ureinwohner("Roland", 45, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Jutta", 77, "SPD"));
		einwohner.add(new Ureinwohner("Ewa", 50, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Alina", 57, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ingeborg", 68, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Wolfgang", 63, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Marcel", 54, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Waldemar", 43, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Amja", 46, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Heinz", 77, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Renate", 57, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Irmgard", 78, "SPD"));
		einwohner.add(new Ureinwohner("Heiko", 42, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Werner", 69, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Michaela", 43, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Anke", 54, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Anja", 42, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Rüdiger", 62, "Die Linke"));
		einwohner.add(new Ureinwohner("Irmgard", 82, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Dieter", 64, "SPD"));
		einwohner.add(new Ureinwohner("Bettina", 51, "SPD"));
		einwohner.add(new Ureinwohner("Doris", 47, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Vera", 31, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Tanja", 34, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Birgit", 55, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Michael", 54, "SPD"));
		einwohner.add(new Ureinwohner("Florian", 62, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ngoc Anh", 35, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Renata", 46, "SPD"));
		einwohner
				.add(new Ureinwohner("Karl-Heinz", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Martin", 56, "SPD"));
		einwohner.add(new Ureinwohner("Karl-Dieter", 63, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Inge", 89, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner
				.add(new Ureinwohner("Alexander", 44, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Hans-Dieter", 71,
				"BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Klaus", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Wilhelma", 71, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Reinhard", 80, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Cordula", 48, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Otto", 65, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Christina", 48, "SPD"));
		einwohner.add(new Ureinwohner("Britta", 34, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Martina", 58, "SPD"));
		einwohner.add(new Ureinwohner("Heinz", 65, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Olaf", 68, "SPD"));
		einwohner.add(new Ureinwohner("Gabriele", 66, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Corrina", 50, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Klaus", 76, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Gerd", 73, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Karwan", 48, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Uta", 58, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Dora", 85, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Margot", 79, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Gorden", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Brigitte", 63, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Susanne", 58, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Sigrid", 78, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Ursula", 64, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Viktoria", 31, "SPD"));
		einwohner.add(new Ureinwohner("Bettina", 71, "Die Linke"));
		einwohner.add(new Ureinwohner("Hannelore", 81, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Anja", 47, "SPD"));
		einwohner.add(new Ureinwohner("Thomas-Wolfgang", 48, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Solveig", 45, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Elfriede", 76, "CDU/CSU"));
		einwohner
				.add(new Ureinwohner("Christiane", 49, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Eva", 52, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Peter-Gerd", 71, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Bernd", 50, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Elke", 50, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Rolf", 73, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Andrea", 49, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Waltraud", 50, "SPD"));
		einwohner.add(new Ureinwohner("Anna", 36, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Günter", 65, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Alfredo", 78, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Beatrice", 52, "SPD"));
		einwohner.add(new Ureinwohner("Udo", 45, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Grischa", 34, "SPD"));
		einwohner.add(new Ureinwohner("Heidrun", 66, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Norbert", 59, "SPD"));
		einwohner.add(new Ureinwohner("Ute", 61, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Dieter", 75, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Björn", 45, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Stefan", 48, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Nikolaos", 41, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Klaus", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Reinhard", 69, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Regina", 62, "Die Linke"));
		einwohner.add(new Ureinwohner("Pierre", 49, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Christa", 75, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Angelika", 62, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Yulia", 33, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ursula", 66, "SPD"));
		einwohner.add(new Ureinwohner("Danuta", 57, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Cornelia", 55, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Karsten", 75, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Hans", 80, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Peter", 71, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Werner", 62, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Marlies", 66, "SPD"));
		einwohner.add(new Ureinwohner("Andrea", 50, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Stefan", 49, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Angelika", 63, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Gudrun", 67, "SPD"));
		einwohner.add(new Ureinwohner("Werner", 72, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Pietro", 41, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Maria", 39, "SPD"));
		einwohner.add(new Ureinwohner("Erhard", 64, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Gitta", 72, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Petra", 57, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Bärbel", 56, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Sandra", 43, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Dieter", 64, "SPD"));
		einwohner.add(new Ureinwohner("Martina", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Ulrike", 51, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Gerda", 57, "Die Linke"));
		einwohner.add(new Ureinwohner("Iris", 56, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Britta", 39, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Hiltrud", 48, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Doritha", 70, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Anke", 75, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Herbert", 78, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner
				.add(new Ureinwohner("Hans-Gerd", 50, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Ursula", 82, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Dimitri", 39, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Petra", 48, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Harry", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Ingeborg", 62, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Reiner", 57, "Die Linke"));
		einwohner.add(new Ureinwohner("Bettina", 52, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Eberhard", 65, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Sonja", 43, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Klaus", 67, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Manfred", 65, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Cornelia", 64, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Walter", 81, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Ralph", 40, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Karola", 74, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Karin", 59, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ute", 76, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Edeltraut", 62, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Dr. Ute", 49, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Christina", 50, "Die Linke"));
		einwohner.add(new Ureinwohner("Helga", 75, "SPD"));
		einwohner.add(new Ureinwohner("Britta", 47, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ina", 41, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Maj-Britt", 48, "SPD"));
		einwohner.add(new Ureinwohner("Ulrich", 59, "SPD"));
		einwohner.add(new Ureinwohner("Lothar", 80, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Kristina", 45, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ina", 52, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Erika", 59, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Jutta", 69, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Volker", 45, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Jan", 32, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Dominik", 35, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Klara", 31, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Sigrid", 65, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Beatrix", 59, "CDU/CSU"));
		einwohner
				.add(new Ureinwohner("Karl-Heinz", 76, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Elke", 76, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Andreas", 52, "SPD"));
		einwohner.add(new Ureinwohner("Falk", 36, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Jürgen", 67, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Anna", 42, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Holger", 54, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Heike", 43, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Andrea", 50, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Michael", 54, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Heinz", 81, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Klaus-Peter", 64, "SPD"));
		einwohner.add(new Ureinwohner("Charlotte", 61, "SPD"));
		einwohner.add(new Ureinwohner("Iris", 60, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Bärbel", 50, "SPD"));
		einwohner.add(new Ureinwohner("Julia", 42, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Christina", 60, "CDU/CSU"));
		einwohner
				.add(new Ureinwohner("Hildegard", 75, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Petra", 51, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Eilert", 45, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Norbert", 63, "Die Linke"));
		einwohner
				.add(new Ureinwohner("Friederike", 74, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("André", 41, "SPD"));
		einwohner.add(new Ureinwohner("Klaudia", 63, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Günter", 76, "SPD"));
		einwohner.add(new Ureinwohner("Detlef", 66, "Die Linke"));
		einwohner.add(new Ureinwohner("Peter", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Hans-Joachim", 59, "SPD"));
		einwohner.add(new Ureinwohner("Uta", 70, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Hans-Günter", 64, "SPD"));
		einwohner.add(new Ureinwohner("Klaus-Dieter", 75,
				"BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Bodo", 61, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Claudia", 71, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ulrich", 72, "SPD"));
		einwohner.add(new Ureinwohner("Joachim", 76, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Wilfried", 79, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner
				.add(new Ureinwohner("H.-Albert", 82, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner
				.add(new Ureinwohner("Alexandra", 43, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Stefanie", 38, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Bruno", 72, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Valentina", 70, "CDU/CSU"));
		einwohner
				.add(new Ureinwohner("Rosemarie", 74, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Wilfried", 62, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Robert", 63, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Aneta", 38, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Sergiy", 41, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Wilfried", 71, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Christoph", 57, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Jürgen", 68, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Michael", 61, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Susanne", 79, "SPD"));
		einwohner.add(new Ureinwohner("Edeltraud", 59, "SPD"));
		einwohner.add(new Ureinwohner("Ali", 36, "SPD"));
		einwohner.add(new Ureinwohner("Ahmad", 34, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Julia", 28, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ersin", 36, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Horst", 76, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Thorsten", 45, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Heike-Ingeborg", 72,
				"BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Burgit", 68, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Sofia", 48, "SPD"));
		einwohner.add(new Ureinwohner("Daniela", 35, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Renate", 63, "SPD"));
		einwohner.add(new Ureinwohner("Samuil", 59, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Horst Jürgen", 78,
				"BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Eckhard", 86, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Herbert", 82, "Die Linke"));
		einwohner.add(new Ureinwohner("Rita", 73, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Iris", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Petra", 58, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Jörg", 54, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Manfred", 70, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Dirk", 55, "SPD"));
		einwohner.add(new Ureinwohner("Bernhard", 59, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Christian", 51, "Die Linke"));
		einwohner.add(new Ureinwohner("Andreas", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Gabriele", 60, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Hans-Michael", 63, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Carsten", 45, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Claus", 81, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Claudia", 35, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Corena", 61, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Carsten", 47, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Wolfgang", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Manuela", 49, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Michael", 56, "SPD"));
		einwohner.add(new Ureinwohner("Annette", 50, "SPD"));
		einwohner.add(new Ureinwohner("Klaus", 62, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Bernhard", 63, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Olaf", 43, "SPD"));
		einwohner.add(new Ureinwohner("Thomas", 33, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Julia", 37, "SPD"));
		einwohner.add(new Ureinwohner("Ralf-Reimund", 64, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Monika", 77, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Markus", 51, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Salah", 63, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ingrid", 64, "SPD"));
		einwohner.add(new Ureinwohner("Ingrid", 72, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Julia", 35, "SPD"));
		einwohner.add(new Ureinwohner("Jiuxin", 46, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Dr. Stefanie", 42, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Reinhard", 86, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Michael", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Markus", 46, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Dr. Jens", 37, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Sven", 56, "SPD"));
		einwohner.add(new Ureinwohner("Andreas", 40, "SPD"));
		einwohner.add(new Ureinwohner("Petra", 62, "SPD"));
		einwohner.add(new Ureinwohner("Melanie", 35, "SPD"));
		einwohner.add(new Ureinwohner("Andreas", 50, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Kerstin", 55, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Anne-France", 44,
				"BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Maria", 81, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Klaus", 56, "SPD"));
		einwohner.add(new Ureinwohner("Irena", 70, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Hans-Jürgen", 65,
				"BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Kirsten", 54, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ute", 73, "SPD"));
		einwohner.add(new Ureinwohner("Anthimos", 82, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Erika", 66, "SPD"));
		einwohner.add(new Ureinwohner("Hans", 65, "SPD"));
		einwohner.add(new Ureinwohner("Viola", 52, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Sabina", 50, "SPD"));
		einwohner.add(new Ureinwohner("Hartmut", 60, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Wilhelm", 60, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Claudia", 45, "Die Linke"));
		einwohner
				.add(new Ureinwohner("Lieselotte", 83, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Klaus", 58, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Kirsten", 53, "SPD"));
		einwohner.add(new Ureinwohner("Katrin", 38, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Nicole", 47, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Peter", 75, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Volker", 46, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Bruno", 56, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Michael-Patrick", 47, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Heinrich", 61, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Wolfgang", 34, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Horst", 71, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Melanie", 46, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Torsten", 46, "SPD"));
		einwohner.add(new Ureinwohner("Cengiz", 52, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Manfred", 62, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ekkehard", 49, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Irmhild", 47, "SPD"));
		einwohner.add(new Ureinwohner("Eleonore", 74, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Adrian", 51, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Manfred", 69, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Dirk", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Gerhard", 84, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Bärbel", 68, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Dirk", 58, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Werner", 43, "Die Linke"));
		einwohner.add(new Ureinwohner("Uwe", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Nadine", 34, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Thomas", 47, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Jürgen", 49, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Oliver", 42, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Inge", 60, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Barbara", 54, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Korkmaz", 41, "Die Linke"));
		einwohner.add(new Ureinwohner("Michael", 73, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Johann", 60, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Vitali", 43, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Wilhelm", 74, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Bettina", 55, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Tanja", 51, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Björn", 45, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Rüdiger", 55, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Ilona", 64, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Gitta", 62, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Martina", 44, "SPD"));
		einwohner.add(new Ureinwohner("Arash", 44, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Günther", 74, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Annegret", 50, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Kirsten", 48, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Klaus-Dieter", 74,
				"BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Stefan", 40, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Bernd", 68, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Jürgen", 65, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Heinrich", 82, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Ingrid", 70, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Elena", 51, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Wolfgang", 61, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Edgara", 83, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Dorothea", 77, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Waltraut", 81, "SPD"));
		einwohner.add(new Ureinwohner("Gerold", 53, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Sabine", 53, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Rainer", 46, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Sabine", 62, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Frieda", 93, "SPD"));
		einwohner.add(new Ureinwohner("Brigitte", 80, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Gerhard", 81, "BÜNDNIS 90/DIE GRÜNEN"));
		einwohner.add(new Ureinwohner("Monika", 59, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Barbara", 53, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Hans-Karl", 73, "SPD"));
		einwohner.add(new Ureinwohner("Nils", 43, "CDU/CSU"));
		einwohner.add(new Ureinwohner("Milica", 57, "CDU/CSU"));

		Mapper<Person, Integer> mapper = new Mapper<Person, Integer>() {

			@Override
			public Integer map(Person o) {
				return o.getGeburtsjahr();
			}

		};
		Mapper<Ureinwohner, String> parteiMapper = new Mapper<Ureinwohner, String>() {

			@Override
			public String map(Ureinwohner o) {
				return o.partei;
			}

		};
		NavigableMap<Integer, Set<Person>> partition = new TreeMap<>(
				SetUtil.createPartition(personen, mapper));

		for (Map.Entry<Integer, Set<Person>> entry : partition.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());

		}

		System.out.println("----------------------------------");
		NavigableMap<String, Set<Ureinwohner>> partition2 = new TreeMap<>(
				SetUtil.createPartition(einwohner, parteiMapper));

		for (Map.Entry<String, Set<Ureinwohner>> entry : partition2.entrySet()) {
			System.out.println(entry.getValue().size() + ": " + entry.getKey()
					+ " -> " + entry.getValue());

		}

	}

}
