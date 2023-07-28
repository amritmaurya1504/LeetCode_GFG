//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Tupple{
    int stops;
    int node;
    int cost;
    Tupple(int _stops, int _node, int _cost){
        this.stops = _stops;
        this.node = _node;
        this.cost = _cost;
    }
}
class Pair{
    int node;
    int cost;
    Pair(int _node, int _cost){
        this.node = _node;
        this.cost = _cost;
    }
}
class Solution {
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        Queue<Tupple> q = new LinkedList<>();
        int[] costArr = new int[n];
        Arrays.fill(costArr, (int)1e9);
        costArr[src] = 0;
        q.add(new Tupple(0, src, 0));
        
        // Making Adjacency List
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int m = flights.length;
        for(int it = 0; it < m; it++) {
            int u = flights[it][0];
            int v = flights[it][1];
            int wt = flights[it][2];
            
            adj.get(u).add(new Pair(v, wt));
        }
        
        while(!q.isEmpty()){
            Tupple it = q.peek();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;
            q.remove();
            
            if(stops > k) continue;
            
            for(Pair iter : adj.get(node)){
                int adjNode = iter.node;
                int adjNCost = iter.cost;
                
                if(cost + adjNCost < costArr[adjNode] && stops <= k){
                    costArr[adjNode] = cost + adjNCost;
                    q.add(new Tupple(stops + 1, adjNode, cost + adjNCost));
                }
            }
        }
        
        if(costArr[dst] == (int)1e9) return -1;
        return costArr[dst];
    }
}