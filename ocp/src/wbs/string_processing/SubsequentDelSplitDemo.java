package wbs.string_processing;

import java.util.Arrays;

public class SubsequentDelSplitDemo {
	public static void main(String[] args) {
		String s = "AxxBxxxCxxxxD";
		String[] sa = s.split("x");
		System.out.println(sa.length + " -> " + Arrays.toString(sa));
		// 10 -> [A, , B, , , C, , , , D]
	}
}