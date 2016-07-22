package wbs.exceptions_assertions;

import java.io.IOException;

class MyAutocloseable implements AutoCloseable {
	private String name;

	public MyAutocloseable(String name, boolean throwExc) throws Exception {
		this.name = name;
		System.out.println("constructor..." + name);
		if (throwExc) {
			throw new Exception("exception from constructor in " + name);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public void close() throws Exception {
		System.out.println("closing " + name);
		throw new IOException("exception from close() in " + name);
	}
}

public class SuppressedExceptionDemo {
	public static void main(String[] args) {
		try (MyAutocloseable auto1 = new MyAutocloseable("a1", false);
				MyAutocloseable auto2 = new MyAutocloseable("a2", false);) {
			System.out.println("after opening...");
			throw new IllegalArgumentException("illegal arguments...");
		} catch (Exception e) {
			System.out.println("exception: " + e);
			System.out.println("suppressed exceptions:");
			for (Throwable throwable : e.getSuppressed()) {
				System.out.println(throwable);
			}
		}
	}
}