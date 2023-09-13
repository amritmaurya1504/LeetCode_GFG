//{ Driver Code Starts
import java.util.*; 
import java.lang.*;
import java.io.*;




class Array
 {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0)
	    {
	    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i] = sc.nextInt();
		    }
		    int sum = sc.nextInt();
		    Solution ob=new Solution();
		    System.out.println(ob.subArraySum(arr,n,sum));
		}
	}
}


// } Driver Code Ends


class Solution
{ 
    public static int subArraySum(int[] arr, int n, int k)
    { 
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0;
        int preffixSum = 0;
        for(int i = 0; i < n; i++){
            preffixSum += arr[i];
            
            if(map.containsKey(preffixSum - k)){
                cnt += map.get(preffixSum - k);
            }
            
            map.put(preffixSum, map.getOrDefault(preffixSum, 0) + 1);
        }
        
        return cnt;
    }
}
  