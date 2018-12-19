/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4b;

import java.rmi.*;

/**
 *
 * @author HP
 */
public interface Server extends Remote {
     public String Echo_Server(String s) throws RemoteException;
    public String Time_Server() throws RemoteException;
}
