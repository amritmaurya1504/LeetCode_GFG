//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

     void dfs(int row, int col, int[][] grid, boolean[][] vis, ArrayList<ArrayList<Integer>> list, int baseRow, int baseCol){
        vis[row][col] = true;
        int r  = row - baseRow;
        int c = col - baseCol;
        ArrayList<Integer> li = new ArrayList<>();
        li.add(r);
        li.add(c);
        list.add(li);

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nR = row + delRow[i];
            int nC = col + delCol[i];

            if(nR >= 0 && nR < grid.length && nC >= 0 && nC < grid[0].length && !vis[nR][nC] && grid[nR][nC] == 1){
                vis[nR][nC] = true;
                dfs(nR, nC, grid, vis, list, baseRow, baseCol);
            }
        }
    }

    int solution(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<ArrayList<Integer>>> st = new HashSet<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                    dfs(i, j, grid, vis, list, i, j);
                    st.add(list);
                }
            }
        }
// time complexity : n X m + log(n X m) + n x m x 4
        return st.size();
    }
    
    
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        
       return  solution(grid);
       
    }
}
