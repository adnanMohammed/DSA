public class TreeMain {
    public static void main(String[] args) {

        TreeTraversal_DFS_BFS t=new TreeTraversal_DFS_BFS(new TreeTraversal_DFS_BFS.Node(1));
        t.Root.left=new TreeTraversal_DFS_BFS.Node(2);
        t.Root.right=new TreeTraversal_DFS_BFS.Node(3);
        t.Root.left.left=new TreeTraversal_DFS_BFS.Node(4);
        t.Root.left.right=new TreeTraversal_DFS_BFS.Node(5);
        t.Root.right.left=new TreeTraversal_DFS_BFS.Node(7);
        t.Root.right.right=new TreeTraversal_DFS_BFS.Node(8);
        t.Root.left.left.left=new TreeTraversal_DFS_BFS.Node(6);
       /* t.preOrder(t.Root);
        System.out.println();
        t.inOrder(t.Root);
        System.out.println();
        t.postOrder(t.Root);*/
        System.out.println( t.levelOrder(t.Root));

    }
}
