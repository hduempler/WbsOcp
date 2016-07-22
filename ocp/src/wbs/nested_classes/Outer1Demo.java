package wbs.nested_classes;

public class Outer1Demo {

	public static void main(String[] args) {

		/*
		 * Wir erzeugen eine Instanz der Klasse Outer1 und zwei mit dieser
		 * Instanz verbundene Instanzen der Klasse Inner1 und geben die
		 * String-Repräsentationen der beiden Instanzen der inneren Klasse aus
		 */

		Outer1 outer1 = new Outer1();
		Outer1.Inner1 inner11=outer1.new Inner1();
		Outer1.Inner1 inner12=outer1.new Inner1();
		System.out.println(inner11);
		System.out.println(inner12);
		
	}

}
