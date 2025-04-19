import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

 class Node{
    int value;
    int height;
    Node leftchild;
    Node rightchild;

    Node(int value){
        this.value=value;
        this.leftchild=null;
        this.rightchild=null;
    }

}
class BinarySearchTree {
    Node root;

    BinarySearchTree() {

    }

    public int getHeight(Node node) {
        if (node == null)
            return -1;
        return node.height;
    }

    public boolean isBalanced(Node node) {
        if (node == null)
            return true;

        return Math.abs(getHeight(node.leftchild) - getHeight(node.rightchild)) <= 1 && isBalanced(node.leftchild) && isBalanced(node.rightchild);
    }


    public void insert(int value) {
        if (this.root == null) {
            this.root = new Node(value);
            return;
        }
        insertHelper(root, value);

    }

    public void insertHelper(Node node, int value) {
        if (value < node.value) {
            if (node.leftchild == null)
                node.leftchild = new Node(value);
            else insertHelper(node.leftchild, value);
        } else if (value > node.value) {
            if (node.rightchild == null)
                node.rightchild = new Node(value);
            else insertHelper(node.rightchild, value);
        }
    }

    public void sortedInsertion(int[] nums) {
        int s = 0, e = nums.length - 1;
        sortedInsertionHelper(nums, s, e);
    }

    private void sortedInsertionHelper(int[] arr, int s, int e) {
        if (s > e)
            return;
        int mid = (s + e) / 2;
        insertoptimal(arr[mid]);
        sortedInsertionHelper(arr, s, mid - 1);
        sortedInsertionHelper(arr, mid + 1, e);
    }


    public void insertoptimal(int value) {
        this.root = insertHelperoptimal(root, value);

    }

    public Node insertHelperoptimal(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value)
            node.leftchild = insertHelperoptimal(node.leftchild, value);
        if (value > node.value)
            node.rightchild = insertHelperoptimal(node.rightchild, value);
        node.height = Math.max(getHeight(node.leftchild), getHeight(node.rightchild)) + 1;
        return node;
    }

    public void display(Node node) {
        if (node == null)
            return;

        System.out.print(node.value+" ");//N->L->R
        display(node.leftchild);
        display(node.rightchild);
    }

    List<Integer> l=new ArrayList<>();
    public List<Integer> preorder(Node node) {
        //your code goes here
        if (node == null)
            return l;
        //System.out.print(node.value+" ");//N->L->R
        l.add(node.value );
        preorder(node.leftchild);
        preorder(node.rightchild);
        return l;
    }

    public void displayInOrder(Node node) {
        if (node == null)
            return;

        displayInOrder(node.leftchild);
        System.out.print(node.value + " ");//L->N->R
        displayInOrder(node.rightchild);
    }

    public void displayPostOrder(Node node) {
        if (node == null)
            return;

        displayPostOrder(node.leftchild);
        displayPostOrder(node.rightchild);
        System.out.print(node.value + " ");//L->R->N
    }
    Queue<Node> q=new LinkedList<>();
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> levelOrder(Node node) {
        //your code goes here
        if (node==null)
            return null;
        Queue<Node> q=new LinkedList();
        List<List<Integer>> listres=new ArrayList<>();
        q.add(node);
        List<Integer> l=new ArrayList<>();
        l.add(node.value);
        listres.add(l);
        LevelOrderHelper(q,listres);
        return listres;
    }
    public void  LevelOrderHelper(Queue<Node> q, List<List<Integer>> listres) {
        if (q.isEmpty())
            return;
        int size = q.size();
        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (q.peek().leftchild!=null){
                int leftVal = q.peek().leftchild.value;
                q.add(q.peek().leftchild);
                l.add(leftVal);
            }
            if (q.peek().rightchild!=null) {
                int rightVal = q.peek().rightchild.value;
                q.add(q.peek().rightchild);
                l.add(rightVal);
            }
            q.remove();
        }

        listres.add(l);
        LevelOrderHelper(q, listres);
    }



}

class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertoptimal(5);
        bst.insertoptimal(3);
        bst.insertoptimal(10);
        bst.insertoptimal(1);
        bst.insertoptimal(4);
        bst.insertoptimal(7);
        bst.insertoptimal(15);
        bst.insertoptimal(6);
        bst.insertoptimal(8);
        bst.insertoptimal(13);
        bst.insertoptimal(17);
        List<List<Integer>> res=bst.levelOrder(bst.root);
        System.out.println(res);
      /*  System.out.print("Pre-Oder Tree Traversal:- ");
        bst.display(bst.root);
        System.out.println();
        System.out.print("In-Oder Tree Traversal:- ");
        bst.displayInOrder(bst.root);
        System.out.println();
        System.out.print("Post-Oder Tree Traversal:- ");
        bst.displayPostOrder(bst.root);
        System.out.println();
        List<Integer> ans=bst.preorder(bst.root);
      //  int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
       // bst.sortedInsertion(arr);
        //System.out.print("In-Oder Tree Traversal:- ");
        //bst.display(bst.root);*/

    }
}

