/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4b;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class RMI_Client {
     public static void main(String[] args) {
        try {
                    Scanner sc=new Scanner(System.in);
            System.out.println("Enter ur choice : 1. Want to check the communication channel ?  2. Want Time ?");
            int ch=sc.nextInt();
            String  s;
            String msg="";
            if(ch==1){
               s="rmi://localhost/Echo_Server";
               System.out.println("Enter the message : ");
               sc.nextLine();
               msg=sc.nextLine();
            }
            else 
                s="rmi://localhost/Time_Server";
            Server o1=(Server) Naming.lookup(s);
            String op;
            System.out.println("Output recevied from the server : ");
            if(ch==1){
                 System.out.println(o1.Echo_Server(msg));
            }
            else{
                System.out.println("Time : ");
                System.out.println(o1.Time_Server());
            }
            
           Naming.unbind(s);

        } catch (NotBoundException ex) {
            System.out.println("Error..."+ex);
        } catch (MalformedURLException ex) {
             System.out.println("Error..."+ex);
        } catch (RemoteException ex) {
             System.out.println("Error..."+ex);
        }
    }
}
