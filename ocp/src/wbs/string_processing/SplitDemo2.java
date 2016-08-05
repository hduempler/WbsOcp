package wbs.string_processing;

import java.util.Arrays;

public class SplitDemo2 {
	public static void main(String[] args) {
		String s1 = "a0b00c000d";
		String[] sa1 = s1.split("0");
		String[] sa2 = s1.split("0+");
		String[] sa3 = s1.split("0*");
		System.out.println(sa1.length + " -> " + Arrays.toString(sa1));
		System.out.println(sa2.length + " -> " + Arrays.toString(sa2));
		System.out.println(sa3.length + " -> " + Arrays.toString(sa3));
	}
}