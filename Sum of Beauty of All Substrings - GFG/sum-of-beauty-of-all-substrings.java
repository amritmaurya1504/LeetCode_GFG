//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.beautySum(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    private static int getMinCount(int[] charCount) {
        int min = Integer.MAX_VALUE;
		
        for (int i = 0; i < charCount.length; ++i) {
            if (charCount[i] != 0) {
                min = Math.min(min, charCount[i]);
            }
        }
		
        return min;
    }
    
    private static int getMaxCount(int[] charCount) {
        int max = 0;
		
        for (int i = 0; i < charCount.length; ++i) {
            max = Math.max(max, charCount[i]);
        }
		
        return max;
    }
    public static int beautySum(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            int[] freq = new int[26];
            for(int j = i; j < n; j++){
                ++freq[s.charAt(j) - 'a'];
                int beauty = getMaxCount(freq) - getMinCount(freq);
                ans += beauty;
            }
        }
        return ans;
    }
}
        
