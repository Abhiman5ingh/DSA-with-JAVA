package DynamicProgramming;

public class stringConversion {
    // O( n * m )
    public static int minOps(String w1, String w2){
        int n = w1.length();
        int m = w2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i=0; i< n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }

        for(int i=1; i< n+1; i++){
            for(int j=1; j<m+1; j++){
                if(w1.charAt(i-1) == w2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int lcs = dp[n][m];
        int del = n-lcs;
        int add = m-lcs;
        return (del+add);
    }

    public static void main(String[] args) {
        String word1 = "pear";
        String word2 = "sea";

        System.out.println(minOps(word1, word2));
    }
}
