class Solution {
// MEMOIZATION
//     int[][] dp;
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length();
//         int m = text2.length();
//         dp = new int[n+1][m+1];
//         for(int[] row : dp) Arrays.fill(row,-1);
//         return helper_fun(text1,text2,n,m);
        
//     }
//     public int helper_fun(String s1, String s2, int n, int m){
//         if(n == 0 || m == 0) return 0;
        
//         if(dp[n][m] != -1) return dp[n][m];
        
//         if(s1.charAt(n-1) == s2.charAt(m-1)) dp[n][m] = 1 + helper_fun(s1,s2,n-1,m-1);
//         else dp[n][m] = Math.max(helper_fun(s1,s2,n-1,m), helper_fun(s1,s2,n,m-1));
        
//         return dp[n][m];
//     }
    
// TABULATION
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < m+1; j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                
                if(i>=1 && j>=1 ){
                    if(text1.charAt(i-1) == text2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[n][m];
    }
}