package co.kevingomez.serializationsdemo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjMapperDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		SerializeMe s = new SerializeMe();
		s.expiry = 1;
		s.recordId = java.util.UUID.randomUUID().toString();
		File f = new File("src/main/resources/SerializeMe.ser");
		f.createNewFile();
		FileOutputStream output = new FileOutputStream("src/main/resources/SerializeMe.ser");
		ObjectOutputStream objOut = new ObjectOutputStream(output);
		objOut.writeObject(s);
		objOut.close();
		FileInputStream fileInput = new FileInputStream("src/main/resources/SerializeMe.ser");
		ObjectInputStream objInpStream = null;
		try {
			objInpStream = new ObjectInputStream(fileInput);
			SerializeMe m = (SerializeMe) objInpStream.readObject();
			System.out.println("desierazled: " + m.expiry);
		} finally {
			objInpStream.close();
		}
		ByteArrayOutputStream baos = null;
		ObjectOutputStream objOutput = null;
		// to a byte array
		try {
			baos = new ByteArrayOutputStream();
			objOutput = new ObjectOutputStream(baos);
			objOutput.writeObject(s);
			objOutput.flush();
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		byte[] yourBytes = baos.toByteArray();

	}
}

class SerializeMe implements java.io.Serializable {
	private static final long serialVersionUID = 1072658975491190063L;
	public String recordId;
	public int expiry;
}
