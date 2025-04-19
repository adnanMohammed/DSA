import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTreeTraversal {
    Node Root;

    public BoundaryTreeTraversal(Node Root) {
        this.Root = Root;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BoundaryTreeTraversal z = new BoundaryTreeTraversal(new Node(1));
        z.Root.left = new Node(2);
        z.Root.right = new Node(7);
        z.Root.left.left = new Node(3);
        z.Root.left.left.right = new Node(4);
        z.Root.left.left.right.left = new Node(5);
        z.Root.left.left.right.right = new Node(6);
        z.Root.right.right = new Node(8);
        z.Root.right.right.left = new Node(9);
        z.Root.right.right.left.left = new Node(10);
        z.Root.right.right.left.right = new Node(11);
        System.out.println(z.BoundaryTraversal(z.Root));
    }

    public List<Integer> BoundaryTraversal(Node root) {
        //if Binary tree is empty return empty list
        if (root == null)
            return new ArrayList<>();

        //initialising list with root data
        List<Integer> l = new ArrayList<>();
        l.add(root.data);

        //left Boundary
        Node templeft = root.left;
        while (templeft != null) {
            l.add(templeft.data);
            if (templeft.left != null)
                templeft = templeft.left;
            else
                templeft = templeft.right;
        }
        if (l.size() > 1)
            l.remove(l.size() - 1);

        //right boundary
        Stack<Integer> rightBoundary = new Stack<>();
        Node tempRight = root.right;
        while (tempRight != null) {
            rightBoundary.push(tempRight.data);
            if (tempRight.right != null)
                tempRight = tempRight.right;
            else
                tempRight = tempRight.left;
        }
        rightBoundary.pop();


        //leaf
        Stack<Node> s = new Stack<>();
        Node current = root;
        while (current != null || !s.isEmpty()) {
            while (current != null) {
                s.push(current);
                current = current.left;
            }
            current = s.pop();
            if (current.left == null && current.right == null)
                l.add(current.data);
            current = current.right;

        }
        //adding right boundary to list
        int count = rightBoundary.size();
        for (int i = 0; i < count; i++) {
            l.add(rightBoundary.pop());
        }
        return l;
    }
}
