package wbs.string_processing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindSubstringsDemo {
	/*
	 * alle vorkommen einer durch einen regulären ausdruck gegebenen
	 * zeichenfolge in einem string finden
	 */
	public static void main(String[] args) {
		String s = "an in 12 der 345 xyz 5555";
		String regex = "\\d+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			System.out.printf("%s an position [%d,%d] gefunden%n",
					matcher.group(), matcher.start(), matcher.end());
		}
	}
}