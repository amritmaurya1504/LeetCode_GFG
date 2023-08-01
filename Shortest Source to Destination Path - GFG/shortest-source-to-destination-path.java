//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Tupple{
    int steps;
    int row;
    int col;
    Tupple(int _steps, int _row, int _col){
        this.steps = _steps;
        this.row = _row;
        this.col = _col;
    }
}
class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if(A[0][0] == 0) return -1;
        if(A[X][Y] == 0) return -1;
        if(X == 0 && Y == 0) return 0;
        
        Queue<Tupple> q = new LinkedList<>();
        q.add(new Tupple(0, 0, 0));
        int[][] dist = new int[N][M];
        for(int[] it : dist){
            Arrays.fill(it, (int)1e9);
        }
        dist[0][0] = 0;
        
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        while(!q.isEmpty()){
            Tupple tp = q.peek();
            int steps = tp.steps;
            int row =tp.row;
            int col = tp.col;
            q.remove();
            
            if(row == X && col == Y) return steps;
            
            for(int i = 0; i < 4; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                
                if(nrow >= 0 && nrow < N && ncol >= 0 && ncol < M && dist[row][col] + 1 < dist[nrow][ncol] &&
                A[nrow][ncol] != 0){
                    dist[nrow][ncol] = 1 + dist[row][col];
                    q.add(new Tupple(steps + 1, nrow, ncol));
                }
            }
        }
        
        return -1;
    }
};