package wbs.exceptions_assertions;

class MyAutoCloseable_2 implements AutoCloseable {
	private AutoCloseable autoCloseable;

	public MyAutoCloseable_2() {
	}

	public MyAutoCloseable_2(AutoCloseable autoCloseable) {
		this.autoCloseable = autoCloseable;
	}

	@Override
	public void close() throws Exception {
		if (autoCloseable != null) {
			autoCloseable.close();
		}
		System.out.println("closing myAutoCloseable_2");
	}

	public AutoCloseable getAutoCloseable() {
		return autoCloseable;
	}

	public void m() throws Exception {
		throw new Exception("exception from myAutoCloesable_2");
	}
}
