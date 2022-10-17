class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return f(str1, str2);
    }
    
    public String f(String str1, String str2) {
        // tabulation code from LCS
        int l1 = str1.length();
        int l2 = str2.length();
        
        int[][] dp = new int[l1+1][l2+1];
        
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
        
           if(str1.charAt(i-1)==str2.charAt(j-1)){
               dp[i][j] = 1 + dp[i-1][j-1];
             } else {
               dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
    } 
        
        String ans = "";
        
        int i=l1, j=l2;
        
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                ans += str1.charAt(i-1);
                i--;
                j--;
            } else if(dp[i-1][j]>dp[i][j-1]){
                ans += str1.charAt(i-1);
                i--;
            } else {
                ans += str2.charAt(j-1);
                j--;
            }
        }
        
         while(i>0){
             ans += str1.charAt(i-1);
             i--;
         }
        
        while(j>0){
            ans += str2.charAt(j-1);
            j--;
        }
        
        return new StringBuilder(ans).reverse().toString();        
    }
}