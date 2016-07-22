package wbs.io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamDemo {
	public static void main(String[] args) {
		String path = "resources/io/stream/data_output.data";
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(
				path))) {
			dos.writeBoolean(true);
			dos.writeByte(1);
			dos.writeShort(2);
			dos.writeInt(3);
			dos.writeLong(4);
			dos.writeFloat(5.0f);
			dos.writeDouble(6.0);
			dos.writeUTF("sieben");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
