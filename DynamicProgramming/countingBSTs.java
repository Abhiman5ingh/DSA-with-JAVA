package DynamicProgramming;
// counting the number of BSTs we can construct fron n nodes -> catalan num concept
public class countingBSTs {
    public static int countBST(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<n+1; i++){  // Ci = no. of BSTs
            for(int j=0; j<i; j++){
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 4;
        int n3 = 5;
        System.out.println(countBST(n1));
        System.out.println(countBST(n2));
        System.out.println(countBST(n3));
    }
}
