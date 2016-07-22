package wbs.enumeration;

enum Wochentag {
	// nach der letzten Enum-Konstante kann auch ein Semikolon stehen
	// ZUweisungen von initialen Werten sind nicht erlaubt
	// MO = 1 geht  n i c h t !
	MO, DI, MI, DO, FR, SA, SO
}

public class WochentagDemo {
	public static void m(Wochentag tag) {
		switch (tag) {
		// Das geht nicht:
		// case Wochentag.MO:
		case MO:
		case DI:
		case MI:
		case DO:
		case FR:
			System.out.println("Wir haben einen Werktag.");
			break;
		case SA:
			System.out.println("Es ist Samstag.");
			break;
		case SO:
			System.out.println("Es ist Sonntag.");
			break;
		default:
			// strange!
			// hier könnte auch ein AssertionError geworfen werden
			break;
		}
	}

	public static void main(String[] args) {

		Wochentag[] values = Wochentag.values();
		// Konstanten eines enum sind vom Typ des enum (oder eine Subklasse
		// dieses Typs)
		for (Wochentag tag : values) {
			System.out.print(tag.name() + " " + tag.ordinal()+ " -> "
					+ tag.getClass().getName() + " ");
			m(tag);
		}
	}

}
