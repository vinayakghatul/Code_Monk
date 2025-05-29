import java.util.*;

/**
 * Given the root of a binary tree, check whether
 * it is a mirror of itself (i.e., symmetric around its center).
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Symmetric_Binary_Tree {

    public boolean isSymmetricUtil(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        return (root1.val == root2.val) && isSymmetricUtil(root1.left, root2.right) && isSymmetricUtil(root1.right, root2.left);

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricUtil(root.left, root.right);
    }

    public static void main(String args[]) {
        Symmetric_Binary_Tree treeChecker = new Symmetric_Binary_Tree();

        // Example of a symmetric tree:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Is tree symmetric? " + treeChecker.isSymmetric(root)); // true

        // Example of an asymmetric tree:
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println("Is tree symmetric? " + treeChecker.isSymmetric(root2)); // false
    }

}