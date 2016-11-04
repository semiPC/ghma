package admin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class Admin_Chat_Server extends JFrame{

	
	ArrayList<DataOutputStream> list = new ArrayList();
	
	public Admin_Chat_Server() {
		// TODO Auto-generated constructor stub
		Collections.synchronizedList(list);
		
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버시작");
			
			while(true)
			{
				Socket client = server.accept();
				
				new TCPMulServerReceiver(client).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class TCPMulServerReceiver extends Thread
	{
		String name;
		DataOutputStream dos;
		DataInputStream dis;
		public TCPMulServerReceiver(Socket client) {
			// TODO Auto-generated constructor stub
			try {
				name = "["+client.getInetAddress()+"]";
				dos = new DataOutputStream(client.getOutputStream());
				dis = new DataInputStream(client.getInputStream());
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				sendToAll(name+" 입장");
				sendToAll("접속자 수:"+list.size());
				list.add(dos);
				
				while(dis!=null)
				{	
					sendToAll(dis.readUTF());	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}finally{
				list.remove(dos);
				sendToAll(name+" 퇴장");
				sendToAll("접속자 수:"+list.size());
			}
		}
	}
	
	void sendToAll(String msg)
	{
		System.out.println(msg);
		for (DataOutputStream dd : list) {
			try {
				dd.writeUTF(msg);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
	//	new FF();
		
		
	}
}
