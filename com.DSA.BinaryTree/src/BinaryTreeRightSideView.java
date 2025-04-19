import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int listans=Integer.MIN_VALUE;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
              listans=current.val;
            }
            ans.add(listans);
        }
        return ans;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root==null)
            return false;

        if (!findSameLevel(root,x,y))
            return false;

        if (!findNode(root,x,y))
            return false;

        return true;
    }

    private boolean findNode(TreeNode root, int x, int y) {
        if (root==null)
            return true;

        if (root.left!=null && root.right!=null && ((root.left.val==x && root.right.val==y) || (root.left.val==y && root.right.val==x)))
            return false;
        return findNode(root.left,x,y) && findNode(root.right,x,y);
    }

    private boolean findSameLevel(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int tempx=x,tempy=y;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (current.left != null)
                    q.add(current.left);

                if (current.right != null)
                    q.add(current.right);

                if (current.val==x)
                    x=-1;
                if (current.val==y)
                    y=-1;
                if (x==-1 && y==-1)
                    return true;
            }
            x=tempx;y=tempy;
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size / 2; i++) {
                TreeNode left = q.poll();
                TreeNode right = q.poll();
                if (left == null && right == null)
                    continue;
                if (left == null || right == null)
                    return false;
                if (left.val != right.val)
                    return false;

                    q.add(left.left);
                    q.add(right.right);
                    q.add(left.right);
                    q.add(right.left);

            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView rs=new BinaryTreeRightSideView();
        rs.insertoptimal(10);rs.insertoptimal(20);rs.insertoptimal(25);rs.insertoptimal(15);
        rs.insertoptimal(13);rs.insertoptimal(14);
       boolean ans= rs.isCousins(rs.root,15,25);
        System.out.println("ans="+ans);
    }
}
