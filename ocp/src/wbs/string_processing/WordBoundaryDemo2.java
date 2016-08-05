package wbs.string_processing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBoundaryDemo2 {
	public static void main(String[] args) {
		String regex1 = "\\B";
		String s1 = "a1 bbb2 _d3_";
		Pattern p1 = Pattern.compile(regex1);
		Matcher m1 = p1.matcher(s1);
		while (m1.find()) {
			System.out.print(m1.start() + " ");
		}
		// 1 4 5 6 9 10 11
	}
}