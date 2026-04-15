package GreedyAlgo;
import java.util.*;

public class MinAbsDiff {
    public static void main(String args[]){
        // int a[] = {1, 2, 3};
        // int b[] = {2, 1, 3};
        int a[] = {4, 1, 8, 7};
        int b[] = {2, 6, 5, 3};

        Arrays.sort(a);
        Arrays.sort(b);

        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum += Math.abs(a[i] - b[i]);
        }
        System.out.println("Minimum Absolute Difference = " + sum);
    }
}
