package DynamicProgramming;

public class longestCommonSubsequence {
    public static int lcsRec(String s1, int n, String s2, int m){   // Recursion
        if(n==0 || m==0) return 0;
        if(s1.charAt(n-1) == s2.charAt(m-1)){   // same
            return lcsRec(s1, n-1, s2, m-1) + 1;
        } else {    // diff
            int ans1 = lcsRec(s1, n, s2, m-1);
            int ans2 = lcsRec(s1, n-1, s2, m);
            return Math.max(ans1, ans2);
        }
    }

    public static int lcsMemo(String s1, int n, String s2, int m, int dp[][]){   // Memoization
        if(n==0 || m==0) return 0;

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s1.charAt(n-1) == s2.charAt(m-1)){   // same
            return dp[n][m] = lcsMemo(s1, n-1, s2, m-1, dp) + 1;
        } else {    // diff
            int ans1 = lcsMemo(s1, n, s2, m-1, dp);
            int ans2 = lcsMemo(s1, n-1, s2, m, dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }


    public static int lcsTabu(String s1, String s2){   // Tabulation
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i =0; i<n+1; i++)
            dp[i][0] = 0;

        for(int j =0; j<m+1; j++)
            dp[0][j] = 0;

        for(int i =1; i< n+1; i++){
            for(int j=1; j< m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }

        return dp[n][m];
    }
    


    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";

        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];

        //initialization
        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                dp[i][j] = -1;
            }
        }

        // System.out.println(lcsMemo(s1, n, s2, m, dp));
        // System.out.println(lcsRec(s1, s1.length(), s2, s2.length()));
        System.out.println(lcsTabu(s1, s2));
    }
}
