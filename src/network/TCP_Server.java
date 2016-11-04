package network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import server.MemberData;

public class TCP_Server extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> dtoInput ;

		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버준비 완료");

			while(true)
			{
				dtoInput = new ArrayList();
				Socket client = server.accept();
				System.out.println(client.getInetAddress()+" 접속");

				ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
				DataInputStream dis = new DataInputStream(ois);

				try {
					sleep(50);
					while(dis.available()>0)
						dtoInput.add(dis.readUTF());
					if(dtoInput.size() != 0)
						new MemberData(dtoInput);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				dis.close();
				ois.close();
				client.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}