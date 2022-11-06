//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int a[][], int n, int m, int k)
	{
	    List<Integer> ls = new ArrayList<>();
	    int l = 0, r = m-1, t = 0, b = n-1;
	    int d = 0;
	    
	    while(l <= r && t <= b){
	        if(d == 0){
	            for(int i = l; i <= r; i++){
	                ls.add(a[t][i]);
	            }
	                d = 1; t++;
	        }else if(d == 1){
	            for(int i = t; i <= b; i++){
	                ls.add(a[i][r]);
	            }
	            d = 2; r--;
	        }else if(d == 2){
	            for(int i = r; i>=l; i--){
	                ls.add(a[b][i]);
	            }
	            d = 3; b--;
	        }else if(d==3){
	            for(int i = b; i >=t; i--){
	                ls.add(a[i][l]);
	            }
	            d = 0; l++;
	        }
	    }
	    
	    return ls.get(k-1);
	}
	
}