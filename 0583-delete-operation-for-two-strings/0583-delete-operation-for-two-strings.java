class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
	    int n = word2.length();
	    int[][] dp = new int[m+1][n+1];
	    
	    for(int i = 0; i < m+1; i++){
	        for(int j = 0; j < n+1; j++){
	            if( i == 0 || j == 0) dp[i][j] = 0;
	            if(i >= 1 && j >=1){
	                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
	                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	            }
	        }
	    }
	    
	    return (m - dp[m][n]) + (n - dp[m][n]);
    }
}