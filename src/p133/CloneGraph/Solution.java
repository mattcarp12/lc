package p133.CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static Node cloneGraph(Node node) {
        return clone(node, new HashMap());
    }

    static Node clone(Node node, Map<Node, Node> map) {
        Node copy = map.get(node);
        if (copy != null) return copy;
        copy = new Node(node.val, new ArrayList());
        map.put(node, copy);
        for (Node neib : node.neighbors) {
            copy.neighbors.add(clone(neib, map));
        }
        return copy;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, new ArrayList<Node>());
        Node node2 = new Node(2, new ArrayList<Node>());
        Node node3 = new Node(3, new ArrayList<Node>());
        Node node4 = new Node(4, new ArrayList<Node>());
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node clone = cloneGraph(node1);
        System.out.println("Hi");
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}