package wbs.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Wie viele Teilnehmer von Fortbildungsmaßnahmen bei WBS sind vor 1970 geboren?
 * 
 * Wie viele Einwohner von Bonn sind volljährig?
 * 
 * Wie viele Bundesligamannschaften haben eine positive Tordifferenz?
 * 
 * Behauptung: Es genügt eine einzige Methode, um die Logik,
 * die diesen Aufgaben zugrundeliegt, umzusetzen.
 * 
 * Methodenname: countByProperty() Returntype ist Int
 * Zwei Parameter Object und ein Interface, das True oder False liefert
 * (man verwendet ein Interface)
 * 
 */

// -----------------------------------------------------------

/*
 * Aus allen im Bundestag vertretenen Fraktionen wählen wir genau einen Abgeordneten.
 * 
 * Aus jedem Wahlkreis eines Bundeslandes wählen wir genau einen Wahlberechtigten.
 * 
 * Aus allen Klassen einer Schule wählen wir genau einen Schüler.
 * 
 * Behauptung: Es genügt eine einzige Methode, um die Logik,
 * die diesen Aufgaben zugrundeliegt, umzusetzen.
 * 
 * Methodenname: repraesentanten() 
 *   
 */

// ----------------------------------------------------------------

/*
 * Stellenvermittlung: Ein Stellensuchender passt zu einem Stellenangebot, wenn er die
 * geforderte Berufserfahrung hat und mindestens 2 Kernanforderungen erfüllt.
 * Wir generieren zu jedem Stellensuchenden alle zu ihm passenden Angebote.
 * 
 * Wir gründen eine Partnervermittlung: Zwei Partnersuchende passen zusammen, 
 * wenn sie zueinander passende geschlechtliche Präferenzen haben 
 * und mindestens zwei gemeinsame Hobbys haben 
 * und der Altersunterschied nicht mehr als 25 Jahre ist.
 * Wir generieren zu jedem PArtnersuchenden alle zu ihm/ihr passenden Partnersuchenden.
 * 
 * Immobilienmakler: Eine Immobilie passt zu einem Kaufinteressenten, 
 * wenn der Preis nicht höher ist als der höchste Preis, den der Interessent akzeptiert
 * und die Wohnfläche eine Mindestgröße nicht unterschreitet.
 * Wir generieren zu jedem Kaufinteressenten alle zu ihm passenden Immobilien.
 *
 * Behauptung: Es genügt eine einzige Methode, um die Logik,
 * die diesen Aufgaben zugrundeliegt, umzusetzen.#
 * 
 * Methodenname: matchingCandidates()
 *
 */

public class SetUtil {

	public static <T> int countByProperty(Set<T> set, Filter<T> filter) {
		int result = 0;
		for (T t : set) {
			if (filter.accept(t)) {
				result++;
			}
		}
		return result;
	}

	public static <P, O> Map<P, O> repraesentanten(Set<O> set,
			Mapper<O, P> mapper) {
		Map<P, O> map = new HashMap<>();
		P property;
		List<O> list = new ArrayList<>();
		list.addAll(set);
		Collections.shuffle(list);
		for (O o : list) {
			property = mapper.map(o);
			if (!map.containsKey(property)) {
				map.put(property, o);
			}
		}
		return map;
	}

	public static <T1, T2> Map<T1, Set<T2>> matchingCandidates(Set<T1> set1,
			Set<T2> set2, Matcher<T1, T2> matcher) {
		Map<T1, Set<T2>> map = new HashMap<>();
		Set<T2> candidates;
		for (T1 t1 : set1) {
			for (T2 t2 : set2) {
				if (matcher.isMatching(t1, t2)) {
					if (map.containsKey(t1)) {
						candidates = map.get(t1);
					} else {
						candidates = new HashSet<T2>();
						map.put(t1, candidates);
					}
					candidates.add(t2);
				}
			}
		}
		return map;
	}

	// Wir schreiben eine Methode createSetOfDupels()
	// Die Methode verallgemeinert das Verfahren aus DupelDemo
	// Optional: Wir liefern die Möglichkeit, beim Iterieren über alle Dupel,
	// die Dupel aufsteigend zu liefern

	public static <T1, T2> Set<Dupel<T1, T2>> createSetOfDupels(
			Collection<T1> c1, Collection<T2> c2, Matcher<T1, T2> matcher) {
		Set<Dupel<T1, T2>> dupelSet = new HashSet<>();
		for (T1 t1 : c1) {
			for (T2 t2 : c2) {
				if (matcher.isMatching(t1, t2)) {
					dupelSet.add(new Dupel<>(t1, t2));
				}
			}
		}

		return dupelSet;
	}

	public static <T1, T2> Set<Dupel<T1, T2>> createSetOfDupels(
			Collection<T1> c1, Collection<T2> c2, Matcher<T1, T2> matcher,
			Comparator<Dupel<T1, T2>> cmp) {
		Set<Dupel<T1, T2>> dupelSet = new TreeSet<>(cmp);
		for (T1 t1 : c1) {
			for (T2 t2 : c2) {
				if (matcher.isMatching(t1, t2)) {
					dupelSet.add(new Dupel<>(t1, t2));
				}
			}
		}

		return dupelSet;
	}

	/*
	 * 1. Wir teilen alle Einwohner einer Gemeinde in Gruppen von Personen
	 * desselben Geburtsjahres auf.
	 * 
	 * 2. Alle PKWs aus dem Fuhrpark eines Unternehmens werden Gruppen
	 * zugewiesen, in denen Der Hersteller derselbe ist
	 * 
	 * 3. Alle Teilnehmer von WBS werden in Gruppen aufgeteilt nach
	 * Zugehörigkeit zu einem Standort
	 * 
	 * Methodenname: createPartition()
	 */

	public static <P, O> Map<P, Set<O>> createPartition(Set<O> set,
			Mapper<O, P> mapper) {
		Map<P, Set<O>> map = new HashMap<>();
		P property;
		Set<O> subSet;
		for (O o : set) {
			property = mapper.map(o);
			if (map.containsKey(property)) {
				subSet = map.get(property);
			} else {
				subSet = new HashSet<>();
				map.put(property, subSet);
			}
			subSet.add(o);
		}
		return map;
	}

	/*
	 * Ein Partnervermittler generiert für jeden Partnersuchenden die 5 am
	 * besten zu ihm passenden Kandidaten (sortiert)
	 * 
	 * Ein Immobilienmakler generiert für jeden Kaufinteressenten die 8 am
	 * besten zu ihm passenden Immobilien.
	 * 
	 * Methodenname: sortedProposals()
	 * 
	 * 1. Phase: gemeinsame Diskussion von Lösungsideen 2. Phase:
	 * Paar-Programmierung 3. Phase: gemeinsames Code-Review
	 * 
	 * Tugenden: Mut, Respekt, Vertrauen, Offenheit, Kritikfähigkeit wichtiges
	 * Ziel: Wissenstransfer
	 */

	public static <T1, T2> Map<T1, List<T2>> sortedProposals(Set<T1> set1,
			Set<T2> set2, int maxProposals, ScoredMatcher<T1, T2> scoredMatcher) {
		Map<T1, List<T2>> map = new HashMap<>();
		for (T1 t1 : set1) {
			List<T2> proposals = new ArrayList<T2>();
			NavigableMap<Integer, Set<T2>> scoreMap = new TreeMap<>();
			for (T2 t2 : set2) {
				int score;
				Set<T2> t2Set = null;
				if ((score = scoredMatcher.getMatching(t1, t2)) >= 0) {
					if (scoreMap.containsKey(score)) {
						t2Set = scoreMap.get(score);
					} else {
						t2Set = new HashSet<T2>();
						scoreMap.put(score, t2Set);
					}
					t2Set.add(t2);
				}
			}
			for (Entry<Integer, Set<T2>> entry : scoreMap.entrySet()) {
				System.out
						.println(entry.getKey() + "------" + entry.getValue());
				proposals.addAll(entry.getValue());
			}
			if (proposals.size() > maxProposals) {
				proposals = proposals.subList(0, maxProposals);
			}
			map.put(t1, proposals);
		}

		return map;
	};

	public static <T1, T2> Map<T1, List<T2>> sortedProposals2(Set<T1> set1,
			Set<T2> set2, int maxProposals, ScoredMatcher<T1, T2> scoredMatcher) {
		Map<T1, List<T2>> map = new HashMap<>();
		Comparator<Dupel<Integer, T2>> cmp = new Comparator<Dupel<Integer, T2>>() {

			@Override
			public int compare(Dupel<Integer, T2> d1, Dupel<Integer, T2> d2) {
				return d1.getA().compareTo(d2.getA());
			}

		};
		for (T1 t1 : set1) {
			List<Dupel<Integer, T2>> scoreList = new ArrayList<>();
			for (T2 t2 : set2) {
				int score;
				if ((score = scoredMatcher.getMatching(t1, t2)) >= 0) {
					scoreList.add(new Dupel<>(score, t2));
				}
			}
			Collections.sort(scoreList, cmp);
			List<T2> proposals = new ArrayList<>();
			for (Dupel<Integer, T2> dup : scoreList) {
				proposals.add(dup.getB());
			}
			if (proposals.size() > maxProposals) {
				proposals = proposals.subList(0, maxProposals);
			}
			map.put(t1, proposals);
		}

		return map;
	};
}
