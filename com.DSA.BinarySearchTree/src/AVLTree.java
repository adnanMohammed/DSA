import java.util.IllegalFormatCodePointException;

public class AVLTree {
    Node root;
    AVLTree() {
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


    public void insertoptimal(int value) {
        this.root = insertHelperoptimal(root, value);
    }

    public Node insertHelperoptimal(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.leftchild = insertHelperoptimal(node.leftchild, value);
        }
        if (value > node.value) {
            node.rightchild = insertHelperoptimal(node.rightchild, value);
        }
        node.height = Math.max(getHeight(node.leftchild), getHeight(node.rightchild)) + 1;
        return rotate(node);
    }

    private Node rightrotate(Node parent) {
        Node child = parent.leftchild;
        Node t = child.rightchild;
        child.rightchild = parent;
        parent.leftchild = t;
        parent.height = Math.max(getHeight(parent.leftchild), getHeight(parent.rightchild)) + 1;
        child.height = Math.max(getHeight(child.leftchild), getHeight(child.rightchild)) + 1;
        return child;

    }

    private Node leftrotate(Node parent) {
        Node child = parent.rightchild;
        Node t = child.leftchild;
        child.leftchild = parent;
        parent.rightchild = t;
        parent.height = Math.max(getHeight(parent.leftchild), getHeight(parent.rightchild)) + 1;
        child.height = Math.max(getHeight(child.leftchild), getHeight(child.rightchild)) + 1;
        return child;
    }


    public Node rotate(Node node) {
        //left heavy
        if (getHeight(node.leftchild) - getHeight(node.rightchild) > 1) {
            //left left case
            if (getHeight(node.leftchild.leftchild) - getHeight(node.leftchild.rightchild) > 0) {
                return rightrotate(node);
            } else {
                //left right case
                node.leftchild = leftrotate(node.leftchild);
                node = rightrotate(node);
            }
        }
        if (getHeight(node.rightchild) - getHeight(node.leftchild) > 1) {
            //right right case
            if (getHeight(node.rightchild.rightchild) - getHeight(node.rightchild.leftchild) > 0) {
                return leftrotate(node);

            } else {
                //right left case
                node.rightchild = rightrotate(node.rightchild);
                node = leftrotate(node);
            }
        }
        return node;
    }

    public void display(Node node) {
        if (node == null)
            return;

        System.out.print(node.value + " ");//N->L->R Pre-Order
        display(node.leftchild);
        display(node.rightchild);
    }
}


class AVLTreeMain{
    public static void main(String[] args) {
        AVLTree t=new AVLTree();
        t.insertoptimal(10);
        t.insertoptimal(8);
        t.insertoptimal(15);
        t.insertoptimal(6);
        t.insertoptimal(3);
        t.insertoptimal(9);
    }
}
