//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int r;
    int c;
    int t;
    Pair(int r, int c, int t){
        this.r = r;
        this.c = c;
        this.t = t;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;

        int ans_time = 0;
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][m]; // to mark roten oranges
        int cntFreash = 0; // Counting Freash orange

        // travers in grid to find out possible position of rotten orange and also count freash oranges
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }else if(grid[i][j] == 1){
                    cntFreash++;
                }else{
                    visited[i][j] = 0;
                }
            }
        }

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        int cnt = 0; // keep track of rotten orange
        // BFS Traversal
        while(!q.isEmpty()){
            int row = q.peek().r;
            int col = q.peek().c;
            int time = q.peek().t;
            ans_time = Math.max(ans_time, time);
            q.remove();
            // now i have to check for neighbours in four directions
            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && 
                grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow, ncol, time + 1));
                    visited[nrow][ncol] = 2;
                    cnt++;
                }   
            }
        }
        
        if(cnt != cntFreash) return -1;
        return ans_time;
    }
}