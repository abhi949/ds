/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac5;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;

/**
 *
 * @author rcoem
 */
public interface Db_Interface extends Remote {
    public String connect()throws RemoteException;
     public String insert(Student s)throws RemoteException ;
     public String updateName(int r,String n)throws RemoteException ;
     public String updateCGPA(int r,double n)throws RemoteException;
     public String updateSem(int r,int n)throws RemoteException ;
      public String delete(int r) throws RemoteException;
       public ArrayList<Student> selectAll() throws RemoteException;
        public Student select(int r) throws RemoteException;
        public ArrayList<Student> selectByCgpa(double c)throws RemoteException;
        public String close_con() throws RemoteException;
}
