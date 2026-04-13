package Basics;
import java.util.*;

public class Power {
    public static int optizimepow(int a,int n){ //O(log n)
        if(n==0) return 1;
        int halfpowsq=optizimepow(a, n/2)*optizimepow(a, n/2);
        if(n%2!=0){
            halfpowsq= a *halfpowsq;
        }
        return halfpowsq;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int n=scanner.nextInt();
        System.out.println(optizimepow(a,n));
        scanner.close();
    }
}