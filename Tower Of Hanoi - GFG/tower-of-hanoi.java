//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}






// } Driver Code Ends




// User function Template for Java


// avoid space at the starting of the string in "move disk....."
class Hanoi {

    public long toh(int N, int from, int to, int aux) {
        long count =1;

        if(N==0){

            return 0;

        }

        //moving n-1 disk from 1 to 2

        count+=toh(N-1,from,aux,to);

        //moving disk n from 1 to 3

        System.out.println("move disk "+N+" from rod "+ from +" to rod "+ to);

        //moving n-1 disk from 2 to 

        count+=toh(N-1,aux,to,from);

        return count;
    }
}
