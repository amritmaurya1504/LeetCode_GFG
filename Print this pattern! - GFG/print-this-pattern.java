//{ Driver Code Starts
//Initial Template for Java//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N =sc.nextInt();
		
            Solution ob = new Solution();
         
            ob.printPattern(N);
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    void printPattern(int N){
        // code here

        int n=(N*2)-1;
        int arr[]=new int[n];
        Arrays.fill(arr,N);
        print(arr);
        for(int i=1;i<N;i++)
        {
            int l=i,r=(n-i)-1;
            while(l<=r)
            {
                if(l==r)
                {
                    arr[l++]-=1;
                    break;
                }
                arr[l++]-=1;
                arr[r--]-=1;
            }
            print(arr);
        }
        
        for(int i=N-1;i>0;i--)
        {
            int l=i,r=(n-i)-1;
            while(l<=r)
            {
                if(l==r)
                {
                    arr[l++]+=1;
                    break;
                }
                arr[l++]+=1;
                arr[r--]+=1;
            }
            print(arr);
        }
       
    }
    void print(int []arr)
    {
        for(int i:arr)
        System.out.print(i);
        System.out.println();
    }
}