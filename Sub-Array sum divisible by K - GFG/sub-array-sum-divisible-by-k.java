//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    long subCount(long nums[] ,int n,int k)
    {
        
         HashMap<Long, Integer> map = new HashMap<>(); // gonna store rem -> count
        map.put((long)0, 1);
        long preffixSum = 0;
        long ans = 0;

        for(int i = 0; i < nums.length; i++){
            preffixSum += nums[i];

            long rem = preffixSum % k;

            // if we don't do this we will going to miss some valid subarrays so we donot store negative remainders instead what we are going to do is add k to remiander 
            // suppose 7*n - 4 we can also write this 7*n - 4 + 7 - 7 => 7(n-1) + 3; here 3 is remainder    
            if(rem < 0){
                rem += k;
            }

            if(map.containsKey(rem)){
                ans += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return ans;
        
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
    //        int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);
            //int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[]=new long[n];
            for(int i=0;i<n;i++)
            {
                a[i]=Long.parseLong(a1[i]);
            }
            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.subCount(a,n,k);
            System.out.println(ans);
        }
    }
}






// } Driver Code Ends