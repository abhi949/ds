package Prac1;


import java.util.*;

public class Lamport_clock {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int p, n;
        System.out.println("Enter the no of process:");
        p=sc.nextInt();
        ArrayList<Integer> event_list=new ArrayList<Integer>();
        System.out.println("Enter the no of event of each process :");
        for(int i=0;i<p;i++){
            System.out.println("Enter the no of events of P"+(i+1));
            event_list.add(sc.nextInt());
        }
        System.out.println("Enter  the no of happened before relationship:");
        n=sc.nextInt();
        int[][] a=new int[p][Collections.max(event_list)];
        int count=0;
        int m=0;
        for(int i=0;i<p;i++){
            int ef= event_list.get(m);
            m++;
            for(int j=0;j<ef;j++){
                count++;
               a[i][j]=count;
            }
            count=0;
        }
        m=0;
        System.out.println("Enter the relations :");
        for(int i=0;i<n;i++){
            System.out.println("Enter sending event:");
            String send=sc.next();
            System.out.println("Enter receiving event:");
            String rec=sc.next();
            int si=Integer.parseInt(String.valueOf(send.charAt(1)));
            int sj=Integer.parseInt(String.valueOf(send.charAt(2)));
            if(si>=p){
                System.out.println("Enter the correct no of process");
                System.exit(0);
            }
            if(sj>=event_list.get(si)){
                System.out.println("Enter the correct no of events");
                System.exit(0);
            }
            int temp1=a[si][sj];
            int ri=Integer.parseInt(String.valueOf(rec.charAt(1)));
            int rj=Integer.parseInt(String.valueOf(rec.charAt(2)));
            if(ri>=p){
                System.out.println("Enter the correct no of process");
                System.exit(0);
            }
            if(rj>=event_list.get(ri)){
                System.out.println("Enter the correct no of events");
                System.exit(0);
            }
            int temp2=a[ri][rj];
            if(temp1>=temp2){
                int x=event_list.get(ri);
                a[ri][rj]=a[si][sj]+1;
                for(int j=rj+1;j<x;j++){
                    if(j>0)
                    a[ri][j]=Math.max(a[ri][j-1]+1,a[ri][j]);
                    else
                       a[ri][j]=2;  
                     System.out.println(a[ri][j]);
                }
            }
        }
        System.out.println("Final space time matrix : ");
        m=0;
        for(int i=0;i<p;i++){
            int ef= event_list.get(m);
            m++;
            for(int j=0;j<ef;j++){
               System.out.print(a[i][j]);
               System.out.print(" ");
            }
           System.out.println();
        }
     }
}
