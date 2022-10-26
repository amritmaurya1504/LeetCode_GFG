class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp=new int[p.length()][s.length()];
        for(int i=0;i<p.length();i++){
            for(int j=0;j<s.length();j++){
                dp[i][j]=-1;
            }
        }
        return helper(p.length()-1,s.length()-1,p,s,dp)==1?true:false;
    }
    public int helper(int i,int j,String p,String s,int[][] dp){
        if(i<0 && j<0) return 1;
        if(i<0 && j>=0) return 0;
        if(i>=0 && j<0){
            for(int ii=0;ii<=i;ii++){
                if(p.charAt(ii)!='*') return 0;
            }
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(p.charAt(i)==s.charAt(j) || p.charAt(i)=='?'){
           return dp[i][j]=helper(i-1,j-1,p,s,dp);
        }else if(p.charAt(i)=='*'){
            return dp[i][j]=(helper(i-1,j,p,s,dp)==1?true:false || helper(i,j-1,p,s,dp)==1?true:false)?1:0;
        }
        return 0;
    }
}