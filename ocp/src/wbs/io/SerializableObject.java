package wbs.io;

import java.io.Serializable;

public class SerializableObject extends Base implements Serializable {
	private static final long serialVersionUID = 1L;
	String feld1="EINS";
	String feld2;
	//String feld3="Test";
	

	public SerializableObject(String feld1) {
		super("blabla");
		System.out.println("konstruktor...");
		this.feld1 = feld1;
		// feld2 = "blabla";
	}

	@Override
	public String toString() {
		 //return feld1 + " " + feld3;
		 //return feld1 + " " + feld2 + " " + feld3;
		return feld1 + " " + feld2;
	}
}