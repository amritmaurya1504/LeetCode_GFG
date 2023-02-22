//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c == '(') st.push(c);
            if(c == ')') st.pop();
            ans = Math.max(st.size(), ans);
        }
        return ans;
    }
}
        
