class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper_fun(text1,text2,n,m);
        
    }
    public int helper_fun(String s1, String s2, int n, int m){
        if(n == 0 || m == 0) return 0;
        
        if(dp[n][m] != -1) return dp[n][m];
        
        if(s1.charAt(n-1) == s2.charAt(m-1)) dp[n][m] = 1 + helper_fun(s1,s2,n-1,m-1);
        else dp[n][m] = Math.max(helper_fun(s1,s2,n-1,m), helper_fun(s1,s2,n,m-1));
        
        return dp[n][m];
    }
}