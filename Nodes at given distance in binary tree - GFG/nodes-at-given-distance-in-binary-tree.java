//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    static Queue<Node> find;
    public static void markParent(Node root, HashMap<Node, Node> parent_Track){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.left != null){
                parent_Track.put(curr.left,curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                parent_Track.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
    }
    public static boolean findNode(Node node, int target){
        if(node == null) return false;
        if(node.data == target) find.offer(node);
        findNode(node.left,target);
        findNode(node.right,target);
        
        return false;
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // Mark Parent Pointer
        HashMap<Node, Node> parent_Track = new HashMap<>();
        markParent(root,parent_Track);
        // Search For target Node;
        find = new LinkedList<>();
        findNode(root,target);
        Node target_node = find.poll();
        // K Distance
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Boolean> visited = new HashMap<>();
        int dist = 0;
        q.offer(target_node);
        visited.put(target_node,true);
        while(!q.isEmpty()){
            int size = q.size();
            if(dist == k) break;
            dist++;
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    visited.put(curr.left,true);
                    q.offer(curr.left);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    visited.put(curr.right,true);
                    q.offer(curr.right);
                }
                if(parent_Track.get(curr) != null && visited.get(parent_Track.get(curr)) == null){
                    q.offer(parent_Track.get(curr));
                    visited.put(parent_Track.get(curr),true);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            Node node = q.poll();
            ans.add(node.data);
        }
        Collections.sort(ans);
        return ans;
    }
};