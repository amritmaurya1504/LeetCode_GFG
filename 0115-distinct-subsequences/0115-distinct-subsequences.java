class Solution {
    public int numDistinct(String s, String t) {
         int[][] dp= new int[s.length()][t.length()];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(s, t, s.length()-1, t.length()-1, dp);
    }
    public int helper(String s, String t, int i, int j, int[][] dp){
        if(j < 0){
             return 1;
        }
        if(i < 0){
            return 0;
        }
        
        
        if(dp[i][j] != -1) return dp[i][j];
        
       if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = helper(s, t, i-1, j-1, dp) + helper(s, t, i-1, j, dp);
        }
        //notmatching
        else{
            return dp[i][j] = helper(s, t, i-1, j, dp);
        }
    }
} 