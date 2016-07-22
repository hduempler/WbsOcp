package wbs.generics;

import java.util.Comparator;

// T1: Immobilienmakler, Partnersuchender
// T2: Kaufinteressent, Partnersuchender

// verwendet die distanz zwischen einer instanz von T1 und einer instanz von T2
// zum vergleich von zwei T2- instanzen

// distance(a_poor_lonely_cowboy, eine hundehütte_der_pampa) : 0
// distance(lady mary, eine_hundehütte_in_der_pampa) : 85367

// => die hundehütte passt besser zum cowboy als zu lady mary

public abstract class DistanceComparatorGZ<T1, T2> implements Comparator<T2> {

	private T1 t1;
	private int limit;

	public DistanceComparatorGZ(int limit) {
		this.limit = limit;
	}
	
	/*
	 * kontrakt: distance liefert einen wert >= 0.
	 */
	public abstract double distance(T1 t1, T2 t2);

	@Override
	public int compare(T2 t21, T2 t22) {
		double d1 = distance(t1, t21);
		double d2 = distance(t1, t22);
		return Double.compare(d1, d2);
	}

	public T1 getT1() {
		return t1;
	}

	public void setT1(T1 t1) {
		this.t1 = t1;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
