import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPost_Order_Iterative {
    Node Root;

    public PreInPost_Order_Iterative(Node Root){
        this.Root=Root;
    }

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
        }
    }
    public static void main(String[] args) {
       Node n=new Node(1);
        PreInPost_Order_Iterative p=new PreInPost_Order_Iterative(n);
        p.Root.left=new Node(2);
        p.Root.right=new Node(5);
        p.Root.left.left=new Node(3);
        p.Root.left.right=new Node(4);
        p.Root.right.left=new Node(6);
        p.Root.right.right=new Node(7);

        preInPost_One_IterativeGPT1(p.Root);
    }

    public static void preInPost_One_IterativeGPT1(Node root){

        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
               // System.out.print(curr.data + " "); // Preorder traversal
                curr = curr.left;
            }

            curr = stack.pop();

            // Inorder traversal
         //  System.out.print(curr.data + " ");

            curr = curr.right;

            // Postorder traversal
           System.out.print(curr.data + " ");
        }
    }


    public static void preInPost_One_IterativeGPT(Node root){
        List<Node> preOrder=new ArrayList<Node>();
        List<Node> InOrder=new ArrayList<Node>();
        List<Node> postOrder=new ArrayList<Node>();
        if (root==null)
            return;

        Stack<Node> s=new Stack<Node>();
        Node curr=root;

        while (curr!=null || !s.isEmpty()){
            while (curr!=null){
                s.push(curr);
                preOrder.add(curr);
                System.out.println("preOrder="+curr.data);
                curr=curr.left;
            }
            curr=s.pop();
            System.out.println("InOrder="+curr.data);
            InOrder.add(curr);

            curr=curr.right;
            System.out.println("postOrder="+curr);
            postOrder.add(curr);
        }
    }
    public static void preInPost_One_Iterative(Node root,int num){
        if (root==null)
            return;

        List<Node> preOrder=new ArrayList<Node>();
        List<Node> InOrder=new ArrayList<Node>();
        List<Node> postOrder=new ArrayList<Node>();
        Stack<Node> s=new Stack<Node>();

        Node curr=root;

        while (curr!=null || !s.isEmpty()) {
            if(num==4)
                num=num-2;
           else if (curr != null) {
                s.push(curr);
                num = 1;
            } else {
                curr = s.peek();
            }

            if (num == 1) {
                preOrder.add(curr);
                num++;
                curr = curr.left;
            } else if (num == 2) {
                InOrder.add(curr);
                num++;
                curr = curr.right;

            } else if (num == 3) {
                postOrder.add(curr);
                s.pop();
                curr=s.peek();
                num++;
            }

        }
    }

}
