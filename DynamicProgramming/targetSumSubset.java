package DynamicProgramming;

public class targetSumSubset {
    public static void print(boolean dp[][]){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(dp[i][j] == true)
                System.out.print("T" + " ");
                else
                System.out.print("F" + " ");
            }
            System.out.println();
        }
    }

    // O(N * SUM)
    public static boolean targetSumSub(int arr[], int sum){
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        // i = items && j = targetSum
        for(int i =0; i<=n; i++){
            dp[i][0] = true;
        }
        for(int i=1; i<n+1; i++){
            for(int j =1; j<sum+1; j++){
                int v = arr[i-1];
                //include
                if(v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                //exclude
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }
    
    public static void main(String args[]){
        int val[] = {4, 2, 7, 1, 3};
        int sum = 10;
        System.out.println(targetSumSub(val, sum));
    }
}
