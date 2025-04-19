import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTest {
    Node Root;

    public TreeTest(Node Root) {
        this.Root = Root;
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        TreeTest t = new TreeTest(n);

        t.Root.left = new Node(2);
        t.Root.right = new Node(3);
        t.Root.left.left = new Node(4);
        t.Root.left.right = new Node(5);
        t.Root.left.right.left = new Node(6);
        t.Root.left.right.right = new Node(7);
        t.Root.right.left = new Node(8);
        t.postOrderIterativeUsingTwoStacks(t.Root);
    }


    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void preOrderRecursion(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + ",");
        preOrderRecursion(root.left);
        preOrderRecursion(root.right);
    }

    public void InOrderRecursion(Node root) {
        if (root == null)
            return;

        InOrderRecursion(root.left);
        System.out.print(root.data + ",");
        InOrderRecursion(root.right);
    }

    public void preOrderIterative(Node root) {
        if (root == null)
            return;
        Stack<Node> s = new Stack();
        s.push(root);
        while (!s.isEmpty()) {
            Node rootTemp = s.pop();
            System.out.print(rootTemp.data + ",");
            if (rootTemp.right != null)
                s.push(rootTemp.right);
            if (rootTemp.left != null)
                s.push(rootTemp.left);
        }
    }

    public void LevelOrderIterative(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node rootTemp = q.remove();
            System.out.print(rootTemp.data + ",");
            if (rootTemp.left != null)
                q.add(rootTemp.left);
            if (rootTemp.right != null)
                q.add(rootTemp.right);
        }
    }


    public void InOrderIterative(Node root) {
        if (root == null)
            return;
        Stack<Node> s = new Stack<Node>();
        Node current = root;
        while (current != null || !s.isEmpty()) {
            while (current != null) {
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            System.out.print(current.data + ",");
            current = current.right;
        }
    }


    public void postOrderIterativeUsingTwoStacks(Node root) {
        if (root == null)
            return;

        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node rootTemp = stack1.pop();
            stack2.push(rootTemp);
            if (rootTemp.left != null)
                stack1.push(rootTemp.left);
            if (rootTemp.right != null)
                stack1.push(rootTemp.right);
        }

        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().data+",");
        }
    }

    public void postOrderIterative(Node root) {
        if (root == null)
            return;

        Stack<Node> s = new Stack<Node>();
        Node curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            Node temp = s.peek().right;
            if (temp == null) {
                temp = s.pop();
                System.out.print(temp.data + ",");
                while (!s.isEmpty() && s.peek().right == temp) {
                    temp = s.pop();
                    System.out.print(temp.data + ",");
                }
              //  curr = s.peek().right;
               curr = (!s.isEmpty()) ? s.peek().right : null;
            } else curr = temp;

        }

    }
}
