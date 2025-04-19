import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal_DFS_BFS {
    Node Root;

    public TreeTraversal_DFS_BFS(Node n) {
        this.Root = n;
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

    //DFS
    //Root,Left,Right
    public void preOrder(Node temp) {
        if (temp == null)
            return;
        System.out.print(temp.data + ",");
        preOrder(temp.left);
        preOrder(temp.right);
    }

    //DFS
    //Left,Root,Right
    public void inOrder(Node temp) {
        if (temp == null)
            return;

        inOrder(temp.left);
        System.out.print(temp.data + ",");
        inOrder(temp.right);
    }

    //DFS
    //Left,Right,Root
    public void postOrder(Node temp) {
        if (temp == null)
            return;

        postOrder(temp.left);
        postOrder(temp.right);
        System.out.print(temp.data + ",");
    }

    //BFS
    //Level wise traversal
    public void levelOrderTraversal(Node root) {
        if (root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            if (q.peek().left != null)
                q.offer(q.peek().left);
            if (q.peek().right != null)
                q.offer(q.peek().right);

            System.out.print(q.poll().data + ",");

        }
    }

    public List<Integer> levelOrder(Node root) {
        List<Integer> LevelOrderData = new ArrayList<>();
        if (root == null)
            return LevelOrderData;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            if (q.peek().left != null)
                q.offer(q.peek().left);
            if (q.peek().right != null)
                q.offer(q.peek().right);
            // System.out.print(q.peek().data + ",");
            //  LevelOrderData.add(q.peek().data);
            LevelOrderData.add(q.poll().data);
        }
        return LevelOrderData;
    }
}
