//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int nums[], int n)
    {
        // Complete this function
        int l = 0, h = n - 1;
        if(h == 0) return nums[0];
        else if(nums[0] != nums[1]) return nums[0];
        else if(nums[h] != nums[h-1]) return nums[h];
        
        while(l <= h){
            int mid = l + (h-l)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
            
            if((mid%2 == 0 && nums[mid] == nums[mid+1]) || (mid%2 != 0 && nums[mid] == nums[mid-1])) l = mid + 1;
            else h = mid - 1;
        }
         return -1;
    }
}