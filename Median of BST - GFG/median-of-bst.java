//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Tree g = new Tree();
                float answer = g.findMedian(root);
                if(answer-(int)answer == 0)
        		    System.out.println((int)answer);
        		else
        		    System.out.println(answer);
                t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Tree
{
    public static void inorderTraversal(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        
        inorderTraversal(root.left, ans);
        ans.add(root.data);
        inorderTraversal(root.right, ans);
    }
    public static float findMedian(Node root)
    {
        ArrayList<Integer> nodeList = new ArrayList<>();
        inorderTraversal(root, nodeList);
        // System.out.println(inorder);
        int n = nodeList.size();
        if (n % 2 == 0) {
            // If the number of nodes is even, median is the average of middle two nodes.
            int midIndex1 = (n / 2) - 1;
            int midIndex2 = n / 2;
            int medianSum = nodeList.get(midIndex1) + nodeList.get(midIndex2);
            return (float) medianSum / 2;
        } else {
            // If the number of nodes is odd, median is the middle node.
            int midIndex = n / 2;
            return nodeList.get(midIndex);
        }
    }
}