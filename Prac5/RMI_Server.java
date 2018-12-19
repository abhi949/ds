/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac5;


import java.rmi.registry.Registry;
import java.util.Scanner;


public class RMI_Server {
    public static void main(String[] args)  {
                Scanner sc=new Scanner(System.in);

        try {
            RMIDB t=new RMIDB();
           
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);//1099 is the port number
                        
            r.rebind("connect", t);
            r.rebind("insert", t);
            r.rebind("updateName", t);
            r.rebind("updateCGPA", t);
            r.rebind("updateSem", t);
            r.rebind("delete", t);
            r.rebind("selectAll", t);
            r.rebind("select", t);
            r.rebind("selectByCgpa", t);
            System.out.println("OBJECT REGISTERED...");
             
        } catch (Exception ex) {
            System.out.println("Error...  "+ex);
        }
        
        
    }
}
