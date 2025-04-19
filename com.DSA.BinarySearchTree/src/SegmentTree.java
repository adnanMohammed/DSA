public class SegmentTree {

    private class Node {
        int data;
        Node left;
        Node right;
        int startInterval;
        int endInterval;

        Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

        Node(int data, int startInterval, int endInterval) {
            this.data = data;
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    //insert O(N)
    public void segmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);

    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        Node n = new Node(start, end);
        int mid = (start + end) / 2;
        n.left = constructTree(arr, start, mid);
        n.right = constructTree(arr, mid + 1, end);
        n.data = n.left.data + n.right.data;
        return n;
    }

    //update O(log N)
    public void updateSegmentTree(int index, int data) {
        updateSegmentTreeHelper(index, data, root, root.startInterval, root.endInterval);
    }

    public Node updateSegmentTreeHelper(int index, int data, Node node, int start, int end) {
        if (start == end) {
            node.data = data;
            return node;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            updateSegmentTreeHelper(index, data, node.left, start, mid);
            node.data = node.left.data + node.right.data;
        }
        if (index > mid) {
            updateSegmentTreeHelper(index, data, node.right, mid + 1, end);
            node.data = node.left.data + node.right.data;
        }
        return node;
    }

    public int sumInRange(int start, int end) {
        if (start>end)
            return -1;

        if(root.startInterval==start && root.endInterval==end)
            return root.data;
        return sumInRangeHelper(root, start,end);
    }

    private int sumInRangeHelper(Node root, int rangeFrom, int rangeTo) {
        if (root.endInterval<rangeFrom || rangeTo< root.startInterval)
            return 0;
        if (rangeFrom <= root.startInterval && root.endInterval <= rangeTo)
            return root.data;


       else if (root.startInterval < rangeFrom || root.endInterval > rangeTo) {
            int mid = (root.startInterval + root.endInterval) / 2;
            int left=0,right=0;
            if (rangeFrom <= mid)
                 left=sumInRangeHelper(root.left, rangeFrom, rangeTo);
                 right=sumInRangeHelper(root.right, rangeFrom, rangeTo);
          return   left+ right;
        }

       else return 0;

    }

    public int subtractInRange(int start, int end) {
        if (start>end)
            return -1;

        if(root.startInterval==start && root.endInterval==end)
            return root.data;
        return subtractInRangeHelper(root, start,end);
    }

    private int subtractInRangeHelper(Node root, int rangeFrom, int rangeTo) {
        if (root.endInterval<rangeFrom || rangeTo< root.startInterval)
            return 0;
        if (rangeFrom <= root.startInterval && root.endInterval <= rangeTo)
            return root.data;


        else if (root.startInterval < rangeFrom || root.endInterval > rangeTo) {
            int mid = (root.startInterval + root.endInterval) / 2;
            int left=0,right=0;
            if (rangeFrom <= mid)
                left=subtractInRangeHelper(root.left, rangeFrom, rangeTo);
            right=subtractInRangeHelper(root.right, rangeFrom, rangeTo);
            return   left- right;
        }

        else return 0;

    }


    public void segmentTreeMax(int[] arr) {
        this.root = constructTreeMax(arr, 0, arr.length - 1);

    }

    private Node constructTreeMax(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        Node n = new Node(start, end);
        int mid = (start + end) / 2;
        n.left = constructTreeMax(arr, start, mid);
        n.right = constructTreeMax(arr, mid + 1, end);
        n.data = Math.max(n.left.data , n.right.data);
        return n;
    }


    public int maxInRange(int start, int end) {
        if (start>end)
            return -1;

        if(root.startInterval==start && root.endInterval==end)
            return root.data;
        return maxRangeHelper(root, start,end);
    }

    private int maxRangeHelper(Node root, int rangeFrom, int rangeTo) {
        if (root.endInterval<rangeFrom || rangeTo< root.startInterval)
            return 0;
        if (rangeFrom <= root.startInterval && root.endInterval <= rangeTo)
            return root.data;


        else if (root.startInterval < rangeFrom || root.endInterval > rangeTo) {
            int mid = (root.startInterval + root.endInterval) / 2;
            int left=0,right=0;
            if (rangeFrom <= mid)
                left=maxRangeHelper(root.left, rangeFrom, rangeTo);
            right=maxRangeHelper(root.right, rangeFrom, rangeTo);
            return   left- right;
        }

        else return 0;
    }
}

class SegmentTreeMain{
    public static void main(String[] args) {
        SegmentTree t=new SegmentTree();
        int[] arr={1,2,3,4,5,6,7,8};
        t.segmentTreeMax(arr);
       // t.updateSegmentTree(3,15);
        int ans=t.sumInRange(3,3);
    }


}
