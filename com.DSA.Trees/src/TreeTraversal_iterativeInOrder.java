import java.util.Stack;

public class TreeTraversal_iterativeInOrder {
    Node Root;

    public TreeTraversal_iterativeInOrder(Node Root){
        this.Root=Root;
    }
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    public void InOrderTraversalGPT(Node root) {
        if (root==null)
            return;
        Stack<Node> s=new Stack<Node>();
        Node current=root;
        while (current!=null || !s.isEmpty()){
            while(current!=null){
                s.push(current);
                current=current.left;
            }
            current=s.pop();
            System.out.print(current+",");
            current=current.right;
        }
    }


    public void InOrderTraversal(Node root) {
        if (root == null)
            return;

        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            while (s.peek().left != null) {
                s.push(s.peek().left);

            }
            System.out.print(s.peek().data + ",");
            while (s.peek().right != null) {
                s.push(s.peek().right);
            }
            s.pop();
            if(s.isEmpty())
                return;
            System.out.print(s.peek().data + ",");
            Node temp = s.pop();
            s.push(temp.right);
        }

    }

    public static void main(String[] args) {
        TreeTraversal_iterativeInOrder inOrder=new TreeTraversal_iterativeInOrder(new Node(1));
        inOrder.Root.left=new Node(2);
        inOrder.Root.right=new Node(3);
        inOrder.Root.left.left=new Node(4);
        inOrder.Root.left.right=new Node(5);
        inOrder.Root.left.right.left=new Node(6);
        inOrder.Root.left.right.right=new Node(7);
        inOrder.InOrderTraversal(inOrder.Root);
    }



}
