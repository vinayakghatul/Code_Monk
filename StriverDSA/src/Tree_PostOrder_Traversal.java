import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // no arg constructor
    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tree_PostOrder_Traversal {

    public void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    public static void main(String args[]) {
        /**
         *      1
         *    /   \
         *   2     3
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<Integer> result = new ArrayList<>();

        Tree_PostOrder_Traversal treePostOrderTraversal = new Tree_PostOrder_Traversal();

        treePostOrderTraversal.postOrder(root, result);

        System.out.println("Post-Order Traversal: " + result);
    }
}