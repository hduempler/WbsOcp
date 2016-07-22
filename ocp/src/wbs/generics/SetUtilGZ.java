package wbs.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * wie viele teilnehmer von fortbildungsmassnahmen bei WBS sind vor 1970 geboren?
 * 
 * wie viele einwohner von bonn sind volljährig?
 * 
 * wie viele bundesligamannschaften haben eine positive tordifferenz?
 * 
 * 
 * behauptung: es genügt eine einzige methode, um die logik, die diesen aufgaben
 * zugrundeliegt, umzusetzen.
 * 
 * methodenname: countByProperty()
 */

// ----------------------------------------------

/*
 * aus allen im bundestag vetretenen fraktionen wählen wir genau einen abgeordneten.
 * 
 * aus jedem wahlkreis eines bundeslandes wählen wir genau einen wahlberechtigten.
 * 
 * aus allen klassen einer schule wählen wir genau einen schüler.
 * 
 * behauptung: es genügt eine einzige methode, um die logik, die diesen aufgaben
 * zugrundeliegt, umzusetzen.
 * 
 * methodenname: repraesentanten()
 */

// --------------------------------------------

/*
 *  stellenvermittlung: ein stellensuchender passt zu einem stellenangebot, wenn er die
 *  geforderte berufserfahrung hat und mindestens 2 kernanforderungen erfüllt.
 *  wir generieren zu jedem stellensuchenden alle zu ihm passenden angebote.
 *  
 *  partnervermittlung: zwei partnersuchende passen zusammen, wenn sie zueinander passende
 *  geschlechtliche präferenzen haben und mindestens zwei gemeinsame hobbies haben und der
 *  altersunterschied nicht mehr als 25 jahre ist.
 *  wir generieren zu jedem partnersuchenden alle zu ihm / ihr passenden partnersuchenden.
 *  
 *  immobilienmakler: eine immobilie passt zu einem kaufinteressenten, wenn der preis nicht
 *  höher ist, als der höchste preis, den der interessent akzeptiert, und die wohnfläche eine mindestgrösse
 *  nicht unterschreitet.
 *  wir generieren zu jedem kaufinteressenten alle zu ihm passenden immobilien.
 *  
 *  behauptung: es genügt eine einzige methode, um die logik, die diesen aufgaben
 * 	zugrundeliegt, umzusetzen.
 * 
 * methodenname: matchingCandidates()
 * 
 */
public class SetUtilGZ {

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
		for (O o : set) {
			property = mapper.map(o);
			if (!map.containsKey(property)) {
				map.put(property, o);
			}
		}
		return map;
	}

	// entscheidung: auch objekte, für die keine matches gefunden werden, kommen
	// in die ergebnis-map
	// (mit einem leeren set als value)
	public static <T1, T2> Map<T1, Set<T2>> matchingCandidates(Set<T1> set1,
			Set<T2> set2, Matcher<T1, T2> matcher) {
		Map<T1, Set<T2>> result = new HashMap<>();
		Set<T2> candidates;
		for (T1 t1 : set1) {
			candidates = new HashSet<>();
			result.put(t1, candidates);
			for (T2 t2 : set2) {
				if (matcher.isMatching(t1, t2)) {
					candidates.add(t2);
				}
			}
		}
		return result;
	}

	// wir schreiben die methode createSetOfDupels().
	// die methode verallgemeinert das verfahren aus DupelDemo.
	// optional: wir liefern die möglichkeit, beim iterieren über alle dupel die
	// dupel aufsteigend sortiert zu liefern
	public static <T1, T2> Set<Dupel<T1, T2>> createSetOfDupels(Set<T1> set1,
			Set<T2> set2, Matcher<T1, T2> matcher, Comparator<Dupel<T1, T2>> cmp) {
		Set<Dupel<T1, T2>> result = (cmp == null ? new HashSet<Dupel<T1, T2>>()
				: new TreeSet<Dupel<T1, T2>>(cmp));
		for (T1 t1 : set1) {
			for (T2 t2 : set2) {
				if (matcher.isMatching(t1, t2)) {
					result.add(new Dupel<>(t1, t2));
				}
			}
		}
		return result;
	}

	/*
	 * 1. wie teilen alle einwohner einer gemeinde in gruppen von personen
	 * desselben geburtsjahres auf 2. alle pkws aus dem fuhrpark eines
	 * unternehmens werden gruppen zugewiesen, in denen der hersteller derselbe
	 * ist 3. alle teilnehmer von wbs werden in gruppen aufgeteilt nach
	 * zugehörigkeit zu einem standort
	 * 
	 * methodenname: createPartition()
	 */
	public static <O, P> Map<P, Set<O>> createPartition(Set<O> set,
			Mapper<O, P> mapper) {
		Map<P, Set<O>> result = new HashMap<>();
		P property;
		Set<O> subSet;
		for (O o : set) {
			property = mapper.map(o);
			subSet = result.get(property);
			if (subSet == null) {
				subSet = new HashSet<>();
				result.put(property, subSet);
			}
			subSet.add(o);
		}
		return result;
	}
	
	/*
	 * ein partnervermittler generiert für jeden partnersuchenden die 5 am besten zu ihm
	 * passenden kandidaten (sortiert).
	 * ein makler generiert für jeden kaufinteressenten die 8 am besten zu ihm passenden
	 * immobilien (sortiert).
	 * 
	 * methodenname: sortedProposals()
	 */

	public static <T1, T2> Map<T1, List<T2>> sortedProposals(
			Set<T1> set1, Set<T2> set2, DistanceComparatorGZ<T1, T2> cmp) {
		Map<T1, List<T2>> result = new HashMap<>();
		List<T2> list;
		for(T1 t1 : set1) {
			list = new ArrayList<>();
			list.addAll(set2);
			cmp.setT1(t1);
			Collections.sort(list, cmp);
			result.put(t1, list.subList(0, cmp.getLimit()));
		}
		return result;
	}
}
