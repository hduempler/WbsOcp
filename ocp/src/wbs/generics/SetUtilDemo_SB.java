package wbs.generics;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class SetUtilDemo_SB {

	public static void main(String[] args) {

/*		
		int count;
		Set<Integer> set = new HashSet<>();
		for(int i =1; i <= 1000; i++) {
			set.add(i);
		}
*/
/*		

		// anonyme klasse: anzahl aller zahlen zwischen 1 und 1000 mit 4 einser-bits
		count = SetUtil.countByProperty(set, new Filter<Integer>() {
			@Override
			public boolean accepts(Integer i) {
				return Integer.bitCount(i) == 4;
			}
		});
		System.out.println(count);
		
		// anonyme klasse: anzahl aller zahlen zwischen 1 und 1000, die die ziffer 9 nicht enthalten
		count = SetUtil.countByProperty(set, new Filter<Integer>() {
			@Override
			public boolean accepts(Integer i) {
				return i.toString().indexOf('9') < 0;
			}
		});
		System.out.println(count);

		System.out.println("--------------------------");

		// anonyme klasse: zu jeder anzahl von einser-bits genau eine zahl 1...1000
		Map<Integer, Integer> map =  SetUtil.repraesentanten(set, new Mapper<Integer, Integer>() {
			@Override
			public Integer map(Integer i) {
				return Integer.bitCount(i);
			}	
		});

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue() + 
					"(" + Integer.toBinaryString(entry.getValue()) + ")");
		}
	

		System.out.println("--------------------------");

		// anonyme klasse: zu jedem int in 1...1000 alle ints in 1...1000 mit derselben quersumme
		Map<Integer, Set<Integer>> candidates =  SetUtil.matchingCandidates(set, set, new Matcher<Integer, Integer>() {
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
		
		for(Map.Entry<Integer, Set<Integer>> entry : candidates.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

		// paare von int, int in 1...1000 mit gleicher anzahl von einserbits
		System.out.println("-----------------------------");
		Set<Dupel<Integer, Integer>> dupelSet = SetUtil.createSetOfDupels(set,
				set, new Matcher<Integer, Integer>() {
						@Override
						public boolean isMatching(Integer i1, Integer i2) {
							return Integer.bitCount(i1) == Integer.bitCount(i2);
						}
					}, new Comparator<Dupel<Integer, Integer>>() {
						
						@Override
						public int compare(Dupel<Integer, Integer> d1, Dupel<Integer, Integer> d2) {
							int diff = d1.getA().compareTo(d2.getA());
							return diff != 0 ? diff : d1.getB().compareTo(d2.getB());
						}
					});
		
		for (Dupel<Integer, Integer> dupel : dupelSet) {
			if (dupel.getA() >= 100 && dupel.getA() <= 110) {
				System.out.println(dupel);
			}
		}
*/		

/*		
		List<Integer> list = new ArrayList<>();
		Random rand = new Random(System.currentTimeMillis());
		
		do {
			list.add(rand.nextInt(100) +1);
		} while (list.size() < 50);
		
		// group by numbers
		Map<Integer, Collection<Integer>> partition =  SetUtil.createPartition(list, new Mapper<Integer, Integer>() {
			@Override
			public Integer map(Integer n) {
				//return n % 10;
				return n / 10;
				//return Math.abs(n -25);
			}	
		});
		
		for(Map.Entry<Integer, Collection<Integer>> entry : partition.entrySet()) {
			//System.out.println(entry.getKey() + " -> " + entry.getValue());
			List<Integer> sortedList = (List<Integer>) entry.getValue();
			Collections.sort(sortedList);
			System.out.println(entry.getKey() + " -> " + sortedList);
		}

		
		List<String> strList = new ArrayList<>();
		strList.add("Stephan Bartsch");
		strList.add("Peter Müller");
		strList.add("Klaus Mayer");
		strList.add("Harald Lesch");
		strList.add("Franz Xaver");
		strList.add("Ernst Elitz");
		strList.add("Leonhard Otto");
		strList.add("Andreas Hartwig");
	
		// group by numbers
		Map<Integer, Collection<String>> strPartition =  SetUtil.createPartition(strList, new Mapper<String, Integer>() {
			@Override
			public Integer map(String s) {
				return s.toUpperCase().indexOf("E");
				//return s.indexOf("e");
			}	
		});
		
		for(Map.Entry<Integer, Collection<String>> strEntry : strPartition.entrySet()) {
			//System.out.println(strEntry.getKey() + " -> " + strEntry.getValue());
			List<String> sortedStrList = (List<String>) strEntry.getValue();
			Collections.sort(sortedStrList);
			System.out.println(strEntry.getKey() + " -> " + sortedStrList);
		}
*/
		
		System.out.println("--------------------------");

		Random random = new Random();
		
		Set<Integer> set = new HashSet<>();

		for(int i =1; i <= 40; i++) {
			set.add(random.nextInt(100) +1);
		}
		
		// anonyme klasse: zu jedem int in 1...1000 alle ints in 1...1000 mit geringstem abstand

		int maxProposals = 5;

		Map<Integer, List<Integer>> sortedLists = SetUtil.sortedProposals(set, set, maxProposals, new ScoredMatcher<Integer, Integer>() {
			@Override
			public int getMatching(Integer i1, Integer i2) {
				int result;
				if((i2 >= 5 & i2 <= 15) || (i2 >= 25 & i2 <= 15))
				{
					result = -1;
				} else {
					result = Math.abs(i1 - i2);
				}
				return result;
			}	
		});
		
		for(Map.Entry<Integer, List<Integer>> entry : sortedLists.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

	}

}
