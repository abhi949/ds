/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4b;


import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class RMI_Server {
    public static void main(String[] args)  {
                Scanner sc=new Scanner(System.in);

        try {
            Impl_Server t=new Impl_Server();
           
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);//1099 is the port number
                        
            r.rebind("Echo_Server", t);
            r.rebind("Time_Server", t);
            System.out.println("OBJECT REGISTERED...");
             
        } catch (Exception ex) {
            System.out.println("Error...  "+ex);
        }
        
        
    }
}
