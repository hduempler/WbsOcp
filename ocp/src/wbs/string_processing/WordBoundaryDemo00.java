package wbs.string_processing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBoundaryDemo00 {
	public static void main(String[] args) {
		String regex = "\\b";
		String s1 = "eins";
		String s2 = "^eins";
		String s3 = "eins$";
		String s4 = "^eins$";
		Pattern p = Pattern.compile(regex);
		Matcher m1 = p.matcher(s1);
		Matcher m2 = p.matcher(s2);
		Matcher m3 = p.matcher(s3);
		Matcher m4 = p.matcher(s4);
		while (m1.find()) {
			System.out.print(m1.start() + " ");
		}
		// 0 4
		System.out.println();
		while (m2.find()) {
			System.out.print(m2.start() + " ");
		}
		// 1 5
		System.out.println();
		while (m3.find()) {
			System.out.print(m3.start() + " ");
		}
		// 0 4
		System.out.println();
		while (m4.find()) {
			System.out.print(m4.start() + " ");
		}
		// 1 5
	}
}