//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        int i = 0, j = 0, ans = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(j < S.length()){
            map.put(S.charAt(j), map.getOrDefault(S.charAt(j), 0) + 1);
            
            if(map.size() == j - i + 1){
                ans = Math.max(ans, j - i + 1);
                j++;
            }else if(map.size() < j - i + 1){
                while(map.size() < j - i + 1){
                    char c = S.charAt(i);
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