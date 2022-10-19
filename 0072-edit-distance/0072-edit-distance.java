class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int [] row: dp){
            Arrays.fill(row,-1);
        }
        return helper_fun(word1,word2,word1.length()-1,word2.length()-1,dp);
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