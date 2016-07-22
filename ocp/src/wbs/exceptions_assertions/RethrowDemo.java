package wbs.exceptions_assertions;

public class RethrowDemo {
	@SuppressWarnings("serial")
	static class E1 extends Exception {
	}

	@SuppressWarnings("serial")
	static class E2 extends Exception {
	}

	public void rethrow() throws E1, E2 {
		try {
			if (Math.random() > 0.5) {
				throw new E1();
			} else {
				throw new E2();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public static void main(String[] args) throws E1, E2{
		RethrowDemo rethrowDemo= new RethrowDemo();
		try {
			rethrowDemo.rethrow();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
