//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.maxScore(a, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static long maxScore(int cardPoints[], int N, int k) {
        int i = 0, j, ans = 0;
        int sum = 0;
        for(j = 0; j < cardPoints.length - k; j++){
            sum += cardPoints[j];
        }
        int totalSum = Arrays.stream(cardPoints).reduce(0, (a,b) -> a+b);
        ans = Math.max(ans, totalSum - sum);

        while(j < cardPoints.length){
            sum -= cardPoints[i++];
            sum += cardPoints[j++];
            ans = Math.max(ans,totalSum - sum);
        }

        return ans;
    }
}
