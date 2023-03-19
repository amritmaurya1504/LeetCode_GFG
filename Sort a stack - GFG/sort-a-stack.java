//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		sortStack(s);
		return s;
	}
	public static void sortStack(Stack<Integer> st){
        if(st.size() == 1) return;

        // pop last element from the stack inorder to decrease the size in other word to small input;
        int temp = st.pop();
        sortStack(st);
        insert(st, temp);
    }
    public static void insert(Stack<Integer> st, int temp){
        if(st.size() == 0 || st.peek() < temp){
            st.push(temp);
            return;
        }

        int val = st.peek();
        st.pop();
        insert(st, temp);
        st.push(val);
    }
}

