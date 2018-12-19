package Prac3;

import java.util.*;

public class Raymond {
static HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
static HashMap<Integer, ArrayList<Integer>> req_q=new HashMap<Integer, ArrayList<Integer>>();
static int token;
 static Scanner sc=new Scanner(System.in); 
   public static void main(String[] args) {
        System.out.println("Enter the total no of process :");
        int n=sc.nextInt();
        System.out.println("Enter the relation :");
        
        for(int i=0;i<n-1;i++){
           System.out.println("from :");
           int f=sc.nextInt();
           System.out.println("to :");
           int t=sc.nextInt();
           map.put(f, t);
        }
        System.out.println("site id holding the token: "); 
        token=sc.nextInt();
        map.put(token, 0);
         for(int i=0;i<n;i++){
            req_q.put(i+1, null);
        }
        
        int ch;
         while(true){
            System.out.println("Enter your choice: 1. req(r) 2.pass 3.exit");
            ch=sc.nextInt();
            if(ch==3)
                System.exit(0);
            if(ch==1){
                token_request();
                for(Map.Entry<Integer,ArrayList<Integer>> m:req_q.entrySet()){
                    System.out.print("Node : "+m.getKey()+" queue: ");
                    ArrayList<Integer> a=m.getValue();
                    if(a!=null){
                        for(int y:a){
                            System.out.print(y+" ");
                        }
                    }
                    System.out.println();
                }
            }
            else
                token_pass();
            
        }
    }
    
   
   
   static void display(){
       
   }
    static void token_request(){
        System.out.println("Enter the token request :");
        int r=sc.nextInt();
        int d=r;
        int temp;
        ArrayList<Integer> ss;
        ss=new ArrayList<Integer>(); 
            ArrayList<Integer> s=req_q.get(d);
            if(s!=null){
                for(int g:s){
                    ss.add(g);
                }
            }
            ss.add(d);
            req_q.replace(d, ss);
        while(d!=token){
            ss=new ArrayList<Integer>(); 
            ArrayList<Integer> s1=req_q.get(map.get(d));
            if(s1!=null){
                for(int g:s1){
                    ss.add(g);
                }
            }
            if(!ss.contains(d)){
               ss.add(d);
            }   
            req_q.replace(map.get(d), ss);
            if(d==token)
                break;
            d=map.get(d);     
          
        }
    }
    static void token_pass(){
        int g=token;
         ArrayList<Integer> ss;
        while(req_q.get(g)!=null && req_q.get(g).size()!=0){
           ss=new ArrayList<Integer>(); 
           ArrayList<Integer> a=req_q.get(g);
           int i = a.get(0);
           map.replace(g, i);
           if(g==i){
               token=g;
               System.out.println("Token acquired at "+g);
                map.replace(g, 0);
           }
           else
                  System.out.println("Token pass from "+g+" to "+i);
           for(int y:a){
               ss.add(y);
           }
           ss.remove(0);
           if(g==i){
               if(ss.size()!=0){
                 i=ss.remove(0);
                 map.replace(g, i);
               }
           }
           req_q.replace(g, ss);
           if(ss.size()!=0){
                ArrayList<Integer> rev=req_q.get(i);
                ArrayList<Integer> sq=new ArrayList<Integer>();
                if(rev!=null){
                    for(int o:rev){
                        sq.add(o);
                    }
                }
                sq.add(g);
                req_q.replace(i, sq);
           }
           else
               req_q.replace(g, null);
           g=i;
        }
        
    }
}

