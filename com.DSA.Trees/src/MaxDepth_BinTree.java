public class MaxDepth_BinTree {
     Node Root;

    public MaxDepth_BinTree(Node Root) {
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
        MaxDepth_BinTree m = new MaxDepth_BinTree(new Node(-1));
       m.Root.left = new Node(-2);
        m.Root.right = new Node(10);
        m.Root.left.left = new Node(-6);
   //     m.Root.left.left = new Node(-2);
        m.Root.right.left = new Node(-3);
        m.Root.right.right = new Node(-6);

     /*  m.Root.right.left = new Node(-3);
        m.Root.right.right = new Node(-6);
        m.Root.left.left = new Node(-6);
      /*  m.Root.right.right = new Node(7);
        m.Root.right.right.right = new Node(8);
        m.Root.right.right.right.right = new Node(9);
*/

        //System.out.println(MaxDepth(m.Root));
        System.out.println(maxPathSum(m.Root));
    }

    public static int MaxDepth(Node root) {
        if (root == null)
            return 0;

        int left = MaxDepth(root.left);
        int right = MaxDepth(root.right);
        return 1 + Math.max(left, right);
    }
    static int count=0;
    public static boolean checkBalancedBinTree(Node root) {
        checkBalancedBinTreeHelper(root);

       return count>0?false:true;
      /*  if (count>0) {
            System.out.println("is not a balanced binary tree");
            return false;
        }
         else{
            System.out.println("is a balanced binary tree");
            return true;
        }*/
    }



    public static int checkBalancedBinTreeHelper(Node root) {
        if (root==null)
            return 0;

        int left = checkBalancedBinTreeHelper(root.left);
        int right = checkBalancedBinTreeHelper(root.right);
        if((left-right)>1) {
            count+=1;
        }
        return 1 + Math.max(left, right);

    }

   static int max=0;

    public static int diameterOfBinTree(Node root){
        diameterOfBinTreeHelper(root);
        return max;
    }
    public static int diameterOfBinTreeHelper(Node root) {
        if (root==null)
            return 0;

        int left=diameterOfBinTreeHelper(root.left);
        int right=diameterOfBinTreeHelper(root.right);
        int Diameter=left+right;
        if (Diameter>max)
            max=Diameter;
        return 1+ Math.max(left,right);

    }
    static int Max=Integer.MIN_VALUE;
    public static int maxPathSum(Node root) {
        MaxPathSumHelper(root);
        return Max;
    }

    public static int  MaxPathSumHelper(Node root) {
        if (root == null)
            return 0;
        int left = Math.max(0,MaxPathSumHelper(root.left));
        int right = Math.max(0,MaxPathSumHelper(root.right));
        Max = Math.max(Max, left + right + root.data);
        return root.data + Math.max(left, right);
    }


}
