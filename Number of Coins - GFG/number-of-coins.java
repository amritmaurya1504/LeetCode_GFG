//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int[][] dp;
	public int minCoins(int coins[], int M, int V) 
	{ 
	    dp = new int[M+1][V+1];
	    for(int[] row : dp) Arrays.fill(row,-1);
	    int res = helper_fun(coins, M, V);
	    return res >= (int)1e9 ? -1 : res;
	} 
	
	public int helper_fun(int[] coins, int M, int V){
	    if(M == 0){
	        if(V%coins[M] == 0) return V/coins[M];
	        else return (int)1e9;
	    }
	    
	    if(dp[M][V] != -1) return dp[M][V];
	    
	    if(coins[M-1] <= V){
	        dp[M][V] = Math.min(helper_fun(coins,M-1,V), 1 + helper_fun(coins,M,V-coins[M-1]));
	    }else{
	        dp[M][V] = helper_fun(coins,M-1,V);
	    }
	    
	    
	    return dp[M][V];
	}
}