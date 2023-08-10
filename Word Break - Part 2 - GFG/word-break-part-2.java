//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.stream.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String arr[] = in.readLine().trim().split("\\s+");
            List<String> dict = new ArrayList<String>();
            for(int i = 0;i < n;i++)
                dict.add(arr[i]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.wordBreak(n, dict, s);
            if(ans.size() == 0)
                System.out.println("Empty");
            else{
                List<String> sol = ans.stream().sorted().collect(Collectors.toList());
                for(int i = 0;i < sol.size();i++)
                    System.out.print("("+sol.get(i)+")");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static void helper(int start, String s, List<String> wordDict, StringBuilder tempBuilder, List<String> ans){
        
        if(start == s.length()){
            ans.add(tempBuilder.toString().trim());
            return;
        }

        for(int end = start; end < s.length(); end++){
            String word = s.substring(start, end + 1);
            if(wordDict.contains(word)){
                tempBuilder.append(word).append(" ");
                helper(end + 1, s, wordDict, tempBuilder, ans);
                tempBuilder.delete(tempBuilder.length() - word.length() - 1, tempBuilder.length());
            }
        }   
        return;
    }
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        List<String> ans = new ArrayList<>();
        StringBuilder tempBuilder = new StringBuilder();
        helper(0, s, dict, tempBuilder, ans);
        return ans;
    }
}