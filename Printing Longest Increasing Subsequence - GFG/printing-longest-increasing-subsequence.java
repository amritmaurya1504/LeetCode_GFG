//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     public ArrayList<Integer> longestIncreasingSubsequence(int N, int arr[]){
        // Code here
        // Time complexity O(nlogn);
        ArrayList<Integer> list=new ArrayList<>();
        int dp[]=new int[N];
        dp[N-1]=1;
        list.add(arr[N-1]);
        for(int i=N-2;i>=0;i--){
            int m=list.size();
            if(arr[i]<list.get(m-1)){
                dp[i]=m+1;
                list.add(arr[i]);
            }
            else{
                int ind=lower_bound(list,0,m-1,arr[i]);
                dp[i]=ind+1;
                list.set(ind,arr[i]);
            }
        }
        int ans=list.size();
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<N;i++){
            if(dp[i]==ans){
                res.add(arr[i]);
                ans--;
            }
        }
        return res;
    }
    public int lower_bound(ArrayList<Integer> arr,int l,int h,int key){
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr.get(mid)<=key){
                ans=mid;
                h=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}
