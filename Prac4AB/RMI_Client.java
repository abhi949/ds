/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac4;


import java.net.*;
import java.rmi.*;
import java.util.*;



public class RMI_Client {
     public static void main(String[] args) {
        try {
                    Scanner sc=new Scanner(System.in);
            System.out.println("Enter ur choice : 1. Transpose  2. Multiplication");
            int ch=sc.nextInt();
            System.out.println("Enter the rows and columns of 1st matrix : ");
                int r=sc.nextInt();
                int cc=sc.nextInt();
            int[][] a=new int[r][cc];
            int[][] b=null;
            System.out.println("Enter the matrix : ");
            for (int i = 0; i < a.length; i++) 
                for (int j = 0; j < a[0].length; j++) 
                        a[i][j]=sc.nextInt();
            String s="";
            if(ch==1){
                s="rmi://localhost/Transpose";
            }
            else{
                s="rmi://localhost/Multiply";
                System.out.println("Enter the rows and columns of the 2nd matrix : ");
                    r=sc.nextInt();
                    cc=sc.nextInt();
                b=new int[r][cc];
            }
            Matrix_operation o1=(Matrix_operation) Naming.lookup(s);
            int[][] c;
            if(ch==1){
                 c=o1.Transpose(a);
                 System.out.println("Transpose is  : ");
            }
            else{
                c=o1.Multiply(a,b);
                 System.out.println("Product  is  : ");
            }
            for (int i = 0; i < c.length; i++){
              for (int j = 0; j <c[0].length ; j++){ 
                  System.out.print(c[i][j]+" ");
              }
               System.out.println("");
           }
           Naming.unbind(s);

        } catch (NotBoundException ex) {
            System.out.println("Error..."+ex);
        } catch (MalformedURLException ex) {
             System.out.println("Error..."+ex);
        } catch (RemoteException ex) {
             System.out.println("Error..."+ex);
        }
    }
}
