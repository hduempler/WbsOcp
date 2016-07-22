package wbs.io.uebungen;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Ser6 implements Serializable {
	/**
	*
	*/
	private static final long serialVersionUID = 1L;
	String s1;
	String s2;

	public Ser6() {
		System.out.println("aha!");
	}

	@Override
	public String toString() {
		return "Ser6 [s1=" + s1 + ", s2=" + s2 + "]";
	}
}

public class SerialisierungDemo6 {
	public static void main(String[] args) throws IOException {
		String path = "resources/io/stream/ser6.ser";
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(path))) {
			Ser6 ser6 = new Ser6();
			ser6.s1 = "s1";
			ser6.s2 = "s2";
			oos.writeObject(ser6);
			ser6.s2 = "na so was";
			oos.writeObject(ser6);
		}
		try (BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(path));
				ObjectInputStream ois = new ObjectInputStream(bis)) {
			while (bis.available() > 0) {
				System.out.println(ois.readObject());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
