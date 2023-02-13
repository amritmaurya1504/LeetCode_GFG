//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] weights, int N, int D) {
    int left=Integer.MIN_VALUE, right=0;
    for(int w : weights) {
        left = Math.max(left , w);
        right += w;
    }
    
    while(left < right) {
        int mid = left + (right-left)/2;
        //   System.out.println("left right mid value is--"+left+" "+right+" "+mid);
        if(isValid(weights, mid) <= D) {
            right= mid;
        } else {
            left = mid+1;
        }
    }
    return left;
}
static int isValid(int[] weights, int target) {
    int total = 0;
    int count = 1;
    for(int w : weights) {
        total+=w;
        if(total > target) {
            count++;
            total = w;
        }
    }
    return count;
}
};