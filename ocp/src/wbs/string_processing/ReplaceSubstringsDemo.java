package wbs.string_processing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceSubstringsDemo {
	public static void main(String[] args) {
		String s = "an in 12 der 345 xyz 5555";
		String regex = "\\d+";
		String replaceWith = "o happy day";
		StringBuffer result = new StringBuffer();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			matcher.appendReplacement(result, replaceWith);
		}
		matcher.appendTail(result);
		System.out.println(result);
	}
}