//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends




class Solution
{
    static int solveUtil(int ind, int[] arr, int[] dp){
        if(ind<0)  return 0;
        if(ind==0) return arr[ind];
        if(dp[ind]!=-1) return dp[ind];
        int pick= arr[ind]+ solveUtil(ind-2, arr,dp);
        int nonPick = 0 + solveUtil(ind-1, arr, dp);
        return dp[ind]=Math.max(pick, nonPick);
    }

    static int solve(int n,int[] arr){
      int dp[]=new int[n];
      Arrays.fill(dp,-1);
      return solveUtil(n-1, arr, dp);
    }
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
       return solve(n,arr);
    }
}