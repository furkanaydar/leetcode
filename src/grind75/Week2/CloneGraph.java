package grind75.Week2;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node dfs(Node node, Node[] h) {
        if (h[node.val] != null) {
            return h[node.val];
        }

        h[node.val] = new Node(node.val);
        for (Node n: node.neighbors) {
            h[node.val].neighbors.add(dfs(n, h));
        }

        return h[node.val];
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return dfs(node, new Node[105]);
    }
}
