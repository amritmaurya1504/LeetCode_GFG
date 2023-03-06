//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        Node temp = head;
        int zCount = 0, oCount = 0, tCount = 0;
        while(temp != null){
            if(temp.data == 0) zCount++;
            if(temp.data == 1) oCount++;
            if(temp.data == 2) tCount++;
            temp = temp.next;
        }
        
        temp = head;
        for(int i = 0; i < zCount; i++){
            temp.data = 0;
            temp = temp.next;
        }
        for(int i = 0; i < oCount; i++){
            temp.data = 1;
            temp = temp.next;
        }
        for(int i = 0; i < tCount; i++){
            temp.data = 2;
            temp = temp.next;
        }
        return head;
    }
}


