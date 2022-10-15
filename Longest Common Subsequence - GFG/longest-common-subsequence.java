//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    static int[][] dp;
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        dp = new int[x+1][y+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper_fun(x,y,s1,s2);
    }
    
    static int helper_fun(int n, int m, String s1, String s2){
        if(n == 0 || m == 0) return 0;
        
        if(dp[n][m] != -1) return dp[n][m];
        
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            dp[n][m] = 1 + helper_fun(n-1,m-1,s1,s2);
        }else{
            dp[n][m] = Math.max(helper_fun(n-1,m,s1,s2),helper_fun(n,m-1,s1,s2));
        }
        
        return dp[n][m];
    }
    
}