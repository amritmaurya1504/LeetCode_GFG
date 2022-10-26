class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        
        Arrays.sort(nums);
        int ans = 1;
        int count = 1;
        int prev = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == prev+1){
                count++;
            }else if(nums[i] != prev){
                count = 1;
            }
            prev = nums[i];
            ans = Math.max(ans,count);
        }
        
        return ans;
    }
}