package wbs.generics;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapUtilDemo {

	public static void main(String[] args) {

		/*
		 * Wir bestücken eine Map Schlüssel sind Strings, die zugehörigen Werte
		 * die Längen der Strings.
		 * 
		 * Dann invertieren wir die Map (die alten Werte werde zu Schlüsseln der
		 * invertierten Map, die alten Schlüssel werden zu Werten der
		 * invertierten Map.
		 */

		String[] mystrings = { "Boolean", "Byte", "Character",
				"Character.Subset", "Character.UnicodeBlock", "Class",
				"ClassLoader", "ClassValue", "Compiler", "Double", "Enum",
				"Float", "InheritableThreadLocal", "Integer", "Long", "Math",
				"Number", "Object", "Package", "Process", "ProcessBuilder",
				"ProcessBuilder.Redirect", "Runtime", "RuntimePermission",
				"SecurityManager", "Short", "StackTraceElement", "StrictMath",
				"String", "StringBuffer", "StringBuilder", "System", "Thread",
				"ThreadGroup", "ThreadLocal", "Throwable", "Void"};
		Map<String, Integer> map = new HashMap<>();
		Map<Integer, Collection<String>> mapInverted;
		for (String s : mystrings) {
			map.put(s, s.length());

		}

		System.out.println(map);
		mapInverted = MapUtil.invertMap(map);
		for (Map.Entry<Integer, Collection<String>> entry : mapInverted
				.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

	}

}
