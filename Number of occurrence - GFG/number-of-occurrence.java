//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int firstOccurance(int l, int h, int[]  arr, int target){
        int res = -1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(target == arr[mid]){
                res = mid;
                h = mid - 1;
            }else if(target < arr[mid]) h = mid - 1;
            else l = mid + 1;
        }
        return res;
    }
    int lastOccurance(int l, int h, int[]  arr, int target){
        int res = -1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(target == arr[mid]){
                res = mid;
                l = mid + 1;
            }else if(target < arr[mid]) h = mid - 1;
            else l = mid + 1;
        }
        return res;
    }
    int count(int[] arr, int n, int x) {
        int l = 0, h = n - 1;
        
        int lastIndex = lastOccurance(l,h,arr,x);
        int firstIndex = firstOccurance(l,h,arr,x);
        if(firstIndex == -1 && lastIndex == -1) return 0;
        
        return lastIndex - firstIndex + 1;
    }
}