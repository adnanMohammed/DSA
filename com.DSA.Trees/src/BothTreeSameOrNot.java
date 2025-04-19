import java.util.Stack;

public class BothTreeSameOrNot {
    Node Root;

    public BothTreeSameOrNot(Node Root){
        this.Root=Root;

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
        BothTreeSameOrNot bt=new BothTreeSameOrNot(new Node(10));
        bt.Root.left=new Node(5);
        bt.Root.right=new Node(15);
        Node q=new Node(10);
        q.left=new Node(5);
        q.left.right=new Node(15);
        System.out.println( bt.isSameTree(bt.Root,q));
    }

    public boolean isSameTree(Node p, Node q) {
        if(p==null || q==null)
            return p==q;

        if(p.data!=q.data)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }


}
