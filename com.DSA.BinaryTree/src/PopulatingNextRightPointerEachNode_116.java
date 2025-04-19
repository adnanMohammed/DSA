import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointerEachNode_116 {
   public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    Node root;
    public void insertoptimal(int value) {
        this.root = insertHelperoptimal(root, value);

    }

    public Node insertHelperoptimal(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.val)
            node.left = insertHelperoptimal(node.left, value);
        if (value > node.val)
            node.right = insertHelperoptimal(node.right, value);
        return node;
    }

    public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                if (prev != null)
                    prev.next = current;

                prev = current;
            }
            if (prev!=null)
                prev.next=null;
        }
        return root;
    }

    public Node connectoptimized(Node root) {
        Node leftMostNode = root;
        Node curr = root;
        if (root == null)
            return root;

        while (leftMostNode.left != null) {
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null)
                    curr.right.next = curr.next.left;
                    curr = curr.next;

            }
            leftMostNode = leftMostNode.left;
            curr=leftMostNode;
        }
    return root;
    }



    public static void main(String[] args) {
        PopulatingNextRightPointerEachNode_116 p=new PopulatingNextRightPointerEachNode_116();
        p.insertoptimal(10);p.insertoptimal(5);p.insertoptimal(20);p.insertoptimal(7);p.insertoptimal(3);
        p.insertoptimal(15);p.insertoptimal(25);
        p.insertoptimal(1);p.insertoptimal(4);p.insertoptimal(6);p.insertoptimal(9);
        p.insertoptimal(12);p.insertoptimal(17);p.insertoptimal(30);;p.insertoptimal(23);
       Node ans= p.connectoptimized(p.root);
    }
}



