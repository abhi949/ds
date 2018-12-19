/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac5;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class RMI_Client {
     public static void main(String[] args) throws SQLException {
        try {
                    Scanner sc=new Scanner(System.in);
                     String  s;
            s="rmi://localhost/connect";
            
            Db_Interface o1;
             o1=(Db_Interface) Naming.lookup(s);
             o1.connect();
            do{
            System.out.println("Enter ur choice :\n 1.INSERT \n  2. UPDATE NAME \n 3. UPDATE  CGPA \n 4. UPDATE SEM \n  5. DELETE \n 6. SELECT ALL \n 7. SELECT USING CGPA \n 8. exit");
           
            switch(sc.nextInt()){
                case 1:  s="rmi://localhost/insert";
                       o1=(Db_Interface) Naming.lookup(s);
                       System.out.println("Enter the details");
                       System.out.println("Name: ");
                       String n=sc.next();
                       System.out.println("Sem: ");
                       int ss=sc.nextInt();
                       System.out.println("Roll no:");
                       int r=sc.nextInt();
                       System.out.println("CGPA: ");
                       double c=sc.nextDouble();
                       Student sq=new Student(n,ss,r,c);
                       System.out.println("Object transfered to the server...");
                       System.out.println(o1.insert(sq));
                       break;
                case 2:   s="rmi://localhost/updateName";
                        o1=(Db_Interface) Naming.lookup(s);
                     System.out.println("Enter  Roll No and Name: ");
                     r=sc.nextInt();
                     n=sc.next();
                     System.out.println(o1.updateName(r, n));
                     break;
                case 3:  s="rmi://localhost/updateCGPA";
                o1=(Db_Interface) Naming.lookup(s);
                     System.out.println("Enter Roll No and CGPA : ");
                     r=sc.nextInt();
                     c=sc.nextDouble();
                     System.out.println(o1.updateCGPA(r, c));
                     break;
                case 4: s="rmi://localhost/updateSem"; 
                o1=(Db_Interface) Naming.lookup(s);
                     System.out.println("Enter Roll No and Sem : ");
                     r=sc.nextInt();
                     ss=sc.nextInt();
                     System.out.println(o1.updateSem(r, ss));
                
                break;    
                case 5:  s="rmi://localhost/delete";
                o1=(Db_Interface) Naming.lookup(s);
                     System.out.println("Enter Roll No : ");
                     r=sc.nextInt();
                     System.out.println(o1.delete(r));
                
                break;
                case 6:  s="rmi://localhost/selectAll";
                o1=(Db_Interface) Naming.lookup(s);
                    
                     ArrayList<Student> ar=o1.selectAll();
                     if(ar.size()==0)
                     System.out.println("Table Empty...");
                     for(Student w:ar){
                         System.out.println("NAME : "+w.getName()+"\n CGPA : "+w.getCgpa()+"\n SEM : "+w.getSem()+"\n ROLL NO : "+w.getRoll_no());
                     }
                break;
                case 7: s="rmi://localhost/selectByCgpa"; 
                  o1=(Db_Interface) Naming.lookup(s);
                System.out.println("Enter CGPA : ");
                    double cc=sc.nextFloat();
                     ar=o1.selectByCgpa(cc);
                     for(Student w:ar){
                         System.out.println("NAME : "+w.getName()+"\n SEM : "+w.getSem()+"\n ROLL NO : "+w.getRoll_no());
                     }
              
                break;
                case 8:s="rmi://localhost/close_con"; 
                  o1=(Db_Interface) Naming.lookup(s);
                    System.out.println(o1.close_con());
                  System.exit(0);
            }
            
            }while(true);
          
       
       //    Naming.unbind(s);

        } catch (NotBoundException ex) {
            System.out.println("Error..."+ex);
        } catch (MalformedURLException ex) {
             System.out.println("Error..."+ex);
        } catch (RemoteException ex) {
             System.out.println("Error..."+ex);
        }
    }
}
