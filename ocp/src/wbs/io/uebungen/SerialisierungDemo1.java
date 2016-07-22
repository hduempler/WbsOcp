package wbs.io.uebungen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Ser1  {
	/**
*
*/
//	private static final long serialVersionUID = 1L;
	String s1;
	transient String s2;

	public Ser1() {
		System.out.println("aha!");
	}

	@Override
	public String toString() {
		return "Ser1 [s1=" + s1 + ", s2=" + s2 + "]";
	}
}

public class SerialisierungDemo1 {
	public static void main(String[] args) throws IOException {
		String path = "resources/io/stream/ser1.ser";
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(path))) {
			Ser1 ser1 = new Ser1();
			ser1.s1 = "s1";
			ser1.s2 = "s2";
			oos.writeObject(ser1);
		}
		System.out.println("--------------");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				path))) {
			System.out.println(ois.readObject());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}