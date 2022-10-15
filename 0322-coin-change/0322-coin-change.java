class Solution {
    // Memoization
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n+1][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int res = helper_fun(coins, amount, n);
        if(res >= (int)1e9)return -1;
        else return res;
    }
    
    public int helper_fun(int[] coins, int s, int n){
        if(n == 0){
            if(s%coins[n] == 0) return s/coins[n];
            else return (int) 1e9;
        }
        
        if(dp[n][s] != -1) return dp[n][s];
        
        if(coins[n-1] <= s ){
            dp[n][s] = Math.min(helper_fun(coins,s,n-1),1 + helper_fun(coins,s-coins[n-1],n));
        }else{
            dp[n][s] = helper_fun(coins,s,n-1);
        }
        
        return dp[n][s];
    }
}