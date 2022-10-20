class Solution {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        int i = N - 2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        
        if(i>=0){
            int j = N - 1;
        while(nums[j] <= nums[i]) j--;
        swap(nums,i,j);
        }
        
        reverse(nums,i+1,N-1);
        
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void reverse(int[] arr, int i, int j){
        while(i < j) swap(arr,i++,j--);
    }
}