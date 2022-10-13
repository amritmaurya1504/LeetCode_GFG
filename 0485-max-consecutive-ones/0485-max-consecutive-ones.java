class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                count++;
            }else{
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}