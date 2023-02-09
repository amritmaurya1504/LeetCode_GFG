//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int h) {
        int left=1, right=0;
        for(int i=0; i<piles.length; i++){
            right = Math.max(right,piles[i]);
        }
        while(left<right){
            int mid = (left+right)/2;
            int hour = 0;
            for(int i=0; i<piles.length; i++){
                hour += (piles[i]%mid==0) ? piles[i]/mid : piles[i]/mid + 1;
            }
            if(hour <= h){
                right = mid;
            } else left = mid+1;
        }
        return right;
    }
}
        
