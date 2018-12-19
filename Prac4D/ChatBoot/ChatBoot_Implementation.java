/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatBoot;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class ChatBoot_Implementation extends UnicastRemoteObject implements ChatBoot_Interface {
    public ChatBoot_Implementation()throws RemoteException {}
    
    @Override
    public String Chating(String s) throws RemoteException {
        System.out.println("Message received : "+s);
        Scanner sc=new Scanner(System.in);
        String m="";
        if(s.equals("bye")){
            m="Bye Bye...";
        }
        else{
            System.out.println("Enter ur msg : ");
           m=sc.nextLine();
        }
        return m;
    }
    
}
