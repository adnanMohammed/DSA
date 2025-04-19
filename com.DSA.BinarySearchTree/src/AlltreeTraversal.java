import java.util.ArrayList;
import java.util.List;

public class AlltreeTraversal {
    TreeNode root;

    AlltreeTraversal() {

    }

    public void insertoptimal(int value) {
        this.root = insertHelperoptimal(root, value);

    }

    public TreeNode insertHelperoptimal(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }
        if (value < node.data)
            node.left = insertHelperoptimal(node.left, value);
        if (value > node.data)
            node.right = insertHelperoptimal(node.right, value);
        return node;
    }



    List<List<Integer>> treeTraversal(TreeNode root) {
        //your code goes here
        List<List<Integer>> res=new ArrayList<>();
        res.add(preorder(root));
        res.add(displayInOrder(root));
        res.add(displayPostOrder(root));
        return res;
    }

    List<Integer> l=new ArrayList();
    public List<Integer> preorder(TreeNode node) {
        //your code goes here
        if (node == null)
            return l;
        l.add(node.data );//N->L->R
        preorder(node.left);
        preorder(node.right);
        return l;
    }
    List<Integer> ls=new ArrayList();
    public List<Integer> displayInOrder(TreeNode node) {
        if (node == null)
            return ls;

        displayInOrder(node.left);
        ls.add(node.data );//L->N->R
        displayInOrder(node.right);
        return ls;
    }
    List<Integer> lst=new ArrayList();
    public List<Integer> displayPostOrder(TreeNode node) {
        if (node == null)
            return lst;

        displayPostOrder(node.left);
        displayPostOrder(node.right);
        lst.add(node.data );//L->R->N
        return lst;

    }
}

 class TreeNode {
      int data;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { data = val; left = null; right = null; }
 }

 class mainTree{
     public static void main(String[] args) {
         AlltreeTraversal bst =new AlltreeTraversal();
         bst.insertoptimal(1);
         bst.insertoptimal(3);
         bst.insertoptimal(4);
         bst.insertoptimal(5);
         bst.insertoptimal(2);
         bst.insertoptimal(7);
         bst.insertoptimal(6);

        List<List<Integer>> res= bst.treeTraversal(bst.root);
         System.out.println(res);
     }
 }
