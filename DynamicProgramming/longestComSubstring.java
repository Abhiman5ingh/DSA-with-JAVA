package DynamicProgramming;

public class longestComSubstring {
    public static int lcsTabu(String s1, String s2){   // Tabulation
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i =0; i<n+1; i++){
            for(int j =0; j<m+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for(int i =1; i< n+1; i++){
            for(int j=1; j< m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }
    


    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abce";

        int n = s1.length();
        int m = s2.length();

        System.out.println(lcsTabu(s1, s2));
    }
}
