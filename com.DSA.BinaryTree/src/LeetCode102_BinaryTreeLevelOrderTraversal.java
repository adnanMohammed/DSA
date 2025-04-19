import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102_BinaryTreeLevelOrderTraversal {
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
    private static class TreeNode {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if (root==null)
            return ans;


        q.add(root);
        levelOrderHelper(q,ans);
        return ans;
    }

    private void levelOrderHelper(Queue<TreeNode> q, List<List<Integer>> ans) {
        if (q.isEmpty())
            return;
        List<Integer> inner_ans = new ArrayList<>();

        int size = q.size();

        for (int i = 0; i < size; i++) {
            inner_ans.add(q.peek().val);
            if (q.peek().left != null)
                q.add(q.peek().left);
            if (q.peek().right != null)
                q.add(q.peek().right);

            q.remove();
        }
        ans.add(inner_ans);
        levelOrderHelper(q,ans);
    }


    public TreeNode levelOrderSuccessor(TreeNode root, TreeNode key){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
       return levelOrderSuccessorHelper(q,  key);
    }

    private TreeNode levelOrderSuccessorHelper(Queue<TreeNode> q, TreeNode key) {
        if (q.isEmpty())
            return null;

        int size = q.size();


        for (int i = 0; i < size; i++) {
            if (q.peek().left != null)
                q.add(q.peek().left);
            if (q.peek().right != null)
                q.add(q.peek().right);

            if(q.peek().val==key.val){
                q.remove();
                if (!q.isEmpty())
                    return q.peek();
                else return root;
            }

            q.remove();
        }

      return   levelOrderSuccessorHelper(q,key);
    }


    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> l = new ArrayList<>();
        q.add(root);
        averageOfLevelsHelper(q, l);
        return l;

    }

    //637. Average of Levels in Binary Tree
    private void averageOfLevelsHelper(Queue<TreeNode> q, List<Double> ans) {
        if (q.isEmpty())
            return;


        int size = q.size();
        int sum = 0;

        for (int i = 0; i < size; i++) {

            sum += q.peek().val;
            if (q.peek().left != null)
                q.add(q.peek().left);
            if (q.peek().right != null)
                q.add(q.peek().right);

            q.remove();
        }
        ans.add((double) sum / size);
        averageOfLevelsHelper(q, ans);
    }

    public static void main(String[] args) {
        LeetCode102_BinaryTreeLevelOrderTraversal l=new LeetCode102_BinaryTreeLevelOrderTraversal();
        l.insertoptimal(10);l.insertoptimal(15);l.insertoptimal(7);l.insertoptimal(5);
        l.insertoptimal(9);l.insertoptimal(11);l.insertoptimal(18);
        l.insertoptimal(3); l.insertoptimal(6);
        TreeNode n=new TreeNode(3);
      TreeNode ans=  l.levelOrderSuccessor(l.root,n);
      if (ans!=null)
        System.out.println(ans.val);
      else System.out.println("wrong Key");
    }
}
