//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < pat.length(); i++){
            map.put(pat.charAt(i),map.getOrDefault(pat.charAt(i),0) + 1);
        }
        
        int i = 0, j = 0, charRemain = map.size();
        int k = pat.length();
        int ans = 0;
        
        while(j < txt.length()){
            // doing calculation
            char c = txt.charAt(j);
            if(map.containsKey(c)){
                map.put(c,map.get(c) - 1);
                if(map.get(c) == 0) charRemain--;
            }
            
            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k){
                // finding answer from calculation
                if(charRemain == 0) ans++;
                char ch = txt.charAt(i);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) == 1) charRemain++;
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}