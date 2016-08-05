package wbs.string_processing;

import java.util.Arrays;

public class SplitDemo1 {
	public static void main(String[] args) {
		String s1 = ",a,b,c,d";
		String s2 = "a,b,c,d,";
		String[] sa1 = s1.split(",");
		String[] sa2 = s2.split(",");
		System.out.println(sa1.length + " -> " + Arrays.toString(sa1));
		System.out.println(sa2.length + " -> " + Arrays.toString(sa2));
	}
}