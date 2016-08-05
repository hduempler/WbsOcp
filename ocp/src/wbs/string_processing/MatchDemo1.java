package wbs.string_processing;

public class MatchDemo1 {
	public static void main(String[] args) {
		String sNoD = "abc";
		String sOneD = "abc1def";
		String sOneOrMoreD = "ab1cd2";
		String sOnlyD = "432123";
		
		String pNoD = "[^0-9]*"; // enthält nur Zeichen, die keine Ziffern sind
		String pOneD = "\\D*\\d\\D*"; // enthält genau eine Ziffer
		String pOneOrMoreD = ".*[0-9].*"; // enthält mindestens eine Ziffer
		String pOnlyD = "\\d*"; // enthält nur Ziffern
		
		System.out.println(sNoD.matches(pNoD)); // true
		System.out.println(sOneD.matches(pNoD)); // false
		System.out.println(sOneOrMoreD.matches(pNoD)); // false
		System.out.println(sOnlyD.matches(pNoD)); // false
		System.out.println("---");
		System.out.println(sNoD.matches(pOneD)); // false
		System.out.println(sOneD.matches(pOneD)); // true
		System.out.println(sOneOrMoreD.matches(pOneD)); // false
		System.out.println(sOnlyD.matches(pOneD)); // false
		System.out.println("---");
		System.out.println(sNoD.matches(pOneOrMoreD)); // false
		System.out.println(sOneD.matches(pOneOrMoreD)); // true
		System.out.println(sOneOrMoreD.matches(pOneOrMoreD)); // true
		System.out.println(sOnlyD.matches(pOneOrMoreD)); // true
		System.out.println("---");
		System.out.println(sNoD.matches(pOnlyD)); // false
		System.out.println(sOneD.matches(pOnlyD)); // false
		System.out.println(sOneOrMoreD.matches(pOnlyD)); // false
		System.out.println(sOnlyD.matches(pOnlyD)); // true
		System.out.println("---------------------------------");
		System.out.println("abc1def".matches("\\w\\d\\w"));
		System.out.println("abc1def".replaceAll("([^0-9])*","$1"));
		
	}
}