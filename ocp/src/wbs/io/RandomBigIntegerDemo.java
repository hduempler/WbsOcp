package wbs.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.Random;

public class RandomBigIntegerDemo {
	/*
	 * die anwendung erzeugt BigInteger- objekte einer variablen groesse,
	 * zwischen 1 und 16 byte. jedes BigInteger- Objekt wird mit einem
	 * zufälligen wert initialisiert
	 * 
	 * die erzeugten objekte werden (als bytearray) in eine datei geschrieben,
	 * nebst ihrer groesse
	 * 
	 * die datei wird anschliessend eingelesen, die biginteger- objekte werden
	 * rekonstruiert und ausgegeben
	 * 
	 * dateiname: resources/biginteger.rnd
	 * 
	 * vorgehen: - lies die groesse des nächsten BigInteger (z.b. 4) - lies die
	 * entsprechende zahl von bytes ein (4) - erzeuge das bigintegerobjekt und
	 * gebe es aus
	 * 
	 * - usw
	 */
	public static void main(String[] args) {
		String path = "resources/io/biginteger.rnd";
		BigInteger bigInteger;
		int numBytes;
		int maxSize = 16;
		byte[] bytes = null;
		Random random = new Random();
		File file = new File(path);
		file.delete();
		System.out.println("---writing---");
		try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
			for (int i = 0; i < 10; i++) {
				numBytes = random.nextInt(maxSize) + 1;
				bigInteger = new BigInteger(numBytes * 8, random);
				raf.writeInt(bigInteger.toByteArray().length);
				raf.write(bigInteger.toByteArray());
				System.out.println(bigInteger.toByteArray().length + " -> "
						+ bigInteger);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("---reading---");
		try (RandomAccessFile raf = new RandomAccessFile(path, "r")) {
			long len = raf.length();
			int lenOfByteArray;
			while (raf.getFilePointer() < len) {
				lenOfByteArray = raf.readInt();
				bytes = new byte[lenOfByteArray];
				raf.read(bytes, 0, lenOfByteArray);
				System.out.println(lenOfByteArray + " -> "
						+ new BigInteger(bytes));
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}