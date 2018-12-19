/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4b;

import java.rmi.*;
import java.rmi.server.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author HP
 */
public class Impl_Server extends UnicastRemoteObject implements Server {
public Impl_Server()throws RemoteException {}
   
    @Override
    public String Echo_Server(String s) throws RemoteException {
        System.out.println("Message from client received..."+s);
        return s;
    }

    @Override
    public String Time_Server() throws RemoteException {
        System.out.println("Calculating the time of the system...");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        System.out.println("Sending the data to the receiver...");
        String s=dtf.format(now);
        return s;
    }
    
}
