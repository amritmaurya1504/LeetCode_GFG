//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void dfs(int row, int col, char[][] board, int[][] vis, int[] delRow, int[] delCol){
        vis[row][col] = 1;

        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && board[nrow][ncol] == 'O' && 
            vis[nrow][ncol] != 1){
                dfs(nrow, ncol, board, vis, delRow, delCol);
            }
        }
    }
    static char[][] fill(int n, int m, char board[][])
    {

        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};

        int[][] visited = new int[n][m];

        // traverse first row & last row
        for(int i = 0; i < m; i++){
            // first row
            if(board[0][i] == 'O' && visited[0][i] == 0) dfs(0, i, board, visited, delRow, delCol);

            // last row
            if(board[n-1][i] == 'O' && visited[n-1][i] == 0) dfs(n-1, i, board, visited, delRow, delCol);
        }

        // traverse firs col & last col
        for(int i = 0; i < n; i++){
            // first row
            if(board[i][0] == 'O' && visited[i][0] == 0) dfs(i, 0, board, visited, delRow, delCol);

            // last row
            if(board[i][m-1] == 'O' && visited[i][m-1] == 0) dfs(i, m-1, board, visited, delRow, delCol);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
        
        return board;
    }
}