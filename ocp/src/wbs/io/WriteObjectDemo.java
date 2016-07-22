package wbs.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class WriteObjectDemo {
	public static void main(String[] args) throws IOException {
		String path = "resources/io/stream/object.ser";
		try (ObjectOutput oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(path)))) {
			SerializableObject o = new SerializableObject("eins");
			oos.writeObject(o);
		}
	}
}