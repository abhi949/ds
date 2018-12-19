/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Operations extends UnicastRemoteObject implements Matrix_operation
{
   public Operations()throws RemoteException 
    {
        
    }
   
    @Override
    public int[][] Transpose(int[][] a) throws RemoteException {
        System.out.println("Got the Matrix...");
        int[][] b=new int[a[0].length][a.length];
        System.out.println("Transpose begin...");
        for (int i = 0; i < a[0].length; i++){
            for (int j = 0; j <a.length ; j++){ 
               b[i][j]=a[j][i];
            }
        }
        System.out.println("Transpose done...");
        System.out.println("Sending Output to the client...");
        return b;
    }

    @Override
    public int[][] Multiply(int[][] a, int[][] b) throws RemoteException {
        System.out.println("Got the Matrices...");
        int[][] c=new int[a.length][b[0].length];
        System.out.println("Multiplication  begin...");
        for (int i = 0; i < a.length; i++){ 
            for (int j = 0; j < b[0].length; j++){ 
                c[i][j] = 0; 
                for (int x = 0; x < a[0].length; x++){ 
                    c[i][j] += a[i][x] *b[x][j]; 
                } 
            } 
        } 
        System.out.println("Product calculated...");
        System.out.println("Sending Output to the client...");
        return b;
    }
}
