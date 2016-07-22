package wbs.exceptions_assertions;

public class Assertion1Demo {

	public static void main(String[] args) {
		int i = Integer.MIN_VALUE;
		if (i < 0) {
			i = -i;
		}
		System.out.println("Der Wert von i ist: " + i);
		// i sollte also immer positiv sein
		assert (i >= 0) : "unmöglich: i ist negativ!";
	}

}
