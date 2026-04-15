package GreedyAlgo;
import java.util.*;

public class IndianCoins {
    public static void main(String args[]){
        int coins[] = {1, 2, 5, 10, 20, 50, 100 , 200, 500, 2000};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount: ");
        int V = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();

        int minamt = 0;
        for(int i = coins.length -1; i>=0 ;i--){
            if(V >= coins[i]){
                while(V >= coins[i]){
                minamt++;
                ans.add(coins[i]);
                V -= coins[i];
                }
            }
        }
        System.out.println("Minimum number of coins = " + minamt);
            System.out.println("Coins used: " + ans);
    }
}
