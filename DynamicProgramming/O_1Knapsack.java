package DynamicProgramming;

public class O_1Knapsack {
    
    // Recursion:
    public static int knapsack(int val[], int wt[], int W, int n){
        if(n == val.length || W == 0)
            return 0;
        if(wt[n] <= W){     // valid
            // include
            int ans1 = val[n]+knapsack(val, wt, W-wt[n], n+1);
            // exclude
            int ans2 = knapsack(val, wt, W, n+1);
            return Math.max(ans1, ans2);
        } else {    // invalid
            return knapsack(val, wt, W, n+1);
        }
    }

    // Memoization:
    public static int knapsackMemo(int val[], int wt[], int W, int n, int dp[][]){
        //O(n * W)

        if(n == val.length || W == 0)
            return 0;

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n] <= W){     // valid
            // include
            int ans1 = val[n]+knapsackMemo(val, wt, W-wt[n], n+1, dp);
            // exclude
            int ans2 = knapsackMemo(val, wt, W, n+1, dp);
            dp[n][W] =  Math.max(ans1, ans2);    // updating before returning
            return dp[n][W];
        } else {    // invalid
            dp[n][W] = knapsackMemo(val, wt, W, n+1, dp);
            return dp[n][W];
        }
    }


    public static void print(int dp[][]){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Tabulation: 
    public static int knapsackTab(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int [n+1][W+1];
        for(int i = 0; i < dp.length; i++){
                dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++){
                dp[0][j] = 0;
        }
        for(int i=1; i < n+1; i++){
            for(int j=1; j< W+1; j++){
                int v= val[i-1];
                int w= wt[i-1];
                if(w<=j){
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i-1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        print(dp);
        return dp[n][W];
    }


    public static void main(String args[]){
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W =7;
        int dp[][] = new int[val.length+1][W+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        // int maxProfit = knapsack(val, wt, W, 0);
        // int maxProfit = knapsackMemo(val, wt, W, 0, dp);
        final int maxProfit = knapsackTab(val, wt, W);
        System.out.println("MaxProfit: "+maxProfit);
    }
}
