//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int i = 0, j = 0, ans = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j < s.length()){
            // calculation -> adding charaters to Map
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
            if(map.size() < k){
                j++;   
            }else if(map.size() == k){
                // calculate answer from that;
                ans = Math.max(ans,j - i + 1);
                j++;
            }else if(map.size() > k){
                // remove calculation of i;
                while(map.size() > k){
                    char c = s.charAt(i);
                    map.put(c, map.get(c) - 1);
                    if(map.get(c) == 0) map.remove(c);
                    i++;
                }
                j++;
            }
            
        }
        return ans;
    }
}