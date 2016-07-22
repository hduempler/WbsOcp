package wbs.io;

import java.io.Serializable;

public class Base implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String fbase;

	public Base(String fbase) {
		super();
		this.fbase = fbase;
	}
}