package wbs.string_processing;

import java.util.Locale;

// wo wird linksbündig ausgegeben?
// wo wird rechtsbündig ausgegeben?
// welchen einfluss hat das Locale auf dezimalpunkt / tausendertrennung?
// was unterscheidet %f von %e?
// wo erscheinen negative zahlen in runden klammern?
// wo wird der gewöhnliche index verwendet, wo argindex?
// wo wird auch ein positives vorzeichen ausgegeben?
// wo wird ein string in grossbuchstaben ausgegeben?
// wo wird die groesse des ausgabebereichs explizit angegeben?

public class S31_Uebung {

	public static void main(String[] args) {

		// Locale.setDefault(Locale.US);
		// System.out.println(Locale.getDefault());

		System.out.printf("Der Preis ist: %.2f€%n", 5.99);
		
		System.out.printf("%s sagt: %d ist %2$dmal zuviel. %n", "Konfuzius",
				100);
		
		int i1 = -123;
		int i2 = 12345;
		
		System.out.printf(">%1$(7d< %n", i1);
		
		System.out.printf(">%0,7d< %n", i2);
		
		System.out.printf(">%+-7d< %n", i2);
		
		System.out.printf(">%2$b + %1$5d< %n", i1, false);
		
		System.out.printf(">%s + %S< %n", i1 + 1, "test");
		
	}
}
