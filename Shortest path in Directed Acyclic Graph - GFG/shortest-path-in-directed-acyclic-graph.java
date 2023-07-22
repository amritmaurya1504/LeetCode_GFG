//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
//User function Template for Java
class Solution {
    public void toposort(int node, Stack<Integer> st, boolean[] vis, ArrayList<ArrayList<Pair>> adj){
        vis[node] = true;
        
        for(int i = 0; i < adj.get(node).size(); i++){
            int it = adj.get(node).get(i).first;
            if(!vis[it]){
                toposort(it, st, vis, adj);
            }
        }
        
        st.push(node);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
    // STEP-1 Creating an adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        // Intializing empty arraylist
        for(int i = 0; i < N; i++){
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        // Adding edges
        for(int i = 0; i < M; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            adj.get(u).add(new Pair(v, wt));
        }
        
    // STEP-2 Call toposort
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[N];
        for(int i = 0; i < N; i++){
            if(!vis[i]){
                toposort(i, st, vis, adj);
            }
        }
        
    // STEP-3 Pop from stack and relax the edges
        int[] dist = new int[N];
        
        for(int i = 0; i <N; i++){
            dist[i] = (int)1e9;
        }
        
        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            
            for(int i = 0; i < adj.get(node).size(); i++){
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;
                
                if(dist[node] + wt < dist[v]) dist[v] = dist[node] + wt;
            }
        }
        
        for(int i = 0; i < dist.length; i++){
            if(dist[i] == 1e9) dist[i] = -1;
        }
        
        return dist;
	}
}