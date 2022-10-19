class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] a = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int i = 0;
        while(i < k){
            int max = findMax(map);
            a[i++] = max;
            map.remove(max);
        }
        
        return a;
        
    }
    public int findMax(HashMap<Integer, Integer> map){
        int val = -1;
        int max = 0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue() > max){
                val = e.getKey();
                max = e.getValue();
            }
        }
        
        return val;
    }
}