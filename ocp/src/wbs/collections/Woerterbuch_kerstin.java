package wbs.collections;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * zu einem Wort der Quellsprache kann es beliebig viele Wörter der Zielsprache geben
 * 
 * ein Wörterbuch soll invertiert werden können
 * 
 * Wörterbücher sollen persistiert werden können (csv-Datei -comma separeted values)
 * als serialisiertes java-Objekt, als xml-Datei, datenbank) und aus externen datei rekonstruiert werden können
 * 
 * elementarere Operationen
 * 
 * putWord() 
 * 	eintragen eines Wortes 
 * putWords()
 * 	eintragen mehrerer Wörter
 * updateWord()
 * 	ersetzt ein Wort der Zielsprache durch ein anderes
 * removeWord()
 * 	löscht zu einem Wortt der Quellsprache ein Wort der Zielsprache
 * removeEntry()
 * 	löscht einen Eintrag der Quellsprache komplett
 * 
 * alle Methoden liefer boolean zurück um zu signalisieren ob das Wörterbuch geändert wurde oder nicht
 * 
 */
public class Woerterbuch_kerstin {
	private NavigableMap<String, NavigableSet<String>>dictionary;
	
	private String srcLanguage;
	private String dstLanguage;
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Woerterbuch_kerstin(String srcLanguage, String dstLanguage) {
		this.srcLanguage = srcLanguage;
		this.dstLanguage = dstLanguage;
		dictionary=new TreeMap();
	}
	
	
	public NavigableMap<String, NavigableSet<String>> getDictionary() {
		return dictionary;
	}


	public String getSrcLanguage() {
		return srcLanguage;
	}


	public String getDstLanguage() {
		return dstLanguage;
	}


	public void setDictionary(NavigableMap<String, NavigableSet<String>> dictionary) {
		this.dictionary = dictionary;
	}


	public void setSrcLanguage(String srcLanguage) {
		this.srcLanguage = srcLanguage;
	}


	public void setDstLanguage(String dstLanguage) {
		this.dstLanguage = dstLanguage;
	}


	public boolean putWord(String srcWord, String dstWord){
		NavigableSet<String> nSet=dictionary.get(srcWord);
		if (nSet==null){
			nSet= new TreeSet<>();
			dictionary.put(srcWord, nSet);
		}
		return nSet.add(dstWord);
	}
	public boolean putWords(String srcWord, String dstWord, String... dstWords){
		boolean result1=putWord(srcWord,dstWord);
		boolean result2 =dictionary.get(srcWord).addAll(Arrays.asList(dstWords));
		return result1||result2;
	}
	public boolean updateWord(String srcWord, String dstOldWord, String destNewWord){
		boolean result=false;
		NavigableSet<String> nSet=dictionary.get(srcWord);
		//es sind Einträge vorhanden
		if(nSet!=null){
			if(!(dstOldWord.equals(destNewWord))&&(nSet.remove(dstOldWord))){
				result=true;
				nSet.add(destNewWord);
			}
		}
		return result;
	}
	public boolean removeWord(String srcWord, String dstWord){
		boolean result=false;
		//Alle Einträge der Zielsprache holen
		NavigableSet<String> nSet=dictionary.get(srcWord);
		//es sind Einträge vorhanden
		if(nSet!=null){
			//entfernen des Eintrags war erfolgreich
			if(nSet.remove(srcWord)){
				//Änderung an der Quelle
				result=true;
				//Ist das Set jetzt leer, dann den gesamten Eintrag löschen 
				if(nSet.isEmpty()){
					result=removeEntry(srcWord);
				}
			}
		}
		
		
		return result;
	}
	public boolean removeEntry(String srcWord){
		
		return (dictionary.remove(srcWord)!=null);
	}
	public NavigableSet<String> getWords(String srcWord){
		return null;
	}
	public Woerterbuch invertDict(){
		return null;
	}
}
