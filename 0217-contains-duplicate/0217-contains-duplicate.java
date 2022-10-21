class Solution {
    public boolean containsDuplicate(int[] nums) {
         int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}