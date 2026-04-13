package Basics;
import java.util.*;
public class tiling {
    public static int tilingways(int n){
        if(n==0 || n==1){
            return 1;
        }
        int fnm1=tilingways(n-1);
        int fnm2=tilingways(n-2);
        int totalways=fnm1+fnm2;
        return totalways;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(tilingways(n));
        sc.close();
    }
}
