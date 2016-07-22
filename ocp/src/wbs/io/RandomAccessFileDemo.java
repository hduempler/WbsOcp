package wbs.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) {
		String path = "resources/io/randomNumbers.rnd";
		File file = new File(path);
		System.out.println(file.length());
		try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
			for (int i = 0; i < 100; i++) {
				raf.writeInt(i);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
			for (int pos = 396; pos >= 380; pos -= 4) {
				raf.seek(pos);
				System.out.println(raf.readInt());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}