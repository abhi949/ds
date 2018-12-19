package Prac2;

import java.util.*;

public class vector_clock {
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
        String[][] a=new String[p][Collections.max(event_list)];
        int count=0;
        int m=0;
        String concat="";
        for(int i=0;i<p;i++){
            concat=concat+"0";
        }
        String concat2;
        for(int i=0;i<p;i++){
            int ef= event_list.get(m);
            m++;
            concat2=concat;
            StringBuilder ss=new StringBuilder(concat2);
            for(int j=0;j<ef;j++){
                count++;
               ss.setCharAt(i, String.valueOf(count).charAt(0));
               a[i][j]=String.valueOf(ss);
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
            String temp1=a[si][sj];
            int ri=Integer.parseInt(String.valueOf(rec.charAt(1)));
            int rj=Integer.parseInt(String.valueOf(rec.charAt(2)));
            String temp2;
            int tt=0;
            if(rj==0){
                temp2=a[ri][rj];
            }
            else{
                temp2=a[ri][rj-1];
            }
            StringBuilder check=new StringBuilder(a[ri][rj]);
            for(int g=0;g<p;g++){
                tt=Math.max(Integer.parseInt(String.valueOf(temp2.charAt(g))), Integer.parseInt(String.valueOf(temp1.charAt(g))));
                int tj=Math.max(tt, Integer.parseInt(String.valueOf(check.charAt(g))));
                if(g==ri && tt==tj)
                    tt=tt+1;
                else
                    tt=tj;
                check.setCharAt(g, String.valueOf(tt).charAt(0));
            }
            a[ri][rj]=String.valueOf(check);
            StringBuilder tq=new StringBuilder(a[ri][rj]);
            for(int g=rj+1;g<event_list.get(ri);g++){
                for(int gg=0;gg<p;gg++){
                    tq=new StringBuilder(a[ri][g]);
                    tt=Math.max(Integer.parseInt(String.valueOf(a[ri][g-1].charAt(gg))),Integer.parseInt(String.valueOf(a[ri][g].charAt(gg))));
                    if(gg==ri)
                          tt=tt+1;
                    tq.setCharAt(gg, String.valueOf(tt).charAt(0));
                    a[ri][g]=String.valueOf(tq);
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
