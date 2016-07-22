package wbs.nested_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * jedes testzentrum hat einen namen, eine x- koordinate, eine y- koordinate
 */
class TestZentrum {
	String name;
	double x;
	double y;

	public TestZentrum(String name, double x, double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return name + "(" + x + "," + y + ")";
	}

}

/*
 * jeder testkandidat hat einen namen, eine x- koordinate, eine y- koordinate
 */
class TestKandidat {
	String name;
	double x;
	double y;

	public TestKandidat(String name, double x, double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return name + "(" + x + "," + y + ")";
	}

}

public class AbstandDemo {

	public static double abstand(TestZentrum zentrum, TestKandidat kandidat) {
		double dx = zentrum.x - kandidat.x;
		double dy = zentrum.y - kandidat.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public static List<TestZentrum> zentrenSortiertNachAbstand(
			final List<TestZentrum> zentren, final TestKandidat kandidat) {
		Comparator<TestZentrum> cmp = new Comparator<TestZentrum>() {
			@Override
			public int compare(TestZentrum z1, TestZentrum z2) {
				double abstand1 = abstand(z1, kandidat);
				double abstand2 = abstand(z2, kandidat);
				return (int) Math.signum(abstand1 - abstand2);
			}

		};
		Collections.sort(zentren, cmp);
		return zentren;
	}

	// wir erzeugen einige testzentren
	// wir erzeugen einige testkandidaten
	// für jeden testkandidaten listen wir alle prüfungszentren auf, und zwar
	// aufsteigend sortiert nach dem abstand
	public static void main(String[] args) {

		List<TestZentrum> zentren = new ArrayList<>();
		List<TestKandidat> kandidaten = new ArrayList<>();

		for (int i = 1; i <= 5; i++) {
			zentren.add(new TestZentrum("zentrum_" + i, (int) (1 + Math
					.random() * 10), (int) (1 + Math.random() * 10)));
		}

		for (int i = 1; i <= 5; i++) {
			kandidaten.add(new TestKandidat("kandidat_" + i, (int) (1 + Math
					.random() * 10), (int) (1 + Math.random() * 10)));
		}

		for (TestKandidat kandidat : kandidaten) {
			System.out.println(kandidat);
			for (TestZentrum zentrum : zentrenSortiertNachAbstand(zentren,
					kandidat)) {
				System.out.println("   " + zentrum + " -> "
						+ abstand(zentrum, kandidat));
			}
		}
	}
}
