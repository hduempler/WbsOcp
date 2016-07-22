package wbs.exceptions_assertions;

public class MyAutoCloseableDemo {
	public static void main(String[] args) {
		// Voraussetzung für try-with-resources:
		// Implementierung von AutoCloseable (neu in 1.7)
		try (MyAutoCloseable_1 myAutoCloseable_1 = new MyAutoCloseable_1();
				MyAutoCloseable_2 myAutoCloseable_2 = new MyAutoCloseable_2()) {
			// myAutoCloseable_1 und myAutoCloseable_2 sind implizit final
			// myAutoCloseable_1=new MyAutoCloseable_1(); // Compilerfehler
			myAutoCloseable_1.m();
			System.out.println("In try");
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		} finally {
			System.out.println("in finally");
		}
	}
}