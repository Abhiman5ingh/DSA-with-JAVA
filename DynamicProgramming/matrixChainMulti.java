package DynamicProgramming;
import java.util.*;

public class matrixChainMulti {

    // By Recursion
    public static int mcm(int arr[], int i, int j){
        if(j == i){
            return 0;   // single matrix case
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<= j-1; k++){
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, k+1, j);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 +cost2 +cost3;
            ans = Math.min(ans, finalCost);
        }

        return ans;   // minimum cost
    }

    // By Memoization
    public static int mcmMemo(int arr[], int i, int j, int dp[][]){
        if(j == i){
            return 0;   // single matrix case
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<= j-1; k++){
            int cost1 = mcm(arr, i, k);
            int cost2 = mcm(arr, k+1, j);
            int cost3 = arr[i-1] * arr[k] * arr[j];
            int finalCost = cost1 +cost2 +cost3;
            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;
    }

    public static int mcmTab(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        for(int i =0; i< n; i++){
            dp[i][i] = 0;
        }

        for(int len = 2; len<= n-1; len++){
            for(int i=1; i<= n-len; i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k =i; k<= j-1; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[j]*arr[k];
                    int finalCost = cost1 + cost2 + cost3;
                    dp[i][j] = Math.min(dp[i][j], finalCost);
                }
            }
        }
        print(dp);
        return dp[1][n-1];
    }

    public static void print(int arr[][]) {
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};    // n=5
        int n = arr.length;

        int dp[][] = new int[n][n];
        for(int i =0; i< n ;i++){
            Arrays.fill(dp[i], -1);
        }

        // System.out.println(mcm(arr, 1, n-1));
        System.out.println(mcmMemo(arr, 1, n-1, dp));
        System.out.println(mcmTab(arr));
    }
}
