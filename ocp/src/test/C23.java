package test;

import java.util.Scanner;

public class C23 {
	public static void main(String[] args) throws Exception {
		try(Scanner scanner = new Scanner("c20c21c22c23c24")) {
			int n=0;
			scanner.useDelimiter("c");
			while(scanner.hasNext()){
				n+=scanner.nextInt();
			}
			System.out.println(n);
		}
	}

}