/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatBoot;

import java.rmi.*;

/**
 *
 * @author HP
 */
public interface ChatBoot_Interface extends Remote {
    public String Chating(String s) throws RemoteException;
}
