package wbs.generics;

import java.io.Serializable;
import java.util.Calendar;

class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int geburtsjahr;
	private String geschlecht;

	public Person(String name, int geburtsjahr, String geschlecht) {
		this.name = name;
		this.geburtsjahr = geburtsjahr;
		this.geschlecht = geschlecht;
	}

	public String getName() {
		return name;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	public int getAlter() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR)-geburtsjahr;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + "(" + getAlter()	+ ")";
	}

}
