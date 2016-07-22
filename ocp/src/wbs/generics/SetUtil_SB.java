package wbs.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * wie viele teilnehmer von fortbildungsmassnahmen bei WBS sind vor 1970 geboren?
 * 
 * wie viele einwohner von bonn sind volljährig?
 * 
 * wie viele bundesligamannschaften haben eine positive tordifferenz?
 *
 * behauptung: es genügt einen einzige methode, um de logik, die diesen aufgaben
 * zurundeliegt, umzusetzen
 * 
 * methodenname: countByProperty(Set<T> , interface true/false) liefert ganzahligen wert
 * 
 * generisches interface erforderlich (true/false)
 */

// --------------------------------

/*
 * aus allen im bundestag vertretenen fraktionen wählen wir genau einen abgeordneten
 * 
 * aus jedem wahlkreis eines bundeslandes wählen wir genau einen wahlberechtigten
 * 
 * aus allen klassen einer schule wählen wir genau einen schüler
 *
 * behauptung: es genügt einen einzige methode, um de logik, die diesen aufgaben
 * zurundeliegt, umzusetzen
 * 
 * methodenname: repraesentanten (Set<T> , interface true/false) liefert ganzahligen wert
 *	
 */

//--------------------------------

/*
 * stellenvermittlung: ein stellensuchender passt zu einem stellenangebot,
 * wenn er die geforderte berufserfahrung hat und mindestens 2 kernanforderungen erfüllt.
 * wir generieren zu jedem stellensuchenden alle zu ihm passenden angebote
 * 
 * partnervermittlung: zwei partnersuchende passen zusammen,
 * wenn sie zueinander passende geschlechtliche präferenzen haben und 
 * mindestens zwei gemeinsame hobbies haben und der altersunterschied nicht mehr als 25 jahre ist
 * wir generieren zu jedem partnersuchenden alle zu ihm / ihr passenden partnersuchenden
 * 
 * immobilienmakler: eine immobilie passt zu einem kaufinteressenten, wenn der preis nicht höher ist 
 * asl der höchste preis, den der kaufinteressent akzeptiert, und die wohnfläche eine mindestgröße 
 * nicht unterschreitet.
 * wir generieren zu jedem kaufinteressenten alle zu ihm passenden immobilien
 *   
 * behauptung: es genügt einen einzige methode, um de logik, die diesen aufgaben
 * zurundeliegt, umzusetzen
 * 
 * methodenname: matchingCandidates(Set<T> , Setinterface true/false) liefert ganzahligen wert
 *
 */

public class SetUtil_SB {
	
	//<T> typ-parameter sektion: ungebundener typ-parameter steht vor dem return-typ bei methoden
	
	public static <T> int countByProperty(Set<T> set, Filter<T> filter) {
		int result = 0;
		for (T t : set) {
			if(filter.accept(t)) {
				result++;
			}
		}
		return result;
	}
	
	public static <P, O> Map<P, O> repraesentanten(Set<O> set, Mapper<O, P> mapper) {
		Map<P, O> map = new HashMap<>();
		P property;
		for (O o : set) {
			property = mapper.map(o);
			if(! map.containsKey(property)) {
				map.put(property, o);
			}
		}
		return map;
	}

	// entscheidung: auch objekte, für die keine matches gefunden werden, kommen
	// in die ergebnis-map
	// (mit einem leeren set als value)
	public static <T1, T2> Map<T1, Set<T2>> matchingCandidates(Set<T1> set1, Set<T2> set2, Matcher<T1, T2> matcher) {
		Map<T1, Set<T2>> result = new HashMap<>();
		Set<T2> candidates;
		for (T1 t1 : set1) {
			candidates = new HashSet<>();
			result.put(t1, candidates);
			for (T2 t2 : set2) {
				if(matcher.isMatching(t1, t2)) {
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
	public static <T1, T2> Set<Dupel<T1, T2>> createSetOfDupels(Set<T1> set1, Set<T2> set2, 
					Matcher<T1, T2> matcher, Comparator<Dupel<T1, T2>> cmp) {
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
	 * 1. alle einwohner einer gemeinde werden in gleichaltrige gruppen eingeteilt, 
	 *    von personen desselben geburtsjahres
	 * 
	 * 2. alle pkws aus dem fuhrpark eines unternehmens werden gruppen zugewiesen, 
	 *    in denen der hersteller derselbe ist
	 *   
	 * 3. alle teilnehmer von WBS werden in gruppen aufgeteilt nach zugehörigkeit zu einem standort   
	 *
	 * methodenname: createPartition(Set<T> , interface true/false) 
	 *  
	 */
	//public static <P, O> Map<P, Set<O>> createPartition(Set<O> set, Mapper<O, P> mapper) {
	public static <P, O> Map<P, Collection<O>> createPartition(Collection<O> set, Mapper<O, P> mapper) {
		Map<P, Collection<O>> map = new HashMap<>();
		//Map<P, Set<O>> map = new HashMap<>();
		P property;
		// Set<O> subSet; // anstatt Collection<O>
		for (O o : set) {
			property = mapper.map(o);
			/*
			subSet = map.get(property);
			if(subSet == null) {
				subSet = new HashSet<O>();
				map.put(property, subSet);
			}
			*/
			if(! map.containsKey(property)) {
				map.put(property, new ArrayList<O>());
			}
			map.get(property).add(o);
			//aubSet(o); 
		}
		return map;
	}	
	

	/*
	 * ein partnervermittler generiert für jeden partnersuchenden die 5 am besten zu ihm passenden kandidaten
	 * ein makler generiert für jeden kaufinteressenten die 8 am besten zu ihm passenden kandidaten
	 * 
	 * methodenname: sortedProposals()
	 * 
	 */
	public static <T1, T2> Map<T1, List<T2>> sortedProposals(Set<T1> set1, Set<T2> set2, int maxProposals, ScoredMatcher<T1, T2> scoredMatcher) {
			Map<T1, List<T2>> result = new HashMap<>();
			List<T2> candidates; //  
			for (T1 t1 : set1) { 
				candidates = new ArrayList<>();
				result.put(t1, candidates);
				Map<Integer, List<T2>> keyMap = new TreeMap<>(); 
				int score = 0;
				List<T2> valueList;
				for (T2 t2 : set2) {
					score = scoredMatcher.getMatching(t1, t2);
					// per definition: score >= 0
					if(score >= 0) {
						if(keyMap.containsKey(score) ) {  
							valueList = keyMap.get(score);
						} else {
							valueList = new ArrayList<>();
							keyMap.put(score, valueList);
						}
						valueList.add(t2);
					}
				}
				List<T2> proposals = new ArrayList<>();
				for (Map.Entry<Integer, List<T2>> entry : keyMap.entrySet()) {
					proposals.addAll(entry.getValue());
				}
				if(proposals.size() > maxProposals) {
					proposals = proposals.subList(0,  maxProposals);
				}
				result.put(t1, proposals); 
			}
			return result;
		}
}
