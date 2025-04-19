import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PathSum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        if (root.left == null && root.right == null && targetSum == root.val)
            return true;
        return left || right;
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode root, int ans) {
        if (root == null)
            return 0;

        int sum = (ans * 10) + root.val;
        if (root.left == null && root.right == null)
            return sum;

        return sumNumbersHelper(root.left, sum) + sumNumbersHelper(root.right, sum);
    }

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return ans;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        ans = Math.max(ans, left + root.val + right);
        return root.val + Math.max(left, right);
    }
    List<String> listans=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        binaryTreePathsHelper(root,"");
        return listans;
    }

    private void binaryTreePathsHelper(TreeNode root,String str) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            str = str + root.val;
            listans.add(str);

            return;
        }
        str = str + root.val+"->";
        binaryTreePathsHelper(root.left, str);
        binaryTreePathsHelper(root.right, str);
    }

    public boolean isPathExists(TreeNode root,int[] path) {
        if (root==null || path.length==0)
            return true;
        List<Integer> listPath= Arrays.stream(path).boxed().collect(Collectors.toList());
     return    isPathExistsHelper(root, listPath);

    }

    private boolean isPathExistsHelper(TreeNode root, List<Integer> listPath) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            if ((root.val == listPath.get(0)) && listPath.size() == 1)
                return true;
            return false;
        }
        if (root.val == listPath.get(0))
            listPath.remove(0);

        boolean left = isPathExistsHelper(root.left, listPath);
        boolean right = isPathExistsHelper(root.right, listPath);
        return left || right;
    }
    int count=0;
    public int findPathCounts(TreeNode root,int sum){
        List<Integer> l=new ArrayList<>();
         findPathCountsHelper(root,sum,l);
    return count;
    }

    private void findPathCountsHelper(TreeNode root, int sum, List<Integer> l) {
        if (root==null)
            return;
        l.add(root.val);
        int sumCount=0;
        for (int i = l.size()-1; i >=0 ; i--) {
            sumCount+=l.get(i);
            if (sumCount==sum)
                count++;
        }
        findPathCountsHelper(root.left,sum,l);
        findPathCountsHelper(root.right,sum,l);
        l.remove(l.size()-1);
    }

    public static void main(String[] args) {
        PathSum p = new PathSum();
        p.insertoptimal(10);
        p.insertoptimal(8);
        p.insertoptimal(20);
        p.insertoptimal(15);
        p.insertoptimal(13);
        p.insertoptimal(30);
        p.insertoptimal(25);
        p.insertoptimal(27);
        p.insertoptimal(26);

        int ans = p.findPathCounts(p.root,52);
        System.out.println("ans=" + ans);
    }
}
