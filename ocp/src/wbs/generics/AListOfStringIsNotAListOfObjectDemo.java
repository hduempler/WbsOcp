package wbs.generics;

import java.util.ArrayList;
import java.util.List;

public class AListOfStringIsNotAListOfObjectDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Object> oList = new ArrayList<>();
		List<String> sList = new ArrayList<>();
		
		// oList = sList; // Compilerfehler

	}
}
