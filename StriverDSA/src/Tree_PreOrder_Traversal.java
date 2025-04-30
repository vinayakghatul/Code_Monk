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

class Tree_PreOrder_Traversal {

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // visit root, traverse left, traverse right
        result.add(root.val);
        inorder(root.left, result);
        inorder(root.right, result);
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

        TreeNode_PreOrder_Traversal treeNodePreOrderTraversal = new TreeNode_PreOrder_Traversal();

        treeNodePreOrderTraversal.inorder(root, result);

        System.out.println("Pre-Order Traversal: " + result);
    }
}