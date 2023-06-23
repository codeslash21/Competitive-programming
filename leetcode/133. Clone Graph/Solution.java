// Using dfs
// t.c.=O(v+e), s.c.=O(v)
/*
// Definition for a Node.
class Node {
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
*/

class Solution {
    HashMap<Node, Node> clone = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)
            return node;
        if(clone.containsKey(node))
            return clone.get(node);
        Node cloned = new Node(node.val, new ArrayList<Node>());
        clone.put(node, cloned);
        for(Node nei : node.neighbors) {
            Node clonedNei = cloneGraph(nei);
            clone.get(node).neighbors.add(clonedNei);
        }
        return clone.get(node);
    }
}
