//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] A)
    {
         int row = A.length, col = A[0].length;
    int top = 0, bottom = row - 1, left = 0, right = col - 1;
    int direction = 0;
    /*
	     0 = left to right
	     1 = top to bottom
	     2 = right to left
	     3 = bottom to top
	    */
    ArrayList<Integer> spiralMatrix = new ArrayList<>();

    while (top <= bottom && left <= right) {
      if (direction == 0) {
        for (int i = left; i <= right; i++) {
          spiralMatrix.add(A[top][i]);
        }
        direction = 1;
        top++;
      } else if (direction == 1) {
        for (int i = top; i <= bottom; i++) {
          spiralMatrix.add(A[i][right]);
        }
        direction = 2;
        right--;
      } else if (direction == 2) {
        for (int i = right; i >= left; i--) {
          spiralMatrix.add(A[bottom][i]);
        }
        direction = 3;
        bottom--;
      } else if (direction == 3) {
        for (int i = bottom; i >= top; i--) {
          spiralMatrix.add(A[i][left]);
        }
        direction = 0;
        left++;
      }
    }
    Collections.reverse(spiralMatrix);
    int[] ans = new int[spiralMatrix.size()];
    int k = 0;
    for(int i : spiralMatrix){
        ans[k++] = i;
    }
    return ans;
    }
}