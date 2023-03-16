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

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        int i = 0, j = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(j < fruits.length){
            int cf = fruits[j];
            map.put(cf, map.getOrDefault(cf, 0) + 1);

            while(map.size() > 2){
                map.put(fruits[i], map.get(fruits[i]) - 1);
                if(map.get(fruits[i]) == 0) map.remove(fruits[i]);
                i++;
            }

            // answer
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}