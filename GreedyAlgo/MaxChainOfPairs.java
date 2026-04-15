package GreedyAlgo;
import java.util.*;

public class MaxChainOfPairs {
    public static void main(String args[]){
        int pairs[][] = {{5, 24}, {39,60}, {5, 28}, {27, 40}, {50, 90}};
        int n = pairs.length;

        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        int count = 1;
        int currEnd = pairs[0][1];

        for(int i = 1; i< n; i++){
            if(pairs[i][0] > currEnd){
                count++;
                currEnd = pairs[i][1];
            }
        }
        System.out.println("Maximum length of chain = " + count);
    }
}
