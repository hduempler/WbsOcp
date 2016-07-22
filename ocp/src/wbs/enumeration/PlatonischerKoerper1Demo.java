package wbs.enumeration;

enum PlatonischerKoerper1 {
	TETRAEDER {
		public int flaechen() {
			return 4;
		}

		public int kanten() {
			return 6;
		}

		public int ecken() {
			return 4;
		}
	},
	OKTAEDER {
		public int flaechen() {
			return 8;
		}

		public int kanten() {
			return 12;
		}

		public int ecken() {
			return 6;
		}
	},
	HEXAEDER {
		public int flaechen() {
			return 6;
		}

		public int kanten() {
			return 12;
		}

		public int ecken() {
			return 8;
		}
	},
	IKOSAEDER {
		public int flaechen() {
			return 20;
		}

		public int kanten() {
			return 30;
		}

		public int ecken() {
			return 12;
		}
	},
	DODEKAEDER {
		public int flaechen() {
			return 12;
		}

		public int kanten() {
			return 30;
		}

		public int ecken() {
			return 20;
		}
	};
	// class-body
	public abstract int flaechen();

	public abstract int kanten();

	public abstract int ecken();
}

public class PlatonischerKoerper1Demo {

	public static void main(String[] args) {
		// gibt die charakteristischen Werte für jede enum-Konstante,
		// also jeden platonischen Körper aus
		for (PlatonischerKoerper1 pk1 : PlatonischerKoerper1.values()) {
			System.out.println(pk1.name() + " Flächen: " + pk1.flaechen()
					+ ", Kanten: " + pk1.kanten() + ", Ecken: " + pk1.ecken());
			// für jede enum-Konstante generiert der Compiler hier eine eigene
			// (anonyme) Klasse
			// wbs.enumeration.PlatonischerKoerper1$1
			// wbs.enumeration.PlatonischerKoerper1$2
			// ...
			// ...

			System.out.println(pk1.getClass().getName() + " -> "
					+ pk1.getDeclaringClass().getName());
			System.out.println("------------------------------");
		}

	}

}
