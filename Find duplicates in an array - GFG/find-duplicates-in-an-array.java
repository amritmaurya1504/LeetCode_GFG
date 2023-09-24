//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
       ArrayList<Integer> vec = new ArrayList<Integer>();
       Set<Integer> st = new HashSet<Integer>();
       Arrays.sort(arr);
       
       for(int i=0;i<n-1;i++){
           if(arr[i]==arr[i+1]){
           vec.add(arr[i]);}
       }
       for(Integer s:vec) st.add(s);
       vec.clear();
       
       for(Integer s:st){ vec.add(s);}
       if(vec.size()==0) vec.add(-1);
       Collections.sort(vec);
       return vec;
    }
}
