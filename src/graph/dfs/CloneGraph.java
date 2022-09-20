package graph.dfs;

import java.util.HashMap;
import java.util.List;
/**
 * Leetcode: 133
 *
 * */
public class CloneGraph {

    private static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
        }
    }

    private static HashMap<Node, Node> map = new HashMap<>();

    private static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        for (Node neighbor : node.neighbors) {
            if (map.containsKey(node)) {
                copyNode.neighbors.add(map.get(neighbor));
            } else {
                copyNode.neighbors.add(cloneGraph(neighbor));
            }
        }
        return copyNode;
    }


    public static void main(String[] args) {

    }
}
