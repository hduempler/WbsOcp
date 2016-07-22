package wbs.enumeration;

enum PlatonischerKoerper2 {

	// Wie PlatonischerKoerper1, aber die enum-Konstanten bekommen hier keinen
	// eigenen class-body
	TETRAEDER(4, 6, 4),
	OKTAEDER(8, 12, 6),
	HEXAEDER(6, 12, 8),
	IKOSAEDER(20, 30, 12),
	DODEKAEDER(12, 30, 20);

	private int flaechen;
	private int kanten;
	private int ecken;

	PlatonischerKoerper2(int flaechen, int kanten, int ecken) {
		this.flaechen = flaechen;
		this.kanten = kanten;
		this.ecken = ecken;
	};

	public int getFlaechen() {
		return flaechen;
	}

	public int getKanten() {
		return kanten;
	}

	public int getEcken() {
		return ecken;
	}

	@Override
	public String toString() {
		return name() + " (" + flaechen + ", " + kanten + ", " + ecken + ")";
	}
}

public class PlatonischerKoerper2Demo {

	public static void main(String[] args) {
		// gibt die charakteristischen Werte für jede enum-Konstante,
		// also jeden platonischen Körper aus
		for (PlatonischerKoerper2 pk2 : PlatonischerKoerper2.values()) {
				System.out.println(pk2);
			System.out.println("------------------------------");
		}

	}

}
