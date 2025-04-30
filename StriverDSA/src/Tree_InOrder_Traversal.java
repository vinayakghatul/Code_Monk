/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // No Args constructor
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tree_InOrder_Traversal {

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        } else {
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> inorder = new ArrayList<>();

        inorder(root, inorder);

        return inorder;

    }

    public static void main(String args[]) {
            // Build the binary tree:
            //         1
            //        /  \
            //       2    3

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);

            Tree_InOrder_Traversal inorderTraversal = new Tree_InOrder_Traversal();
            List<Integer> result = inorderTraversal.inorderTraversal(root);

            // Print the inorder traversal
            System.out.println("Inorder Traversal: " + result);
    }
}