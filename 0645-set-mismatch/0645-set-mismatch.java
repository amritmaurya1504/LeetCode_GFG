class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Set<Integer> s = new HashSet<>();
        
        for(int i : nums){
            if(!s.contains(i)){
                s.add(i);
            }else{
                res[0] = i;
            }
        }
       
        for(int i = 0; i<nums.length; i++){
            if(!s.contains(i+1)){
                res[1] = i+1;
            }
        }
       
        return res;
    }
}