package Prac6;

// Java implementation for a client 
// Save file as Client.java 

import java.io.*; 
import java.net.*; 
import java.util.Scanner; 

public class Client 
{ 
	public static void main(String[] args) throws IOException 
	{ 
		try
		{       Scanner sc = new Scanner(System.in); 
			InetAddress ip = InetAddress.getByName("localhost"); 
	                Socket s = new Socket(ip, 5056); 
	                DataInputStream dis = new DataInputStream(s.getInputStream()); 
			DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
	                System.out.println(dis.readUTF()+"Received..."); 
                        System.out.println("Enter (COMMIT | ABORT)");
                        String tosend = sc.nextLine(); 
                        dos.writeUTF(tosend); 
                        System.out.println(dis.readUTF()+"Received...");
                        System.out.println("Sending the Acknowledgment...");
                        dos.writeUTF("ACK"); 
			System.out.println("Closing this connection : " + s); 
                        s.close(); 
                        System.out.println("Connection closed"); 
			dis.close(); 
			dos.close(); 
		}catch(Exception e){ 
			e.printStackTrace();  }
	} 
} 

