/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatBoot;

import Prac4b.Impl_Server;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class RMI_Server {
    public static void main(String[] args)  {
               
        try {
             ChatBoot_Implementation t=new  ChatBoot_Implementation();
           
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);//1099 is the port number
                        
            r.rebind("Chating", t);
            System.out.println("OBJECT REGISTERED...");
             
        } catch (Exception ex) {
            System.out.println("Error...  "+ex);
        }
        
        
    
    }
}
