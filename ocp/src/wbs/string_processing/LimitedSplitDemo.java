package wbs.string_processing;

import java.util.Arrays;

public class LimitedSplitDemo {
	public static void main(String[] args) {
		String s = "AxBxCxDxExFxGx";
		String[] sa = s.split("x", 3);
		System.out.println(sa.length + " -> " + Arrays.toString(sa));
		// 3 -> [A, B, CxDxExFxGx]
	}
}