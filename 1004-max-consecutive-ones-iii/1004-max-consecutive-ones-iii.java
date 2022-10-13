class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;

        int count = 0;

        int j = -1;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 0 ){

                count ++;

            }

            while(count > k){

                j++;

                if(nums[j] == 0){

                    count--;

                }

            }

            int len = i-j;

            max = Math.max(max,len);

        }

        return max;
    }
}