import java.util.*;

/**
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
 * where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level
 * are also counted into the length calculation.
 *
 *          1
 *        /   \
 *       3     2
 *      / \     \
 *     5   3     9
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class Max_Width_Binary_Tree {
    class Pair {
        TreeNode node;
        int index;

        public Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {

        // base case
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));     // initialize queue, root at index 0

        while (!q.isEmpty()) {

            int size = q.size();

            int minIndex = q.peek().index;

            int first = 0, last = 0;

            for (int i=0;i<size;i++) {
                Pair p = q.remove();

                TreeNode node = p.node;
                int index = p.index - minIndex;

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * index + 2));
                }

            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;

    }

    public static void main(String[] args) {
        // Manually building the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        Max_Width_Binary_Tree sol = new Max_Width_Binary_Tree();
        int maxWidth = sol.widthOfBinaryTree(root);
        System.out.println("Maximum Width of Binary Tree: " + maxWidth);
    }
}