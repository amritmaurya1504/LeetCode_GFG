import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
    }
}
class Pair{
    int num;
    Node node;
    Pair(Node node, int num){
        this.num = num;
        this.node = node;
    }
}

class PreInPostTraversal{

    public static Node createTree(){
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.println("Enter Data : " );
        int data = sc.nextInt();
        if(data == -1) return null;
        root = new Node(data);
        System.out.println("Enter data left of " + data);
        root.left = createTree();
        System.out.println("Enter data right of " + data);
        root.right = createTree();

        return root;

    }

    public static void preInPostTraversalfun(Node root){
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));

        if(root == null) return;

        while (!st.isEmpty()){
            Pair it = st.pop();

            if(it.num == 1){
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.left != null){
                    st.push(new Pair(it.node.left, 1));
                }
            }else if(it.num == 2){
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.right != null){
                    st.push(new Pair(it.node.right, 1));
                }
            }else{
                post.add(it.node.data);
            }
        }
        System.out.println("PreOrder");
        System.out.println(pre);
        System.out.println("InOrder");
        System.out.println(in);
        System.out.println("PostOrder");
        System.out.println(post);

    }

    public static void main(String[] args) {
        Node root = createTree();
        preInPostTraversalfun(root);
    }
}