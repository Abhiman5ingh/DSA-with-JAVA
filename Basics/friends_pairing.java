package Basics;
import java.util.*;
public class friends_pairing {
    public static int singleorpair(int n){
        if(n==2 || n==1){
            return n;
        }
        int single=singleorpair(n-1);
        int pair=singleorpair(n-2);
        int pairways=(n-1)*pair;
        int totalways=single+pairways;
        return totalways;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of friends:");
        int n=sc.nextInt();
        System.out.println(singleorpair(n));
        sc.close();
    }
}
