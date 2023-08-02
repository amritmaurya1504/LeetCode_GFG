//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine().trim());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubsequence(N, A));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int solve(int ind, int prev, int[] arr, int n){
        if(ind >= n) return 0;
        
        int take = 0;
        if(prev == -1 || Math.abs(arr[ind] - arr[prev]) == 1){
            take =  1 + solve(ind + 1, ind, arr, n);
        }
        
        int notTake = solve(ind + 1, prev, arr, n);
        
        return Math.max(take, notTake);
    }
    static int longestSubsequence(int N, int A[])
    {
        return solve(0, -1, A, N);
    }
}