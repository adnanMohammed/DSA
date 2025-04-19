import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

    String ans="";
    // Encodes a tree to a single string.
    //Pre Order
    public String serialize(TreeNode root) {

        serializeHelper(root);
        return ans.trim();
    }

    public void serializeHelper(TreeNode root) {
        if (root == null) {
            ans=ans+"null ";
            return;
        }
        ans = ans + root.val + " ";
        serializeHelper(root.left);
        serializeHelper(root.right);

    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;

        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode node = queue.poll();

            if (!nodes[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }


    public static void main(String[] args) {
        SerializeDeserializeBinaryTree sd = new SerializeDeserializeBinaryTree();
        sd.insertoptimal(10);
        sd.insertoptimal(5);
        sd.insertoptimal(15);
        sd.insertoptimal(13);
        sd.insertoptimal(20);
      TreeNode root=  sd.deserialize( sd.serialize(sd.root));

    }
}
