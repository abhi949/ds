package Prac6;



import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 

// Server class 
public class Server 
{ 
    static int flag=0;
    static int n=0, tot_cohorts=0,tot=0, dec=0;
	public static void main(String[] args) throws IOException 
	{ 
                Scanner sc=new Scanner(System.in);
		ServerSocket ss = new ServerSocket(5056); 
                System.out.println("Enter the number of Cohorts :  ");
                tot=sc.nextInt();
                tot_cohorts=tot;
                System.out.println("***  1st phase...  ***");
		while (tot-->0) 
		{       Socket s = null; 
			try
			{       s = ss.accept(); 
				System.out.println("A new client is connected : " + s); 
				DataInputStream dis = new DataInputStream(s.getInputStream()); 
				DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
				Thread t = new ClientHandler(s, dis, dos); 
                                t.start(); }
			catch (Exception e){ 
				s.close(); 
				e.printStackTrace();  }   
		} 
	} 
} 

class ClientHandler extends Thread 
{   	final DataInputStream dis; 
	final DataOutputStream dos; 
	final Socket s; 
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) 
	{       this.s = s; 
		this.dis = dis; 
		this.dos = dos; 
	} 
        @Override
	public void run() 
	{       String received; 
		while (true) 
		{       try {   System.out.println("SENDING COMMIT-REQUEST MESSAGE to"+s+" ...");
				dos.writeUTF("COMMIT-REQUEST MESSAGE..."); 
				received = dis.readUTF(); 
				if(received.equals("ABORT"))
				        Server.flag=1;
                                    Server.n++;
                                    while(Server.n<Server.tot_cohorts){
                                            System.out.println("WAITING FOR THE REPLY FROM ALL COHORTS... ");
                                    }
                                    if(Server.dec==0){
                                         System.out.println("***  2nd Phase...  ***");
                                         Server.dec=1;
                                     }  
                                    if(Server.flag==1){
                                        System.out.println("Client " + this.s + " sends GLOBAL-ABORT..."); 
                                        dos.writeUTF("GLOBAL-ABORT...");
					received = dis.readUTF(); 
                                        System.out.println("Received "+received+" from "+s);
					this.s.close(); 
					break; 
                                    }
                                    else{
                                        System.out.println("Client " + this.s + " sends GLOBAL-COMMIT..."); 
                                        dos.writeUTF("GLOBAL-COMMIT...");
					received = dis.readUTF(); 
                                        System.out.println("Received "+received+" from "+s);
					this.s.close(); 
					break;
                                    }
                        } catch (IOException e) { 
				e.printStackTrace();  }
		} 
		try
		{       this.dis.close(); 
			this.dos.close(); 
		}catch(IOException e){ 
			e.printStackTrace(); 
		} 
	} 
} 
