class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        
        for(int i : nums) sum+=i;
        
        if((sum + target)%2 != 0) return 0;
        
        int val = (sum+target)/2;
        if(val < 0) return 0;
        int[][] dp = new int[n+1][val+1];
        
        for(int i = 0; i <n+1; i++){
            for(int j = 0; j<val+1;j++){
                if(i == 0) dp[i][j] = 0;
                if(j == 0) dp[i][j] = 1;
            }
        }
        dp[0][0] = 1;
        for(int i = 1; i<n+1; i++){
            for(int j = 0; j<val+1; j++){
                if(nums[i-1] <= j) dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][val];
    }
}