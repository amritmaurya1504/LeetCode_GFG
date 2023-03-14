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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s){
        // code here
         int i = 0, j = 0, ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
            if(map.size() == (j - i + 1)){
                ans = Math.max(ans, j - i + 1);
                j++;
            }else if(map.size() < (j - i + 1)){
                while(map.size() < (j - i + 1)){
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