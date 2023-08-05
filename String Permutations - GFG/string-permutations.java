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
    public void helper_fun(String s, boolean[] map, ArrayList<String> ans, StringBuilder temp){
        if(temp.length() >= s.length()){
            ans.add(temp.toString());
            return;
        }
        
        for(int i = 0; i < map.length; i++){
            if(map[i] == false){
                temp.append(s.charAt(i));
                map[i] = true;
                helper_fun(s, map, ans, temp);
                map[i] = false;
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
    public ArrayList<String> permutation(String S)
    {
        ArrayList<String> ans = new ArrayList<>();
        boolean[] map = new boolean[S.length()];
        helper_fun(S, map, ans, new StringBuilder());
        Collections.sort(ans);
        return ans;
    }
	   
}
