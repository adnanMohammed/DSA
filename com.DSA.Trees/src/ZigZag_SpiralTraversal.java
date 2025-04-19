import java.util.*;

public class ZigZag_SpiralTraversal {
    Node Root;

    public ZigZag_SpiralTraversal(Node Root) {
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

    public  List<Integer> zigzag_spiralTraversal(Node root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> l = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        int flag = 1;
        q.add(root);

        l.add(root.data);

        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> l1 = new ArrayList();
            for (int i = 0; i < count; i++) {
                Node temp = q.remove();
                if (temp.left != null) {
                    q.add(temp.left);
                    l1.add(temp.left.data);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                    l1.add(temp.right.data);
                }

            }
            if(flag==1){
                Collections.reverse(l1);
                flag=0;
            }
            else{
                flag=1;
            }
            l.addAll(l1);

        }
        return l;
    }

    public static void main(String[] args) {

        ZigZag_SpiralTraversal z = new ZigZag_SpiralTraversal(new Node(1));
        z.Root.left = new Node(2);
        z.Root.right = new Node(3);
        z.Root.left.left = new Node(4);
        z.Root.left.right = new Node(5);
        z.Root.right.right = new Node(6);
        System.out.println(z.zigzag_spiralTraversal(z.Root));


    }
}
