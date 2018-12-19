/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4;


import java.net.*;
import java.rmi.*;
import java.rmi.registry.Registry;
import java.util.*;


public class RMI_Server {
     public static void main(String[] args)  {
                Scanner sc=new Scanner(System.in);

        try {
            Operations t=new Operations();
           
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);//1099 is the port number
                        
            r.rebind("Transpose", t);
            r.rebind("Multiply", t);
            System.out.println("OBJECT REGISTERED...");
             
        } catch (Exception ex) {
            System.out.println("Error...  "+ex);
        }
        
        
    }
}
