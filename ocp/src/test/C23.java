package test;

import java.io.IOException;

public class C23 implements java.lang.AutoCloseable {
	void m() throws Exception {
		try (C23 c23 = new C23()) {
		}
	}

	@Override
	public void close() throws Exception {
	}
}