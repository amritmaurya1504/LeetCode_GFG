//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long helper(int indx, int[] coins, int sum, int tempSum, long[][] dp){
        if(tempSum == sum) return 1;
        if(tempSum > sum || indx >= coins.length ) return 0;
        
        if(dp[indx][tempSum] != -1) return dp[indx][tempSum];
        
        long take = 0;
        if(coins[indx] <= sum){
            take = helper(indx, coins, sum, tempSum + coins[indx], dp);
        }
        
        long notTake = helper(indx + 1, coins, sum, tempSum, dp);
        
        return dp[indx][tempSum] = take + notTake;
    }
    public long count(int coins[], int N, int sum) {
        long[][] dp = new long[N+1][sum+1];
        for(long[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(0, coins, sum, 0, dp);
    }
}