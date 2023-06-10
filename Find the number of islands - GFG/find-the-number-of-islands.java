//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
     public void bfs(int row, int col, boolean[][] vis, char[][] grid){
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            int ro = q.peek().first;
            int co = q.peek().second;
            q.remove();

            // traverse in the neighbours and mark them if it is visited
            for(int delRow = -1; delRow <= 1; delRow++ ){
                for(int delCol = -1; delCol <= 1; delCol++){
                    int nRow = ro + delRow;
                    int nCol = co + delCol;

                    if((nRow >= 0 && nRow < n) && (nCol >= 0 && nCol < m) && (vis[nRow][nCol] == false) && 
                    (grid[nRow][nCol] == '1')){
                        vis[nRow][nCol] = true;
                        q.add(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
         int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        boolean[][] vis = new boolean[n][m];
        
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(!vis[row][col] && grid[row][col] == '1'){
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }
}