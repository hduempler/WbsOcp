package wbs.enumeration;

enum DayOfWeek {
	MO("Montag"), DI("Dienstag");
	// class body
	private String bez;

	// Konstruktoren eines Enum werden implizit aufgerufen
	// Sie dürfen nicht explizit aufgerufen werden.
	// Sie dürfen nicht als public oder protected deklariert werden.

	// Die Methode toString() darf überschrieben werden.
	// hashCode() und equals() aber NICHT!

	private DayOfWeek(String bez) {
		this.bez = bez;
	}

	public String getBez() {
		return this.bez;
	}

	public void setBez(String bez) {
		this.bez = bez;
	}

	public String toString() {
		return this.bez;
	}
}

public class DayOfWeekDemo {

	public static void main(String[] args) {
		DayOfWeek day = DayOfWeek.MO;
		System.out.println(day); // Montag
		day.setBez("Monday");
		System.out.println(day); // Monday
		System.out.println(day.name()); // MO
	}

}
