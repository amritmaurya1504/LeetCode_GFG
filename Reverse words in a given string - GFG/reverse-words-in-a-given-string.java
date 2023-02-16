//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends

// import java.util.StringTokenizer;

class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        StringTokenizer st = new StringTokenizer(S, ".");
        String strReversedLine = " ";
        int i = 0;
        while(st.hasMoreTokens()){
            if(i == 0){
                strReversedLine = st.nextToken();
            }else{
                strReversedLine = st.nextToken() + "." + strReversedLine;
            }
            i++;
        } 
        return strReversedLine;
    }
}