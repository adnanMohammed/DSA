import java.util.Arrays;

public class LowestCommonAncestor {
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


    private void inOrder(TreeNode root) {
        if (root==null)
            return;

        inOrder(root.left);
        inOrder(root.right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }
    int count=0;
    int result=-1;
    public int kthSmallest(TreeNode root, int k) {

        kthSmallestHelper(root,k);
        return result;
    }

    private void kthSmallestHelper(TreeNode root, int k) {
        if (root==null)
            return;
        kthSmallestHelper(root.left,k);
        count++;
        if (count==k){
            result=root.val;
            return;
        }
        kthSmallestHelper(root.right,k);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        int r = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == r) {
                index = i;
                break;
            }
        }
        TreeNode n = new TreeNode(r);

        n.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index ));
        n.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return n;

    }


    public static void main(String[] args) {
        LowestCommonAncestor l=new LowestCommonAncestor();
        l.insertoptimal(10); l.insertoptimal(5); l.insertoptimal(15);
        l.insertoptimal(3); l.insertoptimal(7); l.insertoptimal(12);
        l.insertoptimal(17); l.insertoptimal(6); l.insertoptimal(8);
        int[] preorder = {3,9,20,15,7}; int[] inorder = {9,3,15,20,7};
        l.buildTree(preorder,inorder);

    }
}
