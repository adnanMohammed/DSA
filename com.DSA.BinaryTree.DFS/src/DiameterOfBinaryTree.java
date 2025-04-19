public class DiameterOfBinaryTree {
    public class TreeNode {
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

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
       int ans= diameterOfBinaryTreeHelper(root);
        return diameter;

    }

    public int diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null)
            return 0;
        int left = diameterOfBinaryTreeHelper(root.left);
        int right = diameterOfBinaryTreeHelper(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right)+1;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);

        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree bt = new DiameterOfBinaryTree();
        bt.insertoptimal(20);
        bt.insertoptimal(25);
        bt.insertoptimal(30);
        bt.insertoptimal(15);
        bt.insertoptimal(23);
        bt.maxDepth(bt.root);
    }
}
