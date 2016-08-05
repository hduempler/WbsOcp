package wbs.string_processing;

// das Package könnte abgefragt werden

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatchDemo2 {
	public static void main(String[] args) {
		String regex1 = "nana";
		String s1 = "banananabanananana";
		Pattern p1 = Pattern.compile(regex1);
		Matcher m1 = p1.matcher(s1);
		while (m1.find()) {
			System.out.print(m1.start() + " ");
		}
		// 2 10 14
		
		// an der Position 4 wird kein Treffer gemeldet (und an 12 auch nicht)
	}
}