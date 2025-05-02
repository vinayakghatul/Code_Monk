import java.util.*;

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


class Pair {
    TreeNode root;
    int line;

    public Pair(TreeNode root, int line) {
        this.root = root;
        this.line = line;
    }
}

class Right_View_Binary_Tree {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        // base condition
        if (root == null) {
            return ans;
        }

        // Use map to store levels vs node values as seen from right side (key, value) -> (0,node.val) (1,node.val) .. etc
        // Use tree map for sorted order

        Map<Integer, Integer> mp = new TreeMap<>();

        // Use queue to store nodes and its line value with Pair class
        // Use LinkedList based Queue

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while(!q.isEmpty()) {
            Pair temp = q.poll();
            TreeNode currentNode = temp.root;
            int verticalDepth = temp.line;

            if (!mp.containsKey(verticalDepth)) {
                mp.put(verticalDepth, currentNode.val);
            }

            if (currentNode.right != null) {
                q.add(new Pair(currentNode.right, verticalDepth+1));
            }
            if (currentNode.left != null) {
                q.add(new Pair(currentNode.left, verticalDepth+1));
            }
        }

        for(Integer val: mp.values()) {
            ans.add(val);
        }

        return ans;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        Right_View_Binary_Tree solution = new Right_View_Binary_Tree();

        // Get the Right View traversal
        List<Integer> rightView = solution.rightSideView(root);

        // Print the result for Right View
        System.out.print("Right View Traversal: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }

    }
}