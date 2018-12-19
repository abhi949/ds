/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatBoot;


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
            
               String s="rmi://localhost/Chating";
              
            ChatBoot_Interface o1=(ChatBoot_Interface) Naming.lookup(s);
            String msg="";
            do{
                System.out.println("Enter ur msg : ");
                String m=sc.nextLine();
                msg=o1.Chating(m);
               System.out.println("Message received : "+msg);
            }while(msg.equals("Bye Bye...")==false);
            System.exit(0);
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
