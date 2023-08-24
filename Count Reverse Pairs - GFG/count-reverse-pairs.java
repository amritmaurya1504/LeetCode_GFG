//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.countRevPairs(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countPairs(int low, int mid, int high, int [] arr){
        int right = mid + 1;
        int count = 0;
        for(int i = low; i <=mid; i++){
            while(right <= high && arr[i] > 2 * (long)arr[right]) right++;
            count += right - (mid + 1);
        }
        return count;
    }
    public void merge(int l, int m, int r, int[] arr){
        int i = l;
         int j = m + 1;
         ArrayList<Integer> temp = new ArrayList<>();
         
         while(i <= m && j <= r){
             if(arr[i] < arr[j]){
                 temp.add(arr[i]);
                 i++;
             }else{
                 temp.add(arr[j]);
                 j++;
             }
         }
         
         while(i <= m) temp.add(arr[i++]);
         while(j <= r) temp.add(arr[j++]);
         
         for(int it = 0; it < temp.size(); it++){
             arr[it + l] = temp.get(it); 
         }
    }
    public int mergeSort(int low, int high, int[] arr){
        int count = 0;
        if(low < high){
            int mid = (low + high) / 2;
            count += mergeSort(low, mid, arr);
            count += mergeSort(mid + 1, high, arr);
            count += countPairs(low, mid, high, arr);
            merge(low, mid, high, arr);
        }
        return count;
    }
    public int countRevPairs(int N, int arr[]) {
        return mergeSort(0, N - 1, arr);
    }
}