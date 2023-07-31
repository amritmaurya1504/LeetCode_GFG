//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int node;
    int wt;
    Pair(int _node, int _wt){
        this.node = _node;
        this.wt = _wt;
    }
}
class Tupple{
    int wt;
    int node;
    int parent;
    Tupple(int _wt, int _node, int _parent){
        this.wt = _wt;
        this.node = _node;
        this.parent = _parent;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i = 0; i < V; i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i = 0; i < E; i++){
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        
	        adj.get(u).add(new Pair(v, wt));
	        adj.get(v).add(new Pair(u, wt));
	    }
	    
	    Queue<Tupple> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
	    boolean[] visited = new boolean[V];
	    pq.add(new Tupple(0, 0, -1));
	    
	    int ans = 0;
	    
	    while(!pq.isEmpty()){
	        Tupple tp = pq.peek();
	        int wt = tp.wt;
	        int node = tp.node;
	        pq.remove();
	        
	        if(visited[node]) continue;
	        
	        visited[node] = true;
	        ans += wt;
	        
	        for(int i = 0; i < adj.get(node).size(); i++){
	            int edjWt = adj.get(node).get(i).wt;
	            int adjNode = adj.get(node).get(i).node;
	            
	            if(!visited[adjNode]){
	                pq.add(new Tupple(edjWt, adjNode, node));
	            }
	        }
	    }
	    
	    return ans;
	}
}