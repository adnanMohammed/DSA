import com.sun.source.tree.Tree;

public class FlattenBinaryTree2LinkedList {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    TreeNode root;
    public void insertoptimal(int value) {
        this.root = insertHelperoptimal(root, value);

    }

    public TreeNode insertHelperoptimal(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }
        if (value < node.val)
            node.left = insertHelperoptimal(node.left, value);
        if (value > node.val)
            node.right = insertHelperoptimal(node.right, value);
        return node;
    }
    TreeNode head=null; TreeNode tail=null;
    public void flatten(TreeNode root) {
            flattenHelper(root);
            root=head;

    }

    private void flattenHelper(TreeNode root) {
        if (root == null)
            return;

        if (head == null) {
            head = root;
            tail = root;
        } else {
            tail.right = root;
            tail.left=null;
            tail = root;
        }
        TreeNode left=root.left;
        TreeNode right=root.right;
        flattenHelper(left);
        flattenHelper(right);
    }

    public static void main(String[] args) {
        FlattenBinaryTree2LinkedList f=new FlattenBinaryTree2LinkedList();
     /*   f.insertoptimal(10);f.insertoptimal(5);f.insertoptimal(15);
        f.insertoptimal(3);f.insertoptimal(6);f.insertoptimal(20);*/
        f.root=new TreeNode(1);
        f.root.left=new TreeNode(2);
        f.root.left.left=new TreeNode(3);
        f.root.left.right=new TreeNode(4);
        f.root.right=new TreeNode(5);
        f.root.right.right=new TreeNode(6);

        f.flatten(f.root);

    }
}
