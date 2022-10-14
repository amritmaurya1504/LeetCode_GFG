class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n+1][amount+1];
        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }
        
        return helper_fun(amount, coins, n );
    }
    
    public int helper_fun(int s, int[] coins, int n){
        if (s == 0)
            return 1;
        
        if (s < 0)
            return 0;

        if (n <= 0)
            return 0;
        
        if(dp[n][s] != -1)
            return dp[n][s];
        
        if(coins[n-1] <= s){
            dp[n][s] = helper_fun(s,coins,n-1) + helper_fun(s-coins[n-1],coins,n);
        }else{
            dp[n][s] = helper_fun(s,coins,n-1);
        }
        
        return dp[n][s];

    }
    
    
}