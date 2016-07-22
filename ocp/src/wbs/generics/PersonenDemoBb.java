package wbs.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

class Parteimitglied extends Person {

	private static final long serialVersionUID = 1L;

	private String partei;
	public Integer altersgruppe = 0;

	public Parteimitglied(Person p) {
		super(p.getName(), p.getGeburtsjahr(), p.getGeschlecht());
		this.partei = "";
	}

	public Parteimitglied(String name, int geburtsjahr, String geschlecht,
			String partei) {
		super(name, geburtsjahr, geschlecht);
		this.partei = partei;
	}

	public String getPartei() {
		return partei;
	}

	public void setPartei(String partei) {
		this.partei = partei;
	}

	@Override
	public String toString() {
		return super.toString() + " " + partei;
	}

}

interface PropSetter<O, P> {
	public boolean setProp(O o, P p);
}

interface PropReplacer<O, P> {
	public boolean replaceProp(O o, P searchVal, P replaceVal);
}

public class PersonenDemoBb {

	static <O, P> void setRandomProperty(Set<O> set, P value, double anteil,
			PropSetter<O, P> setter) {
		int gesamt = set.size();
		int anzahl = (int) Math.round(anteil * gesamt);
		List<O> tmpList = new ArrayList<>();
		tmpList.addAll(set);
		Collections.shuffle(tmpList);
		int counter = 0;
		for (int i = 0; counter < anzahl && i < tmpList.size(); i++) {
			if (setter.setProp(tmpList.get(i), value)) {
				counter++;
				continue;
			}
		}
	}

	static <O, P> void replaceProperty(Set<O> set, P searchValue,
			P replaceValue, PropReplacer<O, P> replacer) {
		for (O o : set) {
			replacer.replaceProp(o, searchValue, replaceValue);
		}
	}

	public static void main(String[] args) {
		Set<Person> personen = new HashSet<>(
				PersonenUtilBB.getPersonen("E:\\bbehrensdorf\\personen.dat"));
		Set<Parteimitglied> parteimitglieder = new HashSet<>();
		for (Person p : personen) {
			Parteimitglied pm = new Parteimitglied(p);
			parteimitglieder.add(pm);
		}

		PropSetter<Parteimitglied, String> propSetter = new PropSetter<Parteimitglied, String>() {

			@Override
			public boolean setProp(Parteimitglied o, String value) {
				if (o.getPartei().equals("")) {
					o.setPartei(value);
					return true;
				}
				return false;
			}

		};

		PropReplacer<Parteimitglied, String> nameReplacer = new PropReplacer<Parteimitglied, String>() {

			@Override
			public boolean replaceProp(Parteimitglied o, String searchVal,
					String replaceVal) {
				if (o.getName().equals(searchVal)) {
					o.setName(replaceVal);
					return true;
				}
				return false;
			}

		};

		PropReplacer<Parteimitglied, Double> agMaker = new PropReplacer<Parteimitglied, Double>() {

			@Override
			public boolean replaceProp(Parteimitglied o, Double searchVal,
					Double replaceVal) {
				if ((2016 - o.getGeburtsjahr()) >= searchVal
						&& o.altersgruppe.equals(0)) {
					o.altersgruppe = replaceVal.intValue();
					return true;
				}
				return false;
			}

		};

		setRandomProperty(parteimitglieder, "CDU", 0.38, propSetter);
		setRandomProperty(parteimitglieder, "SPD", 0.28, propSetter);
		setRandomProperty(parteimitglieder, "BÜNDNIS 90/GRÜNE", 0.2, propSetter);
		setRandomProperty(parteimitglieder, "Die Linke", 1, propSetter);
		replaceProperty(parteimitglieder, "Bettina", "XXXXXXXXXXXXXXXXX",
				nameReplacer);
		replaceProperty(parteimitglieder, 90.0, 9.0, agMaker);
		replaceProperty(parteimitglieder, 80.0, 8.0, agMaker);
		replaceProperty(parteimitglieder, 70.0, 7.0, agMaker);
		replaceProperty(parteimitglieder, 60.0, 6.0, agMaker);

		Mapper<Parteimitglied, String> parteiMapper = new Mapper<Parteimitglied, String>() {

			@Override
			public String map(Parteimitglied o) {
				return o.getPartei();
			}

		};

		Mapper<Parteimitglied, Integer> agMapper = new Mapper<Parteimitglied, Integer>() {

			@Override
			public Integer map(Parteimitglied o) {
				return o.altersgruppe;
			}

		};

		NavigableMap<String, Set<Parteimitglied>> partition2 = new TreeMap<>(
				SetUtil.createPartition(parteimitglieder, parteiMapper));

		for (Map.Entry<String, Set<Parteimitglied>> entry : partition2
				.entrySet()) {
			System.out.println(entry.getValue().size() + ": " + entry.getKey()
					+ " -> " + entry.getValue());

		}
		System.out
				.println("--------------------------------------------------");
		NavigableMap<Integer, Set<Parteimitglied>> partition3 = new TreeMap<>(
				SetUtil.createPartition(parteimitglieder, agMapper));

		for (Map.Entry<Integer, Set<Parteimitglied>> entry : partition3
				.entrySet()) {
			System.out.println(entry.getValue().size() + ": " + entry.getKey()
					+ " -> " + entry.getValue());

		}
	}

}
