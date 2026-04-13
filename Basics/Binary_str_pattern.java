package Basics;
import java.util.Scanner;

public class Binary_str_pattern {
    public static void binstr(int n,int lastplace,String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        binstr(n-1,0,str+"0");
        if(lastplace==0){
            binstr(n-1,1,str+"1");
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of binary string:");
        int n=sc.nextInt();
        binstr(n,0,"");
        sc.close();
    }
}
