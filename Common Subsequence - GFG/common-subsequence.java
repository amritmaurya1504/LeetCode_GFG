//{ Driver Code Starts

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String a = sc.next ();
            String b = sc.next ();
            
            if (new Sol().commonSubseq(a, b))
                System.out.println (1);
                
            else
                System.out.println (0);
    		   
        }
        
    }
}

// Contributed By: Pranay Bansal


// } Driver Code Ends



class Sol
{
    Boolean commonSubseq (String a, String b)
    {
        Set<Character> s = new HashSet<>();
        for(int i = 0; i < a.length(); i++){
            s.add(a.charAt(i));
        }     
        for(int i = 0; i < b.length(); i++){
            if(s.contains(b.charAt(i))) return true;
        }
        
        return false;
    }
}