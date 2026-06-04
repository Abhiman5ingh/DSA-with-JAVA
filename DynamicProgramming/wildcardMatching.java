package DynamicProgramming;

public class wildcardMatching {
    // HARD -> O(n * m)
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        //initialize
        dp[0][0] = true;
        for(int i=1; i<n+1; i++){
            dp[i][0] = false;
        }
        for(int j=1; j<m+1; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }   // else -> false (default in java)
        }

        // bottom up
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                // case -> ith char == jth char || jth char == ?
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        String s = "baaabab";
        String p = "*****ba*****ab";    // true
        String s2 = "abc";
        String p2 = "**d";
        String p3 = "**?";

        System.out.println(isMatch(s, p));
        System.out.println(isMatch(s2, p2));
        System.out.println(isMatch(s2, p3));
    }
}
