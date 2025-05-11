import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Zigzag_Traversal_BinaryTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        boolean leftToRight = true;

        while(!q.isEmpty()) {

            // to store current level
            List<Integer> temp = new ArrayList<>();

            // q size for current level
            int len = q.size();

            for (int i=0;i<len;i++) {
                TreeNode node = q.poll();
                temp.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (leftToRight) {
                result.add(temp);
                leftToRight = !leftToRight;
            } else {
                Collections.reverse(temp);
                result.add(temp);
                leftToRight = !leftToRight;
            }
        }

        return result;

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        Zigzag_Traversal_BinaryTree zigzagTraversalBinaryTree = new Zigzag_Traversal_BinaryTree();

        List<List<Integer>> result = zigzagTraversalBinaryTree.zigzagLevelOrder(root);

        System.out.println("Zigzag traversal of the binary tree: " + result);
    }
}