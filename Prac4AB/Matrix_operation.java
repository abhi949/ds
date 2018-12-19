/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4;

import java.rmi.*;

/**
 *
 * @author HP
 */
public interface Matrix_operation extends Remote{
    
    public int[][] Transpose(int[][] a) throws RemoteException;
    public int[][] Multiply(int[][] a,int [][] b) throws RemoteException;
}
