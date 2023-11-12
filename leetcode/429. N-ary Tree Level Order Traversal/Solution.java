// Using bfs
// t.c.=O(n), s.c.=O(n)
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            while(len-->0) {
                Node curr = queue.poll();
                level.add(curr.val);
                for(Node child:curr.children)
                    queue.offer(child);
            }
            res.add(level);
        }
        return res;
    }
}

// Using recursion
// t.c.=O(n), s.c.=O(n)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root!=null)
            traverse(root, 0);
        return res;
    }
    public void traverse(Node node, int level) {
        if(res.size()<=level)
            res.add(new ArrayList<>());
        res.get(level).add(node.val);
        for(Node child:node.children)
            traverse(child, level+1);
    }
}
