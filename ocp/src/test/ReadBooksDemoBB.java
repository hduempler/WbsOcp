package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadBooksDemoBB {

	public static void main(String[] args) throws IOException {
		//<span class="title bestseller-popup-link">Ein ganz neues Leben</span>
		String filename="resources/books.txt";
		//try ()
		String content = new String(Files.readAllBytes(Paths.get(filename)));
		
		String regex1 = "<span class=\"bestseller-popup-preis\">([^<]+)<";
		Pattern p1 = Pattern.compile(regex1);
		Matcher m1 = p1.matcher(content);
		while (m1.find()) {
			System.out.println(m1.group(1));
		}

	}

}
