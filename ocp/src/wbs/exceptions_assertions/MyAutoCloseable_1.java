package wbs.exceptions_assertions;

class MyAutoCloseable_1 implements AutoCloseable {
	private AutoCloseable autoCloseable;

	public MyAutoCloseable_1() {
	}

	public MyAutoCloseable_1(AutoCloseable autoCloseable) {
		this.autoCloseable = autoCloseable;
	}

	@Override
	public void close() throws Exception {
		if (autoCloseable != null) {
			autoCloseable.close();
		}
		System.out.println("closing myAutoCloseable_1");
	}

	public AutoCloseable getAutoCloseable() {
		return autoCloseable;
	}

	public void m() throws Exception {
		throw new Exception("exception from myAutoCloseable_1");
	}
}