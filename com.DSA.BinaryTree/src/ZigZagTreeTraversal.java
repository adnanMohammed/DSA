import com.sun.source.tree.Tree;

import java.util.*;

public class ZigZagTreeTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Deque<TreeNode> q=new ArrayDeque<>();

        if (root==null)
            return ans;
        q.add(root);
        zigzagLevelOrderHelper(root,q,ans,true);
        return ans;

    }

    private void zigzagLevelOrderHelper(TreeNode node, Deque<TreeNode> q,List<List<Integer>> ans,boolean left2right) {
        if (q.isEmpty())
            return;

        int size = q.size();

        List<Integer> l = new ArrayList<>();
        if (left2right) {
            for (int i = 0; i < size; i++) {
                if (q.peekFirst().left != null)
                    q.addLast(q.peekFirst().left);
                if (q.peekFirst().right != null)
                    q.addLast(q.peekFirst().right);
                l.add(q.peekFirst().val);
                q.removeFirst();
            }
            left2right = false;
            ans.add(l);
        } else {
            for (int i = 0; i < size; i++) {
                if (q.peekLast().right != null)
                    q.addFirst(q.peekLast().right);
                if (q.peekLast().left != null)
                    q.addFirst(q.peekLast().left);
                l.add(q.peekLast().val);
                q.removeLast();
            }
            left2right = true;
            ans.add(l);
        }
        zigzagLevelOrderHelper(node,q,ans,left2right);
    }

    public static void main(String[] args) {
        ZigZagTreeTraversal z=new ZigZagTreeTraversal();
        z.insertoptimal(10); z.insertoptimal(5); z.insertoptimal(15);
        z.insertoptimal(3);z.insertoptimal(7);z.insertoptimal(12);z.insertoptimal(20);
        z.insertoptimal(1);z.insertoptimal(4);z.insertoptimal(6);z.insertoptimal(9);
        z.insertoptimal(11);z.insertoptimal(14);z.insertoptimal(18);z.insertoptimal(25);
       List<List<Integer>> res= z.zigzagLevelOrder(z.root);
        System.out.println(res);
    }
}
