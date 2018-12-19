/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac5;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *
 * @author HP
 */
public class RMIDB extends UnicastRemoteObject implements Db_Interface {
ResultSet rs;
Statement stmt;
Connection con;
PreparedStatement cinsert;

public RMIDB()throws RemoteException {}

   public String connect() {
       String ss="";
       try{
        Class.forName("oracle.jdbc.OracleDriver");
        con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","HR","hr");
        System.out.println("Successfully created the database");  
        stmt = con.createStatement();
        cinsert=con.prepareStatement("INSERT INTO STUDENT(name,roll_no,sem,cgpa) VALUES(?,?,?,?)");
        return "Connected to Database...";
       }
       catch(SQLException s){
           System.out.println("Error.."+s);
       }
       catch(ClassNotFoundException s){
           System.out.println("Error..."+s);
       }
       return ss;
    }
    
    
    public String insert(Student s){
        String sw="";
        System.out.println("Inside insert func");
        try{
            String as="INSERT INTO STUDENT(name,roll_no,sem,cgpa) VALUES('"+s.getName()+"',"+s.getRoll_no()+","+s.getSem()+","+ s.getCgpa()+")";
            System.out.println("string constructed...");
            stmt.execute(as); 
            System.out.println("1 Row Inserted...");
            return "Data Inserted...";
        }
        catch(SQLException sq){
            System.out.println("Error..."+sq);
        }
        return sw;
    }
    
    public String updateName(int r,String n) {
        String sw="";
        try{
        String s="UPDATE STUDENT SET name = '"+n+"' where roll_no="+r;
        stmt.execute(s); 
            System.out.println("1 row Updated...");
            return "Data Updated...";
        }
        catch(SQLException sq){
            System.out.println("Error..."+sq);
        }
        return sw;
    }
    
     public String updateCGPA(int r,double n){
         String sw;
         try{
        String s="UPDATE STUDENT SET cgpa = "+n+" where roll_no="+r;
        stmt.execute(s);
         System.out.println("1 row Updated...");
          return "Data Updated...";
         }
         catch(SQLException sq){
             System.out.println("Error..."+sq);
         }
          return "Data Updated...";
    }
     
     public String updateSem(int r,int n) {
         try{
        String s="UPDATE STUDENT SET sem = "+n+" where roll_no="+r;
        stmt.execute(s);
         System.out.println("1 row Updated...");
          return "Data Updated...";
         }
         catch(SQLException sq){
             System.out.println("Error..."+sq);
         }
         return "";
    }
    
     public String delete(int r) {
         try{
         String s="delete from student where roll_no="+r;
        stmt.execute(s); 
             System.out.println("1 row deleted...");
              return "1 row Deleted...";
         }
         catch(SQLException sq){
             System.out.println("Error..."+sq);
         }
         return "";
     }
    
    public ArrayList<Student> selectAll() {
        ArrayList<Student> arr=null;
        try{
        String s="SELECT * FROM STUDENT ";
        rs=stmt.executeQuery(s);  
       arr=new ArrayList<Student>();
        Student  st;
            System.out.println("before loop");
            
        while(rs.next()){
            st=new Student(rs.getString("NAME"),rs.getInt("SEM"),rs.getInt("ROLL_NO"),rs.getFloat("CGPA"));
            arr.add(st);
            System.out.println("name"+st.getName());
        } 
            System.out.println("retrived all data...");
        return arr;
        }
        catch(SQLException sq){
             System.out.println("Error..."+sq);
         }
           return arr;
    }
     public Student select(int r) {
         Student   st=null;
         try{
         String s="SELECT * FROM STUDENT WHERE ROLL_NO="+r;
         rs=stmt.executeQuery(s);  
        st=new Student(rs.getString("NAME"),rs.getInt("SEM"),rs.getInt("ROLL_NO"),rs.getFloat("CGPA"));
        System.out.println("retrived a row...");
        return st;
             
         }
         catch(SQLException sq){
             System.out.println("Error..."+sq);
         }
          return st;
     }
     
     public ArrayList<Student> selectByCgpa(double c){
         ArrayList<Student> arr=null;
        try{
        String s="SELECT * FROM STUDENT ";
        rs=stmt.executeQuery(s);  
       arr=new ArrayList<Student>();
        Student  st=null;
            System.out.println("before loop");
            
        while(rs.next()){
            if(rs.getFloat("CGPA")==c){
                st=new Student(rs.getString("NAME"),rs.getInt("SEM"),rs.getInt("ROLL_NO"),rs.getFloat("CGPA"));
            }
            
            arr.add(st);
            System.out.println("name"+st.getName());
        } 
            System.out.println("retrived all data...");
        return arr;
        }
        catch(SQLException sq){
             System.out.println("Error..."+sq);
         }
           return arr;
    }
     
     public String close_con(){
         try{
          con.close(); 
             System.out.println("Connection closed...");
             return "Connection closed with Database...";
         }
           catch(SQLException sq){
             System.out.println("Error..."+sq);
         }
         return "";
     }
     
}
