//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int calculateSum(int[] nums, int d) {
    int sum = 0;
    for (int j = 0; j < nums.length; j++) {
      boolean bool = nums[j] % d == 0;
      sum += bool ? nums[j] / d : nums[j] / d + 1;
    }
    return sum;
     }
      public int smallestDivisor(int[] nums, int threshold) {
    int ans = -1;
    int low = 1, high = 0;
    //   calculating maximum in array
    for (int i = 0; i < nums.length; i++) {
      high = Math.max(high, nums[i]);
    }

    while (low < high) {
      int mid = (low + high) / 2;
      int sum = calculateSum(nums, mid);
      if (sum <= threshold) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return high;
  }
}