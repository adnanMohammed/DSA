import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBinaryTree {

    Node Root;

    public MaxWidthBinaryTree(Node Root) {
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
        MaxWidthBinaryTree tree = new MaxWidthBinaryTree(new Node(1));
        tree.Root.left = new Node(3);
        tree.Root.right = new Node(2);
        tree.Root.left.left = new Node(5);
        tree.Root.left.left.left = new Node(6);
        tree.Root.right.right = new Node(9);
        tree.Root.right.right.left = new Node(7);


        int ans = tree.maxWidth(tree.Root);
        System.out.println(ans);
    }

    public int findMaximumWidth(Node root) {
        int maxWidth = 0;

        //Variable nodesInLevel keep tracks of number of nodes in each level
        int nodesInLevel = 0;
        //queue will be used to keep track of nodes of tree level-wise
        Queue<Node> queue = new LinkedList<Node>();

        //Check if root is null, then width will be 0
        if(root == null) {
            System.out.println("Tree is empty");
            return 0;
        }
        else {
            //Add root node to queue as it represents the first level
            queue.add(root);

            while(queue.size() != 0) {

                //Variable nodesInLevel will hold the size of queue i.e. number of elements in queue
                nodesInLevel = queue.size();
                //maxWidth will hold maximum width.
                //If nodesInLevel is greater than maxWidth then, maxWidth will hold the value of nodesInLevel
                maxWidth = Math.max(maxWidth, nodesInLevel);

                //If variable nodesInLevel contains more than one node
                //then, for each node, we'll add left and right child of the node to the queue
                while(nodesInLevel > 0) {
                    Node current = queue.remove();
                    if(current.left != null)
                        queue.add(current.left);
                    if(current.right != null)
                        queue.add(current.right);
                    nodesInLevel--;
                }
            }
        }
        return maxWidth;
    }

    public static int maxWidth(Node root) {
        int maxWidth = 0;
        int width;
        int nodesInLevel;

        // Check if the tree is empty
        if (root == null) {
            return maxWidth;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            nodesInLevel = queue.size();
            width = nodesInLevel;

            // Enqueue all the children of the nodes at the current level
            while (nodesInLevel > 0) {
                Node node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                nodesInLevel--;
            }

            // Update the maximum width if necessary
            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}
