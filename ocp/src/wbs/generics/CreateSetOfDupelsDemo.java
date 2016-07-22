package wbs.generics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

enum Geschlecht {
	MAENNLICH("männlich"), WEIBLICH("weiblich");
	private String bez;

	Geschlecht(String bez) {
		this.bez = bez;
	}

	public String getBez() {
		return bez;
	}

	public void setBez(String bez) {
		this.bez = bez;
	}

}

class Mensch {
	private String name;
	private Geschlecht geschlecht;
	public Mensch(String name, Geschlecht geschlecht) {
		this.name = name;
		this.geschlecht = geschlecht;
	}
	public String getName() {
		return name;
	}
	public Geschlecht getGeschlecht() {
		return geschlecht;
	}
	@Override
	public String toString() {
		return name;
	}
	

}

public class CreateSetOfDupelsDemo {

	public static void main(String[] args) {

		System.out.println(Geschlecht.MAENNLICH.getBez());
		String[] mystrings1 = { "Grzegorz", "Markus", "Bärbel", "Alexander",
				"Klaus", "Irena", "Nicole", "Reinhard",

		};

		String[] mystrings2 = { "Michael", "Ute", "Samuil", "Madeleine" };
		@SuppressWarnings("unused")
		Matcher<String, String> stringMatcher = new Matcher<String, String>() {
			@Override
			public boolean isMatching(String t1, String t2) {
				return t1.length() == t2.length();
			}
		};

		Matcher<Mensch, Mensch> menschenMatcher = new Matcher<Mensch, Mensch>() {
			@Override
			public boolean isMatching(Mensch p1, Mensch p2) {
				return p1.getGeschlecht()==Geschlecht.MAENNLICH && p2.getGeschlecht()==Geschlecht.WEIBLICH;
			}
		};

		new Comparator<Dupel<String, String>>() {

			@Override
			public int compare(Dupel<String, String> d1,
					Dupel<String, String> d2) {
				int diff = d1.getA().compareTo(d2.getA());
				if (diff == 0) {
					diff = d1.getB().compareTo(d2.getB());
				}
				return diff;
			}

		};

		Comparator<Dupel<Mensch, Mensch>> persCmp = new Comparator<Dupel<Mensch, Mensch>>() {

			@Override
			public int compare(Dupel<Mensch, Mensch> d1,
					Dupel<Mensch, Mensch> d2) {
				int diff = d1.getA().getName().compareTo(d2.getA().getName());
				if (diff == 0) {
					diff = d1.getB().getName().compareTo(d2.getB().getName());
				}
				return diff;
			}

		};
		new HashSet<>(Arrays.asList(mystrings1));
		new HashSet<>(Arrays.asList(mystrings2));
		Set<Mensch> menschen = new HashSet<>();
		menschen.add(new Mensch("Markus",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Bärbel",Geschlecht.WEIBLICH));
		menschen.add(new Mensch("Alexander",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Klaus",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Irena",Geschlecht.WEIBLICH));
		menschen.add(new Mensch("Nicole",Geschlecht.WEIBLICH));
		menschen.add(new Mensch("Reinhard",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Norbert",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Ersin",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Wolfgang",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Darlen",Geschlecht.WEIBLICH));
		menschen.add(new Mensch("Korkmaz",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Karl-Dieter",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Gerhard",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Doritha",Geschlecht.WEIBLICH));
		menschen.add(new Mensch("Jutta",Geschlecht.WEIBLICH));
		menschen.add(new Mensch("Ursula",Geschlecht.WEIBLICH));
		menschen.add(new Mensch("Renate",Geschlecht.WEIBLICH));
		menschen.add(new Mensch("Barbara",Geschlecht.WEIBLICH));
		menschen.add(new Mensch("Klara",Geschlecht.WEIBLICH));
		menschen.add(new Mensch("Herbert",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Jörg",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Heidrun",Geschlecht.WEIBLICH));
		menschen.add(new Mensch("Andreas",Geschlecht.MAENNLICH));
		menschen.add(new Mensch("Susanne",Geschlecht.WEIBLICH));


		Set<Dupel<Mensch, Mensch>> dupelSet1 = SetUtil.createSetOfDupels(menschen,
				menschen, menschenMatcher, persCmp);

		for (Dupel<Mensch, Mensch> dupel : dupelSet1) {
			System.out.println(dupel);
		}
	}

}
