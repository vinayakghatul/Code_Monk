import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}

class Level_Order_Traversal {

    public List<List<Integer>> levelOrder(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();

        // start with root node
        q.add(root);
        int currentLevel = 0;

        while(!q.isEmpty()) {
            int len = q.size();
            // new arraylist at currentLevel index to store that level order
            result.add(new ArrayList<>());

            for (int i=0;i<len;i++) {
                Node node = q.poll();
                result.get(currentLevel).add(node.val);

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            currentLevel++;
        }

        return result;
    }

    public static void main(String args[]) {
        //      5
        //     / \
        //   12   13
        //   /  \    \
        //  7    14   2
        // /  \   /  \  / \
        //17 23 27  3  8  11

        Node root = new Node(5);
        root.left = new Node(12);
        root.right = new Node(13);

        root.left.left = new Node(7);
        root.left.right = new Node(14);

        root.right.right = new Node(2);

        root.left.left.left = new Node(17);
        root.left.left.right = new Node(23);

        root.left.right.left = new Node(27);
        root.left.right.right = new Node(3);

        root.right.right.left = new Node(8);
        root.right.right.right = new Node(11);

        // Perform level order traversal and get the result
        Level_Order_Traversal level_order_traversal = new Level_Order_Traversal();
        List<List<Integer>> res = level_order_traversal.levelOrder(root);

        // Print the result in the required format
        for (List<Integer> level : res) {
            System.out.print("[");
            for (int i = 0; i < level.size(); i++) {
                System.out.print(level.get(i));
                if (i < level.size() - 1) System.out.print(", ");
            }
            System.out.print("] ");
        }
    }
}