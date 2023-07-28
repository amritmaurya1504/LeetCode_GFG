//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class Tupple{
    int diff;
    int row;
    int col;
    Tupple(int _diff, int _row, int _col){
        this.diff = _diff;
        this.row = _row;
        this.col = _col;
    }
}
class Solution {
    int MinimumEffort(int heights[][]) {
        int n = heights.length;
        int m = heights[0].length;
        Queue<Tupple> pq = new PriorityQueue<>((a,b) -> a.diff - b.diff);
        int[][] effort = new int[n][m];
        for(int[] it : effort) Arrays.fill(it , (int)1e9);
        pq.add(new Tupple(0, 0, 0));
        effort[0][0] = 0;
        
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        
        while(!pq.isEmpty()){
            Tupple it = pq.peek();
            int diff = it.diff;
            int r = it.row;
            int c = it.col;
            pq.remove();
            
            if(r == n - 1 && c == m - 1) return diff;
            
            for(int i = 0; i < 4; i++){
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                    int newEffort = Math.max(Math.abs(heights[nrow][ncol] - heights[r][c]), diff);
                    if(newEffort < effort[nrow][ncol]){
                        effort[nrow][ncol] = newEffort;
                        pq.add(new Tupple(newEffort, nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }
}