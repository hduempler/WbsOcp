package wbs.nested_classes;

public class Outer1 {

	private int n = 11;

	// Member - Klasse (inner class)
	class Inner1 {
		private int n = 12;

		// Eine Instanz einer Member-Klasse kann auf alle Member der äußeren
		// Klasse zugreifen
		// auch dann, wenn sie private sind

		// Outer1.this ist eine Referenz auf die Instanz der äußeren Klasse,
		// mit der die Instanz der inneren Klasse verbunden ist

		@Override
		public String toString() {
			return getClass().getName() + "," + n + "," + Outer1.this.n;
		}

		public Inner1 m1() {
			return new Inner1();
		}
		// m2() liefert einen Compiler-Fehler, weil statische Methoden keinen
		// Objektbezug haben, eine Instanz einer Memberklasse aber immer mit
		// einer Instanz der äußeren Klasse verbunden sein muss

		// public static Inner1 m2() {
		// return new Inner1();
		// }

	}

}
