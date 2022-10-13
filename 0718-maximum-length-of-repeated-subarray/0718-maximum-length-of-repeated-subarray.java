class Solution {
    public int findLength(int[] nums1, int[] nums2) {
         int len = 0;
        int n1 = nums1.length;
        int n2= nums2.length;
        int[][]dp = new int[n1+1][n2+1];
        for(int i =0;i<=n2;i++){
            dp[0][i] =0;
        }
        for(int i =0;i<=n1;i++){
            dp[i][0] =0;
        }
        for(int i =1;i<=n1;i++){
            for(int j =1;j<=n2;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                    len = Math.max(len,dp[i][j]);
                }
                else dp[i][j] =0;
            }
        }
        return len;
    }
}