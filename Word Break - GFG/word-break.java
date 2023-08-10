//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int helper(int ind, String s, List<String> wordDict){
        if(ind == s.length()) return 1;
        // if(dp[ind] != -1) return dp[ind];
        String temp= "";
        for(int j = ind; j < s.length(); j++){
            temp += s.charAt(j);
            if(wordDict.contains(temp)){
                if(helper(j + 1, s, wordDict) == 1) return 1;
            }
        }

        return 0;
    }
    public static int wordBreak(String s, ArrayList<String> wordDict )
    {
        return helper(0, s, wordDict);
    }
}