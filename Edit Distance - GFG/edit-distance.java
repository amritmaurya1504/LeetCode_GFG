//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
     int[][] dp = new int[s.length()][t.length()];
        for(int [] row: dp){
            Arrays.fill(row,-1);
        }
        return helper_fun(s,t,s.length()-1,t.length()-1,dp);
    }
    public int helper_fun(String s, String t, int i, int j, int[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = helper_fun(s,t,i-1,j-1,dp);
        }else{
            return dp[i][j] = 1 + Math.min(helper_fun(s,t,i,j-1,dp),Math.min(helper_fun(s,t,i-1,j,dp),helper_fun(s,t,i-          1,j-1,dp)));
        }
    }
}