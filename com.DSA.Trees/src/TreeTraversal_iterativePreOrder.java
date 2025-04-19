import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}



public class TreeTraversal_iterativePreOrder {

    //using Stack
    public static void preOrderTraversalStack(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<Node>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");

            if (current.right != null)
                stack.add(current.right);

            if (current.left != null)
                stack.add(current.left);
        }
    }
    //using Deque
    public static void preOrderTraversal(Node root) {
        if (root == null)
            return;

        Deque<Node> queue = new ArrayDeque<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.pollLast();
            System.out.print(current.data + " ");

            if (current.right != null)
                queue.add(current.right);

            if (current.left != null)
                queue.add(current.left);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print("Pre-order traversal: ");
        preOrderTraversalStack(root);
    }
}
