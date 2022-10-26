class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
      int[] prefixSum = new int[nums.length+1];
        int sum = 0;
        for(int i=1;i<=nums.length;i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        
        Set<Integer> hashSet = new HashSet<>();
        
        for(int i=2;i<=nums.length;i++) {
            hashSet.add(prefixSum[i-2]%k);
            if(hashSet.contains(prefixSum[i]%k)) return true;
        }
        
        return false;
    }
}