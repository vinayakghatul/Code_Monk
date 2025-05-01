import java.util.*;

// Node class
class Node {
    int data;
    Node left;
    Node right;

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
// custom Pair class required
class Pair {
    Node root;
    Integer line;

    public Pair(Node root, Integer line) {
        this.root = root;
        this.line = line;
    }
}

class TopView_Binary_Tree {
    public List<Integer> topView(Node root) {
        //your code goes here

        // result array
        List<Integer> ans = new ArrayList<>();

        // base condition
        if (root == null) {
            return ans;
        }

        // define map to store vertical position and its corresponding value of node
        // use TreeMap, since we want sorted order.
        // vertical position are ex. -2,-1,0,1,2 and so on. 0 will be for root and then left and right

        Map<Integer, Integer> mp = new TreeMap<>();

        // For BFS traversal, use Queue - LinkedList based
        // Store Pair<Node, line> -> line value stands for its vertical line value

        Queue<Pair> q = new LinkedList<>();

        // start with root node, and 0 as its line value.
        // when moving left, reduce line value by 1,for right increase by 1
        q.add(new Pair(root,0));

        while(!q.isEmpty()) {

            // pop the first in the queue and add its left and right if not null
            Pair pr = q.poll();
            Node temp = pr.root;
            Integer line = pr.line;

            // if line doesn't exist in the map then add line and its value
            if (!mp.containsKey(line)) {
                mp.put(line, temp.data);
            }

            if (temp.left != null) {
                q.add(new Pair(temp.left, line-1));
            }

            if (temp.right != null) {
                q.add(new Pair(temp.right, line+1));
            }
        }

        for (Integer i: mp.values()) {
            ans.add(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
             \
              4
               \
                5
                 \
                  6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        TopView_Binary_Tree tree = new TopView_Binary_Tree();
        List<Integer> result = tree.topView(root);

        System.out.println("Top View: " + result);
    }
}