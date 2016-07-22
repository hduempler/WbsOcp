package wbs.io.uebungen;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Ser71 {
}

class Ser72 extends Ser71 implements Serializable {
	private static final long serialVersionUID = 1L;
}

class Ser7 implements Serializable {
	/**
*
*/
	private static final long serialVersionUID = 1L;
	Ser71 ser711 = Math.random() > 0.5 ? new Ser71() : new Ser72();
	Ser71 ser712 = null;
}

public class SerialisierungDemo7 {
	public static void main(String[] args) throws IOException {
		String path = "resources/io/stream/ser7.ser";
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(path))) {
			Ser7 ser7 = new Ser7();
			oos.writeObject(ser7);
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