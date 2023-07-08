//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
 void dfs(int row, int col, int[][] grid, boolean[][] vis, int[] delRow, int[] delCol){
        vis[row][col] = true;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && 
            vis[nrow][ncol] == false){
                dfs(nrow, ncol, grid, vis, delRow, delCol);
            }
        }
    }
    int numberOfEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};

        boolean[][] visited = new boolean[n][m];

        // traverse first row & last row
        for(int i = 0; i < m; i++){
            // first row
            if(grid[0][i] == 1 && visited[0][i] == false) dfs(0, i, grid, visited, delRow, delCol);

            // last row
            if(grid[n-1][i] == 1 && visited[n-1][i] == false) dfs(n-1, i, grid, visited, delRow, delCol);
        }

        // traverse firs col & last col
        for(int i = 0; i < n; i++){
            // first row
            if(grid[i][0] == 1 && visited[i][0] == false) dfs(i, 0, grid, visited, delRow, delCol);

            // last row
            if(grid[i][m-1] == 1 && visited[i][m-1] == false) dfs(i, m-1, grid, visited, delRow, delCol);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == false) ans++;
            }
        }

        return ans;
    }
}