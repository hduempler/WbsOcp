package wbs.string_processing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDemo3 {
	public static void main(String[] args) {
		String regex1 = "\\s\\S+\\s";
		String s1 = "   eins und eins ist zwei";
		Pattern p1 = Pattern.compile(regex1);
		Matcher m1 = p1.matcher(s1);
		while (m1.find()) {
			System.out.print(m1.start() + "<" + m1.group() + ">");
		}
		// 2< eins >11< eins >
	}
}