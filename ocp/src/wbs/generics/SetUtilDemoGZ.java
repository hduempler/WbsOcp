package wbs.generics;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class SetUtilDemoGZ {

	public static void main(String[] args) {
		/*
		 * wir testen die methode countByProperty()
		 */
		int count;
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= 1000; i++) {
			set.add(i);
		}
		// anzahl aller zahlen zwischen 1 und 1000 mit 4 einser-bits
		count = SetUtilGZ.countByProperty(set, new Filter<Integer>() {
			@Override
			public boolean accept(Integer i) {
				return Integer.bitCount(i) == 4;
			}

		});
		System.out.println(count); // 210
		// anzahl aller zahlen zwischen 1 und 1000, die die ziffer 9 nicht
		// enthalten
		count = SetUtilGZ.countByProperty(set, new Filter<Integer>() {
			@Override
			public boolean accept(Integer i) {
				return i.toString().indexOf('9') < 0;
			}
		});
		System.out.println(count); // 729

		// zu jeder anzahl von einser-bits genau eine zahl aus 1...1000
		System.out.println("---------------");
		Map<Integer, Integer> map = SetUtilGZ.repraesentanten(set,
				new Mapper<Integer, Integer>() {
					@Override
					public Integer map(Integer i) {
						return Integer.bitCount(i);
					}
				});
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue() + "("
					+ Integer.toBinaryString(entry.getValue()) + ")");
		}

		// zu jedem int in 1...1000 alle ints in 1...1000 mit derselben
		// quersumme

		System.out.println("---------------");
		Map<Integer, Set<Integer>> candidates = SetUtilGZ.matchingCandidates(set,
				set, new Matcher<Integer, Integer>() {
					private int quersumme(int n) {
						int qs = 0;
						for (; n > 0; n /= 10) {
							qs += n % 10;
						}
						return qs;
					}

					@Override
					public boolean isMatching(Integer i1, Integer i2) {
						return quersumme(i1) == quersumme(i2);
					}
				});
		for (Map.Entry<Integer, Set<Integer>> entry : candidates.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

		// paare von (int, int) in 1...1000 mit gleicher anzahl von einserbits,
		// aufsteigend sortiert
		System.out.println("-----------------------------");
		Set<Dupel<Integer, Integer>> dupelSet = SetUtilGZ.createSetOfDupels(set,
				set, new Matcher<Integer, Integer>() {
					@Override
					public boolean isMatching(Integer i1, Integer i2) {
						return Integer.bitCount(i1) == Integer.bitCount(i2);
					}

				}, new Comparator<Dupel<Integer, Integer>>() {
					@Override
					public int compare(Dupel<Integer, Integer> d1,
							Dupel<Integer, Integer> d2) {
						int diff = d1.getA().compareTo(d2.getA());
						return diff != 0 ? diff : d1.getB()
								.compareTo(d2.getB());
					}
				});
		for (Dupel<Integer, Integer> dupel : dupelSet) {
			if (dupel.getA() >= 100 && dupel.getA() <= 110) {
				System.out.println(dupel);
			}
		}
		// zahlen in 1...1000 in teilmenegen zerlegen, deren elemente bei
		// division durch 10 denselben rest liefern
		System.out.println("-----------------------------");
		Map<Integer, Set<Integer>> partition = SetUtilGZ.createPartition(set,
				new Mapper<Integer, Integer>() {
					@Override
					public Integer map(Integer i) {
						return i % 10;
					}
				});
		for (Map.Entry<Integer, Set<Integer>> entry : partition.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

		Random rnd = new Random();
		Set<Integer> set2 = new HashSet<>();
		while (set2.size() < 10) {
			set2.add(rnd.nextInt(20) + 1);
		}
		// sorted proposals
		System.out.println("--------sortedProposals(5)---------");
		System.out.println("grundmenge: " + set2);
		System.out
				.println("-- eine zahl passt zu einer gegebenen zahl umso besser, je geringer ihr abstand ist --");
		Map<Integer, List<Integer>> proposals = SetUtilGZ.sortedProposals(set2,
				set2, new DistanceComparatorGZ<Integer, Integer>(5) {
					@Override
					public double distance(Integer i1, Integer i2) {
						return Math.abs(i1 - i2);
					}
				});
		for (Map.Entry<Integer, List<Integer>> entry : proposals.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
}
