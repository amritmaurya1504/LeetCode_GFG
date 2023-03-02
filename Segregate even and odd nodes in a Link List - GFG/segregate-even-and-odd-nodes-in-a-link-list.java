//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
	static void printList(Node node, PrintWriter out) 
	{ 
		while (node != null) 
		{ 
			out.print(node.data + " "); 
			node = node.next; 
		} 
		out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans, out); 
            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


//User function Template for Java

/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}

7
17 15 8 9 2 4 6
*/

class Solution{
    Node divide(int N, Node head){
        Node oddList = null,o = null;
        Node evenList = null,e = null;
        // here head pointer is moving
        while(head != null){
            // Check if odd number
            if(head.data%2 != 0){
                // check if oddList is null or not it means this is first time we get any odd or not
                if(oddList == null){
                    oddList = head;
                    o = oddList;
                }else{
                    o.next = head;
                    o = head;
                }
            }else if (head.data % 2 == 0){ //check for even
                if(evenList == null){
                    evenList = head;
                    e = evenList;
                }else{
                    e.next = head;
                    e = head;
                }
            }
            
            head = head.next;
        }
        if(o != null){
            o.next = null;
        }
        if(e != null){
            e.next = oddList;
        }
        if(evenList != null){
            return evenList;
        }
        
        return oddList;
    }
}