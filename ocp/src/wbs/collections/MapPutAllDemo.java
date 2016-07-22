package wbs.collections;

import java.util.HashMap;
import java.util.Map;

public class MapPutAllDemo {

	public static void main(String[] args) {

		Map<CharSequence, CharSequence> map1 = new HashMap<>();

		Map<String, String> map2 = new HashMap<>();
		map2.put("one", "abc");
		map2.put("two", "def");
		map2.put("three", "ghi");
		map1.putAll(map2);

		Map<String, StringBuffer> map3 = new HashMap<>();

		map3.put("four", new StringBuffer("jkl"));
		map3.put("five", new StringBuffer());
		map1.putAll(map3);

		Map<StringBuffer, StringBuilder> map4 = new HashMap<>();

		map4.put(new StringBuffer("one"), new StringBuilder("mno"));
		map4.put(new StringBuffer("seven"), new StringBuilder("pqr"));
		map1.putAll(map4);

		System.out.println(map1);

	}

}
