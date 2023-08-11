//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends






class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int n, int arr[])
    {
       ArrayList<Integer> tail = new ArrayList<>();
        int len = 0;

        for (int i = 0; i < n; i++) {
            int idx = binarySearch(tail, 0, len - 1, arr[i]);
            if (idx == len) {
                tail.add(arr[i]);
                len++;
            } else {
                tail.set(idx, arr[i]);
            }
        }

        return len;
    }

    static int binarySearch(ArrayList<Integer> tail, int l, int r, int x) {
        while (r >= l) {
            int m = l + (r - l) / 2;
            if (tail.get(m) == x) {
                return m;
            } else if (tail.get(m) < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
} 