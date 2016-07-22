package wbs.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObjectDemo {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		String path = "resources/io/stream/object.ser";
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(path)))) {
			// cast ggf mit instanceof absichern
			Object o = ois.readObject();
			if (o instanceof SerializableObject) {
				SerializableObject so = (SerializableObject) o;
				System.out.println(o);
				System.out.println(so.feld1);
			}
		}
	}

}
