package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCP_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket socket = new Socket("192.168.0.22",7777 );

			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			DataOutputStream dos = new DataOutputStream(oos);

			dos.writeUTF("11ewefwf1");
			dos.writeUTF("1ewweff2");
			dos.writeUTF("abaaa�׽�Ʈ�� 3");
			dos.writeUTF("1991-07-23");
			dos.writeUTF("abaaa�׽�Ʈ�� 5");
			dos.writeUTF("abaaa�׽�Ʈ�� 6");
			dos.writeUTF("abaaa�׽�Ʈ�� 7");
			dos.writeUTF("abaaa�׽�Ʈ�� 8");
			dos.writeUTF("1991-07-23");
			dos.writeUTF("12:10:10");
			dos.writeUTF("abaaa�׽�Ʈ�� 11");

			dos.close();
			oos.close();
			socket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
