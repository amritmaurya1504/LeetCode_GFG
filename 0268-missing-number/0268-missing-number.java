class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int s = 0;
        for(int i : nums) s += i;
        
        return n*(n+1)/2 - s;
    }
}