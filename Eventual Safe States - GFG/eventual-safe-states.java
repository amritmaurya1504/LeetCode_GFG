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
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean isCycle_dfs(int node, List<List<Integer>> adj, boolean[] visited,
    boolean[] pathVisited, boolean[] check){
        visited[node] = true;
        pathVisited[node] = true;
        check[node] = false;
        
        for(int it : adj.get(node)){
            if(!visited[it]){
                if(isCycle_dfs(it, adj, visited, pathVisited, check)) return true;
            }else if(pathVisited[it]){
                return true;
            }
        }
            
        check[node] = true;
        pathVisited[node] = false;
        return false;
    }
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] check = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                isCycle_dfs(i, adj, visited, pathVisited, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0; i < check.length; i++){
            if(check[i]) safeNodes.add(i);
        }
        return safeNodes;
    }
}
