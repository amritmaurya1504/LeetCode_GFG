//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String s)
    {
        //Your code here
        int n = s.length();
        int[] map = new int[n];
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(s, sb, ans, map);
        
        Collections.sort(ans);
        return ans;
        
    }
    
    private void solve(String s, StringBuilder sb,  ArrayList<String> ans,int map[]){
        if(sb.length() == s.length()){
            ans.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(map[i] == 0){
                map[i] = 1;
                sb.append(s.charAt(i));
                solve(s, sb, ans, map);
                sb.deleteCharAt(sb.length() -1);
                map[i] = 0;
            }
          
        }
    }
	   
}
